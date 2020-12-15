/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Organization.InsuranceAdminOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClaimWorkRequest;
import Business.WorkQueue.InsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import userinterface.InsuranceAdminWorkArea.ViewPolicyWorkAreaJPanel;

/**
 *
 * @author Anjali
 */
public class PatientInsuranceWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientInsuranceWorkAreaJPanel
     */
    
     JPanel userProcessContainer;
    EcoSystem ecosystem;
    UserAccount account;
    InsuranceAdminOrganization iOrg;
    String i;
    ClaimWorkRequest cr ;
    public PatientInsuranceWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem ecosystem,InsuranceAdminOrganization organization) {
        initComponents();
         this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        this.iOrg=organization;
        this.account=account;
       
         tblStatus.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,15));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblStatus.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(35,33,54));
         headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < tblStatus.getModel().getColumnCount(); i++) {
            tblStatus.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        tblStatus.setShowGrid(true);
        tblStatus.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
    
        jScrollPane3.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblClaim.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer1.setBackground(new Color(48,59,88));
         headerRenderer1.setForeground(Color.WHITE);

        for (int i = 0; i < tblClaim.getModel().getColumnCount(); i++) {
            tblClaim.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        tblClaim.setShowGrid(true);
        tblClaim.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
        
        
        
        
        populateTree();
        populate();
        populateComboBox();
        
        
    }

    public void populateTree()
    {  for (Patient p : ecosystem.getPatientDirectory().getpatientlist()) {
                    if (p.getUserName().equals(account.getEmployee().getName())) {
        txtPrimaryDoctor.setText(p.getPrimaryHospital());
        
    }
        }
        
        
        jComboBoxHospitalList.removeAllItems();
        String s;
        DefaultTableModel model = (DefaultTableModel) tblStatus.getModel();
        model.setRowCount(0);
        for (WorkRequest request : ecosystem.getWorkQueue().getWorkRequestList()) {
            if (account.getUsername().equals(request.getSender().getUsername())) {

                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getInsurancepolicy();
                row[2] = request.getRequestDate();
                row[3] = request.getStatus();
                row[4] = request.getEnterprise().toString();
                model.addRow(row);
                    
                if(request.getStatus().equals("Accepted")){
                    i=request.getInsurancepolicy();
                   
                    
                }
                
                        }
                    }
                }
            

    
    public void populateComboBox() {
        
            for (InsurancePolicy insurance : ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
                if (insurance.getPolicyName().equals(i)) {

                    for (int counter = 0; counter < insurance.getHospitalList().size(); counter++) {
                        jComboBoxHospitalList.addItem(insurance.getHospitalList().get(counter));
                    }
                }
            }
        }
    

     public void populate(){
      
         DefaultTableModel model = (DefaultTableModel)tblClaim.getModel();
            model.setRowCount(0);
         
         for(ClaimWorkRequest r : ecosystem.getClaimWorkQueue().getWorkRequestList())
       {   InsurancePolicy s=r.getInsurancepolicy();
            String insur=s.toString();
            Patient name=r.getPatient();
           if(account.getUsername().equals(name.getUserName()))
           { 
             

            Object[] row = new Object[7];
            row[0] = r;
            row[1] = r.getHospital();
            row[2] = r.getCost();
            row[3] = r.getRequestDate();
            row[4] = r.getStatus();
//            row[5] = r.getMessage();
            cr=r;
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

        tab = new javax.swing.JPanel();
        btnInsuranceRegistration = new javax.swing.JButton();
        btnInsuranceClaim = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        pnl = new javax.swing.JPanel();
        pnl2 = new javax.swing.JPanel();
        btnRegisterForInsurance = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatus = new javax.swing.JTable();
        btnCancelInsurance = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxHospitalList = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        txtPrimaryDoctor = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClaim = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setBackground(new java.awt.Color(35, 33, 54));

        btnInsuranceRegistration.setBackground(new java.awt.Color(73, 42, 63));
        btnInsuranceRegistration.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnInsuranceRegistration.setForeground(new java.awt.Color(255, 255, 255));
        btnInsuranceRegistration.setText("Insurance Registraton ");
        btnInsuranceRegistration.setBorder(null);
        btnInsuranceRegistration.setBorderPainted(false);
        btnInsuranceRegistration.setContentAreaFilled(false);
        btnInsuranceRegistration.setOpaque(true);
        btnInsuranceRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsuranceRegistrationActionPerformed(evt);
            }
        });

        btnInsuranceClaim.setBackground(new java.awt.Color(107, 60, 52));
        btnInsuranceClaim.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnInsuranceClaim.setForeground(new java.awt.Color(255, 255, 255));
        btnInsuranceClaim.setText("Insurance Claim");
        btnInsuranceClaim.setBorder(null);
        btnInsuranceClaim.setBorderPainted(false);
        btnInsuranceClaim.setContentAreaFilled(false);
        btnInsuranceClaim.setOpaque(true);
        btnInsuranceClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsuranceClaimActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/back_to_501px.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabLayout = new javax.swing.GroupLayout(tab);
        tab.setLayout(tabLayout);
        tabLayout.setHorizontalGroup(
            tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInsuranceClaim, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addGroup(tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnInsuranceRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabLayout.setVerticalGroup(
            tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack)
                .addGap(201, 201, 201)
                .addComponent(btnInsuranceRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnInsuranceClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, -1));

        pnl.setLayout(new java.awt.CardLayout());

        pnl2.setBackground(new java.awt.Color(255, 255, 255));

        btnRegisterForInsurance.setBackground(new java.awt.Color(73, 42, 63));
        btnRegisterForInsurance.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        btnRegisterForInsurance.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisterForInsurance.setText("Register for Insurance");
        btnRegisterForInsurance.setBorder(null);
        btnRegisterForInsurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterForInsuranceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("If registered, please find the insurance poliy status below:");

        tblStatus.setBackground(new java.awt.Color(73, 42, 63));
        tblStatus.setForeground(new java.awt.Color(255, 255, 255));
        tblStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "InsuranceRequestNo.", "Policy Name", "Requested Date", "Status", "Insurance Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStatus.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblStatus.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblStatus);
        if (tblStatus.getColumnModel().getColumnCount() > 0) {
            tblStatus.getColumnModel().getColumn(0).setResizable(false);
            tblStatus.getColumnModel().getColumn(1).setResizable(false);
            tblStatus.getColumnModel().getColumn(2).setResizable(false);
            tblStatus.getColumnModel().getColumn(3).setResizable(false);
            tblStatus.getColumnModel().getColumn(4).setResizable(false);
        }

        btnCancelInsurance.setBackground(new java.awt.Color(73, 42, 63));
        btnCancelInsurance.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnCancelInsurance.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelInsurance.setText("Cancel the registered insurance policy");
        btnCancelInsurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelInsuranceActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(73, 42, 63));
        btnView.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("View Insurance Policy Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(73, 42, 63));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Primary Hospital:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("If Insurance accepted and primary doctor not choosen, please choose a primary hospital:");

        jComboBoxHospitalList.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        btnSubmit.setBackground(new java.awt.Color(73, 42, 63));
        btnSubmit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        txtPrimaryDoctor.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPrimaryDoctor.setText("<>");

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel4)
                        .addGap(112, 112, 112)
                        .addComponent(txtPrimaryDoctor))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jComboBoxHospitalList, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(btnRegisterForInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl2Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(pnl2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl2Layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl2Layout.createSequentialGroup()
                                    .addComponent(btnCancelInsurance)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnView))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(389, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnRegisterForInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelInsurance)
                    .addComponent(btnView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrimaryDoctor))
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHospitalList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
        );

        pnl.add(pnl2, "card3");

        pnl1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("INSURANCE CLAIM STATUS");

        tblClaim.setBackground(new java.awt.Color(73, 42, 63));
        tblClaim.setForeground(new java.awt.Color(255, 255, 255));
        tblClaim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Insur.Claim No.", "Sender", "Amount", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClaim.setFocusable(false);
        tblClaim.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblClaim.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tblClaim);

        jButton3.setBackground(new java.awt.Color(35, 33, 54));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/available_updates_40px.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Capture123.PNG"))); // NOI18N

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel3))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(470, Short.MAX_VALUE))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(464, 464, 464))))
        );

        pnl.add(pnl1, "card2");

        add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 0, 1270, 921));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String e="";
        int selectedRow = tblStatus.getSelectedRow();
        InsurancePolicy insurance = null;
        String primaryHospital = (String) jComboBoxHospitalList.getSelectedItem();
        for (InsurancePolicy ins : ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
            if (ins.getPolicyName().equals(i)) {

                insurance = ins;
            }
            if (selectedRow < 0) {
                e="Please select a row!";

            } else {

                WorkRequest a = (WorkRequest) tblStatus.getValueAt(selectedRow, 0);
                String y = (String) jComboBoxHospitalList.getSelectedItem();
                if(a.getStatus().equals("Accepted")){
                    for (Patient p : ecosystem.getPatientDirectory().getpatientlist()) {
                        if (p.getUserName().equals(account.getEmployee().getName())) {
                            p.setPrimaryHospital(primaryHospital);
                            p.setInsurance(insurance);
                            p.setInsuranceOrderNo(a.getRequestNo());

                        }
                    }
                    e= "Successfully assigned primary doctor!";

                }else{
                    e= "Please wait for the insurance request to be accepted by the insurance company!";
                }
            }
        }
        JOptionPane.showMessageDialog(null, e);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        populateTree();
        populateComboBox();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblStatus.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            WorkRequest work = (WorkRequest) tblStatus.getValueAt(selectedRow, 0);
            String inspolicy = work.getInsurancepolicy();

            for (InsurancePolicy a : ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
                if (a.getPolicyName().equals(inspolicy)) {
                    ViewPolicyWorkAreaJPanel vpeaj = new ViewPolicyWorkAreaJPanel(userProcessContainer, ecosystem, a,false);
                    userProcessContainer.add("ViewPolicyWorkAreaJPanel", vpeaj);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);

                }
            }
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCancelInsuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelInsuranceActionPerformed
        // TODO add your handling code here:
        String e="";
        int selectedRow = tblStatus.getSelectedRow();
        InsurancePolicy insurance = null;

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            WorkRequest a = (WorkRequest) tblStatus.getValueAt(selectedRow, 0);
            String inspolicy = a.getInsurancepolicy();

            for (InsurancePolicy ins : ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
                if (ins.getPolicyName().equals(inspolicy)) {
                    ins.deletePatient(account.getUsername());
                }
            }

            a.setStatus("Insurance policy Cancelled");
            for (Patient p : ecosystem.getPatientDirectory().getpatientlist()) {
                if (p.getUserName().equals(account.getEmployee().getName())) {

                    p.setPrimaryHospital(null);
                    p.setInsurance(null);
                    p.setInsuranceOrderNo(null);

                }
            }
            JOptionPane.showMessageDialog(null,"Cancelled the insurance policy");
        }

        populateTree();
    }//GEN-LAST:event_btnCancelInsuranceActionPerformed

    private void btnRegisterForInsuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterForInsuranceActionPerformed
        // TODO add your handling code here:
        for(Patient p:ecosystem.getPatientDirectory().getpatientlist()){
            if(p.getUserName().equals(account.getUsername())){
                if( !(p.getInsurance()==null)){
                    JOptionPane.showMessageDialog(null,"Already registered with the insurance, cancel the existing insurance to proceed", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    RegisterForInsurance rfi=new RegisterForInsurance(userProcessContainer,account, ecosystem,iOrg);
                    userProcessContainer.add("RegisterForInsuranceJPanel",rfi);
                    CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                }
            }
        }
    }//GEN-LAST:event_btnRegisterForInsuranceActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnInsuranceRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsuranceRegistrationActionPerformed
        // TODO add your handling code here:
         pnl.removeAll();
        pnl.add(pnl2);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_btnInsuranceRegistrationActionPerformed

    private void btnInsuranceClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsuranceClaimActionPerformed
        // TODO add your handling code here:
         pnl.removeAll();
        pnl.add(pnl1);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_btnInsuranceClaimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelInsurance;
    private javax.swing.JButton btnInsuranceClaim;
    private javax.swing.JButton btnInsuranceRegistration;
    private javax.swing.JButton btnRegisterForInsurance;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnView;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxHospitalList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel tab;
    private javax.swing.JTable tblClaim;
    private javax.swing.JTable tblStatus;
    private javax.swing.JLabel txtPrimaryDoctor;
    // End of variables declaration//GEN-END:variables
}
