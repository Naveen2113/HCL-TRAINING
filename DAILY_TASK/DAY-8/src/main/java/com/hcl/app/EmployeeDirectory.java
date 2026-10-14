
package com.hcl.app;

import com.hcl.model.Employee;

import java.util.*;

public class EmployeeDirectory {

    public static void main(String[] args) {

        // Sample employee data
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee(104, "Arun", "IT", 65000),
            new Employee(101, "Bala", "HR", 45000),
            new Employee(103, "Charan", "IT", 80000),
            new Employee(102, "Deepa", "Finance", 70000),
            new Employee(105, "Ezhil", "HR", 55000),
            new Employee(106, "Farhan", "IT", 90000),
            new Employee(107, "Gita", "Finance", 60000),
            new Employee(108, "Hari", "IT", 75000)
        ));

        // 1. HashMap: employee ID lookup (FR4)
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        System.out.println("===== EMPLOYEE LOOKUP =====");

        int searchId = 103;
        System.out.println("Employee " + searchId + ": "
                + employeeMap.get(searchId));

        System.out.println("Missing employee: "
                + employeeMap.get(999));

        // 2. LinkedHashMap: department frequency
        Map<String, Integer> departmentCount =
                new LinkedHashMap<>();

        for (Employee employee : employees) {
            departmentCount.merge(
                employee.getDepartment(), 1, Integer::sum
            );
        }

        System.out.println("\n===== DEPARTMENT FREQUENCY =====");
        departmentCount.forEach((department, count) ->
            System.out.println(department + ": " + count)
        );

        // 3. TreeMap: sorted department report (FR5)
        Map<String, List<Employee>> departmentReport =
                new TreeMap<>();

        for (Employee employee : employees) {
            departmentReport
                .computeIfAbsent(
                    employee.getDepartment(),
                    key -> new ArrayList<>()
                )
                .add(employee);
        }

        System.out.println("\n===== DEPARTMENT REPORT =====");

        departmentReport.forEach((department, members) -> {
            System.out.println(department + ":");

            members.stream()
                .sorted()
                .forEach(System.out::println);
        });

        // 4. Comparable: natural ordering by employee ID
        System.out.println("\n===== SORTED BY EMPLOYEE ID =====");

        Collections.sort(employees);
        employees.forEach(System.out::println);

        // 5. Comparator #1: salary descending,
        // then name ascending (FR6)
        Comparator<Employee> salaryComparator =
                Comparator.comparingDouble(Employee::getSalary)
                    .reversed()
                    .thenComparing(Employee::getName);

        System.out.println("\n===== TOP 5 SALARIES =====");

        employees.stream()
            .sorted(salaryComparator)
            .limit(5)
            .forEach(System.out::println);

        // 6. Comparator #2: department, then salary
        Comparator<Employee> departmentComparator =
                Comparator.comparing(Employee::getDepartment)
                    .thenComparing(
                        Comparator.comparingDouble(
                            Employee::getSalary
                        ).reversed()
                    );

        System.out.println("\n===== DEPARTMENT AND SALARY =====");

        employees.stream()
            .sorted(departmentComparator)
            .forEach(System.out::println);

        // 7. equals() and hashCode() contract
        System.out.println("\n===== EQUALS AND HASHCODE =====");

        Employee first =
                new Employee(201, "Kumar", "IT", 50000);

        Employee second =
                new Employee(201, "Kumar Updated", "HR", 60000);

        System.out.println("first.equals(second): "
                + first.equals(second));

        System.out.println("Same hash code: "
                + (first.hashCode() == second.hashCode()));

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(first);
        employeeSet.add(second);

        System.out.println("HashSet size: "
                + employeeSet.size());

        // 8. Demonstrate missing hashCode() bug
        System.out.println("\n===== MISSING HASHCODE BUG =====");

        BugEmployee bug1 = new BugEmployee(301);
        BugEmployee bug2 = new BugEmployee(301);

        Set<BugEmployee> buggySet = new HashSet<>();
        buggySet.add(bug1);
        buggySet.add(bug2);

        System.out.println("bug1.equals(bug2): "
                + bug1.equals(bug2));

        System.out.println("Buggy HashSet size: "
                + buggySet.size());

        // Fix: use Employee with both methods implemented
        Set<Employee> fixedSet = new HashSet<>();
        fixedSet.add(new Employee(301, "Test", "IT", 40000));
        fixedSet.add(new Employee(301, "Test", "IT", 40000));

        System.out.println("Fixed HashSet size: "
                + fixedSet.size());
    }

    // Deliberately incorrect class for demonstration
    static class BugEmployee {
        private final int id;

        BugEmployee(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof BugEmployee other)) {
                return false;
            }

            return this.id == other.id;
        }

        // Intentionally missing hashCode()
    }
}
