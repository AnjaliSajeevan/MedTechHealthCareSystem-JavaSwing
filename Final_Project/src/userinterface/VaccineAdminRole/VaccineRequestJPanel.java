/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineTester;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.VaccineScientistRole.ViewVaccineJPanel;

/**
 *
 * @author Manasa
 */
public class VaccineRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem business; 
    private Enterprise enterprise;
    private int testerNum;
    public VaccineRequestJPanel(JPanel userProcessContainer, Enterprise enterprise,EcoSystem business ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.enterprise = enterprise;
        this.testerNum = 0;
        populateStaffBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateTesterTable(){
                DefaultTableModel model = (DefaultTableModel)testorsTable.getModel();
        model.setRowCount(0);
        if(testerNum > 0){
        testorsTable.addRowSelectionInterval(1, testerNum);
        }
        List<VaccineTester> vaccinetestList = business.getVaccinetesterDirectory().getVaccineTesterList();
        for(VaccineTester tester: vaccinetestList){
            Object row[] = new Object[4];
                 row[0] = tester.getId();
                 row[1] = tester;
                 row[2] = tester.getCondition();
                 row[3] = tester.getAge();        
                 
            model.addRow(row);                    
        }
            
    
    }
    public void populateStaffBox(){
        staffComboBox.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                if(ua.getRole().equals("VaccineTestingStaff")){
                staffComboBox.addItem(ua);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        vaccineRequestTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSelectTester = new javax.swing.JButton();
        btnViewVaccine = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        testerSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        testorsTable = new javax.swing.JTable();
        btnViewTester = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnStaffAsgn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRouteBack = new javax.swing.JButton();
        routeMessage = new javax.swing.JTextField();
        staffComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        testingRequestTable = new javax.swing.JTable();
        btnDeselect = new javax.swing.JButton();

        vaccineRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "VaccineID", "Name", "Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vaccineRequestTable);

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Step 1: Select Request to Process and Number of Testers:");

        btnSelectTester.setText("Proceed For Testers Selection");
        btnSelectTester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectTesterActionPerformed(evt);
            }
        });

        btnViewVaccine.setText("View Vaccine");
        btnViewVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVaccineActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Step 2: Choose Testers:");

        jLabel3.setText("Number of Patients to be Tested");

        testorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TesterID", "Name", "Health Type", "Age"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(testorsTable);

        btnViewTester.setText("View Tester Details");
        btnViewTester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTesterActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setText("Step 3:Assign to Staff for Testing:");

        btnStaffAsgn.setText("Proceed For Staff Assignment");
        btnStaffAsgn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffAsgnActionPerformed(evt);
            }
        });

        jButton4.setText("Proceed with Testing");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Testing Staff:");

        btnRouteBack.setText("Route Back Request");
        btnRouteBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRouteBackActionPerformed(evt);
            }
        });

        staffComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("New Vaccine Requests");

        testingRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "RequestID", "VaccineID", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(testingRequestTable);
        if (testingRequestTable.getColumnModel().getColumnCount() > 0) {
            testingRequestTable.getColumnModel().getColumn(0).setResizable(false);
            testingRequestTable.getColumnModel().getColumn(1).setResizable(false);
            testingRequestTable.getColumnModel().getColumn(2).setResizable(false);
            testingRequestTable.getColumnModel().getColumn(3).setResizable(false);
        }

        btnDeselect.setText("Deselect All");
        btnDeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewTester)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(317, 317, 317)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(staffComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(84, 84, 84))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDeselect))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnViewVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(142, 142, 142)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnSelectTester, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(testerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(97, 97, 97)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRouteBack)
                                        .addComponent(routeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btnStaffAsgn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewVaccine)
                    .addComponent(routeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(testerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRouteBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectTester, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnDeselect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnViewTester)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStaffAsgn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(staffComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewTesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTesterActionPerformed
        // TODO add your handling code here:
        int selectedRow = testorsTable.getSelectedRow();
        if(selectedRow<0 || selectedRow>1){
            JOptionPane.showMessageDialog(null, "Please select one Testor to view details!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineTester tester= (VaccineTester)testorsTable.getValueAt(selectedRow, 0);
        ViewTestersJPanel viewTestersJPanel = new ViewTestersJPanel(userProcessContainer, business,tester);
        userProcessContainer.add("viewTestersJPanel", viewTestersJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewTesterActionPerformed

    private void staffComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffComboBoxActionPerformed

    private void btnStaffAsgnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffAsgnActionPerformed
        // TODO add your handling code here:
        int rows = testorsTable.getSelectedRowCount();
        if(rows < testerNum){
             JOptionPane.showMessageDialog(null, "Required "+testerNum+" testers!\nThe selected testers are less than required testers!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;           
        }
        int[] selectedRow = testorsTable.getSelectedRows();
        for(int i=0;i<selectedRow.length;i++){
          //send each selectedtester requests to labstaff  
          //populate testing request table
        }

    }//GEN-LAST:event_btnStaffAsgnActionPerformed

    private void btnDeselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectActionPerformed
        // TODO add your handling code here:
        testorsTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnDeselectActionPerformed

    private void btnSelectTesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectTesterActionPerformed
        // TODO add your handling code here:
        testerNum = (Integer)testerSpinner.getValue();
        if(testerNum <=0){
      JOptionPane.showMessageDialog(null, "Number of testers needs to be more than zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;    
        }
        populateTesterTable(); 
    }//GEN-LAST:event_btnSelectTesterActionPerformed

    private void btnRouteBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRouteBackActionPerformed
        // TODO add your handling code here:
       int selectedRow = vaccineRequestTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(routeMessage.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Route message is mandatory for sending back the request!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;            
        }
        //send back the vaccine req to vaccine sceintist queue.
    }//GEN-LAST:event_btnRouteBackActionPerformed

    private void btnViewVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVaccineActionPerformed
        // TODO add your handling code here:
                  int selectedRow = vaccineRequestTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vaccine vaccine= (Vaccine)vaccineRequestTable.getValueAt(selectedRow, 0);
          
        ViewVaccineJPanel viewVaccineJPanel=new ViewVaccineJPanel(userProcessContainer,account,business,vaccine);
        userProcessContainer.add("viewVaccineJPanel",viewVaccineJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewVaccineActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(staffComboBox.getSelectedItem().equals("")){
         JOptionPane.showMessageDialog(null, "Please select a Vaccine Testing staff!", "Warning", JOptionPane.WARNING_MESSAGE);       
                  return;
        }
                int[] selectedRow = testorsTable.getSelectedRows();
        for(int i=0;i<selectedRow.length;i++){
          //send each selectedtester requests to labstaff  
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeselect;
    private javax.swing.JButton btnRouteBack;
    private javax.swing.JButton btnSelectTester;
    private javax.swing.JButton btnStaffAsgn;
    private javax.swing.JButton btnViewTester;
    private javax.swing.JButton btnViewVaccine;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField routeMessage;
    private javax.swing.JComboBox staffComboBox;
    private javax.swing.JSpinner testerSpinner;
    private javax.swing.JTable testingRequestTable;
    private javax.swing.JTable testorsTable;
    private javax.swing.JTable vaccineRequestTable;
    // End of variables declaration//GEN-END:variables
}
