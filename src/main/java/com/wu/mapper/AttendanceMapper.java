package com.wu.mapper;

import com.wu.pojo.MyAttendance;
import com.wu.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AttendanceMapper {

   MyAttendance getAttendance(@Param("attendanceId") int attendanceId);


   //查找指定员工出勤
   List<MyAttendance> queryAttendanceByStaffId(@Param("staffId") int staffId,
                                            @Param("attendanceStart")Date attendanceStart,
                                            @Param("attendanceEnd") Date attendanceEnd);

   //查找指定员工们的出勤
   List<MyAttendance> queryAttendanceByStaffIds(Map map);

   //增加一个职员
   int addAttendance(MyAttendance myAttendance);


}
