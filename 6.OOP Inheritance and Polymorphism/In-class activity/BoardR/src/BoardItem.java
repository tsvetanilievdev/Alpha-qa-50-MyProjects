import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BoardItem {
    public static final int BOARD_ITEM_MIN_LENGTH = 5;
    public static final int BOARD_ITEM_MAX_LENGTH = 30;
    public static final String TITLE_ERROR = String.format("%s length must be between %d and %d characters long!", "Title", BOARD_ITEM_MIN_LENGTH, BOARD_ITEM_MAX_LENGTH);
    public static final String DATE_ERROR = "The date should never be in the past";

    private String title;
    private LocalDate dueDate;
    private Status status;
    private static ArrayList<EventLog> eventLogArrayList;

    public BoardItem(String title, LocalDate dueDate){
        validateTitle(title);
        validateDueDate(dueDate);
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.Open;
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

    public void setTitle(String title) {
        validateTitle(title);
        eventLogArrayList.add(new EventLog(String.format("Title changed from %s to %s", this.title, title)));
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate){
        validateDueDate(dueDate);
        eventLogArrayList.add(new EventLog(String.format("DueDate changed from %s to %s", this.dueDate, dueDate)));
        this.dueDate = dueDate;
    }

    public void revertStatus(){
        if(this.status == Status.values()[0]){
            eventLogArrayList.add(new EventLog("Can't revert, already at Open"));
        }else {
            this.status = Status.values()[this.status.ordinal() - 1];
            eventLogArrayList.add(new EventLog(String.format("Status changed from %s to %s",
                    Status.values()[status.ordinal() + 1], this.status)));
        }
    }

    public void advanceStatus(){
        if(this.status.ordinal() == Status.values().length - 1){
            eventLogArrayList.add(new EventLog("Can't advance, already at Verified"));
        }else {
            this.status = Status.values()[this.status.ordinal() + 1];
            eventLogArrayList.add(new EventLog(String.format("Status changed from %s to %s",
                    Status.values()[status.ordinal() - 1], this.status)));
        }
    }

    public void displayHistory(){
        for (EventLog log: eventLogArrayList) {
            System.out.println(log.viewInfo());
        }
    }
    public String viewInfo(){
        return String.format("%s, [%s | %s]", this.title, this.status, this.dueDate);
    }

    private static void validateTitle(String title) {
        if(title.length() < BOARD_ITEM_MIN_LENGTH || title.length() > BOARD_ITEM_MAX_LENGTH) {
            throw new IllegalArgumentException(TITLE_ERROR);
        }
    }
    private static void validateDueDate(LocalDate dueDate) {
        if(!LocalDate.now().isBefore(dueDate)){
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }
}
