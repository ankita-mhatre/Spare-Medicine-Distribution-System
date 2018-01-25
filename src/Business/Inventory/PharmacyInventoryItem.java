/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.UserAccount.UserAccount;

/**
 *
 * @author NIKUNJ
 */
public class PharmacyInventoryItem extends InventoryItem {

    
// Nikunj 5/12
    
       private UserAccount userAccount;

    

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
    
}
