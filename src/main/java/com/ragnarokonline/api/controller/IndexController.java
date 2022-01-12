package com.ragnarokonline.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String defaultRoute() {
        return "rathena-online api is online!";
    }
    
}
