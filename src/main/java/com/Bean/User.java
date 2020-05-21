package com.Bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户", description="用户实体信息")
public class User implements Serializable {
    @ApiModelProperty(value="用户编号", dataType = "java.lang.Long")
    private Long uId;
    @ApiModelProperty(value="用户邮件", dataType = "java.lang.String")
    private String uEmai;
    @ApiModelProperty(value="用户密码", dataType = "java.lang.String")
    private String uPwd;
    @ApiModelProperty(value="用户名称", dataType = "java.lang.String")
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
