
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
import javax.swing.JPanel;

/**
 *
 * @author Shah
 */

public abstract class Role {
     public enum RoleType{
        Admin("Admin"),
        InventoryManagerRole("Inventory Manager Role"),
        NGORole("NGO Role"),
        PatientRole("Patient Role"),
        SystemAdminRole("System Admin Role"),
        DoctorRole("Doctor Role"),
        PharmacyRole("Pharmacy Manager Role"),
        DisposableRole("Disposable Manager Role");
        
        
        private String value;
        private RoleType(String value){
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
    
    public abstract JPanel createWorkArea(JPanel container, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise,
            Network network,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1).trim();
       
    }
    
}
