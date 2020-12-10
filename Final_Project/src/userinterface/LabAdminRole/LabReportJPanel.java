/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabPatientWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.VaccineWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class LabReportJPanel extends javax.swing.JPanel {
        private JPanel userProcessContainer;
    private EcoSystem business;  
    private Enterprise enterprise;
    public LabReportJPanel(JPanel userProcessContainer,Enterprise enterprise,EcoSystem business ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.enterprise = enterprise;
        populateAgeGroupChart();
        populateServices();
        populateCovidCases();
        valueLabel.setText(enterprise.getName());
    }

public void populateAgeGroupChart(){
        int count1to15 = 0;
        int count16to30=0;
        int count31to45=0;
        int count46to60=0;
        int count61to75=0;
        int count76to90=0;
        int count90toAbove=0;
        
        for(LabPatientWorkRequest request : business.getLabPatQueue().getLabPatientRequestList()){
            int age = 0;
           for(Patient p: business.getPatientDirectory().getpatientlist()){
               if(p.getUserAccount().equals(request.getPatient().getUsername())){
                   age = p.getAge();
               }
           }
            if(age > 0){
            if((age >= 1) &&(age <= 15)) {
                ++count1to15;
            }
            if((age >= 16) &&(age <= 30)) {
                ++count16to30;
            }
            if((age >= 31) &&(age <= 46)) {
                ++count31to45;
            }
            if((age >= 47) &&(age <= 60)) {
                ++count46to60;
            }
            if((age >= 61) &&(age <= 75)) {
                ++count61to75;
            }
            if((age >= 76) &&(age <= 90)) {
                ++count76to90;
            }else{
                ++count90toAbove;
            }
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
        JFreeChart chart=ChartFactory.createPieChart("LabTesting Age-Group Chart", piedataset, true, true, true);
        PiePlot p=(PiePlot)chart.getPlot();
        ChartFrame frame=new ChartFrame("Age-Group Pie Chart", chart);
       
        ageGroupPanel.setLayout(new java.awt.BorderLayout());
        ageGroupPanel.add(new ChartPanel(chart));
        ageGroupPanel.setPreferredSize(new Dimension(300,300));
}

public void populateCovidCases(){
              DefaultTableModel model = (DefaultTableModel)activeTable.getModel();
        model.setRowCount(0);
        List<LabPatientWorkRequest> requestList = business.getLabPatQueue().getLabPatientRequestList();
        for(LabPatientWorkRequest req: requestList){
            if(req.isCovidCase() == true){
               Object row[] = new Object[8];
                 row[0] = req;
                 row[1] = req.getPatient();
                 row[2] = req.getCompleteDate(); 
                 row[3] = req.getMessage();
                   model.addRow(row); 
            }
        }    
}
public void populateServices(){
    DefaultCategoryDataset category = new DefaultCategoryDataset();
    LabEnterprise e = (LabEnterprise) enterprise;
    for(String i: e.getServices()){
        int count = 0;
        for(LabPatientWorkRequest req: business.getLabPatQueue().getLabPatientRequestList()){
            if(req.getLabTestType().equals(i)){
                ++count;
            }
        }
    category.setValue(count, "Number of LabTests", i);
    }
    JFreeChart chart=ChartFactory.createBarChart("ProjectTimeline Chart", "Services", "LabTests", category, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p= (CategoryPlot)chart.getPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame=new ChartFrame("LabTest Services Chart", chart);
        
        servicesPanel.setLayout(new java.awt.BorderLayout());
        servicesPanel.add(new ChartPanel(chart));
        servicesPanel.setPreferredSize(new Dimension(300,300));
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        activeTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ageGroupPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        servicesPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        jLabel1.setText("Laboratory Report");

        valueLabel.setText("<value>");

        jButton1.setText("Laboratory Records");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        activeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "LabRequest", "Patient", "ResultDate", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(activeTable);

        jLabel2.setText("Covid Positive Test Results:");

        ageGroupPanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel10.setText("Age-Group");

        javax.swing.GroupLayout ageGroupPanelLayout = new javax.swing.GroupLayout(ageGroupPanel);
        ageGroupPanel.setLayout(ageGroupPanelLayout);
        ageGroupPanelLayout.setHorizontalGroup(
            ageGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ageGroupPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel10)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        ageGroupPanelLayout.setVerticalGroup(
            ageGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ageGroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        servicesPanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel12.setText("Services Used");

        javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
        servicesPanel.setLayout(servicesPanelLayout);
        servicesPanelLayout.setHorizontalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel12)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        servicesPanelLayout.setVerticalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ageGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(servicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(224, 224, 224))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(179, 179, 179)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valueLabel)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(303, Short.MAX_VALUE))
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
        LabRecordsJPanel viewRepJPanel = new LabRecordsJPanel(userProcessContainer,enterprise,business);
        userProcessContainer.add("viewRepJPanel", viewRepJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activeTable;
    private javax.swing.JPanel ageGroupPanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel servicesPanel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
