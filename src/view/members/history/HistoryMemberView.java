/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.members.history;

import view.members.saving.*;
import java.awt.geom.RoundRectangle2D;
import control.AccountsControl;
import control.LoansControl;
import control.TransactionsControl;
import control.SavingsControl;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Accounts;
import model.Members;
import view.members.DashMembersView;

public class HistoryMemberView extends javax.swing.JFrame {
    private Accounts account;
    private TransactionsControl TransactionsControl = new TransactionsControl();
    private SavingsControl SavingControl = new SavingsControl();
    private AccountsControl AccountsControl = new AccountsControl();
    private LoansControl LoansControl = new LoansControl();
    private String selectedTransactionFK = "";
    private String selectedTransactionID = "";
    private String selectedTipePeminjaman = "";
    
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public HistoryMemberView(Accounts account) {
        this.account = account;
        initComponents();
        initJFrame();
        setDefault();
        showDaftarTransaksi();
    }
    
    public void setDefault(){
        detail.setBackground(Color.gray);
    }
    
    public void setDetailEnable(){
        detail.setBackground(new java.awt.Color(73,105,166));
    }
    
    public void showDaftarTransaksi(){
        tabelHistory.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 12));
        tabelHistory.getTableHeader().setOpaque(false);
        tabelHistory.getTableHeader().setForeground(new Color(0, 61, 121));
        tabelHistory.setModel(TransactionsControl.getTransaction(account.getAccount_id(), ""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paryGrp = new javax.swing.ButtonGroup();
        panelBorder11 = new com.swing.PanelBorder1();
        panelBorder21 = new com.swing.PanelBorder1();
        panelBorder20 = new com.swing.PanelBorder1();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        panelBorder12 = new com.swing.PanelBorder1();
        jLabel17 = new javax.swing.JLabel();
        detail = new com.swing.PanelBorder1();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelHistory = new javax.swing.JTable();
        exPanel1 = new com.swing.PanelBorder1();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder11.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder11.setPreferredSize(new java.awt.Dimension(395, 720));
        panelBorder11.setRoundBottomLeft(20);
        panelBorder11.setRoundBottomRight(20);
        panelBorder11.setRoundTopLeft(20);
        panelBorder11.setRoundTopRight(20);

        panelBorder21.setBackground(new java.awt.Color(28, 94, 32));
        panelBorder21.setRoundBottomLeft(50);
        panelBorder21.setRoundBottomRight(50);
        panelBorder21.setRoundTopLeft(20);
        panelBorder21.setRoundTopRight(20);

        panelBorder20.setBackground(new java.awt.Color(28, 94, 32));

        jTextField9.setBackground(new java.awt.Color(28, 94, 32));
        jTextField9.setFont(new java.awt.Font("Krungthep", 1, 20)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setText("Koperasi");
        jTextField9.setBorder(null);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9jTextField5ActionPerformed(evt);
            }
        });

        jTextField10.setBackground(new java.awt.Color(28, 94, 32));
        jTextField10.setFont(new java.awt.Font("Krungthep", 1, 20)); // NOI18N
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
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addContainerGap(96, Short.MAX_VALUE))
        );
        panelBorder21Layout.setVerticalGroup(
            panelBorder21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder21Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBorder21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelBorder12.setBackground(java.awt.Color.gray);
        panelBorder12.setMaximumSize(new java.awt.Dimension(308, 53));
        panelBorder12.setMinimumSize(new java.awt.Dimension(308, 53));
        panelBorder12.setPreferredSize(new java.awt.Dimension(308, 53));
        panelBorder12.setRoundBottomLeft(50);
        panelBorder12.setRoundBottomRight(50);
        panelBorder12.setRoundTopLeft(50);
        panelBorder12.setRoundTopRight(50);
        panelBorder12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBorder12MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Kembali");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder12Layout = new javax.swing.GroupLayout(panelBorder12);
        panelBorder12.setLayout(panelBorder12Layout);
        panelBorder12Layout.setHorizontalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder12Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder12Layout.setVerticalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        detail.setBackground(new java.awt.Color(51, 102, 0));
        detail.setMaximumSize(new java.awt.Dimension(308, 53));
        detail.setMinimumSize(new java.awt.Dimension(308, 53));
        detail.setRoundBottomLeft(50);
        detail.setRoundBottomRight(50);
        detail.setRoundTopLeft(50);
        detail.setRoundTopRight(50);
        detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailMouseClicked(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(51, 102, 0));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Detail Transaksi");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout detailLayout = new javax.swing.GroupLayout(detail);
        detail.setLayout(detailLayout);
        detailLayout.setHorizontalGroup(
            detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        detailLayout.setVerticalGroup(
            detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Krungthep", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Histori Transaksi");

        tabelHistory.setAutoCreateRowSorter(true);
        tabelHistory.setBackground(new java.awt.Color(255, 254, 243));
        tabelHistory.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        tabelHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelHistory.setGridColor(new java.awt.Color(204, 204, 204));
        tabelHistory.setRowHeight(25);
        tabelHistory.setSelectionBackground(new java.awt.Color(93, 143, 44));
        tabelHistory.setShowGrid(true);
        tabelHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelHistory);

        exPanel1.setBackground(new java.awt.Color(0, 0, 0));
        exPanel1.setPreferredSize(new java.awt.Dimension(170, 6));
        exPanel1.setRoundBottomLeft(20);
        exPanel1.setRoundBottomRight(20);
        exPanel1.setRoundTopLeft(20);
        exPanel1.setRoundTopRight(20);
        exPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exPanel1Layout = new javax.swing.GroupLayout(exPanel1);
        exPanel1.setLayout(exPanel1Layout);
        exPanel1Layout.setHorizontalGroup(
            exPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        exPanel1Layout.setVerticalGroup(
            exPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder11Layout = new javax.swing.GroupLayout(panelBorder11);
        panelBorder11.setLayout(panelBorder11Layout);
        panelBorder11Layout.setHorizontalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(exPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBorder12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelBorder11Layout.setVerticalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addComponent(panelBorder21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(exPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField9jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9jTextField5ActionPerformed

    private void jTextField10jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10jTextField6ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void tabelHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelHistoryMouseClicked
        setDetailEnable();
        int clickedRow = tabelHistory.getSelectedRow();
        TableModel tableModel = tabelHistory.getModel();

        selectedTransactionID = tableModel.getValueAt(clickedRow, 0).toString();
        selectedTipePeminjaman = tableModel.getValueAt(clickedRow, 1).toString();
        selectedTransactionFK = tableModel.getValueAt(clickedRow,3).toString();
    }//GEN-LAST:event_tabelHistoryMouseClicked

    private void detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailMouseClicked
        try{
            if(selectedTipePeminjaman.equals("Peminjaman Uang")){
                this.dispose();
                new HistoryLoanView(
                        account, 
                        TransactionsControl.singleTransaction(account.getAccount_id(), selectedTransactionID, ""), 
                        LoansControl.getLoan(selectedTransactionFK, "")
                ).setVisible(true);
            } else if(selectedTipePeminjaman.equals("Savings")){
                this.dispose();
                new HistorySavingView(
                        account, 
                        TransactionsControl.singleTransaction(account.getAccount_id(), selectedTransactionID, ""),
                        SavingControl.singleSavings(selectedTransactionFK), 
                        AccountsControl.selectAccount(account.getAccount_id())).setVisible(true);
            }
        
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Akun Pengguna yang bersangkutan sudah dihapus!");
            System.out.println(e.toString());
            HistoryMemberView hv = new HistoryMemberView(account);
            hv.setVisible(true);
        }
    }//GEN-LAST:event_detailMouseClicked

    private void panelBorder12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder12MouseClicked
        this.dispose();
        new DashMembersView(account).setVisible(true);
    }//GEN-LAST:event_panelBorder12MouseClicked

    private void exPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exPanel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_exPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(HistoryMemberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryMemberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryMemberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryMemberView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryMemberView(new Accounts(0, 0, new Members(0, "", "", "", "", ""), "", "")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.PanelBorder1 detail;
    private com.swing.PanelBorder1 exPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    private com.swing.PanelBorder1 panelBorder11;
    private com.swing.PanelBorder1 panelBorder12;
    private com.swing.PanelBorder1 panelBorder20;
    private com.swing.PanelBorder1 panelBorder21;
    private javax.swing.ButtonGroup paryGrp;
    private javax.swing.JTable tabelHistory;
    // End of variables declaration//GEN-END:variables
}
