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
import Business.InsurancePolicy.InsurancePolicy;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClaimWorkRequest;
import Business.WorkQueue.PharmaWorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
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
import javax.swing.table.DefaultTableCellRenderer;
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
    Patient patient;
    String policy;
    InsurancePolicy Insurancepolicy;
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
                          DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.BLACK);
         headerRenderer.setForeground(java.awt.Color.WHITE);

        for (int i = 0; i < medTable.getModel().getColumnCount(); i++) {
            medTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        medTable.setShowGrid(true);
       medTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));

        for (int i = 0; i < medReqTable.getModel().getColumnCount(); i++) {
            medReqTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        medReqTable.setShowGrid(true);
       medReqTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
               for (int i = 0; i < respTable.getModel().getColumnCount(); i++) {
            respTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        respTable.setShowGrid(true);
       respTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
    }
    public void populatePharmacies(){
        pharmacyComboBox.removeAllItems();
//        for (Network network : business.getNetworkList()){
//        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
//        String pwdRegex = ".*Pharmacy.*";
//            Pattern pwdPattern = Pattern.compile(pwdRegex);
//            Matcher pwdCheck = pwdPattern.matcher(enterprise.toString());
//            boolean checkPwd = pwdCheck.matches();
//            if(checkPwd == TRUE){
//                pharmacyComboBox.addItem(enterprise.toString());      
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
       {for (int counter = 0; counter < a.getPharmacyList().size(); counter++) {
            
                    pharmacyComboBox.addItem(a.getPharmacyList().get(counter));
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
                 if(req.getSender() == null){
                 row[2] = "In-Person";  
                 }else{
                 row[2] = req.getSender();
                 }
                 row[3] = latestKey;
                 row[4] = req.getMessage();
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
        jLabel1 = new javax.swing.JLabel();
        btnDisplayMed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        medTable = new javax.swing.JTable();
        quant = new javax.swing.JSpinner();
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
        lblCond = new javax.swing.JLabel();
        lblCond1 = new javax.swing.JLabel();
        lblCond2 = new javax.swing.JLabel();
        lblCond3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/backIcon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        pharmacyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Medicine Request");

        btnDisplayMed.setBackground(new java.awt.Color(0, 0, 51));
        btnDisplayMed.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnDisplayMed.setForeground(new java.awt.Color(255, 255, 255));
        btnDisplayMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/pharma.png"))); // NOI18N
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

        btnCart.setBackground(new java.awt.Color(0, 0, 51));
        btnCart.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnCart.setForeground(new java.awt.Color(255, 255, 255));
        btnCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/product.png"))); // NOI18N
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

        btnSendMed.setBackground(new java.awt.Color(0, 0, 51));
        btnSendMed.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnSendMed.setForeground(new java.awt.Color(255, 255, 255));
        btnSendMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/services.png"))); // NOI18N
        btnSendMed.setText("SEND MEDICINE REQUEST");
        btnSendMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMedActionPerformed(evt);
            }
        });

        lblTot.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblTot.setForeground(new java.awt.Color(102, 0, 153));
        lblTot.setText("Total Price: ");

        btnRemove.setBackground(new java.awt.Color(0, 0, 51));
        btnRemove.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/removeservice.png"))); // NOI18N
        btnRemove.setText("Remove From Cart");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpload.setBackground(new java.awt.Color(0, 0, 51));
        btnUpload.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnUpload.setForeground(new java.awt.Color(255, 255, 255));
        btnUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/add.png"))); // NOI18N
        btnUpload.setText("Upload Prescription");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        respTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PharmacyID", "Medicine", "DeliveryStaff", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(respTable);

        btnTrack.setBackground(new java.awt.Color(0, 0, 51));
        btnTrack.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnTrack.setForeground(new java.awt.Color(255, 255, 255));
        btnTrack.setText("Track Medicine Requests");
        btnTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackActionPerformed(evt);
            }
        });

        btnMod.setBackground(new java.awt.Color(0, 0, 51));
        btnMod.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnMod.setForeground(new java.awt.Color(255, 255, 255));
        btnMod.setText("Modify Quantity");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        modQuant.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblCond.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        lblCond.setForeground(new java.awt.Color(0, 0, 51));
        lblCond.setText("Choose a Pharmacy:");

        lblCond1.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        lblCond1.setForeground(new java.awt.Color(0, 0, 51));
        lblCond1.setText("Modify Quantity:");

        lblCond2.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        lblCond2.setForeground(new java.awt.Color(0, 0, 51));
        lblCond2.setText("Quantity:");

        lblCond3.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        lblCond3.setForeground(new java.awt.Color(0, 0, 51));
        lblCond3.setText("Cart Medicines:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCond, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCond2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pharmacyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDisplayMed)
                        .addGap(165, 165, 165)
                        .addComponent(lblCond3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(220, 220, 220)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(86, 86, 86)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnUpload)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSendMed, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCart)
                                    .addGap(27, 27, 27)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(modQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57)
                                    .addComponent(btnRemove))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(lblTot, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCond, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pharmacyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDisplayMed, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCond3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCond1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnRemove)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTot, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCond2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpload))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnCart)
                                .addGap(43, 43, 43)
                                .addComponent(btnSendMed, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
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
        reqMap.put("New Medicine Request to "+pharmaReq.getEnterprise(), new Date());
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
                            reqMap.put("Request Sent to Admin: "+ua, new Date());
                            pharmaReq.setStatusMap(reqMap);
                            ua.getPharmaWorkQueue().addPharmaRequest(pharmaReq);
                            business.getPharmaQueue().addPharmaRequest(pharmaReq);
                        }
                    }

                }
            }
        }
        account.getPharmaWorkQueue().addPharmaRequest(pharmaReq);
        medList.clear();
        requestInprog = "";
        populateMedReqTable();
        lblTot.setVisible(false);
        txtPres.setText("");
        JOptionPane.showMessageDialog(null,"Pharmacy Request successuly submitted!", "Warning", JOptionPane.WARNING_MESSAGE);

        Patient patient1 = null;
        String pat= account.getUsername();
        for(Patient p:business.getPatientDirectory().getpatientlist())
        {if (p.getUserName().equals(pat)){
            patient1=p;
        }
        }
        String s=(String) pharmacyComboBox.getSelectedItem();
        
       
        ClaimWorkRequest r = new ClaimWorkRequest();
        System.out.println(account);
        
        r.setPatient(patient1);
        r.setRequestDate(new Date());
        r.setCost(150.00);
        r.setStatus("Claim Requested");
        r.setInsurancepolicy(patient1.getInsurance());
        r.setHospital(s);
        r.setInsuranceEnterprise(patient1.getInsurance().getEnterprise());
        r.setInsuranceNo(patient1.getInsuranceOrderNo());
      
       
        
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCond;
    private javax.swing.JLabel lblCond1;
    private javax.swing.JLabel lblCond2;
    private javax.swing.JLabel lblCond3;
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
