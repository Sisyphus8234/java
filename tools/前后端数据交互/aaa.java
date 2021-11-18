import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class aaa {

    @GetMapping("")

    public String ssdf() {

        return "/aaa";
    }
}
