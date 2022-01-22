package day01;

public class Student implements Comparable<Student>{
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return studentId-o.studentId;
    }
}
