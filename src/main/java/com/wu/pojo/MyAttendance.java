package com.wu.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MyAttendance implements Serializable {

    private int attendanceId;
    private int astaffId;
    private Date attendanceStart;
    private Date attendanceEnd;
    private int attendanceType;
    private Date attendanceUpdate;
    private Date attendanceCreate;
    //一对多，一个出勤对应多个请假
    private List<MyLeave> leaves;
    //多对一
    private Staff staff;
    private Branch branch;

    public MyAttendance() {
    }

    public MyAttendance(int attendanceId, int astaffId, Date attendanceStart, Date attendanceEnd, int attendanceType, Date attendanceUpdate, Date attendanceCreate, List<MyLeave> leaves, Staff staff, Branch branch) {
        this.attendanceId = attendanceId;
        this.astaffId = astaffId;
        this.attendanceStart = attendanceStart;
        this.attendanceEnd = attendanceEnd;
        this.attendanceType = attendanceType;
        this.attendanceUpdate = attendanceUpdate;
        this.attendanceCreate = attendanceCreate;
        this.leaves = leaves;
        this.staff = staff;
        this.branch = branch;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getAstaffId() {
        return astaffId;
    }

    public void setAstaffId(int astaffId) {
        this.astaffId = astaffId;
    }

    public Date getAttendanceStart() {
        return attendanceStart;
    }

    public void setAttendanceStart(Date attendanceStart) {
        this.attendanceStart = attendanceStart;
    }

    public Date getAttendanceEnd() {
        return attendanceEnd;
    }

    public void setAttendanceEnd(Date attendanceEnd) {
        this.attendanceEnd = attendanceEnd;
    }

    public int getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(int attendanceType) {
        this.attendanceType = attendanceType;
    }

    public Date getAttendanceUpdate() {
        return attendanceUpdate;
    }

    public void setAttendanceUpdate(Date attendanceUpdate) {
        this.attendanceUpdate = attendanceUpdate;
    }

    public Date getAttendanceCreate() {
        return attendanceCreate;
    }

    public void setAttendanceCreate(Date attendanceCreate) {
        this.attendanceCreate = attendanceCreate;
    }

    public List<MyLeave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<MyLeave> leaves) {
        this.leaves = leaves;
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
        return "MyAttendance{" +
                "attendanceId=" + attendanceId +
                ", astaffId=" + astaffId +
                ", attendanceStart=" + attendanceStart +
                ", attendanceEnd=" + attendanceEnd +
                ", attendanceType=" + attendanceType +
                ", attendanceUpdate=" + attendanceUpdate +
                ", attendanceCreate=" + attendanceCreate +
                ", leaves=" + leaves +
                ", staff=" + staff +
                ", branch=" + branch +
                '}';
    }
}
