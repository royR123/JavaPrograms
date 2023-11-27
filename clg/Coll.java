package clg;
import java.util.*;
public class Coll {
    public static void main(String[] args) {
            ArrayList<Employee> lt = new ArrayList<>();
            lt.add(new Employee(19, "Ritik", 2339298.93));
            lt.add(new Employee(28, "Raj", 2322.02));
            lt.add(new Employee(18, "Nandini", 2392238.93));
            lt.add(new Employee(20, "Sumit", 23838.93));
            lt.sort();

    }
}
class Employee{
    int age ;
    String name ;
    double salary;
    Employee(int age , String name , double salary){
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
    
}
