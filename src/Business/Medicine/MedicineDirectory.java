/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medicine;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ankita Mhatre
 */
public class MedicineDirectory {
        private ArrayList<Medicine> medicineList;

    public MedicineDirectory() {
        medicineList = new ArrayList<Medicine>();
    }

    public ArrayList<Medicine> getMedicineList() {
        System.out.println(medicineList+"in med inv");

        return this.medicineList;
        
    }

    public void setMedicineList(ArrayList<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public Medicine addMedicine(Medicine med) {
//       Ankita 12/11
//        Medicine medicine = new Medicine();
//        medicine.setMedicineID(id);
//        medicine.setMedicineName(name);
//        medicine.setManufactureDate(manuName);
//        medicine.setQuantity(quantity);
//        medicine.setManufactureDate(manuDate);
//        medicine.setExpiryDate(expDate);
System.out.println("in add medicine");
        medicineList.add(med);
        return med;
    }
    
    
        public void removeMedicineNGO(Medicine ni){
        
        medicineList.remove(ni);
        
    }
    

    public void removeMedicine(Medicine Medicine) {
        medicineList.remove(Medicine);
    }
}
