package view.admin;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import control.AdministratorsControl;
import control.EmployeesControl;
import java.awt.Cursor;
import java.awt.Font;
import java.util.List;
import model.Administrators;
import model.Employees;
import view.employee.login.LoginView;

public class DashAdminView extends javax.swing.JPanel {

    private AdministratorsControl administratorsControl;
    private EmployeesControl employeesControl;
    private Administrators admin = null;
    String action = null;
    List<Administrators> listAdministrators;
    int selectedId = 0;
    List<Employees> listEmployees;
    
    public void showDashboard(){
        adminTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 12));
        adminTable.getTableHeader().setOpaque(false);
        adminTable.getTableHeader().setForeground(new Color(0, 61, 121));
        adminTable.setModel(administratorsControl.showAdministrator(""));
        empTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 12));
        empTable.getTableHeader().setOpaque(false);
        empTable.getTableHeader().setForeground(new Color(0, 61, 121));
        empTable.setModel(employeesControl.showEmployees(""));  
    }
    
    private int countTotalAdmin(){
        return administratorsControl.countAdmin();
    }
    
    private int countTotalEmployee(){
        return employeesControl.countEmployee();
    }
    
    public DashAdminView(Administrators admin) {
        administratorsControl = new AdministratorsControl();
        employeesControl = new EmployeesControl();
        this.admin = admin;
        initComponents();
        haloText.setEditable(false);
        haloText.setText("Administrator " + admin.getUsername());
        totalAdmin.setEditable(false);
        totalEmp.setEditable(false);
        showDashboard();
        totalAdmin.setText(String.valueOf(countTotalAdmin()));
        totalEmp.setText(String.valueOf(countTotalEmployee()));
        setBackground(new Color(0, 0, 0, 0));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        haloText = new javax.swing.JTextField();
        panelBorder11 = new com.swing.PanelBorder1();
        panelBorder12 = new com.swing.PanelBorder1();
        totalAdmin = new javax.swing.JTextField();
        panelBorder13 = new com.swing.PanelBorder1();
        totalEmp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelBorder14 = new com.swing.PanelBorder1();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        panelBorder15 = new com.swing.PanelBorder1();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel3.setBackground(new java.awt.Color(226, 226, 226));
        jPanel3.setPreferredSize(new java.awt.Dimension(1049, 85));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Krungthep", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(28, 94, 32));
        jLabel2.setText("Administrators");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Krungthep", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(28, 94, 32));
        jLabel4.setText("Welcome");

        haloText.setFont(new java.awt.Font("Krungthep", 1, 30)); // NOI18N
        haloText.setForeground(new java.awt.Color(28, 94, 32));
        haloText.setText("Administrator ..................");
        haloText.setBorder(null);
        haloText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haloTextActionPerformed(evt);
            }
        });

        panelBorder11.setRoundBottomLeft(20);
        panelBorder11.setRoundBottomRight(20);
        panelBorder11.setRoundTopLeft(20);
        panelBorder11.setRoundTopRight(20);

        panelBorder12.setBackground(new java.awt.Color(153, 153, 153));
        panelBorder12.setRoundBottomLeft(20);
        panelBorder12.setRoundBottomRight(20);
        panelBorder12.setRoundTopLeft(20);
        panelBorder12.setRoundTopRight(20);

        totalAdmin.setBackground(new java.awt.Color(153, 153, 153));
        totalAdmin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalAdmin.setForeground(new java.awt.Color(255, 255, 255));
        totalAdmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalAdmin.setText("15");
        totalAdmin.setToolTipText("");
        totalAdmin.setBorder(null);

        javax.swing.GroupLayout panelBorder12Layout = new javax.swing.GroupLayout(panelBorder12);
        panelBorder12.setLayout(panelBorder12Layout);
        panelBorder12Layout.setHorizontalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder12Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(totalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelBorder12Layout.setVerticalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(totalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelBorder13.setBackground(new java.awt.Color(153, 153, 153));
        panelBorder13.setRoundBottomLeft(20);
        panelBorder13.setRoundBottomRight(20);
        panelBorder13.setRoundTopLeft(20);
        panelBorder13.setRoundTopRight(20);

        totalEmp.setBackground(new java.awt.Color(153, 153, 153));
        totalEmp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalEmp.setForeground(new java.awt.Color(255, 255, 255));
        totalEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalEmp.setText("50");
        totalEmp.setToolTipText("");
        totalEmp.setBorder(null);

        javax.swing.GroupLayout panelBorder13Layout = new javax.swing.GroupLayout(panelBorder13);
        panelBorder13.setLayout(panelBorder13Layout);
        panelBorder13Layout.setHorizontalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder13Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(totalEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        panelBorder13Layout.setVerticalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder13Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(totalEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(28, 94, 32));
        jLabel6.setText("Total Admin");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(28, 94, 32));
        jLabel7.setText("Total Employee");

        javax.swing.GroupLayout panelBorder11Layout = new javax.swing.GroupLayout(panelBorder11);
        panelBorder11.setLayout(panelBorder11Layout);
        panelBorder11Layout.setHorizontalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(panelBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        panelBorder11Layout.setVerticalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        panelBorder14.setRoundBottomLeft(20);
        panelBorder14.setRoundBottomRight(20);
        panelBorder14.setRoundTopLeft(20);
        panelBorder14.setRoundTopRight(20);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 94, 32));
        jLabel1.setText("Data Administrators");

        adminTable.setAutoCreateRowSorter(true);
        adminTable.setBackground(new java.awt.Color(255, 254, 243));
        adminTable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        adminTable.setGridColor(new java.awt.Color(204, 204, 204));
        adminTable.setRowHeight(35);
        adminTable.setSelectionBackground(new java.awt.Color(93, 143, 44));
        adminTable.setShowGrid(true);
        jScrollPane1.setViewportView(adminTable);

        javax.swing.GroupLayout panelBorder14Layout = new javax.swing.GroupLayout(panelBorder14);
        panelBorder14.setLayout(panelBorder14Layout);
        panelBorder14Layout.setHorizontalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelBorder14Layout.setVerticalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder14Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panelBorder15.setRoundBottomLeft(20);
        panelBorder15.setRoundBottomRight(20);
        panelBorder15.setRoundTopLeft(20);
        panelBorder15.setRoundTopRight(20);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 94, 32));
        jLabel3.setText("Data Employees");

        empTable.setAutoCreateRowSorter(true);
        empTable.setBackground(new java.awt.Color(255, 254, 243));
        empTable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        empTable.setGridColor(new java.awt.Color(204, 204, 204));
        empTable.setRowHeight(35);
        empTable.setSelectionBackground(new java.awt.Color(93, 143, 44));
        empTable.setShowGrid(true);
        jScrollPane2.setViewportView(empTable);

        javax.swing.GroupLayout panelBorder15Layout = new javax.swing.GroupLayout(panelBorder15);
        panelBorder15.setLayout(panelBorder15Layout);
        panelBorder15Layout.setHorizontalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelBorder15Layout.setVerticalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelBorder14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelBorder15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(haloText, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(panelBorder11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(haloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelBorder11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void haloTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haloTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_haloTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adminTable;
    private javax.swing.JTable empTable;
    private javax.swing.JTextField haloText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.swing.PanelBorder1 panelBorder11;
    private com.swing.PanelBorder1 panelBorder12;
    private com.swing.PanelBorder1 panelBorder13;
    private com.swing.PanelBorder1 panelBorder14;
    private com.swing.PanelBorder1 panelBorder15;
    private javax.swing.JTextField totalAdmin;
    private javax.swing.JTextField totalEmp;
    // End of variables declaration//GEN-END:variables
}
