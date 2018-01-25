/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;
import UserInterface.DoctorRole.DoctorRoleJPanel;
import UserInterface.NGORole.NgoWorkAreaJPanel;
import UserInterface.Pharmacy.PharmacyWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author NIKUNJ
 */


public class PharmacyRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel container, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
     return new PharmacyWorkAreaJPanel(container, enterprise,network, account);
    }
    
}
