package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ValueConstants;

/**
 * 类描述: 测试
 *
 * @Author: 杨扬
 * @Date: 2022/12/12 10:51
 */
@Controller
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "resume")
    public String resume(){
        System.out.println("测试jsp页面跳转！！");
        return "resume";
    }

}
