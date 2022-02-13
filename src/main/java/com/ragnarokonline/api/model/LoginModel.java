package com.ragnarokonline.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;
    private String userid;
    private String user_pass;
    private String sex;
    private String email;
    private int group_id;
    private int state;
    private int unban_time;
    private int logincount;
    // @Column(name = "last_login")
    private Date lastlogin;
    private String last_ip;
    private Date birthdate;
    private int character_slots;
    private String pincode;
    private int pincode_change;
    private int vip_time;
    private int old_group;
    private String web_auth_token;
    private int web_auth_token_enabled;

    public LoginModel() {

    }

    public LoginModel(int account_id, String userid, String user_pass, String sex, String email, int group_id,
            int state, int unban_time, int logincount, Date lastlogin, String last_ip, Date birthdate,
            int character_slots, String pincode, int pincode_change, int vip_time, int old_group, String web_auth_token,
            int web_auth_token_enabled) {
        this.account_id = account_id;
        this.userid = userid;
        this.user_pass = user_pass;
        this.sex = sex;
        this.email = email;
        this.group_id = group_id;
        this.state = state;
        this.unban_time = unban_time;
        this.logincount = logincount;
        this.lastlogin = lastlogin;
        this.last_ip = last_ip;
        this.birthdate = birthdate;
        this.character_slots = character_slots;
        this.pincode = pincode;
        this.pincode_change = pincode_change;
        this.vip_time = vip_time;
        this.old_group = old_group;
        this.web_auth_token = web_auth_token;
        this.web_auth_token_enabled = web_auth_token_enabled;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUnban_time() {
        return unban_time;
    }

    public void setUnban_time(int unban_time) {
        this.unban_time = unban_time;
    }

    public int getLogincount() {
        return logincount;
    }

    public void setLogincount(int logincount) {
        this.logincount = logincount;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getCharacter_slots() {
        return character_slots;
    }

    public void setCharacter_slots(int character_slots) {
        this.character_slots = character_slots;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getPincode_change() {
        return pincode_change;
    }

    public void setPincode_change(int pincode_change) {
        this.pincode_change = pincode_change;
    }

    public int getVip_time() {
        return vip_time;
    }

    public void setVip_time(int vip_time) {
        this.vip_time = vip_time;
    }

    public int getOld_group() {
        return old_group;
    }

    public void setOld_group(int old_group) {
        this.old_group = old_group;
    }

    public String getWeb_auth_token() {
        return web_auth_token;
    }

    public void setWeb_auth_token(String web_auth_token) {
        this.web_auth_token = web_auth_token;
    }

    public int getWeb_auth_token_enabled() {
        return web_auth_token_enabled;
    }

    public void setWeb_auth_token_enabled(int web_auth_token_enabled) {
        this.web_auth_token_enabled = web_auth_token_enabled;
    }
}
