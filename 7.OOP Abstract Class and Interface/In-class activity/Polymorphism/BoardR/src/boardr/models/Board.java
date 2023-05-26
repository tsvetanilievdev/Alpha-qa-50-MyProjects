package boardr.models;

import boardr.loggers.Logger;

import java.util.ArrayList;

public class Board {
    private final ArrayList<BoardItem> items;
    public Board(){
        items = new ArrayList<>();
    }

    public void addItem(BoardItem item){
        if(items.contains(item)){
            throw new IllegalArgumentException("Item already in the list!");
        }
        items.add(item);
    }

    public void displayHistory(Logger logger){
        for (BoardItem item:items) {
            logger.log(item.getHistory());
        }
    }

    public int totalItems(){
        return items.size();
    }
}
