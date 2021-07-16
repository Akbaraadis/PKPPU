package com.project.pkppu.admin.skpk;

public class Skpk {

    public String no_req_skpk;
    public String kk_alm;
    public String ktp_alm;
    public String sk_rtrw;
    public String nik;
    public String status;

    public Skpk() {

    }

    public Skpk(String no_req_skpk, String kk_alm, String ktp_alm, String sk_rtrw, String nik, String status) {
        this.no_req_skpk = no_req_skpk;
        this.kk_alm = kk_alm;
        this.ktp_alm = ktp_alm;
        this.sk_rtrw = sk_rtrw;
        this.nik = nik;
        this.status = status;
    }

    public String getNo_req_skpk() {
        return no_req_skpk;
    }

    public void setNo_req_skpk(String no_req_skpk) {
        this.no_req_skpk = no_req_skpk;
    }

    public String getKk_alm() {
        return kk_alm;
    }

    public void setKk_alm(String kk_alm) {
        this.kk_alm = kk_alm;
    }

    public String getKtp_alm() {
        return ktp_alm;
    }

    public void setKtp_alm(String ktp_alm) {
        this.ktp_alm = ktp_alm;
    }

    public String getSk_rtrw() {
        return sk_rtrw;
    }

    public void setSk_rtrw(String sk_rtrw) {
        this.sk_rtrw = sk_rtrw;
    }

    public String getnik() {
        return nik;
    }

    public void setnik(String nik) {
        this.nik = nik;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

}
