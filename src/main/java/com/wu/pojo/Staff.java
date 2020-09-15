package com.wu.pojo;


import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable {

    private int staffId;
    private String staffName;
    private String userName;
    private String password;
    private String staffTitle;
    private String staffPhone;
    private int staffManager;
    private int staffHr;
    private int sbranchId;
    private Date staffUpdate;
    private Date staffCreate;

    public Staff() {
    }

    public Staff(int staffId, String staffName, String userName, String password, String staffTitle, String staffPhone, int staffManager, int staffHr, int sbranchId, Date staffUpdate, Date staffCreate) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.userName = userName;
        this.password = password;
        this.staffTitle = staffTitle;
        this.staffPhone = staffPhone;
        this.staffManager = staffManager;
        this.staffHr = staffHr;
        this.sbranchId = sbranchId;
        this.staffUpdate = staffUpdate;
        this.staffCreate = staffCreate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public int getStaffManager() {
        return staffManager;
    }

    public void setStaffManager(int staffManager) {
        this.staffManager = staffManager;
    }

    public int getStaffHr() {
        return staffHr;
    }

    public void setStaffHr(int staffHr) {
        this.staffHr = staffHr;
    }

    public int getSbranchId() {
        return sbranchId;
    }

    public void setSbranchId(int sbranchId) {
        this.sbranchId = sbranchId;
    }

    public Date getStaffUpdate() {
        return staffUpdate;
    }

    public void setStaffUpdate(Date staffUpdate) {
        this.staffUpdate = staffUpdate;
    }

    public Date getStaffCreate() {
        return staffCreate;
    }

    public void setStaffCreate(Date staffCreate) {
        this.staffCreate = staffCreate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", staffTitle='" + staffTitle + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffManager=" + staffManager +
                ", staffHr=" + staffHr +
                ", sbranchId=" + sbranchId +
                ", staffUpdate=" + staffUpdate +
                ", staffCreate=" + staffCreate +
                '}';
    }
}
