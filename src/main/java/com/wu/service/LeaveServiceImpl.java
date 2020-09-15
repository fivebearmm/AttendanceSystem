package com.wu.service;

import com.wu.mapper.LeaveMapper;
import com.wu.pojo.MyLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    LeaveMapper leaveMapper;

    @Override
    public List<MyLeave> queryLeaveByStaffIds(Map map) {

        List<MyLeave> myLeaves = leaveMapper.queryLeaveByStaffIds(map);
        return myLeaves;
    }

    @Override
    public List<MyLeave> queryLeaveByStaffId(int staffId, Date leaveStart, Date leaveEnd) {
        List<MyLeave> myLeaves = leaveMapper.queryLeaveByStaffId(staffId, leaveStart, leaveEnd);
        return  myLeaves;
    }

    @Override
    public int addLeave(MyLeave myLeave) {
        int i = leaveMapper.addLeave(myLeave);
        return i;
    }

    @Override
    public List<MyLeave> queryLeaveByAttendanceId(int lattendanceId) {
        List<MyLeave> myLeaves = leaveMapper.queryLeaveByAttendanceId(lattendanceId);
        return myLeaves;
    }


}
