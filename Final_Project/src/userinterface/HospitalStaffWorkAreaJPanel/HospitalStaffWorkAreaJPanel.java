/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalStaffWorkAreaJPanel;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Essentials.Product;
import Business.Essentials.ProductCatalog;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Organization.AdminOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.InsuranceAdminWorkArea.ViewPolicyWorkAreaJPanel;

/**
 *
 * @author Anjali
 */
public class HospitalStaffWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalStaffWorkAreaJPanel
     */
    private JPanel userProcessContainer;
 private ProductCatalog productcatalog;
    private Enterprise enterprise;
    private UserAccount account;
    private EcoSystem ecosystem;
    public HospitalStaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,  Enterprise enterprise,EcoSystem ecosystem) {
        initComponents();
  
        this.ecosystem=ecosystem;
         this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account=account;
        enterprise.getName();
        System.out.println("enterprise.getName() "+enterprise.getName());
        
        //txtName.setText(s.getSupplyName());
        populateEssentialTable();
    }
public void populateEssentialTable(){
        DefaultTableModel model = (DefaultTableModel)essentialTable.getModel();
        model.setRowCount(0);
        List<Product> productList = ecosystem.getProductCatalog().getProductcatalog(); 
        
        for(Product tester: productList){
            if(tester.getProdName().equalsIgnoreCase("Room") ){
                int countR=tester.getAvail();
                txtRoomCount.setText(String.valueOf(countR));
            }if(tester.getProdName().equalsIgnoreCase("Deluxe Room") ){
                int countR=tester.getAvail();
                txtDeluxe.setText(String.valueOf(countR));
            }
            if(tester.getProdName().equalsIgnoreCase("ICU") ){
                int countR=tester.getAvail();
                txtICU.setText(String.valueOf(countR));
            }
            else{
            
            Object row[] = new Object[4];
                 row[0] = tester;
                 row[1] = tester.getAvail();
                      
                 
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        essentialTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtRoomCount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtICU = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDeluxe = new javax.swing.JTextField();

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Hospital Staff- Essentials Management");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnCreate.setText("Create ");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel2.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel2.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 70, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 70, -1));

        essentialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(essentialTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 330, 90));

        jLabel1.setText("General Ward");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        txtRoomCount.setText(" ");
        txtRoomCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomCountActionPerformed(evt);
            }
        });
        jPanel2.add(txtRoomCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Room Avaliability Count");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel4.setText("ICU ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        txtICU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtICUActionPerformed(evt);
            }
        });
        jPanel2.add(txtICU, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 140, -1));

        jLabel5.setText("Deluxe Room");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));
        jPanel2.add(txtDeluxe, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 140, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateJPanel panel=new CreateJPanel(userProcessContainer,ecosystem);
        userProcessContainer.add("CreateJPanel",panel);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
         int selectedRow =  essentialTable.getSelectedRow();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Pleasse select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        { 
            Product p = (Product) essentialTable.getValueAt(selectedRow, 0);
            System.out.println(p);
            ViewJPanel vpeaj = new ViewJPanel(userProcessContainer, ecosystem, p);
            userProcessContainer.add("ViewJPanel", vpeaj);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void txtRoomCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomCountActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_txtRoomCountActionPerformed

    private void txtICUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtICUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtICUActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnView;
    private javax.swing.JTable essentialTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDeluxe;
    private javax.swing.JTextField txtICU;
    private javax.swing.JTextField txtRoomCount;
    // End of variables declaration//GEN-END:variables
}
