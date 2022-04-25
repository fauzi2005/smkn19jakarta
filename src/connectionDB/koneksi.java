/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author training86
 */
public class koneksi {
    private Connection koneksi;
    private Statement stm;
            
    public Connection connect(){
        try {
            String url ="jdbc:mysql://localhost/smkn19jakarta";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(url,user,pass);
            stm = koneksi.createStatement();
            System.out.println("Koneksi Berhasil;");
        } catch (Exception e) {
            System.err.println("Koneksi Gagal" +e.getMessage());
        }
        return koneksi;
    }
}
