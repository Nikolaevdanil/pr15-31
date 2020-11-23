package pr25.Three;


import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Task task = new Task(
                "Conan O'Brien",
                new Date(System.currentTimeMillis() + 7 * 1000 * 60 * 60 * 24)
        );
        System.out.println(task.getAssignee() + " should complete task in "
                + task.durationTillDeadline().toDays() + " days");
    }

}
