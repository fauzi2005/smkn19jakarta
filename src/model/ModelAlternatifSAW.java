/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connectionDB.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fauzi
 */
public class ModelAlternatifSAW {
    int id;
    String nis;
    String nama;
    Double c1d;
    Double c2d;
    Double c3d;
    Double c4d;
    Double sum;

    public ModelAlternatifSAW(){

    }

    public ModelAlternatifSAW(int ids, String niss, String namas,Double ca1, Double ca2, Double ca3, Double ca4, Double sums) {
        id = ids;
        nis = niss;
        nama = namas;
        c1d = ca1;
        c2d = ca2;
        c3d = ca3;
        c4d = ca4;
        sum = sums;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getC1() {
        return c1d;
    }

    public void setC1(Double c1) {
        this.c1d = c1;
    }
    
    public Double getC2() {
        return c2d;
    }

    public void setC2(Double c2) {
        this.c2d = c2;
    }
    
    public Double getC3() {
        return c3d;
    }

    public void setC3(Double c3) {
        this.c3d = c3;
    }
    
    public Double getC4() {
        return c4d;
    }

    public void setC4(Double c4) {
        this.c4d = c4;
    }
    
    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
    
    static Connection conn = new koneksi().connect();
    private Statement statement;

    public void insertData() {
        String query = "insert into tb_alternatif1 values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, null);
            stat.setString(2, "1010");
            stat.setString(3, "NAMA");
            stat.setString(4, String.valueOf(c1d));
            stat.setString(5, String.valueOf(c1d));
            stat.setString(6, String.valueOf(c1d));
            stat.setString(7, String.valueOf(c1d));

            int rowsAffected = stat.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertDataSAW() {
        String query = "INSERT INTO tb_saw values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, String.valueOf(id));
            stat.setString(2, nis);
            stat.setString(3, nama);
            stat.setString(4, String.valueOf(c1d));
            stat.setString(5, String.valueOf(c2d));
            stat.setString(6, String.valueOf(c3d));
            stat.setString(7, String.valueOf(c4d));
            stat.setString(8, String.valueOf(sum));

            int rowsAffected = stat.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllRowSAW() {
        String query = "DELETE FROM tb_saw";

        try {
            PreparedStatement stat = conn.prepareStatement(query);

            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
