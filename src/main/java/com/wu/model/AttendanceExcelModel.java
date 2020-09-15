package com.wu.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class AttendanceExcelModel extends BaseRowModel {

    @ExcelProperty(value = "考勤记录编码", index = 0)
    private String attendanceId;
    @ExcelProperty(value = "工号", index = 1)
    private String astaffId;
    @ExcelProperty(value = "上午打卡时间", index = 2)
    private String attendanceStart;
    @ExcelProperty(value = "下午打卡时间", index = 3)
    private String attendanceEnd;

    public AttendanceExcelModel() {
    }

    public AttendanceExcelModel(String attendanceId, String astaffId, String attendanceStart, String attendanceEnd) {
        this.attendanceId = attendanceId;
        this.astaffId = astaffId;
        this.attendanceStart = attendanceStart;
        this.attendanceEnd = attendanceEnd;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getAstaffId() {
        return astaffId;
    }

    public void setAstaffId(String astaffId) {
        this.astaffId = astaffId;
    }

    public String getAttendanceStart() {
        return attendanceStart;
    }

    public void setAttendanceStart(String attendanceStart) {
        this.attendanceStart = attendanceStart;
    }

    public String getAttendanceEnd() {
        return attendanceEnd;
    }

    public void setAttendanceEnd(String attendanceEnd) {
        this.attendanceEnd = attendanceEnd;
    }

    @Override
    public String toString() {
        return "AttendanceExcelModel{" +
                "attendanceId='" + attendanceId + '\'' +
                ", astaffId='" + astaffId + '\'' +
                ", attendanceStart='" + attendanceStart + '\'' +
                ", attendanceEnd='" + attendanceEnd + '\'' +
                '}';
    }
}