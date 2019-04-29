package ai.shanshu.swagger.overview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @author hannannan ( hannannan@shanshu.ai )
 * @date 2019/04/28
 **/
@Controller
@RequestMapping("/")
@ApiIgnore
public class HomeController {
    @GetMapping("/index")
    public String home(){
        return "index";
    }
    @GetMapping("/oauth2-redirect.html")
    public String o2c(){
        return "oauth2-redirect";
    }


}
