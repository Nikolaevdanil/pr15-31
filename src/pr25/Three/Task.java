package pr25.Three;


import java.time.Duration;
import java.util.Date;

public class Task {

    private String assignee;
    private Date completeDate;
    private Date startDate;

    public Task(String assignee, Date completeDate) {
        this.assignee = assignee;
        this.completeDate = completeDate;
        this.startDate = new Date();
    }

    public String getAssignee() {
        return assignee;
    }

    public Duration durationTillDeadline() {
        return Duration.between(startDate.toInstant(), completeDate.toInstant());
    }

}
