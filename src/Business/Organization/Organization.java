/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Doctor.DoctorDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Inventory.InventoryDirectory;
import Business.Medicine.Medicine;
import Business.Medicine.MedicineDirectory;

import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
// Harsh 18-11
public abstract class Organization {

    private String name;
    private int organizationId;
    private static int counter = 1;

    private EmployeeDirectory employeeList;
    private UserAccountDirectory userAccountList;
    private WorkQueue workQueue;
    private PersonDirectory personList;
    private DoctorDirectory doctorList;

    public DoctorDirectory getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(DoctorDirectory doctorList) {
        this.doctorList = doctorList;
    }
//------------------------Not Sure ----------------------------------------------------------------------//
    private Medicine medicine;
//    private InventoryDirectory inventoryList;
    private MedicineDirectory medicineList;
//------------------------------------------------------------------------------------------------------//

    public enum Type {
        Admin("Admin Organization"),
        //NGO("NGO Organization"),
        //Hospital("Hospital Organization"),
        Disposable("Disposable Organization"),
        Doctor("Doctor Organization"),
        Patient("Patient Organization"),
        Customer("Customer Organization"),
        Pharmacy("Pharmacy Organization"),
        //AdminHospital("Hospital Admin"),
        //AdminDoctor("Doctor Admin"),
        RnDTeam("R&D Admin"),
        Manager("Manager");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public Organization(String name) {
        this.name = name;
        employeeList = new EmployeeDirectory();
        userAccountList = new UserAccountDirectory();
        medicineList = new MedicineDirectory();
        //inventoryList = new InventoryDirectory();
        workQueue = new WorkQueue();
        organizationId = counter++;
        personList = new PersonDirectory();
        doctorList = new DoctorDirectory();

    }

    public abstract ArrayList<Role> getSupportedRole();

//    public InventoryDirectory getInventoryList() {
//        return inventoryList;
//    }
//
//    public void setInventoryList(InventoryDirectory inventoryList) {
//        this.inventoryList = inventoryList;
//    }

    public PersonDirectory getPersonList() {
        return personList;
    }

    public void setPersonList(PersonDirectory personList) {
        this.personList = personList;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

//    public InventoryDirectory getInventoryList() {
//        return inventoryList;
//    }
//
//    public void setInventoryList(InventoryDirectory inventoryList) {
//        this.inventoryList = inventoryList;
//    }
    public MedicineDirectory getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(MedicineDirectory medicineList) {
        this.medicineList = medicineList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Organization.counter = counter;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public EmployeeDirectory getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(EmployeeDirectory employeeList) {
        this.employeeList = employeeList;
    }

    public UserAccountDirectory getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(UserAccountDirectory userAccountList) {
        this.userAccountList = userAccountList;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
}
// Harsh 18-11
