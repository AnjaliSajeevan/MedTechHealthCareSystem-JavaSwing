/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Network.Network;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabPatientWorkRequest;
import java.awt.CardLayout;
import static java.lang.Boolean.TRUE;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manasa
 */
public class BookLabJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookLabJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    UserAccount account;
    Patient patient;
    String policy;
    InsurancePolicy Insurancepolicy;
    public BookLabJPanel(JPanel userProcessContainer, UserAccount account,Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        labComboBox.removeAllItems();
        serviceComboBox.removeAllItems();
        populateLabs();
    }
    public void populateLabs(){
        labComboBox.removeAllItems();
//        for (Network network : business.getNetworkList()){
//        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
//        String pwdRegex = ".*Laboratory.*";
//            Pattern pwdPattern = Pattern.compile(pwdRegex);
//            Matcher pwdCheck = pwdPattern.matcher(enterprise.toString());
//            boolean checkPwd = pwdCheck.matches();
//            if(checkPwd == TRUE){
//                labComboBox.addItem(enterprise.toString());      
//        }
//        }
//        }
    String patientName = account.getUsername();
        for (Patient p : business.getPatientDirectory().getpatientlist()) {

            if (p.getUserName().equals(patientName)) {
                patient = p;
            }
        }
        
        Insurancepolicy = patient.getInsurance();
        System.out.print(Insurancepolicy);
        policy = Insurancepolicy.toString();
        
        for (InsurancePolicy a: business.getInsurancePolicyDirectory().getInsurancePolicyList())
   {    
   
       if(a.getPolicyName().equalsIgnoreCase(policy))
       {for (int counter = 0; counter < a.getLaboratoryList().size(); counter++) {
            
                    labComboBox.addItem(a.getLaboratoryList().get(counter));
                }
       
               }
   }
    }
    
    
    
    
    public void populateServices(LabEnterprise e){
                serviceComboBox.removeAllItems();
      List<String> services = e.getServices();
         for(String service : services){
          serviceComboBox.addItem(service);
         }
    }
        public void populateSlots(LabEnterprise e){
        DefaultTableModel model = (DefaultTableModel)slotTable.getModel();
        model.setRowCount(0);
      Map<String,String> slots = e.getTimeSlot();
            for (Map.Entry<String,String> slot : slots.entrySet()) {  
                if(slot.getValue().equals("false")){
                    Object[] row = new Object[5];
                    String [] slotDet =  slot.getKey().split(",");
                    row[0] = slotDet[0];
                    row[1] = slotDet[1];

                    model.addRow(row);    
                }
         }
    }
         public void populateTestingTable(){
        DefaultTableModel model = (DefaultTableModel)labTestingTable.getModel();
        model.setRowCount(0);
        for(LabPatientWorkRequest work : account.getLabPatientWorkQueue().getLabPatientRequestList()){
                 Map<String,Date> map = work.getStatusMap();
                String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : map.entrySet()) {  
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        labComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        serviceComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        slotTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnBook = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        labTestingTable = new javax.swing.JTable();
        btnResults = new javax.swing.JButton();

        btnBack.setText("<-Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Select Laboratory");

        jLabel1.setText("Lab Appointment Booking");

        jButton1.setText("View Services and Available Slots");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        serviceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Choose Service:");

        jLabel2.setText("Showing Next Week Available Slots:");

        slotTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Day", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(slotTable);

        jSeparator1.setBackground(new java.awt.Color(102, 0, 0));

        btnBook.setText("BOOK LAB APPOINTMENT");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
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
        jScrollPane2.setViewportView(labTestingTable);

        btnResults.setText("Display Lab Results");
        btnResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(serviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jButton1)))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnResults)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnResults)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(labComboBox.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please select a Laboratory to check slots and services!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        LabEnterprise labEnterpise = null;
        for (Network network : business.getNetworkList()){
            for (Enterprise enterpriseCheck : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterpriseCheck.getName().equals(labComboBox.getSelectedItem().toString())){
                    labEnterpise = (LabEnterprise) enterpriseCheck;
                }
            }
        }
        if(labEnterpise!=null){
            populateServices(labEnterpise);
            populateSlots(labEnterpise);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        if(serviceComboBox.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Service Selection is mandatory!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int rows = slotTable.getSelectedRowCount();
        if(rows <= 0){
            JOptionPane.showMessageDialog(null,"Selecting one time slot is mandatory!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(rows >1){
            JOptionPane.showMessageDialog(null,"Please select only one slot!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String slotDate = (String) slotTable.getValueAt(rows, 0);
        String slotTime = (String) slotTable.getValueAt(rows, 1);
        LabPatientWorkRequest request = new LabPatientWorkRequest();
        request.setEnterprise(labComboBox.getSelectedItem().toString());
        request.setPatient(account);
        request.setSender(account);
        request.setLabTestType(serviceComboBox.getSelectedItem().toString());
        request.setSlotDate(slotDate);
        request.setSlotTime(slotTime);
        request.setCovidCase(false);
        Map<String,Date> reqMap = request.getStatusMap();
        reqMap.put("Appointment for "+serviceComboBox.getSelectedItem().toString()+"in "+labComboBox.getSelectedItem().toString()+" created!", new Date());
        request.setStatusMap(reqMap);
        for (Network network : business.getNetworkList()){
            for (Enterprise enterpriseCheck : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterpriseCheck.getName().equals(labComboBox.getSelectedItem().toString())){
                    LabEnterprise e = (LabEnterprise) enterpriseCheck;
                    Map<String,String> slots = e.getTimeSlot();
                    slots.put(slotDate+","+slotTime, "true");
                    e.setTimeSlot(slots);
                    for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                        if(ua.getRole().toString().equals("LabAdmin")){
                            reqMap.put("Request Sent to Laboratory Admin:"+ua, new Date());
                            request.setStatusMap(reqMap);
                            ua.getLabPatientWorkQueue().addLabPatientRequest(request);
                            business.getLabPatQueue().addLabPatientRequest(request);
                        }
                    }
                }
            }
        }
    account.getLabPatientWorkQueue().addLabPatientRequest(request);
        JOptionPane.showMessageDialog(null,"Booked Lab appointment successfully!", "Warning", JOptionPane.WARNING_MESSAGE);
        LabEnterprise labEnterpise = null;
        for (Network network : business.getNetworkList()){
            for (Enterprise enterpriseCheck : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterpriseCheck.getName().equals(labComboBox.getSelectedItem().toString())){
                    labEnterpise = (LabEnterprise) enterpriseCheck;
                }
            }
        }
        populateSlots(labEnterpise);
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultsActionPerformed
        // TODO add your handling code here:
        populateTestingTable();
    }//GEN-LAST:event_btnResultsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnResults;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> labComboBox;
    private javax.swing.JTable labTestingTable;
    private javax.swing.JComboBox<String> serviceComboBox;
    private javax.swing.JTable slotTable;
    // End of variables declaration//GEN-END:variables
}
