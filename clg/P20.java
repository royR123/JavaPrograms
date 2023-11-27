package clg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class P20 {
 public static void main(String[] args) {
 List<Employee> employees = new ArrayList<>();
 employees.add(new Employee(1, "John", 50000, 30, new Date(2022, 10, 15)));
 employees.add(new Employee(2, "Jack", 60000, 25, new Date(2021, 8, 20)));
 employees.add(new Employee(3, "Bob", 55000, 35, new Date(2020, 5, 10)));
 Collections.sort(employees);
 System.out.println("ID Name Salary Age Joining Date");
 for (Employee emp : employees) {
 System.out.println(emp);
 }
 }
}
class Employee implements Comparable<Employee> {
 private int id;
 private String name;
 private int salary;
 private int age;
 private Date dateOfJoining;
 public Employee(int id, String name, int salary, int age, Date dateOfJoining) {
 this.id = id;
 this.name = name;
 this.salary = salary;
 this.age = age;
 this.dateOfJoining = dateOfJoining;
 }
 public int compareTo(Employee other) {
 int nameComparison = this.name.compareTo(other.name);
 if (nameComparison != 0) {
 return nameComparison;
 }

 int ageComparison = Integer.compare(this.age, other.age);
 if (ageComparison != 0) {
 return ageComparison;
 }

 int salaryComparison = Integer.compare(this.salary, other.salary);
 if (salaryComparison != 0) {
 return salaryComparison;
 }

 return this.dateOfJoining.compareTo(other.dateOfJoining);
 }
 public String toString() {
 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
 return String.format("%-5d %-10s %-5d %-3d %s", id, name, salary, age,
sdf.format(dateOfJoining));
 }
}
