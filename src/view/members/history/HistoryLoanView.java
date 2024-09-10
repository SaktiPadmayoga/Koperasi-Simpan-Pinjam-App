/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.members.history;

import view.members.loan.*;
import view.members.saving.*;
import java.awt.geom.RoundRectangle2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import model.Accounts;
import model.Members;
import model.Loans;
import model.Transactions;

/**
 *
 * @author User
 */
public class HistoryLoanView extends javax.swing.JFrame {
    
    private Accounts account;
    private Loans loan;
    private Transactions transaction;
    
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public HistoryLoanView(Accounts account, Transactions transaction, Loans loan) {
        this.account = account;
        this.loan = loan;
        this.transaction = transaction;
        initComponents();
        date_idtrans.setText(create_date(transaction.getTransaction_date())+" ∙ No. Transaksi : "+transaction.getTransaction_id());
        nama_penerima.setText(account.getMember().getFirst_name() + " " + account.getMember().getLast_name());
        tipe_peminjaman.setText(loan.getLoan_type());
        BigDecimal total = new BigDecimal(loan.getAmount()).setScale(0, RoundingMode.HALF_EVEN);
        total_peminjaman.setText("Rp. "+formatNominal(total));
        tanggal_peminjaman.setText(create_date_loan(loan.getLoan_start_date()));
        tanggal_kembali.setText(create_date_loan(loan.getLoan_end_date()));
        bunga.setText(loan.getInterest_rate()+"%");
        BigDecimal bayar = new BigDecimal(loan.getEnd_amount_pay()).setScale(0, RoundingMode.HALF_EVEN);
        total_bayar.setText("Rp. "+formatNominal(bayar));
        status.setText(loan.getConfirm());
        metode_pembayaran.setText(loan.getInterest_rate_type());
        initJFrame();
    }
    
    public String formatNominal(BigDecimal nominal){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return df.format(nominal);
    }
    
    public String create_date(String date_send){
        if(date_send.contains("T")){
            String[] date = date_send.split("T");
            String[] date2 = date[0].split("-");
            String[] time = date[1].split("\\.");
            String[] time2 = time[0].split(":");
            switch (date2[1]){
                case "01":
                    date2[1] = "Januari";
                    break;
                case "02":
                    date2[1] = "Februari";
                    break;
                case "03":
                    date2[1] = "Maret";
                    break;
                case "04":
                    date2[1] = "April";
                    break;
                case "05":
                    date2[1] = "Mei";
                    break;
                case "06":
                    date2[1] = "Juni";
                    break;
                case "07":
                    date2[1] = "Juli";
                    break;
                case "08":
                    date2[1] = "Agustus";
                    break;
                case "09":
                    date2[1] = "September";
                    break;
                case "10":
                    date2[1] = "Oktober";
                    break;
                case "11":
                    date2[1] = "November";
                    break;
                case "12":
                    date2[1] = "Desember";
                    break;
            }
            String new_date = date2[2] + " " + date2[1] + " " + date2[0] + " ∙ " + time2[0] + ":" + time2[1] + ":" + time2[2];
            return new_date;
        }else{
            String[] date = date_send.split(" ");
            String[] date2 = date[0].split("-");
            String[] time = date[1].split("\\.");
            String[] time2 = time[0].split(":");
            switch (date2[1]){
                case "01":
                    date2[1] = "Januari";
                    break;
                case "02":
                    date2[1] = "Februari";
                    break;
                case "03":
                    date2[1] = "Maret";
                    break;
                case "04":
                    date2[1] = "April";
                    break;
                case "05":
                    date2[1] = "Mei";
                    break;
                case "06":
                    date2[1] = "Juni";
                    break;
                case "07":
                    date2[1] = "Juli";
                    break;
                case "08":
                    date2[1] = "Agustus";
                    break;
                case "09":
                    date2[1] = "September";
                    break;
                case "10":
                    date2[1] = "Oktober";
                    break;
                case "11":
                    date2[1] = "November";
                    break;
                case "12":
                    date2[1] = "Desember";
                    break;
            }
            String new_date = date2[2] + " " + date2[1] + " " + date2[0] + " ∙ " + time2[0] + ":" + time2[1] + ":" + time2[2];
            return new_date;
        }
    }
    
    public String create_date_loan(String date_send){
        String[] date = date_send.split("-");
        switch (date[1]){
            case "01":
                date[1] = "Januari";
                break;
            case "02":
                date[1] = "Februari";
                break;
            case "03":
                date[1] = "Maret";
                break;
            case "04":
                date[1] = "April";
                break;
            case "05":
                date[1] = "Mei";
                break;
            case "06":
                date[1] = "Juni";
                break;
            case "07":
                date[1] = "Juli";
                break;
            case "08":
                date[1] = "Agustus";
                break;
            case "09":
                date[1] = "September";
                break;
            case "10":
                date[1] = "Oktober";
                break;
            case "11":
                date[1] = "November";
                break;
            case "12":
                date[1] = "Desember";
                break;
        }
        String new_date = date[2] + " " + date[1] + " " + date[0];
        return new_date;
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
        panelBorder13 = new com.swing.PanelBorder1();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        to_accid = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        date_idtrans = new javax.swing.JLabel();
        metode_pembayaran = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nama_penerima = new javax.swing.JLabel();
        total_peminjaman = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tanggal_peminjaman = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        total_bayar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tanggal_kembali = new javax.swing.JLabel();
        tipe_peminjaman = new javax.swing.JLabel();
        bunga = new javax.swing.JLabel();
        exPanel2 = new com.swing.PanelBorder1();

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
                .addContainerGap(107, Short.MAX_VALUE))
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

