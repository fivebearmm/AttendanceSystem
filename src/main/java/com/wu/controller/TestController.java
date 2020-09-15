package com.wu.controller;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wu.annotation.AuthToken;
import com.wu.model.LeaveExportModel;
import com.wu.pojo.*;
import com.wu.service.*;
import com.wu.test.InvoiceTaxForeEO;
import com.wu.test.TaxForeEO;
import com.wu.test.TestModel;
import com.wu.utils.BranchTreeUtils;
import com.wu.utils.EasyExcelUtil;
import com.wu.utils.Md5TokenGenerator;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TestController {


    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/a/{attendanceId}")
    public MyAttendance getAttendance(@PathVariable int attendanceId){

        MyAttendance myAttendance = attendanceService.getAttendance(attendanceId);
        return myAttendance;

    }

    @GetMapping("/dodo")
    public int addA(){
        MyAttendance myAttendance = new MyAttendance();
        myAttendance.setAttendanceId(20201111);
        myAttendance.setAstaffId(1);
        int i = attendanceService.addAttendance(myAttendance);
        return i;

    }


    @Autowired
    private BranchService branchService;

    @GetMapping("/b")
    public List<Branch> queryBranchList(){

        List<Branch> branches = branchService.queryBranchList();
        for (Branch branch : branches) {

            System.out.println(branch);
        }

        return branches;
    }

    @GetMapping("/queryBranchById/{branchId}")
    public Branch queryBranchById(@PathVariable int branchId, Model model){

        Branch branch = branchService.queryBranchById(branchId);

        System.out.println(branch);

        //model.addAttribute("branch",branch);

        return branch;


    }

    @GetMapping("/BranchListWithStaff")
    public List<Branch> BranchListWithStaff(){

        List<Branch> branchList = branchService.queryBranchListWithStaff();
        return branchList;

    }



//    //部门人员树查询接口
//    @GetMapping("/BranchWithStaffTree")
//    @AuthToken
//    public Branch BranchWithStaffTree(){
//
//        Branch beanTree1 = branchService.queryBranchById(1);
//
//
//        List<Branch> rootList = new ArrayList<>();
//        rootList.add(beanTree1);
//        List<Branch> bodyList = new ArrayList<>();
//        List<Branch> beanTrees = branchService.queryBranchListWithStaff();
//        for (Branch beanTree : beanTrees) {
//            bodyList.add(beanTree);
//        }
//        BranchTreeUtils Utils = new BranchTreeUtils(rootList, bodyList);
//        List<Branch> tree = Utils.getTree();
//        Branch branch = tree.get(0);
//        return branch;
//
//    }



    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private StaffService staffService;

//    @GetMapping("/queryStaffById/{staffId}")
//    public Staff queryStaffById(@PathVariable int staffId){
//
//        Staff staff = staffService.queryStaffById(staffId);
//        return staff;
//
//    }

    @GetMapping("/queryStaffListByBranchId/{sbranchId}")
    public List<Staff> queryStaffByBranchId(@PathVariable int sbranchId){

        List<Staff> staff = staffService.queryStaffListByBranchId(sbranchId);
        return  staff;
    }




//    @ResponseBody
//    @GetMapping("/welcome")
//    @AuthToken
//    public String welcome(){
//
//        return "welcome token authentication";
//    }

//    @ResponseBody
//    @PostMapping("/login")
//    public ResponseTemplate login(@RequestParam String userName,
//                                  @RequestParam String password) {
//
//
//        Staff staff = staffService.getStaff(userName, password);
//
//
//        JSONObject result = new JSONObject();
//        if (staff != null) {
//
//            Jedis jedis = new Jedis("127.0.0.1", 6379);
//            String token = tokenGenerator.generate(userName, password);
//            jedis.set(userName,token);
//            //设置key生存时间，当key过期时，它会被自动删除，时间是秒
//            jedis.expire(userName, ConstantKit.TOKEN_EXPIRE_TIME);
//            jedis.set(token, userName);
//            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
//            Long currentTime = System.currentTimeMillis();
//            jedis.set(token + userName, currentTime.toString());
//            //用完关闭
//            jedis.close();
//
//            result.put("status", "登录成功");
//            result.put("token", token);
//
//            ResponseTemplate responseTemplate = new ResponseTemplate();
//            responseTemplate.setCode(200);
//            responseTemplate.setMessage("登录成功");
//            responseTemplate.setData(result);
//
//            return responseTemplate;
//
//        } else {
//            result.put("status", "登录失败");
//            ResponseTemplate responseTemplate = new ResponseTemplate();
//            responseTemplate.setCode(401);
//            responseTemplate.setMessage("登录失败");
//            return responseTemplate;
//        }
//
//
//    }
//

    @GetMapping("/queryStaffListByTitle/{staffTitle}")
    public List<Staff> queryStaffListByTitle(@PathVariable String staffTitle){

        List<Staff> staffs = staffService.queryStaffListByTitle(staffTitle);
        return staffs;

    }

    @ResponseBody
    @GetMapping("/s")
    @AuthToken
    public List<Staff> queryStaffList(){

        List<Staff> staffs = staffService.queryStaffList();
        for (Staff staff : staffs) {

            System.out.println(staff);
        }

        return staffs;
    }


    @ResponseBody
    @GetMapping("/token/{userName}/{password}")
    public Staff getStaff(@PathVariable String userName,@PathVariable String password){

        Staff staff = staffService.getStaff(userName, password);
        return staff;

    }

//    @ResponseBody
//    @RequestMapping(value = "test", method = RequestMethod.GET)
//    @AuthToken
//    public ResponseTemplate test() {
//
//        ResponseTemplate responseTemplate = new ResponseTemplate();
//        responseTemplate.setCode(200);
//        responseTemplate.setMessage("登录成功");
//        responseTemplate.setData("test url");
//        return responseTemplate;
//    }



    @Autowired
    private UserService userService;


    @GetMapping("/q")
    public List<User> queryUserList(){

        List<User> users = userService.queryUserList();

        for (User user : users) {
            System.out.println(user);
        }

        return users;

    }

    @GetMapping("/getAllPerson")
    public List<User> getAllPerson(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<User> list = userService.queryUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("pageInfo",pageInfo);
        return list;
    }




        //导入excel
    @RequestMapping(value = "excelImport", method = {RequestMethod.GET, RequestMethod.POST })
    public String excelImport(HttpServletRequest request, Model model, @RequestParam("uploadFile") MultipartFile[] files) throws Exception {
        if(files != null && files.length > 0){
            MultipartFile file = files[0];
            Map<String,Object> result = EasyExcelUtil.readExcel(file, new TestModel(),1);
            Boolean flag = (Boolean) result.get("flag");
            if(flag){
                List<Object> list = (List<Object>) result.get("datas");
                if(list != null && list.size() > 0){
                    for(Object o : list){
                        TestModel xfxx = (TestModel) o;
                        System.out.println(xfxx.getXm()+"/"+xfxx.getSjh()+"/"+xfxx.getSjh()+"/"+xfxx.getDay());
                    }
                }
            }else{
                System.out.println("表头格式错误");
            }
        }
        return "index";
    }



//    @GetMapping(value = "/exportExcel/taxForecast")
//    public void exportExcel(String uid, String accountCodeList, Date startDate, Date endDate, HttpServletResponse response) {
//        //log.info("帐套查询参数{},开始时间{},结束时间{},uid:{}",, accountCodeList, startDate, endDate, uid);
//        try {
//            List<TaxForeEO> taxForeEOList = new ArrayList<>();
//            List<InvoiceTaxForeEO> invoiceTaxForeEOS = new ArrayList<>();
//            Map<String, List<? extends BaseRowModel>> map = new HashMap<>();
//            map.put("税赋预测表", taxForeEOList);
//            map.put("发票汇总表", invoiceTaxForeEOS);
//            EasyExcelUtil.createExcelStreamMutilByEaysExcel(response, map, ExcelTypeEnum.XLSX);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // return Result.fail("500", "导出失败");
//        }
//        // return Result.success("导出成功");
//    }

    @Autowired
    private LeaveService leaveService;
    @GetMapping(value = "/exportExcelTest/{staffId}/{branchId}/{leaveStart}/{leaveEnd}")
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
