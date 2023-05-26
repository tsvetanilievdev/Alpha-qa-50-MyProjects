package boardr.models;

import boardr.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class BoardItem {
    public static final int BOARD_ITEM_MIN_LENGTH = 5;
    public static final int BOARD_ITEM_MAX_LENGTH = 30;
    public static final String TITLE_ERROR = String.format("%s length must be between %d and %d characters long!", "Title", BOARD_ITEM_MIN_LENGTH, BOARD_ITEM_MAX_LENGTH);
    public static final String DATE_ERROR = "The date should never be in the past";

    private String title;
    private LocalDate dueDate;
    protected Status status;
    protected ArrayList<EventLog> eventLogArrayList;

    public BoardItem(String title, LocalDate dueDate, Status status) {
        validateTitle(title);
        validateDueDate(dueDate);
        this.title = title;
        this.dueDate = dueDate;
        setStatus(status);
        this.eventLogArrayList = new ArrayList<>();
        eventLogArrayList.add(new EventLog(String.format("Item created: '%s', [%s | %s]", title, status, dueDate)));
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Status getStatus() {
        return status;
    }

    protected void setStatus(Status status){
        this.status = status;
    }
    protected void setTitle(String title) {
        validateTitle(title);
        eventLogArrayList.add(new EventLog(String.format("Title changed from %s to %s", this.title, title)));
        this.title = title;
    }

    protected void setDueDate(LocalDate dueDate) {
        validateDueDate(dueDate);
        eventLogArrayList.add(new EventLog(String.format("DueDate changed from %s to %s", this.dueDate, dueDate)));
        this.dueDate = dueDate;
    }

    protected abstract void revertStatus();

    protected abstract void advanceStatus();

    public void displayHistory() {
        for (EventLog log : eventLogArrayList) {
            System.out.println(log.viewInfo());
        }
    }

    public String viewInfo() {
        return String.format("%s, [%s | %s]", this.title, this.status, this.dueDate);
    }

    private static void validateTitle(String title) {
        if (title.length() < BOARD_ITEM_MIN_LENGTH || title.length() > BOARD_ITEM_MAX_LENGTH) {
            throw new IllegalArgumentException(TITLE_ERROR);
        }
    }

    private static void validateDueDate(LocalDate dueDate) {
        if (!LocalDate.now().isBefore(dueDate)) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    public String getHistory(){
        StringBuilder builder = new StringBuilder();

        for (EventLog eventLog : eventLogArrayList) {
            builder.append(eventLog.viewInfo()).append(System.lineSeparator());
        }

        return builder.toString();
    }
}
