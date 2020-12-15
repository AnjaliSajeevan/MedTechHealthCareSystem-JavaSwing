/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineTester;
import Business.WorkQueue.VaccineWorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.lang.Boolean.FALSE;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static java.lang.Boolean.TRUE;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Manasa
 */
public class VaccineCompReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VaccineCompReportJPanel
     */
        private JPanel userProcessContainer;
    private EcoSystem business;  
    private UserAccount account;
    private Enterprise enterprise;
    public VaccineCompReportJPanel(JPanel userProcessContainer,UserAccount account,Enterprise enterprise,EcoSystem business ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.enterprise = enterprise;
        populateSuccessChart();
        populateProjectTimeline();
        populateAgeGroupChart();
        populateConditionChart();
        populateLatestApprovals();
        populateOnGoingProjects();
         this.setSize(1466, 902);
                 populateAllDrugRequestTable();
        populateTimeline("");
                introPanel.setBounds(171, 33, 1293, 101);
        jLabel4.setBounds(1, 1, 160, 113);
        jTabbedPane1.setBounds(1, 130, 1228, 782);
        jPanel1.setSize(1190,740);
        jPanel2.setSize(1190,740);
        jPanel3.setSize(1190,740);
        jPanel4.setSize(1190,740);
        jPanel5.setSize(1190,740);
        jPanel6.setSize(1190,740);
        jPanel7.setSize(1190,740);
        responseTable.setSize(1032, 225);
        timelineTable.setSize(1032, 225);
        
        jTabbedPane1.setBackground(Color.WHITE);
                DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.BLACK);
         headerRenderer.setForeground(java.awt.Color.WHITE);

        for (int i = 0; i < activeTable.getModel().getColumnCount(); i++) {
            activeTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        activeTable.setShowGrid(true);
       activeTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));

        for (int i = 0; i < approveTable.getModel().getColumnCount(); i++) {
            approveTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        approveTable.setShowGrid(true);
       approveTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
       
               for (int i = 0; i < responseTable.getModel().getColumnCount(); i++) {
            responseTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        responseTable.setShowGrid(true);
       responseTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));

        for (int i = 0; i < timelineTable.getModel().getColumnCount(); i++) {
            timelineTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        timelineTable.setShowGrid(true);
       timelineTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
    }
     public void populateAllDrugRequestTable(){
             DefaultTableModel model = (DefaultTableModel)responseTable.getModel();
        model.setRowCount(0);
        List<VaccineWorkRequest> requestList = business.getVaccineQueue().getVaccineRequestList();
        for(VaccineWorkRequest req: requestList){
            if(req.getVaccine().getEnterprise().getName().equals(enterprise.getName())){
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
                 row[1] = req.getVaccine().getName();
                 row[2] = req.getVaccine().getCondition();
                 row[3] = req.getRequestDate();
                 row[4] = req.getResolveDate();
            
            if(req.getSender() == null){
                 row[5] = "";
            }else{
                 row[5] = req.getSender();
            }
            if(req.getReceiver() == null){
                 row[6] = "";
            }else{
                 row[6] = req.getReceiver();
            }


   
                 row[7] = latestKey;
                 row[8] = req.getMessage();
            

            
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
  
  
      public void populateTimeline(VaccineWorkRequest vacReq){
       DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);
           Map<String,Date> map = vacReq.getStatusMap();
           Map<String, Date> Sortedmap = sortByDate(map);
            String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : Sortedmap.entrySet()) {
                            Object row[] = new Object[5];
                 row[0] =mapEntry.getValue(); 
                 row[1] = mapEntry.getKey();
                  model.addRow(row); 
               }
      }
            public void populateTimeline(String blank){
       DefaultTableModel model = (DefaultTableModel)timelineTable.getModel();
        model.setRowCount(0);
         
      }
public void populateSuccessChart(){
        int countFail = 0;
        int countSuccess=0;
        int countDrop=0;
        int countOngoing=0;
        for(VaccineWorkRequest request : business.getVaccineQueue().getVaccineRequestList()){
            if(request.getSuccess().equalsIgnoreCase("fail")){
                ++countFail;
            }
            else if(request.getSuccess().equalsIgnoreCase("success")){
                ++countSuccess;
            }
            else if(request.getSuccess().equalsIgnoreCase("drop")){
                ++countDrop;
            }
            else if(request.getSuccess().equalsIgnoreCase("ongoing")){
                ++countOngoing;
            }
        }

        DefaultPieDataset piedataset= new DefaultPieDataset();
        piedataset.setValue("Success", countSuccess);
        piedataset.setValue("Failure",countFail );
        piedataset.setValue("Dropped",countDrop);
        piedataset.setValue("OnGoing",countOngoing);
        JFreeChart chart=ChartFactory.createPieChart("Vaccine Company Success Chart", piedataset, true, true, true);
        PiePlot p=(PiePlot)chart.getPlot();
        ChartFrame frame=new ChartFrame("Success Pie Chart", chart);
        successpanel.setLayout(new java.awt.BorderLayout());
        successpanel.add(new ChartPanel(chart));
        successpanel.setPreferredSize(new Dimension(300,300));
}
public void populateAgeGroupChart(){
        int count1to15 = 0;
        int count16to30=0;
        int count31to45=0;
        int count46to60=0;
        int count61to75=0;
        int count76to90=0;
        int count90toAbove=0;
        
        for(VaccineWorkRequest request : business.getVaccineQueue().getVaccineRequestList()){
            int minAge = request.getVaccine().getMinAgeGroup();
            int maxAge = request.getVaccine().getMaxAgeGroup();
            if(((minAge <=1) && (1<=maxAge)) || (minAge<=15 && 15<=maxAge)) {
                ++count1to15;
            }
            if(((minAge <=16) && (16<=maxAge)) || (minAge<=30 && 30<=maxAge)) {
                ++count16to30;
            }
            if(((minAge <=31) && (31<=maxAge)) || (minAge<=46 && 46<=maxAge)) {
                ++count31to45;
            }
            if(((minAge <=46) && (46<=maxAge)) || (minAge<=60 && 60<=maxAge)) {
                ++count46to60;
            }
            if(((minAge <=61) && (61<=maxAge)) || (minAge<=75 && 75<=maxAge)) {
                ++count61to75;
            }
            if(((minAge <=76) && (76<=maxAge)) || (minAge<=90 && 90<=maxAge)) {
                ++count76to90;
            }else{
                ++count90toAbove;
            }
        }

        DefaultPieDataset piedataset= new DefaultPieDataset();
        piedataset.setValue("1-15", count1to15);
        piedataset.setValue("16-30",count16to30 );
        piedataset.setValue("31-45",count31to45);
        piedataset.setValue("46-60",count46to60);
        piedataset.setValue("61-75",count61to75);
        piedataset.setValue("76-90",count76to90);
        piedataset.setValue("90-Above",count90toAbove);
        JFreeChart chart=ChartFactory.createPieChart("Vaccine Age-Group Chart", piedataset, true, true, true);
        PiePlot p=(PiePlot)chart.getPlot();
        ChartFrame frame=new ChartFrame("Success Pie Chart", chart);
       
        ageGroupPanel.setLayout(new java.awt.BorderLayout());
        ageGroupPanel.add(new ChartPanel(chart));
        ageGroupPanel.setPreferredSize(new Dimension(300,300));
}
public void populateConditionChart(){
        int diabetesCount = 0;
        int covidCount=0;
        int heartCount=0;
        int respCount=0;
        
        for(VaccineWorkRequest request : business.getVaccineQueue().getVaccineRequestList()){
            String condition = request.getVaccine().getCondition();
            
            if(condition.equalsIgnoreCase("covid")){
                ++covidCount;
            }
            else if(condition.equalsIgnoreCase("diabetes")){
                ++diabetesCount;
            }
            else if(condition.equalsIgnoreCase("heart")){
                ++heartCount;
            }
            else if(condition.equalsIgnoreCase("resp")){
                ++respCount;
            }
        }

        DefaultPieDataset piedataset= new DefaultPieDataset();
        piedataset.setValue("Covid Vaccine", covidCount);
        piedataset.setValue("Heart Problems",heartCount );
        piedataset.setValue("Diabetes",diabetesCount);
        piedataset.setValue("Respiratory Problems",respCount);
        JFreeChart chart=ChartFactory.createPieChart("Vaccine Condition Chart", piedataset, true, true, true);
        PiePlot p=(PiePlot)chart.getPlot();
        ChartFrame frame=new ChartFrame("Medical Condition Pie Chart", chart);
        conditionPanel.setLayout(new java.awt.BorderLayout());
        conditionPanel.add(new ChartPanel(chart));
        conditionPanel.setPreferredSize(new Dimension(300,300));
}

public void populateLatestApprovals(){
               DefaultTableModel model = (DefaultTableModel)approveTable.getModel();
        model.setRowCount(0);
        List<VaccineWorkRequest> requestList = business.getVaccineQueue().getVaccineRequestList();
        for(VaccineWorkRequest req: requestList){
            if(req.getSuccess().equalsIgnoreCase("success")){
               Object row[] = new Object[8];
                 row[0] = req.getVaccine().getName();
                 row[1] = req.getVaccine().getCondition(); 
                 row[2] = req.getResolveDate();
                   model.addRow(row); 
            }
        }
}
public void populateOnGoingProjects(){
              DefaultTableModel model = (DefaultTableModel)activeTable.getModel();
        model.setRowCount(0);
        List<VaccineWorkRequest> requestList = business.getVaccineQueue().getVaccineRequestList();
        for(VaccineWorkRequest req: requestList){
            if(req.getSuccess().equalsIgnoreCase("ongoing")){
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
                 row[0] = req.getVaccine().getName();
                 row[1] = req.getVaccine().getCondition(); 
                 row[2] = latestKey;
                   model.addRow(row); 
            }
        }    
}
public void populateProjectTimeline(){
            int createCount = 0;
        int testCount=0;
        int approvalCount=0;
        int prodCount=0;
         for(VaccineWorkRequest request : business.getVaccineQueue().getVaccineRequestList()){
             String phase = request.getPhase();
              Map<String,Date> map = request.getStatusMap();
                    String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : request.getStatusMap().entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0){
                    latestKey = mapEntry.getKey();
                }
               }
            
            if(phase.equalsIgnoreCase("development")){
                ++createCount;
            }
            else if(phase.equalsIgnoreCase("test")){
                ++testCount;
            }
            else if(phase.equalsIgnoreCase("approval")){
                ++approvalCount;
            }
            else if(phase.equalsIgnoreCase("prod")){
                ++prodCount;
            }
        }       
    DefaultCategoryDataset category = new DefaultCategoryDataset();
    
    category.setValue(createCount, "Number of Projects", "Discovery and Exploration Stage");
    category.setValue(testCount, "Number of Projects", "Clinical Trial Stage");
    category.setValue(approvalCount, "Number of Projects", "Regulatory Approval Stage");
    category.setValue(prodCount, "Number of Projects", "Production Stage");
    JFreeChart chart=ChartFactory.createBarChart("ProjectTimeline Chart", "Project Phase", "Number of Projects", category, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p= (CategoryPlot)chart.getPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame=new ChartFrame("Project Timeline Chart", chart);
        
        timelinePanel.setLayout(new java.awt.BorderLayout());
        timelinePanel.add(new ChartPanel(chart));
        timelinePanel.setPreferredSize(new Dimension(300,300));
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        introPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activeTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        approveTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        successpanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ageGroupPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        conditionPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        timelinePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        responseTable = new javax.swing.JTable();
        btnTimeline = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        timelineTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/vacreport.png"))); // NOI18N

        introPanel.setBackground(new java.awt.Color(0, 51, 153));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VaccineCompany Report");

        lblEnterprise.setBackground(new java.awt.Color(51, 51, 51));
        lblEnterprise.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        lblEnterprise.setText("Enterprise:");
        lblEnterprise.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblAccount.setBackground(new java.awt.Color(51, 51, 51));
        lblAccount.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setText("Enterprise:");
        lblAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        backJButton1.setBackground(new java.awt.Color(0, 0, 102));
        backJButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backJButton1.setForeground(new java.awt.Color(255, 255, 255));
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/home2.png"))); // NOI18N
        backJButton1.setText("Home");
        backJButton1.setBorder(null);
        backJButton1.setBorderPainted(false);
        backJButton1.setContentAreaFilled(false);
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(159, 159, 159)))
                .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnterprise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        activeTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        activeTable.setFont(new java.awt.Font("Sukhumvit Set", 1, 14)); // NOI18N
        activeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "VaccineName", "Condition", "CurrentStatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        activeTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(activeTable);
        if (activeTable.getColumnModel().getColumnCount() > 0) {
            activeTable.getColumnModel().getColumn(0).setResizable(false);
            activeTable.getColumnModel().getColumn(1).setResizable(false);
            activeTable.getColumnModel().getColumn(2).setResizable(false);
            activeTable.getColumnModel().getColumn(2).setHeaderValue("CurrentStatus");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("OnGoing Projects", jPanel1);

        approveTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        approveTable.setFont(new java.awt.Font("Sukhumvit Set", 1, 14)); // NOI18N
        approveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "VaccineName", "Condition", "Approve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        approveTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(approveTable);
        if (approveTable.getColumnModel().getColumnCount() > 0) {
            approveTable.getColumnModel().getColumn(0).setResizable(false);
            approveTable.getColumnModel().getColumn(1).setResizable(false);
            approveTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Approved Projects", jPanel2);

        successpanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel9.setText("Success Rate");

        javax.swing.GroupLayout successpanelLayout = new javax.swing.GroupLayout(successpanel);
        successpanel.setLayout(successpanelLayout);
        successpanelLayout.setHorizontalGroup(
            successpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successpanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel9)
                .addContainerGap(848, Short.MAX_VALUE))
        );
        successpanelLayout.setVerticalGroup(
            successpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(542, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(successpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(successpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Success Rate", jPanel3);

        ageGroupPanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel10.setText("Age-Group");

        javax.swing.GroupLayout ageGroupPanelLayout = new javax.swing.GroupLayout(ageGroupPanel);
        ageGroupPanel.setLayout(ageGroupPanelLayout);
        ageGroupPanelLayout.setHorizontalGroup(
            ageGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ageGroupPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ageGroupPanelLayout.setVerticalGroup(
            ageGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ageGroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(531, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ageGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ageGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Age-Group Analysis", jPanel4);

        conditionPanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel11.setText("MedicalCondition");

        javax.swing.GroupLayout conditionPanelLayout = new javax.swing.GroupLayout(conditionPanel);
        conditionPanel.setLayout(conditionPanelLayout);
        conditionPanelLayout.setHorizontalGroup(
            conditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conditionPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel11)
                .addContainerGap(819, Short.MAX_VALUE))
        );
        conditionPanelLayout.setVerticalGroup(
            conditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conditionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(542, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conditionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conditionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Medical-Condition Requests", jPanel5);

        timelinePanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel12.setText("Vaccine Project Timeline");

        javax.swing.GroupLayout timelinePanelLayout = new javax.swing.GroupLayout(timelinePanel);
        timelinePanel.setLayout(timelinePanelLayout);
        timelinePanelLayout.setHorizontalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel12)
                .addContainerGap(776, Short.MAX_VALUE))
        );
        timelinePanelLayout.setVerticalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(551, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timelinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(timelinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vaccine Project Timeline", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        responseTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        responseTable.setFont(new java.awt.Font("Sukhumvit Set", 1, 12)); // NOI18N
        responseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "VaccineID", "Name", "Type", "CreateDate", "ResolveDate", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        responseTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane3.setViewportView(responseTable);

        btnTimeline.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTimeline.setForeground(new java.awt.Color(0, 0, 51));
        btnTimeline.setText("View Timeline");
        btnTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimelineActionPerformed(evt);
            }
        });

        timelineTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        timelineTable.setFont(new java.awt.Font("Sukhumvit Set", 1, 14)); // NOI18N
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
        timelineTable.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane6.setViewportView(timelineTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(415, 415, 415))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("Project History", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(introPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void btnTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimelineActionPerformed
        // TODO add your handling code here:
                int selectedRow = responseTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine Request row from table!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineWorkRequest vaccine= (VaccineWorkRequest)responseTable.getValueAt(selectedRow, 0);

        populateTimeline(vaccine);
    }//GEN-LAST:event_btnTimelineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activeTable;
    private javax.swing.JPanel ageGroupPanel;
    private javax.swing.JTable approveTable;
    private javax.swing.JButton backJButton1;
    private javax.swing.JButton btnTimeline;
    private javax.swing.JPanel conditionPanel;
    private javax.swing.JPanel introPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JTable responseTable;
    private javax.swing.JPanel successpanel;
    private javax.swing.JPanel timelinePanel;
    private javax.swing.JTable timelineTable;
    // End of variables declaration//GEN-END:variables
}
