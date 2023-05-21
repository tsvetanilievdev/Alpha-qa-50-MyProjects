import java.time.LocalDate;

public class Issue extends BoardItem{
    private final String description;

    public Issue(String title, String description, LocalDate localDate){
        super(title,localDate);
        this.description = checkDescription(description);
    }

    private String checkDescription(String description) {
        if(description.isEmpty() || description == null){
            return "No description";
        }
        return description;
    }
}
