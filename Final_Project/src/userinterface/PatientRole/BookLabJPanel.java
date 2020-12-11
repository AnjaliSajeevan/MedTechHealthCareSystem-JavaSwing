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
import java.awt.Color;
import java.awt.Font;
import static java.lang.Boolean.TRUE;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
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

    
         slotTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,15));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        UIManager.put("slotTable.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(0,102,102));
         headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < slotTable.getModel().getColumnCount(); i++) {
            slotTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        slotTable.setShowGrid(true);
        slotTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
    
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        UIManager.put("labTestingTable.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer1.setBackground(new Color(0,102,102));
         headerRenderer1.setForeground(Color.WHITE);

        for (int i = 0; i < labTestingTable.getModel().getColumnCount(); i++) {
            labTestingTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        labTestingTable.setShowGrid(true);
        labTestingTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
        
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
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/left_50px.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Select Laboratory:");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("LAB APPOINTMENT BOOKING");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Services and Available Slots");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        serviceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Choose Service:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Showing Next Week Available Slots:");

        slotTable.setBackground(new java.awt.Color(99, 171, 171));
        slotTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        slotTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        slotTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(slotTable);

        jSeparator1.setBackground(new java.awt.Color(102, 0, 0));

        btnBook.setBackground(new java.awt.Color(0, 0, 0));
        btnBook.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnBook.setText("BOOK LAB APPOINTMENT");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        labTestingTable.setBackground(new java.awt.Color(99, 171, 171));
        labTestingTable.setForeground(new java.awt.Color(255, 255, 255));
        labTestingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        labTestingTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        labTestingTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(labTestingTable);

        btnResults.setBackground(new java.awt.Color(0, 0, 0));
        btnResults.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnResults.setForeground(new java.awt.Color(255, 255, 255));
        btnResults.setText("Display Lab Results");
        btnResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultsActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/5fd2d0e84a02a670752073.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(365, 365, 365)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31)
                                .addComponent(serviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnResults)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton1)
                                .addGap(214, 214, 214))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(serviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResults, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> labComboBox;
    private javax.swing.JTable labTestingTable;
    private javax.swing.JComboBox<String> serviceComboBox;
    private javax.swing.JTable slotTable;
    // End of variables declaration//GEN-END:variables
}
