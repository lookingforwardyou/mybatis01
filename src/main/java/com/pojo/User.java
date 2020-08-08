package com.pojo;

public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userTel;
    private String userQx;

    public User() {
    }

    public User(int userId, String userName, String userPwd, String userTel, String userQx) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userTel = userTel;
        this.userQx = userQx;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserQx() {
        return userQx;
    }

    public void setUserQx(String userQx) {
        this.userQx = userQx;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userQx='" + userQx + '\'' +
                '}';
    }
}
