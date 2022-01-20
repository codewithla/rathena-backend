package com.ragnarokonline.api.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guild")
public class GuildModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guild_id;
    private String name;
    @Column(name = "char_id")
    private int charId;
    private String master;
    private int guild_lv;
    private int connect_member;
    private int max_member;
    private int average_lv;
    private int exp;
    private int next_exp;
    private int skill_point;
    private String mes1;
    private String mes2;
    private int emblem_len;
    private int emblem_id;
    private Blob emblem_data;
    private Date last_master_change;

    public GuildModel() {};

    public GuildModel(int guild_id, String name, int charId, String master, int guild_lv, int connect_member,
            int max_member, int average_lv, int exp, int next_exp, int skill_point, String mes1, String mes2,
            int emblem_len, int emblem_id, Blob emblem_data, Date last_master_change) {
        this.guild_id = guild_id;
        this.name = name;
        this.charId = charId;
        this.master = master;
        this.guild_lv = guild_lv;
        this.connect_member = connect_member;
        this.max_member = max_member;
        this.average_lv = average_lv;
        this.exp = exp;
        this.next_exp = next_exp;
        this.skill_point = skill_point;
        this.mes1 = mes1;
        this.mes2 = mes2;
        this.emblem_len = emblem_len;
        this.emblem_id = emblem_id;
        this.emblem_data = emblem_data;
        this.last_master_change = last_master_change;
    }

    public int getGuild_id() {
        return guild_id;
    }

    public void setGuild_id(int guild_id) {
        this.guild_id = guild_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public int getGuild_lv() {
        return guild_lv;
    }

    public void setGuild_lv(int guild_lv) {
        this.guild_lv = guild_lv;
    }

    public int getConnect_member() {
        return connect_member;
    }

    public void setConnect_member(int connect_member) {
        this.connect_member = connect_member;
    }

    public int getMax_member() {
        return max_member;
    }

    public void setMax_member(int max_member) {
        this.max_member = max_member;
    }

    public int getAverage_lv() {
        return average_lv;
    }

    public void setAverage_lv(int average_lv) {
        this.average_lv = average_lv;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNext_exp() {
        return next_exp;
    }

    public void setNext_exp(int next_exp) {
        this.next_exp = next_exp;
    }

    public int getSkill_point() {
        return skill_point;
    }

    public void setSkill_point(int skill_point) {
        this.skill_point = skill_point;
    }

    public String getMes1() {
        return mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    public String getMes2() {
        return mes2;
    }

    public void setMes2(String mes2) {
        this.mes2 = mes2;
    }

    public int getEmblem_len() {
        return emblem_len;
    }

    public void setEmblem_len(int emblem_len) {
        this.emblem_len = emblem_len;
    }

    public int getEmblem_id() {
        return emblem_id;
    }

    public void setEmblem_id(int emblem_id) {
        this.emblem_id = emblem_id;
    }

    public Blob getEmblem_data() {
        return emblem_data;
    }

    public void setEmblem_data(Blob emblem_data) {
        this.emblem_data = emblem_data;
    }

    public Date getLast_master_change() {
        return last_master_change;
    }

    public void setLast_master_change(Date last_master_change) {
        this.last_master_change = last_master_change;
    }

}
