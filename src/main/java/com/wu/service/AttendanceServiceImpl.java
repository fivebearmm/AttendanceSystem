package com.wu.service;

import com.wu.mapper.AttendanceMapper;
import com.wu.pojo.MyAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceServiceImpl implements AttendanceService {


    @Autowired
    private AttendanceMapper attendanceMapper;


    @Override
    public MyAttendance getAttendance(int attendanceId) {

        MyAttendance attendance = attendanceMapper.getAttendance(attendanceId);
        return attendance;
    }

    @Override
    public List<MyAttendance> queryAttendanceByStaffId(int staffId, Date attendanceStart, Date attendanceEnd) {

        List<MyAttendance> myAttendances = attendanceMapper.queryAttendanceByStaffId(staffId, attendanceStart, attendanceEnd);
        return  myAttendances;

    }

    @Override
    public List<MyAttendance> queryAttendanceByStaffIds(Map map) {
        List<MyAttendance> myAttendances = attendanceMapper.queryAttendanceByStaffIds(map);
        return myAttendances;

    }

    @Override
    public int addAttendance(MyAttendance myAttendance) {
        int i = attendanceMapper.addAttendance(myAttendance);
        return i;
    }


}
