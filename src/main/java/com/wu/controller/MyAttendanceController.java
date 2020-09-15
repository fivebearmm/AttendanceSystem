package com.wu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wu.annotation.AuthToken;
import com.wu.model.ResponseTemplate;
import com.wu.pojo.MyAttendance;
import com.wu.pojo.MyLeave;
import com.wu.service.AttendanceService;
import com.wu.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MyAttendanceController {


    //我的考勤实时状态接口同首页普通员工查询出勤接口




    //我的考勤月报表
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/MyAttendanceMonth/{staffId}/{leaveStart}/{leaveEnd}")
   // @AuthToken
    public ResponseTemplate MyAttendanceMonth(@PathVariable int staffId,
                                              @PathVariable String leaveStart,
                                              @PathVariable String leaveEnd
                                              ) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date start = dateFormat.parse(leaveStart);
        Date end = dateFormat.parse(leaveEnd);

        List<MyLeave> myLeaves = leaveService.queryLeaveByStaffId(staffId, start, end);

        Map<Integer,List<MyLeave>> groupByMonth =myLeaves.stream().collect(Collectors.groupingBy(o -> o.getLeaveStart().getMonth()+1));

        String s = JSON.toJSONStringWithDateFormat(groupByMonth, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteNonStringKeyAsString);
        JSONObject jsonObject = JSON.parseObject(s);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查找成功");
        responseTemplate.setData(jsonObject);
        return responseTemplate;


    }


}
