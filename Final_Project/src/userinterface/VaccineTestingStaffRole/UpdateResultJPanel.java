/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineTestingStaffRole;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.VaccineScientistRole.VaccineScientistWorkAreaJPanel;

/**
 *
 * @author Manasa
 */
public class UpdateResultJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateResultJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;  
    private UserAccount account;
    private LabTestWorkRequest labReq;
    private Enterprise enterprise;
    public UpdateResultJPanel(JPanel userProcessContainer,EcoSystem business,Enterprise enterprise,UserAccount account,LabTestWorkRequest labReq ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.enterprise = enterprise;
        this.account=account;
        this.labReq = labReq;
        populateFields();
        this.setSize(900, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateFields(){
        txtVac.setText(labReq.getVaccine().toString());
        txtTest.setText(labReq.toString());
        txtPatient.setText(labReq.getTester().toString());
        txtVac.setEnabled(false);
        txtTest.setEnabled(false);
        txtPatient.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPatient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDetail = new javax.swing.JTextField();
        btnSuc = new javax.swing.JRadioButton();
        btnFail = new javax.swing.JRadioButton();
        txtTest = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVac = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Update Clinical Trial Result");

        jLabel2.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Tester/Patient ID:");

        txtPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        txtPatient.setEnabled(false);
        txtPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Result:");

        jLabel6.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Detail Observation:");

        txtDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        txtDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetailActionPerformed(evt);
            }
        });

        btnSuc.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        btnSuc.setForeground(new java.awt.Color(0, 0, 51));
        btnSuc.setText("Success");
        btnSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSucActionPerformed(evt);
            }
        });

        btnFail.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        btnFail.setForeground(new java.awt.Color(0, 0, 51));
        btnFail.setText("Failure");
        btnFail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFailActionPerformed(evt);
            }
        });

        txtTest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        txtTest.setEnabled(false);
        txtTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTestActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Testing ID:");

        jLabel4.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("VaccineID:");

        txtVac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        txtVac.setEnabled(false);
        txtVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVacActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(0, 0, 51));
        btnSubmit.setText("SUBMIT RESULT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTest, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSuc)
                                .addGap(18, 18, 18)
                                .addComponent(btnFail))
                            .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuc)
                    .addComponent(btnFail))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientActionPerformed

    private void txtDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetailActionPerformed

    private void btnSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSucActionPerformed
        // TODO add your handling code here:
        btnFail.setSelected(false);
    }//GEN-LAST:event_btnSucActionPerformed

    private void btnFailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFailActionPerformed
        // TODO add your handling code here:
        btnSuc.setSelected(false);
    }//GEN-LAST:event_btnFailActionPerformed

    private void txtTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTestActionPerformed

    private void txtVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVacActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        LabTestWorkRequest lab = account.getLabTestWorkQueue().getLabRequest(labReq);
        if(lab == null){
            JOptionPane.showMessageDialog(null, "Lab Result has already been sent!\n Go back to update other results", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String error = "";
        if((!btnSuc.isSelected()) && (!btnFail.isSelected())){
            error+="Selecting Result is Mandatory!\n";
        }
        if(txtDetail.getText().equals("")){
            error+="Detail Observation is Mandatory!\n";
        }
        if(error.equals("")){
            if(btnSuc.isSelected()){
                Map<String,Date> labMap = labReq.getStatusMap();
                labMap.put("Success!", new Date());
                labReq.setResult("Success!");
                labReq.setStatusMap(labMap);
            }else{
                Map<String,Date> labMap = labReq.getStatusMap();
                labMap.put("Failure!", new Date());
                labReq.setStatusMap(labMap);
                labReq.setResult("Failure!");
            }
            labReq.setMessage(txtDetail.getText());
            UserAccount ua = labReq.getSender();
            ua.getLabTestWorkQueue().addLabRequest(labReq);
            labReq.setReceiver(labReq.getSender());
            labReq.setSender(account);
            business.getLabQueue().updateLabRequest(labReq, business.getLabQueue().getLabRequestList());
            account.getLabTestWorkQueue().removeLabRequest(labReq);
            JOptionPane.showMessageDialog(null, "Lab Result submitted successfully!", "Warning", JOptionPane.WARNING_MESSAGE);

        }else{
            JOptionPane.showMessageDialog(null, error, "Warning", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnFail;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JRadioButton btnSuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDetail;
    private javax.swing.JTextField txtPatient;
    private javax.swing.JTextField txtTest;
    private javax.swing.JTextField txtVac;
    // End of variables declaration//GEN-END:variables
}
