package com.wu.service;

import com.wu.pojo.Branch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BranchService {

    List<Branch> queryBranchList();

    public Branch queryBranchById(@Param("branchId") int branchId);

    List<Branch> queryBranchListWithStaff();

    int addBranch(Branch branch);

    int updateBranch(Branch branch);

    int deleteBranchById(@Param("branchId") int branchId);

}
