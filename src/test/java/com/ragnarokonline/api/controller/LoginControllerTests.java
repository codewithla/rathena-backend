package com.ragnarokonline.api.controller;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.ragnarokonline.api.model.LoginModel;
import com.ragnarokonline.api.repository.LoginRepository;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;


@WebMvcTest(controllers = LoginController.class)
public class LoginControllerTests {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    LoginRepository loginRepository;

    @Test
    public void getAccountsTest() throws Exception {
        List<LoginModel> response = new ArrayList<>();
        response.add(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0));
        Mockito.when(this.loginRepository.findAll()).thenReturn(response);
        mockMvc.perform(get("/v1/accounts/"))
        .andExpect(content().string(containsString("\"account_id\":2000000")))
        .andExpect(status().isOk());
    }
}
