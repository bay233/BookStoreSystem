package com.Bean;


import java.io.Serializable;

public class User implements Serializable {
    private Long uId;
    private String uEmai;
    private String uPwd;
    private String uName;

    public User() { }

    public User(String uEmai, String uPwd, String uName) {
        this.uEmai = uEmai;
        this.uPwd = uPwd;
        this.uName = uName;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public void setuEmai(String uEmai) {
        this.uEmai = uEmai;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Long getuId() {
        return uId;
    }

    public String getuEmai() {
        return uEmai;
    }

    public String getuPwd() {
        return uPwd;
    }

    public String getuName() {
        return uName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uEmai='" + uEmai + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uName='" + uName + '\'' +
                '}';
    }
}