package com.ragnarokonline.api.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<?> defaultRoute() {
        HashMap<String, String> map = new HashMap<>();
        map.put("statusCode", "200");
        map.put("status", "SUCCESS");
        map.put("message", "rathena-online api is online!");
        map.put("data", null);
        return ResponseEntity.ok(map);
    }
}
