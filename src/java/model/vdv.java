/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trhuy
 */
public class vdv {
    String hoten;
    int mavdv;
    int sohc;
    int sonamtd;
    double tienthuong;

    public double getTienthuong() {
        return tienthuong=sohc*5000000+sonamtd*400000;
    }

    public void setTienthuong(double tienthuong) {
        this.tienthuong = tienthuong;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMavdv() {
        return mavdv;
    }

    public void setMavdv(int mavdv) {
        this.mavdv = mavdv;
    }

    public int getSohc() {
        return sohc;
    }

    public void setSohc(int sohc) {
        this.sohc = sohc;
    }

    public int getSonamtd() {
        return sonamtd;
    }

    public void setSonamtd(int sonamtd) {
        this.sonamtd = sonamtd;
    }

    public vdv(int mavdv, String hoten, int sohc, int sonamtd) {
        this.hoten = hoten;
        this.mavdv = mavdv;
        this.sohc = sohc;
        this.sonamtd = sonamtd;
    }

    public vdv() {
    }
}
