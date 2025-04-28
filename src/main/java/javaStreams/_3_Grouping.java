package javaStreams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _3_Grouping {

    public static void main(String[] args) {
        // Group by first character
        //groupByFirstCharacter();

        List<Employee2> employees = List.of(
                new Employee2("Alice", "HR"),
                new Employee2("Bob", "IT"),
                new Employee2("Charlie", "HR"),
                new Employee2("David", "Finance")
        );
        // Group employees by department
        //groupEmployeesByDepartment(employees);
        //groupEmployeesByDepartment2(employees);

        // Count employees by department
        //countEmployeesInDept(employees);

        // Group by department and city
        groupByDeptAndCity();
    }

    /*
        Collectors.groupingBy always returns a Map. We can customize:
        Key (with classifier function)
        Value (with downstream collector)
        Map Type (optional third param)
     */

    private static void groupByFirstCharacter() {
        List<String> names = List.of("Ram", "Ravi", "Mohan", "Rajesh", "Mira");
        System.out.printf("Given names : %s", names);
        /*
        groupingBy(
                classifierFunction,
                toList() // default collector if not specified
        )*/
        Map<Character, List<String>> groupedByFirstChar = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.printf("\nGrouped by first character : %s", groupedByFirstChar);
    }

    private static void groupEmployeesByDepartment(List<Employee2> employees) {
        // ✅ When groupingBy directly, we collect full objects into the list.
        Map<String, List<Employee2>> employeesByDept = employees.stream().collect(Collectors.groupingBy(Employee2::dept));

        employeesByDept.forEach((dept, emps) -> {
            System.out.println(dept + " -> " + emps.stream().map(Employee2::name).collect(Collectors.toList()));
        });
    }

    private static void groupEmployeesByDepartment2(List<Employee2> employees) {

        // ✅ If we want only a part (like just name, or salary, or id), we must use mapping() inside groupingBy().
        /*
        Collectors.mapping() params :
        First param: What to extract or convert from each element.
        Second param: Where to collect the extracted things.
         */
        Map<String, List<String>> employeesByDept = employees.stream().
                collect(
                        Collectors.groupingBy(
                                Employee2::dept, // use accessor method
                                Collectors.mapping(Employee2::name, Collectors.toList() //map employee2 -> name
                                )
                        )
                );

        employeesByDept.forEach((dept, emps) -> System.out.println(dept + " -> " + emps));
    }

    private static void countEmployeesInDept(List<Employee2> employees) {
        Map<String, Long> countByDept = employees.stream().collect(Collectors.groupingBy(Employee2::dept, Collectors.counting()));
        System.out.println(countByDept);
    }

    private static void groupByDeptAndCity() {
        List<Employee3> employees = List.of(
                new Employee3("Alice", "HR", "New York"),
                new Employee3("Bob", "IT", "San Francisco"),
                new Employee3("Charlie", "HR", "New York"),
                new Employee3("David", "Finance", "Chicago"),
                new Employee3("Eve", "IT", "San Francisco")
        );

        Map<String, Map<String, List<String>>> grouped = employees.stream().collect(
                Collectors.groupingBy(Employee3::dept, Collectors.groupingBy(Employee3::city, Collectors.mapping(Employee3::name, Collectors.toList())))
        );

        for (Map.Entry<String, Map<String, List<String>>> entry : grouped.entrySet()) {
            System.out.println(entry);
        }
    }
}

/*
Key points to remember :
Concept                    |      Example
Basic Grouping             | .groupingBy(keyExtractor)
Grouping + Counting        | .groupingBy(keyExtractor, counting())
Grouping + Mapping         | .groupingBy(keyExtractor, mapping(valueExtractor, toList()))
Multi-level Grouping       | .groupingBy(key1, groupingBy(key2))
 */