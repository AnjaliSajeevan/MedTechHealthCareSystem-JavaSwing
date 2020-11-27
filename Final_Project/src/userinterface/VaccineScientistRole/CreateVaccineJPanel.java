/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineScientistRole;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Manasa
 */
public class CreateVaccineJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVaccineJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem business;  
    public CreateVaccineJPanel(JPanel userProcessContainer, UserAccount account,EcoSystem business ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();
        quantityMinAgeSpinner = new javax.swing.JSpinner();
        quantityMaxAgeSpinner = new javax.swing.JSpinner();
        lblCore = new javax.swing.JLabel();
        txtCore = new javax.swing.JTextField();
        lblAllergens = new javax.swing.JLabel();
        txtAllergens = new javax.swing.JTextField();
        lblCond = new javax.swing.JLabel();
        lblDosage = new javax.swing.JLabel();
        txtPreservations = new javax.swing.JTextField();
        lblPreservation = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSide = new javax.swing.JLabel();
        txtSide = new javax.swing.JTextField();
        txtOther = new javax.swing.JTextField();
        lblOther = new javax.swing.JLabel();
        btnMorning = new javax.swing.JRadioButton();
        btnAfternoon = new javax.swing.JRadioButton();
        btnNight = new javax.swing.JRadioButton();
        mornDosage = new javax.swing.JSpinner();
        afterDosage = new javax.swing.JSpinner();
        nightDosage = new javax.swing.JSpinner();
        lblAdministration = new javax.swing.JLabel();
        btnIntra = new javax.swing.JRadioButton();
        btnPills = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        btnHeart = new javax.swing.JRadioButton();
        btnDiabetes = new javax.swing.JRadioButton();
        btnCovid = new javax.swing.JRadioButton();
        btnResp = new javax.swing.JRadioButton();
        backJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Create Vaccine");

        lblName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblName.setText("Name:");

        lblDesc.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDesc.setText("Description:");

        lblAge.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAge.setText("Age-Group:");

        lblMin.setText("Min :");

        lblMax.setText("Max:");

        quantityMinAgeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        quantityMaxAgeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblCore.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblCore.setText("Core Component:");

        lblAllergens.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAllergens.setText("Any Allergens:");

        lblCond.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblCond.setText("Usage For Condition:");

        lblDosage.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDosage.setText("Dosage:");

        lblPreservation.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPreservation.setText("Preservation instructions:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel13.setText("(in years)");

        lblSide.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblSide.setText("Possible Side Effects:");

        lblOther.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblOther.setText("Other Instructions:");

        btnMorning.setText("Morning");
        btnMorning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMorningActionPerformed(evt);
            }
        });

        btnAfternoon.setText("Afternoon");

        btnNight.setText("Night");

        mornDosage.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        afterDosage.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        nightDosage.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblAdministration.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAdministration.setText("Administration:");

        btnIntra.setText("Intravenous");
        btnIntra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntraActionPerformed(evt);
            }
        });

        btnPills.setText("Pills");
        btnPills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPillsActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(102, 0, 0));

        jLabel10.setText("(milligrams)");

        jLabel21.setText("(milligrams)");

        jLabel22.setText("(milligrams)");

        jSeparator3.setBackground(new java.awt.Color(153, 0, 0));

        btnUpdate.setText("CREATE VACCINE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(102, 0, 0));

        btnHeart.setText("Heart Disease");
        btnHeart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeartActionPerformed(evt);
            }
        });

        btnDiabetes.setText("Diabetes");
        btnDiabetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiabetesActionPerformed(evt);
            }
        });

        btnCovid.setText("Covid");
        btnCovid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCovidActionPerformed(evt);
            }
        });

        btnResp.setText("Respiratory problems");
        btnResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCond)
                                    .addComponent(lblAge)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantityMinAgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMax)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantityMaxAgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnHeart)
                                    .addComponent(btnDiabetes)
                                    .addComponent(btnCovid)
                                    .addComponent(btnResp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAdministration)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnPills)
                                            .addComponent(btnIntra)))
                                    .addComponent(lblDosage)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(btnMorning)
                                            .addGap(12, 12, 12)
                                            .addComponent(mornDosage, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnNight)
                                                .addComponent(btnAfternoon))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(afterDosage, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel21))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(nightDosage, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel22)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblDesc))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAllergens)
                                    .addComponent(lblCore))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAllergens, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCore, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPreservation)
                                            .addComponent(lblSide))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPreservations)
                                            .addComponent(txtSide, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblOther)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOther, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168)
                                .addComponent(jLabel1)))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCore)
                    .addComponent(txtCore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesc)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAllergens)
                    .addComponent(txtAllergens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAdministration)
                                    .addComponent(btnIntra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPills))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAge)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMin)
                            .addComponent(quantityMinAgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMax)
                            .addComponent(quantityMaxAgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDosage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMorning)
                            .addComponent(mornDosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAfternoon)
                            .addComponent(afterDosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNight)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nightDosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCond)
                            .addComponent(btnHeart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDiabetes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCovid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResp)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPreservation)
                        .addGap(17, 17, 17)
                        .addComponent(lblSide)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOther)
                            .addComponent(txtOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPreservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMorningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMorningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMorningActionPerformed

    private void btnIntraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntraActionPerformed
        // TODO add your handling code here:
        btnIntra.setName("Intravenous");
        btnPills.setSelected(false);
    }//GEN-LAST:event_btnIntraActionPerformed

    private void btnPillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPillsActionPerformed
        // TODO add your handling code here:
         btnPills.setName("Pills");
         btnIntra.setSelected(false);
    }//GEN-LAST:event_btnPillsActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        lblName.setForeground(Color.black);
        lblDesc.setForeground(Color.black);
        lblCond.setForeground(Color.black);
        lblPreservation.setForeground(Color.black);
        lblOther.setForeground(Color.black);
        lblCore.setForeground(Color.black);
        lblAllergens.setForeground(Color.black);
        lblDosage.setForeground(Color.black);
        lblAdministration.setForeground(Color.black);
        lblAge.setForeground(Color.black);
        lblSide.setForeground(Color.black);
        lblMax.setForeground(Color.black); 
        lblMin.setForeground(Color.black); 
        
        String error = "";
        if((txtName.getText().equalsIgnoreCase("")) ||
            (txtDesc.getText().equalsIgnoreCase(""))||
            (txtCore.getText().equals(""))||
            (txtAllergens.getText().equalsIgnoreCase(""))||
            (txtOther.getText().equalsIgnoreCase(""))||
            (txtSide.getText().equalsIgnoreCase(""))||
            (txtPreservations.getText().equalsIgnoreCase(""))||
            ((!btnResp.isSelected()) &&(!btnCovid.isSelected()) && (!btnHeart.isSelected()) &&(!btnDiabetes.isSelected()))||
                 ((!btnPills.isSelected()) &&(!btnIntra.isSelected())) ||
                ((!btnMorning.isSelected()) &&(!btnAfternoon.isSelected()) && (!btnNight.isSelected()))
                ){
            error="\nAll the fields are Mandatory!!!";
            //Highligting the unfilled blocks to RED
            if((txtName.getText().equalsIgnoreCase(""))){
                lblName.setForeground(Color.red);
            }
            if((txtPreservations.getText().equalsIgnoreCase(""))){
                lblPreservation.setForeground(Color.red);
            }
            if((txtSide.getText().equalsIgnoreCase(""))){
                lblSide.setForeground(Color.red);
            }
            if((txtOther.getText().equalsIgnoreCase(""))){
                lblOther.setForeground(Color.red);
            }
            if((txtDesc.getText().equalsIgnoreCase(""))){
                lblDesc.setForeground(Color.red);
            }
            if((txtCore.getText().equalsIgnoreCase(""))){
                lblCore.setForeground(Color.red);
            }
            if((txtAllergens.getText().equalsIgnoreCase(""))){
                lblAllergens.setForeground(Color.red);
            }
            if((!btnResp.isSelected()) &&(!btnCovid.isSelected()) && (!btnHeart.isSelected()) &&(!btnDiabetes.isSelected())){
                lblCond.setForeground(Color.red);
            }
            if((!btnPills.isSelected()) &&(!btnIntra.isSelected())){
                lblAdministration.setForeground(Color.red);
            }
            if((!btnMorning.isSelected()) &&(!btnAfternoon.isSelected()) && (!btnNight.isSelected())){
                lblDosage.setForeground(Color.red);
            }
            if(((Integer)quantityMinAgeSpinner.getValue() <= 0) || ((Integer)quantityMaxAgeSpinner.getValue()<=0)){
                lblAge.setForeground(Color.red);
            }

        }
        if(!error.equals("")){
            JOptionPane.showMessageDialog(null,error);
            return;
        }else{
                    int minAge = (Integer)quantityMinAgeSpinner.getValue();
                    int maxAge = (Integer)quantityMaxAgeSpinner.getValue();
        if((minAge <= 0) || (maxAge<=0)){
            if(minAge <= 0){
                lblMin.setForeground(Color.red);
            }else{
               lblMax.setForeground(Color.red); 
            }
            JOptionPane.showMessageDialog(null, "Minimum or Maximum Age For Vaccine usage cannot be zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;          
        }
        
        if(btnMorning.isSelected()) {
             int mornDose = (Integer)mornDosage.getValue();
             if((mornDose <= 0)){

            JOptionPane.showMessageDialog(null, "Morning Dosage Selected!\nDosage for selected time cannot be zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;          
             }
        }
        if(btnAfternoon.isSelected()){
            int aftDose = (Integer)afterDosage.getValue();
             if((aftDose <= 0)){

            JOptionPane.showMessageDialog(null, "Afternoon Dosage Selected!\nDosage for selected time cannot be zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;          
             }
        }
        if(btnNight.isSelected()){
            int nightDose = (Integer)nightDosage.getValue();
             if((nightDose <= 0)){

            JOptionPane.showMessageDialog(null, "Night Dosage Selected!\nDosage for selected time cannot be zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;          
             }
        }
        
        }
        if(!error.equals("")){
            JOptionPane.showMessageDialog(null,error);
        }else{
            Vaccine vaccine = new Vaccine();
            vaccine.setName(txtName.getText());
            vaccine.setDescription(txtDesc.getText());
            vaccine.setCoreComponents(txtCore.getText());
            vaccine.setAllergens(txtAllergens.getText());
            vaccine.setMinAgeGroup((Integer)quantityMinAgeSpinner.getValue());
            vaccine.setMaxAgeGroup((Integer)quantityMaxAgeSpinner.getValue());
            if(btnPills.isSelected()){
                vaccine.setAdministration(btnPills.getName());
            }else{
                vaccine.setAdministration(btnIntra.getName());
            }
            String condition = "";
            if(btnHeart.isSelected()){
                condition=btnHeart.getName();
            }else if(btnCovid.isSelected()){
                condition=btnCovid.getName();
            }else if(btnResp.isSelected()){
                condition=btnResp.getName();
            }else{
                condition=btnDiabetes.getName();
            }
            vaccine.setCondition(condition);
            int dose =0;
            Map<String,Integer> doseMap = vaccine.getDosage();
            if((Integer)mornDosage.getValue()<=0){
                doseMap.put("Morning", dose);
            }else{
            doseMap.put("Morning", (Integer)mornDosage.getValue());
            }
            if((Integer)afterDosage.getValue()<=0){
                doseMap.put("Afternoon", dose);
            }else{
            doseMap.put("Afternoon", (Integer)afterDosage.getValue());
            }
            if((Integer)nightDosage.getValue()<=0){
               doseMap.put("Night", dose);
            }else{
            doseMap.put("Night", (Integer)nightDosage.getValue());
            }
            vaccine.setDosage(doseMap);
            vaccine.setPreservations(txtPreservations.getText());
            vaccine.setSideeffects(txtSide.getText());
            vaccine.setOther(txtOther.getText());
            vaccine.setUpdateDate();
            vaccine.setUsername(account.getUsername());
            business.getVaccineDirectory().addVaccine(vaccine);
            JOptionPane.showMessageDialog(null,"Vaccine Added Successfully!!!");
            btnUpdate.setEnabled(true);
        }           
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHeartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeartActionPerformed
        // TODO add your handling code here:
        btnHeart.setName("Heart");
        btnDiabetes.setSelected(false);
        btnCovid.setSelected(false);
        btnResp.setSelected(false);      
    }//GEN-LAST:event_btnHeartActionPerformed

    private void btnDiabetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiabetesActionPerformed
        // TODO add your handling code here:
        btnDiabetes.setName("Diabetes");
         btnHeart.setSelected(false);
        btnCovid.setSelected(false);
        btnResp.setSelected(false);         
    }//GEN-LAST:event_btnDiabetesActionPerformed

    private void btnCovidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCovidActionPerformed
        // TODO add your handling code here:
        btnCovid.setName("Covid");
        btnDiabetes.setSelected(false);
        btnHeart.setSelected(false);
        btnResp.setSelected(false);  
    }//GEN-LAST:event_btnCovidActionPerformed

    private void btnRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespActionPerformed
        // TODO add your handling code here:
        btnResp.setName("Resp");
        btnDiabetes.setSelected(false);
        btnCovid.setSelected(false);
        btnHeart.setSelected(false);  
    }//GEN-LAST:event_btnRespActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        VaccineScientistWorkAreaJPanel sysAdminwjp = (VaccineScientistWorkAreaJPanel) component;
        sysAdminwjp.populateNewTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner afterDosage;
    private javax.swing.JButton backJButton;
    private javax.swing.JRadioButton btnAfternoon;
    private javax.swing.JRadioButton btnCovid;
    private javax.swing.JRadioButton btnDiabetes;
    private javax.swing.JRadioButton btnHeart;
    private javax.swing.JRadioButton btnIntra;
    private javax.swing.JRadioButton btnMorning;
    private javax.swing.JRadioButton btnNight;
    private javax.swing.JRadioButton btnPills;
    private javax.swing.JRadioButton btnResp;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblAdministration;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAllergens;
    private javax.swing.JLabel lblCond;
    private javax.swing.JLabel lblCore;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDosage;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOther;
    private javax.swing.JLabel lblPreservation;
    private javax.swing.JLabel lblSide;
    private javax.swing.JSpinner mornDosage;
    private javax.swing.JSpinner nightDosage;
    private javax.swing.JSpinner quantityMaxAgeSpinner;
    private javax.swing.JSpinner quantityMinAgeSpinner;
    private javax.swing.JTextField txtAllergens;
    private javax.swing.JTextField txtCore;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOther;
    private javax.swing.JTextField txtPreservations;
    private javax.swing.JTextField txtSide;
    // End of variables declaration//GEN-END:variables
}