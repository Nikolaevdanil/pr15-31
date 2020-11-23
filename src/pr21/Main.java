package pr21;


public class Main {

    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();
        try {
            demo.run();
            System.out.println("Line that will not print!");
        } catch (Exception e) {
            System.out.println("Caught arithmetic exception!");
        } finally {
            System.out.println("Finally block!");
        }
    }

}