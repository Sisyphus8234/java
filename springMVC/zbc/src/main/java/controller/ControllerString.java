package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/String")
public class ControllerString {

    @RequestMapping(value = "/some.do")
    public String dosome(HttpServletRequest h1) {

//        h1.setAttribute("msg","AAA");
        h1.setAttribute("fun","BBB");
        return "show";

    }
}
