/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

//import Business.Appointment.AppointmentDirectory;
import Business.Doctor.DoctorDirectory;
import Business.Inventory.InventoryDirectory;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
//import Business.Patient.PatientDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Shah
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private WorkQueue workQueue;
    // ankita changes for 2-12//
    private InventoryDirectory inventoryDirectoryEnterpriseLevel;
    //-----------------------//

    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
        workQueue = new WorkQueue();
        inventoryDirectoryEnterpriseLevel = new InventoryDirectory();
    }

    public InventoryDirectory getInventoryDirectoryEnterpriseLevel() {
        this.inventoryDirectoryEnterpriseLevel = inventoryDirectoryEnterpriseLevel;
        return inventoryDirectoryEnterpriseLevel;
    }

    public void setInventoryDirectoryEnterpriseLevel(InventoryDirectory inventoryDirectoryEnterpriseLevel) {
        this.inventoryDirectoryEnterpriseLevel = inventoryDirectoryEnterpriseLevel;
    }

   

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public enum EnterpriseType {

        NGO("NGO Enterprise"), Hospital("Hospital Enterprise"), Disposable("Disposable Enterprise");
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

}
