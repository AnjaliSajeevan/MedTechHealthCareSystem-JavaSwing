/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InsuranceAdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Organization.InsuranceAdminOrganization;
import Business.Patient.Patient;
import Business.Role.PatientRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import userinterface.AdministrativeRole.ManageEmployeeJPanel;
import userinterface.AdministrativeRole.ManageOrganizationJPanel;
import userinterface.AdministrativeRole.ManageUserAccountJPanel;
import userinterface.PatientRole.CreatePatientJPanel;

/**
 *
 * @author Anjali
 */
public class InsuranceAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form InsuranceAdminWorkAreaJPanel
     */

    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount account;
    EcoSystem ecosystem;
    InsuranceAdminOrganization insuranceOrganization;
   
    public InsuranceAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, InsuranceAdminOrganization insuranceOrganization, Enterprise enterprise,EcoSystem ecosystem) {
       
        initComponents();
       
        
        tblPatient.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,15));
        jScrollPane3.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblPolicy.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(48,59,88));
         headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < tblPolicy.getModel().getColumnCount(); i++) {
            tblPolicy.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        tblPolicy.setShowGrid(true);
        tblPolicy.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
    
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblPolicy.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer1.setBackground(new Color(48,59,88));
         headerRenderer1.setForeground(Color.WHITE);

        for (int i = 0; i < tblPatient.getModel().getColumnCount(); i++) {
            tblPatient.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        tblPatient.setShowGrid(true);
        tblPatient.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
        
        
        
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.ecosystem=ecosystem;
        this.insuranceOrganization = insuranceOrganization;
        valueLabel.setText(enterprise.getName());
        jLabel9.setText(account.getEmployee().getName());
       

        populateTree();
        populateTable();

    }
    
    
    
      public void populateTree()
    {DefaultTableModel model = (DefaultTableModel) tblPolicy.getModel();
        model.setRowCount(0);        
         
            for (InsurancePolicy r: ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
                if(r.getEnterprise().equals(enterprise.getName()))
                {Object row[] = new Object[3];
                row[0] = r;
                row[1] = r.getMonthlyPremium();
                row[2] = r.getPolicyType();
                ((DefaultTableModel) tblPolicy.getModel()).addRow(row);
                
            }
            }
    
    }
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)tblPatient.getModel();
        model.setRowCount(0);
            
        for(WorkRequest request : ecosystem.getWorkQueue().getWorkRequestList()){
            
            if(request.getEnterprise().equals(enterprise.getName())){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getInsurancepolicy();
            row[3] = request.getStatus();
            
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

        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlCards = new javax.swing.JPanel();
        pnlCard1 = new javax.swing.JPanel();
        valueLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlCard2 = new javax.swing.JPanel();
        userJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnlCard4 = new javax.swing.JPanel();
        btnViewPolicy = new javax.swing.JButton();
        btnDeletePolicy = new javax.swing.JButton();
        btnCreatePolicy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPolicy = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pnlCard3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlTab = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnInsuranceRequest = new javax.swing.JButton();
        btnInsurancePolicy = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnOrganisation = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setDividerSize(0);

        pnlCards.setBackground(new java.awt.Color(255, 255, 255));
        pnlCards.setLayout(new java.awt.CardLayout());

        pnlCard1.setBackground(new java.awt.Color(255, 255, 255));

        valueLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        valueLabel.setText("            <value>");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/health-medical-insurance-vector-28999951(2).jpg"))); // NOI18N

        javax.swing.GroupLayout pnlCard1Layout = new javax.swing.GroupLayout(pnlCard1);
        pnlCard1.setLayout(pnlCard1Layout);
        pnlCard1Layout.setHorizontalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCard1Layout.setVerticalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCard1, "card6");

        pnlCard2.setBackground(new java.awt.Color(255, 255, 255));

        userJButton.setBackground(new java.awt.Color(50, 57, 73));
        userJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userJButton.setForeground(new java.awt.Color(255, 255, 255));
        userJButton.setText("Manage User");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });

        manageEmployeeJButton.setBackground(new java.awt.Color(50, 57, 73));
        manageEmployeeJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manageEmployeeJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });

        manageOrganizationJButton.setBackground(new java.awt.Color(50, 57, 73));
        manageOrganizationJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manageOrganizationJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/5fd1791cc2f31803167028.gif"))); // NOI18N

        javax.swing.GroupLayout pnlCard2Layout = new javax.swing.GroupLayout(pnlCard2);
        pnlCard2.setLayout(pnlCard2Layout);
        pnlCard2Layout.setHorizontalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard2Layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard2Layout.createSequentialGroup()
                        .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(307, 307, 307))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard2Layout.createSequentialGroup()
                        .addGroup(pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(307, 307, 307))))
        );
        pnlCard2Layout.setVerticalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard2Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCard2, "card4");

        pnlCard4.setBackground(new java.awt.Color(255, 255, 255));

        btnViewPolicy.setBackground(new java.awt.Color(255, 255, 255));
        btnViewPolicy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/view_50px.png"))); // NOI18N
        btnViewPolicy.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnViewPolicy.setBorderPainted(false);
        btnViewPolicy.setContentAreaFilled(false);
        btnViewPolicy.setFocusPainted(false);
        btnViewPolicy.setFocusable(false);
        btnViewPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPolicyActionPerformed(evt);
            }
        });

        btnDeletePolicy.setBackground(new java.awt.Color(255, 255, 255));
        btnDeletePolicy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/delete_bin_50-2px.png"))); // NOI18N
        btnDeletePolicy.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeletePolicy.setBorderPainted(false);
        btnDeletePolicy.setContentAreaFilled(false);
        btnDeletePolicy.setFocusPainted(false);
        btnDeletePolicy.setFocusable(false);
        btnDeletePolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePolicyActionPerformed(evt);
            }
        });

        btnCreatePolicy.setBackground(new java.awt.Color(255, 255, 255));
        btnCreatePolicy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/new_copy_50px.png"))); // NOI18N
        btnCreatePolicy.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCreatePolicy.setBorderPainted(false);
        btnCreatePolicy.setContentAreaFilled(false);
        btnCreatePolicy.setFocusPainted(false);
        btnCreatePolicy.setFocusable(false);
        btnCreatePolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePolicyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("AVAILABLE INSURANCE POLICIES");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/health-insurance-concept-banner-vector-19294662.jpg"))); // NOI18N

        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tblPolicy.setBackground(new java.awt.Color(83, 103, 142));
        tblPolicy.setForeground(new java.awt.Color(255, 255, 255));
        tblPolicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy Name", "Monthly Premium", "Policy Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPolicy.setGridColor(new java.awt.Color(255, 255, 255));
        tblPolicy.setRowHeight(25);
        tblPolicy.setSelectionBackground(new java.awt.Color(210, 225, 249));
        tblPolicy.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tblPolicy);
        if (tblPolicy.getColumnModel().getColumnCount() > 0) {
            tblPolicy.getColumnModel().getColumn(0).setResizable(false);
            tblPolicy.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPolicy.getColumnModel().getColumn(1).setResizable(false);
            tblPolicy.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblPolicy.getColumnModel().getColumn(2).setResizable(false);
            tblPolicy.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/import_csv_50px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCard4Layout = new javax.swing.GroupLayout(pnlCard4);
        pnlCard4.setLayout(pnlCard4Layout);
        pnlCard4Layout.setHorizontalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard4Layout.createSequentialGroup()
                .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCard4Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(btnCreatePolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(btnViewPolicy)
                        .addGap(113, 113, 113)
                        .addComponent(btnDeletePolicy))
                    .addGroup(pnlCard4Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel6)))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(pnlCard4Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(61, 61, 61))
        );
        pnlCard4Layout.setVerticalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(74, 74, 74)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCreatePolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeletePolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnViewPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCard4, "card7");

        pnlCard3.setBackground(new java.awt.Color(255, 255, 255));

        tblPatient.setBackground(new java.awt.Color(83, 103, 142));
        tblPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));
        tblPatient.setForeground(new java.awt.Color(255, 255, 255));
        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request No.", "Name", "Policy Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatient.setGridColor(new java.awt.Color(255, 255, 255));
        tblPatient.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPatient.setRowHeight(25);
        tblPatient.setSelectionBackground(new java.awt.Color(210, 225, 249));
        tblPatient.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblPatient.setShowVerticalLines(false);
        tblPatient.setUpdateSelectionOnSort(false);
        tblPatient.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tblPatient);
        if (tblPatient.getColumnModel().getColumnCount() > 0) {
            tblPatient.getColumnModel().getColumn(0).setResizable(false);
            tblPatient.getColumnModel().getColumn(1).setResizable(false);
            tblPatient.getColumnModel().getColumn(2).setResizable(false);
            tblPatient.getColumnModel().getColumn(3).setResizable(false);
        }

        btnAccept.setBackground(new java.awt.Color(50, 57, 73));
        btnAccept.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnAccept.setForeground(new java.awt.Color(255, 255, 255));
        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/checked_25px.png"))); // NOI18N
        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnDecline.setBackground(new java.awt.Color(50, 57, 73));
        btnDecline.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnDecline.setForeground(new java.awt.Color(255, 255, 255));
        btnDecline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/cancel_25px.png"))); // NOI18N
        btnDecline.setText("Decline");
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/father-shaking-hands-with-insurance-agent_74855-4412.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("INSURANCE REQUEST");

        javax.swing.GroupLayout pnlCard3Layout = new javax.swing.GroupLayout(pnlCard3);
        pnlCard3.setLayout(pnlCard3Layout);
        pnlCard3Layout.setHorizontalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard3Layout.createSequentialGroup()
                        .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlCard3Layout.createSequentialGroup()
                                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );
        pnlCard3Layout.setVerticalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard3Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCard3, "card5");

        jSplitPane1.setRightComponent(pnlCards);

        pnlTab.setBackground(new java.awt.Color(66, 66, 120));
        pnlTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(50, 57, 73));

        btnInsuranceRequest.setBackground(new java.awt.Color(145, 186, 214));
        btnInsuranceRequest.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnInsuranceRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnInsuranceRequest.setText("Insurance Request");
        btnInsuranceRequest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnInsuranceRequest.setBorderPainted(false);
        btnInsuranceRequest.setContentAreaFilled(false);
        btnInsuranceRequest.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnInsuranceRequest.setOpaque(true);
        btnInsuranceRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsuranceRequestActionPerformed(evt);
            }
        });

        btnInsurancePolicy.setBackground(new java.awt.Color(115, 165, 198));
        btnInsurancePolicy.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnInsurancePolicy.setForeground(new java.awt.Color(255, 255, 255));
        btnInsurancePolicy.setText("Insurance Policy");
        btnInsurancePolicy.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnInsurancePolicy.setBorderPainted(false);
        btnInsurancePolicy.setContentAreaFilled(false);
        btnInsurancePolicy.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnInsurancePolicy.setOpaque(true);
        btnInsurancePolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsurancePolicyActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(46, 89, 132));
        btnHome.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnHome.setOpaque(true);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnOrganisation.setBackground(new java.awt.Color(82, 138, 174));
        btnOrganisation.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnOrganisation.setForeground(new java.awt.Color(255, 255, 255));
        btnOrganisation.setText("Organization");
        btnOrganisation.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnOrganisation.setBorderPainted(false);
        btnOrganisation.setContentAreaFilled(false);
        btnOrganisation.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnOrganisation.setOpaque(true);
        btnOrganisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrganisationActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("<value>");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Welcome");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsuranceRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addComponent(btnOrganisation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsurancePolicy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnInsurancePolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnInsuranceRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        pnlTab.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-13, -20, 410, 930));

        jSplitPane1.setLeftComponent(pnlTab);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1258, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise,ecosystem);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrganizationJPanel manageInsuranceOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),"Insurance Organization");
        userProcessContainer.add("manageInsuranceOrganizationJPanel", manageInsuranceOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void btnViewPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPolicyActionPerformed
        // TODO add your handling code here:
        int selectedRow =  tblPolicy.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Pleasse select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
            InsurancePolicy a = (InsurancePolicy) tblPolicy.getValueAt(selectedRow, 0);
            ViewPolicyWorkAreaJPanel vpeaj = new ViewPolicyWorkAreaJPanel(userProcessContainer, ecosystem, a,true);
            userProcessContainer.add("ViewPolicyWorkAreaJPanel", vpeaj);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }
    }//GEN-LAST:event_btnViewPolicyActionPerformed

    private void btnDeletePolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePolicyActionPerformed
        // TODO add your handling code here:
        int selectedRow =  tblPolicy.getSelectedRow();
        UserAccount c = null;
        if(selectedRow >=0)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult= JOptionPane.showConfirmDialog(null,"Would you like to delete insurance policy?","Warning",dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                InsurancePolicy a = (InsurancePolicy) tblPolicy.getValueAt(selectedRow, 0);
                ecosystem.getInsurancePolicyDirectory().deleteInsurancePolicy(a);
            }
            populateTree();

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Pleasse select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnDeletePolicyActionPerformed

    private void btnCreatePolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePolicyActionPerformed
        // TODO add your handling code here:
        CreatePolicyWorkAreaJPanel cpeaj = new CreatePolicyWorkAreaJPanel(userProcessContainer, enterprise,ecosystem,account);
        userProcessContainer.add("CreatePolicyWorkAreaJPanel", cpeaj);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreatePolicyActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
      
        populateRequest();
       

        }

        public void populateRequest(){
            int selectedRow =  tblPatient.getSelectedRow();
            if(selectedRow <0)
            {
                JOptionPane.showMessageDialog(null,"Pleasse select a row","Warning", JOptionPane.WARNING_MESSAGE);

            }

            else
            {  
                InsuranceWorkRequest request = (InsuranceWorkRequest) tblPatient.getValueAt(selectedRow, 0);
                 if(request.getStatus().equals("Accepted")||request.getStatus().equals("Declined")){
                     JOptionPane.showMessageDialog(null,"Request already  processed","Warning", JOptionPane.WARNING_MESSAGE);
                 }
                
                 else{
                request.setStatus("Accepted");
                request.setResolveDate(new Date());
                for (InsurancePolicy r: ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
                    if(r.getEnterprise().equals(enterprise.getName()))
                    {if(request.getInsurancepolicy().equals(r.getPolicyName()))
                        r.addPatient(request.getSender().toString());
                       populateTable();
                    }
                }
                 JOptionPane.showMessageDialog(null,"Successfully Accepted");
                }
            }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        // TODO add your handling code here:
        int selectedRow =  tblPatient.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Pleasse select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
            InsuranceWorkRequest request = (InsuranceWorkRequest) tblPatient.getValueAt(selectedRow, 0);
             if(request.getStatus().equals("Accepted")||request.getStatus().equals("Declined")||request.getStatus().equals("Consultation completed")){
                     JOptionPane.showMessageDialog(null,"Request already processed","Warning", JOptionPane.WARNING_MESSAGE);
                 }else{
            request.setStatus("Declined");
           
            populateTable();
        }
        }
    }//GEN-LAST:event_btnDeclineActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        pnlCards.removeAll();
        pnlCards.add(pnlCard1);
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnOrganisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganisationActionPerformed
        // TODO add your handling code here:
        pnlCards.removeAll();
        pnlCards.add(pnlCard2);
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnOrganisationActionPerformed

    private void btnInsurancePolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsurancePolicyActionPerformed
        // TODO add your handling code here:
        pnlCards.removeAll();
        pnlCards.add(pnlCard4);
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnInsurancePolicyActionPerformed

    private void btnInsuranceRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsuranceRequestActionPerformed
        // TODO add your handling code here:
         pnlCards.removeAll();
        pnlCards.add(pnlCard3);
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnInsuranceRequestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String filepath = "InsurancePolicy.csv";
         File file = new File(filepath);
         String line =null;
         { 
            String dental;
            String fitness;
            String vision;
            String hearing;
            String teleHealth;
            String policyType;
            String zipCode;
            String policyName;
            double monthlyPremium;
            double deductable;
            String policyMax;
            String OutOfPocket;
            String ageGroup;
            int primaryCare ;
            int specialist;
            int emergency;
            int surgery;
            int laboratoryservices;
            int inpatients;
        
         
                
         try {
              
              
            BufferedReader br = new BufferedReader(new FileReader(file));
             
              
             for(int  j=0;j<10;j++)
        {
               
                      while((line = br.readLine()) != null ){
                          String[] temp = line.split(",");
                          policyName=temp[0];
                          policyType=temp[1];
                          monthlyPremium=Double.parseDouble(temp[2]);
                          OutOfPocket=temp[3];
                          deductable=Double.parseDouble(temp[4]);
                          policyMax=temp[5];
                          ageGroup=temp[6];
                          zipCode=temp[7];
                          primaryCare=Integer.parseInt(temp[8]);
                          specialist=Integer.parseInt(temp[9]);
                          emergency=Integer.parseInt(temp[10]);
                          surgery=Integer.parseInt(temp[11]);
                          laboratoryservices=Integer.parseInt(temp[12]);
                          inpatients=Integer.parseInt(temp[13]);
                           dental=temp[14];
                          fitness=temp[15];
                          vision=temp[16];
                          hearing=temp[17];
                          teleHealth=temp[18];
                          
                                                              
                           InsurancePolicy i = ecosystem.getInsurancePolicyDirectory().addInsurancePolicy();
                          i.setAgeGroup(ageGroup);
                          i.setDental(dental);
                          i.setEmergency(emergency);
                          i.setFitness(fitness);
                          i.setHearing(hearing);
                          i.setInPatients(inpatients);
                          i.setMonthlyPremium(monthlyPremium);
                          i.setOutOfPocket(OutOfPocket);
                          i.setPolicyMax(policyMax);
                          i.setPolicyName(policyName);
                          i.setSurgery(surgery);
                          i.setTeleHealth(teleHealth);
                          i.setSpecialist(specialist);
                          i.setPrimaryCare(primaryCare);
                          i.setPolicyType(policyType);
                          i.setLaboratoryservices(laboratoryservices);
                          i.setVision(vision);
                          i.setDeductable(deductable);
                          i.setZipCode(zipCode);
                          i.setUserName(account.getUsername());
                          i.setEnterprise(enterprise.getName());
                      } 
        }
         JOptionPane.showMessageDialog(null, "Data Successfully Loaded");
                  }catch (IOException ex) {
                      Logger.getLogger(CreatePatientJPanel.class.getName()).log(Level.SEVERE, null, ex);
                 
              }
         
         

        
        
         }
        
        
        populateTree();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCreatePolicy;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnDeletePolicy;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInsurancePolicy;
    private javax.swing.JButton btnInsuranceRequest;
    private javax.swing.JButton btnOrganisation;
    private javax.swing.JButton btnViewPolicy;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JPanel pnlCard1;
    private javax.swing.JPanel pnlCard2;
    private javax.swing.JPanel pnlCard3;
    private javax.swing.JPanel pnlCard4;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel pnlTab;
    private javax.swing.JTable tblPatient;
    private javax.swing.JTable tblPolicy;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
