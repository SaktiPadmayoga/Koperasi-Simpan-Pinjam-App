package view.employee.login;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import control.AdministratorsControl;
import control.EmployeesControl;
import javax.swing.JOptionPane;
import model.Administrators;
import model.Employees;
import view.admin.*;
import view.employee.*;

public class LoginView extends javax.swing.JFrame {
    private AdministratorsControl adminControl;
    private EmployeesControl empControl;
    private Administrators admin;
    private Employees emp;
    private AdminMainView dasView;
    
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public void init(){
        titleBar.initJFram(this);
    }
    
    public LoginView() {
        initComponents();
        initJFrame();
        init();
        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder11 = new com.swing.PanelBorder1();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        userInput = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        userlabel = new javax.swing.JLabel();
        loginlabel = new javax.swing.JLabel();
        loginlabel1 = new javax.swing.JLabel();
        loginlabel2 = new javax.swing.JLabel();
        passlabel = new javax.swing.JLabel();
        titleBar = new javaswingdev.swing.titlebar.TitleBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder11.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder11.setRoundBottomLeft(20);
        panelBorder11.setRoundBottomRight(20);
        panelBorder11.setRoundTopLeft(20);
        panelBorder11.setRoundTopRight(20);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkGradientFocus(10);
        kGradientPanel1.setkStartColor(new java.awt.Color(28, 94, 32));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plisss.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(450, 460));

        jLabel3.setFont(new java.awt.Font("Krungthep", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SIMPAN PINJAM");

        jLabel1.setFont(new java.awt.Font("Krungthep", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KOPERASI ");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel3)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        passwordInput.setBackground(new java.awt.Color(255, 255, 255));
        passwordInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        passwordInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 94, 32), 2, true));
        passwordInput.setPreferredSize(new java.awt.Dimension(64, 27));

        userInput.setBackground(new java.awt.Color(255, 255, 255));
        userInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        userInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 94, 32), 2, true));
        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        loginBtn.setBackground(new java.awt.Color(28, 94, 32));
        loginBtn.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(245, 245, 245));
        loginBtn.setText("Login");
        loginBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        loginBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginBtnFocusGained(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        loginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBtnKeyPressed(evt);
            }
        });

        userlabel.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        userlabel.setForeground(new java.awt.Color(28, 94, 32));
        userlabel.setText("Username");

        loginlabel.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        loginlabel.setForeground(new java.awt.Color(28, 94, 32));
        loginlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginlabel.setText("Please enter your username and password");

        loginlabel1.setFont(new java.awt.Font("Krungthep", 1, 36)); // NOI18N
        loginlabel1.setForeground(new java.awt.Color(28, 94, 32));
        loginlabel1.setText("Welcome Back");

        loginlabel2.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
        loginlabel2.setForeground(new java.awt.Color(28, 94, 32));
        loginlabel2.setText("LOGIN");

        passlabel.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        passlabel.setForeground(new java.awt.Color(28, 94, 32));
        passlabel.setText("Password");

        javax.swing.GroupLayout panelBorder11Layout = new javax.swing.GroupLayout(panelBorder11);
        panelBorder11.setLayout(panelBorder11Layout);
        panelBorder11Layout.setHorizontalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                        .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                                .addComponent(loginlabel2)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userlabel)
                                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passlabel)
                                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                                .addComponent(loginlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                        .addComponent(loginlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelBorder11Layout.setVerticalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(loginlabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginlabel)
                .addGap(41, 41, 41)
                .addComponent(loginlabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

    private void loginBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginBtnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnFocusGained

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        adminControl = new AdministratorsControl();
        empControl = new EmployeesControl();

        admin = new Administrators(0, userInput.getText(), String.valueOf(passwordInput.getPassword()));
        emp = new Employees(0,"", "",userInput.getText(), String.valueOf(passwordInput.getPassword()), "", "", 0, "", "");

        if(adminControl.searchAdministrators(admin) != null){
            this.admin=adminControl.searchAdministrators(admin);
            dasView = new AdminMainView(admin);
            this.dispose();
            dasView.setVisible(true);
        }else if(empControl.searchEmployees(emp)!=null){
            emp=empControl.searchEmployees(emp);
            if(emp.getRole_id()==1){
                DashTellerView tv = new DashTellerView();
                this.dispose();
                tv.setVisible(true);
            }else{
                CustomerServiceView csv = new CustomerServiceView();
                this.dispose();
                csv.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this,"Username or Password was Incorrect!");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void loginBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBtnKeyPressed
        adminControl= new AdministratorsControl();
        empControl=new EmployeesControl();

        admin = new Administrators(0, userInput.getText(), String.valueOf(passwordInput.getPassword()));
        emp= new Employees(0,"", "",userInput.getText(), String.valueOf(passwordInput.getPassword()), "", "", 0, "", "");

        if(adminControl.searchAdministrators(admin)!=null){
            this.admin=adminControl.searchAdministrators(admin);
            dasView = new AdminMainView(admin);
            this.dispose();
            dasView.setVisible(true);
        }else if(empControl.searchEmployees(emp)!=null){
            emp=empControl.searchEmployees(emp);
            if(emp.getRole_id()==1){
                DashTellerView tv = new DashTellerView();
                this.dispose();
                tv.setVisible(true);
            }else{
                CustomerServiceView csv = new CustomerServiceView();
                this.dispose();
                csv.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this,"Username or Password was Incorrect!");
        }
    }//GEN-LAST:event_loginBtnKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginlabel;
    private javax.swing.JLabel loginlabel1;
    private javax.swing.JLabel loginlabel2;
    private com.swing.PanelBorder1 panelBorder11;
    private javax.swing.JLabel passlabel;
    private javax.swing.JPasswordField passwordInput;
    private javaswingdev.swing.titlebar.TitleBar titleBar;
    private javax.swing.JTextField userInput;
    private javax.swing.JLabel userlabel;
    // End of variables declaration//GEN-END:variables
}
