/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Essentials.Medicine;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClaimWorkRequest;
import Business.WorkQueue.PharmaWorkRequest;
import java.awt.CardLayout;
import java.io.File;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manasa
 */
public class RequestMedicineJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestMedicineJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    UserAccount account;
    String requestInprog;
    Map<Medicine,Integer> medList;
    Double costClaim;
    public RequestMedicineJPanel(JPanel userProcessContainer, UserAccount account,Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        requestInprog = "";
        medList = new HashMap<Medicine,Integer>();
        populatePharmacies();
        lblTot.setVisible(false);
    }
    public void populatePharmacies(){
        pharmacyComboBox.removeAllItems();
        for (Network network : business.getNetworkList()){
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
        String pwdRegex = ".*Pharmacy.*";
            Pattern pwdPattern = Pattern.compile(pwdRegex);
            Matcher pwdCheck = pwdPattern.matcher(enterprise.toString());
            boolean checkPwd = pwdCheck.matches();
            if(checkPwd == TRUE){
                pharmacyComboBox.addItem(enterprise.toString());      
        }
        }
        }
    }
    public void populateMedReqTable(){
                 DefaultTableModel model = (DefaultTableModel)medReqTable.getModel();
        model.setRowCount(0);
        int sum = 0;
      for (Map.Entry<Medicine,Integer> medicine : medList.entrySet()) {  

              
                    Object[] row = new Object[5];
                    row[0] = medicine.getKey();
                    row[1] = ((medicine.getKey().getPrice()) * (medicine.getValue()));
                    sum+= (Double)((medicine.getKey().getPrice()) * (medicine.getValue()));
                    row[2] = medicine.getValue();

                    model.addRow(row);                    
    
      }
      lblTot.setText("Total Price :"+sum);
      costClaim=Double.valueOf(sum);
      lblTot.setVisible(true);
    }
   public void populatePatientRequests(){
        DefaultTableModel model = (DefaultTableModel)respTable.getModel();
        model.setRowCount(0);
        List<PharmaWorkRequest> requestList = business.getPharmaQueue().getPharmaList();
        for(PharmaWorkRequest req: requestList){
            if(req.getCust().equals(account)){
            String medList1 = "";
                Map<Medicine,Integer> medMap= req.getMedList();
                for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {  
                    if(medList1.equals("")){
                        medList1+=medicine.getKey();
                    }else{    
                        medList1+=","+medicine.getKey();
                  }
                } 
                    Map<String,Date> map = req.getStatusMap();
                    String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : req.getStatusMap().entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0){
                    latestKey = mapEntry.getKey();
                }
               }
             Object row[] = new Object[8];
                 row[0] = req;
                 row[1] = medList1;   
                 row[2] = latestKey;
                 row[3] = req.getMessage();
                 if(req.getSender() == null){
                 row[4] = account;    
                 }else{
                 row[4] = req.getSender();
                 }
                 model.addRow(row); 
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

        btnBack = new javax.swing.JButton();
        pharmacyComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnDisplayMed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        medTable = new javax.swing.JTable();
        quant = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        medReqTable = new javax.swing.JTable();
        btnSendMed = new javax.swing.JButton();
        lblTot = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        txtPres = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        respTable = new javax.swing.JTable();
        btnTrack = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        modQuant = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        btnBack.setText("<-Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        pharmacyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Pharmacy:");

        jLabel1.setText("Medicine Request");

        btnDisplayMed.setText("Display Medicines");
        btnDisplayMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayMedActionPerformed(evt);
            }
        });

        medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Medicine", "Price", "Dose(milligrams)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(medTable);

        quant.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel3.setText("Quantity");

        btnCart.setText("ADD TO CART");
        btnCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartActionPerformed(evt);
            }
        });

        medReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Medicine", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(medReqTable);

        btnSendMed.setText("SEND MEDICINE REQUEST");
        btnSendMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMedActionPerformed(evt);
            }
        });

        lblTot.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblTot.setForeground(new java.awt.Color(102, 0, 153));
        lblTot.setText("Total Price: ");

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload Prescription");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        respTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PharmacyID", "Medicine", "Message", "DeliveryStaff"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(respTable);

        btnTrack.setText("Track Medicine Requests");
        btnTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackActionPerformed(evt);
            }
        });

        btnMod.setText("Modify Quantity");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        modQuant.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel4.setText("Quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpload)
                                    .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSendMed, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMod))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemove)
                                .addGap(105, 105, 105)
                                .addComponent(lblTot, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(modQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCart)
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(pharmacyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnDisplayMed, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pharmacyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(btnDisplayMed, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCart)
                    .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTot, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemove))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpload))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSendMed, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMod)))
                .addGap(18, 18, 18)
                .addComponent(btnTrack, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDisplayMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayMedActionPerformed
        // TODO add your handling code here:

        if(pharmacyComboBox.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please choose a Pharmacy to display medicine list!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel)medTable.getModel();
        model.setRowCount(0);
        for (Network network : business.getNetworkList()){
            for (Enterprise enterpriseCheck : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterpriseCheck.getName().equals(pharmacyComboBox.getSelectedItem().toString())){
                    PharmacyEnterprise pharmaE = (PharmacyEnterprise) enterpriseCheck;
                    for(Medicine med:pharmaE.getMedicineCatalog().getMedicineList()){
                        Object[] row = new Object[5];
                        row[0] = med;
                        row[1] = med.getPrice();
                        row[2] = med.getDosage();

                        model.addRow(row);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnDisplayMedActionPerformed

    private void btnCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartActionPerformed
        // TODO add your handling code here:
        if(!requestInprog.equals("")){
            if(!requestInprog.equals(pharmacyComboBox.getSelectedItem().toString())){
                if(!medList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You already have medicines of other pharmacy in the cart.\n Cannot place medicine request on multiple pharmacies at a time.\n Please send the existing request and then add other pharmacy request.","Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

            }
        }
        int rows = medTable.getSelectedRow();
        if(rows <0){
            JOptionPane.showMessageDialog(null,"Selected one medicine at a time to send pharmacy request", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int quantity = (Integer)quant.getValue();
        if(quantity <= 0){
            JOptionPane.showMessageDialog(null,"Quantity of desired medicine cannot be less than or equal to zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Medicine med = (Medicine) medTable.getValueAt(rows, 0);
        if((!(med.getName().equals(""))) || (!(quantity > 0))){
            medList.put(med,quantity);
        }
        requestInprog = pharmacyComboBox.getSelectedItem().toString();
        populateMedReqTable();

    }//GEN-LAST:event_btnCartActionPerformed

    private void btnSendMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMedActionPerformed
        // TODO add your handling code here:
        if(medList.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please add medicines required from the desired Pharmacy options", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(txtPres.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Uploading prescription is mandatory!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PharmaWorkRequest pharmaReq = new PharmaWorkRequest();
        pharmaReq.setEnterprise(pharmacyComboBox.getSelectedItem().toString());
        pharmaReq.setPatient(account.getEmployee().getName());
        pharmaReq.setCust(account);
        pharmaReq.setSender(account);
        Map<String,Date> reqMap = pharmaReq.getStatusMap();
        reqMap.put("Medicine Request Created", new Date());
        pharmaReq.setStatusMap(reqMap);
        boolean covidCond = false;
        for (Map.Entry<Medicine,Integer> medicine : medList.entrySet()) {
            if(medicine.getKey().getCondition().equals("Covid")){
                covidCond = true;
            }
        }
        if(covidCond == true){
            pharmaReq.setCondition("Covid");
        }else{
            pharmaReq.setCondition("Not Covid");
        }
        for (Map.Entry<Medicine,Integer> medicine : medList.entrySet()) {
            pharmaReq.updateMedList(medicine.getKey(),medicine.getValue());
        }
        for (Network network : business.getNetworkList()){
            for (Enterprise enterpriseCheck : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterpriseCheck.getName().equals(pharmacyComboBox.getSelectedItem().toString())){
                    for (UserAccount ua : enterpriseCheck.getUserAccountDirectory().getUserAccountList()) {
                        if(ua.getRole().toString().equals("PharmacyAdmin")){
                            reqMap.put("Request Sent to Admin", new Date());
                            pharmaReq.setStatusMap(reqMap);
                            ua.getPharmaWorkQueue().addPharmaRequest(pharmaReq);
                            business.getPharmaQueue().addPharmaRequest(pharmaReq);
                        }
                    }

                }
            }
        }

        medList.clear();
        requestInprog = "";
        populateMedReqTable();
        lblTot.setVisible(false);
        JOptionPane.showMessageDialog(null,"Pharmacy Request successuly submitted!", "Warning", JOptionPane.WARNING_MESSAGE);

        Patient patient1 = null;
        String pat= account.getUsername();
        for(Patient p:business.getPatientDirectory().getpatientlist())
        {if (p.getUserName().equals(pat)){
            patient1=p;
        }
        }
        
              
        ClaimWorkRequest r = new ClaimWorkRequest();
        r.setSender(account);
        r.setPatient(patient1);
        r.setRequestDate(new Date());
        r.setCost(costClaim);
        r.setStatus("Claim Requested");
        r.setInsurancepolicy(patient1.getInsurance());
        r.setHospital(enterprise);
        
        business.getClaimWorkQueue().getWorkRequestList().add(r);
        account.getClaimWorkQueue().getWorkRequestList().add(r);
    }//GEN-LAST:event_btnSendMedActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int rows = medReqTable.getSelectedRowCount();
        if(rows <= 0){
            JOptionPane.showMessageDialog(null,"Select the medicine to be removed!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Medicine med = (Medicine) medTable.getValueAt(rows, 0);
        medList.remove(med);
        populateMedReqTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChoose = new JFileChooser();
        fileChoose.showOpenDialog(null);
        File photoFile = fileChoose.getSelectedFile();
        String filename = photoFile.getAbsolutePath();
        if(!((filename.toLowerCase().endsWith(".jpg")) || !(filename.toLowerCase().endsWith(".pdf")) || (filename.toLowerCase().endsWith(".png"))|| (filename.toLowerCase().endsWith(".gif")) || (filename.toLowerCase().endsWith(".jpeg")))){
            JOptionPane.showMessageDialog(null,"Photo upload must be of file type .jpg .gif .png .pdf or .jpeg only");
        }else{
            txtPres.setText(filename);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackActionPerformed
        // TODO add your handling code here:
        populatePatientRequests();
    }//GEN-LAST:event_btnTrackActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        // TODO add your handling code here:
        int rows = medReqTable.getSelectedRow();
        if(rows < 0){
            JOptionPane.showMessageDialog(null,"Select the medicine to modify quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int quantity = (Integer)modQuant.getValue();
        if(quantity <= 0){
            JOptionPane.showMessageDialog(null,"Quantity of desired medicine cannot be less than or equal to zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Medicine med = (Medicine) medReqTable.getValueAt(rows, 0);
        for (Map.Entry<Medicine,Integer> medicine : medList.entrySet()) {
            if(medicine.getKey().getName().equals(med.getName())){

            }
        }
        medList.put(med,quantity);
        populateMedReqTable();
    }//GEN-LAST:event_btnModActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnDisplayMed;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSendMed;
    private javax.swing.JButton btnTrack;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTot;
    private javax.swing.JTable medReqTable;
    private javax.swing.JTable medTable;
    private javax.swing.JSpinner modQuant;
    private javax.swing.JComboBox<String> pharmacyComboBox;
    private javax.swing.JSpinner quant;
    private javax.swing.JTable respTable;
    private javax.swing.JTextField txtPres;
    // End of variables declaration//GEN-END:variables
}
