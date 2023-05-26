package boardr;

import boardr.loggers.ConsoleLogger;
import boardr.models.Board;
import boardr.models.Issue;
import boardr.models.Task;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        boardr.models.BoardItem task = new boardr.models.Task("Write unit tests", "Pesho", tomorrow);
        boardr.models.BoardItem issue = new boardr.models.Issue("Review tests", "Someone must review Pesho's tests.", tomorrow);

        System.out.println(task.viewInfo());
        System.out.println(issue.viewInfo());
    }
}
