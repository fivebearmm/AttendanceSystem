package com.wu.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.wu.annotation.AuthToken;
import com.wu.model.AttendanceExcelModel;
import com.wu.model.LeaveExcelModel;
import com.wu.model.LeaveExportModel;
import com.wu.pojo.MyAttendance;
import com.wu.pojo.MyLeave;
import com.wu.pojo.Staff;
import com.wu.service.AttendanceService;
import com.wu.service.LeaveService;
import com.wu.service.StaffService;
import com.wu.utils.EasyExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ExcelExportImportController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private LeaveService leaveService;

    //导入出勤excel
    @RequestMapping(value = "excelLeaveImport", method = {RequestMethod.GET, RequestMethod.POST })
    //@AuthToken
    public String excelImport1(HttpServletRequest request, Model model, @RequestParam("uploadFile") MultipartFile[] files) throws Exception {
        if(files != null && files.length > 0){
            MultipartFile file = files[0];
            Map<String,Object> result = EasyExcelUtil.readExcel(file,new LeaveExcelModel(),1);
            Boolean flag = (Boolean) result.get("flag");
            if(flag){
                List<Object> list = (List<Object>) result.get("datas");
                if(list != null && list.size() > 0){
                    for(Object o : list){
                        LeaveExcelModel excelModel = (LeaveExcelModel) o;
                        int lattendanceId = Integer.parseInt(excelModel.getLattendanceId());
                        int lstaffId = Integer.parseInt(excelModel.getLstaffId());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date start = dateFormat.parse(excelModel.getLeaveStart());
                        Date end = dateFormat.parse(excelModel.getLeaveEnd());
                        MyLeave myLeave = new MyLeave();
                        myLeave.setLattendanceId(lattendanceId);
                        myLeave.setLstaffId(lstaffId);
                        myLeave.setLeaveStart(start);
                        myLeave.setLeaveEnd(end);
                        myLeave.setLeaveType(excelModel.getLeaveType());
                        myLeave.setLeaveReason(excelModel.getLeaveReason());
                        leaveService.addLeave(myLeave);
                    }
                }
            }else{
                System.out.println("表头格式错误");
            }
        }
        return "index";
    }

    //导入出勤excel
    @RequestMapping(value = "excelAttendanceImport", method = {RequestMethod.GET, RequestMethod.POST })
    //@AuthToken
    public String excelImport(HttpServletRequest request, Model model, @RequestParam("uploadFile") MultipartFile[] files) throws Exception {
        if(files != null && files.length > 0){
            MultipartFile file = files[0];
            Map<String,Object> result = EasyExcelUtil.readExcel(file,new AttendanceExcelModel(),1);
            Boolean flag = (Boolean) result.get("flag");
            if(flag){
                List<Object> list = (List<Object>) result.get("datas");
                if(list != null && list.size() > 0){
                    for(Object o : list){
                        AttendanceExcelModel excelModel = (AttendanceExcelModel) o;
                        int attendanceId = Integer.parseInt(excelModel.getAttendanceId());
                        int astaffId = Integer.parseInt(excelModel.getAstaffId());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date start = dateFormat.parse(excelModel.getAttendanceStart());
                        Date end = dateFormat.parse(excelModel.getAttendanceEnd());
                        MyAttendance myAttendance = new MyAttendance();
                        myAttendance.setAttendanceId(attendanceId);
                        myAttendance.setAstaffId(astaffId);
                        myAttendance.setAttendanceStart(start);
                        myAttendance.setAttendanceEnd(end);
                        MyLeave myLeave = new MyLeave();
                        myLeave.setLattendanceId(attendanceId);
                        myLeave.setLstaffId(astaffId);
                        myLeave.setLeaveStart(start);
                        myLeave.setLeaveEnd(end);
                        //出勤和请假当天公司上班下班时间
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String s = sdf.format(myAttendance.getAttendanceEnd());
                        Date date = sdf.parse(s);
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        cal.set(Calendar.HOUR_OF_DAY, 13); //时
                        cal.set(Calendar.MINUTE, 30); //分
                        cal.set(Calendar.SECOND, 0); //秒
                        cal.set(Calendar.MILLISECOND, 0); //毫秒
                        Date timenoon = cal.getTime();
                        Calendar cal2 = Calendar.getInstance();
                        cal2.setTime(date);
                        cal2.set(Calendar.HOUR_OF_DAY, 11); //时
                        cal2.set(Calendar.MINUTE, 30); //分
                        cal2.set(Calendar.SECOND, 0); //秒
                        cal2.set(Calendar.MILLISECOND, 0); //毫秒
                        Date timening = cal2.getTime();

                        Calendar cal3 = Calendar.getInstance();
                        cal.setTime(date);
                        cal.set(Calendar.HOUR_OF_DAY, 9); //时
                        cal.set(Calendar.MINUTE, 0); //分
                        cal.set(Calendar.SECOND, 0); //秒
                        cal.set(Calendar.MILLISECOND, 0); //毫秒
                        Date timeU = cal.getTime();
                        Calendar cal4 = Calendar.getInstance();
                        cal2.setTime(date);
                        cal2.set(Calendar.HOUR_OF_DAY, 18); //时
                        cal2.set(Calendar.MINUTE, 0); //分
                        cal2.set(Calendar.SECOND, 0); //秒
                        cal2.set(Calendar.MILLISECOND, 0); //毫秒
                        Date timenD = cal2.getTime();


                        //分别计算出上下午请假总时间
                        long tlStart = 0;
                        long tlEnd = 0;
                        List<MyLeave> myLeaves = leaveService.queryLeaveByAttendanceId(myAttendance.getAttendanceId());
                                for (MyLeave myLeaf : myLeaves) {
                                    if ((myLeaf.getLeaveEnd().getTime() >= timenoon.getTime()) && (myLeaf.getLeaveStart().getTime() <= timening.getTime())){
                                           tlEnd = tlEnd + (myLeaf.getLeaveEnd().getTime() - timenoon.getTime());//下午请假时间
                                           tlStart = tlStart + (timening.getTime() - myLeaf.getLeaveStart().getTime());//上午请假时间
                                    }else if((myLeaf.getLeaveEnd().getTime() >= timenoon.getTime()) && (myLeaf.getLeaveStart().getTime() >= timening.getTime())){
                                           tlEnd = tlEnd + (myLeaf.getLeaveEnd().getTime() - myLeaf.getLeaveStart().getTime());//下午请假时间
                                    }else {
                                           tlStart = tlStart + (myLeaf.getLeaveEnd().getTime() - myLeaf.getLeaveStart().getTime());//上午请假时间
                                    }
                                }
                        //分别算出上下午未打卡的时间
                        long taStart = 0;
                        long taEnd  = 0;
                        StringBuilder builder = new StringBuilder();

                        if (myAttendance.getAttendanceStart() == null){
                            taStart = 4;
                        }else{
                            if (myAttendance.getAttendanceStart().getTime() >= timeU.getTime()){

                                taStart = (myAttendance.getAttendanceStart().getTime() - timeU.getTime());

                            }
                        }
                        if (myAttendance.getAttendanceEnd() == null){
                            taEnd = 4;
                        }else {
                            if (myAttendance.getAttendanceEnd().getTime() <= timenD.getTime()){

                                taEnd = (timenD.getTime() - myAttendance.getAttendanceEnd().getTime());

                            }

                        }
                        taStart = taStart - tlStart;
                        taEnd = taEnd - tlEnd;
                        //18000是半小时，半小时以上为未打卡
                        if (taStart > 1800000){
                            taStart = taStart / (60 * 60 * 1000);
                            builder.append("上午未打卡"+taStart+"小时/");
                         }else{
                            if (taStart > 0){
                                builder.append("迟到/");
                            }

                        }
                        if (taEnd > 1800000){
                            taEnd = taEnd / (60 * 60 * 1000);
                            builder.append( "下午未打卡"+taEnd+"小时/");
                        }else{
                            if (taEnd > 0){
                                builder.append("早退/");
                            }
                        }
                        String type = builder.toString();
                        System.out.println(type);
                        if (builder.length() != 0){
                            myLeave.setLeaveType(type);
                            leaveService.addLeave(myLeave);
                            myAttendance.setAttendanceType(0);
                        }
                        int i = attendanceService.addAttendance(myAttendance);
                        System.out.println(i);
                    }
                }
            }else{
                System.out.println("表头格式错误");
            }
        }
        return "index";
    }




    @Autowired
    private StaffService staffService;

    @GetMapping(value = "/exportExcel/{staffId}/{branchId}/{leaveStart}/{leaveEnd}")
    public void exportExcel(@PathVariable int staffId,
                            @PathVariable int branchId,
                            @PathVariable String leaveStart,
                            @PathVariable String leaveEnd,
                            HttpServletResponse response) throws ParseException {

        ArrayList<Integer> lstaffIds = new ArrayList<>();
        HashMap map = new HashMap();


        //前端如果查的是人不是部门，部门id请求时设0
        if(branchId == 0){

            Staff staff = staffService.queryStaffById(staffId);
            lstaffIds.add(staff.getStaffId());

        }else{

            List<Staff> staffs = staffService.queryStaffListByBranchId(branchId);
            for (Staff staff : staffs) {

                lstaffIds.add(staff.getStaffId());

            }

        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = dateFormat.parse(leaveStart);
        Date end = dateFormat.parse(leaveEnd);

        map.put("lstaffIds",lstaffIds);
        map.put("leaveStart",start);
        map.put("leaveEnd",end);
        List<LeaveExportModel> leaveModels = new ArrayList<>();
        List<MyLeave> myLeaves = leaveService.queryLeaveByStaffIds(map);
        for (MyLeave myLeaf : myLeaves) {
            LeaveExportModel leaveModel = new LeaveExportModel();
            leaveModel.setBranchName(myLeaf.getBranch().getBranchName());
            leaveModel.setStaffName(myLeaf.getStaff().getStaffName());
            String date = dateFormat.format(myLeaf.getLeaveStart());
            leaveModel.setLeaveStart(date);
            leaveModel.setLeaveType(myLeaf.getLeaveType());
            leaveModels.add(leaveModel);
        }

        Map<String,List<LeaveExportModel>> groupByMonth =leaveModels.stream().collect(Collectors.groupingBy(o -> {


            String yearAndMonth = o.getLeaveStart().substring(0, 7);
            return yearAndMonth;
        }));

        try {
            EasyExcelUtil.createExcelStreamMutilByEaysExcel(response, groupByMonth, ExcelTypeEnum.XLSX);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
