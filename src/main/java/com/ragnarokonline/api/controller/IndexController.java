package com.ragnarokonline.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public Map<String, String> defaultRoute() {
        HashMap<String, String> map = new HashMap<>();
        map.put("statusCode", "200");
        map.put("status", "SUCCESS");
        map.put("message", "rathena-online api is online!");
        map.put("data", null);
        return map;
    }
}
