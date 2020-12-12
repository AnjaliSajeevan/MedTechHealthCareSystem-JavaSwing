/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.VaccineEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.VaccineWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manasa
 */
public class TestedRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TestedRequestsJPanel
     */
  private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem business; 
    private Enterprise enterprise;
    public TestedRequestsJPanel(JPanel userProcessContainer, UserAccount account,Enterprise enterprise,EcoSystem business ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.enterprise = enterprise;
         this.setSize(1466, 902);
        populateTestedTable("");
        populateVaccines();
        populateFDAEnterprises();
        jTabbedPane1.setBackground(Color.WHITE);
                  DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.BLACK);
         headerRenderer.setForeground(java.awt.Color.WHITE);

        for (int i = 0; i < testRequestTable.getModel().getColumnCount(); i++) {
            testRequestTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        testRequestTable.setShowGrid(true);
       testRequestTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateTestedTable(String vac){
         DefaultTableModel model = (DefaultTableModel)testRequestTable.getModel();
        model.setRowCount(0);
       int testCount =0;
        for(LabTestWorkRequest labTest: account.getLabTestWorkQueue().getLabRequestList()){
            if(!labTest.isComplete()){
                                        Map<String,Date> map = labTest.getStatusMap();
                    String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : labTest.getStatusMap().entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0){
                    latestKey = mapEntry.getKey();
                }
               }
            if((latestKey.equals("Success!") || (labTest.getResult().equals("Failure!")))){
                if(!vac.equals("")){
                    if(!labTest.getVaccine().toString().equals(vac)){
                        continue;                       
                    }else{
                        testCount+=1;
                    }
                }
            Object row[] = new Object[8];
                 row[0] = labTest;
                 row[1] = labTest.getLabTestType();
                 row[2] = labTest.getVaccine();
                 row[3] =labTest.getTester();
                 row[4] = labTest.getLabTestType();
                 if(labTest.getReceiver() == null){
                     row[5] = "";
                 }else{
                 row[5] = labTest.getReceiver();
                 }
                 if(labTest.getResult() == null){
                     row[6] = "";
                 }else{
                 row[6] = labTest.getResult();
                 }
                 if(labTest.getMessage() == null){
                     row[7] = "";
                 }else{
                 row[7] = labTest.getMessage();
                 }
                 

                 
                 
            model.addRow(row);                    
        }
            }
        }
        int allTest =0;
          if(!vac.equals("")){
              Vaccine newVac = (Vaccine)vaccinecomboBox.getSelectedItem();
              VaccineEnterprise vacEnterprise = (VaccineEnterprise) enterprise;
              for(Vaccine v : vacEnterprise.getVaccineDirectory().getVaccineList()){
                  if(v.getId()==newVac.getId()){
                     allTest = v.getTesterNum();
                  }
              }
           if(testCount < allTest){
                        JOptionPane.showMessageDialog(null, "Note: Complete Test Results not received yet!\nTotal Tests for this vaccine :"+allTest+"\nPending results for this vaccine :"+(allTest-testCount), "Warning", JOptionPane.WARNING_MESSAGE);       
           }
          }
        
        
    
    }
        public void populateVaccines(){   
            List<Vaccine> vacList = new ArrayList<Vaccine>();
        vaccinecomboBox.removeAllItems();
        vaccinecomboBox.addItem("");
                vaccinecomboBox1.removeAllItems();
        vaccinecomboBox1.addItem("");
        for(LabTestWorkRequest labReq:business.getLabQueue().getLabRequestList()){
            if(!labReq.getVaccine().isTested()){
                if(!vacList.contains(labReq.getVaccine())){
                    vacList.add(labReq.getVaccine());
                }
            }
        }
        for(Vaccine v:vacList){
        vaccinecomboBox.addItem(v);
        vaccinecomboBox1.addItem(v);
        }
    }
        public void populateFDAEnterprises(){
                    fdaBox.removeAllItems();
                    fdaBox.addItem("");
          for (Network network : business.getNetworkList()){
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            String fdaReg = ".*Food and Drug Administration.*";
            Pattern pattern = Pattern.compile(fdaReg);
            Matcher check = pattern.matcher(enterprise.toString());
            boolean fdaMatch = check.matches();
            if(fdaMatch == TRUE){
            fdaBox.addItem(enterprise.toString());
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

        jLabel6 = new javax.swing.JLabel();
        introPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        testRequestTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        vaccinecomboBox = new javax.swing.JComboBox();
        btnSearchByVaccine = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtResult = new javax.swing.JTextField();
        btnRoute = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        fdaBox = new javax.swing.JComboBox<>();
        btnFDA = new javax.swing.JButton();
        txtResult1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        vaccinecomboBox1 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("Tested Vaccine Requests");

        introPanel.setBackground(new java.awt.Color(0, 51, 153));

        jLabel5.setFont(new java.awt.Font("Sukhumvit Set", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Post Clinical Trial Processing");

        lblEnterprise.setBackground(new java.awt.Color(51, 51, 51));
        lblEnterprise.setFont(new java.awt.Font("Sukhumvit Set", 1, 18)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        lblEnterprise.setText("Enterprise:");
        lblEnterprise.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblAccount.setBackground(new java.awt.Color(51, 51, 51));
        lblAccount.setFont(new java.awt.Font("Sukhumvit Set", 1, 14)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setText("Enterprise:");
        lblAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        backJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 51, 153));
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/home.png"))); // NOI18N
        backJButton.setText("Home");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
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
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/postClinicalTrial.png"))); // NOI18N

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        testRequestTable.setBackground(new java.awt.Color(204, 204, 204));
        testRequestTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        testRequestTable.setFont(new java.awt.Font("Sukhumvit Set", 1, 14)); // NOI18N
        testRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "TestID", "Type", "VaccineID", "TesterID", "TestingStaff", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        testRequestTable.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane5.setViewportView(testRequestTable);

        jButton1.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/displayResult.png"))); // NOI18N
        jButton1.setText("Display All Results");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        vaccinecomboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccinecomboBoxActionPerformed(evt);
            }
        });

        btnSearchByVaccine.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        btnSearchByVaccine.setForeground(new java.awt.Color(0, 0, 51));
        btnSearchByVaccine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/search3.png"))); // NOI18N
        btnSearchByVaccine.setText("Search All Results By VaccineID");
        btnSearchByVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByVaccineActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Sukhumvit Set", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 51));
        jLabel12.setText("Clinical Trial Responses for Vaccine Requests:");

        jLabel13.setFont(new java.awt.Font("Symbol", 0, 18)); // NOI18N
        jLabel13.setText("Testing Vaccine ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vaccinecomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchByVaccine))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vaccinecomboBox)
                    .addComponent(btnSearchByVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tested Vaccine Table", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnRoute.setFont(new java.awt.Font("Symbol", 0, 14)); // NOI18N
        btnRoute.setForeground(new java.awt.Color(102, 0, 0));
        btnRoute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/routeBack.png"))); // NOI18N
        btnRoute.setText("Route Back to Scientist");
        btnRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRouteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Symbol", 0, 18)); // NOI18N
        jLabel7.setText("Provide detailed reason for closure of the Drug Project:");

        jLabel8.setFont(new java.awt.Font("Sukhumvit Set", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Route Back Vaccine to Scientist:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnRoute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Route Back", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        fdaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFDA.setFont(new java.awt.Font("Symbol", 1, 14)); // NOI18N
        btnFDA.setForeground(new java.awt.Color(0, 0, 51));
        btnFDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/checkMark.png"))); // NOI18N
        btnFDA.setText("Send for FDA Approval");
        btnFDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFDAActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Symbol", 0, 18)); // NOI18N
        jLabel9.setText("Select FDA Company to sent the Vaccine Request:");

        jLabel10.setFont(new java.awt.Font("Symbol", 0, 18)); // NOI18N
        jLabel10.setText("Provide any Message that would be relevant for FDA consideration:");

        jLabel11.setFont(new java.awt.Font("Sukhumvit Set", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setText("Proceed for FDA Approval:");

        vaccinecomboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccinecomboBox1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Symbol", 0, 18)); // NOI18N
        jLabel14.setText("Testing Vaccine ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vaccinecomboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fdaBox, 0, 322, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFDA, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(txtResult1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(btnFDA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaccinecomboBox1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fdaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResult1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Send To FDA", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(introPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        populateTestedTable("");
        populateVaccines();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSearchByVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByVaccineActionPerformed
        // TODO add your handling code here:
        if(vaccinecomboBox.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine ID!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        populateTestedTable(vaccinecomboBox.getSelectedItem().toString());
    }//GEN-LAST:event_btnSearchByVaccineActionPerformed

    private void vaccinecomboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccinecomboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaccinecomboBoxActionPerformed

    private void btnRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRouteActionPerformed
        // TODO add your handling code here:
        if(txtResult.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Message is mandatory for routing!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(vaccinecomboBox.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine ID!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        VaccineWorkRequest request = null;
        for(VaccineWorkRequest vacReq: business.getVaccineQueue().getVaccineRequestList()){
            if(vacReq.getVaccine().toString().equals(vaccinecomboBox.getSelectedItem().toString())){
                Map<String,Date> reqMap = vacReq.getStatusMap();
                reqMap.put("TestComplete: "+txtResult.getText(), new Date());
                reqMap.put("Vaccine Work finished", new Date());
                vacReq.setStatusMap(reqMap);
                vacReq.setSender(account);
                vacReq.setReceiver(vacReq.getVaccine().getUsername());
                vacReq.setResolveDate(new Date());
                vacReq.setMessage(txtResult.getText());
                vacReq.setSuccess("drop");
                request = vacReq;
            }
        }

        if(request!=null){
            LabTestWorkRequest removeWork = null;
            for(LabTestWorkRequest work:account.getLabTestWorkQueue().getLabRequestList()){
                if(work.getVaccine().toString().equals(vaccinecomboBox.getSelectedItem().toString())){
                    removeWork = work;
                    work.setComplete(true);
                    work.getVaccine().setTested(true);
                    business.getLabQueue().updateLabRequest(work, business.getLabQueue().getLabRequestList());

                }
            }
            account.getLabTestWorkQueue().removeLabRequest(removeWork);
            business.getVaccineQueue().updateWorkRequest(request, business.getVaccineQueue().getVaccineRequestList());
        }
        JOptionPane.showMessageDialog(null, "Vaccine Request Dropped and Routed Back to Scientist!!", "Information", JOptionPane.INFORMATION_MESSAGE);

        populateTestedTable("");
        populateVaccines();
        populateFDAEnterprises();
        txtResult.setText("");
    }//GEN-LAST:event_btnRouteActionPerformed

    private void btnFDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFDAActionPerformed
        // TODO add your handling code here:
        if(txtResult1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Message is mandatory for proceeding to FDA!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(vaccinecomboBox1.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine ID!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(fdaBox.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please choose the FDA enterprise to send the request!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        VaccineWorkRequest request = null;
        for(VaccineWorkRequest vacReq: business.getVaccineQueue().getVaccineRequestList()){
            if(vacReq.getVaccine().toString().equals(vaccinecomboBox1.getSelectedItem().toString())){
                Map<String,Date> reqMap = vacReq.getStatusMap();
                reqMap.put("TestComplete: "+txtResult1.getText(), new Date());
                vacReq.setStatusMap(reqMap);
                vacReq.setSender(account);
                vacReq.setMessage(txtResult1.getText());
                request = vacReq;
            }
        }
        if(request!=null){
            for(LabTestWorkRequest work:account.getLabTestWorkQueue().getLabRequestList()){
                if(work.getVaccine().toString().equals(vaccinecomboBox1.getSelectedItem().toString())){
                    work.setComplete(true);
                    work.getVaccine().setTested(true);
                    business.getLabQueue().updateLabRequest(work, business.getLabQueue().getLabRequestList());
                    // account.getLabTestWorkQueue().removeLabRequest(work);
                }
            }
            Map<String,Date> reqMap = request.getStatusMap();
            reqMap.put("Sent to FDA: "+fdaBox.getSelectedItem().toString(), new Date());
            request.setStatusMap(reqMap);
            request.setPhase("approval");
            request.setSender(account);
            for (Network network : business.getNetworkList()){
                for (Enterprise enterpriseCheck : network.getEnterpriseDirectory().getEnterpriseList()){
                    if(enterpriseCheck.getName().equals(fdaBox.getSelectedItem().toString())){
                        for (UserAccount ua : enterpriseCheck.getUserAccountDirectory().getUserAccountList()) {
                            if(ua.getRole().toString().equals("FDAAdmin")){
                                request.setReceiver(ua);
                                ua.getVaccineWorkQueue().addWorkRequest(request);
                            }
                        }

                    }
                }
            }
            business.getVaccineQueue().updateWorkRequest(request, business.getVaccineQueue().getVaccineRequestList());
        }
        JOptionPane.showMessageDialog(null, "Vaccine Request Proceeded for FDA Approval!!", "Information", JOptionPane.INFORMATION_MESSAGE);
        populateTestedTable("");
        populateVaccines();
        populateFDAEnterprises();
        txtResult1.setText("");
    }//GEN-LAST:event_btnFDAActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        if(this.jTabbedPane1.getSelectedIndex() == 0){//all tested drug requests
    populateTestedTable("");
}else if(this.jTabbedPane1.getSelectedIndex() == 1){//route Back
                if(vaccinecomboBox.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine ID from DropDown in TestedTable tab!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }


        
}else if(this.jTabbedPane1.getSelectedIndex() == 2){//remove vaccine request
populateVaccines();
}
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void vaccinecomboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccinecomboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaccinecomboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnFDA;
    private javax.swing.JButton btnRoute;
    private javax.swing.JButton btnSearchByVaccine;
    private javax.swing.JComboBox<String> fdaBox;
    private javax.swing.JPanel introPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JTable testRequestTable;
    private javax.swing.JTextField txtResult;
    private javax.swing.JTextField txtResult1;
    private javax.swing.JComboBox vaccinecomboBox;
    private javax.swing.JComboBox vaccinecomboBox1;
    // End of variables declaration//GEN-END:variables
}
