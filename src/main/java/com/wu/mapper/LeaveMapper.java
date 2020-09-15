package com.wu.mapper;

import com.wu.pojo.MyAttendance;
import com.wu.pojo.MyLeave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LeaveMapper {

    //查找指定员工们的非正常出勤
    List<MyLeave> queryLeaveByStaffIds(Map map);

    //查找指定员工的非正常出勤
    List<MyLeave> queryLeaveByStaffId(@Param("staffId") int staffId,
                                                @Param("leaveStart")Date leaveStart,
                                                @Param("leaveEnd") Date leaveEnd);
    //增加一条非正常出勤
    int addLeave(MyLeave myLeave);

    //查询出勤id下所有非正常出勤
    List<MyLeave> queryLeaveByAttendanceId(@Param("lattendanceId") int lattendanceId);

}
