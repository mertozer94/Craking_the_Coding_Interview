package Seventh_Chapter;

import java.util.ArrayList;

/**
 * @author Mert Ozer
 *
 * Imagine you have a call center with three levels of employees: respondent manager,
and director. An incoming telephone call must be first allocated to a respondent who is free. If the
respondent can't handle the call, he or she must escalate the call to a manager. If the manager is not
free or not able to handle it, then the call should be escalated to a director. Design the classes and
data structures for this problem. Implement a method dispatchCall() which assigns a call to
the first available employee.
 */
public class Call_Center_7_2 {
    public static void main(String[] args) throws Exception {
        CallCenter c = CallCenter.getInstance();
        c.addEmploye("Respondant","Mert",0);
        c.addEmploye("Manager","Mert1",1);
        c.addEmploye("Director","Mert2",1);
        c.dispatchCall();
    }
    public static class CallCenter {
        // maybe do smy more smart for employees.
        private ArrayList<Employee> respondants;
        private ArrayList<Employee> managers;
        private ArrayList<Employee> directors;
        private static CallCenter _instance = null;
        public void dispatchCall(){
            for (Employee e:respondants){
                if (e.availabilty == 1){
                    e.availabilty = 0;
                    e.respondToCall();
                    return;
                }
            }
            for (Employee e: managers){
                if (e.availabilty == 1){
                    e.availabilty = 0;
                    e.respondToCall();
                    return;
                }
            }
            for (Employee e: directors){
                if (e.availabilty == 1){
                    e.availabilty = 0;
                    e.respondToCall();
                    return;
                }
            }
        }
        private CallCenter(){
            respondants = new ArrayList<>();
            managers = new ArrayList<>();
            directors = new ArrayList<>();
        }
        private static CallCenter getInstance(){
            if (_instance == null)
                _instance = new CallCenter();
            return _instance;
        }
        private void addEmploye(String type, String name, int availabilty) throws Exception {
            Employee e = EmployeeFactory.createNewEmploye(type, name, availabilty);
            if (type.equalsIgnoreCase("Respondant"))
                respondants.add(e);
            else if (type.equalsIgnoreCase("Manager"))
                managers.add(e);
            else
                directors.add(e);
        }
    }
    public static class Employee {
        private String name;
        private int availabilty;
        public Employee(String name, int availabilty){
            this.name = name;
            this.availabilty = availabilty;
        }
        public void respondToCall(){}
    }
    public static class EmployeeFactory{
        public static Employee createNewEmploye(String type, String name, int availabilty) throws Exception{
            if (type.equalsIgnoreCase("Respondant"))
                return new Respondant(name, availabilty);
            else if (type.equalsIgnoreCase("Manager"))
                return new Manager(name, availabilty);
            else if (type.equalsIgnoreCase("Director"))
                return new Director(name, availabilty);
            else
                throw new Exception("Type not found");
        }
    }
    public static class Respondant extends Employee {
        public Respondant(String name, int availabilty){
            super(name, availabilty);
        }
        public void respondToCall(){
            System.out.println("Hello this is Respondant speaking");

        }
    }
    public static class Manager extends Employee {
        public Manager(String name, int availabilty){
            super(name, availabilty);
        }
        public void respondToCall(){
            System.out.println("Hello this is Manager speaking");

        }
    }
    public static class Director extends Employee {
        public Director(String name, int availabilty){
            super(name, availabilty);
        }
        public void respondToCall(){
            System.out.println("Hello this is Director speaking");
        }
    }
}
