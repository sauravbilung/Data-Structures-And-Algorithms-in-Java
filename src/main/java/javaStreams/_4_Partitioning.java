package javaStreams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class _4_Partitioning {

    public static void main(String[] args) {
        // partition odd even numbers
        //evenOddPartitioning();

        List<Employee> employees = List.of(
                new Employee("Alice", 4000),
                new Employee("Bob", 6000),
                new Employee("Charlie", 7000)
        );
        // partition employee by salary
        partitionBySalary(employees);

        // count employees greater and less than a fixed salary number
        //partitionCount(employees);
    }

    private static void evenOddPartitioning() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitions = nums.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

        for (Map.Entry<Boolean, List<Integer>> partition : partitions.entrySet()) {
            System.out.println(partition);
        }
    }

    private static void partitionBySalary(List<Employee> employees) {

        Map<Boolean, List<Employee>> partitions = employees.stream().collect(Collectors.partitioningBy(emp -> emp.salary() > 5000));
        //Map<Boolean, List<String>> partitions = employees.stream().collect(Collectors.partitioningBy(emp -> emp.salary() > 5000, Collectors.mapping(Employee::name, toList())));

        /*for (Map.Entry<Boolean, List<Employee>> partition : partitions.entrySet()) {
            System.out.println(partition);
        }*/
        // cleaner way :
        partitions.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void partitionCount(List<Employee> employees) {
        Map<Boolean, Long> partitions = employees.stream().collect(Collectors.partitioningBy(emp -> emp.salary() > 5000, Collectors.counting()));
        System.out.println(partitions);
    }
}

/*
 * 📚 Partitioning in Java Streams
 *
 * Partitioning means splitting the data into exactly two groups based on a boolean condition (true or false).
 * ✅ It is done using : Collectors.partitioningBy(predicate)
 *
 * Map<Boolean, List<T>>
 * true → list of elements satisfying the condition
 * false → list of elements not satisfying it
 */