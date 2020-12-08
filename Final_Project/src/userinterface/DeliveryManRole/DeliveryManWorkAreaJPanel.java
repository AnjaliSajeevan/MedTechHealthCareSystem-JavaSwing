/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DeliveryManRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Essentials.Medicine;
import Business.Organization.LaboratoryOrganization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabPatientWorkRequest;
import Business.WorkQueue.PharmaWorkRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manasa
 */
public class DeliveryManWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryManWorkAreaJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    UserAccount account;
    PharmacyOrganization organization;
    public DeliveryManWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PharmacyOrganization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = organization;
        populatePatientRequests();
    }
    public void populatePatientRequests(){
                      DefaultTableModel model = (DefaultTableModel)medicineTable.getModel();
        model.setRowCount(0);
        List<PharmaWorkRequest> requestList = account.getPharmaWorkQueue().getPharmaList();
        for(PharmaWorkRequest req: requestList){
            String medList = "";
                Map<Medicine,Integer> medMap= req.getMedList();
                for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {  
                    if(medList.equals("")){
                        medList+=medicine.getKey();
                    }else{    
                        medList+=","+medicine.getKey();
                  }
                } 
             Object row[] = new Object[8];
             row[0] = req;
                 row[1] = req.getReceiver();
                 row[2] = medList;
                 row[3] = req.getSender();
                 row[4] = req.getMessage();
                 model.addRow(row); 
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineTable = new javax.swing.JTable();
        btnProcess = new javax.swing.JButton();
        txtMsg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("DeliveryMan Panel");

        medicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PatientName", "Medicine", "Sender", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(medicineTable);
        if (medicineTable.getColumnModel().getColumnCount() > 0) {
            medicineTable.getColumnModel().getColumn(0).setResizable(false);
            medicineTable.getColumnModel().getColumn(1).setResizable(false);
            medicineTable.getColumnModel().getColumn(2).setResizable(false);
            medicineTable.getColumnModel().getColumn(3).setResizable(false);
        }

        btnProcess.setText("Process Request");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel2.setText("Delivery Message:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
                int selectedRow = medicineTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Request from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PharmaWorkRequest req= (PharmaWorkRequest)medicineTable.getValueAt(selectedRow, 0);
        
        UserAccount ua = req.getReceiver();
        req.setMessage(txtMsg.getText());
        ua.getPharmaWorkQueue().updatePharmaRequest(req, ua.getPharmaWorkQueue().getPharmaList());
        account.getPharmaWorkQueue().removePharmaRequest(req);
                
        Map<String,Date> reqMap = req.getStatusMap();
        reqMap.put(account+" Update:"+txtMsg.getText(), new Date());
        reqMap.put("Request Completed by-"+account, new Date());
        req.setStatusMap(reqMap);
        //    pharmaRequest.setSender(account);
        account.getPharmaWorkQueue().removePharmaRequest(req);
        business.getPharmaQueue().updatePharmaRequest(req, business.getPharmaQueue().getPharmaList());
        JOptionPane.showMessageDialog(null, "Message Submitted!", "Information", JOptionPane.INFORMATION_MESSAGE);
        populatePatientRequests();
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicineTable;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables
}
