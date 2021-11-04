package com.example.myspringboot.a;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import comb.test2;

@Controller
public class test {
    @RequestMapping(value = "/string")
    @ResponseBody
    public String string(){
        return new test2().f();
    }

    @RequestMapping(value = "/map")
    @ResponseBody
    public Map<String,Object> map(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("a","xxxxxxx");
        return map;
    }



}
