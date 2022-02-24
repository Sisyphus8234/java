package aaa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

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

    @ResponseBody
    @RequestMapping("/d")
    public String receive_json(@RequestBody aaaDomain aaaDomain1) {
        System.out.println(aaaDomain1.getName());
        System.out.println(aaaDomain1.getAaaDomain2().getName2());
        return "success";
    }

    @ResponseBody
    @RequestMapping("/e")
    public String receive_file(MultipartFile file) throws Exception{
        InputStream is = file.getInputStream();
        FileOutputStream fos = new FileOutputStream("b");

        byte[] b = new byte[is.available()];
        System.out.println(is.available());

        while ((is.read(b)) != -1) {
            fos.write(b);
        }
        is.close();
        fos.close();

        return "success";
    }
}
