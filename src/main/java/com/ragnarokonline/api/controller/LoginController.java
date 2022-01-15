package com.ragnarokonline.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.ragnarokonline.api.model.LoginModel;
import com.ragnarokonline.api.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/v1/accounts/")
@CrossOrigin(origins = { "http://localhost:3000", "http://snorlaxx-server.ddns.net:3000" })
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAccounts() {
        List<LoginModel> response = loginRepository.findAll();
        if (response.isEmpty()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("messsage", "API Message: Failed to retrieve accounts from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<?> getAccountsById(@PathVariable int account_id) {
        LoginModel response = loginRepository.findById(account_id).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("messsage", "API Message: Failed to retrieve account from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/username/{userid}")
    public ResponseEntity<?> getAccountsByUserName(@PathVariable String userid) {
        LoginModel response = loginRepository.getUserByUserid(userid).orElse(null);
        if (response == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("messsage", "API Message: Failed to find account based on userid from the db");
            return ResponseEntity.badRequest().body(map);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveAccount(@RequestBody LoginModel account) {
        try {
            loginRepository.save(account);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("messsage", "API Message: Successfully added account to db");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{account_id}")
    public ResponseEntity<?> updateAccountsById(@PathVariable int account_id, @RequestBody LoginModel account) {
        try {
            Optional<LoginModel> response = loginRepository.findById(account_id);
            if (!response.isPresent()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("statusCode", "400");
                map.put("status", "BAD REQUEST");
                map.put("messsage", "API Message: Failed to find account based on account id from the db");
                return ResponseEntity.badRequest().body(map);
            } else {
                LoginModel accountData = response.get();
                if (account.getBirthdate() != null) {
                    accountData.setBirthdate(account.getBirthdate());
                }
                if (account.getCharacter_slots() != 0) {
                    accountData.setCharacter_slots(account.getCharacter_slots());
                }
                if (account.getEmail() != null) {
                    accountData.setEmail(account.getEmail());
                }
                if (account.getGroup_id() != 0) {
                    accountData.setGroup_id(account.getGroup_id());
                }
                if (account.getLast_ip() != null) {
                    accountData.setLast_ip(account.getLast_ip());
                }
                if (account.getLastlogin() != null) {
                    accountData.setLastlogin(account.getLastlogin());
                }
                if (account.getLogincount() != 0) {
                    accountData.setLogincount(account.getLogincount());
                }
                if (account.getOld_group() != 0) {
                    account.setOld_group(account.getOld_group());
                }
                if (account.getPincode() != null) {
                    accountData.setPincode(account.getPincode());
                }
                if (account.getPincode_change() != 0) {
                    accountData.setPincode_change(account.getPincode_change());
                }
                if (account.getSex() != null) {
                    accountData.setSex(account.getSex());
                }
                if (account.getState() != 0) {
                    accountData.setState(account.getState());
                }
                if (account.getUnban_time() != 0) {
                    accountData.setUnban_time(account.getUnban_time());
                }
                if (account.getUser_pass() != null) {
                    accountData.setUser_pass(account.getUser_pass());
                }
                if (account.getUserid() != null) {
                    accountData.setUserid(account.getUserid());
                }
                if (account.getVip_time() != 0) {
                    accountData.setVip_time(account.getVip_time());
                }
                if (account.getWeb_auth_token() != null) {
                    accountData.setWeb_auth_token(account.getWeb_auth_token());
                }
                if (account.getWeb_auth_token_enabled() != 0)
                    accountData.setWeb_auth_token_enabled(account.getWeb_auth_token_enabled());
                try {
                    loginRepository.save(accountData);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("statusCode", "200");
                    map.put("status", "SUCCESSFUL");
                    map.put("messsage", "API Message: Successfully updated account details in the db");
                    return ResponseEntity.ok(map);
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body(e);
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{account_id}")
    public ResponseEntity<?> deleteAccountById(@PathVariable int account_id) {
        try {
            loginRepository.deleteById(account_id);
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("messsage", "API Message: Sucessfully deleted account");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("messsage", "API Message: Failed to delete account with account_id");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllAccounts() {
        try {
            loginRepository.deleteAll();
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "200");
            map.put("status", "SUCCESSFUL");
            map.put("messsage", "API Message: Sucessfully deleted all accounts");
            return ResponseEntity.ok(map);

        } catch (Exception e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("statusCode", "400");
            map.put("status", "BAD REQUEST");
            map.put("messsage", "API Message: Failed to all accounts");
            map.put("errorMessage", "Error Message: " + e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

}
