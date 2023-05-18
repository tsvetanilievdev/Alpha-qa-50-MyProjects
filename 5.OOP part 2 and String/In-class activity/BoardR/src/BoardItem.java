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
    private Status[] statusArrayList;
    private static ArrayList<EventLog> eventLogArrayList;

    public BoardItem(String title, LocalDate dueDate){
        this.status = Status.Open;
        this.statusArrayList = Status.values();
        this.eventLogArrayList = new ArrayList<>();
        EventLog firstLog = new EventLog(String.format("Item created: '%s', [%s | %s]", title, status, dueDate));
        eventLogArrayList.add(firstLog);

        setTitle(title);
        setDueDate(dueDate);


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
        if(title.length() < BOARD_ITEM_MIN_LENGTH || title.length() > BOARD_ITEM_MAX_LENGTH) {
            throw new IllegalArgumentException(TITLE_ERROR);
        }
        if(this.title != null){
            String lastTitle = this.title;
            EventLog log = new EventLog(String.format("Title changed from %s to %s", lastTitle, title));
            eventLogArrayList.add(log);
        }

        this.title = title;
    }

    public void setDueDate(LocalDate dueDate){
        if(!LocalDate.now().isBefore(dueDate)){
            throw new IllegalArgumentException(DATE_ERROR);
        }
        if(this.dueDate != null){
            LocalDate lastDueDate = this.dueDate;
            EventLog log = new EventLog(String.format("DueDate changed from %s to %s", lastDueDate, dueDate));
            eventLogArrayList.add(log);
        }
        this.dueDate = dueDate;
    }

    public void revertStatus(){
        int currOrdinal = this.status.ordinal();
        int prevOrdinal = Math.max(currOrdinal - 1, 0);
        this.status = this.statusArrayList[prevOrdinal];
        if(currOrdinal == 0){
            EventLog log = new EventLog("Can't revert, already at Open");
            eventLogArrayList.add(log);
        }else {
            EventLog log = new EventLog(String.format("Status changed from %s to %s",
                    this.statusArrayList[currOrdinal], this.statusArrayList[prevOrdinal]));
            eventLogArrayList.add(log);
        }
    }

    public void advanceStatus(){
        int currOrdinal = this.status.ordinal();
        int nextOrdinal = Math.min(currOrdinal + 1, this.statusArrayList.length - 1);
        this.status = this.statusArrayList[nextOrdinal];

        if(currOrdinal == this.statusArrayList.length - 1){
            EventLog log = new EventLog("Can't advance, already at Verified");
            eventLogArrayList.add(log);
        }else {
            EventLog log = new EventLog(String.format("Status changed from %s to %s",
                    this.statusArrayList[currOrdinal], this.statusArrayList[nextOrdinal]));
            eventLogArrayList.add(log);
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

    private void createFirstLog(){
        EventLog log = new EventLog();
    }
    private void createLogBoardItemConstructed(String title){
        EventLog log = new EventLog();
        eventLogArrayList.add(log);
    }
}
