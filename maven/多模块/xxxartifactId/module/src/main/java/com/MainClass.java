package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aaacom.aaa;

public class MainClass {
    public void f() {
        new ClassPathXmlApplicationContext();

        String[] pinyin = PinyinHelper.toHanyuPinyinStringArray('王');
        System.out.println(pinyin[0]);

        System.out.println(JSON.toJSONString(new JsonClass(), SerializerFeature.WriteMapNullValue));
    }

    public static void main(String[] args) {
        MainClass m1 = new MainClass();
        m1.f();
    }
}

class JsonClass{
    int x;
    String y;

    public int getX() {
        return x;
    }
    public String getY() {
        return y;
    }
}
