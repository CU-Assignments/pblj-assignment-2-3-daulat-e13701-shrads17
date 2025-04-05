import java.util.*;
import java.util.stream.Collectors;
class Student {
    String name;
    double marks;
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}
public class FilterStudentUsingLambdaExpressions{
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Anna", 85.5),
                new Student("Robert", 72.3),
                new Student("Percy", 90.1),
                new Student("David", 65.0),
                new Student("Lily", 78.8)
        );
        List<String> topStudents = students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .map(s -> s.name)
                .collect(Collectors.toList());
        System.out.println("Students scoring above 75% (Sorted by marks):");
        topStudents.forEach(System.out::println);
    }
}