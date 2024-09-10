package view.members;

import control.AccountsControl;
import java.awt.geom.RoundRectangle2D;
import model.Accounts;
import model.Members;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import view.members.history.HistoryMemberView;
import view.members.loan.DashLoanView;
import view.members.saving.SaveMemberView;

public class DashMembersView extends javax.swing.JFrame {
    private Accounts account;
    private AccountsControl aControl;
    
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public DashMembersView(Accounts account) {
        aControl = new AccountsControl();
        this.account = account;
        this.account = aControl.searchAccount(account.getAccount_id());
        initComponents();
        initJFrame();
        namaKartu.setText(this.account.getMember().getFirst_name() + " " + this.account.getMember().getLast_name());
        account_rek.setText(String.valueOf(this.account.getAccount_id()));
        BigDecimal saldoDc = new BigDecimal(this.account.getBalance()).setScale(0, RoundingMode.HALF_EVEN);
        saldo.setText("Rp. "+formatNominal(saldoDc));
    }
    
    public String formatNominal(BigDecimal nominal){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return df.format(nominal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder110 = new com.swing.PanelBorder1();
        panelBorder21 = new com.swing.PanelBorder1();
        panelBorder20 = new com.swing.PanelBorder1();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginlabel1 = new javax.swing.JLabel();
        panelBorder13 = new com.swing.PanelBorder1();
        namaKartu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        saldo = new javax.swing.JTextField();
        account_rek = new javax.swing.JLabel();
        logoutPanel = new com.swing.PanelBorder1();
        jLabel2 = new javax.swing.JLabel();
        historyPanel = new com.swing.PanelBorder1();
        jTextField4 = new javax.swing.JTextField();
        loanPanel = new com.swing.PanelBorder1();
        jLabel5 = new javax.swing.JLabel();
        loginlabel2 = new javax.swing.JLabel();
        savePanel = new com.swing.PanelBorder1();
        jLabel4 = new javax.swing.JLabel();
        exPanel2 = new com.swing.PanelBorder1();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder110.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder110.setPreferredSize(new java.awt.Dimension(395, 917));
        panelBorder110.setRoundBottomLeft(20);
        panelBorder110.setRoundBottomRight(20);
        panelBorder110.setRoundTopLeft(20);
        panelBorder110.setRoundTopRight(20);

        panelBorder21.setBackground(new java.awt.Color(28, 94, 32));
        panelBorder21.setRoundBottomLeft(50);
        panelBorder21.setRoundBottomRight(50);
        panelBorder21.setRoundTopLeft(20);
        panelBorder21.setRoundTopRight(20);

        panelBorder20.setBackground(new java.awt.Color(28, 94, 32));

        jTextField9.setBackground(new java.awt.Color(28, 94, 32));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setText("Koperasi");
        jTextField9.setBorder(null);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9jTextField5ActionPerformed(evt);
            }
        });

        jTextField10.setBackground(new java.awt.Color(28, 94, 32));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setText("Simpan Pinjam");
        jTextField10.setBorder(null);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder20Layout = new javax.swing.GroupLayout(panelBorder20);
        panelBorder20.setLayout(panelBorder20Layout);
        panelBorder20Layout.setHorizontalGroup(
            panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder20Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelBorder20Layout.setVerticalGroup(
            panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/63.png"))); // NOI18N

        javax.swing.GroupLayout panelBorder21Layout = new javax.swing.GroupLayout(panelBorder21);
        panelBorder21.setLayout(panelBorder21Layout);
        panelBorder21Layout.setHorizontalGroup(
            panelBorder21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder21Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        panelBorder21Layout.setVerticalGroup(
            panelBorder21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder21Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBorder21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        loginlabel1.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
        loginlabel1.setForeground(new java.awt.Color(28, 94, 32));
        loginlabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginlabel1.setText("Welcome Back");

        panelBorder13.setBackground(new java.awt.Color(51, 51, 51));
        panelBorder13.setRoundBottomLeft(20);
        panelBorder13.setRoundBottomRight(20);
        panelBorder13.setRoundTopLeft(20);
        panelBorder13.setRoundTopRight(20);

        namaKartu.setBackground(new java.awt.Color(51, 51, 51));
        namaKartu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        namaKartu.setForeground(new java.awt.Color(255, 255, 255));
        namaKartu.setText("Ragil Riztianda");
        namaKartu.setBorder(null);
        namaKartu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        namaKartu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKartuActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Saldo Anda");

        saldo.setBackground(new java.awt.Color(51, 51, 51));
        saldo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        saldo.setForeground(new java.awt.Color(255, 255, 255));
        saldo.setText("Rp. 500000");
        saldo.setBorder(null);

        account_rek.setBackground(new java.awt.Color(0, 0, 0));
        account_rek.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        account_rek.setForeground(new java.awt.Color(255, 255, 255));
        account_rek.setText("1234567890");

        javax.swing.GroupLayout panelBorder13Layout = new javax.swing.GroupLayout(panelBorder13);
        panelBorder13.setLayout(panelBorder13Layout);
        panelBorder13Layout.setHorizontalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder13Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(namaKartu, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(account_rek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        panelBorder13Layout.setVerticalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(namaKartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(account_rek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        logoutPanel.setBackground(new java.awt.Color(255, 0, 0));
        logoutPanel.setPreferredSize(new java.awt.Dimension(248, 70));
        logoutPanel.setRoundBottomLeft(20);
        logoutPanel.setRoundBottomRight(20);
        logoutPanel.setRoundTopLeft(20);
        logoutPanel.setRoundTopRight(20);
        logoutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanelMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel2.setText("Logout");

        javax.swing.GroupLayout logoutPanelLayout = new javax.swing.GroupLayout(logoutPanel);
        logoutPanel.setLayout(logoutPanelLayout);
        logoutPanelLayout.setHorizontalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutPanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel2)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        logoutPanelLayout.setVerticalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        historyPanel.setBackground(new java.awt.Color(28, 94, 32));
        historyPanel.setRoundBottomLeft(20);
        historyPanel.setRoundBottomRight(20);
        historyPanel.setRoundTopLeft(20);
        historyPanel.setRoundTopRight(20);
        historyPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyPanelMouseClicked(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(28, 94, 32));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("History");
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        loanPanel.setBackground(new java.awt.Color(28, 94, 32));
        loanPanel.setRoundBottomLeft(20);
        loanPanel.setRoundBottomRight(20);
        loanPanel.setRoundTopLeft(20);
        loanPanel.setRoundTopRight(20);
        loanPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loanPanelMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pinjam");

        javax.swing.GroupLayout loanPanelLayout = new javax.swing.GroupLayout(loanPanel);
        loanPanel.setLayout(loanPanelLayout);
        loanPanelLayout.setHorizontalGroup(
            loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loanPanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loanPanelLayout.setVerticalGroup(
            loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loanPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        loginlabel2.setFont(new java.awt.Font("Krungthep", 1, 14)); // NOI18N
        loginlabel2.setForeground(new java.awt.Color(28, 94, 32));
        loginlabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginlabel2.setText("Choose the transaction");

        savePanel.setBackground(new java.awt.Color(28, 94, 32));
        savePanel.setRoundBottomLeft(20);
        savePanel.setRoundBottomRight(20);
        savePanel.setRoundTopLeft(20);
        savePanel.setRoundTopRight(20);
        savePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savePanelMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Simpan");

        javax.swing.GroupLayout savePanelLayout = new javax.swing.GroupLayout(savePanel);
        savePanel.setLayout(savePanelLayout);
        savePanelLayout.setHorizontalGroup(
            savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, savePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(105, 105, 105))
        );
        savePanelLayout.setVerticalGroup(
            savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        exPanel2.setBackground(new java.awt.Color(0, 0, 0));
        exPanel2.setPreferredSize(new java.awt.Dimension(170, 6));
        exPanel2.setRoundBottomLeft(20);
        exPanel2.setRoundBottomRight(20);
        exPanel2.setRoundTopLeft(20);
        exPanel2.setRoundTopRight(20);
        exPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exPanel2Layout = new javax.swing.GroupLayout(exPanel2);
        exPanel2.setLayout(exPanel2Layout);
        exPanel2Layout.setHorizontalGroup(
            exPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        exPanel2Layout.setVerticalGroup(
            exPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder110Layout = new javax.swing.GroupLayout(panelBorder110);
        panelBorder110.setLayout(panelBorder110Layout);
        panelBorder110Layout.setHorizontalGroup(
            panelBorder110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder110Layout.createSequentialGroup()
                .addGroup(panelBorder110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder110Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(loginlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder110Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder110Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panelBorder110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(loanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(historyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(savePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder110Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(loginlabel2)
                                .addGap(60, 60, 60)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder110Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        panelBorder110Layout.setVerticalGroup(
            panelBorder110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder110Layout.createSequentialGroup()
                .addComponent(panelBorder21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginlabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(savePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(exPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder110, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField9jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9jTextField5ActionPerformed

    private void jTextField10jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10jTextField6ActionPerformed

    private void namaKartuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKartuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKartuActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked
        this.dispose();
        new LoginMembersView().setVisible(true);
    }//GEN-LAST:event_logoutPanelMouseClicked

    private void savePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savePanelMouseClicked
        this.dispose();
        new SaveMemberView(account).setVisible(true);
    }//GEN-LAST:event_savePanelMouseClicked

    private void loanPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanPanelMouseClicked
        this.dispose();
        new DashLoanView(account).setVisible(true);
    }//GEN-LAST:event_loanPanelMouseClicked

    private void historyPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyPanelMouseClicked
        this.dispose();
        new HistoryMemberView(account).setVisible(true);
    }//GEN-LAST:event_historyPanelMouseClicked

    private void exPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exPanel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_exPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(DashMembersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashMembersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashMembersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashMembersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashMembersView(new Accounts(0, 0.0, new Members(0, "", "", "", "", ""), "", "")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account_rek;
    private com.swing.PanelBorder1 exPanel2;
    private com.swing.PanelBorder1 historyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField9;
    private com.swing.PanelBorder1 loanPanel;
    private javax.swing.JLabel loginlabel1;
    private javax.swing.JLabel loginlabel2;
    private com.swing.PanelBorder1 logoutPanel;
    private javax.swing.JTextField namaKartu;
    private com.swing.PanelBorder1 panelBorder110;
    private com.swing.PanelBorder1 panelBorder13;
    private com.swing.PanelBorder1 panelBorder20;
    private com.swing.PanelBorder1 panelBorder21;
    private javax.swing.JTextField saldo;
    private com.swing.PanelBorder1 savePanel;
    // End of variables declaration//GEN-END:variables
}
