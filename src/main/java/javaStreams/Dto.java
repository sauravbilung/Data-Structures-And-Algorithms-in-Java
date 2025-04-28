package javaStreams;

import java.util.List;

record Employee(String name, int salary){}

record Employee2(String name, String dept){}

record Employee3(String name, String dept, String city){}

record Department(String deptName, List<Employee> employees){}
