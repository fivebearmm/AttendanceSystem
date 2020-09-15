package com.wu.service;

import com.wu.pojo.MyAttendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AttendanceService {

    MyAttendance getAttendance(@Param("attendanceId") int attendanceId);

    List<MyAttendance> queryAttendanceByStaffId(@Param("staffId") int staffId,
                                             @Param("attendanceStart") Date attendanceStart,
                                             @Param("attendanceEnd") Date attendanceEnd);

    //查找指定员工们的出勤
    List<MyAttendance> queryAttendanceByStaffIds(Map map);

    int addAttendance(MyAttendance myAttendance);

}
