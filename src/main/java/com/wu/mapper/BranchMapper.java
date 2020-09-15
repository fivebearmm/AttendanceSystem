package com.wu.mapper;

import com.wu.pojo.Branch;
import com.wu.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BranchMapper {


    //获取全部部门
    List<Branch> queryBranchList();

    //获取指定部门，及部门下的所有职员
    Branch queryBranchById(@Param("branchId") int branchId);

    //获取所有部门，及部门下的所有职员
    List<Branch> queryBranchListWithStaff();

    //增加一个部门
    int addBranch(Branch branch);

    //修改一个部门
    int updateBranch(Branch branch);

    //删除一个部门
    int deleteBranchById(@Param("branchId") int branchId);

}
