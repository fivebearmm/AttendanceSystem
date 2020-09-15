package com.wu.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class LeaveExcelModel extends BaseRowModel {

    @ExcelProperty(value = "考勤记录编码",index = 0)
    private String lattendanceId;
    @ExcelProperty(value = "工号",index = 1)
    private String lstaffId;
    @ExcelProperty(value = "非正常出勤类型",index = 2)
    private String leaveType;
    @ExcelProperty(value = "请假开始时间",index = 3)
    private String leaveStart;
    @ExcelProperty(value = "请假结束时间",index = 4)
    private String leaveEnd;
    @ExcelProperty(value = "请假原因",index = 5)
    private String leaveReason;

    public LeaveExcelModel() {
    }

    public LeaveExcelModel(String lattendanceId, String lstaffId, String leaveType, String leaveStart, String leaveEnd, String leaveReason) {
        this.lattendanceId = lattendanceId;
        this.lstaffId = lstaffId;
        this.leaveType = leaveType;
        this.leaveStart = leaveStart;
        this.leaveEnd = leaveEnd;
        this.leaveReason = leaveReason;
    }

    public String getLattendanceId() {
        return lattendanceId;
    }

    public void setLattendanceId(String lattendanceId) {
        this.lattendanceId = lattendanceId;
    }

    public String getLstaffId() {
        return lstaffId;
    }

    public void setLstaffId(String lstaffId) {
        this.lstaffId = lstaffId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveStart() {
        return leaveStart;
    }

    public void setLeaveStart(String leaveStart) {
        this.leaveStart = leaveStart;
    }

    public String getLeaveEnd() {
        return leaveEnd;
    }

    public void setLeaveEnd(String leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    @Override
    public String toString() {
        return "LeaveExcelModel{" +
                "lattendanceId='" + lattendanceId + '\'' +
                ", lstaffId='" + lstaffId + '\'' +
                ", leaveType='" + leaveType + '\'' +
                ", leaveStart='" + leaveStart + '\'' +
                ", leaveEnd='" + leaveEnd + '\'' +
                ", leaveReason='" + leaveReason + '\'' +
                '}';
    }
}
