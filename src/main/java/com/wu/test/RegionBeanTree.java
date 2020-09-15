package com.wu.test;


import java.util.List;

public class RegionBeanTree {
    private String code ;
    private String pid ;
    private String label ;
    private List<RegionBeanTree> children;

    public RegionBeanTree() {
    }

    public RegionBeanTree(String code, String pid, String label, List<RegionBeanTree> children) {
        this.code = code;
        this.pid = pid;
        this.label = label;
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<RegionBeanTree> getChildren() {
        return children;
    }

    public void setChildren(List<RegionBeanTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "RegionBeanTree{" +
                "code='" + code + '\'' +
                ", pid='" + pid + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