        panelBorder13.setBackground(new java.awt.Color(51, 102, 0));
        panelBorder13.setMaximumSize(new java.awt.Dimension(308, 53));
        panelBorder13.setMinimumSize(new java.awt.Dimension(308, 53));
        panelBorder13.setRoundBottomLeft(50);
        panelBorder13.setRoundBottomRight(50);
        panelBorder13.setRoundTopLeft(50);
        panelBorder13.setRoundTopRight(50);
        panelBorder13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBorder13MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Kembali ke Dashboard");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder13Layout = new javax.swing.GroupLayout(panelBorder13);
        panelBorder13.setLayout(panelBorder13Layout);
        panelBorder13Layout.setHorizontalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder13Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        panelBorder13Layout.setVerticalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipe Peminjaman");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Tanggal Peminjaman");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Suku Bunga Peminjaman");

        to_accid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        to_accid.setForeground(new java.awt.Color(102, 102, 102));
        to_accid.setText("Account ID - 210711111");

        status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status.setText("Status");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Total Peminjaman");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Total Yang Harus Dibayar");

        date_idtrans.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_idtrans.setForeground(new java.awt.Color(153, 153, 153));
        date_idtrans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        date_idtrans.setText("11 Mei 2023 - 14:08:49 - No. Transaksi : TR-222222222");

        metode_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        metode_pembayaran.setText("Metode");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Metode Pembayar");

        nama_penerima.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nama_penerima.setText("Nama");

        total_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_peminjaman.setText("Rp. 1.000.000");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Penerima");

        tanggal_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tanggal_peminjaman.setText("Tanggal");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Status Peminjaman");

        total_bayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_bayar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total_bayar.setText("Rp. 1.000.000");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Peminjaman Berhasil diajukan!");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Detail Transaksi");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Tanggal Kembali");

        jPanel4.setPreferredSize(new java.awt.Dimension(100, 4));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        tanggal_kembali.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tanggal_kembali.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tanggal_kembali.setText("Tanggal");

        tipe_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tipe_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tipe_peminjaman.setText("Tipe Peminjaman");

        bunga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bunga.setText("Bunga Peminjaman");

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

        javax.swing.GroupLayout panelBorder11Layout = new javax.swing.GroupLayout(panelBorder11);
        panelBorder11.setLayout(panelBorder11Layout);
        panelBorder11Layout.setHorizontalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder11Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(to_accid)
                                    .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder11Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(total_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelBorder11Layout.createSequentialGroup()
                                            .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(tanggal_peminjaman)
                                                .addComponent(jLabel11)
                                                .addComponent(bunga)
                                                .addComponent(jLabel12)
                                                .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel14)
                                                .addComponent(status)
                                                .addComponent(jLabel15)
                                                .addComponent(metode_pembayaran))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tanggal_kembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panelBorder11Layout.createSequentialGroup()
                                            .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(nama_penerima))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tipe_peminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(panelBorder11Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(date_idtrans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder11Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder11Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(exPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder11Layout.setVerticalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addComponent(panelBorder21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_idtrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama_penerima)
                    .addComponent(tipe_peminjaman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(to_accid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total_peminjaman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggal_peminjaman)
                    .addComponent(tanggal_kembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(metode_pembayaran)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bunga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_bayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(exPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void panelBorder13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder13MouseClicked
        this.dispose();
        new HistoryMemberView(account).setVisible(true);
    }//GEN-LAST:event_panelBorder13MouseClicked

    private void exPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exPanel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_exPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(HistoryLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new HistoryLoanView(new Accounts(0, 0, new Members(0, "", "", "", "", ""), "", ""), new Transactions("",0,"",""), new Loans("", "", "", "", 0.0, 0, "", 0, "")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bunga;
    private javax.swing.JLabel date_idtrans;
    private com.swing.PanelBorder1 exPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel metode_pembayaran;
    private javax.swing.JLabel nama_penerima;
    private com.swing.PanelBorder1 panelBorder11;
    private com.swing.PanelBorder1 panelBorder13;
    private com.swing.PanelBorder1 panelBorder20;
    private com.swing.PanelBorder1 panelBorder21;
    private javax.swing.ButtonGroup paryGrp;
    private javax.swing.JLabel status;
    private javax.swing.JLabel tanggal_kembali;
    private javax.swing.JLabel tanggal_peminjaman;
    private javax.swing.JLabel tipe_peminjaman;
    private javax.swing.JLabel to_accid;
    private javax.swing.JLabel total_bayar;
    private javax.swing.JLabel total_peminjaman;
    // End of variables declaration//GEN-END:variables
}
