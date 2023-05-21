import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Issue issue = new Issue("App flow tests?", "", tomorrow);
        Task task = new Task("Test the application flow", "Pesho", tomorrow);

        Board board = new Board();

        board.addItem(issue);
        board.addItem(task);
        System.out.println(board.totalItems()); // 2
    }
}
