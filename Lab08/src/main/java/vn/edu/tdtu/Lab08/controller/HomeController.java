package vn.edu.tdtu.Lab08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String postContact(
            @RequestParam("fullName") String fullName,
            @RequestParam("age") String age,
            @RequestParam("address") String address,
            Model model
    ){
        model.addAttribute("fullName", fullName);
        model.addAttribute("age", age);
        model.addAttribute("address", address);
        return "contact-response";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
