/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.Essentials.Medicine;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabPatientWorkRequest;
import Business.WorkQueue.PatientHospitalAppointmentWorkRequest;
import Business.WorkQueue.PharmaWorkRequest;
import com.lowagie.text.Chunk;


import java.awt.CardLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author sayu
 */
public class PatientHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientHistoryJPanel
     */
    EcoSystem ecosystem;
    JPanel userProcessContainer;
    UserAccount account;
   String patient;
   String timeLineHospital;
   String timeLineLaboratory;
   String timeLinePharmacy;
   
    public PatientHistoryJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.account = account;
        populateTable();
        populateTableLab();
        populateTablePhar();
        patient = account.getEmployee().getName();
        jLabel5.setText(patient);
    }
     public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblpatientAppointment.getModel();
        model.setRowCount(0);

        for (PatientHospitalAppointmentWorkRequest request : ecosystem.getHospitalQueue().hospitalRequestList()) {
            if (request.getSender().equals(account)) {
                System.out.println("Hi");
                Map<String, Date> map = request.getStatusMap();
                String latestKey = "";
                for (Map.Entry<String, Date> mapEntry : request.getStatusMap().entrySet()) {
                    if (latestKey.equals("")) {
                        latestKey = mapEntry.getKey();
                    }
                }
                    Object[] row = new Object[7];
                    row[0] = request;
                    row[1] = request.getAppDate();
                    row[2] = request.getTime();
                    row[3] = latestKey;
                    row[4] = request.getHospital();
                    row[5] = request.getDoctor();
                    row[6] = request.getResult();

                    model.addRow(row);
                }

        }
    }

    public void populateTableLab() {
        DefaultTableModel model = (DefaultTableModel) labTestingTable.getModel();
        model.setRowCount(0);

        for (LabPatientWorkRequest request : ecosystem.getLabPatQueue().getLabPatientRequestList()) {
            if (request.getPatient().equals(account)) {
                Map<String, Date> map = request.getStatusMap();
                String latestKey = "";
                for (Map.Entry<String, Date> mapEntry : request.getStatusMap().entrySet()) {
                    if (latestKey.equals("")) {
                        latestKey = mapEntry.getKey();
                    }
                    if ((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0) {
                        latestKey = mapEntry.getKey();
                    }
                }
                Object[] row = new Object[8];
                row[0] = request;
                row[1] = request.getEnterprise();
                row[2] = request.getLabTestType();
                row[3] = request.getPatient();
                row[4] = latestKey;
                row[5] = request.getMessage();

                model.addRow(row);
            }
        }

    }
           
           public void populateTablePhar(){
        DefaultTableModel model = (DefaultTableModel)pharmaTable.getModel();
        model.setRowCount(0);
        List<PharmaWorkRequest> requestList = ecosystem.getPharmaQueue().getPharmaList();
        for(PharmaWorkRequest req: requestList){
            if(req.getCust().equals(account)){
            String medList1 = "";
                Map<Medicine,Integer> medMap= req.getMedList();
                for (Map.Entry<Medicine,Integer> medicine : medMap.entrySet()) {  
                    if(medList1.equals("")){
                        medList1+=medicine.getKey();
                    }else{    
                        medList1+=","+medicine.getKey();
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
             Object row[] = new Object[8];
                 row[0] = req;
                 row[1] = medList1;   
                 if(req.getSender() == null){
                 row[2] = "In-Person";  
                 }else{
                 row[2] = req.getSender();
                 }
                 row[3] = latestKey;
                 row[4] = req.getMessage();
                 model.addRow(row); 
            }
        }
    
        
    }
       public void populateTestingTable(){
        DefaultTableModel model = (DefaultTableModel)labTestingTable.getModel();
        model.setRowCount(0);
        for(LabPatientWorkRequest work : account.getLabPatientWorkQueue().getLabPatientRequestList()){
                 Map<String,Date> map = work.getStatusMap();
                String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : map.entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0){
                latestKey = mapEntry.getKey();
                }
                }
                    Object[] row = new Object[8];
                    row[0] = work;
                    row[1] = work.getLabTestType();
                    row[2] = work.getPatient();
                     row[3] = work.getSlotDate();
                    row[4] = work.getSlotTime();
                    row[5] = latestKey;
                    row[6] = work.getMessage();

                    model.addRow(row);  
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
  
      public void populateTimeline(LabPatientWorkRequest req){
       DefaultTableModel model = (DefaultTableModel)labTimeline.getModel();
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
       public void populateTimeline(PharmaWorkRequest req){
       DefaultTableModel model = (DefaultTableModel)pharmaTimeline.getModel();
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
       public void populateTimeline(PatientHospitalAppointmentWorkRequest req){
       DefaultTableModel model = (DefaultTableModel)hospTimeline.getModel();
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
 
     public void populateTimeline(String blank){
       DefaultTableModel model = (DefaultTableModel)hospTimeline.getModel();
        model.setRowCount(0);
               DefaultTableModel model2 = (DefaultTableModel)labTimeline.getModel();
        model2.setRowCount(0);
               DefaultTableModel model3 = (DefaultTableModel)pharmaTimeline.getModel();
        model3.setRowCount(0);
         
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
        jScrollPane6 = new javax.swing.JScrollPane();
        hospTimeline = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpatientAppointment = new javax.swing.JTable();
        btnHosTimeline = new javax.swing.JButton();
        btnGeneratePdf = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnLabTimeline = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        labTimeline = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        labTestingTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pharTimeline = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        pharmaTimeline = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        pharmaTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        hospTimeline.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(hospTimeline);

        jLabel1.setText("Hospital appointment history");

        tblpatientAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment No.", "Date", "Time", "Status", "Hospital", "Doctor", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblpatientAppointment);

        btnHosTimeline.setText("View Timeline");
        btnHosTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHosTimelineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHosTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(434, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHosTimeline)
                .addGap(16, 16, 16))
        );

        btnGeneratePdf.setText("Generate pdf");
        btnGeneratePdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePdfActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("'s History");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("<>");

        btnBack.setText("<-Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        jLabel2.setText("Laboratory appointment history");

        btnLabTimeline.setText("View Timeline");
        btnLabTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabTimelineActionPerformed(evt);
            }
        });

        labTimeline.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(labTimeline);

        labTestingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "LabID", "Laboratory", "TestName", "PatientName", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(labTestingTable);
        if (labTestingTable.getColumnModel().getColumnCount() > 0) {
            labTestingTable.getColumnModel().getColumn(0).setResizable(false);
            labTestingTable.getColumnModel().getColumn(1).setResizable(false);
            labTestingTable.getColumnModel().getColumn(2).setResizable(false);
            labTestingTable.getColumnModel().getColumn(3).setResizable(false);
            labTestingTable.getColumnModel().getColumn(4).setResizable(false);
            labTestingTable.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLabTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLabTimeline)
                .addGap(12, 12, 12))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setText("Pharmacy history");

        pharTimeline.setText("View Timeline");
        pharTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharTimelineActionPerformed(evt);
            }
        });

        pharmaTimeline.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(pharmaTimeline);

        pharmaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PharmacyID", "Medicine", "DeliveryStaff", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(pharmaTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pharTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pharTimeline)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(216, 216, 216)
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addGap(195, 195, 195)
                        .addComponent(btnGeneratePdf))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGeneratePdf)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHosTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHosTimelineActionPerformed
        // TODO add your handling code here:
            int selectedRow = tblpatientAppointment.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Hospital Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PatientHospitalAppointmentWorkRequest req= (PatientHospitalAppointmentWorkRequest)tblpatientAppointment.getValueAt(selectedRow, 0);
        populateTimeline(req);   
        timeLineHospital=req.getRequestNo();
    }//GEN-LAST:event_btnHosTimelineActionPerformed

    private void btnGeneratePdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePdfActionPerformed
         String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {

            path = j.getSelectedFile().getPath();

            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path+"PatientHistory.pdf"));
                doc.open();
                          
                Image image =Image.getInstance("MedTech.PNG");
                image.scaleAbsolute(80, 80);
                image.setAbsolutePosition(490f, 750f);
                doc.add(image);
                doc.add(new Paragraph((patient+"'s MedTech History"),FontFactory.getFont(FontFactory.TIMES_BOLD, 18,Font.BOLD, Color.black)));
                doc.add(new Paragraph(new Date().toString()));
                doc.add( Chunk.NEWLINE );
                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------"));
                doc.add( Chunk.NEWLINE );
                doc.add( Chunk.NEWLINE );
                
                PdfPTable tbl = new PdfPTable(7);
                tbl.setTotalWidth(600f);
                tbl.setHorizontalAlignment(1);
                tbl.setWidths(new int[]{4, 3, 2,3,3,2,2});
                tbl.setHeaderRows(2);
               
                PdfPCell cell=new PdfPCell(new Phrase("Patient Hospital History "));
                cell.setColspan(7);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(Color.cyan);
                tbl.addCell(cell);
                
                PdfPCell cell0=new PdfPCell(new Phrase(" "));
                cell0.setColspan(7);
                cell0.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell0.setBackgroundColor(Color.white);
                tbl.addCell(cell0);

                tbl.addCell("Appointment ID");
                tbl.addCell("Date");
                tbl.addCell("Time");
                tbl.addCell("Status");
                tbl.addCell("Hospital");
                tbl.addCell("Doctor");
                tbl.addCell("Result");
                
                PdfPCell cell1=new PdfPCell(new Phrase(" "));
                cell1.setColspan(7);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(Color.white);
                tbl.addCell(cell1);

                for (int i = 0; i < tblpatientAppointment.getRowCount(); i++) {
                    String appointmentID = tblpatientAppointment.getValueAt(i, 0).toString();
                    String date = tblpatientAppointment.getValueAt(i, 1).toString();
                    String time = tblpatientAppointment.getValueAt(i, 2).toString();
                    String status = tblpatientAppointment.getValueAt(i, 3).toString();
                    String hospital = tblpatientAppointment.getValueAt(i, 4).toString();
                    String doctor = tblpatientAppointment.getValueAt(i, 5).toString();
                    String result = tblpatientAppointment.getValueAt(i, 6).toString();

                    tbl.addCell(appointmentID);
                    tbl.addCell(date);
                    tbl.addCell(time);
                    tbl.addCell(status);
                    tbl.addCell(hospital);
                    tbl.addCell(doctor);
                    tbl.addCell(result);
                }

                doc.add(tbl);

                PdfPCell blankRow1 = new PdfPCell(new Paragraph("\n"));
                blankRow1.setFixedHeight(5f);
                blankRow1.setColspan(7);
                doc.add( Chunk.NEWLINE );
             
                PdfPTable tb4 = new PdfPTable(2);
                tb4.setTotalWidth(600f);
                tb4.setHorizontalAlignment(1);
                tb4.setWidths(new int[]{4, 3});
                tb4.setHeaderRows(2);
               
                PdfPCell cell9=new PdfPCell(new Phrase("Patient Hospital Timeline for Appointment No:"+timeLineHospital));
                cell9.setColspan(7);
                cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell9.setBackgroundColor(Color.cyan);
                tb4.addCell(cell9);
                
                PdfPCell cell10=new PdfPCell(new Phrase(" "));
                cell10.setColspan(7);
                cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell10.setBackgroundColor(Color.white);
                tb4.addCell(cell10);

                tb4.addCell("Date");
                tb4.addCell("Status");

                
                PdfPCell cell11=new PdfPCell(new Phrase(" "));
                cell11.setColspan(7);
                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell11.setBackgroundColor(Color.white);
                tb4.addCell(cell11);

                for (int i = 0; i < hospTimeline.getRowCount(); i++) {
                    String datesss = hospTimeline.getValueAt(i, 0).toString();
                    String status2 = hospTimeline.getValueAt(i, 1).toString();


                    tb4.addCell(datesss);
                    tb4.addCell(status2);
             
                }

                doc.add(tb4);

                PdfPCell blankRow5 = new PdfPCell(new Paragraph("\n"));
                blankRow5.setFixedHeight(5f);
                blankRow5.setColspan(7);
                doc.add( Chunk.NEWLINE );
           
                
                
                
                PdfPTable tbl2 = new PdfPTable(6);
                tbl2.setWidths(new int[]{3, 3, 2,3,2,2});
                PdfPCell cell2=new PdfPCell(new Phrase("Patient Laboratory History") );
                cell2.setColspan(7);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setBackgroundColor(Color.cyan);
                tbl2.addCell(cell2);
                
                 PdfPCell cell4=new PdfPCell(new Phrase(" "));
                cell4.setColspan(7);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setBackgroundColor(Color.white);
                tbl2.addCell(cell4);
                
                tbl2.addCell("Lab ID");
                tbl2.addCell("Laboratory");
                tbl2.addCell("Test Name");
                tbl2.addCell("Patient Name");
                tbl2.addCell("Status");
                tbl2.addCell("Message");

                PdfPCell cell5=new PdfPCell(new Phrase(" "));
                cell5.setColspan(7);
                cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell5.setBackgroundColor(Color.white);
                tbl2.addCell(cell5);
               
               
                for (int i = 0; i < labTestingTable.getRowCount(); i++) {
                    String labID = labTestingTable.getValueAt(i, 0).toString();
                    String laboratory = labTestingTable.getValueAt(i, 1).toString();
                    String labTest = labTestingTable.getValueAt(i, 2).toString();
                    String PatientName = labTestingTable.getValueAt(i, 3).toString();
                    String status = labTestingTable.getValueAt(i, 4).toString();
                    String message = labTestingTable.getValueAt(i, 5).toString();
                    


                    tbl2.addCell(labID);
                    tbl2.addCell(laboratory);
                    tbl2.addCell(labTest);
                    tbl2.addCell(PatientName);
                    tbl2.addCell(status);
                    tbl2.addCell(message);

                }

                doc.add(tbl2);
                
                PdfPCell blankRow2 = new PdfPCell(new Paragraph("\n"));
                blankRow2.setFixedHeight(5f);
                blankRow2.setColspan(7);
                doc.add( Chunk.NEWLINE );
 
                
                PdfPTable tbl5 = new PdfPTable(2);
                
                tbl5.setTotalWidth(600f);
                tbl5.setHorizontalAlignment(1);
                tbl5.setWidths(new int[]{4, 3});
                tbl5.setHeaderRows(2);
               
                PdfPCell cell19=new PdfPCell(new Phrase("Patient Laboratory Timeline for LabID No:"+timeLineLaboratory));
                cell19.setColspan(7);
                cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell19.setBackgroundColor(Color.cyan);
                tbl5.addCell(cell19);
                
                PdfPCell cell14=new PdfPCell(new Phrase(" "));
                cell14.setColspan(7);
                cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell14.setBackgroundColor(Color.white);
                tbl5.addCell(cell14);

                tb4.addCell("Date");
                tb4.addCell("Status");

                
                PdfPCell cell15=new PdfPCell(new Phrase(" "));
                cell15.setColspan(7);
                cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell15.setBackgroundColor(Color.white);
                tbl5.addCell(cell15);

                for (int i = 0; i < labTimeline.getRowCount(); i++) {
                    String datesss1 = labTimeline.getValueAt(i, 0).toString();
                    String status3 = labTimeline.getValueAt(i, 1).toString();


                    tbl5.addCell(datesss1);
                    tbl5.addCell(status3);
             
                }

                doc.add(tbl5);

                PdfPCell blankRow9 = new PdfPCell(new Paragraph("\n"));
                blankRow9.setFixedHeight(5f);
                blankRow9.setColspan(7);
                doc.add( Chunk.NEWLINE );
              
                
                              
                PdfPTable tbl3 = new PdfPTable(5);
                tbl3.setWidths(new int[]{2, 2, 2,2,2});
                PdfPCell cell3=new PdfPCell(new Phrase("Patient Pharmacy History"));
                cell3.setColspan(7);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setBackgroundColor(Color.cyan);
                tbl3.addCell(cell3);
                
                 PdfPCell cell6=new PdfPCell(new Phrase(" "));
                cell6.setColspan(7);
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell6.setBackgroundColor(Color.white);
                tbl3.addCell(cell6);
                
                
                
                tbl3.addCell("PharmacyID");
                tbl3.addCell("Medicine");
               tbl3.addCell("Delivery Status");
                tbl3.addCell("Status");
                tbl3.addCell("Message");

                 PdfPCell cell7=new PdfPCell(new Phrase(" "));
                cell7.setColspan(7);
                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell7.setBackgroundColor(Color.white);
                tbl3.addCell(cell7);

                for (int i = 0; i < pharmaTable.getRowCount(); i++) {
                    String pharmacyID = pharmaTable.getValueAt(i, 0).toString();
                    String medicine = pharmaTable.getValueAt(i, 1).toString();
                   String delivaryStatus = pharmaTable.getValueAt(i, 2).toString();
                    String statusss = pharmaTable.getValueAt(i, 3).toString();
                    String messages = pharmaTable.getValueAt(i, 4).toString();
                 


                    tbl3.addCell(pharmacyID);
                    tbl3.addCell(medicine);
                   tbl3.addCell(delivaryStatus);
                    tbl3.addCell(statusss);
                    tbl3.addCell(messages);

                }

                doc.add(tbl3);
                
                doc.add( Chunk.NEWLINE );
                
                PdfPTable tbl6 = new PdfPTable(2);
                
                tbl6.setTotalWidth(600f);
                tbl6.setHorizontalAlignment(1);
                tbl6.setWidths(new int[]{4, 3});
                tbl6.setHeaderRows(2);
               
                PdfPCell cell199=new PdfPCell(new Phrase("Patient Pharmacy Timeline for PharmacyID No:"+timeLinePharmacy));
                cell199.setColspan(7);
                cell199.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell199.setBackgroundColor(Color.cyan);
                tbl6.addCell(cell199);
                
                PdfPCell cell16=new PdfPCell(new Phrase(" "));
                cell16.setColspan(7);
                cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell16.setBackgroundColor(Color.white);
                tbl6.addCell(cell16);

                tbl6.addCell("Date");
                tbl6.addCell("Status");

                
                PdfPCell cell17=new PdfPCell(new Phrase(" "));
                cell17.setColspan(7);
                cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell17.setBackgroundColor(Color.white);
                tbl6.addCell(cell17);

                for (int i = 0; i < pharmaTimeline.getRowCount(); i++) {
                    String datesss2 = pharmaTimeline.getValueAt(i, 0).toString();
                    String status4 = pharmaTimeline.getValueAt(i, 1).toString();


                    tbl6.addCell(datesss2);
                    tbl6.addCell(status4);
             
                }

                doc.add(tbl6);

             
            
             
  
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PatientHistoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(PatientHistoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        }
 JOptionPane.showMessageDialog(null,"Report Generated Successfully!");

                            

    
    }//GEN-LAST:event_btnGeneratePdfActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLabTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLabTimelineActionPerformed
        // TODO add your handling code here:
        int selectedRow = labTestingTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Lab Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LabPatientWorkRequest lab= (LabPatientWorkRequest)labTestingTable.getValueAt(selectedRow, 0);

        populateTimeline(lab);
        timeLineLaboratory=lab.getId();
    }//GEN-LAST:event_btnLabTimelineActionPerformed

    private void pharTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharTimelineActionPerformed
        // TODO add your handling code here:
                int selectedRow = pharmaTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Pharmacy Request row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PharmaWorkRequest pharma= (PharmaWorkRequest)pharmaTable.getValueAt(selectedRow, 0);

        populateTimeline(pharma);
        timeLinePharmacy=pharma.getId();
    }//GEN-LAST:event_pharTimelineActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGeneratePdf;
    private javax.swing.JButton btnHosTimeline;
    private javax.swing.JButton btnLabTimeline;
    private javax.swing.JTable hospTimeline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable labTestingTable;
    private javax.swing.JTable labTimeline;
    private javax.swing.JButton pharTimeline;
    private javax.swing.JTable pharmaTable;
    private javax.swing.JTable pharmaTimeline;
    private javax.swing.JTable tblpatientAppointment;
    // End of variables declaration//GEN-END:variables
}
