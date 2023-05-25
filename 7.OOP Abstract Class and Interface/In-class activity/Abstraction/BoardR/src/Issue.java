import java.time.LocalDate;

public class Issue extends BoardItem{
    private final String description;

    public Issue(String title, String description, LocalDate localDate){
        super(title,localDate, Status.Open);
        this.description = checkDescription(description);
    }


    protected void revertStatus() {
        if (super.getStatus() == Status.Open) {
            eventLogArrayList.add(new EventLog("Issue status already Open"));
        } else {
            super.setStatus(Status.Open);
            eventLogArrayList.add(new EventLog("Issue status set to Open"));
        }
    }
    protected void advanceStatus() {
        if (super.getStatus() == Status.Verified) {
            eventLogArrayList.add(new EventLog("Issue status already Verified"));
        } else {
            super.setStatus(Status.Verified);
            eventLogArrayList.add(new EventLog("Issue status set to Verified"));
        }
    }

    private String checkDescription(String description) {
        if(description.isEmpty() || description == null){
            return "No description";
        }
        return description;
    }
}
