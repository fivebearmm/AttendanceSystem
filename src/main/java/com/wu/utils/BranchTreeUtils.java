package com.wu.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wu.pojo.Branch;

import java.util.List;
import java.util.Map;

public class BranchTreeUtils {


    private List<Branch> rootList; //根节点对象存放到这里

    private List<Branch> bodyList; //其他节点存放到这里，可以包含根节点

    public BranchTreeUtils(List<Branch> rootList, List<Branch> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }

    public List<Branch> getTree(){   //调用的方法入口
        if(bodyList != null && !bodyList.isEmpty()){
            //声明一个map，用来过滤已操作过的数据
            Map<Integer, Integer> map = Maps.newHashMapWithExpectedSize(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree,map));//传递根对象和一个空map
            return rootList;
        }
        return null;
    }

    public void getChild(Branch beanTree, Map<Integer, Integer> map){
        List<Branch> childList = Lists.newArrayList();
        bodyList.stream()
                .filter(c -> !map.containsKey(c.getBranchId()))//map内不包含子节点的code
                .filter(c ->c.getParentId() == (beanTree.getBranchId()))//子节点的父id==根节点的code 继续循环
                .forEach(c ->{
                    map.put(c.getBranchId(),c.getParentId());//当前节点code和父节点id
                    getChild(c,map);//递归调用
                    childList.add(c);
                });
        beanTree.setChildren(childList);
    }

}
