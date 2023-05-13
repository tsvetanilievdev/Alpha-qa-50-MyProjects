import java.util.ArrayList;



public class ForumPost {
    String author;
    String text;
    int upVotes;
    ArrayList<String> replies;

    public ForumPost(String author, String text, int upVotes){
        this.author = author;
        this.text = text;
        this.upVotes = upVotes;
        this.replies = new ArrayList<>();
    }

    public ForumPost(String author, String text){
        this(author, text, 0);
    }

    public StringBuilder format() {
        StringBuilder result = new StringBuilder();

        String message = String.format("%s / by %s, %d votes. %n", this.text, this.author, this.upVotes);

        result.append(message);

        for (int i = 0; i < this.replies.size(); i++) {
            String reply = String.format(" - %s%n", replies.get(i));
            result.append(reply);
        }
        return result;
    }
}
