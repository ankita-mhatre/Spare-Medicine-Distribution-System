/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

//import Business.Patient.PatientDirectory;

/**
 *
 * @author Shah
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    // private PatientDirectory patientList;
    //private CustomerDirectory customerList;

    public Person() {
        //  patientList = new PatientDirectory();
        //customerList = new CustomerDirectory();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
