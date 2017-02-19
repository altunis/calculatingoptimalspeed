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
public class viraj {
    int virajid;
    String virajad;
    double surtunmekatsayisi;
    double egim;
    double yaricap;

    public viraj(int virajid,String virajad, double surtunmekatsayisi, double egim, double yaricap) {
        this.virajad = virajad;
        this.surtunmekatsayisi = surtunmekatsayisi;
        this.egim = egim;
        this.yaricap = yaricap;
        this.virajid=virajid;
    }

    public viraj() {
    }

    public int getVirajid() {
        return virajid;
    }

    public void setVirajid(int virajid) {
        this.virajid = virajid;
    }

    public String getVirajad() {
        return virajad;
    }

    public void setVirajad(String virajad) {
        this.virajad = virajad;
    }

    public double getSurtunmekatsayisi() {
        return surtunmekatsayisi;
    }

    public void setSurtunmekatsayisi(double surtunmekatsayisi) {
        this.surtunmekatsayisi = surtunmekatsayisi;
    }

    public double getEgim() {
        return egim;
    }

    public void setEgim(double egim) {
        this.egim = egim;
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }
    
}
