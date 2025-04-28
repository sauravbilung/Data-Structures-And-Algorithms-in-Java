package javaStreams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class _10_SummaryStatistics {

    public static void main(String[] args) {
        //summaryStatisticsWithIntegers();
        summaryStatisticsForCustomObjects();
    }

    private static void summaryStatisticsWithIntegers() {
        List<Integer> numbers = List.of(3, 5, 7, 2, 8);

        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(n -> n));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }

    private static void summaryStatisticsForCustomObjects() {
        List<Employee> employees = List.of(
                new Employee("Alice", 5000),
                new Employee("Bob", 7000),
                new Employee("Charlie", 6000)
        );

        IntSummaryStatistics salaryStats = employees.stream()
                .collect(Collectors.summarizingInt(Employee::salary));

        System.out.println("Total Employees: " + salaryStats.getCount());
        System.out.println("Total Salary: " + salaryStats.getSum());
        System.out.println("Minimum Salary: " + salaryStats.getMin());
        System.out.println("Maximum Salary: " + salaryStats.getMax());
        System.out.println("Average Salary: " + salaryStats.getAverage());

    }
}

/*
* 📚 What is Summary Statistics in Java Streams?
✅ If we want to get count, sum, min, max, average together from a numeric stream,
we can use Collectors.summarizingInt, Collectors.summarizingDouble, or Collectors.summarizingLong.

👉 It produces a ready summary object like IntSummaryStatistics.
*
* 🔥 Basic Syntax : .collect(Collectors.summarizingInt(mapper))
*
* mapper → function to extract the number from the object.
* Output type is IntSummaryStatistics, DoubleSummaryStatistics, or LongSummaryStatistics.
*/