/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.NGOEnterprise;
import Business.Inventory.InventoryDirectory;
import Business.Inventory.InventoryItem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.UserOrder.UserOrder;
import Business.UserOrder.UserOrderDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Ankita Mhatre
 */
public class AnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalysisJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private int ecoTotal;
    private int netTotal;

    public AnalysisJPanel(JPanel userProcessContainer, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        populateComboBox();
    }

    private void populateComboBox() {
        networkJComboBox.removeAllItems();
//        enterpriseTypeJComboBox.removeAllItems();

        for (Network network : business.getNetworkList()) {
            networkJComboBox.addItem(network);
        }

    }

    private void populateTop10OrderedMeds(Network n) {
        // Storing orders from both hospi and ngo orderDirs
//        UserOrder finalOrder = new UserOrder();
        UserOrderDirectory finalOrderDir = new UserOrderDirectory();
        UserOrderDirectory tempResult = new UserOrderDirectory();
        DefaultTableModel model = (DefaultTableModel) tbltopOrderedMeds.getModel();
        model.setRowCount(0);
        Object[] row = new Object[2];
        int srno = 1;

        for (Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof NGOEnterprise || enterprise instanceof HospitalEnterprise) {
                System.out.println(enterprise.getName() + "---should be ngo/ hospi enterprise");
                for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : o.getUserAccountList().getUserAccountList()) {

                        for (UserOrder uo : ua.getUserOrderDir().getUserOrderList()) {
                            finalOrderDir.addOrder(uo);
                        }
                    }
                }
            }
        }
        // check if multiple entries n add quantities of same entries
        for (UserOrder finalOrder : finalOrderDir.getUserOrderList()) {
            for (UserOrder fin : finalOrderDir.getUserOrderList()) {
                if (finalOrder.getOrderItem().equalsIgnoreCase(fin.getOrderItem())) {
                    finalOrder.setQuantity(fin.getQuantity() + finalOrder.getQuantity());
                }
            }
            UserOrder tempOrder = new UserOrder();
            tempResult.addOrder(tempOrder);
        }
        //                *****Ankita 12-12
        //                reverse arraylist
        for (UserOrder ttt : tempResult.getUserOrderList()) {
            System.out.println(ttt.getQuantity());

        }
        Collections.sort(tempResult.getUserOrderList(), new Comparator<UserOrder>() {

            @Override
            public int compare(UserOrder o1, UserOrder o2) {
                if (o1.getQuantity() > (o2.getQuantity())) {
                    return -1;
                } else if (o1.getQuantity() == (o2.getQuantity())) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
//                Display reversed list    
        for (UserOrder uoo : finalOrderDir.getUserOrderList()) {
            if (srno <= 10) {
                System.out.println(uoo.getQuantity() + "desc order quantity 1");
                row[0] = srno;
                row[1] = uoo.getOrderItem();
                srno++;
                model.addRow(row);
            }
        }

    }

    private void populateTop10DonatedMeds(Network n) {
        DefaultTableModel model = (DefaultTableModel) tbltop5MedicalDonatedMeds.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        int srno = 1;

        for (Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof NGOEnterprise) {
                System.out.println(enterprise.getName() + "---should be enterprise");
                InventoryDirectory inventoryDir = enterprise.getInventoryDirectoryEnterpriseLevel();

//                *****Ankita 12-12
//                reverse arraylist
                Collections.sort(inventoryDir.getInventoryList(), new Comparator<InventoryItem>() {
                    @Override
                    public int compare(InventoryItem o1, InventoryItem o2) {
                        if (o1.getQuantity() > (o2.getQuantity())) {
                            return -1;
                        } else if (o1.getQuantity() == (o2.getQuantity())) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }

                    @Override
                    public Comparator<InventoryItem> reversed() {
                        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
                    }
                });
//                Display reversed list    
                for (InventoryItem i : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList()) {
                    if (srno <= 5) {
                        System.out.println(i.getQuantity() + "desc order quantity 1");
                        row[0] = srno;
                        row[1] = i.getMedName();
                        srno++;
                        model.addRow(row);
                    }

                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTotalDonated = new javax.swing.JTextField();
        btnTotalMeds = new javax.swing.JButton();
        lblAllNetworks = new javax.swing.JLabel();
        txtTotalNetwork = new javax.swing.JTextField();
        networkJComboBox = new javax.swing.JComboBox();
        lblAllNetworks2 = new javax.swing.JLabel();
        btnTotalMedsInNetwork = new javax.swing.JButton();
        lblAllNetworks3 = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltopOrderedMeds = new javax.swing.JTable();
        lblAllNetworks4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltop5MedicalDonatedMeds = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        chart = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtTotalDonated.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalDonated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalDonatedActionPerformed(evt);
            }
        });

        btnTotalMeds.setBackground(new java.awt.Color(51, 153, 255));
        btnTotalMeds.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTotalMeds.setForeground(new java.awt.Color(255, 255, 255));
        btnTotalMeds.setText("Get Ecosystem Stats");
        btnTotalMeds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalMedsActionPerformed(evt);
            }
        });

        lblAllNetworks.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAllNetworks.setText("Donated in Entire system so far");

        txtTotalNetwork.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalNetworkActionPerformed(evt);
            }
        });

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        lblAllNetworks2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAllNetworks2.setText("Donated in this network");

        btnTotalMedsInNetwork.setBackground(new java.awt.Color(51, 153, 255));
        btnTotalMedsInNetwork.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTotalMedsInNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnTotalMedsInNetwork.setText("Get Network Stats");
        btnTotalMedsInNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalMedsInNetworkActionPerformed(evt);
            }
        });

        lblAllNetworks3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAllNetworks3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAllNetworks3.setText("Top 10 Most Ordered Meds");

        btnBack2.setText("<< Back Button");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        tbltopOrderedMeds.setBackground(new java.awt.Color(0, 153, 255));
        tbltopOrderedMeds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbltopOrderedMeds.setForeground(new java.awt.Color(255, 0, 0));
        tbltopOrderedMeds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "Medicine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbltopOrderedMeds);

        lblAllNetworks4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAllNetworks4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAllNetworks4.setText("Top 10 Donated Meds");

        tbltop5MedicalDonatedMeds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbltop5MedicalDonatedMeds.setForeground(new java.awt.Color(0, 153, 255));
        tbltop5MedicalDonatedMeds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No", "Medicine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbltop5MedicalDonatedMeds);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Network Analysis");

        chart.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        chart.setText("Chart");
        chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBack2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAllNetworks2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(202, 202, 202)
                                .addComponent(txtTotalNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(58, 58, 58)
                                    .addComponent(btnTotalMedsInNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAllNetworks, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(108, 108, 108)
                                    .addComponent(txtTotalDonated, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAllNetworks4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAllNetworks3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(511, 511, 511)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(btnTotalMeds, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnBack2)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTotalMeds, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalDonated, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAllNetworks, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTotalMedsInNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalNetwork)
                            .addComponent(lblAllNetworks2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAllNetworks4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAllNetworks3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(chart))
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalDonatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalDonatedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDonatedActionPerformed

    private void btnTotalMedsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalMedsActionPerformed
        // TODO add your handling code here:
        int count = 0;
        for (Network network : business.getNetworkList()) {
            System.out.println(network + "---network");
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof NGOEnterprise) {
                    System.out.println(enterprise.getName() + "---should be enterprise");
                    for (InventoryItem i : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList()) {
                        count += i.getQuantity();
                        ecoTotal = count;
                    }

                }
            }
        }
        txtTotalDonated.setText(String.valueOf(count));
    }//GEN-LAST:event_btnTotalMedsActionPerformed

    private void txtTotalNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalNetworkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalNetworkActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void btnTotalMedsInNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalMedsInNetworkActionPerformed
        // TODO add your handling code here:
        Network n = (Network) networkJComboBox.getSelectedItem();
        int networkCount = 0;
        for (Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof NGOEnterprise) {
                System.out.println(enterprise.getName() + "---should be enterprise");
                for (InventoryItem i : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList()) {
                    networkCount += i.getQuantity();
                    netTotal = networkCount;
                }

            }
        }
        txtTotalNetwork.setText(String.valueOf(networkCount));
        populateTop10DonatedMeds(n);
        populateTop10OrderedMeds(n);
    }//GEN-LAST:event_btnTotalMedsInNetworkActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        int networkCount = 0;
        for (Network net1 : business.getNetworkList()) {
            for (Enterprise enterprise : net1.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof NGOEnterprise) {
                    System.out.println(enterprise.getName() + "---should be enterprise");
                    for (InventoryItem i : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList()) {
                        networkCount += i.getQuantity();
                        netTotal = networkCount;
                    }

                }
            }
            pieDataset.setValue(net1.getName(), new Double((netTotal * 100 / ecoTotal)));
            netTotal = 0;
        }

        //pieDataset.setValue("EcoSytem", new Double( ecoTotal ) );
//          pieDataset.setValue("Network", new Double(  ) );
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(900, 850);
    }//GEN-LAST:event_chartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnTotalMeds;
    private javax.swing.JButton btnTotalMedsInNetwork;
    private javax.swing.JButton chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAllNetworks;
    private javax.swing.JLabel lblAllNetworks2;
    private javax.swing.JLabel lblAllNetworks3;
    private javax.swing.JLabel lblAllNetworks4;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JTable tbltop5MedicalDonatedMeds;
    private javax.swing.JTable tbltopOrderedMeds;
    private javax.swing.JTextField txtTotalDonated;
    private javax.swing.JTextField txtTotalNetwork;
    // End of variables declaration//GEN-END:variables
}
