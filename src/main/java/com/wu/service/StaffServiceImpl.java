package com.wu.service;

import com.wu.mapper.StaffMapper;
import com.wu.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> queryStaffList() {

        List<Staff> staffs = staffMapper.queryStaffList();
        return staffs;
    }

    @Override
    public Staff getStaff(String UserName, String password) {
        Staff staff = staffMapper.getStaff(UserName, password);
        return staff;
    }

    @Override
    public List<Staff> queryStaffListByTitle(String staffTitle) {
        List<Staff> staffs = staffMapper.queryStaffListByTitle(staffTitle);
        return staffs;
    }

    @Override
    public Staff queryStaffById(int staffId) {
        Staff staff = staffMapper.queryStaffById(staffId);
        return staff;
    }

    @Override
    public List<Staff> queryStaffListByBranchId(int sbranchId) {

        List<Staff> staffs = staffMapper.queryStaffListByBranchId(sbranchId);
        return staffs;
    }

    @Override
    public int addStaff(Staff staff) {
        int i = staffMapper.addStaff(staff);
        return i;
    }

    @Override
    public int updateStaff(Staff staff) {
        int i = staffMapper.updateStaff(staff);
        return i;
    }

    @Override
    public int deleteStaffById(int staffId) {
        int i = staffMapper.deleteStaffById(staffId);
        return i;
    }


}
