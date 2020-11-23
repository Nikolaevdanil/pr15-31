package pr22.Deux.Student;


public class Student {

    private int IDNumber;
    private String name;
    private int age;
    private double[] points;
    private double gpa;

    public Student(int IDNumber, String name, int age) {
        this.IDNumber = IDNumber;
        this.name = name;
        this.age = age;
    }

    public Student(int IDNumber, String name, int age, double[] points) {
        this.IDNumber = IDNumber;
        this.name = name;
        this.age = age;
        this.points = points;
        if (points != null && points.length > 0) {
            for (double point : points) {
                this.gpa += point;
            }
            this.gpa /= points.length;
        }
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double[] getPoints() {
        return points;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "IDNumber=" + IDNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }
}
