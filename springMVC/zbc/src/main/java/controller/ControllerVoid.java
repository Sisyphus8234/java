package controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.Student;


import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/Void")
public class ControllerVoid {

//    @RequestMapping(value = "/some.do")
//    public void dosome(HttpServletResponse h1, String data1, Integer data2)
//            throws Exception {
//        System.out.println(data1);
//        System.out.println(data2);
//
//        Student s1=new Student();
//        s1.setNameA("AAAA");
//        s1.setAgeA(111);
//
//        String json1;
//
//        ObjectMapper o1=new ObjectMapper();
//        json1=o1.writeValueAsString(s1);
//
//        System.out.print(1111111111);
//        System.out.println(json1);
//
//        h1.setContentType("application/json;charset=utf-8");
//        PrintWriter pw1=h1.getWriter();
//        pw1.println(json1);
//        pw1.flush();
//        pw1.close();
//    }


    @RequestMapping(value = "/some.do")
    @ResponseBody
    public Student dosome(){
        Student s1= new Student();
        s1.setNameA("李四同学");
        s1.setAgeA(20);
        return s1;
    }

    @RequestMapping(value = "/some2.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String dosome2(){
        return "SpingMVC返回字符串！！！！";
    }



}
