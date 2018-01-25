/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Inventory.NGOInventoryItem;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class NGOEnterprise extends Enterprise {

    private NGOInventoryItem ngoInventory;

    public NGOInventoryItem getNgoInventory() {
        return ngoInventory;
    }

    public void setNgoInventory(NGOInventoryItem ngoInventory) {
        this.ngoInventory = ngoInventory;
    }
            
    
    public NGOEnterprise(String name) {
        super(name, EnterpriseType.NGO);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

}
