

package userinterface.AdministrativeRole;

import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Organization.Organization.Type.Doctor;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  raunak
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    /** Creates new form AdminWorkAreaJPanel */
    public AdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business=business;
        valueLabel.setText(enterprise.getName());
        populateComboBox();
    }
    public void populateComboBox(){
        availableDoctor.removeAllItems();
        DefaultComboBoxModel dm=new DefaultComboBoxModel();
        
        
        for(Doctor n : business.getDoctorDirectory().getdoctorlist())
        {
            if(enterprise.getName().equalsIgnoreCase(n.getHospital()))
            {
                availableDoctor.addItem(n.getName());    
            }
   }
       //RestaurantComboBox.setModel(dm);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpatientAppointment = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAccept = new javax.swing.JButton();
        availableDoctor = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        emergencyRequestTable = new javax.swing.JTable();
        btnAcceptAmbulance = new javax.swing.JButton();
        btnAssignAmbulanceDriver = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTimeSlot = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Hospital-Adminstrative Role");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        userJButton.setText("Manage User");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });
        add(userJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 150, -1));

        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });
        add(manageEmployeeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 180, -1));

        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });
        add(manageOrganizationJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, -1));

        tblpatientAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Name", "Health Condition"
            }
        ));
        jScrollPane1.setViewportView(tblpatientAppointment);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 410, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Patient Appointment Request");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        btnAccept.setText("Accept Appointment");
        add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        availableDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(availableDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        emergencyRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient Name", "Address", "Desciption"
            }
        ));
        jScrollPane2.setViewportView(emergencyRequestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 370, 90));

        btnAcceptAmbulance.setText("Accept Request");
        btnAcceptAmbulance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptAmbulanceActionPerformed(evt);
            }
        });
        add(btnAcceptAmbulance, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, -1, -1));

        btnAssignAmbulanceDriver.setText("Assign Ambulance");
        btnAssignAmbulanceDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignAmbulanceDriverActionPerformed(evt);
            }
        });
        add(btnAssignAmbulanceDriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Emergency Request");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 170, -1));

        add(jComboBoxTimeSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 70, -1));

        btnSubmit.setText("Check Time Slots");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        jLabel4.setText("Time slot available:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        btnConfirm.setText("Submit");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));

        btnDecline.setText("Decline Appointment");
        add(btnDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jLabel5.setText("Assign Doctor:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise);
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

        ManageOrganizationJPanel manageOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),"Hospiatal Organization");
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void btnAssignAmbulanceDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignAmbulanceDriverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAssignAmbulanceDriverActionPerformed

    private void btnAcceptAmbulanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptAmbulanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcceptAmbulanceActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        jComboBoxTimeSlot.removeAllItems();
        int selectedRow =  tblpatientAppointment.getSelectedRow();
        String doctor= (String) availableDoctor.getSelectedItem();
        if(selectedRow <0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row","Warning", JOptionPane.WARNING_MESSAGE);

        }

        else
        {
            for(Doctor n : business.getDoctorDirectory().getdoctorlist())
        {
            if(n.getName().equals(doctor))
            {for (int i=0;i<n.getTimeSlotList().size();i++)
            {   String x=n.getTimeSlotList().get(i);
                jComboBoxTimeSlot.addItem(x);
            }    
                }
                
            }
            
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here: PatientAppointment WorkRequest Part
        
    }//GEN-LAST:event_btnConfirmActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> availableDoctor;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAcceptAmbulance;
    private javax.swing.JButton btnAssignAmbulanceDriver;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTable emergencyRequestTable;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxTimeSlot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JTable tblpatientAppointment;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}
