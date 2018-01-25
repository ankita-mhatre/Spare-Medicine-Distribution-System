/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medicine;

import Business.Inventory.InventoryDirectory;
import java.util.Date;

/**
 *
 * @author Ankita Mhatre
 */
public class Medicine {
    private int medicineID;
    private String medicineName;
    private String medicineManufacturerName;
    private String manufactureDate;
    private Date expiryDate;

   
    private String prescribed;
    private String disease;
    private String comment;
    private String drugType;
    private int quantity;
    
    private InventoryDirectory inventoryList;

    public InventoryDirectory getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(InventoryDirectory inventoryList) {
        this.inventoryList = inventoryList;
    }
   
    
     public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Medicine() {
        
    }

    public String getPrescribed() {
        return prescribed;
    }

    public void setPrescribed(String prescribed) {
        this.prescribed = prescribed;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    
    
    public int getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(int medicineID) {
        this.medicineID = medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineManufacturerName() {
        return medicineManufacturerName;
    }

    public void setMedicineManufacturerName(String medicineManufacturerName) {
        this.medicineManufacturerName = medicineManufacturerName;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

   

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return medicineName;
    }
    
    
}
