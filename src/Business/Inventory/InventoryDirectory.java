/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Enterprise.DisposableEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.NGOEnterprise;
import Business.Medicine.Medicine;
import Business.Medicine.MedicineDirectory;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Ankita Mhatre
 */
public class InventoryDirectory {

    private ArrayList<InventoryItem> inventoryList;

    public InventoryDirectory() {
        inventoryList = new ArrayList<InventoryItem>();
    }

    public ArrayList<InventoryItem> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<InventoryItem> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public InventoryItem addInventoryItem(Enterprise enterprise, UserAccount ua, Medicine medicine, int qty) {
// **********Ankita 12/10
    int flag = 0;
        NGOInventoryItem ni = new NGOInventoryItem();
        if (enterprise instanceof NGOEnterprise) {
            System.out.println("in inventory NGOEnterprise");
            //first check whether  med then already exists in inventory
            
           for(InventoryItem i : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList())
            {
            if(medicine.getMedicineName().equalsIgnoreCase(i.getMedName()))
            {
                System.out.println(i.getMedName()+"-------------med dir name");
                i.setQuantity(i.getQuantity()+qty);
                flag = 1;
                System.out.println("med copy found");
                System.out.println(i.getQuantity()+"------current quantity in inventory");
                MedicineDirectory md = i.getMedicineListInInventoryItem();
                md.getMedicineList().add(medicine);
            }
            }
            //first check whether then med already exists in inventory
            if(flag == 1)
            {
                System.out.println("new med record added in medlist");
//                return ni;
            }else if(flag == 0)
            {
            
           // add med in med inventory
              
            ni.getMedicineListInInventoryItem().addMedicine(medicine);
            ni.setMedName(medicine.getMedicineName());
            ni.setMedicine(medicine);
            ni.setQuantity(qty);
            ni.setUserAccount(ua);
             System.out.println(ni.getMedName()+"-------------med name set new med");
            inventoryList.add(ni);
            System.out.println("med copy not found...new med added");
            System.out.println(ni.getQuantity()+"----new med quantity");
//            return ni;
            }
            
       }
//************Ankita 12/10
        return ni;
    }
    
//    public InventoryItem removeInventoryItemNGO(NGOInventoryItem ni){
//        
////        NGOInventoryItem ni = new NGOInventoryItem();
//        inventoryList.remove(ni);
//        
//        return null;
//    }
    
   
    
    
    public InventoryItem addInventoryItemDisposable(Enterprise enterprise, UserAccount ua, Medicine medicine, int qty) {
//        inventory.setNetwork(network);
        DisposableInventoryItem ni = new DisposableInventoryItem();
        if (enterprise instanceof DisposableEnterprise) {
            System.out.println("in inventory DisEnterprise");

            ni.setMedicine(medicine);
            ni.setQuantity(qty);
            ni.setUserAccount(ua);
            inventoryList.add(ni);
            return ni;
        }

        return null;
    }
    
     public InventoryItem addInventoryItemPharmacy (Enterprise enterprise, UserAccount ua, Medicine medicine, int qty) {
        PharmacyInventoryItem ni = new PharmacyInventoryItem();
        if (enterprise instanceof HospitalEnterprise) {

            ni.setMedicine(medicine);
            ni.setQuantity(qty);
            ni.setUserAccount(ua);
            inventoryList.add(ni);
            return ni;
        }

        return null;
    }
    

    public InventoryItem addAndUpdate(Medicine medicine, int qty) {
        boolean flag = false;
        InventoryItem itm = null;
        for (InventoryItem item : inventoryList) {
            if (item.getMedicine() == medicine) {
                item.setQuantity(item.getQuantity() + qty);
                flag = true;
                itm = item;
            }
        }
        if (!flag) {
            InventoryItem inventory = new InventoryItem();
            inventory.setMedicine(medicine);
            inventory.setQuantity(qty);
            inventoryList.add(inventory);
            itm = inventory;
        }
        return itm;
    }

}
