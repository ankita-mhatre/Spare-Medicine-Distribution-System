/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.UserAccount.UserAccount;

/**
 *
 * @author Ankita Mhatre
 */
public class NGOInventoryItem extends InventoryItem {
    
   // ankita 29/11//
   private UserAccount userAccount; 
//    ********Ankita 11/29***********

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
}
