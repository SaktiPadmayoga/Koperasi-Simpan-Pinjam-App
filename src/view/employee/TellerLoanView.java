/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.employee;

import java.awt.geom.RoundRectangle2D;
import model.Accounts;
import model.Transactions;
import model.Loans;
import control.AccountsControl;
import control.TransactionsControl;
import control.LoansControl;
import exception.BlankInputException;
import exception.InvalidCalendarException;
import exception.StatusLoansException;
import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.TableModel;
import java.util.concurrent.ThreadLocalRandom;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TellerLoanView extends javax.swing.JFrame {
    private AccountsControl aControl;
    private LoansControl lControl;
    private TransactionsControl tControl;
    private Accounts peminjam = null;
    float rate;
    String type = null;
    String split;
    String newFormat;
    String oldStatusLoan="";
    String idLoan = null;
    String idAcc = null;
    
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public void init(){
        titleBar.initJFram(this);
    }
    
    public TellerLoanView() {
        initComponents();
        setComponent(false);
        generateIdLOA();
        aControl = new AccountsControl();
        tControl = new TransactionsControl();
        lControl = new LoansControl();
        initJFrame();
        showDataCurrently();
        showDataHistory();
        init();
        runUpdate();
    }
    
    public void generateIdLOA(){
        tampilIdPinjaman.setText("LOA-"+String.valueOf(ThreadLocalRandom.current().nextInt(0, 99999)));
    }
    
    public void setComponent(boolean value){
        tampilIdPinjaman.setEnabled(value);
        tampilInterestRate.setEnabled(value);
        namaInput.setEnabled(value);
        cancelPeminjamBtn.setEnabled(value);
        cbStatus.setEnabled(value);
        batalkanPinjamanBtn.setEnabled(value);
        tampilBiayaBulan.setEnabled(value);
        tampilBiayaTahun.setEnabled(value);
    }
    
    public void setDetailPeminjamanArea(boolean value){
        inputIdMember.setEnabled(value);
        cekPeminjamBtn.setEnabled(value);
        if (value==true) {
            inputIdMember.setText("");
            namaInput.setText("");
        }
    }
    
    public void clearText(){
        tampilIdPinjaman.setText("");
        namaInput.setText("");
        inputIdMember.setText("");
        inputJumlahPinjaman.setText("");
        tampilBiayaBulan.setText("");
        tampilBiayaTahun.setText("");
        cbJenisBunga.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        cbTipePinjaman.setSelectedIndex(0);
        tampilInterestRate.setText("");
        dateStartPicker.setCalendar(null);
        dateEndPicker.setCalendar(null);
    }
    
    public void setEditComponent(boolean value){
        inputIdMember.setEnabled(value);
        inputJumlahPinjaman.setEnabled(value);
        dateStartPicker.setEnabled(value);
        dateEndPicker.setEnabled(value);
        cbJenisBunga.setEnabled(value);
        cbTipePinjaman.setEnabled(value);
        tampilBiayaTahun.setEnabled(value);
        tampilBiayaBulan.setEnabled(value);
        batalkanPinjamanBtn.setEnabled(!value);
    }
    public void showDataHistory(){
        loanTable.getTableHeader().setOpaque(false);
        loanTable.getTableHeader().setForeground(new Color(0, 61, 121));
        loanTable.setRowHeight(25);
        loanTable.setModel(lControl.showAllJoinLoans("LOA", "Lunas", "Dibatalkan"));
    }
    
    public void showDataCurrently(){
        confirmLoanTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 12));
        confirmLoanTable.getTableHeader().setOpaque(false);
        confirmLoanTable.getTableHeader().setForeground(new Color(0, 61, 121));
        confirmLoanTable.setRowHeight(25);
        confirmLoanTable.setModel(lControl.showAllJoinLoans("LOA", "Dikonfirmasi", "Menunggu Konfirmasi"));
    }
    
    public String convDateSql(Date input){
        String dateSql = null;
        Date fromView = input;    
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
        Date date = new Date(fromView.getTime());
        try {
            dateSql = format.format(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return dateSql;
    }
    
    public void setRate(){
        if (cbTipePinjaman.getSelectedIndex()==1){
            type = "Umum/Biasa";
            rate = (float) 0.15;
        }
        if(cbTipePinjaman.getSelectedIndex()==2){
            type = "Kendaraan";
            rate = (float) 0.12;
        }
        if(cbTipePinjaman.getSelectedIndex()==3){
            type = "Perumahan";
            rate = (float) 0.1;
        }
        if(cbTipePinjaman.getSelectedIndex()==4){
            type = "Pendidikan";
            rate = (float) 0.08;
        }
        if(cbTipePinjaman.getSelectedIndex()==5){
            type = "Usaha";
            rate = (float) 0.14;
        }
    }
    
    public String formatNominal(BigDecimal nominal){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return df.format(nominal);
    }
    
    private void blankInputException() throws BlankInputException{
        if(namaInput.getText().isEmpty() || inputJumlahPinjaman.getText().isEmpty()
           || cbTipePinjaman.getSelectedIndex()==0  || cbJenisBunga.getSelectedIndex()==0){
                throw new BlankInputException();
        }
    }
    
    private void invalidCalendarException() throws InvalidCalendarException{
        if(dateStartPicker.getCalendar()==null || dateEndPicker.getCalendar()==null){
            throw new InvalidCalendarException();
        }else if(dateStartPicker.getCalendar().compareTo(dateEndPicker.getCalendar())>0){
            throw new InvalidCalendarException();
        }
    }
    
    private void statusLoansException() throws StatusLoansException{
        if(oldStatusLoan.equalsIgnoreCase("Dikonfirmasi") && cbStatus.getSelectedIndex()==1){
            throw new  StatusLoansException();
        }
    }
    
    public void runUpdate(){
        inputJumlahPinjaman.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
                double kalkulasi_perbulan = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate))/12;
                double kalkulasi_pertahun = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate));
                BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                tampilBiayaBulan.setText(formatNominal(bcBulan));
                tampilBiayaTahun.setText(formatNominal(bcTahun));
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    double kalkulasi_perbulan = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate))/12;
                    double kalkulasi_pertahun = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate));
                    BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                    BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                    tampilBiayaBulan.setText(formatNominal(bcBulan));
                    tampilBiayaTahun.setText(formatNominal(bcTahun));
                } catch(Exception handling){
                    handling.getMessage();
                }
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    warn();
                    double kalkulasi_perbulan = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate))/12;
                    double kalkulasi_pertahun = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate));
                    BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                    BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                    tampilBiayaBulan.setText(formatNominal(bcBulan));
                    tampilBiayaTahun.setText(formatNominal(bcTahun));
                }catch(NumberFormatException e1){
                    System.out.println(e1.toString());
              }
            }

            public void warn() {
                try{
                    if (Double.parseDouble(inputJumlahPinjaman.getText())<=0){
                        JOptionPane.showMessageDialog(null, "Amount must be more than 0!", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Amount invalid!", "Error Message", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error "+ e.toString());
                }
            }
        });
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
        panelBorder12 = new com.swing.PanelBorder1();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleBar = new javaswingdev.swing.titlebar.TitleBar();
        jLabel9 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        ajukanPinjamanBtn = new javax.swing.JButton();
        batalkanPinjamanBtn = new javax.swing.JButton();
        panelBorder13 = new com.swing.PanelBorder1();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cancelPeminjamBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        namaInput = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        inputIdMember = new javax.swing.JTextField();
        tampilIdPinjaman = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cekPeminjamBtn = new javax.swing.JButton();
        panelBorder14 = new com.swing.PanelBorder1();
        inputJumlahPinjaman = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        panelBorder15 = new com.swing.PanelBorder1();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        dateEndPicker = new com.toedter.calendar.JDateChooser();
        dateStartPicker = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        panelBorder16 = new com.swing.PanelBorder1();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cbTipePinjaman = new javax.swing.JComboBox<>();
        tampilInterestRate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        panelBorder17 = new com.swing.PanelBorder1();
        jLabel24 = new javax.swing.JLabel();
        cbJenisBunga = new javax.swing.JComboBox<>();
        tampilBiayaTahun = new javax.swing.JTextField();
        tampilBiayaBulan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        panelBorder18 = new com.swing.PanelBorder1();
        jLabel18 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        panelBorder19 = new com.swing.PanelBorder1();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        confirmLoanTable = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        panelBorder20 = new com.swing.PanelBorder1();
        jScrollPane1 = new javax.swing.JScrollPane();
        loanTable = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder11.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder11.setPreferredSize(new java.awt.Dimension(1280, 720));
        panelBorder11.setRoundBottomLeft(20);
        panelBorder11.setRoundBottomRight(20);
        panelBorder11.setRoundTopLeft(20);
        panelBorder11.setRoundTopRight(20);

        panelBorder12.setBackground(new java.awt.Color(28, 94, 32));
        panelBorder12.setPreferredSize(new java.awt.Dimension(1280, 120));
        panelBorder12.setRoundTopLeft(20);
        panelBorder12.setRoundTopRight(20);

        jLabel3.setBackground(new java.awt.Color(28, 94, 32));
        jLabel3.setFont(new java.awt.Font("Krungthep", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Loans");

        jLabel2.setBackground(new java.awt.Color(28, 94, 32));
        jLabel2.setFont(new java.awt.Font("Krungthep", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teller");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sedeng pas.png"))); // NOI18N

        backBtn.setBackground(new java.awt.Color(255, 0, 0));
        backBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder12Layout = new javax.swing.GroupLayout(panelBorder12);
        panelBorder12.setLayout(panelBorder12Layout);
        panelBorder12Layout.setHorizontalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 831, Short.MAX_VALUE)
                .addGroup(panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder12Layout.createSequentialGroup()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder12Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
        );
        panelBorder12Layout.setVerticalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder12Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder12Layout.createSequentialGroup()
                .addGroup(panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder12Layout.createSequentialGroup()
                        .addGroup(panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder12Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2))
                            .addGroup(panelBorder12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(panelBorder12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        ajukanPinjamanBtn.setBackground(new java.awt.Color(25, 135, 84));
        ajukanPinjamanBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        ajukanPinjamanBtn.setForeground(new java.awt.Color(255, 255, 255));
        ajukanPinjamanBtn.setText("Accept");
        ajukanPinjamanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajukanPinjamanBtnActionPerformed(evt);
            }
        });

        batalkanPinjamanBtn.setBackground(new java.awt.Color(194, 16, 16));
        batalkanPinjamanBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        batalkanPinjamanBtn.setForeground(new java.awt.Color(255, 255, 255));
        batalkanPinjamanBtn.setText("Batal");
        batalkanPinjamanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalkanPinjamanBtnActionPerformed(evt);
            }
        });

        panelBorder13.setRoundBottomLeft(20);
        panelBorder13.setRoundBottomRight(20);
        panelBorder13.setRoundTopLeft(20);
        panelBorder13.setRoundTopRight(20);

        jLabel4.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(28, 94, 32));
        jLabel4.setText("Loan ID");

        jLabel15.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(28, 94, 32));
        jLabel15.setText("Loan Detail");

        cancelPeminjamBtn.setBackground(new java.awt.Color(194, 16, 16));
        cancelPeminjamBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cancelPeminjamBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelPeminjamBtn.setText("Cancel");
        cancelPeminjamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPeminjamBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Customer Name");

        namaInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        namaInput.setPreferredSize(new java.awt.Dimension(64, 27));
        namaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaInputActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Customer ID");

        inputIdMember.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        inputIdMember.setPreferredSize(new java.awt.Dimension(64, 27));

        tampilIdPinjaman.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tampilIdPinjaman.setPreferredSize(new java.awt.Dimension(64, 27));

        jPanel1.setBackground(new java.awt.Color(153, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(18, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        cekPeminjamBtn.setBackground(new java.awt.Color(13, 110, 253));
        cekPeminjamBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cekPeminjamBtn.setForeground(new java.awt.Color(255, 255, 255));
        cekPeminjamBtn.setText("OK");
        cekPeminjamBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cekPeminjamBtnMouseClicked(evt);
            }
        });
        cekPeminjamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekPeminjamBtnActionPerformed(evt);
            }
        });
        cekPeminjamBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cekPeminjamBtnKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder13Layout = new javax.swing.GroupLayout(panelBorder13);
        panelBorder13.setLayout(panelBorder13Layout);
        panelBorder13Layout.setHorizontalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tampilIdPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(cancelPeminjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder13Layout.createSequentialGroup()
                        .addGroup(panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(namaInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(inputIdMember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cekPeminjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder13Layout.setVerticalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(tampilIdPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(4, 4, 4)
                .addGroup(panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputIdMember, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekPeminjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cancelPeminjamBtn)
                .addGap(15, 15, 15))
        );

        panelBorder14.setRoundBottomLeft(20);
        panelBorder14.setRoundBottomRight(20);
        panelBorder14.setRoundTopLeft(20);
        panelBorder14.setRoundTopRight(20);

        inputJumlahPinjaman.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(28, 94, 32));
        jLabel25.setText("Amount");

        jPanel11.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder14Layout = new javax.swing.GroupLayout(panelBorder14);
        panelBorder14.setLayout(panelBorder14Layout);
        panelBorder14Layout.setHorizontalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(inputJumlahPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelBorder14Layout.setVerticalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel25)
                .addGap(2, 2, 2)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputJumlahPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelBorder15.setPreferredSize(new java.awt.Dimension(278, 164));
        panelBorder15.setRoundBottomLeft(20);
        panelBorder15.setRoundBottomRight(20);
        panelBorder15.setRoundTopLeft(20);
        panelBorder15.setRoundTopRight(20);

        jLabel19.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(28, 94, 32));
        jLabel19.setText("Loan Start Date");

        jPanel4.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(28, 94, 32));
        jLabel17.setText("Loan End Date");

        javax.swing.GroupLayout panelBorder15Layout = new javax.swing.GroupLayout(panelBorder15);
        panelBorder15.setLayout(panelBorder15Layout);
        panelBorder15Layout.setHorizontalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateEndPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateStartPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelBorder15Layout.setVerticalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addGap(2, 2, 2)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(dateStartPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateEndPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelBorder16.setRoundBottomLeft(20);
        panelBorder16.setRoundBottomRight(20);
        panelBorder16.setRoundTopLeft(20);
        panelBorder16.setRoundTopRight(20);

        jLabel20.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(28, 94, 32));
        jLabel20.setText("Loan Type");

        jPanel7.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        cbTipePinjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Loan Type", "Umum/Biasa", "Kendaraan", "Perumahan", "Pendidikan", "Usaha" }));
        cbTipePinjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipePinjamanActionPerformed(evt);
            }
        });

        tampilInterestRate.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tampilInterestRate.setPreferredSize(new java.awt.Dimension(64, 27));

        jLabel21.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(28, 94, 32));
        jLabel21.setText("Interest Rate");

        jPanel6.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder16Layout = new javax.swing.GroupLayout(panelBorder16);
        panelBorder16.setLayout(panelBorder16Layout);
        panelBorder16Layout.setHorizontalGroup(
            panelBorder16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cbTipePinjaman, 0, 208, Short.MAX_VALUE)
                    .addComponent(tampilInterestRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelBorder16Layout.setVerticalGroup(
            panelBorder16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel20)
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbTipePinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(2, 2, 2)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(tampilInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelBorder17.setRoundBottomLeft(20);
        panelBorder17.setRoundBottomRight(20);
        panelBorder17.setRoundTopLeft(20);
        panelBorder17.setRoundTopRight(20);

        jLabel24.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(28, 94, 32));
        jLabel24.setText("Interest Rate Type");

        cbJenisBunga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Interest Type", "Perbulan", "Pertahun" }));
        cbJenisBunga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisBungaActionPerformed(evt);
            }
        });

        tampilBiayaTahun.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        tampilBiayaBulan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Annual Cost");

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Monthly Cost");

        jPanel10.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder17Layout = new javax.swing.GroupLayout(panelBorder17);
        panelBorder17.setLayout(panelBorder17Layout);
        panelBorder17Layout.setHorizontalGroup(
            panelBorder17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder17Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(tampilBiayaBulan)
                    .addComponent(cbJenisBunga, 0, 208, Short.MAX_VALUE)
                    .addComponent(tampilBiayaTahun))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelBorder17Layout.setVerticalGroup(
            panelBorder17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder17Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel24)
                .addGap(2, 2, 2)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbJenisBunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tampilBiayaBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tampilBiayaTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelBorder18.setRoundBottomLeft(20);
        panelBorder18.setRoundBottomRight(20);
        panelBorder18.setRoundTopLeft(20);
        panelBorder18.setRoundTopRight(20);

        jLabel18.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(28, 94, 32));
        jLabel18.setText("Loan Status");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Loan Status", "Menunggu Konfirmasi", "Dikonfirmasi", "Lunas", "Dibatalkan" }));

        jPanel8.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder18Layout = new javax.swing.GroupLayout(panelBorder18);
        panelBorder18.setLayout(panelBorder18Layout);
        panelBorder18Layout.setHorizontalGroup(
            panelBorder18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder18Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelBorder18Layout.setVerticalGroup(
            panelBorder18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder18Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addGap(2, 2, 2)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panelBorder19.setRoundBottomLeft(20);
        panelBorder19.setRoundBottomRight(20);
        panelBorder19.setRoundTopLeft(20);
        panelBorder19.setRoundTopRight(20);

        jPanel9.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        confirmLoanTable.setAutoCreateRowSorter(true);
        confirmLoanTable.setBackground(new java.awt.Color(255, 254, 243));
        confirmLoanTable.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        confirmLoanTable.setModel(new javax.swing.table.DefaultTableModel(
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
        confirmLoanTable.setGridColor(new java.awt.Color(204, 204, 204));
        confirmLoanTable.setRowHeight(25);
        confirmLoanTable.setSelectionBackground(new java.awt.Color(93, 143, 44));
        confirmLoanTable.setShowGrid(true);
        confirmLoanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmLoanTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(confirmLoanTable);

        jLabel22.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(28, 94, 32));
        jLabel22.setText("Waiting & On Going Loans");

        javax.swing.GroupLayout panelBorder19Layout = new javax.swing.GroupLayout(panelBorder19);
        panelBorder19.setLayout(panelBorder19Layout);
        panelBorder19Layout.setHorizontalGroup(
            panelBorder19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelBorder19Layout.setVerticalGroup(
            panelBorder19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel22)
                .addGap(2, 2, 2)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panelBorder20.setRoundBottomLeft(20);
        panelBorder20.setRoundBottomRight(20);
        panelBorder20.setRoundTopLeft(20);
        panelBorder20.setRoundTopRight(20);

        loanTable.setBackground(new java.awt.Color(255, 254, 243));
        loanTable.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loanTable.setModel(new javax.swing.table.DefaultTableModel(
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
        loanTable.setGridColor(new java.awt.Color(204, 204, 204));
        loanTable.setRowHeight(25);
        loanTable.setSelectionBackground(new java.awt.Color(93, 143, 44));
        loanTable.setShowGrid(true);
        jScrollPane1.setViewportView(loanTable);

        jPanel12.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel23.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(28, 94, 32));
        jLabel23.setText("History Loans");

        javax.swing.GroupLayout panelBorder20Layout = new javax.swing.GroupLayout(panelBorder20);
        panelBorder20.setLayout(panelBorder20Layout);
        panelBorder20Layout.setHorizontalGroup(
            panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder20Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelBorder20Layout.setVerticalGroup(
            panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder20Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel23)
                .addGap(2, 2, 2)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelBorder11Layout = new javax.swing.GroupLayout(panelBorder11);
        panelBorder11.setLayout(panelBorder11Layout);
        panelBorder11Layout.setHorizontalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addComponent(panelBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelBorder14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder11Layout.createSequentialGroup()
                        .addComponent(batalkanPinjamanBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ajukanPinjamanBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder11Layout.setVerticalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder11Layout.createSequentialGroup()
                .addComponent(panelBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBorder14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBorder15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder11Layout.createSequentialGroup()
                        .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelBorder11Layout.createSequentialGroup()
                                .addComponent(panelBorder19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(panelBorder20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder11Layout.createSequentialGroup()
                                .addComponent(panelBorder16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelBorder17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelBorder18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(batalkanPinjamanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ajukanPinjamanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 60, Short.MAX_VALUE))))
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

    private void ajukanPinjamanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajukanPinjamanBtnActionPerformed
        String interest_type = null;
        setRate();
        if (cbJenisBunga.getSelectedIndex()==1) split = tampilBiayaBulan.getText().split(" ")[0];
        else split = tampilBiayaTahun.getText().split(" ")[0];
        
        split = split.replaceAll(",", "");
        split = split.replaceAll("\\.", "");
        try{
            blankInputException();
            invalidCalendarException();
            statusLoansException();
                if (tampilBiayaTahun.getText().equals("") || tampilBiayaBulan.getText().equals("")) {
                int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure to changes loan status?", "Confirmation",JOptionPane.YES_NO_OPTION);
                if(getAnswer == JOptionPane.YES_OPTION){
                    lControl.updateLoan(new Loans(tampilIdPinjaman.getText(), 
                    type, convDateSql(dateStartPicker.getDate()),
                    convDateSql(dateEndPicker.getDate()), 
                    Double.parseDouble(inputJumlahPinjaman.getText()), 
                    rate*100, cbJenisBunga.getSelectedItem().toString(), 
                    Double.parseDouble(split), cbStatus.getSelectedItem().toString()));
                    
                    if(cbStatus.getSelectedItem().equals("Dikonfirmasi")){
                        try {
                            peminjam = aControl.searchAccount(Integer.parseInt(inputIdMember.getText()));
                            peminjam.setBalance(peminjam.getBalance()+Double.parseDouble(inputJumlahPinjaman.getText()));
                            aControl.updateAccounts(peminjam);
                        }catch(Exception e){
                            // pass
                        }
                    }
                    clearText();
                    setDetailPeminjamanArea(true);
                    tampilInterestRate.setText("");
                    showDataHistory();
                    showDataCurrently();
                    setComponent(false);
                    setEditComponent(true);
                    cbStatus.setEnabled(false);
                    generateIdLOA();
                    tampilBiayaBulan.setEnabled(false);
                    tampilBiayaTahun.setEnabled(false); 
                    ajukanPinjamanBtn.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(this, "Failed to changes loan status");
                }
            }else{
              Transactions trans = tControl.searchByStatusLoan(Integer.parseInt(inputIdMember.getText()));
              if(trans!=null){
                  JOptionPane.showMessageDialog(null, "Pengguna sudah memiliki peminjaman!");
              }else{
                  if(inputJumlahPinjaman.getText().length() <= 6){
                      JOptionPane.showMessageDialog(null, "Nominal peminjaman harus lebih dari ratusan ribu");
                  }else{
                      int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure to add new loan?", "Confirmationi",JOptionPane.YES_NO_OPTION);
                      if(getAnswer == JOptionPane.YES_OPTION){
                            tControl.insertTransaction(new Transactions("TR-"+String.valueOf(ThreadLocalRandom.current().nextInt(0, 99999)), 
                            peminjam.getAccount_id(), tampilIdPinjaman.getText(), LocalDate.now().toString()));
                            lControl.insertLoan(new Loans(tampilIdPinjaman.getText(), 
                            type, convDateSql(dateStartPicker.getDate()),
                            convDateSql(dateEndPicker.getDate()), 
                            Double.parseDouble(inputJumlahPinjaman.getText()), 
                            rate*100, cbJenisBunga.getSelectedItem().toString(), 
                            Double.parseDouble(split), "Dikonfirmasi"));


                            clearText();
                            setDetailPeminjamanArea(true);
                            tampilInterestRate.setText("");
                            showDataHistory();
                            showDataCurrently();
                            setComponent(false);
                            setEditComponent(true);
                            cbStatus.setEnabled(false);
                            generateIdLOA();
                            tampilBiayaBulan.setEnabled(false);
                            tampilBiayaTahun.setEnabled(false); 
                            ajukanPinjamanBtn.setEnabled(true);
                        }else{
                            JOptionPane.showMessageDialog(this, "Failed to add new loan");
                        }
                  }
                    
              }
            }
        }catch(BlankInputException e){
            JOptionPane.showConfirmDialog(null, e.message(), "Warning", JOptionPane.DEFAULT_OPTION);
            System.out.println("Error: " + e.toString());
        }catch(InvalidCalendarException e){
            JOptionPane.showConfirmDialog(null, e.message(), "Warning", JOptionPane.DEFAULT_OPTION);
            System.out.println("Error: " + e.toString());
        }catch(NumberFormatException e){
            JOptionPane.showConfirmDialog(null, "Amount must be digit", "Warning", JOptionPane.DEFAULT_OPTION);
            System.out.println("Error: " + e.toString());
        }catch(StatusLoansException e){
            JOptionPane.showConfirmDialog(null, "Invalid Loan Status", "Warning", JOptionPane.DEFAULT_OPTION);
            System.out.println("Error: " + e.toString());
        }
    }//GEN-LAST:event_ajukanPinjamanBtnActionPerformed

    private void batalkanPinjamanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalkanPinjamanBtnActionPerformed
        cbStatus.setEnabled(false);
        setEditComponent(true);
        clearText();
        setComponent(false);
        generateIdLOA();
        cekPeminjamBtn.setEnabled(true);
        ajukanPinjamanBtn.setEnabled(true);
    }//GEN-LAST:event_batalkanPinjamanBtnActionPerformed

    private void cancelPeminjamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPeminjamBtnActionPerformed
        setDetailPeminjamanArea(true);
        cancelPeminjamBtn.setEnabled(false);
    }//GEN-LAST:event_cancelPeminjamBtnActionPerformed

    private void namaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaInputActionPerformed

    }//GEN-LAST:event_namaInputActionPerformed

    private void cekPeminjamBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekPeminjamBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cekPeminjamBtnMouseClicked

    private void cekPeminjamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekPeminjamBtnActionPerformed
        try {
            peminjam = aControl.searchAccount(Integer.parseInt(inputIdMember.getText()));
            if(peminjam!=null){
                namaInput.setText(peminjam.getMember().getFirst_name()+" "+peminjam.getMember().getLast_name());
                setDetailPeminjamanArea(false);
                cancelPeminjamBtn.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Account not found","Confirmation", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_cekPeminjamBtnActionPerformed

    private void cekPeminjamBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cekPeminjamBtnKeyPressed
        try {
            peminjam = aControl.searchAccount(Integer.parseInt(inputIdMember.getText()));
            if(peminjam!=null){
                namaInput.setText(peminjam.getMember().getFirst_name()+" "+peminjam.getMember().getLast_name());
                setDetailPeminjamanArea(false);
                cancelPeminjamBtn.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null,"Account not found","Confirmation", JOptionPane.DEFAULT_OPTION);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Account not found","Confirmation", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_cekPeminjamBtnKeyPressed

    private void cbTipePinjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipePinjamanActionPerformed
        if (cbTipePinjaman.getSelectedIndex()==1){
            tampilInterestRate.setText("15%");
        }
        if(cbTipePinjaman.getSelectedIndex()==2){
            tampilInterestRate.setText("12%");
        }
        if(cbTipePinjaman.getSelectedIndex()==3){
            tampilInterestRate.setText("10%");
        }
        if(cbTipePinjaman.getSelectedIndex()==4){
            tampilInterestRate.setText("8%");
        }
        if(cbTipePinjaman.getSelectedIndex()==5){
            tampilInterestRate.setText("14%");
        }
        setRate();
    }//GEN-LAST:event_cbTipePinjamanActionPerformed

    private void cbJenisBungaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisBungaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisBungaActionPerformed

    private void confirmLoanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmLoanTableMouseClicked
        cbStatus.setEnabled(true);
        setEditComponent(false);
        int clickedRow = confirmLoanTable.getSelectedRow();
        TableModel tableModel = confirmLoanTable.getModel();
        idLoan = tableModel.getValueAt(clickedRow,0).toString();
        tampilIdPinjaman.setText(idLoan);
        idAcc = tableModel.getValueAt(clickedRow,1).toString();
        inputIdMember.setText(idAcc);
        peminjam = aControl.searchAccount(Integer.parseInt(inputIdMember.getText()));
        namaInput.setText(peminjam.getMember().getFirst_name()+" "+peminjam.getMember().getLast_name());
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(tableModel.getValueAt(clickedRow,5).toString().substring(6, 10)),
                Integer.parseInt(tableModel.getValueAt(clickedRow,5).toString().substring(3, 5))-1,
                Integer.parseInt(tableModel.getValueAt(clickedRow,5).toString().substring(0, 2)));
        dateStartPicker.setCalendar(c);
        c.set(Integer.parseInt(tableModel.getValueAt(clickedRow,9).toString().substring(6, 10)),
                Integer.parseInt(tableModel.getValueAt(clickedRow,9).toString().substring(3, 5))-1,
                Integer.parseInt(tableModel.getValueAt(clickedRow,9).toString().substring(0, 2)));
        dateEndPicker.setCalendar(c);
        inputJumlahPinjaman.setText(tableModel.getValueAt(clickedRow,3).toString());
        cbTipePinjaman.setSelectedItem(tableModel.getValueAt(clickedRow,2).toString());
        cbJenisBunga.setSelectedItem(tableModel.getValueAt(clickedRow,8).toString());
        cbStatus.setSelectedItem(tableModel.getValueAt(clickedRow,6).toString());
        setRate();
        oldStatusLoan = tableModel.getValueAt(clickedRow,6).toString();
        if (cbJenisBunga.getSelectedIndex()==1) tampilBiayaTahun.setText("");
        else tampilBiayaBulan.setText("");
        cekPeminjamBtn.setEnabled(false);
    }//GEN-LAST:event_confirmLoanTableMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        DashTellerView dv = new DashTellerView();
        this.dispose();
        dv.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TellerLoanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajukanPinjamanBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton batalkanPinjamanBtn;
    private javax.swing.JButton cancelPeminjamBtn;
    private javax.swing.JComboBox<String> cbJenisBunga;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbTipePinjaman;
    private javax.swing.JButton cekPeminjamBtn;
    private javax.swing.JTable confirmLoanTable;
    private com.toedter.calendar.JDateChooser dateEndPicker;
    private com.toedter.calendar.JDateChooser dateStartPicker;
    private javax.swing.JTextField inputIdMember;
    private javax.swing.JTextField inputJumlahPinjaman;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable loanTable;
    private javax.swing.JTextField namaInput;
    private com.swing.PanelBorder1 panelBorder11;
    private com.swing.PanelBorder1 panelBorder12;
    private com.swing.PanelBorder1 panelBorder13;
    private com.swing.PanelBorder1 panelBorder14;
    private com.swing.PanelBorder1 panelBorder15;
    private com.swing.PanelBorder1 panelBorder16;
    private com.swing.PanelBorder1 panelBorder17;
    private com.swing.PanelBorder1 panelBorder18;
    private com.swing.PanelBorder1 panelBorder19;
    private com.swing.PanelBorder1 panelBorder20;
    private javax.swing.JTextField tampilBiayaBulan;
    private javax.swing.JTextField tampilBiayaTahun;
    private javax.swing.JTextField tampilIdPinjaman;
    private javax.swing.JTextField tampilInterestRate;
    private javaswingdev.swing.titlebar.TitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
