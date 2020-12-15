/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Enterprise.VaccineEnterprise;
import Business.Essentials.Medicine;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Patient.Patient;
import Business.Role.AdminRole;
import Business.Role.AmbulanceDriverRole;
import Business.Role.DeliveryManRole;
import Business.Role.FDARole;
import Business.Role.InsuranceAdminRole;
import Business.Role.InsuranceClaimRole;
import Business.Role.LabAdminRole;
import Business.Role.LabStaffRole;
import Business.Role.ManufactureAdminRole;
import Business.Role.PatientRole;
import Business.Role.PharmacyAdminRole;
import Business.Role.VaccineAdminRole;
import Business.Role.VaccineScientistRole;
import Business.Role.VaccineTestingStaffRole;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineTester;
import Business.WorkQueue.VaccineWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
//import userinterface.SystemAdminWorkArea.
/**
 *
 * @author MyPC1
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
         jScrollPane2.getViewport().setBackground(Color.WHITE);
         
//         DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) jTree.getCellRenderer();
//        Icon closedIcon = new ImageIcon("folder_10px.png");
//        Icon openIcon = new ImageIcon("management_10px.png");
//        Icon leafIcon = new ImageIcon("opened_folder_10px.png");
//        renderer.setClosedIcon(closedIcon);
//        renderer.setOpenIcon(openIcon);
//        renderer.setLeafIcon(leafIcon);
        
        populateTree();

    }
    
 
    
    public void populateTree(){
        DefaultTreeModel model=(DefaultTreeModel)jTree.getModel();
        ArrayList<Network> networkList=ecosystem.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> orgList;
        ArrayList<UserAccount> userList;
        
        int count=0;
        String role;
        Network network;
        Enterprise enterprise;
        Organization organization;
        UserAccount user = null;
        String org = null;
        Type type;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        DefaultMutableTreeNode userNode = null;
        
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            
            enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
  
                    orgList=enterprise.getOrganizationDirectory().getOrganizationList(); 
                  for (int l=0;l<orgList.size();l++){         
                     organization=orgList.get(l);
                    organizationNode=new DefaultMutableTreeNode(organization.getOrganizationType());
                     enterpriseNode.insert(organizationNode, l);
                       
                   userList=organization.getUserAccountDirectory().getUserAccountList();
                    for (int k=0;k<userList.size();k++){ 
                        user=userList.get(k);
                        
                        if(user.getRole().toString().equals(organization.getOrganizationType())){
                            System.out.print("Hi");
                            userNode=new DefaultMutableTreeNode(user.getEmployee().getName());
                            organizationNode.insert(userNode, k);
                    }   
                    }
            }
                }
        
        }
        model.reload();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnltab = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        btnManageEnterprise = new javax.swing.JButton();
        btnManageNetwork = new javax.swing.JButton();
        lab = new javax.swing.JLabel();
        btnManageAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnManagePatient = new javax.swing.JButton();
        btnVacLoad = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        lblSelectedNode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnltab.setBackground(new java.awt.Color(255, 255, 255));
        pnltab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(213, 176, 181));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Network Tree");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnltab.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 340, 108));

        jButton2.setBackground(new java.awt.Color(217, 185, 41));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setText("Home");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnltab.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 340, 108));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Administrator Profile !");
        pnltab.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 40));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setText("Welcome to System ");
        pnltab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 40));

        add(pnltab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 870));

        pnl.setBackground(new java.awt.Color(195, 199, 210));
        pnl.setLayout(new java.awt.CardLayout());

        pnl1.setBackground(new java.awt.Color(238, 233, 234));

        btnManageEnterprise.setBackground(new java.awt.Color(255, 255, 255));
        btnManageEnterprise.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnManageEnterprise.setText("Manage Enterprise");
        btnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterpriseActionPerformed(evt);
            }
        });

        btnManageNetwork.setBackground(new java.awt.Color(255, 255, 255));
        btnManageNetwork.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnManageNetwork.setText("Manage Network");
        btnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageNetworkActionPerformed(evt);
            }
        });

        lab.setBackground(new java.awt.Color(0, 0, 0));
        lab.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lab.setText("Making health care better. Together.");

        btnManageAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnManageAdmin.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnManageAdmin.setText("Manage Enterprise Admin");
        btnManageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdminActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/5fd3a69ced29a044757172.gif"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("MEDTECH HEALTH CARE");

        btnManagePatient.setBackground(new java.awt.Color(255, 255, 255));
        btnManagePatient.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnManagePatient.setText("Manage Patients");
        btnManagePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePatientActionPerformed(evt);
            }
        });

        btnVacLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/import_csv_50px.png"))); // NOI18N
        btnVacLoad.setBorder(null);
        btnVacLoad.setBorderPainted(false);
        btnVacLoad.setContentAreaFilled(false);
        btnVacLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacLoadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setText("Making health care better. Together.");

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel2))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVacLoad))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab)))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManageAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManagePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addGap(85, 85, 85)
                .addComponent(btnManageNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnManageAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addComponent(btnManagePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(btnVacLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(277, 277, 277)
                .addComponent(lab)
                .addGap(38, 38, 38))
        );

        pnl.add(pnl1, "card2");

        pnl2.setBackground(new java.awt.Color(238, 233, 234));

        jTree.setBackground(new java.awt.Color(0, 0, 0));
        jTree.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTree.setOpaque(false);
        jTree.setRootVisible(false);
        jTree.setRowHeight(25);
        jTree.setVisibleRowCount(30);
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTree);

        lblSelectedNode.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblSelectedNode.setText("<View_selected_node>");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Selected Node:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setText("NETWORK TREE");

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(365, 365, 365))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSelectedNode, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectedNode, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pnl.add(pnl2, "card3");

        add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 940, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl1);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl2);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged

        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged

    private void btnManageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdminActionPerformed
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel=new ManageEnterpriseAdminJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseAdminJPanel",manageEnterpriseAdminJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdminActionPerformed

    private void btnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageNetworkActionPerformed
        ManageNetworkJPanel manageNetworkJPanel=new ManageNetworkJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageNetworkJPanel",manageNetworkJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageNetworkActionPerformed

    private void btnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterpriseActionPerformed
        ManageEnterpriseJPanel manageEnterpriseJPanel=new ManageEnterpriseJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseJPanel",manageEnterpriseJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEnterpriseActionPerformed

    private void btnManagePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePatientActionPerformed
        // TODO add your handling code here:
        ManagePateintJPanel managePateintJPanel=new ManagePateintJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("managePateintJPanel",managePateintJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManagePatientActionPerformed

    private void btnVacLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacLoadActionPerformed
        // TODO add your handling code here:

        //For Testing purpose only. MUST be deleted for final push.
   /*     for(Network n: ecosystem.getNetworkList()){
            if(n.getName().equals("NewHampshire")){
                JOptionPane.showMessageDialog(null,"Network already Loaded!");
                return;
            }
        }
        //Create Network
        Network network = ecosystem.createAndAddNetwork();
        network.setName("NewHampshire");

        //Create "VaccineCompany" Enterprise in NewHampshire Network
        Enterprise.EnterpriseType type = null;
        for (Enterprise.EnterpriseType temp : Enterprise.EnterpriseType.values()) {
            if(temp.toString().equals("VaccineCompany")){
                type=temp;
            }
        }
        String name = "NeoPharma";
        name = name+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        String name2 = "GenomeTech";
        name = name2+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);
        //Create "Pharmacy" Enterprise
        for (Enterprise.EnterpriseType temp2 : Enterprise.EnterpriseType.values()) {
            if(temp2.toString().equals("Pharmacy")){
                type= temp2;
            }
        }
        String name3 = "MediCare";
        name = name3+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        String name4 = "YourMed";
        name = name4+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        //Create Laboratory Enterprise
        for (Enterprise.EnterpriseType temp3 : Enterprise.EnterpriseType.values()) {
            if(temp3.toString().equals("Laboratory")){
                type = temp3;
            }
        }
        String name5 = "HighTech";
        name = name5+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        String name6 = "LabWorks";
        name = name6+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        //Create FDA Enterprise
        for (Enterprise.EnterpriseType temp4 : Enterprise.EnterpriseType.values()) {
            if(temp4.toString().equals("Food and Drug Administration")){
                type = temp4;
            }
        }
        String name7 = "GeoResearch";
        name = name7+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        String name8 = "BioHealthCare";
        name = name8+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        //Create Hospital
        for (Enterprise.EnterpriseType temp5 : Enterprise.EnterpriseType.values()) {
            if(temp5.toString().equals("Hospital")){
                type = temp5;
            }
        }
        String name9 = "NewHampshire";
        name = name9+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        String name10 = "Excellence";
        name = name10+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        //Create Insurance Company
        for (Enterprise.EnterpriseType temp6 : Enterprise.EnterpriseType.values()) {
            if(temp6.toString().equals("Insurance")){
                type = temp6;
            }
        }
        String name11 = "NHLife";
        name = name11+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        String name12 = "Sunshine";
        name = name12+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);
        
        //Create Drug Manufacturing Unit
                for (Enterprise.EnterpriseType temp7 : Enterprise.EnterpriseType.values()) {
            if(temp7.toString().equals("DrugManufacturer")){
                type = temp7;
            }
        }
        String name13 = "DrugFactory";
        name = name13+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        String name14 = "BulkIndustry";
        name = name14+" "+type;
        network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        //Load Admins
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
            Organization org = null;
            Organization org2 = null;
            Employee employee= null;
            if(e.getName().equals("NeoPharma VaccineCompany")){
                employee =e.getEmployeeDirectory().createEmployee("vacEmp1");
                e.getUserAccountDirectory().createUserAccount("vac1", "vac1", employee, new  VaccineAdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.VaccineScientist);
                employee =org.getEmployeeDirectory().createEmployee("scientistEmp");
                UserAccount r1 =org.getUserAccountDirectory().createUserAccount("r1", "r1", employee, new VaccineScientistRole());
                org2 = e.getOrganizationDirectory().createOrganization(Organization.Type.VaccineTestingStaff);
                employee =org2.getEmployeeDirectory().createEmployee("testStaff1");
                org2.getUserAccountDirectory().createUserAccount("s1", "s1", employee, new VaccineTestingStaffRole());
                VaccineTester tester = new VaccineTester();
                tester.setName("Manny");
                tester.setCondition("Covid");
                tester.setDOB("12/12/2000");
                tester.setUpdateDate();
                tester.setPhotograph("fdgfdbdsfds");
                tester.setGender("Male");
                tester.setAge(20);
                tester.setEnterprise(e);
                VaccineEnterprise enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester);
                VaccineTester tester2 = new VaccineTester();
                tester2.setName("Dia");
                tester2.setCondition("Diabetes");
                tester2.setDOB("12/12/1987");
                tester2.setAge(33);
                tester2.setUpdateDate();
                tester2.setPhotograph("fdgfdbdsfds");
                tester2.setGender("Male");
                tester2.setEnterprise(e);
                enter.getVaccinetesterDirectory().addVaccineTester(tester2);
                VaccineTester tester3 = new VaccineTester();
                tester3.setName("Nuthan");
                tester3.setCondition("Healthy");
                tester3.setDOB("12/12/1994");
                tester3.setAge(26);
                tester3.setUpdateDate();
                tester3.setPhotograph("fdgfdbdsfds");
                tester3.setGender("Male");
                tester3.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester3);
                VaccineTester tester4 = new VaccineTester();
                tester4.setName("Freya");
                tester4.setCondition("Healthy");
                tester4.setDOB("12/12/1994");
                tester4.setAge(26);
                tester4.setUpdateDate();
                tester4.setPhotograph("fdgfdbdsfds");
                tester4.setGender("Female");
                tester4.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester4);
                VaccineTester tester5 = new VaccineTester();
                tester5.setName("Heeta");
                tester5.setCondition("Covid");
                tester5.setDOB("12/12/1990");
                tester5.setAge(30);
                tester5.setUpdateDate();
                tester5.setPhotograph("fdgfdbdsfds");
                tester5.setGender("Male");
                tester5.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester5);
                VaccineTester tester6 = new VaccineTester();
                tester6.setName("Anam");
                tester6.setCondition("Diabetes");
                tester6.setDOB("12/12/1997");
                tester6.setAge(23);
                tester6.setUpdateDate();
                tester6.setPhotograph("fdgfdbdsfds");
                tester6.setGender("Female");
                tester6.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester6);
                VaccineTester tester7 = new VaccineTester();
                tester7.setName("Noor");
                tester7.setCondition("Covid");
                tester7.setDOB("12/12/1990");
                tester7.setAge(30);
                tester7.setUpdateDate();
                tester7.setPhotograph("fdgfdbdsfds");
                tester7.setGender("Female");
                tester7.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester7);
                VaccineTester tester8 = new VaccineTester();
                tester8.setName("Tarun");
                tester8.setCondition("Diabetes");
                tester8.setDOB("12/12/1994");
                tester8.setAge(26);
                tester8.setUpdateDate();
                tester8.setPhotograph("fdgfdbdsfds");
                tester8.setGender("Male");
                tester8.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester8);
                VaccineTester tester9 = new VaccineTester();
                tester9.setName("Adam");
                tester9.setCondition("Heart Problems");
                tester9.setDOB("12/12/1980");
                tester9.setAge(40);
                tester9.setUpdateDate();
                tester9.setPhotograph("fdgfdbdsfds");
                tester9.setGender("Male");
                tester9.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester9);

                VaccineTester tester10 = new VaccineTester();
                tester10.setName("Danny");
                tester10.setCondition("Respiratory Problems");
                tester10.setDOB("12/12/1960");
                tester10.setAge(60);
                tester10.setUpdateDate();
                tester10.setPhotograph("fdgfdbdsfds");
                tester10.setGender("Other");
                tester10.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester10);

                //Creating Vaccine Requests

                Vaccine vaccine = new Vaccine();
                vaccine.setName("Vaccine1");
                vaccine.setDescription("Used for Resp");
                vaccine.setCoreComponents("Mol");
                vaccine.setAllergens("antihistamines");
                vaccine.setMinAgeGroup(10);
                vaccine.setMaxAgeGroup(40);
                vaccine.setAdministration("Pills");
                vaccine.setCondition("Heart Disease");
                Map<String,Integer> doseMap = vaccine.getDosage();
                doseMap.put("Night", 100);
                doseMap.put("Afternoon", 0);
                doseMap.put("Morning", 100);
                vaccine.setDosage(doseMap);
                vaccine.setPreservations("NA");
                vaccine.setSideeffects("Nausea");
                vaccine.setOther("NA");
                vaccine.setUpdateDate();
                vaccine.setUsername(r1);
                vaccine.setEnterpriseName(enter.getName());
                vaccine.setEnterprise(enter);

                enter.getVaccineDirectory().addVaccine(vaccine);

                VaccineWorkRequest vaccineReq = new VaccineWorkRequest();
                vaccineReq.setEnterprise(enter.getName());
                vaccineReq.setSender(r1);
                vaccineReq.setVaccine(vaccine);
                vaccineReq.setRequestDate(new Date());
                vaccineReq.setSuccess("ongoing");
                vaccineReq.setPhase("development");
                Map<String,Date> statusMap = vaccineReq.getStatusMap();
                statusMap.put("Formulation Phase", new Date());
                vaccineReq.setStatusMap(statusMap);
                r1.getVaccineWorkQueue().addWorkRequest(vaccineReq);
                ecosystem.getVaccineQueue().addWorkRequest(vaccineReq);

                Vaccine vaccine2 = new Vaccine();
                vaccine2.setName("Vaccine2");
                vaccine2.setDescription("Used for Covid");
                vaccine2.setCoreComponents("Mol");
                vaccine2.setAllergens("antihistamines");
                vaccine2.setMinAgeGroup(10);
                vaccine2.setMaxAgeGroup(40);
                vaccine2.setAdministration("Pills");
                vaccine2.setCondition("Covid");
                vaccine2.setDosage(doseMap);
                vaccine2.setPreservations("NA");
                vaccine2.setSideeffects("Nausea");
                vaccine2.setOther("NA");
                vaccine2.setUpdateDate();
                vaccine2.setUsername(r1);
                vaccine2.setEnterpriseName(enter.getName());
                vaccine2.setEnterprise(enter);

                enter.getVaccineDirectory().addVaccine(vaccine2);

                VaccineWorkRequest vaccineReq2 = new VaccineWorkRequest();
                vaccineReq2.setEnterprise(enter.getName());
                vaccineReq2.setSender(r1);
                vaccineReq2.setVaccine(vaccine2);
                vaccineReq2.setRequestDate(new Date());
                Map<String,Date> statusMap2 = vaccineReq2.getStatusMap();
                statusMap2.put("Formulation Phase", new Date());
                vaccineReq2.setStatusMap(statusMap2);
                vaccineReq2.setSuccess("ongoing");
                vaccineReq2.setPhase("development");
                r1.getVaccineWorkQueue().addWorkRequest(vaccineReq2);
                ecosystem.getVaccineQueue().addWorkRequest(vaccineReq2);

                Vaccine vaccine3 = new Vaccine();
                vaccine3.setName("Vaccine3");
                vaccine3.setDescription("Used for Diab");
                vaccine3.setCoreComponents("Mol");
                vaccine3.setAllergens("antihistamines");
                vaccine3.setMinAgeGroup(10);
                vaccine3.setMaxAgeGroup(40);
                vaccine3.setAdministration("Pills");
                vaccine3.setCondition("Diabetes");
                vaccine3.setDosage(doseMap);
                vaccine3.setPreservations("NA");
                vaccine3.setSideeffects("Nausea");
                vaccine3.setOther("NA");
                vaccine3.setUpdateDate();
                vaccine3.setUsername(r1);
                vaccine3.setEnterpriseName(enter.getName());
                vaccine3.setEnterprise(enter);

                enter.getVaccineDirectory().addVaccine(vaccine3);

                VaccineWorkRequest vaccineReq3 = new VaccineWorkRequest();
                vaccineReq3.setEnterprise(enter.getName());
                vaccineReq3.setSender(r1);
                vaccineReq3.setVaccine(vaccine3);
                vaccineReq3.setRequestDate(new Date());
                vaccineReq3.setSuccess("ongoing");
                vaccineReq3.setPhase("development");
                Map<String,Date> statusMap3 = vaccineReq3.getStatusMap();
                statusMap3.put("Formulation Phase", new Date());
                vaccineReq3.setStatusMap(statusMap3);
                r1.getVaccineWorkQueue().addWorkRequest(vaccineReq3);
                ecosystem.getVaccineQueue().addWorkRequest(vaccineReq3);

                Vaccine vaccine4 = new Vaccine();
                vaccine4.setName("Vaccine4");
                vaccine4.setDescription("Used for Resp");
                vaccine4.setCoreComponents("Mol");
                vaccine4.setAllergens("antihistamines");
                vaccine4.setMinAgeGroup(10);
                vaccine4.setMaxAgeGroup(40);
                vaccine4.setAdministration("Pills");
                vaccine4.setCondition("Heart Disease");
                vaccine4.setDosage(doseMap);
                vaccine4.setPreservations("NA");
                vaccine4.setSideeffects("Nausea");
                vaccine4.setOther("NA");
                vaccine4.setUpdateDate();
                vaccine4.setUsername(r1);
                vaccine4.setEnterpriseName(enter.getName());
                vaccine4.setEnterprise(enter);

                enter.getVaccineDirectory().addVaccine(vaccine4);

                VaccineWorkRequest vaccineReq4 = new VaccineWorkRequest();
                vaccineReq4.setEnterprise(enter.getName());
                vaccineReq4.setSender(r1);
                vaccineReq4.setVaccine(vaccine4);
                vaccineReq4.setRequestDate(new Date());
                Map<String,Date> statusMap4 = vaccineReq4.getStatusMap();
                statusMap4.put("Formulation Phase", new Date());
                vaccineReq4.setStatusMap(statusMap4);
                vaccineReq4.setSuccess("ongoing");
                vaccineReq4.setPhase("development");
                r1.getVaccineWorkQueue().addWorkRequest(vaccineReq4);
                ecosystem.getVaccineQueue().addWorkRequest(vaccineReq4);

                Vaccine vaccine5 = new Vaccine();
                vaccine5.setName("Vaccine5");
                vaccine5.setDescription("Used for Resp");
                vaccine5.setCoreComponents("Mol");
                vaccine5.setAllergens("antihistamines");
                vaccine5.setMinAgeGroup(10);
                vaccine5.setMaxAgeGroup(40);
                vaccine5.setAdministration("Pills");
                vaccine5.setCondition("Covid");
                vaccine5.setDosage(doseMap);
                vaccine5.setPreservations("NA");
                vaccine5.setSideeffects("Nausea");
                vaccine5.setOther("NA");
                vaccine5.setUpdateDate();
                vaccine5.setUsername(r1);
                vaccine5.setEnterpriseName(enter.getName());
                vaccine5.setEnterprise(enter);

                enter.getVaccineDirectory().addVaccine(vaccine5);

                VaccineWorkRequest vaccineReq5 = new VaccineWorkRequest();
                vaccineReq5.setEnterprise(enter.getName());
                vaccineReq5.setSender(r1);
                vaccineReq5.setVaccine(vaccine5);
                vaccineReq5.setRequestDate(new Date());
                Map<String,Date> statusMap5 = vaccineReq5.getStatusMap();
                statusMap5.put("Formulation Phase", new Date());
                vaccineReq5.setStatusMap(statusMap5);
                vaccineReq5.setSuccess("ongoing");
                vaccineReq5.setPhase("development");
                r1.getVaccineWorkQueue().addWorkRequest(vaccineReq5);
                ecosystem.getVaccineQueue().addWorkRequest(vaccineReq5);
            }
            if(e.getName().equals("GenomeTech VaccineCompany")){
                employee =e.getEmployeeDirectory().createEmployee("vacEmp2");
                e.getUserAccountDirectory().createUserAccount("vac2", "vac2", employee, new  VaccineAdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.VaccineScientist);

                employee =org.getEmployeeDirectory().createEmployee("scientistEmp3");
                org.getUserAccountDirectory().createUserAccount("r2", "r2", employee, new VaccineScientistRole());
                org2 = e.getOrganizationDirectory().createOrganization(Organization.Type.VaccineTestingStaff);
                employee =org2.getEmployeeDirectory().createEmployee("testStaff2");
                org2.getUserAccountDirectory().createUserAccount("s2", "s2", employee, new VaccineTestingStaffRole());

                //Creating Vaccine Tester

                VaccineTester tester = new VaccineTester();
                tester.setName("Marie");
                tester.setCondition("Covid");
                tester.setDOB("12/12/2000");
                tester.setUpdateDate();
                tester.setAge(20);
                tester.setPhotograph("fdgfdbdsfds");
                tester.setGender("Other");
                tester.setEnterprise(e);
                VaccineEnterprise enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester);
                VaccineTester tester2 = new VaccineTester();
                tester2.setName("Vij");
                tester2.setCondition("Diabetes");
                tester2.setDOB("12/12/1987");
                tester2.setAge(43);
                tester.setUpdateDate();
                tester.setPhotograph("fdgfdbdsfds");
                tester.setGender("Female");
                tester.setEnterprise(e);
                enter.getVaccinetesterDirectory().addVaccineTester(tester2);
                VaccineTester tester3 = new VaccineTester();
                tester3.setName("Nisha");
                tester3.setCondition("Healthy");
                tester3.setDOB("12/12/1994");
                tester3.setAge(26);
                tester.setUpdateDate();
                tester.setPhotograph("fdgfdbdsfds");
                tester.setGender("Male");
                tester.setEnterprise(e);
                enter = (VaccineEnterprise) e;
                enter.getVaccinetesterDirectory().addVaccineTester(tester3);

            }
            if(e.getName().equals("MediCare Pharmacy")){
                Employee pharmae1 = e.getEmployeeDirectory().createEmployee("pharmaEmp1");
                e.getUserAccountDirectory().createUserAccount("ph1", "ph1", pharmae1, new PharmacyAdminRole());
                org =e.getOrganizationDirectory().createOrganization(Organization.Type.DeliveryMan);
                employee =org.getEmployeeDirectory().createEmployee("delivEmp");
                org.getUserAccountDirectory().createUserAccount("deliv1", "deliv1", employee, new DeliveryManRole());
                PharmacyEnterprise enter = (PharmacyEnterprise) e;
                Medicine med = new Medicine("ParaMed",12.00,12,100);
                med.setCondition("Diabetes");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
                med = new Medicine("Inhaler",50.00,12,100);
                med.setCondition("Respiratory Problems");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
                med = new Medicine("CovVac",12.00,12,100);
                med.setCondition("Covid");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
                med= new Medicine("EasyHale",90.00,12,100);
                med.setCondition("Covid");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
            }
            if(e.getName().equals("YourMed Pharmacy")){
                Employee pharmae2 = e.getEmployeeDirectory().createEmployee("pharmaEmp2");
                e.getUserAccountDirectory().createUserAccount("ph2", "ph2", pharmae2, new PharmacyAdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.DeliveryMan);
                employee =org.getEmployeeDirectory().createEmployee("delivEmp2");
                org.getUserAccountDirectory().createUserAccount("deliv2", "deliv2", employee, new DeliveryManRole());
                PharmacyEnterprise enter = (PharmacyEnterprise) e;
                Medicine med = new Medicine("Med2",10.00,12,100);
                med.setCondition("Diabetes");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
                med = new Medicine("Paracetemol",15.00,12,100);
                med.setCondition("Respiratory Problems");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
                med = new Medicine("Medicin4",12.00,12,100);
                med.setCondition("Covid");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
                med= new Medicine("VitaPlus",18.00,12,100);
                med.setCondition("Covid");
                med.setDemand(0);
                enter.getMedicineCatalog().addMedicine(med);
            }
            if(e.getName().equals("HighTech Laboratory")){
                Employee labe1 = e.getEmployeeDirectory().createEmployee("labEmp1");
                e.getUserAccountDirectory().createUserAccount("lab1", "lab1", labe1, new LabAdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.LabStaff);
                employee =org.getEmployeeDirectory().createEmployee("labStaffEmp1");
                org.getUserAccountDirectory().createUserAccount("labstaff1", "labstaff1", employee, new LabStaffRole());

                LabEnterprise labEnterprise = (LabEnterprise) e;
                List<String> sList = labEnterprise.getServices();
                sList.add("X-Ray");
                sList.add("Blood-Test");
                sList.add("Covid-Test");
                sList.add("General-Checkup");

                labEnterprise.setServices(sList);
            }
            if(e.getName().equals("LabWorks Laboratory")){
                Employee labe2 = e.getEmployeeDirectory().createEmployee("labEmp2");
                e.getUserAccountDirectory().createUserAccount("lab2", "lab2", labe2, new LabAdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.LabStaff);
                employee =org.getEmployeeDirectory().createEmployee("labStaffEmp2");
                org.getUserAccountDirectory().createUserAccount("labstaff2", "labstaff2", employee, new LabStaffRole());
                LabEnterprise labEnterprise = (LabEnterprise) e;
                List<String> sList = labEnterprise.getServices();
                sList.add("Cholesterol-Checkup");
                sList.add("Blood-Test");
                sList.add("Covid-Test");
                sList.add("CT-Scan");

                labEnterprise.setServices(sList);
            }
            if(e.getName().equals("GeoResearch Food and Drug Administration")){
                Employee fdaEmp1 = e.getEmployeeDirectory().createEmployee("fdaEmp1");
                e.getUserAccountDirectory().createUserAccount("fda1", "fda1", fdaEmp1, new FDARole());

            }
            if(e.getName().equals("BioHealthCare Food and Drug Administration")){
                Employee fdaEmp2 = e.getEmployeeDirectory().createEmployee("fdaEmp2");
                e.getUserAccountDirectory().createUserAccount("fda2", "fda2", fdaEmp2, new FDARole());
            }
            if(e.getName().equals("DrugFactory DrugManufacturer")){
                Employee manuEmp1 = e.getEmployeeDirectory().createEmployee("manufacturer1");
                e.getUserAccountDirectory().createUserAccount("drug1", "drug1", manuEmp1, new ManufactureAdminRole());
            }
            if(e.getName().equals("BulkIndustry DrugManufacturer")){
                Employee manuEmp2 = e.getEmployeeDirectory().createEmployee("manufacturer2");
                e.getUserAccountDirectory().createUserAccount("drug2", "drug2", manuEmp2, new ManufactureAdminRole());
            }
            if(e.getName().equals("Sunshine Insurance")){
                Employee insEmp = e.getEmployeeDirectory().createEmployee("insureEmp1");
                e.getUserAccountDirectory().createUserAccount("in1", "in1", insEmp, new InsuranceAdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.InsuranceStaff);
                employee =org.getEmployeeDirectory().createEmployee("isStaff1");
                org.getUserAccountDirectory().createUserAccount("instaff1", "instaff1", employee, new InsuranceClaimRole());
                employee =org.getEmployeeDirectory().createEmployee("isStaff2");
                org.getUserAccountDirectory().createUserAccount("instaff2", "instaff2", employee, new InsuranceClaimRole());
            }
            if(e.getName().equals("NHLife Insurance")){
                Employee insEmp = e.getEmployeeDirectory().createEmployee("insureEmp2");
                e.getUserAccountDirectory().createUserAccount("in2", "in2", insEmp, new InsuranceAdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.InsuranceStaff);
                employee =org.getEmployeeDirectory().createEmployee("isStaff3");
                org.getUserAccountDirectory().createUserAccount("instaff3", "instaff3", employee, new InsuranceClaimRole());
                employee =org.getEmployeeDirectory().createEmployee("isStaff4");
                org.getUserAccountDirectory().createUserAccount("instaff4", "instaff4", employee, new InsuranceClaimRole());
            }
            if(e.getName().equals("NewHampshire Hospital")){
                Employee hospE = e.getEmployeeDirectory().createEmployee("hospE");
                Employee patE = e.getEmployeeDirectory().createEmployee("patE");
                e.getUserAccountDirectory().createUserAccount("h1", "h1", hospE, new AdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.AmbulanceDriver);
                employee =org.getEmployeeDirectory().createEmployee("ambuEmp1");
                org.getUserAccountDirectory().createUserAccount("amb1", "amb1", employee, new AmbulanceDriverRole());
                employee =org.getEmployeeDirectory().createEmployee("ambuEmp2");
                org.getUserAccountDirectory().createUserAccount("amb2", "amb2", employee, new AmbulanceDriverRole());

                
            }
            if(e.getName().equals("Excellence Hospital")){
                Employee hospE = e.getEmployeeDirectory().createEmployee("hospE2");
                e.getUserAccountDirectory().createUserAccount("h2", "h2", hospE, new AdminRole());
                org = e.getOrganizationDirectory().createOrganization(Organization.Type.AmbulanceDriver);
                employee =org.getEmployeeDirectory().createEmployee("ambuEmp2");
                org.getUserAccountDirectory().createUserAccount("amb3", "amb3", employee, new AmbulanceDriverRole());
                employee =org.getEmployeeDirectory().createEmployee("ambuEmp2");
                org.getUserAccountDirectory().createUserAccount("amb4", "amb4", employee, new AmbulanceDriverRole());

               

            }
        }

        JOptionPane.showMessageDialog(null,"Load Complete!");*/
    }//GEN-LAST:event_btnVacLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdmin;
    private javax.swing.JButton btnManageEnterprise;
    private javax.swing.JButton btnManageNetwork;
    private javax.swing.JButton btnManagePatient;
    private javax.swing.JButton btnVacLoad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lab;
    private javax.swing.JLabel lblSelectedNode;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnltab;
    // End of variables declaration//GEN-END:variables
}
