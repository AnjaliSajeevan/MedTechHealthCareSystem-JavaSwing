/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.VaccineEnterprise;
import Business.Organization.VaccineCompanyOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.ManageEmployeeJPanel;
import userinterface.AdministrativeRole.ManageOrgJPanel;
import userinterface.AdministrativeRole.ManageUserAccountJPanel;

/**
 *
 * @author Manasa
 */
public class VaccineAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VaccineAdminWorkAreaJPanel
     */
        JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    UserAccount account;
    VaccineCompanyOrganization organization;
    /** Creates new form AdminWorkAreaJPanel */
    public VaccineAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, VaccineCompanyOrganization LabOrganization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.organization = LabOrganization;
        lblName.setText(account.getEmployee().getName());
        lblRole.setText("Company Admin");
        lblEnterprise.setText(enterprise.getName());
        lblAccount.setText("Logged in as: "+account.getUsername());
        this.setSize(1466, 902);
                introPanel.setBounds(171, 33, 1293, 101);
        jLabel4.setBounds(1, 1, 160, 113);
        jSplitPane1.setBounds(2, 140, 1195, 550);
        manageOrganizationJButton.setBounds(424, 451, 393, 166);
        btnVaccineReq.setBounds(424, 617, 393, 166);
        btnCompRpt.setBounds(424, 783, 393, 166);
        btnTestors.setBounds(887, 451, 393, 166);
        btnCheckTests.setBounds(887, 617, 393, 166);
        btnMedReport.setBounds(887, 783, 393, 166);
        btnResp.setBounds(711,141,393,166);

        this.business = business;
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
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCompRpt = new javax.swing.JButton();
        btnMedReport = new javax.swing.JButton();
        btnTestors = new javax.swing.JButton();
        btnResp = new javax.swing.JButton();
        btnCheckTests = new javax.swing.JButton();
        btnVaccineReq = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        introPanel.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vaccine Company Admin Portal");

        lblName.setBackground(new java.awt.Color(51, 51, 51));
        lblName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Enterprise:");
        lblName.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblRole.setBackground(new java.awt.Color(51, 51, 51));
        lblRole.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("Enterprise:");
        lblRole.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblEnterprise.setBackground(new java.awt.Color(51, 51, 51));
        lblEnterprise.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        lblEnterprise.setText("Enterprise:");
        lblEnterprise.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(271, 271, 271)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)))
                .addComponent(lblEnterprise)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/ID.png"))); // NOI18N

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1357, 667));

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome!");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("to Admin Page! ");

        lblAccount.setBackground(new java.awt.Color(51, 51, 51));
        lblAccount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setText("Enterprise:");
        lblAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(78, 78, 78)
                .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnCompRpt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCompRpt.setForeground(new java.awt.Color(0, 0, 51));
        btnCompRpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/bar_chart_100px.png"))); // NOI18N
        btnCompRpt.setText("Display VaccineCompany Report");
        btnCompRpt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        btnCompRpt.setContentAreaFilled(false);
        btnCompRpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompRptActionPerformed(evt);
            }
        });

        btnMedReport.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMedReport.setForeground(new java.awt.Color(0, 0, 51));
        btnMedReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/increase_100px.png"))); // NOI18N
        btnMedReport.setText("Check Medical Demands");
        btnMedReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        btnMedReport.setContentAreaFilled(false);
        btnMedReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedReportActionPerformed(evt);
            }
        });

        btnTestors.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTestors.setForeground(new java.awt.Color(0, 0, 51));
        btnTestors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/people_100px.png"))); // NOI18N
        btnTestors.setText("Manage Clinical Trial Testers");
        btnTestors.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        btnTestors.setContentAreaFilled(false);
        btnTestors.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTestors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestorsActionPerformed(evt);
            }
        });

        btnResp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnResp.setForeground(new java.awt.Color(0, 0, 51));
        btnResp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/bookmark_100px.png"))); // NOI18N
        btnResp.setText("Vaccine Records");
        btnResp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        btnResp.setContentAreaFilled(false);
        btnResp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespActionPerformed(evt);
            }
        });

        btnCheckTests.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCheckTests.setForeground(new java.awt.Color(0, 0, 51));
        btnCheckTests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/syringe_100px.png"))); // NOI18N
        btnCheckTests.setText("Post Clinical Trial Vaccines");
        btnCheckTests.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        btnCheckTests.setContentAreaFilled(false);
        btnCheckTests.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCheckTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckTestsActionPerformed(evt);
            }
        });

        btnVaccineReq.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVaccineReq.setForeground(new java.awt.Color(0, 0, 51));
        btnVaccineReq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/crowd_100px.png"))); // NOI18N
        btnVaccineReq.setText("Send Vaccine for Trial");
        btnVaccineReq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        btnVaccineReq.setContentAreaFilled(false);
        btnVaccineReq.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVaccineReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineReqActionPerformed(evt);
            }
        });

        manageOrganizationJButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        manageOrganizationJButton.setForeground(new java.awt.Color(0, 0, 51));
        manageOrganizationJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/organization_chart_people_100px.png"))); // NOI18N
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 2));
        manageOrganizationJButton.setContentAreaFilled(false);
        manageOrganizationJButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCompRpt, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(btnMedReport, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVaccineReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTestors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCheckTests, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResp, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(btnResp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTestors, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnVaccineReq, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnCheckTests, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompRpt, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMedReport, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(introPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrgJPanel manageOrgJPanel = new ManageOrgJPanel(userProcessContainer,account,organization,enterprise,business,"Vaccine Organization");
        userProcessContainer.add("manageOrgJPanel", manageOrgJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void btnCheckTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckTestsActionPerformed
        // TODO add your handling code here:
        TestedRequestsJPanel testedRequestsJPanel = new TestedRequestsJPanel(userProcessContainer, account,enterprise,business);
        userProcessContainer.add("testedRequestsJPanel", testedRequestsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCheckTestsActionPerformed

    private void btnVaccineReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineReqActionPerformed
        // TODO add your handling code here:
        VaccineRequestJPanel vaccineRequestJPanel = new VaccineRequestJPanel(userProcessContainer, account,organization,enterprise,business);
        userProcessContainer.add("vaccineRequestJPanel", vaccineRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnVaccineReqActionPerformed

    private void btnCompRptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompRptActionPerformed
        // TODO add your handling code here:
        VaccineCompReportJPanel reportCompJPanel = new VaccineCompReportJPanel(userProcessContainer, account,enterprise,business);
        userProcessContainer.add("reportCompJPanel", reportCompJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCompRptActionPerformed

    private void btnTestorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestorsActionPerformed
        // TODO add your handling code here:
        ManageTestersJPanel manageTestersJPanel = new ManageTestersJPanel(userProcessContainer, business, (VaccineEnterprise) enterprise);
        userProcessContainer.add("manageTestersJPanel", manageTestersJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnTestorsActionPerformed

    private void btnMedReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedReportActionPerformed
        // TODO add your handling code here:
          MedicalDemandJPanel medDemandPanel = new MedicalDemandJPanel(userProcessContainer, account,enterprise,business);
        userProcessContainer.add("medDemandPanel", medDemandPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);      
    }//GEN-LAST:event_btnMedReportActionPerformed

    private void btnRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespActionPerformed
        // TODO add your handling code here:
        VaccineRecordsJPanel recJPanel = new VaccineRecordsJPanel(userProcessContainer, account, (VaccineEnterprise) enterprise,business);
        userProcessContainer.add("recJPanel", recJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRespActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckTests;
    private javax.swing.JButton btnCompRpt;
    private javax.swing.JButton btnMedReport;
    private javax.swing.JButton btnResp;
    private javax.swing.JButton btnTestors;
    private javax.swing.JButton btnVaccineReq;
    private javax.swing.JPanel introPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRole;
    private javax.swing.JButton manageOrganizationJButton;
    // End of variables declaration//GEN-END:variables
}
