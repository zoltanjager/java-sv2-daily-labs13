package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    void testAddStudent() {
        ClassNotebook classNotebook = new ClassNotebook();
        Student student = new Student(1, "John Doe");

        classNotebook.addStudent(student);
        assertTrue(classNotebook.getNotebook().keySet().contains(student));
        assertEquals(0, classNotebook.getNotebook().get(student).size());
    }

    @Test
    void testAddStudentInOrder(){

    ClassNotebook classNotebook = new ClassNotebook();

    Student s = new Student(1,"John");
    Student s2 = new Student(3,"John");
    Student s3 = new Student(2,"John");
        classNotebook.addStudent(s);
        classNotebook.addStudent(s2);
        classNotebook.addStudent(s3);

    assertEquals(List.of(s, s3, s2), new ArrayList<>(classNotebook.getNotebook().keySet()));

    int i=1;
        for(Map.Entry<Student, List<Integer>> actual : classNotebook.getNotebook().entrySet()){
        assertEquals(i, actual.getKey().getStudentId());
        i++;
    }
}

    @Test
    void testAddMark(){
        ClassNotebook classNotebook = new ClassNotebook();

        Student s = new Student(1,"John");
        Student s2 = new Student(3,"John");
        Student s3 = new Student(2,"John");
        classNotebook.addStudent(s);
        classNotebook.addStudent(s2);
        classNotebook.addStudent(s3);

        classNotebook.addMark(2,5);

        assertEquals(5,classNotebook.getNotebook().get(s3).get(0));

    }


}