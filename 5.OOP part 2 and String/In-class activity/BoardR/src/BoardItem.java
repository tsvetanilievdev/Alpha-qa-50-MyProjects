import java.time.LocalDate;
import java.util.ArrayList;

public class BoardItem {
    String title;
    LocalDate dueDate;
    Status status;
    Status[] statusArrayList;
    public BoardItem(String title, LocalDate dueDate){

        if(title.length() >= 5 && title.length() <= 30){
            this.title = title;
        }else {
            throw new Error("Title length must be between 5 and 30 characters long!");
        }

        if(LocalDate.now().isBefore(dueDate)){
            this.dueDate = dueDate;
        }else {
            throw new Error("The date should never be in the past");
        }

        this.status = Status.Open;

        this.statusArrayList = Status.values();
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
