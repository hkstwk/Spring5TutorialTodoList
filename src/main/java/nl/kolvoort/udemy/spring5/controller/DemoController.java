package nl.kolvoort.udemy.spring5.controller;

import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.udemy.spring5.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // fields
    private final DemoService demoService;

    // constructors
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // request methods
    // URL http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    // URL http://localhost:8080/todo-list/welcome
    @GetMapping("welcome")
    public String welcome(Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage("Harm"));
        log.info("model = {}", model);
        // prefix + name + suffix
        // /WEB-INF/view/welcome.jsp
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
