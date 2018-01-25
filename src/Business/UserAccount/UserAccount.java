/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Doctor.Doctor;
import Business.Employee.Employee;
//import Business.Patient.Patient;
//import Business.Patient.PatientDirectory;
import Business.Person.Person;
import Business.Role.Role;
import Business.UserOrder.UserOrderDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Shah
 */
public class UserAccount {

    private String username;
    private String password;

    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
// added patient directory by harsh //
    private Person person;
    private Doctor doctor;
// end of patient directory by harsh // 

     private UserOrderDirectory userOrderDir;
    
    
    public UserAccount() {
        workQueue = new WorkQueue();
         userOrderDir = new UserOrderDirectory();
    }
    
    public void setUserOrderDir(UserOrderDirectory userOrderDir) {
        this.userOrderDir = userOrderDir;
    }
   

// Ankita 12-12
    
 

   public UserOrderDirectory getUserOrderDir() {
        return userOrderDir;
    }
    

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return username;
    }

}
