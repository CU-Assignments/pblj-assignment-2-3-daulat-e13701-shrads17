import java.util.*;
class Employee {
    String name;
    int age;
    double salary;
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public void display() {
        System.out.println(name + " | Age: " + age + " | Salary: " + salary);
    }
}
public class SortEmployeesUsingLambdaExpression{
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Anna", 30, 50000));
        employees.add(new Employee("Robert", 25, 60000));
        employees.add(new Employee("Lily", 35, 55000));
        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Sorted by Name:");
        employees.forEach(Employee::display);
        employees.sort((e1, e2) -> Integer.compare(e1.age, e2.age));
        System.out.println("\nSorted by Age:");
        employees.forEach(Employee::display);
        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));
        System.out.println("\nSorted by Salary:");
        employees.forEach(Employee::display);
    }
}