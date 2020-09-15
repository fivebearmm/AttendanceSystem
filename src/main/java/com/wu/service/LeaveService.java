package com.wu.service;

import com.wu.pojo.MyLeave;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LeaveService {


    List<MyLeave> queryLeaveByStaffIds(Map map);

    List<MyLeave> queryLeaveByStaffId(@Param("staffId") int staffId,
                                      @Param("leaveStart") Date leaveStart,
                                      @Param("leaveEnd") Date leaveEnd);
    int addLeave(MyLeave myLeave);

    List<MyLeave> queryLeaveByAttendanceId(@Param("lattendanceId") int lattendanceId);

}
