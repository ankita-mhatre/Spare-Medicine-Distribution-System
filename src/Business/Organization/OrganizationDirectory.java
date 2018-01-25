/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
//harsh 18-11
public class OrganizationDirectory {

    ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Manager.getValue())) {
            organization = new ManagerOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Pharmacy.getValue())) {
            organization = new PharmacyOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.RnDTeam.getValue())) {
            organization = new RnDOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Patient.getValue())) {
            organization = new PatientOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Disposable.getValue())) {
            organization = new DisposalOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Customer.getValue())) {
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }

        return organization;
    }
    
    
    public void removeOrganization(Organization org){
        
        organizationList.remove(org);
    }
    
    
    
    
}
// harsh 18-11
