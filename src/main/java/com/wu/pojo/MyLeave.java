package com.wu.pojo;

import java.io.Serializable;
import java.util.Date;

public class MyLeave  implements Serializable {

    private int leaveId;
    private int lattendanceId;
    private int lstaffId;
    private String leaveType;
    private Date leaveStart;
    private Date leaveEnd;
    private String leaveReason;
    private Date leaveUpdate;
    private Date leaveCreate;

    //多个非正常出勤对应一个职员，多对一
    private Staff staff;

    private Branch branch;

    public MyLeave() {
    }

    public MyLeave(int leaveId, int lattendanceId, int lstaffId, String leaveType, Date leaveStart, Date leaveEnd, String leaveReason, Date leaveUpdate, Date leaveCreate, Staff staff, Branch branch) {
        this.leaveId = leaveId;
        this.lattendanceId = lattendanceId;
        this.lstaffId = lstaffId;
        this.leaveType = leaveType;
        this.leaveStart = leaveStart;
        this.leaveEnd = leaveEnd;
        this.leaveReason = leaveReason;
        this.leaveUpdate = leaveUpdate;
        this.leaveCreate = leaveCreate;
        this.staff = staff;
        this.branch = branch;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getLattendanceId() {
        return lattendanceId;
    }

    public void setLattendanceId(int lattendanceId) {
        this.lattendanceId = lattendanceId;
    }

    public int getLstaffId() {
        return lstaffId;
    }

    public void setLstaffId(int lstaffId) {
        this.lstaffId = lstaffId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getLeaveStart() {
        return leaveStart;
    }

    public void setLeaveStart(Date leaveStart) {
        this.leaveStart = leaveStart;
    }

    public Date getLeaveEnd() {
        return leaveEnd;
    }

    public void setLeaveEnd(Date leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public Date getLeaveUpdate() {
        return leaveUpdate;
    }

    public void setLeaveUpdate(Date leaveUpdate) {
        this.leaveUpdate = leaveUpdate;
    }

    public Date getLeaveCreate() {
        return leaveCreate;
    }

    public void setLeaveCreate(Date leaveCreate) {
        this.leaveCreate = leaveCreate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "MyLeave{" +
                "leaveId=" + leaveId +
                ", lattendanceId=" + lattendanceId +
                ", lstaffId=" + lstaffId +
                ", leaveType='" + leaveType + '\'' +
                ", leaveStart=" + leaveStart +
                ", leaveEnd=" + leaveEnd +
                ", leaveReason='" + leaveReason + '\'' +
                ", leaveUpdate=" + leaveUpdate +
                ", leaveCreate=" + leaveCreate +
                ", staff=" + staff +
                ", branch=" + branch +
                '}';
    }
}
