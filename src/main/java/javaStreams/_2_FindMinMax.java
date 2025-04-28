package javaStreams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class _2_FindMinMax {

    public static void main(String[] args) {
        // find min max
        //findMinMax();
        findMinMax2();
        //findMinMax3();
        //findMinMax4();
    }

    private static void findMinMax() {
        List<Integer> nums = List.of(5, 1, 9, 3, 7);
        System.out.printf(" Inputs : %s", nums);
        // Optional because list could be empty.
        Optional<Integer> min = nums.stream().min(Integer::compareTo);
        Optional<Integer> max = nums.stream().max(Integer::compareTo);

        min.ifPresent(m -> System.out.printf("\nMinimum : %d", m));
        max.ifPresent(m -> System.out.printf("\nMaximum : %d", m));
    }

    private static void findMinMax2() {
        List<Employee> employees = List.of(
                new Employee("Superman", 5000),
                new Employee("Batman", 10000),
                new Employee("Spiderman", 3000)
        );

        employees.stream().forEach(employee -> System.out.printf("\n %s", employee.toString()));
        Optional<Employee> min = employees.stream().min((emp1, emp2) -> Integer.compare(emp1.salary(), emp2.salary()));
        Optional<Employee> max = employees.stream().max((emp1, emp2) -> Integer.compare(emp1.salary(), emp2.salary()));

        min.ifPresent(m -> System.out.printf("\nMinimum : %d", m.salary()));
        max.ifPresent(m -> System.out.printf("\nMaximum : %d", m.salary()));

    }

    private static void findMinMax3() {
        List<Employee> employees = List.of(
                new Employee("Superman", 5000),
                new Employee("Batman", 10000),
                new Employee("Spiderman", 3000)
        );

        employees.stream().forEach(employee -> System.out.printf("\n %s", employee.toString()));
        Optional<Employee> min = employees.stream().min(Comparator.comparing(Employee::salary));
        Optional<Employee> max = employees.stream().max(Comparator.comparing(Employee::salary));

        min.ifPresent(m -> System.out.printf("\nMinimum : %d", m.salary()));
        max.ifPresent(m -> System.out.printf("\nMaximum : %d", m.salary()));
    }

    private static void findMinMax4() {

        List<Integer> nums = List.of(5, 1, 9, 3, 7);
        System.out.printf(" Inputs : %s", nums);

        Optional<Integer> min = nums.stream().reduce((a, b) -> a < b ? a : b);
        Optional<Integer> max = nums.stream().reduce((a, b) -> a < b ? b : a);

        min.ifPresent(m -> System.out.printf("\nMinimum : %d", m));
        max.ifPresent(m -> System.out.printf("\nMaximum : %d", m));
    }
}

