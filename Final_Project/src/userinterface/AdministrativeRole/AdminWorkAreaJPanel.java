

package userinterface.AdministrativeRole;

import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Organization.Organization.Type.Doctor;
import Business.WorkQueue.EmergencyRequest;
import Business.WorkQueue.PatientHospitalAppointmentWorkRequest;
import Business.WorkQueue.PharmaWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  raunak
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    LocalDate d;
    String time;
    
    
    Map<LocalDate,ArrayList<String>>appointment;

    public AdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem business) {
           initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        valueLabel.setText(enterprise.getName());
        String from = "08:00:00", to = "20:00:00";
        LocalTime fromTime = LocalTime.parse(from), toTime = LocalTime.parse(to);

        for (LocalTime counter = fromTime;
                counter.compareTo(toTime) <= 0;
                counter = counter.plusMinutes(30)) {
            jComboBoxTimeSlot.addItem(counter.toString());

                    }
//        populateComboBox();

        tblpatientAppointment.getTableHeader().setFont(new Font("SansSerif 14 Plain", Font.BOLD, 15));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        UIManager.put("tblpatientAppointment.gridColor", new ColorUIResource(Color.BLACK));

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(42, 0, 1));
        headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < tblpatientAppointment.getModel().getColumnCount(); i++) {
            tblpatientAppointment.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        tblpatientAppointment.setShowGrid(true);
        tblpatientAppointment.getTableHeader().setFont(new Font("SansSerif 14 Plain", Font.BOLD, 16));
        
        for (int i = 0; i < tblEmergency.getModel().getColumnCount(); i++) {
            tblEmergency.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

       tblEmergency.setShowGrid(true);
        tblEmergency.getTableHeader().setFont(new Font("SansSerif 14 Plain", Font.BOLD, 16));
        
        populateEmergency();
        
            jTable1.getTableHeader().setFont(new Font("SansSerif 14 Plain", Font.BOLD, 15));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        UIManager.put("jTable1.gridColor", new ColorUIResource(Color.BLACK));

        DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer1.setBackground(new Color(42, 0, 1));
        headerRenderer1.setForeground(Color.WHITE);

        for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setFont(new Font("SansSerif 14 Plain", Font.BOLD, 16));
        
        populateTable();
        comboTimeline();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblpatientAppointment.getModel();
        model.setRowCount(0);

        for (PatientHospitalAppointmentWorkRequest request : business.getHospitalQueue().hospitalRequestList()) {
            if (request.getHospital().equals(enterprise.getName())) {
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getAppDate();
                row[3] = request.getTime();
                row[4] = request.getStatus();
                d = request.getAppDate();
                time = request.getTime();
                model.addRow(row);
            }
        }

    }
    
    public void comboTimeline(){
       jComboBox1.removeAll();
       
        for(Doctor d:business.getDoctorDirectory().getdoctorlist())
        {if(d.getHospital().equals(enterprise.getName()))
            if(!(d.getTime()==null)){
            jComboBox1.addItem(d.toString());
        
            }
    }
    }
    
       public void populateEmergency(){
                DefaultTableModel model = (DefaultTableModel)tblEmergency.getModel();
        model.setRowCount(0);
            
        for(EmergencyRequest request : business.getEmergencyQueue().getEmergencyRequestList()){           
            if(request.getEnterprise().equals(enterprise.getName())){
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
            if(!latestKey.equalsIgnoreCase("Complete")){
            
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getSender();
            row[2] = request.getMsg();
            row[3] = request.getCreateDate();
            row[4] = latestKey;
            model.addRow(row);
        }   
       }
        }
       }   
      
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnl = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        manageOrganizationJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        userJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        availableDoctor = new javax.swing.JComboBox<>();
        jComboBoxTimeSlot = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnDecline = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpatientAppointment = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmergency = new javax.swing.JTable();
        btnProceedEmergency = new javax.swing.JButton();
        pnl3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(42, 0, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hospital");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(255, 255, 255));
        enterpriseLabel.setText("EnterPrise :");
        jPanel1.add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 120, 30));

        valueLabel.setForeground(new java.awt.Color(255, 255, 255));
        valueLabel.setText("<value>");
        jPanel1.add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Adminstrative");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jButton2.setBackground(new java.awt.Color(156, 87, 87));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setText("Organization");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 240, 85));

        jButton3.setBackground(new java.awt.Color(212, 144, 144));
        jButton3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton3.setText("Patient Appointments");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 240, 85));

        jButton4.setBackground(new java.awt.Color(225, 178, 178));
        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Doctor Availability");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 240, 85));

        pnl.setLayout(new java.awt.CardLayout());

        pnl1.setBackground(new java.awt.Color(255, 255, 255));

        manageOrganizationJButton.setBackground(new java.awt.Color(42, 0, 1));
        manageOrganizationJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manageOrganizationJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        manageEmployeeJButton.setBackground(new java.awt.Color(42, 0, 1));
        manageEmployeeJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manageEmployeeJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });

        userJButton.setBackground(new java.awt.Color(42, 0, 1));
        userJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userJButton.setForeground(new java.awt.Color(255, 255, 255));
        userJButton.setText("Manage User");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Health-professional-team.gif"))); // NOI18N

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(434, 434, 434))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pnl.add(pnl1, "card2");

        pnl2.setBackground(new java.awt.Color(255, 255, 255));

        btnSubmit.setBackground(new java.awt.Color(42, 0, 1));
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnAccept.setBackground(new java.awt.Color(42, 0, 1));
        btnAccept.setForeground(new java.awt.Color(255, 255, 255));
        btnAccept.setText("Accept Appointment");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        jLabel4.setText("Time slot available:");

        btnDecline.setBackground(new java.awt.Color(42, 0, 1));
        btnDecline.setForeground(new java.awt.Color(255, 255, 255));
        btnDecline.setText("Decline Appointment");
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/doctor_male_25px.png"))); // NOI18N
        jLabel5.setText("Assign Doctor:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("PATIENT APPOINTMENT");

        tblpatientAppointment.setBackground(new java.awt.Color(107, 30, 30));
        tblpatientAppointment.setForeground(new java.awt.Color(255, 255, 255));
        tblpatientAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appoinment No.", "Patient ", "Date", "Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpatientAppointment.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblpatientAppointment.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(tblpatientAppointment);
        if (tblpatientAppointment.getColumnModel().getColumnCount() > 0) {
            tblpatientAppointment.getColumnModel().getColumn(0).setResizable(false);
            tblpatientAppointment.getColumnModel().getColumn(1).setResizable(false);
            tblpatientAppointment.getColumnModel().getColumn(2).setResizable(false);
            tblpatientAppointment.getColumnModel().getColumn(3).setResizable(false);
            tblpatientAppointment.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/5fd2ddc0a3ae6128996963.gif"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        tblEmergency.setBackground(new java.awt.Color(107, 30, 30));
        tblEmergency.setForeground(new java.awt.Color(255, 255, 255));
        tblEmergency.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestID", "Patient", "Message", "CreateDate", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmergency.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblEmergency.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(tblEmergency);

        btnProceedEmergency.setBackground(new java.awt.Color(42, 0, 1));
        btnProceedEmergency.setForeground(new java.awt.Color(255, 255, 255));
        btnProceedEmergency.setText("Handle Request");
        btnProceedEmergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedEmergencyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jLabel2))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl2Layout.createSequentialGroup()
                                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(btnAccept))
                                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(availableDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxTimeSlot, 0, 129, Short.MAX_VALUE))
                                        .addGap(61, 61, 61)
                                        .addComponent(btnSubmit))
                                    .addGroup(pnl2Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(btnDecline)))
                                .addGap(152, 152, 152))))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(btnProceedEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnSubmit))
                .addGap(35, 35, 35)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(availableDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProceedEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        pnl.add(pnl2, "card3");

        pnl3.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(156, 87, 87));
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setText("CHECK DOCTOR AVAILABILTY");

        jTable1.setBackground(new java.awt.Color(107, 30, 30));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date From", "Date To", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setText("Please select a doctor:");

        jPanel2.setBackground(new java.awt.Color(156, 87, 87));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnl3Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel8)))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(110, 110, 110)
                .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        pnl.add(pnl3, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String doctorCheck="";
        availableDoctor.removeAllItems();
        String e = "";
        String y = null;
        String doctor;
        int selectedRow = tblpatientAppointment.getSelectedRow();
        String time = (String) jComboBoxTimeSlot.getSelectedItem();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            for (Doctor n : business.getDoctorDirectory().getdoctorlist()) {
               
                if ((n.getHospital()==null)){
                    e="No doctors available";
                }else{
                    if(n.getHospital().equals(enterprise.getName())) {
                    appointment = n.getAppointment();
                    
                    if (appointment == null || appointment.isEmpty()) {
                        e = "No doctors available for the selected time";
                    } else {
                        for (LocalDate dates : appointment.keySet()) {
                            if (dates.equals(d)) {
                                for (String timess : appointment.get(dates)) {
                                    if (timess.equals(time)) {
                                        doctor = n.toString();
                                        availableDoctor.addItem(doctor);
                                           doctorCheck=n.toString();
                                    }else{
                                        e="No slots available for doctor";
                                    }

                                }
                            }else{
                                e="No doctors available on this day";
                            }

                        }
                    }
                }else{e="No doctors available";
                }
            }
            }
            if ((doctorCheck.equals(""))) {
                if(e.equals("")){e="No doctors available";}
               JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
       
        int selectedRow = tblpatientAppointment.getSelectedRow();
        String doctor = (String) availableDoctor.getSelectedItem();
            String selected = (String) jComboBoxTimeSlot.getSelectedItem();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            PatientHospitalAppointmentWorkRequest request = (PatientHospitalAppointmentWorkRequest) tblpatientAppointment.getValueAt(selectedRow, 0);
            if((request.getStatus().equals("Appointment confirmed with doctor"))||(request.getStatus().equals("Appointment declined"))||((availableDoctor.getSelectedIndex()== -1))){
                JOptionPane.showMessageDialog(null, "Appointment already processed", "Warning", JOptionPane.WARNING_MESSAGE);
            }else{
            
            for (LocalDate dates : appointment.keySet()) {
                if (dates.equals(d)) {
                    for (Doctor doc : business.getDoctorDirectory().getdoctorlist()) {
                        if (doc.getName().equals(doctor)) {
                          
                            doc.removeAppointment(dates, selected);
                         
                        }
                      
                    }
                }

                request.setStatus("Appointment confirmed with doctor");
                request.setCost(123.4);
                request.setDoctor(doctor);
                    Map<String,Date> reqMap = request.getStatusMap();
        
                    reqMap.put("Appointment confirmed to doctor-"+doctor, new Date());
        request.setStatusMap(reqMap); 
            }
            JOptionPane.showMessageDialog(null, "Appointmnent confirmed and assigned to doctor!");
            populateTable();
             business.getHospitalQueue().updateHospitalRequest(request, business.getHospitalQueue().hospitalRequestList());
        }
        }
   
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblpatientAppointment.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            PatientHospitalAppointmentWorkRequest request = (PatientHospitalAppointmentWorkRequest) tblpatientAppointment.getValueAt(selectedRow, 0);
            if((request.getStatus().equals("Appointment confirmed with doctor"))||(request.getStatus().equals("Appointment declined"))){
                JOptionPane.showMessageDialog(null, "Appointment already processed", "Warning", JOptionPane.WARNING_MESSAGE);
            }else{
        request.setStatus("Appointment declined");
        
        populateTable();
            }
        }
    }//GEN-LAST:event_btnDeclineActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrganizationJPanel manageOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),"Hospiatal Organization");
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise,business);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl1);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        pnl.removeAll();
        pnl.add(pnl2);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
             pnl.removeAll();
        pnl.add(pnl3);
        pnl.repaint();
        pnl.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Map<LocalDate,ArrayList<String>>app = null;
       String e;
        Doctor d = null;
         String doc = (String) jComboBox1.getSelectedItem();
         for(Doctor doctors:business.getDoctorDirectory().getdoctorlist()){
            
             if(doctors.toString().equals(doc)){
                 d=doctors;
                
             }
         
           if(d!=null){
//            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setRowCount(0);

                Object[] row = new Object[5];
                row[0] = d.getDateFrom();
                row[1] = d.getDateTo();
                row[2]=d.getTime();
                model.addRow(row);
                          
                  }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnProceedEmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedEmergencyActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblEmergency.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select an Emergency Row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        EmergencyRequest emergency= (EmergencyRequest)tblEmergency.getValueAt(selectedRow, 0);

        Map<String,Date> reqMap = emergency.getStatusMap();
                    String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : reqMap.entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((reqMap.get(latestKey).compareTo(reqMap.get(mapEntry.getKey()))) < 0){
                    latestKey = mapEntry.getKey();
                }
               }
            if(!latestKey.equalsIgnoreCase("Patient admitted")){
        JOptionPane.showMessageDialog(null, "Patient yet to reach the hospital!", "Warning", JOptionPane.WARNING_MESSAGE);   
        return;
            }
        reqMap.put("Complete",new Date());
        emergency.setStatusMap(reqMap);
        business.getEmergencyQueue().updateEmergencyRequest(emergency, business.getEmergencyQueue().getEmergencyRequestList());
        JOptionPane.showMessageDialog(null, "Request transferred and handled by available doctor!", "Information", JOptionPane.INFORMATION_MESSAGE);
        populateEmergency();      
    }//GEN-LAST:event_btnProceedEmergencyActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> availableDoctor;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnProceedEmergency;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxTimeSlot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JTable tblEmergency;
    private javax.swing.JTable tblpatientAppointment;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}
