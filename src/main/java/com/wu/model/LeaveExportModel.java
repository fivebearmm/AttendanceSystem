package com.wu.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class LeaveExportModel extends BaseRowModel {


    @ExcelProperty(value = "工作单位",index = 0)
    private String branchName;
    @ExcelProperty(value = "姓名",index = 1)
    private String staffName;
    @ExcelProperty(value = "日期",index = 3)
    private String leaveStart;
    @ExcelProperty(value = "非正常出勤类型",index = 4)
    private String leaveType;

    public LeaveExportModel() {
    }

    public LeaveExportModel(String branchName, String staffName, String leaveStart, String leaveType) {
        this.branchName = branchName;
        this.staffName = staffName;
        this.leaveStart = leaveStart;
        this.leaveType = leaveType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getLeaveStart() {
        return leaveStart;
    }

    public void setLeaveStart(String leaveStart) {
        this.leaveStart = leaveStart;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    @Override
    public String toString() {
        return "LeaveExportModel{" +
                "branchName='" + branchName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", leaveStart='" + leaveStart + '\'' +
                ", leaveType='" + leaveType + '\'' +
                '}';
    }
}
