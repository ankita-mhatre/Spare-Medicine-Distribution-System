/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Doctor.DoctorDirectory;
//import Business.Patient.PatientDirectory;
import Business.Person.PersonDirectory;
import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class DoctorOrganization extends Organization {

    private PersonDirectory personList;

    public DoctorOrganization() {
        super(Organization.Type.Doctor.getValue());
        personList = new PersonDirectory();

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new DoctorRole());
        return roleList;
    }

}
