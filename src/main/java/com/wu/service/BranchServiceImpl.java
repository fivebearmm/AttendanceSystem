package com.wu.service;

import com.wu.mapper.BranchMapper;
import com.wu.pojo.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchMapper branchMapper;

    @Override
    public List<Branch> queryBranchList() {

        List<Branch> branches = branchMapper.queryBranchList();
        return branches;

    }

    @Override
    public Branch queryBranchById(int branchId) {
        Branch branch = branchMapper.queryBranchById(branchId);
        return branch;
    }

    @Override
    public List<Branch> queryBranchListWithStaff() {
        List<Branch> branchList = branchMapper.queryBranchListWithStaff();
        return branchList;
    }

    @Override
    public int addBranch(Branch branch) {
        int i = branchMapper.addBranch(branch);
        return i;
    }

    @Override
    public int updateBranch(Branch branch) {
        int i = branchMapper.updateBranch(branch);
        return i;
    }

    @Override
    public int deleteBranchById(int branchId) {
        int i = branchMapper.deleteBranchById(branchId);
        return i;
    }


}
