import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aaa")
public class aaacontroller {

    @GetMapping("/a")
    public String return_html() {
        System.out.println("-----------------------------------------return_html()");
        return "/aaa";
    }

    @GetMapping("/b")
    public aaadomain return_json() {
        System.out.println("-----------------------------------------return_json()");
        return new aaadomain();
    }
}
