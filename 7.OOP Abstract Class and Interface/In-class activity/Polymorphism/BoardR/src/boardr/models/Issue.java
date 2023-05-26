package boardr.models;

import boardr.enums.Status;

import java.time.LocalDate;

public class Issue extends BoardItem{
    private String description;

    public Issue(String title, String description, LocalDate localDate){
        super(title,localDate, Status.Open);
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        if(description == null || description.isEmpty()){
            this.description =  "No description";
        }else {
            this.description = description;
        }
    }

    @Override
    public String viewInfo(){
        return String.format("boardr.models.Task: %s, Description: %s", super.viewInfo(),getDescription());
    }
    protected void revertStatus() {
        if (super.getStatus() == Status.Open) {
            eventLogArrayList.add(new EventLog("boardr.models.Issue status already Open"));
        } else {
            super.setStatus(Status.Open);
            eventLogArrayList.add(new EventLog("boardr.models.Issue status set to Open"));
        }
    }
    protected void advanceStatus() {
        if (super.getStatus() == Status.Verified) {
            eventLogArrayList.add(new EventLog("boardr.models.Issue status already Verified"));
        } else {
            super.setStatus(Status.Verified);
            eventLogArrayList.add(new EventLog("boardr.models.Issue status set to Verified"));
        }
    }

}
