package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

public class _12_NestedStreamProcessing {

    public static void main(String[] args) {
        //listAllEmployeesFromAllDepartments();
        listAllEmployeesFromAllDepartmentsWhoseNameStartsWithC();
    }

    private static void listAllEmployeesFromAllDepartments() {
        List<Department> departments = List.of(
                new Department("HR", List.of(new Employee("Alice", 4000), new Employee("Bob", 5000))),
                new Department("IT", List.of(new Employee("Charlie", 6000), new Employee("David", 7000)))
        );

        List<String> employeeNames = departments.stream()
                .flatMap(dept -> dept.employees().stream()) // flatten employees
                .map(Employee::name)                     // get names
                .collect(Collectors.toList());

        System.out.println(employeeNames);
    }

    private static void listAllEmployeesFromAllDepartmentsWhoseNameStartsWithC() {
        List<Department> departments = List.of(
                new Department("HR", List.of(new Employee("Alice", 4000), new Employee("Bob", 5000))),
                new Department("IT", List.of(new Employee("Charlie", 6000), new Employee("David", 7000)))
        );

        List<String> employeeNamesStartingWithC = departments.stream()
                .flatMap(dept -> dept.employees().stream())
                .map(Employee::name)
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toList());

        System.out.println(employeeNamesStartingWithC);
    }
}
