package com.wu.service;

import com.wu.pojo.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffService {

    List<Staff> queryStaffList();

    Staff getStaff(@Param("userName") String name, @Param("password") String password);

    List<Staff> queryStaffListByTitle(@Param("staffTitle") String StaffTitle);

    Staff queryStaffById(@Param("staffId") int staffId);

    List<Staff> queryStaffListByBranchId(@Param("sbranchId") int sbranchId);

    int addStaff(Staff staff);

    int updateStaff(Staff staff);

    int deleteStaffById(@Param("staffId") int staffId);

}
