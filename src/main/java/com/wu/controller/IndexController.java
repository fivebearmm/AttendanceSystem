package com.wu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wu.annotation.AuthToken;
import com.wu.model.ResponseTemplate;
import com.wu.pojo.MyAttendance;
import com.wu.pojo.MyLeave;
import com.wu.pojo.Staff;
import com.wu.service.AttendanceService;
import com.wu.service.LeaveService;
import com.wu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class IndexController {


    @Autowired
    private AttendanceService attendanceService;


    //普通员工登录首页为我的考勤-实时状态 查询接口
    @GetMapping("/commonStatus/{staffId}/{attendanceStart}/{attendanceEnd}/{pageNum}")
    //@AuthToken
    public ResponseTemplate CommonStaffQuery(@PathVariable int staffId,
                                             @PathVariable String attendanceStart,
                                             @PathVariable String attendanceEnd,
                                             Model model,
                                             @PathVariable Integer pageNum
                                             ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = dateFormat.parse(attendanceStart);
        Date end = dateFormat.parse(attendanceEnd);

        PageHelper.startPage(pageNum,10);
        List<MyAttendance> myAttendances = attendanceService.queryAttendanceByStaffId(staffId,start,end);

        String s = JSON.toJSONStringWithDateFormat(myAttendances,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
        JSONArray objects = JSON.parseArray(s);

        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查询成功");
        responseTemplate.setData(objects);
        PageInfo<MyAttendance> pageInfo = new PageInfo<>(myAttendances);
        model.addAttribute("pageInfo",pageInfo);
        return responseTemplate;
    }



    //管理职登录首页为考勤统计-实时状态 查询接口
    @Autowired
    private StaffService staffService;
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/ManageQueryStatus/{staffTitle}/{leaveStart}/{leaveEnd}/{pageNum}")
    //@AuthToken
    public ResponseTemplate queryLeaveByStaffIds(@PathVariable String staffTitle,
                                                 @PathVariable String leaveStart,
                                                 @PathVariable String leaveEnd,
                                                 Model model,
                                                 @PathVariable Integer pageNum
                                                 ) throws ParseException {

        List<Staff> staffs = staffService.queryStaffListByTitle(staffTitle);
        ArrayList<Integer> lstaffIds = new ArrayList<>();
        for (Staff staff : staffs) {
            lstaffIds.add(staff.getStaffId());
        }
        HashMap map = new HashMap();
        map.put("lstaffIds",lstaffIds);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date start = dateFormat.parse(leaveStart);
        Date end = dateFormat.parse(leaveEnd);
        map.put("leaveStart",start);
        map.put("leaveEnd",end);

        PageHelper.startPage(pageNum,10);
        List<MyLeave> myLeaves = leaveService.queryLeaveByStaffIds(map);
        String s = JSON.toJSONStringWithDateFormat(myLeaves,"yyyy-MM-dd HH:mm:ss",SerializerFeature.WriteDateUseDateFormat);
        JSONArray objects = JSON.parseArray(s);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查找成功");
        responseTemplate.setData(objects);
        PageInfo<MyLeave> pageInfo = new PageInfo<>(myLeaves);
        model.addAttribute("pageInfo",pageInfo);
        return responseTemplate;

    }




}
