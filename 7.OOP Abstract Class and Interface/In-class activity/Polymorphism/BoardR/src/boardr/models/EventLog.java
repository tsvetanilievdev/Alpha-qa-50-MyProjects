package boardr.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EventLog {
    private final String description;
    private final LocalDateTime timestamp;

    public EventLog() {
        throw new IllegalArgumentException("Description should not be empty!");
    }

    public EventLog(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description should not be empty!");
        }
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return timestamp;
    }

    public String viewInfo() {
        return String.format("[%s] %s", timestamp.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss", Locale.ENGLISH)), description);
    }

}
