/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InsuranceAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Organization.InsuranceAdminOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.AdministrativeRole.ManageEmployeeJPanel;
import userinterface.AdministrativeRole.ManageOrganizationJPanel;
import userinterface.AdministrativeRole.ManageUserAccountJPanel;

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
    public InsuranceAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, InsuranceAdminOrganization InsuranceOrganization, Enterprise enterprise,EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.ecosystem=ecosystem;
        valueLabel.setText(enterprise.getName());
        populateTree();
    }
    
    public void populateTree()
    {DefaultTableModel model = (DefaultTableModel) tblPolicy.getModel();
        model.setRowCount(0);        
            for (InsurancePolicy r: ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
                Object row[] = new Object[3];
                row[0] = r;
                row[1] = r.getMonthlyPremium();
                row[2] = r.getPolicyType();
                ((DefaultTableModel) tblPolicy.getModel()).addRow(row);
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

        btnAccept = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPolicy = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        btnDecline = new javax.swing.JButton();
        btnCreatePolicy = new javax.swing.JButton();
        btnViewPolicy = new javax.swing.JButton();
        btnDeletePolicy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        manageOrganizationJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        userJButton = new javax.swing.JButton();
        btnPatientsProfile = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, -1, -1));

        tblPolicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Monthly Premium", "Policy Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPolicy);
        if (tblPolicy.getColumnModel().getColumnCount() > 0) {
            tblPolicy.getColumnModel().getColumn(0).setResizable(false);
            tblPolicy.getColumnModel().getColumn(1).setResizable(false);
            tblPolicy.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, 788, 117));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Available Insurane Policies");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 574, 180, 20));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 280, -1));

        btnDecline.setText("Decline");
        add(btnDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        btnCreatePolicy.setText("Create Policy");
        btnCreatePolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePolicyActionPerformed(evt);
            }
        });
        add(btnCreatePolicy, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 740, -1, -1));

        btnViewPolicy.setText("View Policy");
        btnViewPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPolicyActionPerformed(evt);
            }
        });
        add(btnViewPolicy, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 740, -1, -1));

        btnDeletePolicy.setText("Delete Policy");
        btnDeletePolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePolicyActionPerformed(evt);
            }
        });
        add(btnDeletePolicy, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 740, -1, -1));

        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Insurance Policy", "Policy Type", "Monthly Premium"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPatient);
        if (tblPatient.getColumnModel().getColumnCount() > 0) {
            tblPatient.getColumnModel().getColumn(0).setResizable(false);
            tblPatient.getColumnModel().getColumn(1).setResizable(false);
            tblPatient.getColumnModel().getColumn(2).setResizable(false);
            tblPatient.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 788, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Insurance Requests");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 160, -1));

        jPanel1.setBackground(new java.awt.Color(141, 185, 208));

        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });

        userJButton.setText("Manage User");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(manageOrganizationJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userJButton)
                    .addComponent(manageEmployeeJButton)
                    .addComponent(manageOrganizationJButton))
                .addGap(29, 29, 29))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        btnPatientsProfile.setText("Patients in the Policy");
        btnPatientsProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientsProfileActionPerformed(evt);
            }
        });
        add(btnPatientsProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 740, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrganizationJPanel manageInsuranceOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),"Insurance Organization");
        userProcessContainer.add("manageInsuranceOrganizationJPanel", manageInsuranceOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCreatePolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePolicyActionPerformed
        // TODO add your handling code here:
        CreatePolicyWorkAreaJPanel cpeaj = new CreatePolicyWorkAreaJPanel(userProcessContainer, enterprise,ecosystem,account);
        userProcessContainer.add("CreatePolicyWorkAreaJPanel", cpeaj);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreatePolicyActionPerformed

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
            ViewPolicyWorkAreaJPanel vpeaj = new ViewPolicyWorkAreaJPanel(userProcessContainer, ecosystem, a);
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
            int dialogResult= JOptionPane.showConfirmDialog(null,"Would you like to delete restaurant details?","Warning",dialogButton);
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

    private void btnPatientsProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientsProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPatientsProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCreatePolicy;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnDeletePolicy;
    private javax.swing.JButton btnPatientsProfile;
    private javax.swing.JButton btnViewPolicy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JTable tblPatient;
    private javax.swing.JTable tblPolicy;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}