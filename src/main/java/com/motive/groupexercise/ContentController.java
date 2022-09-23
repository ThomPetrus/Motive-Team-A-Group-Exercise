package com.motive.groupexercise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pages")
public class ContentController {
    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/index")
    public String homepage() {
        return "index";
    }
}
