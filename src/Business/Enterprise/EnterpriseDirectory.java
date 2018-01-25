
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.NGO) {
            enterprise = new NGOEnterprise(name);
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Hospital) {
            enterprise = new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Disposable) {
            enterprise = new DisposableEnterprise(name);
            enterpriseList.add(enterprise);
        }

        return enterprise;
    }
    
    public boolean checkIfEnterpriseIsUnique(String username){
        for (Enterprise ent : enterpriseList){
            if (ent.getName().equals(username))
                return true;
        }
        return false;
    }
    
    
    public void removeEnterprise(Enterprise ent) {
        
       
        enterpriseList.remove(ent);
         
    }
    
    

}
