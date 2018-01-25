/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
//import Business.Patient.Patient;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientDoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shah
 */
public class PrescriptionsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PrescriptionsJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    private Network network;
    private UserAccount userAccount;
    private Organization organization;

    PrescriptionsJPanel(JPanel container, Enterprise enterprise, UserAccount userAccount, Network network, Organization organization) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.network = network;
        this.userAccount = userAccount;
        this.organization = organization;
        populateDatas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePatientDetails = new javax.swing.JTable();
        btnProcess = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPatientHist = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tablePatientDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Age"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePatientDetails);

        btnProcess.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Patient Details");

        btnPatientHist.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPatientHist.setText("Patient History");
        btnPatientHist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientHistActionPerformed(evt);
            }
        });

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnPatientHist, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(jLabel1)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPatientHist, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
    }// </editor-fold>//GEN-END:initComponents

     private void populateDatas() {

// new changes //
        DefaultTableModel model = (DefaultTableModel) tablePatientDetails.getModel();
        model.setRowCount(0);
        
            //  if (org instanceof PatientOrganization) {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                if (request instanceof PatientDoctorWorkRequest) {
//                       
                    Object[] row = new Object[2];
                    //row[0] = request.getSender();
                    row[0] = request;
                    UserAccount ua = request.getSender();
                    row[1] = ua.getPerson().getAge();

                    model.addRow(row);
              
            }
        }
        //   }
//            //
    }
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:

        int selectedrow = tablePatientDetails.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row to view data ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            WorkRequest request = (WorkRequest) tablePatientDetails.getValueAt(selectedrow, 0);
            DoctorAppointmentJPanel doctorAppointmentJPaneljpanel = new DoctorAppointmentJPanel(container, enterprise, network,organization,request,userAccount);
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("DoctorAppointmentJPanel", doctorAppointmentJPaneljpanel);
            layout.next(container);
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnPatientHistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientHistActionPerformed
        // TODO add your handling code here:
        int selectedrow = tablePatientDetails.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row to view data ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // Patient patient = (Patient) tablePatientDetails.getValueAt(selectedrow, 0);
            WorkRequest request = (WorkRequest) tablePatientDetails.getValueAt(selectedrow, 0);
            PatientHistoryJPanel patientHistoryJPanel = new PatientHistoryJPanel(container, enterprise, network,organization,request,userAccount);
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("PatientHistoryJPanel", patientHistoryJPanel);
            layout.next(container);
        }
    }//GEN-LAST:event_btnPatientHistActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPatientHist;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePatientDetails;
    // End of variables declaration//GEN-END:variables

   
}