package com.wu.controller;

import com.alibaba.fastjson.JSONObject;
import com.wu.annotation.AuthToken;
import com.wu.model.ResponseTemplate;
import com.wu.pojo.Staff;
import com.wu.service.StaffService;
import com.wu.utils.ConstantKit;
import com.wu.utils.Md5TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RestController
public class loginController {

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private StaffService staffService;

    //测试用
    @ResponseBody
    @GetMapping("/welcome")
    @AuthToken
    public String welcome(){

        return "welcome token authentication";
    }


    //登录接口
    @ResponseBody
    @PostMapping("/login")
    public ResponseTemplate login(@RequestParam String userName,
                                  @RequestParam String password) {

        Staff staff = staffService.getStaff(userName, password);
        JSONObject result = new JSONObject();
        if (staff != null) {

            Jedis jedis = new Jedis("127.0.0.1", 6379);
            String token = tokenGenerator.generate(userName, password);
            jedis.set(userName,token);
            //设置key生存时间，当key过期时，它会被自动删除，时间是秒
            jedis.expire(userName, ConstantKit.TOKEN_EXPIRE_TIME);
            jedis.set(token, userName);
            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + userName, currentTime.toString());
            //用完关闭
            jedis.close();

            result.put("status", "登录成功");
            result.put("token", token);

            ResponseTemplate responseTemplate = new ResponseTemplate();
            responseTemplate.setCode(200);
            responseTemplate.setMessage("登录成功");
            responseTemplate.setData(result);

            return responseTemplate;

        } else {
            result.put("status", "登录失败");
            ResponseTemplate responseTemplate = new ResponseTemplate();
            responseTemplate.setCode(401);
            responseTemplate.setMessage("登录失败");
            return responseTemplate;
        }


    }

    //测试拦截器，及token验证用
    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @AuthToken
    public ResponseTemplate test() {

        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setCode(200);
        responseTemplate.setMessage("登录成功");
        responseTemplate.setData("test url");
        return responseTemplate;
    }


}
