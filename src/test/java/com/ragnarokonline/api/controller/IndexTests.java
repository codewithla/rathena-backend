package com.ragnarokonline.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class IndexTests {
    
    @Autowired
    private IndexController controller;

    @Test
    public void testDefaultRoute() {
        assertThat(controller).isNotNull();
        assert(controller.defaultRoute()).equals("rathena-online api is online!");
    }
}
