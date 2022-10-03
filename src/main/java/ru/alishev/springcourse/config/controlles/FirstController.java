package ru.alishev.springcourse.config.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) int a,
                                 @RequestParam(value = "b", required = false) int b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model1){
        if (action.equals("multiplication")) {
            Integer temp = (a * b);
            String result = temp.toString();
            model1.addAttribute("message", action + " result: " + result);
        } else if (action.equals("addition")) {
            Integer temp = (a + b);
            String result = temp.toString();
            model1.addAttribute("message", action + " result: " + result);
        } else if (action.equals("subtraction")) {
            Integer temp = (a - b);
            String result = temp.toString();
            model1.addAttribute("message", action + " result: " + result);
        } else if (action.equals("division")) {
            Integer temp = (a / b);
            String result = temp.toString();
            model1.addAttribute("message", action + " result: " + result);
        }

        return "first/calculator";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        model.addAttribute("message", "Hello, " + name + " " +surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
