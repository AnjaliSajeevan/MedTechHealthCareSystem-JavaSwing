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
import static java.lang.Boolean.FALSE;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static java.lang.Boolean.TRUE;
import javax.swing.JPanel;
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
        this.account = account;
        this.enterprise = enterprise;
        populateSuccessChart();
        populateProjectTimeline();
        populateAgeGroupChart();
        populateConditionChart();
        populateLatestApprovals();
        populateOnGoingProjects();
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

        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activeTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        successpanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ageGroupPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        conditionPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        timelinePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        approveTable = new javax.swing.JTable();

        jLabel1.setText("VACCINE COMPANY REPORT");

        valueLabel.setText("<value>");

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

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
        jScrollPane1.setViewportView(activeTable);
        if (activeTable.getColumnModel().getColumnCount() > 0) {
            activeTable.getColumnModel().getColumn(0).setResizable(false);
            activeTable.getColumnModel().getColumn(1).setResizable(false);
            activeTable.getColumnModel().getColumn(2).setResizable(false);
            activeTable.getColumnModel().getColumn(2).setHeaderValue("CurrentStatus");
        }

        jLabel2.setText("OnGoing Projects");

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jButton1.setText("Project History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        successpanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel9.setText("Success Rate");

        javax.swing.GroupLayout successpanelLayout = new javax.swing.GroupLayout(successpanel);
        successpanel.setLayout(successpanelLayout);
        successpanelLayout.setHorizontalGroup(
            successpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successpanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel9)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        successpanelLayout.setVerticalGroup(
            successpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap(258, Short.MAX_VALUE))
        );

        conditionPanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel11.setText("MedicalCondition");

        javax.swing.GroupLayout conditionPanelLayout = new javax.swing.GroupLayout(conditionPanel);
        conditionPanel.setLayout(conditionPanelLayout);
        conditionPanelLayout.setHorizontalGroup(
            conditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conditionPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel11)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        conditionPanelLayout.setVerticalGroup(
            conditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conditionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        timelinePanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel12.setText("Vaccine Project Timeline");

        javax.swing.GroupLayout timelinePanelLayout = new javax.swing.GroupLayout(timelinePanel);
        timelinePanel.setLayout(timelinePanelLayout);
        timelinePanelLayout.setHorizontalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel12)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        timelinePanelLayout.setVerticalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setText("Approved Projects");

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
        jScrollPane2.setViewportView(approveTable);
        if (approveTable.getColumnModel().getColumnCount() > 0) {
            approveTable.getColumnModel().getColumn(0).setResizable(false);
            approveTable.getColumnModel().getColumn(1).setResizable(false);
            approveTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(conditionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(timelinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBack)
                            .addGap(147, 147, 147)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(100, 100, 100)
                            .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(224, 224, 224)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(successpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ageGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valueLabel)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(successpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conditionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timelinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        VaccineRecordsJPanel viewRecJPanel = new VaccineRecordsJPanel(userProcessContainer, account,enterprise,business);
        userProcessContainer.add("viewRecJPanel", viewRecJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activeTable;
    private javax.swing.JPanel ageGroupPanel;
    private javax.swing.JTable approveTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel conditionPanel;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel successpanel;
    private javax.swing.JPanel timelinePanel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
