/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import static java.lang.Boolean.FALSE;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
private EcoSystem business;
    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;
        this.business=business;
        popOrganizationComboBox();
       // employeeJComboBox.removeAllItems();
        popData();
    }

    public void popOrganizationComboBox(){
        organizationJComboBox.removeAllItems();
        organizationJComboBox.addItem("");
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization.getOrganizationType());
        }
    }
    
    public void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();
        employeeJComboBox.addItem("");
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            employeeJComboBox.addItem(employee);
        }
    }
    
    private void populateRoleComboBox(Organization organization,String type){
        roleJComboBox.removeAllItems();
         roleJComboBox.addItem("");
        for (Role role : organization.getSupportedRole()){
                        String pwdRegex = ".*Admin.*";
            Pattern pwdPattern = Pattern.compile(pwdRegex);
            Matcher pwdCheck = pwdPattern.matcher(role.toString());
            boolean checkPwd = pwdCheck.matches();
            if(checkPwd == FALSE){
                if(role.toString().equals(type)){
            roleJComboBox.addItem(role);
            }
            }
        }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
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

        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        btnRem = new javax.swing.JButton();

        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("User Name");

        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);
        if (userJTable.getColumnModel().getColumnCount() > 0) {
            userJTable.getColumnModel().getColumn(0).setResizable(false);
            userJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Password");

        jLabel3.setText("Employee");

        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backjButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Organization");

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Role");

        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRem.setText("Remove User");
        btnRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRem)
                .addGap(266, 266, 266))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205)
                        .addComponent(createUserJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnRem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backjButton1)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(createUserJButton)
                        .addGap(44, 44, 44))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        if(nameJTextField.getText().equals("") || passwordJTextField.getText().equals("")){
                  JOptionPane.showMessageDialog(null,"Username and Password are mandatory fields!");
                 return;            
        }
        if( employeeJComboBox.getSelectedItem().toString().equals("") || roleJComboBox.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null,"Selecting Employee and Role is mandatory!");
                 return;           
        }
        Organization organization = null;
               for(Network n: business.getNetworkList()){
        for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){

        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
           for(UserAccount ua:org.getUserAccountDirectory().getUserAccountList()){
            if(ua.getUsername().equals(userName)){
          JOptionPane.showMessageDialog(null, "Username already exists!");
            return;    
            }
        } 
        }
        }
               }
        
        Employee employee = (Employee) employeeJComboBox.getSelectedItem();
        Role role = (Role) roleJComboBox.getSelectedItem();
        organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        if(role.toString().equals("Doctor"))
        {
            Doctor d= new Doctor();
            d.setUserName(userName);
            d.setName(userName);
            System.out.println("mange user acc USername"+ d.getUserName());
            business.getDoctorDirectory().addDoctor(d);
        }
        popData();
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void btnRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemActionPerformed
        // TODO add your handling code here:
         int selectedRow = userJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row to remove!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you Sure you want to delete the User?","Confirm Delete",JOptionPane.YES_NO_OPTION);
        Organization organization = null;  
        if(confirmed == JOptionPane.YES_OPTION){
                UserAccount ua= (UserAccount)userJTable.getValueAt(selectedRow, 0);
                for(Network n: business.getNetworkList()){
                    for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                        for(Organization org: e.getOrganizationDirectory().getOrganizationList()){
                           for(UserAccount user : org.getUserAccountDirectory().getUserAccountList()){
                               if(user.equals(ua)){
                               organization = org;
                           }
                           }
                        }
                    }
                }
                if(organization  != null){
                organization.getUserAccountDirectory().removeUserAccount(ua);
                        }
            }
                  JOptionPane.showMessageDialog(null, "User Account removed!", "Warning", JOptionPane.WARNING_MESSAGE);
            popData();
    }//GEN-LAST:event_btnRemActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = null;
        for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(org.getOrganizationType().equals(organizationJComboBox.getSelectedItem())){
                organization = org;
            }
        }
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization,organizationJComboBox.getSelectedItem().toString());
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton btnRem;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
