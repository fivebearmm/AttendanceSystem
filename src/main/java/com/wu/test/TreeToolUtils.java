package com.wu.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/26.
 */
public class TreeToolUtils {

    private List<RegionBeanTree> rootList; //根节点对象存放到这里

    private List<RegionBeanTree> bodyList; //其他节点存放到这里，可以包含根节点

    public TreeToolUtils(List<RegionBeanTree> rootList, List<RegionBeanTree> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }

    public List<RegionBeanTree> getTree(){   //调用的方法入口
        if(bodyList != null && !bodyList.isEmpty()){
            //声明一个map，用来过滤已操作过的数据
            Map<String,String> map = Maps.newHashMapWithExpectedSize(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree,map));//传递根对象和一个空map
            return rootList;
        }
        return null;
    }

    public void getChild(RegionBeanTree beanTree,Map<String,String> map){
        List<RegionBeanTree> childList = Lists.newArrayList();
        bodyList.stream()
                .filter(c -> !map.containsKey(c.getCode()))//map内不包含子节点的code
                .filter(c ->c.getPid().equals(beanTree.getCode()))//子节点的父id==根节点的code 继续循环
                .forEach(c ->{
                    map.put(c.getCode(),c.getPid());//当前节点code和父节点id
                    getChild(c,map);//递归调用
                    childList.add(c);
                });
        beanTree.setChildren(childList);
    }

    public static void main(String[] args){
        RegionBeanTree beanTree1 = new RegionBeanTree();
        beanTree1.setCode("540000");
        beanTree1.setLabel("西藏省");
        beanTree1.setPid("100000"); //最高节点
        RegionBeanTree beanTree2 = new RegionBeanTree();
        beanTree2.setCode("540100");
        beanTree2.setLabel("拉萨市");
        beanTree2.setPid("540000");
        RegionBeanTree beanTree3 = new RegionBeanTree();
        beanTree3.setCode("540300");
        beanTree3.setLabel("昌都市");
        beanTree3.setPid("540000");
        RegionBeanTree beanTree4 = new RegionBeanTree();
        beanTree4.setCode("540121");
        beanTree4.setLabel("林周县");
        beanTree4.setPid("540100");
        RegionBeanTree beanTree5 = new RegionBeanTree();
        beanTree5.setCode("540121206");
        beanTree5.setLabel("阿朗乡");
        beanTree5.setPid("540121");
        RegionBeanTree beanTree6 = new RegionBeanTree();
        List<RegionBeanTree> rootList = new ArrayList<>();
        rootList.add(beanTree1);
        List<RegionBeanTree> bodyList = new ArrayList<>();
        bodyList.add(beanTree1);
        bodyList.add(beanTree2);
        bodyList.add(beanTree3);
        bodyList.add(beanTree4);
        bodyList.add(beanTree5);
        TreeToolUtils utils =  new TreeToolUtils(rootList,bodyList);
        List<RegionBeanTree> result =  utils.getTree();
        RegionBeanTree regionBeanTree = result.get(0);
        System.out.println(regionBeanTree);
    }
}