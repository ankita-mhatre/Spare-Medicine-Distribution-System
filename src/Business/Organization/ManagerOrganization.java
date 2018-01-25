/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Patient.PatientDirectory;
import Business.Role.AdminRole;
import Business.Role.ManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class ManagerOrganization extends Organization {

    // to be done after creating panel of it//
   // private PatientDirectory patientList;

    public ManagerOrganization() {
        super(Organization.Type.Manager.getValue());
     //   patientList = new PatientDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new ManagerRole());
        return roleList;

    }

}
