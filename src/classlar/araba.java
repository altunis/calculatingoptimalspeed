/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classlar;

/**
 *
 * @author User
 */
public class araba {
    int arabaid;
    String marka;
    double uzunluk;
    double tekeruzunlugu;
    double arabagenisligi;

   
    public araba(int arabaid, String marka, double uzunluk, double tekeruzunlugu, double arabagenisligi) {
        this.arabaid=arabaid;
        this.marka = marka;
        this.uzunluk = uzunluk;
        this.tekeruzunlugu = tekeruzunlugu;
        this.arabagenisligi = arabagenisligi;
    }
    public araba() {
    }

    public int getArabaid() {
        return arabaid;
    }

    public void setArabaid(int arabaid) {
        this.arabaid = arabaid;
    }
    
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public double getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(double uzunluk) {
        this.uzunluk = uzunluk;
    }

    public double getTekeruzunlugu() {
        return tekeruzunlugu;
    }

    public void setTekeruzunlugu(double tekeruzunlugu) {
        this.tekeruzunlugu = tekeruzunlugu;
    }

    public double getArabagenisligi() {
        return arabagenisligi;
    }

    public void setArabagenisligi(double arabagenisligi) {
        this.arabagenisligi = arabagenisligi;
    }
}
