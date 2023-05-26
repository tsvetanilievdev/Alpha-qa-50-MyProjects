package boardr.models;

import boardr.enums.Status;

import java.time.LocalDate;

public class Task extends BoardItem {
    public static final int MIN_ASSIGNEE_LENGTH = 5;
    public static final int MAX_ASSIGNEE_LENGTH = 30;
    private String assignee;

    public Task(String title, String assignee, LocalDate localDate) {
        super(title, localDate, Status.ToDo);
        validateAssignee(assignee);
        this.assignee = assignee;
    }

    @Override
    public String viewInfo(){
        return String.format("boardr.models.Task: %s, Assignee: %s", super.viewInfo(), getAssignee());
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.eventLogArrayList.add(new EventLog(String.format("Assignee changed from %s to %s",
                this.assignee, assignee)));
    }

    public void revertStatus() {
        if (super.getStatus().ordinal() == 1) {
            eventLogArrayList.add(new EventLog("Can't revert, already at To Do"));
        } else {
            super.setStatus(Status.values()[super.getStatus().ordinal() - 1]);
            eventLogArrayList.add(new EventLog(String.format("boardr.models.Task status changed from %s to %s",
                    Status.values()[super.getStatus().ordinal() + 1].toString(), super.getStatus().toString())));
        }
    }

    public void advanceStatus() {
        if (super.getStatus().ordinal() == Status.values().length - 1) {
            eventLogArrayList.add(new EventLog("Can't advance, already at Verified"));
        } else {
            super.setStatus(Status.values()[super.getStatus().ordinal() + 1]);
            eventLogArrayList.add(new EventLog(String.format("boardr.models.Task status changed from %s to %s",
                    Status.values()[super.getStatus().ordinal() - 1].toString(), super.getStatus().toString())));
        }
    }

    private void validateAssignee(String assignee) {
        if (assignee.isEmpty() || assignee == null) {
            throw new IllegalArgumentException("Assignee cannot be empty!");
        } else if (assignee.length() < MIN_ASSIGNEE_LENGTH || assignee.length() > MAX_ASSIGNEE_LENGTH) {
            throw new IllegalArgumentException(String.format("The assignee field must be between %d and %d characters long!",
                    MIN_ASSIGNEE_LENGTH,
                    MAX_ASSIGNEE_LENGTH));
        }
    }

}
