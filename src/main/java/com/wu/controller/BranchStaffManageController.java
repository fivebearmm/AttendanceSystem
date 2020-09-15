package com.wu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.wu.annotation.AuthToken;
import com.wu.model.ResponseTemplate;
import com.wu.pojo.Branch;
import com.wu.pojo.Staff;
import com.wu.service.BranchService;
import com.wu.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BranchStaffManageController {


    @Autowired
    private StaffService staffService;

    @Autowired
    private BranchService branchService;

    @GetMapping("/queryStaffById/{staffId}")
    //@AuthToken
    public ResponseTemplate queryStaffById(@PathVariable int staffId){

        Staff staff = staffService.queryStaffById(staffId);
        String s = JSON.toJSONString(staff);
        Object parse = JSONObject.parse(s);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查找成功");
        responseTemplate.setData(parse);
        return responseTemplate;
    }

    @GetMapping("/queryStaffList/{pageNum}")
    //@AuthToken
    public ResponseTemplate queryStaffList(Model model,
                                           @PathVariable Integer pageNum){

        PageHelper.startPage(pageNum,10);
        List<Staff> staffList = staffService.queryStaffList();
        String jsonString = JSON.toJSONString(staffList);
        JSONArray objects = JSONObject.parseArray(jsonString);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setData("查找成功");
        responseTemplate.setData(objects);
        return responseTemplate;
    }

    @PostMapping("/addStaff")
    //@AuthToken
    public ResponseTemplate addStaff(Staff staff){

        int i = staffService.addStaff(staff);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        if (i == 1){
            responseTemplate.setCode(200);
            responseTemplate.setMessage("添加成功");
            return responseTemplate;
        }else {
            responseTemplate.setCode(406);
            responseTemplate.setMessage("添加失败");
            return responseTemplate;
        }

    }

    @PostMapping("/updateStaff")
    //@AuthToken
    public ResponseTemplate updateStaff(Staff staff){

        int i = staffService.updateStaff(staff);
        ResponseTemplate responseTemplate = new ResponseTemplate();
       if(i == 1){

           responseTemplate.setCode(200);
           responseTemplate.setMessage("修改成功");
           return responseTemplate;

       }else{

           responseTemplate.setCode(406);
           responseTemplate.setMessage("修改失败");
           return responseTemplate;
       }
    }

    @GetMapping("/deleteStaffById/{staffId}")
    //@AuthToken
    public ResponseTemplate deleteStaffById(@PathVariable int staffId){

        int i = staffService.deleteStaffById(staffId);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        if(i == 1){

            responseTemplate.setCode(200);
            responseTemplate.setMessage("删除成功");
            return responseTemplate;

        }else{

            responseTemplate.setCode(406);
            responseTemplate.setMessage("删除失败");
            return responseTemplate;
        }
    }


    @GetMapping("/queryBranchById/{branchId}")
    //@AuthToken
    public ResponseTemplate queryBranchById(@PathVariable int branchId){

        Branch branch = branchService.queryBranchById(branchId);
        String s = JSON.toJSONString(branch);
        Object parse = JSONObject.parse(s);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("查找成功");
        responseTemplate.setData(parse);
        return responseTemplate;
    }

    @GetMapping("/queryBranchList/{pageNum}")
    //@AuthToken
    public ResponseTemplate queryBranchList(Model model,
                                           @PathVariable Integer pageNum){

        PageHelper.startPage(pageNum,10);
        List<Branch> branches = branchService.queryBranchList();
        String jsonString = JSON.toJSONString(branches);
        JSONArray objects = JSONObject.parseArray(jsonString);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setData("查找成功");
        responseTemplate.setData(objects);
        return responseTemplate;
    }


    @PostMapping("/addBranch")
    //@AuthToken
    public ResponseTemplate addBranch(Branch branch){

        int i = branchService.addBranch(branch);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        if (i == 1){
            responseTemplate.setCode(200);
            responseTemplate.setMessage("添加成功");
            return responseTemplate;
        }else {
            responseTemplate.setCode(406);
            responseTemplate.setMessage("添加失败");
            return responseTemplate;
        }

    }


    @PostMapping("/updateBranch")
    //@AuthToken
    public ResponseTemplate updateBranch(Branch branch){

        int i = branchService.updateBranch(branch);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        if(i == 1){

            responseTemplate.setCode(200);
            responseTemplate.setMessage("修改成功");
            return responseTemplate;

        }else{

            responseTemplate.setCode(406);
            responseTemplate.setMessage("修改失败");
            return responseTemplate;
        }
    }


    @GetMapping("/deleteBranchById/{BranchId}")
    //@AuthToken
    public ResponseTemplate deleteBranchById(@PathVariable int branchId){

        int i = branchService.deleteBranchById(branchId);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        if(i == 1){

            responseTemplate.setCode(200);
            responseTemplate.setMessage("删除成功");
            return responseTemplate;

        }else{

            responseTemplate.setCode(406);
            responseTemplate.setMessage("删除失败");
            return responseTemplate;
        }
    }

}
