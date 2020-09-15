package com.wu.mapper;

import com.wu.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {

    //查找所有职员
    List<Staff> queryStaffList();

    //根据账号密码查找职员
     Staff getStaff(@Param("userName") String name, @Param("password") String password);

    //根据职称（职位）查找职员
    List<Staff> queryStaffListByTitle(@Param("staffTitle") String staffTitle);

    //根据staffid查找职员
    Staff queryStaffById(@Param("staffId") int staffId);

    //根据部门id查询职员
    List<Staff> queryStaffListByBranchId(@Param("sbranchId") int sbranchId);

    //增加一个职员
    int addStaff(Staff staff);

    //修改一个职员
    int updateStaff(Staff staff);

    //删除一个职员
    int deleteStaffById(@Param("staffId") int staffId);


}
