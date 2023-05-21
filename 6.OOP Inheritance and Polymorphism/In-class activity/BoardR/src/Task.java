import java.time.LocalDate;

public class Task extends BoardItem {
    public static final int MIN_ASSIGNEE_LENGTH = 5;
    public static final int MAX_ASSIGNEE_LENGTH = 30;
    private String assignee;

    public Task(String title, String assignee, LocalDate localDate) {
        super(title, localDate);
        super.status = initialStatus();
        validateAssignee(assignee);
        this.assignee = assignee;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.eventLogArrayList.add(new EventLog(String.format("Assignee changed from %s to %s",
                this.assignee, assignee)));
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

    @Override
    public Status initialStatus() {
        return Status.ToDo;
    }
}
