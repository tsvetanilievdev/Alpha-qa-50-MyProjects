import java.time.LocalDate;
import java.util.ArrayList;

public class BoardItem {
    public static final int BOARD_ITEM_MIN_LENGTH = 5;
    public static final int BOARD_ITEM_MAX_LENGTH = 30;
    public static final String TITLE_ERROR = String.format("%s length must be between %d and %d characters long!", "Title", BOARD_ITEM_MIN_LENGTH, BOARD_ITEM_MAX_LENGTH);
    public static final String DATE_ERROR = "The date should never be in the past";

    private String title;
    private LocalDate dueDate;
    private Status status;
    Status[] statusArrayList;
    public BoardItem(String title, LocalDate dueDate){
        setTitle(title);
        setDueDate(dueDate);
        this.status = Status.Open;

        this.statusArrayList = Status.values();
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
        this.title = title;
    }

    private void setDueDate(LocalDate dueDate){
        if(!LocalDate.now().isBefore(dueDate)){
            throw new IllegalArgumentException(DATE_ERROR);
        }
        this.dueDate = dueDate;
    }

    public void revertStatus(){
        int currOrdinal = this.status.ordinal();
        int prevOrdinal = Math.max(currOrdinal - 1, 0);
        this.status = this.statusArrayList[prevOrdinal];
    }

    public void advanceStatus(){
        int currOrdinal = this.status.ordinal();
        int nextOrdinal = Math.min(currOrdinal + 1, this.statusArrayList.length - 1);
        this.status = this.statusArrayList[nextOrdinal];
    }

    public String viewInfo(){
        return String.format("%s, [%s | %s]", this.title, this.status, this.dueDate);
    }
}
