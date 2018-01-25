/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

//import Business.Appointment.Appointment;

import java.util.Date;


/**
 *
 * @author Shah
 */
public class PatientDoctorWorkRequest extends WorkRequest {

    private String time;
    private Date date;

    // nikunj 12/6
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

}
