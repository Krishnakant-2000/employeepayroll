import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

     public abstract double calculateSalary();

    @Override
    public  String toString(){
        return  "Employee name = " + name + " id = " + id + " Salary = " + calculateSalary();
    }


}
class fullTimeEmployee extends Employee{
    double monthlySalary;
    public fullTimeEmployee(String name,int id,double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
class partTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    private int daysWorked;

    public partTimeEmployee(String name, int id, int hoursWorked , double hourlyRate, int daysWorked) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.daysWorked = daysWorked;

    }

    @Override
    public double calculateSalary() {
        return (hoursWorked*hourlyRate)*daysWorked;
    }


}

class payRollSystem{
    private ArrayList<Employee>  employeeList;

    public payRollSystem(){
        employeeList = new ArrayList<>();

    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);

    }
    public void removeEmployee(int id){
        Employee employeeToRemove =null;
        for(Employee employee:employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee :employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
payRollSystem payRollSystem  = new payRollSystem();
fullTimeEmployee emp1 = new fullTimeEmployee("vivek" ,  1, 50000);
partTimeEmployee emp2 = new partTimeEmployee("aman", 2, 80,90,22);
payRollSystem.addEmployee(emp1);
payRollSystem.addEmployee(emp2);
        System.out.println("intial employee details : " );
        payRollSystem.displayEmployees();
        System.out.println("removing employee :" );
        payRollSystem.removeEmployee(2);
        System.out.println("Remaining employee details :");
        payRollSystem.displayEmployees();


    }
}