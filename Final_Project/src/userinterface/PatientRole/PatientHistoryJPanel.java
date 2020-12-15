/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.Essentials.Medicine;
import Business.Patient.Patient;
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
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;


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
        
        for(Patient p: ecosystem.getPatientDirectory().getpatientlist()){

            if(account.getUsername().toString().equals(p.getUserName())){
               
                patient=p.getPatientname();
        }
        }
        
        
        jLabel5.setText(patient);
        
        tblpatientAppointment.getTableHeader().setFont(new java.awt.Font("SansSerif 14 Plain",java.awt.Font.BOLD,15));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblpatientAppointment.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(35,33,54));
         headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < tblpatientAppointment.getModel().getColumnCount(); i++) {
            tblpatientAppointment.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        tblpatientAppointment.setShowGrid(true);
        tblpatientAppointment.getTableHeader().setFont(new java.awt.Font("SansSerif 14 Plain",java.awt.Font.BOLD,16));
    
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        UIManager.put("labTestingTable.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer1.setBackground(new Color(48,59,88));
         headerRenderer1.setForeground(Color.WHITE);

        for (int i = 0; i < labTestingTable.getModel().getColumnCount(); i++) {
            labTestingTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       labTestingTable.setShowGrid(true);
        labTestingTable.getTableHeader().setFont(new java.awt.Font("SansSerif 14 Plain",java.awt.Font.BOLD,16));
        
    
        jScrollPane3.getViewport().setBackground(Color.WHITE);
        UIManager.put("pharmaTable.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer2 = new DefaultTableCellRenderer();
        headerRenderer2.setBackground(new Color(48,59,88));
         headerRenderer2.setForeground(Color.WHITE);

        for (int i = 0; i < pharmaTable.getModel().getColumnCount(); i++) {
            pharmaTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       pharmaTable.setShowGrid(true);
        pharmaTable.getTableHeader().setFont(new java.awt.Font("SansSerif 14 Plain",java.awt.Font.BOLD,16));
        
        
        jScrollPane8.getViewport().setBackground(Color.WHITE);
        UIManager.put("hospTimeline.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer4 = new DefaultTableCellRenderer();
        headerRenderer4.setBackground(new Color(48,59,88));
         headerRenderer4.setForeground(Color.WHITE);

        for (int i = 0; i < hospTimeline.getModel().getColumnCount(); i++) {
            hospTimeline.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       hospTimeline.setShowGrid(true);
        hospTimeline.getTableHeader().setFont(new java.awt.Font("SansSerif 14 Plain",java.awt.Font.BOLD,16));
        
        jScrollPane7.getViewport().setBackground(Color.WHITE);
        UIManager.put("labTimeline.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer5 = new DefaultTableCellRenderer();
        headerRenderer2.setBackground(new Color(48,59,88));
         headerRenderer2.setForeground(Color.WHITE);

        for (int i = 0; i < labTimeline.getModel().getColumnCount(); i++) {
            labTimeline.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       labTimeline.setShowGrid(true);
        labTimeline.getTableHeader().setFont(new java.awt.Font("SansSerif 14 Plain",java.awt.Font.BOLD,16));
        
        jScrollPane6.getViewport().setBackground(Color.WHITE);
        UIManager.put("pharmaTimeline.gridColor", new ColorUIResource(Color.BLACK));
       
        DefaultTableCellRenderer headerRenderer6 = new DefaultTableCellRenderer();
        headerRenderer6.setBackground(new Color(48,59,88));
         headerRenderer6.setForeground(Color.WHITE);

        for (int i = 0; i < pharmaTimeline.getModel().getColumnCount(); i++) {
            pharmaTimeline.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       pharmaTimeline.setShowGrid(true);
        pharmaTimeline.getTableHeader().setFont(new java.awt.Font("SansSerif 14 Plain",java.awt.Font.BOLD,16));
        
        
        
        
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
                    row[3] = request.getStatus();
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

        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGeneratePdf = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        pnl = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpatientAppointment = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        hospTimeline = new javax.swing.JTable();
        btnHosTimeline = new javax.swing.JButton();
        pnl2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labTestingTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        labTimeline = new javax.swing.JTable();
        btnLabTimeline = new javax.swing.JButton();
        pnl3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pharmaTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        pharmaTimeline = new javax.swing.JTable();
        pharTimeline = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(11, 43, 38));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(22, 56, 50));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Hospital History");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 330, 80));

        jButton2.setBackground(new java.awt.Color(140, 180, 153));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jButton2.setText("Pharmacy History");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 330, 90));

        jButton3.setBackground(new java.awt.Color(35, 83, 71));
        jButton3.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Laboratory History");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 330, 90));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<>");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("'s History");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        btnGeneratePdf.setBackground(new java.awt.Color(22, 56, 50));
        btnGeneratePdf.setText("Generate pdf");
        btnGeneratePdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePdfActionPerformed(evt);
            }
        });
        jPanel4.add(btnGeneratePdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 130, 50));

        btnBack.setText("<-Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel4.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        pnl.setBackground(new java.awt.Color(255, 255, 255));
        pnl.setLayout(new java.awt.CardLayout());

        pnl1.setBackground(new java.awt.Color(255, 255, 255));

        tblpatientAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("HOSPITAL APPOINTMENT HISTORY");

        hospTimeline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        btnHosTimeline.setBackground(new java.awt.Color(22, 56, 50));
        btnHosTimeline.setForeground(new java.awt.Color(255, 255, 255));
        btnHosTimeline.setText("View Timeline");
        btnHosTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHosTimelineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel1))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(btnHosTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(109, 109, 109)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnHosTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pnl.add(pnl1, "card4");

        pnl2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("LABORATORY APPOINTMENT HISTORY");

        labTestingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        labTimeline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        btnLabTimeline.setBackground(new java.awt.Color(22, 56, 50));
        btnLabTimeline.setForeground(new java.awt.Color(255, 255, 255));
        btnLabTimeline.setText("View Timeline");
        btnLabTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabTimelineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(244, 244, 244))
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(btnLabTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(103, 103, 103)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnLabTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        pnl.add(pnl2, "card2");

        pnl3.setBackground(new java.awt.Color(255, 255, 255));

        pharmaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("PHARMACY HISTORY");

        pharmaTimeline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        pharTimeline.setBackground(new java.awt.Color(22, 56, 50));
        pharTimeline.setForeground(new java.awt.Color(255, 255, 255));
        pharTimeline.setText("View Timeline");
        pharTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharTimelineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(pharTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl3Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel3))
                    .addGroup(pnl3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(59, 59, 59)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(pharTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        pnl.add(pnl3, "card3");

        add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 980, 902));
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

    private void btnGeneratePdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePdfActionPerformed
        String statusss;
        String messages;
        String messagelab;
        String e="";
       if((tblpatientAppointment.getRowCount()==0 )|| (hospTimeline.getRowCount()==0 )||(labTimeline.getRowCount()==0 )||(labTestingTable.getRowCount()==0 )||(pharmaTable.getRowCount()==0 )||(pharmaTimeline.getRowCount()==0 ))
       {
            JOptionPane.showMessageDialog(null, "Data not sufficient for  generating report!", "Warning", JOptionPane.WARNING_MESSAGE);
       }else{
                
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

               

                tbl.addCell("Appointment ID");
                tbl.addCell("Date");
                tbl.addCell("Time");
                tbl.addCell("Status");
                tbl.addCell("Hospital");
                tbl.addCell("Doctor");
                tbl.addCell("Result");

               

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

                

                tb4.addCell("Date");
                tb4.addCell("Status");

             

                for (int i = 0; i < hospTimeline.getRowCount(); i++) {
                   
                    String datesss = hospTimeline.getValueAt(i, 0).toString();
                    String status2 = hospTimeline.getValueAt(i, 1).toString();

                    tb4.addCell(datesss);
                    tb4.addCell(status2);

                }
                doc.add(tb4);
                    

                
                doc.add( Chunk.NEWLINE );

                PdfPTable tbl2 = new PdfPTable(6);
                tbl2.setWidths(new int[]{3, 3, 2,3,2,2});
                PdfPCell cell2=new PdfPCell(new Phrase("Patient Laboratory History") );
                cell2.setColspan(7);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setBackgroundColor(Color.cyan);
                tbl2.addCell(cell2);

//                PdfPCell cell4=new PdfPCell(new Phrase(" "));
//                cell4.setColspan(7);
//                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell4.setBackgroundColor(Color.white);
//                tbl2.addCell(cell4);

                tbl2.addCell("Lab ID");
                tbl2.addCell("Laboratory");
                tbl2.addCell("Test Name");
                tbl2.addCell("Patient Name");
                tbl2.addCell("Status");
                tbl2.addCell("Message");

//                PdfPCell cell5=new PdfPCell(new Phrase(" "));
//                cell5.setColspan(7);
//                cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell5.setBackgroundColor(Color.white);
//                tbl2.addCell(cell5);

                for (int i = 0; i < labTestingTable.getRowCount(); i++) {
                    String labID = labTestingTable.getValueAt(i, 0).toString();
                    String laboratory = labTestingTable.getValueAt(i, 1).toString();
                    String labTest = labTestingTable.getValueAt(i, 2).toString();
                    String PatientName = labTestingTable.getValueAt(i, 3).toString();
                    String status = labTestingTable.getValueAt(i, 4).toString();
                   try{
                    if(labTestingTable.getValueAt(i, 5).toString()==null){
                       messagelab="not available";
                    
                    }else{
                     messagelab = labTestingTable.getValueAt(i, 5).toString();
                   }}catch(NullPointerException ex1)
                    {messagelab="Not available";
                             }
                    tbl2.addCell(labID);
                    tbl2.addCell(laboratory);
                    tbl2.addCell(labTest);
                    tbl2.addCell(PatientName);
                    tbl2.addCell(status);
                    tbl2.addCell(messagelab);

                }

                doc.add(tbl2);

//                PdfPCell blankRow2 = new PdfPCell(new Paragraph("\n"));
//                blankRow2.setFixedHeight(5f);
//                blankRow2.setColspan(7);
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

//                PdfPCell cell14=new PdfPCell(new Phrase(" "));
//                cell14.setColspan(7);
//                cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell14.setBackgroundColor(Color.white);
//                tbl5.addCell(cell14);

                tb4.addCell("Date");
                tb4.addCell("Status");

//                PdfPCell cell15=new PdfPCell(new Phrase(" "));
//                cell15.setColspan(7);
//                cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell15.setBackgroundColor(Color.white);
//                tbl5.addCell(cell15);

                for (int i = 0; i < labTimeline.getRowCount(); i++) {
//                    if(labTimeline.getValueAt(i, 0).toString()==null){
//                        e="Please choose a row for timeline for laboratory";
//                    }else{
                    String datesss1 = labTimeline.getValueAt(i, 0).toString();
                    String status3 = labTimeline.getValueAt(i, 1).toString();

                    tbl5.addCell(datesss1);
                    tbl5.addCell(status3);

//                }
                }
                doc.add(tbl5);
                
//                PdfPCell blankRow9 = new PdfPCell(new Paragraph("\n"));
//                blankRow9.setFixedHeight(5f);
//                blankRow9.setColspan(7);
                doc.add( Chunk.NEWLINE );

                PdfPTable tbl3 = new PdfPTable(5);
                tbl3.setWidths(new int[]{2, 2, 2,2,2});
                PdfPCell cell3=new PdfPCell(new Phrase("Patient Pharmacy History"));
                cell3.setColspan(7);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setBackgroundColor(Color.cyan);
                tbl3.addCell(cell3);

//                PdfPCell cell6=new PdfPCell(new Phrase(" "));
//                cell6.setColspan(7);
//                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell6.setBackgroundColor(Color.white);
//                tbl3.addCell(cell6);

                tbl3.addCell("PharmacyID");
                tbl3.addCell("Medicine");
                tbl3.addCell("Delivery Status");
                tbl3.addCell("Status");
                tbl3.addCell("Message");

//                PdfPCell cell7=new PdfPCell(new Phrase(" "));
//                cell7.setColspan(7);
//                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell7.setBackgroundColor(Color.white);
//                tbl3.addCell(cell7);

                for (int i = 0; i < pharmaTable.getRowCount(); i++) {
                    String pharmacyID = pharmaTable.getValueAt(i, 0).toString();
                    String medicine = pharmaTable.getValueAt(i, 1).toString();
                    String delivaryStatus = pharmaTable.getValueAt(i, 2).toString();
                   
                    if(pharmaTable.getValueAt(i, 3).toString()==null){
                       statusss="not available";
                    
                    }else{
                   statusss = pharmaTable.getValueAt(i, 3).toString();
                    }
                    try{
                     if(pharmaTable.getValueAt(i, 4).toString()==null){
                       messages="not available";
                     
                    }else{
                    messages = pharmaTable.getValueAt(i, 4).toString();
                     }
                    }catch(NullPointerException ex)
                    {messages="Not available";
                             }
                             
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

//                PdfPCell cell16=new PdfPCell(new Phrase(" "));
//                cell16.setColspan(7);
//                cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell16.setBackgroundColor(Color.white);
//                tbl6.addCell(cell16);

                tbl6.addCell("Date");
                tbl6.addCell("Status");

//                PdfPCell cell17=new PdfPCell(new Phrase(" "));
//                cell17.setColspan(7);
//                cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell17.setBackgroundColor(Color.white);
//                tbl6.addCell(cell17);

                for (int i = 0; i < pharmaTimeline.getRowCount(); i++) {
//                     if(pharmaTimeline.getValueAt(i, 0).toString()==null){
//                        e="Please choose a row for timeline for pharmacy";
//                    }else{
                    String datesss2 = pharmaTimeline.getValueAt(i, 0).toString();
                    String status4 = pharmaTimeline.getValueAt(i, 1).toString();

                    tbl6.addCell(datesss2);
                    tbl6.addCell(status4);

//                     }
                }
                doc.add(tbl6);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PatientHistoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(PatientHistoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        }
        if(e.equals("")){
        JOptionPane.showMessageDialog(null,"Report Generated Successfully!");
        }else{
            JOptionPane.showMessageDialog(null,e);
        }
       }
    }//GEN-LAST:event_btnGeneratePdfActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl1);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl2);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl3);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGeneratePdf;
    private javax.swing.JButton btnHosTimeline;
    private javax.swing.JButton btnLabTimeline;
    private javax.swing.JTable hospTimeline;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JTable tblpatientAppointment;
    // End of variables declaration//GEN-END:variables
}
