/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

//import Business.Appointment.Appointment;
import Business.Medicine.Medicine;
//import Business.Patient.Patient;
//import Business.Patient.PatientDirectory;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Shah
 */
public abstract class WorkRequest {

    private UserAccount sender;
    private UserAccount receiver;
    private String status;

    // need to check once -----------------//
    private Medicine medicine;
  //  private Appointment appointment;
    // -----------------------------------//

    public WorkRequest() {

      //  appointment = new Appointment();

    }

  

    public Medicine getMedicine() {

        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return getStatus();
//    }
    
    @Override
    public String toString() {
        return sender.toString();
    }
    
}
