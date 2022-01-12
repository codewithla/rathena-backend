package com.ragnarokonline.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = IndexController.class)
public class IndexTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDefaultRoute() throws Exception {
        mockMvc.perform(get("/")).andExpect(content().string(containsString("rathena-online api is online!"))).andExpect(status().isOk());
    }
}
