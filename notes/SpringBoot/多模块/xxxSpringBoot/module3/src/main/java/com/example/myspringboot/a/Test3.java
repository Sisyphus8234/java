package com.example.myspringboot.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Test3 {

    @RequestMapping(value = "/map1")
    @ResponseBody
    public Map<String,Object> map1(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("a","xxxxxxx");
        return map;
    }



}
