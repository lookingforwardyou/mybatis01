package com.pojo;

public class Persion {
    private int pId;
    private String pName;
    private String pPwd;
    private String pTel;
    private String pAddress;
    private String pCheck;
    private String pPhoto;
    private String pAddtime;

    public Persion() {
    }

    public Persion(int pId, String pName, String pPwd, String pTel, String pAddress, String pCheck, String pPhoto, String pAddtime) {
        this.pId = pId;
        this.pName = pName;
        this.pPwd = pPwd;
        this.pTel = pTel;
        this.pAddress = pAddress;
        this.pCheck = pCheck;
        this.pPhoto = pPhoto;
        this.pAddtime = pAddtime;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPwd() {
        return pPwd;
    }

    public void setpPwd(String pPwd) {
        this.pPwd = pPwd;
    }

    public String getpTel() {
        return pTel;
    }

    public void setpTel(String pTel) {
        this.pTel = pTel;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getpCheck() {
        return pCheck;
    }

    public void setpCheck(String pCheck) {
        this.pCheck = pCheck;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public String getpAddtime() {
        return pAddtime;
    }

    public void setpAddtime(String pAddtime) {
        this.pAddtime = pAddtime;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPwd='" + pPwd + '\'' +
                ", pTel='" + pTel + '\'' +
                ", pAddress='" + pAddress + '\'' +
                ", pCheck='" + pCheck + '\'' +
                ", pPhoto='" + pPhoto + '\'' +
                ", pAddtime='" + pAddtime + '\'' +
                '}';
    }
}
