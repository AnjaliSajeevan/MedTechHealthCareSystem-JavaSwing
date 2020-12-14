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
import java.awt.Font;
import static java.lang.Boolean.TRUE;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import userinterface.AdministrativeRole.ManageEmployeeJPanel;
import userinterface.AdministrativeRole.ManageOrgJPanel;
import userinterface.AdministrativeRole.ManageOrganizationJPanel;
import userinterface.AdministrativeRole.ManageUserAccountJPanel;
import userinterface.VaccineScientistRole.ViewVaccineJPanel;

/**
 *
 * @author Manasa
 */
public class MedicineRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyAdminWorkAreaJPanel
     */

    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    UserAccount account;
    PharmacyOrganization organization;
    public MedicineRequestsJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = organization;
        lblEnterprise.setText(enterprise.getName());
        lblAccount.setText("Logged in as: "+account.getUsername());
        this.setSize(1466, 902);
                introPanel.setBounds(171, 33, 1293, 101);
        jLabel10.setBounds(1, 1, 160, 113);
        jTabbedPane1.setBounds(1, 115, 1228, 782);
        jPanel2.setSize(1190,600);
        jPanel3.setSize(1190,600);
        populatePatientRequests();
        populateDeliv();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.BLACK);
         headerRenderer.setForeground(java.awt.Color.WHITE);
               for (int i = 0; i < respTable.getModel().getColumnCount(); i++) {
            respTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        respTable.setShowGrid(true);
       respTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
               for (int i = 0; i < medicineTable.getModel().getColumnCount(); i++) {
            medicineTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        medicineTable.setShowGrid(true);
       medicineTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
               for (int i = 0; i < timelineTable.getModel().getColumnCount(); i++) {
            timelineTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
             }
        
            timelineTable.setShowGrid(true);
            timelineTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
       

    }

 private  Map<String,Date> sortByDate(Map<String, Date> map){
        List<Map.Entry<String, Date>> tempList = new LinkedList<Map.Entry<String, Date>>(map.entrySet());
        Collections.sort(tempList, new Comparator<Map.Entry<String, Date>>(){
            public int compare(Map.Entry<String, Date> obj1,Map.Entry<String, Date> obj2) {
                    return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        Map<String, Date> sortedMap = new LinkedHashMap<String, Date>();
        for (Map.Entry<String, Date> entry : tempList){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
    public void populatePatientRequests(){
                      DefaultTableModel model = (DefaultTableModel)medicineTable.getModel();
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
        delivComboBox.addItem("");
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
                         if(req.getSender() == null){
                             row[1] = "";
                         }else{
                 row[1] = req.getSender();  
                         }
                 row[2] = medList;
                 row[3] = req.getCreateDate();
                 row[4] = req.getCondition();
                 row[5] = latestKey;

            

            
            model.addRow(row);    
            }
        }
    }
       public void populateTimeline(PharmaWorkRequest req){
       DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);
           Map<String,Date> map = req.getStatusMap();
           Map<String, Date> Sortedmap = sortByDate(map);
            for (Map.Entry<String,Date> mapEntry : Sortedmap.entrySet()) {
                            Object row[] = new Object[5];
                 row[0] =mapEntry.getValue(); 
                 row[1] = mapEntry.getKey();
                  model.addRow(row); 
               }
      }
              public void populateTimeline(String req){
       DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);
              }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicineTable = new javax.swing.JTable();
        btnCheck = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        delivComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        respTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        timelineTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1466, 902));

        introPanel.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Medicine Requests Portal");

        lblEnterprise.setBackground(new java.awt.Color(51, 51, 51));
        lblEnterprise.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        lblEnterprise.setText("Enterprise:");
        lblEnterprise.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblAccount.setBackground(new java.awt.Color(51, 51, 51));
        lblAccount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setText("Enterprise:");
        lblAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        backJButton1.setBackground(new java.awt.Color(0, 102, 102));
        backJButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton1.setForeground(new java.awt.Color(255, 255, 255));
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/home2.png"))); // NOI18N
        backJButton1.setText("Home");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                .addComponent(backJButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/patientMedRequest.png"))); // NOI18N

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        medicineTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(medicineTable);

        btnCheck.setBackground(new java.awt.Color(0, 102, 102));
        btnCheck.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/checkavailability.png"))); // NOI18N
        btnCheck.setText("Check Availability");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnProcess.setBackground(new java.awt.Color(0, 102, 102));
        btnProcess.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnProcess.setForeground(new java.awt.Color(255, 255, 255));
        btnProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/newMedRequest .png"))); // NOI18N
        btnProcess.setText("Process Request");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        delivComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/delivselect.png"))); // NOI18N
        jLabel6.setText("Select Delivery Man incase of Covid Condition:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delivComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(delivComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(234, 234, 234))
        );

        jTabbedPane1.addTab("Patient Medicine Requests", jPanel2);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Medicine Request Logs", jPanel5);

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Timeline", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Medicine Request Logs", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(introPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(introPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:

        String stockOutMed = "";
        int selectedRow = medicineTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Medicine Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PharmacyEnterprise pharma = (PharmacyEnterprise) enterprise;
        PharmaWorkRequest pharmaRequest= (PharmaWorkRequest)medicineTable.getValueAt(selectedRow, 0);
        Map<String,Date> reqMap = pharmaRequest.getStatusMap();
        reqMap.put("Checking Medicine Availability", new Date());
        pharmaRequest.setStatusMap(reqMap);
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
        String msg ="";
        if(stockOutMed.equals("")){
            JOptionPane.showMessageDialog(null, "All Medicines are in Stock!", "Information", JOptionPane.INFORMATION_MESSAGE);
            msg = "Pharmacy:All Medicines are in Stock!";
        }else{
            JOptionPane.showMessageDialog(null, "Please fill up Medicines - OutOfStock -"+stockOutMed, "Information", JOptionPane.INFORMATION_MESSAGE);
            msg = "Pharmacy:Please fill up Medicines - OutOfStock -"+stockOutMed;
        }
        reqMap.put(msg, new Date());
        pharmaRequest.setStatusMap(reqMap);

        //patient.getPharmaWorkQueue().addPharmaRequest(pharmaRequest);
        //account.getPharmaWorkQueue().removePharmaRequest(pharmaRequest);
        business.getPharmaQueue().updatePharmaRequest(pharmaRequest, business.getPharmaQueue().getPharmaList());
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        UserAccount patient = null;
        UserAccount deliv = null;
        int selectedRow = medicineTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Medicine Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String stockOutMed = "";
        PharmacyEnterprise pharma = (PharmacyEnterprise) enterprise;
        PharmaWorkRequest pharmaRequest= (PharmaWorkRequest)medicineTable.getValueAt(selectedRow, 0);
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

            // JOptionPane.showMessageDialog(null, "All Medicines are in Stock!", "Information", JOptionPane.INFORMATION_MESSAGE);
            if(pharmaRequest.getCondition().equals("Covid")){
                message = "Medicines in stock and reserved.\n DeliveryStaff: "+delivComboBox.getSelectedItem().toString()+" will deliver at the earliest" ;
                for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua1 : organization1.getUserAccountDirectory().getUserAccountList()) {
                        if(ua1.getUsername().equals(delivComboBox.getSelectedItem().toString())){
                            pharmaRequest.setSender(ua1);
                            deliv = ua1;
                        }
                    }
                }
            }else{
                message = "Medicines in stock and reserved.\n Please pickup from pharmacy at the earliest!" ;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please fill up Medicines - OutOfStock -"+stockOutMed, "Information", JOptionPane.INFORMATION_MESSAGE);
            Date future = new Date();
            future.setDate(future.getDate()+10);
            if(pharmaRequest.getCondition().equals("Covid")){
                for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua1 : organization1.getUserAccountDirectory().getUserAccountList()) {
                        if(ua1.getUsername().equals(delivComboBox.getSelectedItem().toString())){
                            pharmaRequest.setSender(ua1);
                            deliv = ua1;
                        }
                    }
                }
                message = "Medicines currently OutOfStock.\n DeliveryStaff: "+delivComboBox.getSelectedItem().toString()+" will deliver anyday after"+future ;
            }else{
                message = "Medicines currently OutOfStock.\nPlease pickup from pharmacy anyday after"+future ;
            }
        }
        Map<String,Date> reqMap = pharmaRequest.getStatusMap();
        reqMap.put(message, new Date());
        pharmaRequest.setStatusMap(reqMap);
        pharmaRequest.setReceiver(patient);
        //    pharmaRequest.setSender(account);
        pharmaRequest.setMessage(message);
        if(deliv!=null){
            deliv.getPharmaWorkQueue().addPharmaRequest(pharmaRequest);
            pharmaRequest.setSender(deliv);
        }
        patient.getPharmaWorkQueue().addPharmaRequest(pharmaRequest);
        account.getPharmaWorkQueue().removePharmaRequest(pharmaRequest);
        business.getPharmaQueue().updatePharmaRequest(pharmaRequest, business.getPharmaQueue().getPharmaList());
        populatePatientRequests();
        JOptionPane.showMessageDialog(null, message+"\nMessage sent to Patient!", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnProcessActionPerformed

    private void delivComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivComboBoxActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
 if(this.jTabbedPane1.getSelectedIndex() ==  0){//patient medicine request
        populatePatientRequests();
        populateDeliv();
        }else if(this.jTabbedPane1.getSelectedIndex() ==  2){//medicine request logs
        populateAllRecords();
        populateTimeline("");
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
                if(this.jTabbedPane2.getSelectedIndex() == 0){//view logs
                          populateAllRecords();
        populateTimeline("");
        }else if(this.jTabbedPane2.getSelectedIndex() ==  1){//view timeline
             int selectedRow = respTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Medicine Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
             populateTimeline("");
            return;
        }

        PharmaWorkRequest pharma= (PharmaWorkRequest)respTable.getValueAt(selectedRow, 0);

        populateTimeline(pharma);
        }
    }//GEN-LAST:event_jTabbedPane2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnProcess;
    private javax.swing.JComboBox delivComboBox;
    private javax.swing.JPanel introPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JTable medicineTable;
    private javax.swing.JTable respTable;
    private javax.swing.JTable timelineTable;
    // End of variables declaration//GEN-END:variables
}
