/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import Business.Person.PersonDirectory;

/**
 *
 * @author Shah
 */
public class Doctor {

    private String location;
    private String prescribedMedicine;
    private String disease;
    private String time;
    private int medicineQty;
    // new change//
    private PersonDirectory personDirectory;
    // -----------//

    public Doctor() {
        personDirectory = new PersonDirectory();
    }

    public int getMedicineQty() {
        return medicineQty;
    }

    public void setMedicineQty(int medicineQty) {
        this.medicineQty = medicineQty;
    }

    public String getLocation() {
        return location;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(String prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return getPrescribedMedicine();
    }
}
