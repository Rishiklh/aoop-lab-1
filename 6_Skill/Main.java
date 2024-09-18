import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 30, 50000.0));
        employees.add(new Employee("Jane Doe", 25, 60000.0));
        employees.add(new Employee("Bob Smith", 40, 70000.0));

        System.out.println("Original List:");
        printEmployees(employees);

        Collections.sort(employees);
        System.out.println("\nSorted by Age:");
        printEmployees(employees);

        Collections.sort(employees, new SalaryComparator());
        System.out.println("\nSorted by Salary:");
        printEmployees(employees);

        Employee clonedEmployee = (Employee) employees.get(0).clone();
        System.out.println("\nCloned Employee:");
        System.out.println(clonedEmployee);

        System.out.println("\nIterating over Employees:");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
