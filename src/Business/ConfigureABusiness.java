/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Inventory.InventoryItem;
//import Business.MedicineList.Medicine;
import Business.Medicine.Medicine;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Shah
 */
public class ConfigureABusiness {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        Employee employee = system.getEmployeeList().createEmployee("Harsh");

        UserAccount ua = system.getUserAccountList().createUserAccount("sys", "sys", employee, new SystemAdminRole());
        
        
//        Medicine m = system.getMedicineList().addMedicine(0, "crocin", "cipla", 10, "11/12/2004", "08/12/2006");
        
//        InventoryItem i = system.getInventoryList().addAndUpdate(m, 10);
        
//        System.out.println(m);

        return system;
    }

}
