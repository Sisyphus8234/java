package aaa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//RestController = Controller + ResponseBody
@Controller

//允许跨域
//@CrossOrigin(value = "*")

@RequestMapping("/aaa")
public class aaaController {

    @GetMapping("/a")
    public String return_html() {
        System.out.println("-----------------------------------------return_html()");
        return "/ajax请求";
    }

    @GetMapping("/b")
    public String return_html2() {
        System.out.println("-----------------------------------------return_html2()");
        return "/bbb";
    }

    @ResponseBody
    @GetMapping("/c")
    public aaaDomain return_json() {
        System.out.println("-----------------------------------------return_json()");
        return new aaaDomain();
    }
}
