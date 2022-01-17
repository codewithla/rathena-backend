package com.ragnarokonline.api.controller;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

    @Test
    public void getAccountsTestFail() throws Exception {
        mockMvc.perform(get("/v1/accounts/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve accounts from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getAccountsById() throws Exception {
        Mockito.when(this.loginRepository.findById(anyInt())).thenReturn(Optional.of(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0)));
        mockMvc.perform(get("/v1/accounts/{account_id}", 2000000))
        .andExpect(content().string(containsString("\"account_id\":2000000")))
        .andExpect(status().isOk());
    }

    @Test
    public void getAccountsByIdFail() throws Exception {
        mockMvc.perform(get("/v1/accounts/{account_id}", 2000001))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to retrieve account from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getAccountsByUserName() throws Exception {
        Mockito.when(this.loginRepository.getUserByUserid(anyString())).thenReturn(Optional.of(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0)));
        mockMvc.perform(get("/v1/accounts/username/{userid}", "userid"))
        .andExpect(content().string(containsString("\"account_id\":2000000")))
        .andExpect(status().isOk());
    }

    @Test
    public void getAccountsByUserNameFail() throws Exception {
        // Mockito.when(this.loginRepository.findById(2000000)).thenReturn(Optional.of(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0)));
        mockMvc.perform(get("/v1/accounts/username/{userid}", "userid"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to find account based on userid from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void saveAccount() throws Exception {
        Mockito.when(this.loginRepository.save(any(LoginModel.class))).thenReturn(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0));
        mockMvc.perform(post("/v1/accounts/new/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully added account to db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void saveAccountFail() throws Exception {
        Mockito.when(this.loginRepository.save(any(LoginModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(post("/v1/accounts/new/"))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateAccountsById() throws Exception {
        Mockito.when(this.loginRepository.findById(anyInt())).thenReturn(Optional.of(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0)));
        Mockito.when(this.loginRepository.save(any(LoginModel.class))).thenReturn(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0));
        mockMvc.perform(put("/v1/accounts/{account_id}/", 2000000))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully updated account details in the db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void updateAccountsByIdfindByIdFail() throws Exception {
        Mockito.when(this.loginRepository.findById(anyInt())).thenReturn(null);
        // Mockito.when(this.loginRepository.save(any(LoginModel.class))).thenReturn(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0));
        mockMvc.perform(put("/v1/accounts/{account_id}/", 2000000))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Failed to find account based on account id from the db\",\"statusCode\":\"400\",\"status\":\"BAD REQUEST\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateAccountsByIdSaveFail() throws Exception {
        Mockito.when(this.loginRepository.findById(anyInt())).thenReturn(Optional.of(new LoginModel(2000000, "userid", "user_pass", "M", "email@gmail.com", 0, 0, 0, 0, null, "192.168.0.231", null, 0, "0000", 0, 0, 0, null, 0)));
        Mockito.when(this.loginRepository.save(any(LoginModel.class))).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/accounts/{account_id}/", 2000000))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void updateAccountsByIdFail() throws Exception {
        Mockito.when(this.loginRepository.findById(anyInt())).thenThrow(new RuntimeException());
        mockMvc.perform(put("/v1/accounts/{account_id}/", 2000000))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteAccountById() throws Exception {
        // Mockito.when(this.loginRepository.deleteById(2000000)).thenReturn(null);
        mockMvc.perform(delete("/v1/accounts/{account_id}/", 2000000))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Sucessfully deleted account\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteAccountByIdFail() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(this.loginRepository).deleteById(2000000);
        // Mockito.when(this.loginRepository.deleteById(2000000)).thenThrow(new RuntimeException());
        mockMvc.perform(delete("/v1/accounts/{account_id}/", 2000000))
        // .andExpect(content().string(containsString("{\"messsage\":\"API Message: Successfully updated account details in the db\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteAllAccounts() throws Exception {
        mockMvc.perform(delete("/v1/accounts/"))
        .andExpect(content().string(containsString("{\"messsage\":\"API Message: Sucessfully deleted all accounts\",\"statusCode\":\"200\",\"status\":\"SUCCESSFUL\"}")))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteAllAccountsFail() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(this.loginRepository).deleteAll();
        mockMvc.perform(delete("/v1/accounts/"))
        .andExpect(status().isBadRequest());
    }
}
