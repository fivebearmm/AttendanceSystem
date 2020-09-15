package com.wu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wu.annotation.AuthToken;
import com.wu.model.ResponseTemplate;
import com.wu.pojo.Branch;
import com.wu.pojo.MyAttendance;
import com.wu.pojo.MyLeave;
import com.wu.pojo.Staff;
import com.wu.service.AttendanceService;
import com.wu.service.BranchService;
import com.wu.service.LeaveService;
import com.wu.service.StaffService;
import com.wu.utils.BranchTreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class AttendanceRecordController {

    @Autowired
    private BranchService branchService;

    //考勤统计部门人员树查询接口
    @GetMapping("/BranchWithStaffTree")
    //@AuthToken
    public Branch BranchWithStaffTree(){

        Branch beanTree1 = branchService.queryBranchById(1);


        List<Branch> rootList = new ArrayList<>();
        rootList.add(beanTree1);
        List<Branch> bodyList = new ArrayList<>();
        List<Branch> beanTrees = branchService.queryBranchListWithStaff();
        for (Branch beanTree : beanTrees) {
            bodyList.add(beanTree);
        }
        BranchTreeUtils Utils = new BranchTreeUtils(rootList, bodyList);
        List<Branch> tree = Utils.getTree();
        Branch branch = tree.get(0);
        return branch;

    }

    @Autowired
    private StaffService staffService;
    @Autowired
    private LeaveService leaveService;


    //考勤统计/实时状态接口
    @PostMapping("/recordStatus")
    //@AuthToken
    public ResponseTemplate recordStatus( @RequestParam List<Integer> staffIdList,
                                          @RequestParam List<Integer> branchIdList,
                                          @RequestParam String leaveStart,
                                          @RequestParam String leaveEnd,
                                          Model model,
                                          @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) throws ParseException {

        ArrayList<Integer> lstaffIds = new ArrayList<>();
        HashMap map = new HashMap();

        if (staffIdList.size() != 0){

            for (Integer integer : staffIdList) {
                lstaffIds.add(integer);
            }

        }
        if(branchIdList.size() != 0){

            for (Integer integer : branchIdList) {

                List<Staff> staffs = staffService.queryStaffListByBranchId(integer);
                for (Staff staff : staffs) {
                    lstaffIds.add(staff.getStaffId());
                }

            }

        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = dateFormat.parse(leaveStart);
        Date end = dateFormat.parse(leaveEnd);

        map.put("lstaffIds",lstaffIds);
        map.put("leaveStart",start);
        map.put("leaveEnd",end);

        PageHelper.startPage(pageNum,10);
        List<MyLeave> myLeaves = leaveService.queryLeaveByStaffIds(map);
        String s = JSON.toJSONStringWithDateFormat(myLeaves,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
        JSONArray objects = JSON.parseArray(s);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查找成功");
        responseTemplate.setData(objects);
        PageInfo<MyLeave> pageInfo = new PageInfo<>(myLeaves);
        model.addAttribute("pageInfo",pageInfo);
        return responseTemplate;

    }



    //考勤统计/月报表查询接口
    @PostMapping("/recordMonth")
    //@AuthToken
    public ResponseTemplate recordMonth(@RequestParam List<Integer> staffIdList,
                                        @RequestParam List<Integer> branchIdList,
                                        @RequestParam String leaveStart,
                                        @RequestParam String leaveEnd
                                        ) throws ParseException {


        ArrayList<Integer> lstaffIds = new ArrayList<>();
        HashMap map = new HashMap();

        if (staffIdList.size() != 0){

            for (Integer integer : staffIdList) {
                lstaffIds.add(integer);
            }

        }
        if(branchIdList.size() != 0){

            for (Integer integer : branchIdList) {

                List<Staff> staffs = staffService.queryStaffListByBranchId(integer);
                for (Staff staff : staffs) {
                    lstaffIds.add(staff.getStaffId());
                }

            }

        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = dateFormat.parse(leaveStart);
        Date end = dateFormat.parse(leaveEnd);

        map.put("lstaffIds",lstaffIds);
        map.put("leaveStart",start);
        map.put("leaveEnd",end);

        List<MyLeave> myLeaves = leaveService.queryLeaveByStaffIds(map);
        Map<String,List<MyLeave>> groupByMonth =myLeaves.stream().collect(Collectors.groupingBy(o ->{
            int year = o.getLeaveStart().getYear() + 1900;
            int month = o.getLeaveStart().getMonth() + 1;
            String syear = Integer.toString(year);
            String smonth = Integer.toString(month);
            return syear+"-"+smonth;
        }));
        String s = JSON.toJSONStringWithDateFormat(groupByMonth, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteNonStringKeyAsString);
        JSONObject jsonObject = JSON.parseObject(s);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查找成功");
        responseTemplate.setData(jsonObject);
        return responseTemplate;
    }


    //考勤统计/年报表查询接口
    @PostMapping("/recordYear")
    //@AuthToken
    public ResponseTemplate recordYear(@RequestParam List<Integer> staffIdList,
                                       @RequestParam List<Integer> branchIdList,
                                       @RequestParam String leaveStart,
                                       @RequestParam String leaveEnd
    ) throws ParseException {

        ArrayList<Integer> lstaffIds = new ArrayList<>();
        HashMap map = new HashMap();

        if (staffIdList.size() != 0){

            for (Integer integer : staffIdList) {
                lstaffIds.add(integer);
            }

        }
        if(branchIdList.size() != 0){

            for (Integer integer : branchIdList) {

                List<Staff> staffs = staffService.queryStaffListByBranchId(integer);
                for (Staff staff : staffs) {
                    lstaffIds.add(staff.getStaffId());
                }

            }

        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = dateFormat.parse(leaveStart);
        Date end = dateFormat.parse(leaveEnd);

        map.put("lstaffIds",lstaffIds);
        map.put("leaveStart",start);
        map.put("leaveEnd",end);

        List<MyLeave> myLeaves = leaveService.queryLeaveByStaffIds(map);
        Map<String,List<MyLeave>> groupByMonth =myLeaves.stream().collect(Collectors.groupingBy(o -> {
            int year = o.getLeaveStart().getYear() + 1900;
            String syear = Integer.toString(year);
            return syear;
        }));
        String s = JSON.toJSONStringWithDateFormat(groupByMonth, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteNonStringKeyAsString);
        JSONObject jsonObject = JSON.parseObject(s);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查找成功");
        responseTemplate.setData(jsonObject);
        return responseTemplate;
    }


    //考勤统计/非正常出勤月报表接口  同考勤统计/月报表





}
