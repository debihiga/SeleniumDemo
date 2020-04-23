package com.debihiga.seleniumdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // Spring Boot’s autoconfigured view resolver will map to src/main/resources/templates/index.html.
    private final String TEMPLATE_INDEX = "index";

    @RequestMapping(value = "/")
    public String index() {
        return TEMPLATE_INDEX;
    }

}