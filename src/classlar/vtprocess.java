/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classlar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class vtprocess {

    String url = "jdbc:mysql://localhost:3306/";
    String dbname = "viraj";
    String driver = "com.mysql.jdbc.Driver";
    String id = "root";
    String pass = "1234";
    public Connection conn;
    public PreparedStatement ps;
    public ResultSet rs;

    public void baglan() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbname, id, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ObservableList<araba> arabalaricek()
    {
            ObservableList<araba> or = FXCollections.observableArrayList();
        try {
            baglan();
            String sorgu = "select * from arabalar";
            ps = conn.prepareStatement(sorgu);
            rs=ps.executeQuery();
            while (rs.next()) {                
                or.add(new araba(rs.getInt("arabaid"),rs.getString("marka"), rs.getDouble("uzunluk"),rs.getDouble("tekeruzunlugu"), rs.getDouble("arabagenisligi")));
            }
            rs.close();
            ps.close();
            return or;
            
        } catch (Exception e) {
            return null;
        }
    }
     public ObservableList<viraj> virajlaricek()
    {
            ObservableList<viraj> or = FXCollections.observableArrayList();
        try {
            baglan();
            String sorgu = "select * from virajlar";
            ps = conn.prepareStatement(sorgu);
            rs=ps.executeQuery();
            while (rs.next()) {                
                or.add(new viraj(rs.getInt("virajid"),rs.getString("virajad"), rs.getDouble("surtunmekatsayisi"), rs.getDouble("egim"), rs.getDouble("yaricap")));
            }
            rs.close();
            ps.close();
            return or;
        } catch (Exception e) {
            return null;
        }
    }
     public void arabaEkle(String marka, double uzunluk,double tekerUzunlugu,double arabagenisligi)
     {
         try {
             baglan();
         String sorgu="insert into arabalar (marka,uzunluk,tekeruzunlugu,arabagenisligi) values (?,?,?,?)";
         ps=conn.prepareStatement(sorgu);
         ps.setString(1, marka);
         ps.setDouble(2, uzunluk);
         ps.setDouble(3, tekerUzunlugu);
         ps.setDouble(4, arabagenisligi);
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }         
     }
     public void arabaSil(String marka){
         try{
             baglan();
             String sorgu="delete from arabalar where marka = ?";
             ps=conn.prepareStatement(sorgu);
             ps.setString(1,marka);
             ps.executeUpdate();
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
     public void virajSil(String virajadi){
         try{
             baglan();
             String sorgu="delete from virajlar where virajad= ?";
             ps=conn.prepareStatement(sorgu);
             ps.setString(1,virajadi);
             ps.executeUpdate();
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
      public void virajEkle(String virajAd, double surtunmeKatsayisi,double egim,double yaricap)
     {
         try {
             baglan();
         String sorgu="insert into virajlar (virajad,surtunmekatsayisi,egim,yaricap) values (?,?,?,?)";
         ps=conn.prepareStatement(sorgu);
         ps.setString(1, virajAd);
         ps.setDouble(2, surtunmeKatsayisi);
         ps.setDouble(3, egim);
         ps.setDouble(4, yaricap);
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }         
     }
      public void arabaGuncelle(int arabaid, String marka, double uzunluk,double tekeruzunlugu,double arabagenisligi)
      {
          try {
              baglan();
              String sorgu = "update arabalar set marka=?, uzunluk=?, tekeruzunlugu=?, arabagenisligi=? where arabaid=?";
              ps=conn.prepareStatement(sorgu);
              ps.setString(1, marka);
              ps.setDouble(2, uzunluk);
              ps.setDouble(3, tekeruzunlugu);
              ps.setDouble(4, arabagenisligi);
              ps.setInt(5, arabaid);
              ps.executeUpdate();
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
          }
      }
}
