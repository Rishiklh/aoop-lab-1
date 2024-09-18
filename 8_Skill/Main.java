import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25, 50000),
                new Employee("Alice", 30, 60000),
                new Employee("Bob", 35, 70000),
                new Employee("Charlie", 20, 40000),
                new Employee("David", 40, 80000),
                new Employee("Eve", 28, 55000),
                new Employee("Frank", 32, 65000),
                new Employee("George", 38, 75000),
                new Employee("Hannah", 22, 45000),
                new Employee("Ivan", 42, 85000)
        );

        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println("Employees older than 30:");
        filteredEmployees.forEach(System.out::println);

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("\nEmployees sorted by salary in descending order:");
        sortedEmployees.forEach(System.out::println);

        Employee highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
        System.out.println("\nEmployee with the highest salary:");
        System.out.println(highestPaidEmployee);

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println("\nAverage salary of employees:");
        System.out.println(averageSalary);
    }
}
