package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vo.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/test")
public class MyController {

    @RequestMapping(value = {"/some.do", "/some1.do"})
    public ModelAndView dosome() {
        //返回值：ModelAndView
        //Model:数据
        //View:视图，比如jsp等

        ModelAndView m1 = new ModelAndView();
        m1.addObject("msg", "AAAAAAAAAAA");
        m1.addObject("fun", "BBBBBBBBBBB");

        m1.setViewName("show");

        return m1;
    }

    @RequestMapping(value = "/someB.do",method= RequestMethod.POST)
    public ModelAndView dosomeB(HttpServletRequest h1, HttpServletResponse h2, HttpSession h3) {

        System.out.println("111111name:"+h1.getParameter("name"));
        System.out.println("111111age:"+h1.getParameter("age"));

        ModelAndView m1 = new ModelAndView();
        m1.addObject("msg", "CCCCCCCCC");
        m1.addObject("fun", "DDDDDDDDD");

        m1.setViewName("show");

        return m1;
    }

    @RequestMapping(value = "/receiveProperty.do",method= RequestMethod.POST)
    public ModelAndView doreceiveProperty(@RequestParam(value="nameA") String name, @RequestParam(value="ageA")int age) {

        ModelAndView m1 = new ModelAndView();
        m1.addObject("msg", name);
        m1.addObject("fun", age);

        m1.setViewName("show");

        return m1;
    }

    @RequestMapping(value = "/receiveObject.do",method= RequestMethod.POST)
    public ModelAndView doreceiveObject(Student s1) {

        ModelAndView m1 = new ModelAndView();
        m1.addObject("msg", s1.getNameA());
        m1.addObject("fun", s1.getAgeA());

        m1.setViewName("show");

        return m1;
    }
}
