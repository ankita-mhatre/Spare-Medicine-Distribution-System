/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;


import java.util.ArrayList;

/**
 *
 * @author Shah
 */
public class DoctorDirectory {

    ArrayList<Doctor> doctorList;

    public DoctorDirectory() {
        doctorList = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public void CreateDoctor(Doctor dr) {

        doctorList.add(dr);

    }
}
