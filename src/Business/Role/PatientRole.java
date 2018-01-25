/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.NGORole.NgoWorkAreaJPanel;
import UserInterface.PatientRole.PatientWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Shah
 */
// harsh//
public class PatientRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel container, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
//        if (organization instanceof ManagerOrganization) {
            //  return new PatientWorkAreaJPanel(container, account, (PatientOrganization) organization, enterprise, network);
//            return new NgoWorkAreaJPanel(container, enterprise, network, business, account);

//        } else {
            return new PatientWorkAreaJPanel(container, account, (PatientOrganization) organization, enterprise, network);
//        }
    }

//    @Override
//    public JPanel createWorkArea(JPanel container, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
//        return new PatientWorkAreaJPanel(container,account,(PatientOrganization)organization, enterprise,  network);
//
//    }
    // harsh//
}
