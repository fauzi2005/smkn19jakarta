/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import connectionDB.koneksi;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelAlternatifSAW;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class NewHasil extends javax.swing.JFrame {

    /**
     * Creates new form NewHasil
     */
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private Statement statement;
    
    private final DecimalFormat decimalFormat = new DecimalFormat("#.###");
    private final double[] bobot;
    private final List<ModelAlternatifSAW> model = new ArrayList<>();
    private final List<ModelAlternatifSAW> modelForSAW = new ArrayList<>();
    private final List<ModelAlternatifSAW> modelSAWFinal = new ArrayList<>();
    private int buttonSawClicked = 0;
    
    public NewHasil() {
        this.bobot = new double[]{0.4, 0.3, 0.2, 0.1};
        
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        initComponents();
        datatable1();
        initSetTitleTableHasil();
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent (this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    protected void insertSAW(){
        ModelAlternatifSAW[] modelArray = new ModelAlternatifSAW[model.size()];
        model.toArray(modelArray);
        
        Double[][] matrix = new Double[modelArray.length][4];

        for (int i = 0; i < modelArray.length; i++) {
            matrix[i][0] = modelArray[i].getC1() * bobot[0];
            matrix[i][1] = modelArray[i].getC2() * bobot[1];
            matrix[i][2] = modelArray[i].getC3() * bobot[2];
            matrix[i][3] = modelArray[i].getC4() * bobot[3];
        }

        // Printing the matrix
        for (int i = 0; i < matrix.length; i++) {
            ModelAlternatifSAW models = new ModelAlternatifSAW();
            Double sums = 0.00;
            models.setId(modelForSAW.get(i).getId());
            models.setNis(modelForSAW.get(i).getNis());
            models.setNama(modelForSAW.get(i).getNama());
            
            for (int j = 0; j < matrix[i].length; j++) {
                sums += matrix[i][j];
                
                switch (j) {
                    case 0:
                        models.setC1(Double.parseDouble(decimalFormat.format(matrix[i][j])));
                        break;
                    case 1:
                        models.setC2(Double.parseDouble(decimalFormat.format(matrix[i][j])));
                        break;
                    case 2: 
                        models.setC3(Double.parseDouble(decimalFormat.format(matrix[i][j])));
                        break;
                    case 3:
                        models.setC4(Double.parseDouble(decimalFormat.format(matrix[i][j])));
                        break;
                    default:
                        break;
                }
                System.out.print(decimalFormat.format(matrix[i][j]) + " ");
            }
            models.setSum(Double.parseDouble(decimalFormat.format(sums)));
            modelSAWFinal.add(models);
            System.out.println("  " + decimalFormat.format(sums));
        }
        
        ModelAlternatifSAW.deleteAllRowSAW();
        
        for(int i=0; i<modelSAWFinal.size(); i++){
            ModelAlternatifSAW insertTableSAW = new ModelAlternatifSAW();
            insertTableSAW.setId(modelSAWFinal.get(i).getId());
            insertTableSAW.setNis(modelSAWFinal.get(i).getNis());
            insertTableSAW.setNama(modelSAWFinal.get(i).getNama());
            insertTableSAW.setC1(modelSAWFinal.get(i).getC1());
            insertTableSAW.setC2(modelSAWFinal.get(i).getC2());
            insertTableSAW.setC3(modelSAWFinal.get(i).getC3());
            insertTableSAW.setC4(modelSAWFinal.get(i).getC4());
            insertTableSAW.setSum(modelSAWFinal.get(i).getSum());
            
            insertTableSAW.insertDataSAW();
        }
    }
    
    protected void datatable1(){
    Object [] Baris = {"NO","NIS","NAMA","C1","C2","C3","C4"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelnormalisasi.setModel(tabmode);
    try {
    String sql = "Select * from tb_alternatif2";
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        
     
        java.sql.Statement stat1 = conn.createStatement();
        ResultSet hasil1 = stat1.executeQuery(sql);
        
        List<Double> c1Array = new ArrayList<>();
        List<Double> c2Array = new ArrayList<>();
        List<Double> c3Array = new ArrayList<>();
        List<Double> c4Array = new ArrayList<>();
        
        while (hasil1.next()){
            c1Array.add(hasil1.getDouble("c1"));
            c2Array.add(hasil1.getDouble("c2"));
            c3Array.add(hasil1.getDouble("c3"));
            c4Array.add(hasil1.getDouble("c4"));
        }
        
        Double c1Max = Collections.max(c1Array);
        Double c2Max = Collections.max(c2Array);
        Double c3Max = Collections.max(c3Array);
        Double c4Max = Collections.max(c4Array);
        
        double[][] mat = null;
                
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("nis");
            String c = hasil.getString("nama");
            Double d = hasil.getDouble("c1") / c1Max;
            Double e = hasil.getDouble("c2") / c2Max;
            Double f = hasil.getDouble("c3") / c3Max;
            Double g = hasil.getDouble("c4") / c4Max;
            
            ModelAlternatifSAW model1 = new ModelAlternatifSAW();
            model1.setC1(Double.parseDouble(decimalFormat.format(d)));
            model1.setC2(Double.parseDouble(decimalFormat.format(e)));
            model1.setC3(Double.parseDouble(decimalFormat.format(f)));
            model1.setC4(Double.parseDouble(decimalFormat.format(g)));
            
            model.add(model1);
            
            ModelAlternatifSAW models = new ModelAlternatifSAW();
            models.setId(Integer.parseInt(a));
            models.setNis(b);
            models.setNama(c);
            
            modelForSAW.add(models);
            
            String[] data = {
                a,
                b,
                c,
                String.valueOf(decimalFormat.format(d)),
                String.valueOf(decimalFormat.format(e)),
                String.valueOf(decimalFormat.format(f)),
                String.valueOf(decimalFormat.format(g)),
            };
            tabmode.addRow(data);
        }
    }catch (SQLException e){
        }
    }
    
    protected void datatable2(){
    Object [] Baris = {"NO","NIS","NAMA","C1","C2","C3","C4","SUM","RANKING"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelhasil.setModel(tabmode);
    try {
    String sql = "SELECT *, RANK() OVER (ORDER BY sum DESC) AS ranking FROM tb_saw";
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("nis");
            String c = hasil.getString("nama");
            String d = hasil.getString("c1");
            String e = hasil.getString("c2");
            String f = hasil.getString("c3");
            String g = hasil.getString("c4");
            String h = hasil.getString("sum");
            String i = hasil.getString("ranking");
            String[] data={a,b,c,d,e,f,g,h,i};
            tabmode.addRow(data);
        }
    }catch (SQLException e){
        }
    } 
    
    protected void initSetTitleTableHasil() {
        Object [] Baris = {"NO","NIS","NAMA","C1","C2","C3","C4","SUM","RANKING"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelhasil.setModel(tabmode);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelhasil = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelnormalisasi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnHasil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        btnClose.setBackground(new java.awt.Color(204, 102, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_4.png"))); // NOI18N
        btnClose.setContentAreaFilled(false);
        btnClose.setOpaque(true);
        btnClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_5.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("                 DATA HASIL PERHITUNGAN DAN HASIL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabelhasil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelhasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tabelhasil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelhasil.setRowHeight(30);
        tabelhasil.setRowMargin(2);
        tabelhasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelhasilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelhasil);

        tabelnormalisasi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelnormalisasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tabelnormalisasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelnormalisasi.setRowHeight(30);
        tabelnormalisasi.setRowMargin(2);
        tabelnormalisasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelnormalisasiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelnormalisasi);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PERHITUNGAN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("              HASIL");

        jButton1.setText("PROSES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnHasil.setBackground(new java.awt.Color(204, 204, 204));
        btnHasil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHasil.setText("CETAK HASIL");
        btnHasil.setContentAreaFilled(false);
        btnHasil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHasil.setOpaque(true);
        btnHasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHasilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHasilMouseExited(evt);
            }
        });
        btnHasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHasilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int xx, xy;
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        close();
        NewInputDataAlternatif nida = new NewInputDataAlternatif();
        nida.setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void tabelhasilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelhasilMouseClicked

    }//GEN-LAST:event_tabelhasilMouseClicked

    private void tabelnormalisasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelnormalisasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelnormalisasiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(buttonSawClicked == 0) {
            insertSAW();
            datatable2();
            buttonSawClicked++;
        } else {
            System.err.println("Tidak bisa menghitung lebih dari 1 kali");
            JOptionPane.showMessageDialog(null, "Tidak bisa menghitung kebih dari 1 kali");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHasilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHasilMouseEntered
        btnHasil.setBackground(new Color(0,0,204));
        btnHasil.setForeground(Color.white);
    }//GEN-LAST:event_btnHasilMouseEntered

    private void btnHasilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHasilMouseExited
        btnHasil.setBackground(new Color(204,204,204));
        btnHasil.setForeground(Color.black);
    }//GEN-LAST:event_btnHasilMouseExited

    private void btnHasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHasilActionPerformed
        try {
            String namaFile = "src/Report/reporthasil.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false); //coba
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btnHasilActionPerformed

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
            java.util.logging.Logger.getLogger(NewHasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewHasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewHasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewHasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewHasil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHasil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelhasil;
    private javax.swing.JTable tabelnormalisasi;
    // End of variables declaration//GEN-END:variables
}
