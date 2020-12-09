/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabStaffRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LaboratoryOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClaimWorkRequest;
import Business.WorkQueue.LabPatientWorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manasa
 */
public class LabStaffWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LabStaffWorkAreaJPanel
     */
        private JPanel userProcessContainer;
    private EcoSystem business;  
    private UserAccount account;
    Enterprise enterprise;
    public LabStaffWorkAreaJPanel(JPanel userProcessContainer, EcoSystem business,UserAccount account, LaboratoryOrganization LabOrganization, Enterprise enterprise) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.account = account;
        this.enterprise=enterprise;
        populateTestingTable();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateTestingTable(){
        DefaultTableModel model = (DefaultTableModel)labTestingTable.getModel();
        model.setRowCount(0);
        for(LabPatientWorkRequest work : account.getLabPatientWorkQueue().getLabPatientRequestList()){
                                Map<String,Date> map = work.getStatusMap();
                    String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : work.getStatusMap().entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0){
                    latestKey = mapEntry.getKey();
                }
               }
                            Object[] row = new Object[8];
                    row[0] = work;
                    row[1] = work.getLabTestType();
                    row[2] = work.getPatient();
                     row[3] = work.getSlotDate();
                    row[4] = work.getSlotTime();
                    row[5] = latestKey;
                    row[6] = work.getMessage();

                    model.addRow(row);  
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAssign = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        labTestingTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnProcess = new javax.swing.JButton();

        btnAssign.setText("Assign Receiver");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        labTestingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "LabID", "TestName", "PatientName", "Date", "Time", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(labTestingTable);

        jLabel1.setText("Lab Staff Panel");

        btnProcess.setText("Process Test");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1)
                .addContainerGap(381, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAssign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcess)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssign)
                    .addComponent(btnProcess))
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
         int selectedRow = labTestingTable.getSelectedRow();
                 if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Lab Test from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        LabPatientWorkRequest labReq= (LabPatientWorkRequest)labTestingTable.getValueAt(selectedRow, 0);
        Map<String,Date> reqMap = labReq.getStatusMap();
        reqMap.put("LabTesting InProgress-"+labReq.getLabTestType(), new Date());
        labReq.setStatusMap(reqMap);
        UserAccount pat = labReq.getPatient();
        pat.getLabPatientWorkQueue().updateLabPatientRequest(labReq, pat.getLabPatientWorkQueue().getLabPatientRequestList());
        business.getLabPatQueue().updateLabPatientRequest(labReq, business.getLabPatQueue().getLabPatientRequestList());
        populateTestingTable();
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = labTestingTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Lab Test from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        LabPatientWorkRequest labReq= (LabPatientWorkRequest)labTestingTable.getValueAt(selectedRow, 0);
        Map<String,Date> reqMap = labReq.getStatusMap();
        reqMap.put("Test Complete-Submitting Results-"+account, new Date());
        labReq.setStatusMap(reqMap);
        UserAccount pat1 = labReq.getPatient();
        pat1.getLabPatientWorkQueue().updateLabPatientRequest(labReq, pat1.getLabPatientWorkQueue().getLabPatientRequestList());
        business.getLabPatQueue().updateLabPatientRequest(labReq, business.getLabPatQueue().getLabPatientRequestList());
        ProcessTestJPanel processTestJPanel = new ProcessTestJPanel(userProcessContainer, account,business,labReq);
        userProcessContainer.add("processTestJPanel", processTestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        Patient patient = null;
        String pat= labReq.getSender().getUsername();
        for(Patient p:business.getPatientDirectory().getpatientlist())
        {if (p.getUserName().equals(pat)){
            patient=p;
        }
        }
        
        ClaimWorkRequest r = new ClaimWorkRequest();
        r.setSender(account);
        r.setPatient(patient);
        r.setRequestDate(new Date());
        r.setCost(150.00);
        r.setStatus("Claim Requested");
        r.setInsurancepolicy(patient.getInsurance());
        r.setHospital(enterprise.toString());
        r.setInsuranceEnterprise(patient.getInsurance().getEnterprise());
        r.setInsuranceNo(patient.getInsuranceOrderNo());
       
       
        
        business.getClaimWorkQueue().getWorkRequestList().add(r);
        account.getClaimWorkQueue().getWorkRequestList().add(r);
        
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable labTestingTable;
    // End of variables declaration//GEN-END:variables
}
