package javaStreams;

import java.util.Comparator;
import java.util.List;

public class _6_CustomSorting {

    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 2, 8, 1, 3);
        //basicNaturalSorting(nums);
        //customSorting(nums);
        //sortBySalaryAscending();
        //sortBySalaryDescending();
        sortBySalaryAndName();
    }

    private static void basicNaturalSorting(List<Integer> nums) {
        nums.stream().sorted().forEach(System.out::println);
    }

    private static void customSorting(List<Integer> nums) {
        nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void sortBySalaryAscending() {
        List<Employee> employees = List.of(
                new Employee("Alice", 6000),
                new Employee("Bob", 4000),
                new Employee("Charlie", 7000)
        );

        // or Comparator.comparing(emp -> emp.salary())
        employees.stream().sorted(Comparator.comparing(Employee::salary)).forEach(System.out::println);
    }

    private static void sortBySalaryDescending() {
        List<Employee> employees = List.of(
                new Employee("Alice", 6000),
                new Employee("Bob", 4000),
                new Employee("Charlie", 7000)
        );

        employees.stream().sorted(Comparator.comparing(Employee::salary).reversed()).forEach(System.out::println);
    }

    private static void sortBySalaryAndName() {
        List<Employee> employees = List.of(
                new Employee("Alice", 6000),
                new Employee("Jerry", 6000),
                new Employee("Bob", 4000),
                new Employee("Charlie", 7000),
                new Employee("Daisy", 4000),
                new Employee("Alan", 7000)
        );

        employees.stream().sorted(Comparator.comparing(Employee::salary).thenComparing(Employee::name)).forEach(System.out::println);
    }
}
