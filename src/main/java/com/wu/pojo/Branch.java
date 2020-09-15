package com.wu.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Branch implements Serializable {

    private int branchId;
    private String branchName;
    private int parentId;
    private Date branchUpdate;
  //一个部门多个职员
    private List<Staff> staffs;

    private List<Branch> children;

    public Branch() {
    }

    public Branch(int branchId, String branchName, int parentId, Date branchUpdate, List<Staff> staffs, List<Branch> children) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.parentId = parentId;
        this.branchUpdate = branchUpdate;
        this.staffs = staffs;
        this.children = children;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Date getBranchUpdate() {
        return branchUpdate;
    }

    public void setBranchUpdate(Date branchUpdate) {
        this.branchUpdate = branchUpdate;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Branch> getChildren() {
        return children;
    }

    public void setChildren(List<Branch> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", parentId=" + parentId +
                ", branchUpdate=" + branchUpdate +
                ", staffs=" + staffs +
                ", children=" + children +
                '}';
    }
}
