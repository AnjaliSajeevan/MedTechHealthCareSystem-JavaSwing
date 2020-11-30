/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Network.Network;
import Business.Organization.InsuranceAdminOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import userinterface.InsuranceAdminWorkArea.ViewPolicyWorkAreaJPanel;

/**
 *
 * @author Anjali
 */
public class RegisterForInsurance extends javax.swing.JPanel {

    /**
     * Creates new form RegisterForInsurance
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    UserAccount userAccount;
  InsuranceAdminOrganization organization;
    public RegisterForInsurance(JPanel userProcessContainer, UserAccount userAccount, EcoSystem ecosystem,InsuranceAdminOrganization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        this.userAccount=userAccount;
        this.organization=organization;

        
    for(Network network:ecosystem.getNetworkList()){
    for(Enterprise e:network.getEnterpriseDirectory().getEnterpriseList()){
    if(e.getEnterpriseType().equals(e.getEnterpriseType().Insurance)){
           jComboBox1.addItem(e.getName());   
    
    }
    }
    }
    }
    
     public void populateTree(){
     
       String y=(String) jComboBox1.getSelectedItem();
        int flag=0;
        DefaultTableModel model = (DefaultTableModel) tblSearch.getModel();
                model.setRowCount(0);
        for (InsurancePolicy r: ecosystem.getInsurancePolicyDirectory().getInsurancePolicyList()) {
          
            if (r.getEnterprise().equals(y)) {
                flag=1;}
                else{flag=0;
            }
            if(flag==1){               
                Object row[] = new Object[6];
                row[0] = r;
                row[1] = r.getZipCode();
                row[2] = r.getMonthlyPremium();
                row[3] = r.getAgeGroup();
                row[4] = r.getPolicyMax();
                row[5] = r.getPolicyType();
                ((DefaultTableModel) tblSearch.getModel()).addRow(row);
                      
            }
            flag=0;
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtzipCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnSelectInsurance = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConfirmedPolicy = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtAdult = new javax.swing.JTextField();
        btnSubmit1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStatus = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxHospitalList = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnSubmitPrimaryHospital = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Search for Insurance Policy:");

        jLabel3.setText("Policy Type:");

        jLabel4.setText("Age:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "18-30", "30-45", "45-60", "60-80", "80-100" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy Name", "Zipcode", "Monthly Premium", "AgeGroup", "PolicyMax", "Policy Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSearch);
        if (tblSearch.getColumnModel().getColumnCount() > 0) {
            tblSearch.getColumnModel().getColumn(0).setResizable(false);
            tblSearch.getColumnModel().getColumn(1).setResizable(false);
            tblSearch.getColumnModel().getColumn(2).setResizable(false);
            tblSearch.getColumnModel().getColumn(3).setResizable(false);
            tblSearch.getColumnModel().getColumn(4).setResizable(false);
            tblSearch.getColumnModel().getColumn(5).setResizable(false);
            tblSearch.getColumnModel().getColumn(5).setHeaderValue("");
        }

        jLabel6.setText("Zip Code:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Choose Insurance Company:");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Register for Insurance");

        btnSelectInsurance.setText("Request");
        btnSelectInsurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectInsuranceActionPerformed(evt);
            }
        });

        btnView.setText("View Insurance Policy Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Family", "Individual" }));

        btnBack.setText("<-Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblConfirmedPolicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy Name", "Policy Type", "Policy Maximum", "Total members", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblConfirmedPolicy);
        if (tblConfirmedPolicy.getColumnModel().getColumnCount() > 0) {
            tblConfirmedPolicy.getColumnModel().getColumn(0).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(1).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(2).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(3).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(4).setResizable(false);
            tblConfirmedPolicy.getColumnModel().getColumn(4).setHeaderValue("Total Cost");
        }

        jLabel2.setText("If family policy enter the number of members:");

        txtAdult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAdultMouseClicked(evt);
            }
        });
        txtAdult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdultActionPerformed(evt);
            }
        });

        btnSubmit1.setText("Submit");
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });

        tblStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestNo.", "Receiver", "Insurance Policy", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStatus);
        if (tblStatus.getColumnModel().getColumnCount() > 0) {
            tblStatus.getColumnModel().getColumn(0).setResizable(false);
            tblStatus.getColumnModel().getColumn(1).setResizable(false);
            tblStatus.getColumnModel().getColumn(2).setResizable(false);
            tblStatus.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel8.setText("Request Status:");

        jComboBoxHospitalList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Choose Primary Hospital if status updated:");

        btnSubmitPrimaryHospital.setText("Submit");
        btnSubmitPrimaryHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPrimaryHospitalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(btnView))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnSubmit1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSelectInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnSubmit))
                            .addComponent(btnRefresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtzipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(174, 174, 174)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxHospitalList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubmitPrimaryHospital)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnBack))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtzipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAdult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSubmit1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectInsurance)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxHospitalList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmitPrimaryHospital))
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         InsurancePolicy  zipCode = null;
         InsurancePolicy age = null;
     
         InsurancePolicy pType=null;
         String ageGroup = (String) jComboBox3.getSelectedItem();
         String prefferedpolicy = (String) jComboBox2.getSelectedItem();
         String error = "";
        
        if((txtzipCode.equals(""))){
          
            JOptionPane.showMessageDialog(null, "Please enter all the required details", "Information", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        else{
                    zipCode = ecosystem.getInsurancePolicyDirectory().searchzipCode(txtzipCode.getText());
                    age = ecosystem.getInsurancePolicyDirectory().searchAge(ageGroup);
     
                   
                    
                    System.out.println(prefferedpolicy);
                    pType = ecosystem.getInsurancePolicyDirectory().searchpolicy(prefferedpolicy);

            }
           
            if ((zipCode == null) || (age == null) || (pType == null)) {
                error = "No policies exists for the entered details";
                JOptionPane.showMessageDialog(null, error, "Information", JOptionPane.INFORMATION_MESSAGE);
               
            }
            else{
            
            
            String zips = txtzipCode.getText();
            String policyType = (String) jComboBox2.getSelectedItem();
            
            String type=(String) jComboBox3.getSelectedItem();
            
            DefaultTableModel dtm = (DefaultTableModel)tblSearch.getModel(); 
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblSearch.getModel());
            tblSearch.setRowSorter(rowSorter);
            List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(6);
            filters.add(RowFilter.regexFilter(zips.trim(),1));
            filters.add(RowFilter.regexFilter(policyType.trim(),5)); 
            filters.add(RowFilter.regexFilter(ageGroup.trim(),3));

            RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
            rowSorter.setRowFilter(rf);
            populateTree();
            
            }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        populateTree();
   
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnSelectInsuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectInsuranceActionPerformed
        // TODO add your handling code here:

        String s=userAccount.getUsername();
        int selectedRow =  tblConfirmedPolicy.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
        
        InsuranceWorkRequest request = new InsuranceWorkRequest();
        request.setSender(userAccount);
        request.setStatus("Insurance Requested");
        InsurancePolicy a = (InsurancePolicy) tblSearch.getValueAt(selectedRow, 0);
        request.setEnterprise(a.getEnterprise());
        request.setInsurancepolicy(a.getPolicyName());
        ecosystem.getWorkQueue().getWorkRequestList().add(request);
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        DefaultTableModel model = (DefaultTableModel)tblStatus.getModel();
        model.setRowCount(0);
               if(request.getReceiver()==null){
                s="Not Assigned";
            }else{ s= request.getReceiver().getEmployee().getName();
                
            }
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = s;
            row[2] = request.getInsurancepolicy();
            row[3] = request.getStatus();
            model.addRow(row);
             JOptionPane.showMessageDialog(null,"Successfully requested for insurance");
             
            
            for (int counter = 0; counter < a.getHospitalList().size(); counter++) {
                    jComboBoxHospitalList.addItem(a.getHospitalList().get(counter));
                }
            
        }
        
            

        
    }//GEN-LAST:event_btnSelectInsuranceActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow =  tblSearch.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
            InsurancePolicy a = (InsurancePolicy) tblSearch.getValueAt(selectedRow, 0);
            ViewPolicyWorkAreaJPanel vpeaj = new ViewPolicyWorkAreaJPanel(userProcessContainer, ecosystem, a);
            userProcessContainer.add("ViewPolicyWorkAreaJPanel", vpeaj);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTree();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtAdultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdultActionPerformed

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        double x=Double.parseDouble(txtAdult.getText());
        double z;
        int selectedRow =  tblSearch.getSelectedRow();
        
        InsurancePolicy r =(InsurancePolicy) tblSearch.getValueAt(selectedRow, 0);
       if(r.getPolicyType().equals("Family"))
       {    double y = x*r.getMonthlyPremium();
            z=x;
           r.setTotalcost(y);
       }else {
           r.setTotalcost(r.getMonthlyPremium());
           z=1;
       }
        DefaultTableModel model = (DefaultTableModel)tblConfirmedPolicy.getModel();
        model.setRowCount(0);
        
            Object row[] = new Object[5];
                row[0] = r;
                row[1] = r.getPolicyType();
                row[2] = r.getPolicyMax();
                row[3] = z;
                row[4] = r.getTotalcost();

            model.addRow(row);                    
        
    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void txtAdultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAdultMouseClicked
        // TODO add your handling code here:
       int selectedRow =  tblSearch.getSelectedRow(); 
        InsurancePolicy r =(InsurancePolicy) tblSearch.getValueAt(selectedRow, 0);
       if(r.getPolicyType().equals("Individual"))
       { JOptionPane.showMessageDialog(null,"Enter for policy type family only");
           
       }
        
    }//GEN-LAST:event_txtAdultMouseClicked

    private void btnSubmitPrimaryHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPrimaryHospitalActionPerformed
        // TODO add your handling code here:
       int selectedRow =  tblStatus.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
        
        InsuranceWorkRequest a =  (InsuranceWorkRequest) tblStatus.getValueAt(selectedRow, 0);
            if(a.getStatus().equals("Approved"))
            {
        String y = (String) jComboBoxHospitalList.getSelectedItem();
        for(Patient p:ecosystem.getPatientDirectory().getpatientlist())
        {if(p.getUserName().equals(userAccount.getUsername()))
        {p.setPrimaryHospital(y);
            } 
        }
            }else {JOptionPane.showMessageDialog(null,"The Insurance policy request should be approved to select primary hospital");
            }
            }
    }//GEN-LAST:event_btnSubmitPrimaryHospitalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelectInsurance;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JButton btnSubmitPrimaryHospital;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBoxHospitalList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblConfirmedPolicy;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTable tblStatus;
    private javax.swing.JTextField txtAdult;
    private javax.swing.JTextField txtzipCode;
    // End of variables declaration//GEN-END:variables
}
