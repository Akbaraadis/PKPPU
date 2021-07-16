package com.project.pkppu.admin.skmk;

public class Skmk {

    public String no_req_skmk;
    public String thn_meninggal;
    public String file_makam;
    public String file_s_materai;
    public String file_rtrw;
    public String ktp_pengurus;
    public String ktp_almarhum;
    public String kk_almarhum;
    public String status;
    public String nik;

    public Skmk() {

    }

    public Skmk(String no_req_skpk, String thn_meninggal, String file_makam, String file_s_materai, String file_rtrw, String ktp_pengurus, String ktp_almarhum, String kk_almarhum, String status, String nik) {
        this.no_req_skmk = no_req_skpk;
        this.thn_meninggal = thn_meninggal;
        this.file_makam = file_makam;
        this.file_s_materai = file_s_materai;
        this.file_rtrw = file_rtrw;
        this.ktp_pengurus = ktp_pengurus;
        this.ktp_almarhum = ktp_almarhum;
        this.kk_almarhum = kk_almarhum;
        this.status = status;
        this.nik = nik;
    }

    public String getNo_req_skmk() {
        return no_req_skmk;
    }

    public void setNo_req_skmk(String no_req_skmk) {
        this.no_req_skmk = no_req_skmk;
    }

    public String getThn_meninggal() {
        return thn_meninggal;
    }

    public void setThn_meninggal(String thn_meninggal) {
        this.thn_meninggal = thn_meninggal;
    }

    public String getFile_makam(){
        return file_makam;
    }

    public void setFile_makam(String makam){
        this.file_makam = makam;
    }

    public String getFile_s_materai(){
        return file_s_materai;
    }

    public void setFile_s_materai(String materai){
        this.file_s_materai = materai;
    }

    public String getFile_rtrw(){
        return file_rtrw;
    }

    public void setFile_rtrw(String rtrw){
        this.file_rtrw = rtrw;
    }

    public String getKtp_pengurus(){
        return ktp_pengurus;
    }

    public void setKtp_pengurus(String rtrw){
        this.ktp_pengurus = rtrw;
    }

    public String getKtp_almarhum(){
        return ktp_almarhum;
    }

    public void setKtp_almarhum(String rtrw){
        this.ktp_almarhum = rtrw;
    }

    public String getKk_almarhum(){
        return kk_almarhum;
    }

    public void setKk_almarhum(String rtrw){
        this.kk_almarhum = rtrw;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String rtrw){
        this.status = rtrw;
    }

    public String getNik(){
        return nik;
    }

    public void setNik(String rtrw){
        this.nik = rtrw;
    }
}


//public class Skmk {
//
//    public String no_req_skmk;
//    public String nik;
//    public String status;
//
//    public Skmk() {
//
//    }
//
//    public Skmk(String no_req_skpk, String nik, String status) {
//        this.no_req_skmk = no_req_skpk;
//        this.nik = nik;
//        this.status = status;
//    }
//
//    public String getNo_req_skmk() {
//        return no_req_skmk;
//    }
//
//    public void setNo_req_skmk(String no_req_skmk) {
//        this.no_req_skmk = no_req_skmk;
//    }
//
//    public String getnik() {
//        return nik;
//    }
//
//    public void setnik(String nik) {
//        this.nik = nik;
//    }
//
//    public String getstatus() {
//        return status;
//    }
//
//    public void setstatus(String status) {
//        this.status = status;
//    }
//
//}