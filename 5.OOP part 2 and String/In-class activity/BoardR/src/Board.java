import java.util.ArrayList;

public class Board {
    private static ArrayList<BoardItem> items = new ArrayList<>();

    public Board(){
    }

    public void addItem(BoardItem item){
        if(items.contains(item)){
            throw new IllegalArgumentException("Item already in the list!");
        }
        items.add(item);
    }

    public int totalItems(){
        return items.size();
    }
}
