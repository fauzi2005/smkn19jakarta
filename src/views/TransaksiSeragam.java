/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import connectionDB.koneksi;

public class TransaksiSeragam extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public TransaksiSeragam(java.awt.Frame parent, boolean modal) {
        initComponents();
        aktif();
        datatable();
    }
    
    protected void aktif(){
        
        id_tu.setEnabled(true);
        nama_pengurus.setEnabled(true);
        nis_siswa.setEnabled(true);
        nama_siswa.setEnabled(true);
        jurusan.setEnabled(true);
        harga.setEnabled(false);
        tcari.setEnabled(true);
        tjenis.setEnabled(false);
        tukuran.setEnabled(false);
        
        id_tu.requestFocus();
    }
    
    protected void kosong(){
        id_tu.setText("");
        nama_pengurus.setText("");
        nis_siswa.setText("");
        nama_siswa.setText("");
        jurusan.setText("");
        cjenis.setSelectedIndex(0);
        cukuran.setSelectedIndex(0);
        harga.setText("");
        tjenis.setText("");
        tukuran.setText("");
        tcari.setText("");
    }
    
    protected void datatable(){
    Object [] Baris = {"PENGURUS","NIS SISWA","NAMA","JURUSAN","JENIS","UKURAN","HARGA"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelseragam.setModel(tabmode);
    String sql = "select * from transaksi_pembayaran_seragam";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("nama_tu");
            String b = hasil.getString("nis_siswa");
            String c = hasil.getString("nama_siswa");
            String d = hasil.getString("jurusan");
            String e = hasil.getString("jenis_seragam");
            String f = hasil.getString("ukuran");
            String g = hasil.getString("harga");
            
            String[] data={a,b,c,d,e,f,g};
            tabmode.addRow(data);
        }
    }catch (Exception e){
        
        }
    }
    
    public TransaksiSeragam() {
        initComponents();
        aktif();
        datatable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama_siswa = new javax.swing.JTextField();
        nis_siswa = new javax.swing.JTextField();
        cari_nis_siswa = new javax.swing.JButton();
        jurusan = new javax.swing.JTextField();
        cukuran = new javax.swing.JComboBox<>();
        harga = new javax.swing.JTextField();
        cjenis = new javax.swing.JComboBox<>();
        tjenis = new javax.swing.JTextField();
        tukuran = new javax.swing.JTextField();
        bhitung = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id_tu = new javax.swing.JTextField();
        nama_pengurus = new javax.swing.JTextField();
        cari_id_tu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelseragam = new javax.swing.JTable();
        bcari = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        bbersih = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        jScrollPane2.setViewportView(jTextPane1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("PEMBAYARAN SERAGAM");

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("NIS SISWA");

        jLabel3.setText("NAMA SISWA");

        jLabel4.setText("JURUSAN");

        jLabel5.setText("JENIS SERAGAM");

        jLabel6.setText("UKURAN");

        jLabel7.setText("HARGA");

        cari_nis_siswa.setText("CARI");
        cari_nis_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_nis_siswaActionPerformed(evt);
            }
        });

        cukuran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "XXL", "XL", "L", "M", "S" }));
        cukuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cukuranActionPerformed(evt);
            }
        });

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });

        cjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "A", "B", "C", "D" }));
        cjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cjenisActionPerformed(evt);
            }
        });

        tjenis.setText("*");

        tukuran.setText("*");

        bhitung.setText("Hitung");
        bhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66))
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bhitung))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nis_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(cari_nis_siswa))
                    .addComponent(nama_siswa)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tjenis)
                            .addComponent(tukuran)))
                    .addComponent(jurusan))
                .addGap(132, 132, 132))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nis_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari_nis_siswa))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nama_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhitung))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        jLabel8.setText("NAMA PENGURUS");

        jLabel10.setText("ID TU");

        cari_id_tu.setText("CARI");
        cari_id_tu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_id_tuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(id_tu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cari_id_tu))
                    .addComponent(nama_pengurus))
                .addGap(130, 130, 130))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(id_tu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari_id_tu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nama_pengurus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        tabelseragam.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelseragam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelseragamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelseragam);

        bcari.setText("CARI");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcari)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bbersih.setText("BERSIHKAN");
        bbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersihActionPerformed(evt);
            }
        });

        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bubah.setText("UBAH");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bkeluar.setText("KELUAR");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bsimpan)
                                .addGap(18, 18, 18)
                                .addComponent(bubah)
                                .addGap(18, 18, 18)
                                .addComponent(bhapus)
                                .addGap(18, 18, 18)
                                .addComponent(bbersih)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bkeluar)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bbersih)
                    .addComponent(bhapus)
                    .addComponent(bubah)
                    .addComponent(bsimpan)
                    .addComponent(bkeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cari_id_tuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_id_tuActionPerformed
        // TODO add your handling code here:
        String sql = "select * from tabel_tu where id_tu  = '"+id_tu.getText()+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String mp = hasil.getString("nama_tu");
                nama_pengurus.setText(mp);
                nama_pengurus.setEnabled(false);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_cari_id_tuActionPerformed

    private void cari_nis_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_nis_siswaActionPerformed
        // TODO add your handling code here:
        String sql = "select * from tabelsiswa where nis = '"+nis_siswa.getText()+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String ns = hasil.getString("nama_siswa");
                nama_siswa.setText(ns);
                nama_siswa.setEnabled(false);
                
                String jrs = hasil.getString("jurusan_siswa");
                jurusan.setText(jrs);
                jurusan.setEnabled(false);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_cari_nis_siswaActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        String sql = "insert into transaksi_pembayaran_seragam values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama_pengurus.getText());
            stat.setString(2, nis_siswa.getText());
            stat.setString(3, nama_siswa.getText());
            stat.setString(4, jurusan.getText());
            stat.setString(5, cjenis.getSelectedItem().toString());
            stat.setString(6, cukuran.getSelectedItem().toString());
            stat.setString(7, harga.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            id_tu.requestFocus();
            datatable();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE transaksi_pembayaran_seragam SET nama_tu=?, nama_siswa=?, uas=?, kelas=?, jurusan=?, ukuran=?, harga=? WHERE nis_siswa=?";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, nama_pengurus.getText());
            stat.setString(2, nis_siswa.getText());
            stat.setString(3, nama_siswa.getText());
            stat.setString(4, jurusan.getText());
            stat.setString(5, cjenis.getSelectedItem().toString());
            stat.setString(6, cukuran.getSelectedItem().toString());
            stat.setString(7, harga.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            kosong();
            id_tu.requestFocus();
            datatable();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_bubahActionPerformed

    private void tabelseragamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelseragamMouseClicked
        // TODO add your handling code here:
        int bar = tabelseragam.getSelectedRow();
        String a = tabmode.getValueAt (bar, 0).toString();
        String b = tabmode.getValueAt (bar, 1).toString();
        String c = tabmode.getValueAt (bar, 2).toString();
        String d = tabmode.getValueAt (bar, 3).toString();
        String e = tabmode.getValueAt (bar, 4).toString();
        String f = tabmode.getValueAt (bar, 5).toString();
        String g = tabmode.getValueAt (bar, 6).toString();
        
        nama_pengurus.setText(a);
        nis_siswa.setText(b);
        nama_siswa.setText(c);
        jurusan.setText(d);
        cjenis.setSelectedItem(e);
        cukuran.setSelectedItem(f);
        harga.setText(g);
    }//GEN-LAST:event_tabelseragamMouseClicked

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from transaksi_pembayaran_seragam where nis_siswa='"+nis_siswa.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                id_tu.requestFocus();
                datatable();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
    }//GEN-LAST:event_bbersihActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        Object [] Baris = {"PENGURUS","NIS SISWA","NAMA","JURUSAN","JENIS","UKURAN","HARGA"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelseragam.setModel(tabmode);
        String sql = "Select * from transaksi_pembayaran_seragam where nis_siswa='"+tcari.getText()+"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a = hasil.getString("nama_tu");
                String b = hasil.getString("nis_siswa");
                String c = hasil.getString("nama_siswa");
                String d = hasil.getString("jurusan");
                String e = hasil.getString("jenis_seragam");
                String f = hasil.getString("ukuran");
                String g = hasil.getString("harga");
            
                String[] data={a,b,c,d,e,f,g};
                tabmode.addRow(data);
            }
        }catch (Exception e){}
    }//GEN-LAST:event_bcariActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void cjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cjenisActionPerformed
        // TODO add your handling code here:
        String pilih, jenis;
        double harga;
        jenis = String.valueOf(cjenis.getSelectedItem());
        
        if (jenis.equals ("A")) {
            harga = 100000;
        }else if (jenis.equals ("B")){
            harga = 75000;
        }else if (jenis.equals ("C")){
            harga = 85000;
        }else if (jenis.equals ("D")){
            harga = 50000;
        }else {
            harga = 0;
        }
        tjenis.setText (""+harga);
    }//GEN-LAST:event_cjenisActionPerformed

    private void cukuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cukuranActionPerformed
        // TODO add your handling code here:
        String ukuran;
        double harga;
        ukuran = String.valueOf(cukuran.getSelectedItem());
        
        if (ukuran.equals ("XXL")) {
            harga = 20000;
        }else if (ukuran.equals ("XL")){
            harga = 10000;
        }else if (ukuran.equals ("L")){
            harga = 0;
        }else if (ukuran.equals ("M")){
            harga = 0;
        }else if (ukuran.equals ("S")){
            harga = 0;
        }else {
            harga = 0;
        }
        tukuran.setText (""+harga);
        
    }//GEN-LAST:event_cukuranActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void bhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhitungActionPerformed
        // TODO add your handling code here:
        double hargajenis, hargaukuran, totalharga;
        
        hargajenis = Double.parseDouble(this.tjenis.getText());
        hargaukuran = Double.parseDouble(this.tukuran.getText());
        
        totalharga = (hargajenis + hargaukuran);
        harga.setText(""+totalharga);
    }//GEN-LAST:event_bhitungActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiSeragam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiSeragam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiSeragam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiSeragam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiSeragam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersih;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bhitung;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JButton cari_id_tu;
    private javax.swing.JButton cari_nis_siswa;
    private javax.swing.JComboBox<String> cjenis;
    private javax.swing.JComboBox<String> cukuran;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField id_tu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField jurusan;
    private javax.swing.JTextField nama_pengurus;
    private javax.swing.JTextField nama_siswa;
    private javax.swing.JTextField nis_siswa;
    private javax.swing.JTable tabelseragam;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tjenis;
    private javax.swing.JTextField tukuran;
    // End of variables declaration//GEN-END:variables
}
