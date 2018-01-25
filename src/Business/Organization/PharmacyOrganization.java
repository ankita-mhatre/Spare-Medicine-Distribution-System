/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Patient.PatientDirectory;
import Business.Role.AdminRole;
import Business.Role.PharmacyRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class PharmacyOrganization extends Organization{

   // private PatientDirectory patientList;

    public PharmacyOrganization() {
        super(Organization.Type.Pharmacy.getValue());
     //   patientList = new PatientDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new PharmacyRole());
        return roleList;
    }
}
