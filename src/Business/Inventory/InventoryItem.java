/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Inventory;
import Business.Medicine.Medicine;
import Business.Medicine.MedicineDirectory;
import Business.Network.Network;
import java.util.ArrayList;

/**
 *
 * @author Ankita Mhatre
 */

public class InventoryItem {
    
    // Ankita 12/11
    private String medName;
    private MedicineDirectory medicineListInInventoryItem;
    private Medicine medicine;
    private int quantity;
    private Network network;

    public InventoryItem() {
        medicineListInInventoryItem = new MedicineDirectory();
    }

    
    public MedicineDirectory getMedicineListInInventoryItem() {
        return this.medicineListInInventoryItem;
    }

    public void setMedicineListInInventoryItem(MedicineDirectory medicineListInInventoryItem) {
        this.medicineListInInventoryItem = medicineListInInventoryItem;
    }



    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }
    // Ankita 12/11
    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

      
    @Override
    public String toString() {
        return medName;
    }
}
