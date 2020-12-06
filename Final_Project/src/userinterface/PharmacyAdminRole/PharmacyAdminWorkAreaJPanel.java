/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Essentials.Medicine;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkQueue.PharmaWorkRequest;
import Business.WorkQueue.VaccineWorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.AdministrativeRole.ManageEmployeeJPanel;
import userinterface.AdministrativeRole.ManageOrganizationJPanel;
import userinterface.AdministrativeRole.ManageUserAccountJPanel;
import userinterface.VaccineScientistRole.ViewVaccineJPanel;

/**
 *
 * @author Manasa
 */
public class PharmacyAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyAdminWorkAreaJPanel
     */

    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    UserAccount account;
    PharmacyOrganization organization;
    public PharmacyAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PharmacyOrganization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = organization;
        valueLabel.setText(enterprise.getName());
        populateNewMedTable();
        populatePatientRequests();
        populateDeliv();

    }
    public void populateNewMedTable(){
              DefaultTableModel model = (DefaultTableModel)vaccineRequestTable.getModel();
        model.setRowCount(0);
        List<VaccineWorkRequest> requestList = account.getVaccineWorkQueue().getVaccineRequestList();
        for(VaccineWorkRequest req: requestList){

            Object row[] = new Object[5];
                 row[0] = req;
                 row[1] = req.getVaccine();
                 row[2] = req.getVaccine().getCondition();
                 row[3] = req.getResolveDate();          
                 model.addRow(row); 
            }
        
    
    }
    public void populatePatientRequests(){
                      DefaultTableModel model = (DefaultTableModel)medicineTable1.getModel();
        model.setRowCount(0);
        List<PharmaWorkRequest> requestList = account.getPharmaWorkQueue().getPharmaList();
        for(PharmaWorkRequest req: requestList){
            String medList = "";
                Map<Medicine,Integer> medMap= req.getMedList();
                for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {  
                    if(medList.equals("")){
                        medList+=medicine.getKey();
                    }else{    
                        medList+=","+medicine.getKey();
                  }
                } 
             Object row[] = new Object[8];
                 row[0] = req;
                 row[1] = req.getSender().getUsername();              
                 row[2] = medList;
                 row[3] = req.getCreateDate();
                 row[4] = req.getCondition();
                 model.addRow(row); 
            }
    }
    public void populateDeliv(){
        delivComboBox.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                if(ua.getRole().toString().equals("DeliveryMan")){
                delivComboBox.addItem(ua);
                }
            }
        }
    }
    public void populateAllRecords(){
               DefaultTableModel model = (DefaultTableModel)respTable.getModel();
        model.setRowCount(0);
        List<PharmaWorkRequest> requestList = business.getPharmaQueue().getPharmaList();
        for(PharmaWorkRequest req: requestList){
            if(req.getEnterprise().equals(enterprise.getName())){
                            String medList = "";
                Map<Medicine,Integer> medMap= req.getMedList();
                for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {  
                    if(medList.equals("")){
                        medList+=medicine.getKey();
                    }else{    
                        medList+=","+medicine.getKey();
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
            Object row[] = new Object[9];
                         row[0] = req;
                 row[1] = req.getSender().getUsername();              
                 row[2] = medList;
                 row[3] = req.getCreateDate();
                 row[4] = req.getCondition();
                 row[5] = latestKey;

            

            
            model.addRow(row);    
            }
        }
    }
    public void populateTimeline(String pharma){
        if(pharma.isEmpty()){
          DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);         
        }else{
            PharmaWorkRequest p = null;
                  List<PharmaWorkRequest> requestList = business.getPharmaQueue().getPharmaList();
        for(PharmaWorkRequest req: requestList){
            if(req.toString().equals(pharma)){
                p = req;
            }
        }  
        if(p!=null){
           DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);
           Map<String,Date> map = p.getStatusMap();
            String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : p.getStatusMap().entrySet()) {
                            Object row[] = new Object[5];
                 row[0] = mapEntry.getKey();
                 row[1] = mapEntry.getValue();
                  model.addRow(row); 
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

        jLabel2 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        manageEmployeeJButton1 = new javax.swing.JButton();
        userJButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnReport = new javax.swing.JButton();
        btnAddMed = new javax.swing.JButton();
        manageOrganizationJButton1 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        vaccineRequestTable = new javax.swing.JTable();
        btnAddSupply = new javax.swing.JButton();
        btnVaccine = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicineTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btnProcess = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        delivComboBox = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        respTable = new javax.swing.JTable();
        btnRecord = new javax.swing.JButton();
        btnTime = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        timelineTable = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Pharmacy Admin");

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setText("<value>");

        manageEmployeeJButton1.setText("Manage Employee");
        manageEmployeeJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButton1ActionPerformed(evt);
            }
        });

        userJButton1.setText("Manage User");
        userJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButton1ActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(102, 0, 0));

        btnReport.setText("Display Pharmacy Reports");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        btnAddMed.setText("Manage Medicine Supplies");
        btnAddMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedActionPerformed(evt);
            }
        });

        manageOrganizationJButton1.setText("Manage Organization");
        manageOrganizationJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButton1ActionPerformed(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(102, 0, 0));

        jLabel6.setText("New Medicine Requests:");

        vaccineRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "RequestID", "Medicine", "Type", "ApproveDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(vaccineRequestTable);

        btnAddSupply.setText("Add to Supply");
        btnAddSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplyActionPerformed(evt);
            }
        });

        btnVaccine.setText("View Vaccine contents");
        btnVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineActionPerformed(evt);
            }
        });

        medicineTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "RequestID", "PatientName", "Medicine", "RequestDate", "CovidCondition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(medicineTable1);

        jLabel8.setText("Patient Medicine Requests:");

        jSeparator5.setBackground(new java.awt.Color(102, 0, 0));

        btnProcess.setText("Process Request");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnCheck.setText("CheckAvailability");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        jLabel7.setText("DeliveryMan");

        delivComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivComboBoxActionPerformed(evt);
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
                "RequestID", "PatientName", "Medicine", "RequestDate", "CovidCondition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(respTable);

        btnRecord.setText("View Pharmacy Records");
        btnRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordActionPerformed(evt);
            }
        });

        btnTime.setText("View Timeline");
        btnTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeActionPerformed(evt);
            }
        });

        timelineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(timelineTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delivComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnAddMed, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(manageOrganizationJButton1)
                                .addGap(53, 53, 53)
                                .addComponent(manageEmployeeJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(userJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(btnAddSupply)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVaccine))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel)
                    .addComponent(valueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manageOrganizationJButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userJButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageEmployeeJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMed, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSupply, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(delivComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTime)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageEmployeeJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButton1ActionPerformed

        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeeJButton1ActionPerformed

    private void userJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButton1ActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise,business);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButton1ActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnAddMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedActionPerformed
        // TODO add your handling code here:
        ManageMedicineJPanel mngMedJPanel=new ManageMedicineJPanel(userProcessContainer,enterprise,business);
        userProcessContainer.add("mngMedJPanel",mngMedJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddMedActionPerformed

    private void manageOrganizationJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButton1ActionPerformed

        ManageOrganizationJPanel managePharmacyOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),"Pharmacy Organization");
        userProcessContainer.add("managePharmacyOrganizationJPanel", managePharmacyOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButton1ActionPerformed

    private void btnAddSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplyActionPerformed
        // TODO add your handling code here:
        int selectedRow = vaccineRequestTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vaccine vaccine= (Vaccine)vaccineRequestTable.getValueAt(selectedRow, 1);
        VaccineWorkRequest vaccineReq= (VaccineWorkRequest)vaccineRequestTable.getValueAt(selectedRow, 0);
        account.getVaccineWorkQueue().removeWorkRequest(vaccineReq);
        ManageMedicineJPanel mngMedJPanel=new ManageMedicineJPanel(userProcessContainer,enterprise,business,vaccine.getName(),vaccine.getCondition());
        userProcessContainer.add("mngMedJPanel",mngMedJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddSupplyActionPerformed

    private void btnVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineActionPerformed
        // TODO add your handling code here:
        int selectedRow = vaccineRequestTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Medicine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vaccine vaccine= (Vaccine)vaccineRequestTable.getValueAt(selectedRow, 1);

        ViewVaccineJPanel viewVaccineJPanel=new ViewVaccineJPanel(userProcessContainer,account,business,vaccine,false);
        userProcessContainer.add("viewVaccineJPanel",viewVaccineJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnVaccineActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        UserAccount patient = null;
        UserAccount deliv = null;
        int selectedRow = medicineTable1.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Medicine Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String stockOutMed = "";
        PharmacyEnterprise pharma = (PharmacyEnterprise) enterprise;
        PharmaWorkRequest pharmaRequest= (PharmaWorkRequest)medicineTable1.getValueAt(selectedRow, 0);
        if(pharmaRequest.getCondition().equals("Covid")){
            if(delivComboBox.getSelectedItem().toString().equals("")){
                JOptionPane.showMessageDialog(null, "Handling Covid case, Delivery staff selection is mandatory!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        Map<Medicine,Integer> medMap = pharmaRequest.getMedList();
        patient= pharmaRequest.getSender();
        for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {
            for(Medicine m: pharma.getMedicineCatalog().getMedicineList())        {
                if(medicine.getKey().getName().equals(m.getName())){
                    if(m.getQuantity() < medicine.getValue()){
                        int dem = (m.getDemand() + medicine.getValue());
                        m.setDemand(dem);
                        pharma.getMedicineCatalog().updateMedicine(m);
                        if(stockOutMed.equals("")){
                            stockOutMed=m.getName();
                        }else{
                            stockOutMed+=","+m.getName();
                        }
                    }else{
                        int quant = (m.getQuantity() - medicine.getValue());
                        m.setQuantity(quant);
                        pharma.getMedicineCatalog().updateMedicine(m);
                    }
                }
            }
        }
        String message = "";
        if(stockOutMed.equals("")){

            JOptionPane.showMessageDialog(null, "All Medicines are in Stock!", "Information", JOptionPane.INFORMATION_MESSAGE);
            if(pharmaRequest.getCondition().equals("Covid")){
                message = "Medicines in stock and reserved.\n DeliveryStaff: "+delivComboBox.getSelectedItem().toString()+" will deliver at the earliest" ;
            }else{
                message = "Medicines in stock and reserved.\n Please pickup from pharmacy at the earliest!" ;
            }
            pharmaRequest.setSender(null);
        }else{
            JOptionPane.showMessageDialog(null, "Please fill up Medicines - OutOfStock -"+stockOutMed, "Information", JOptionPane.INFORMATION_MESSAGE);
            Date future = new Date();
            future.setDate(future.getDate()+10);
            if(pharmaRequest.getCondition().equals("Covid")){
                message = "Medicines currently OutOfStock.\n DeliveryStaff: "+delivComboBox.getSelectedItem().toString()+" will deliver anyday after"+future ;
            }else{
                message = "Medicines currently OutOfStock.\nPlease pickup from pharmacy anyday after"+future ;
            }
            for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
                for (UserAccount ua1 : organization1.getUserAccountDirectory().getUserAccountList()) {
                    if(ua1.getUsername().equals(delivComboBox.getSelectedItem().toString())){
                        pharmaRequest.setSender(ua1);
                        deliv = ua1;
                    }
                }
            }

        }
        Map<String,Date> reqMap = pharmaRequest.getStatusMap();
        reqMap.put(message, new Date());
        pharmaRequest.setStatusMap(reqMap);
        pharmaRequest.setReceiver(patient);
        //    pharmaRequest.setSender(account);
        pharmaRequest.setMessage(message);
        if(deliv!=null){
            deliv.getPharmaWorkQueue().removePharmaRequest(pharmaRequest);
        }
        patient.getPharmaWorkQueue().addPharmaRequest(pharmaRequest);
        account.getPharmaWorkQueue().removePharmaRequest(pharmaRequest);
        business.getPharmaQueue().updatePharmaRequest(pharmaRequest, business.getPharmaQueue().getPharmaList());
        populatePatientRequests();
        JOptionPane.showMessageDialog(null, message+"\nMessage sent to Patient!", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        String stockOutMed = "";
        int selectedRow = medicineTable1.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Medicine Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PharmacyEnterprise pharma = (PharmacyEnterprise) enterprise;
        PharmaWorkRequest pharmaRequest= (PharmaWorkRequest)medicineTable1.getValueAt(selectedRow, 0);
        Map<Medicine,Integer> medMap = pharmaRequest.getMedList();

        for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {
            for(Medicine m: pharma.getMedicineCatalog().getMedicineList())        {
                if(medicine.getKey().getName().equals(m.getName())){
                    if(m.getQuantity() < medicine.getValue()){
                        if(stockOutMed.equals("")){
                            stockOutMed=m.getName();
                        }else{
                            stockOutMed+=","+m.getName();
                        }
                    }
                }
            }
        }
        if(stockOutMed.equals("")){
            JOptionPane.showMessageDialog(null, "All Medicines are in Stock!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Please fill up Medicines - OutOfStock -"+stockOutMed, "Information", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void delivComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivComboBoxActionPerformed

    private void btnTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeActionPerformed
        // TODO add your handling code here:
        int selectedRow = respTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PharmaWorkRequest pharma= (PharmaWorkRequest)respTable.getValueAt(selectedRow, 0);

        populateTimeline(pharma.toString());
    }//GEN-LAST:event_btnTimeActionPerformed

    private void btnRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordActionPerformed
        // TODO add your handling code here:
        populateAllRecords();
        populateTimeline("");
    }//GEN-LAST:event_btnRecordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMed;
    private javax.swing.JButton btnAddSupply;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnRecord;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnTime;
    private javax.swing.JButton btnVaccine;
    private javax.swing.JComboBox delivComboBox;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton manageEmployeeJButton1;
    private javax.swing.JButton manageOrganizationJButton1;
    private javax.swing.JTable medicineTable1;
    private javax.swing.JTable respTable;
    private javax.swing.JTable timelineTable;
    private javax.swing.JButton userJButton1;
    private javax.swing.JTable vaccineRequestTable;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
