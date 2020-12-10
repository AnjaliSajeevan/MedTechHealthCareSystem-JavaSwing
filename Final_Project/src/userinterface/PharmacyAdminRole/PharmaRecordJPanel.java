/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Essentials.Medicine;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmaWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manasa
 */
public class PharmaRecordJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmaRecordJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    PharmacyOrganization organization;
    public PharmaRecordJPanel(JPanel userProcessContainer, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
                populateAllRecords();
        populateTimeline("");
    }
    public void populateAllRecords(){
               DefaultTableModel model = (DefaultTableModel)respTable.getModel();
        model.setRowCount(0);
        List<PharmaWorkRequest> requestList = business.getPharmaQueue().getPharmaList();
        for(PharmaWorkRequest req: requestList){
            if(req.getEnterprise().equals(enterprise.getName())){
                            String medList = "";
                Map<Medicine,Integer> medMap= req.getMedList();
                for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {  
                    if(medList.equals("")){
                        medList+=medicine.getKey();
                    }else{    
                        medList+=","+medicine.getKey();
                  }
                } 
                    Map<String,Date> map = req.getStatusMap();
                    String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : req.getStatusMap().entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0){
                    latestKey = mapEntry.getKey();
                }
               }
            Object row[] = new Object[9];
                         row[0] = req;
                         if(req.getSender() == null){
                             row[1] = "";
                         }else{
                 row[1] = req.getSender();  
                         }
                 row[2] = medList;
                 row[3] = req.getCreateDate();
                 row[4] = req.getCondition();
                 row[5] = latestKey;
           model.addRow(row);    
            }
        }
    }
     private  Map<String,Date> sortByDate(Map<String, Date> map){
        List<Map.Entry<String, Date>> tempList = new LinkedList<Map.Entry<String, Date>>(map.entrySet());
        Collections.sort(tempList, new Comparator<Map.Entry<String, Date>>(){
            public int compare(Map.Entry<String, Date> obj1,Map.Entry<String, Date> obj2) {
                    return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        Map<String, Date> sortedMap = new LinkedHashMap<String, Date>();
        for (Map.Entry<String, Date> entry : tempList){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
       public void populateTimeline(PharmaWorkRequest req){
       DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);
           Map<String,Date> map = req.getStatusMap();
           Map<String, Date> Sortedmap = sortByDate(map);
            for (Map.Entry<String,Date> mapEntry : Sortedmap.entrySet()) {
                            Object row[] = new Object[5];
                 row[0] =mapEntry.getValue(); 
                 row[1] = mapEntry.getKey();
                  model.addRow(row); 
               }
      }
              public void populateTimeline(String req){
       DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);
              }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        respTable = new javax.swing.JTable();
        btnTime = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        timelineTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        respTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "RequestID", "PatientName", "Medicine", "RequestDate", "CovidCondition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(respTable);

        btnTime.setText("View Timeline");
        btnTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeActionPerformed(evt);
            }
        });

        timelineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(timelineTable);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Pharmacy History Records");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(btnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTime)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeActionPerformed
        // TODO add your handling code here:
        int selectedRow = respTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PharmaWorkRequest pharma= (PharmaWorkRequest)respTable.getValueAt(selectedRow, 0);

        populateTimeline(pharma);
    }//GEN-LAST:event_btnTimeActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PharmaReportJPanel sysAdminwjp = (PharmaReportJPanel) component;
        sysAdminwjp.populateCovidCases(); 
        sysAdminwjp.populateAgeGroup();
        sysAdminwjp.populateMedicineGraph();
        sysAdminwjp.populateNewMedList();
        sysAdminwjp.populateConditionDemand(); 
        sysAdminwjp.populateConditionMedDemands();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable respTable;
    private javax.swing.JTable timelineTable;
    // End of variables declaration//GEN-END:variables
}
