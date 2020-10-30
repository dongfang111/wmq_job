package com.example.demo.aspectj.controller;

import com.example.demo.aspectj.service.AService;
import com.example.demo.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/15 17:22
 **/
@Controller
public class AspectJController {

    @Autowired
    private AService aService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public Map<String,Object> aHelloService(){
        String s = null;
        Map<String,Object> map = new HashMap<>();
        try {
            s = aService.sayHelloA();
            throw new BusinessException("00","hi 出现异常！");
            //System.out.println("33333");
        } catch (BusinessException e) {
            map.put("code",e.getErrCode());
            map.put("msg",e.getErrMsg());
        }
        return map;
    }
}
