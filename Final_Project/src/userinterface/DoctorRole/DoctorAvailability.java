/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Doctor.Doctor;
import Business.EcoSystem;
import static Business.Organization.Organization.Type.Doctor;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author Anjali
 */
public class DoctorAvailability extends javax.swing.JPanel {

    /**
     * Creates new form DoctorAvailability
     */
    JPanel userProcessContainer; 
    UserAccount account;
    EcoSystem ecosystem;
    Date dfrom;
    Date dto;
    public DoctorAvailability(JPanel userProcessContainer, UserAccount account,EcoSystem ecosystem) {
        initComponents();
        this.ecosystem=ecosystem;
        this.account=account;
        this.userProcessContainer=userProcessContainer;
        dateFrom.setDate(new Date());
        dateTo.setDate(new Date());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboTime = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dateTo = new com.toedter.calendar.JDateChooser();
        dateFrom = new com.toedter.calendar.JDateChooser();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Available Days and Time Slots");

        jLabel2.setText("Available Time:");

        jLabel4.setText("Available Date From:");

        jComboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00 - 16:00", "16:00 - 24:00", "01:00 - 08:00", "LEAVE" }));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel7.setText("Available Date To:");

        dateFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateFromMouseClicked(evt);
            }
        });

        btnBack.setText("<- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(235, 235, 235))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(btnSubmit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(btnSubmit)
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateFromMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateFromMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {dfrom=dateFrom.getDate();
        dto=dateTo.getDate();

        }   
    }//GEN-LAST:event_dateFromMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String t = (String) jComboTime.getSelectedItem();
        for (Doctor doc : ecosystem.getDoctorDirectory().getdoctorlist()) {
            if (doc.getUserName().equals(account.getUsername())) {
                doc.setDateFrom(dfrom);
                doc.setDateTo(dto);
                doc.setTime(t);
                if (doc.getTime().equals("08:00 - 16:00")) {
                    String from = "08:00:00", to = "16:00:00";
                    LocalTime fromTime = LocalTime.parse(from), toTime = LocalTime.parse(to);

                    for (LocalTime counter = fromTime;
                            counter.compareTo(toTime) <= 0;
                            counter = counter.plusMinutes(30)) {
                        doc.addTimeSlot(counter.toString());
                        
                    }

                }else if(doc.getTime().equals("16:00 - 24:00")){
                    String from = "16:00:00", to = "24:00:00";
                    LocalTime fromTime = LocalTime.parse(from), toTime = LocalTime.parse(to);

                    for (LocalTime counter = fromTime;
                            counter.compareTo(toTime) <= 0;
                            counter = counter.plusMinutes(30)) {
                        doc.addTimeSlot(counter.toString());
                        
                    }
            }else if(doc.getTime().equals("01:00 - 08:00")){
                    String from = "01:00:00", to = "08:00:00";
                    LocalTime fromTime = LocalTime.parse(from), toTime = LocalTime.parse(to);

                    for (LocalTime counter = fromTime;
                            counter.compareTo(toTime) <= 0;
                            counter = counter.plusMinutes(30)) {
                        doc.addTimeSlot(counter.toString());
                      
                    }
            }
                
                
        }
        }


    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JComboBox<String> jComboTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
