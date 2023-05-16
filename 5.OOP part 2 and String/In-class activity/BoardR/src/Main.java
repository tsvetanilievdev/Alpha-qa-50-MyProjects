import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        item.advanceStatus();
        BoardItem anotherItem = new BoardItem("Encrypt user data", LocalDate.now().plusDays(10));

        Board.items.add(item);
        Board.items.add(anotherItem);

        Board.items.add(item);
        Board.items.add(anotherItem);

        for (BoardItem boardItem : Board.items) {
            boardItem.advanceStatus();
        }

        for (BoardItem boardItem : Board.items) {
            System.out.println(boardItem.viewInfo());
        }
    }
}
