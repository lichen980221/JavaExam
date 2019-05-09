package com.isoft.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {
    @RequestMapping(value = "/displayTest.do",method = RequestMethod.GET)
    @ResponseBody
    public List displayTest(){
        System.out.println("sssssss");
        List list = new ArrayList();
        list.add("zhangjis");
        list.add("zhangds");
        list.add("svbwris");
        list.add("yrjnyjis");
        return list;
    }
}
