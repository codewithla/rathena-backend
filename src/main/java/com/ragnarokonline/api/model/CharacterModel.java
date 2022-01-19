package com.ragnarokonline.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "char")
public class CharacterModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int char_id;
    private int account_id;
    private int char_num;
    private String name;
    @Column(name = "class")
    private int charClass;
    private int base_level;
    private int job_level;
    private int base_exp;
    private int job_exp;
    private int zeny;
    private int str;
    private int agi;
    private int vit;
    @Column(name = "int")
    private int inte;
    private int dex;
    private int luk;
    private int max_hp;
    private int hp;
    private int max_sp;
    private int sp;
    private int status_point;
    private int skill_point;
    private int option;
    private int karma;
    private int manner;
    private int party_id;
    private int guild_id;
    private int pet_id;
    private int homun_id;
    private int elemental_id;
    private int hair;
    private int hair_color;
    private int clothes_color;
    private int body;
    private int weapon;
    private int shield;
    private int head_top;
    private int head_mid;
    private int head_bottom;
    private int robe;
    private String last_map;
    private int last_x;
    private int last_y;
    private String save_map;
    private int save_x;
    private int save_y;
    private int partner_id;
    private int online;
    private int father;
    private int mother;
    private int child;
    private int fame;
    private int rename;
    private int delete_date;
    private int moves;
    private int unban_time;
    private int font;
    private int uniqueitem_counter;
    private String sex;
    private int hotkey_rowshift;
    private int hotkey_rowshift2;
    private int clan_id;
    private Date last_login = null;
    private int title_id;
    private int show_equip;

    public CharacterModel() {}

    public CharacterModel(int char_id, int account_id, int char_num, String name, int charClass, int base_level,
            int job_level, int base_exp, int job_exp, int zeny, int str, int agi, int vit, int inte, int dex, int luk,
            int max_hp, int hp, int max_sp, int sp, int status_point, int skill_point, int option, int karma,
            int manner, int party_id, int guild_id, int pet_id, int homun_id, int elemental_id, int hair,
            int hair_color, int clothes_color, int body, int weapon, int shield, int head_top, int head_mid,
            int head_bottom, int robe, String last_map, int last_x, int last_y, String save_map, int save_x, int save_y,
            int partner_id, int online, int father, int mother, int child, int fame, int rename, int delete_date,
            int moves, int unban_time, int font, int uniqueitem_counter, String sex, int hotkey_rowshift,
            int hotkey_rowshift2, int clan_id, Date last_login, int title_id, int show_equip) {
        this.char_id = char_id;
        this.account_id = account_id;
        this.char_num = char_num;
        this.name = name;
        this.charClass = charClass;
        this.base_level = base_level;
        this.job_level = job_level;
        this.base_exp = base_exp;
        this.job_exp = job_exp;
        this.zeny = zeny;
        this.str = str;
        this.agi = agi;
        this.vit = vit;
        this.inte = inte;
        this.dex = dex;
        this.luk = luk;
        this.max_hp = max_hp;
        this.hp = hp;
        this.max_sp = max_sp;
        this.sp = sp;
        this.status_point = status_point;
        this.skill_point = skill_point;
        this.option = option;
        this.karma = karma;
        this.manner = manner;
        this.party_id = party_id;
        this.guild_id = guild_id;
        this.pet_id = pet_id;
        this.homun_id = homun_id;
        this.elemental_id = elemental_id;
        this.hair = hair;
        this.hair_color = hair_color;
        this.clothes_color = clothes_color;
        this.body = body;
        this.weapon = weapon;
        this.shield = shield;
        this.head_top = head_top;
        this.head_mid = head_mid;
        this.head_bottom = head_bottom;
        this.robe = robe;
        this.last_map = last_map;
        this.last_x = last_x;
        this.last_y = last_y;
        this.save_map = save_map;
        this.save_x = save_x;
        this.save_y = save_y;
        this.partner_id = partner_id;
        this.online = online;
        this.father = father;
        this.mother = mother;
        this.child = child;
        this.fame = fame;
        this.rename = rename;
        this.delete_date = delete_date;
        this.moves = moves;
        this.unban_time = unban_time;
        this.font = font;
        this.uniqueitem_counter = uniqueitem_counter;
        this.sex = sex;
        this.hotkey_rowshift = hotkey_rowshift;
        this.hotkey_rowshift2 = hotkey_rowshift2;
        this.clan_id = clan_id;
        this.last_login = last_login;
        this.title_id = title_id;
        this.show_equip = show_equip;
    }

    public int getChar_id() {
        return char_id;
    }

    public void setChar_id(int char_id) {
        this.char_id = char_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getChar_num() {
        return char_num;
    }

    public void setChar_num(int char_num) {
        this.char_num = char_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharClass() {
        return charClass;
    }

    public void setCharClass(int charClass) {
        this.charClass = charClass;
    }

    public int getBase_level() {
        return base_level;
    }

    public void setBase_level(int base_level) {
        this.base_level = base_level;
    }

    public int getJob_level() {
        return job_level;
    }

    public void setJob_level(int job_level) {
        this.job_level = job_level;
    }

    public int getBase_exp() {
        return base_exp;
    }

    public void setBase_exp(int base_exp) {
        this.base_exp = base_exp;
    }

    public int getJob_exp() {
        return job_exp;
    }

    public void setJob_exp(int job_exp) {
        this.job_exp = job_exp;
    }

    public int getZeny() {
        return zeny;
    }

    public void setZeny(int zeny) {
        this.zeny = zeny;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getLuk() {
        return luk;
    }

    public void setLuk(int luk) {
        this.luk = luk;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMax_sp() {
        return max_sp;
    }

    public void setMax_sp(int max_sp) {
        this.max_sp = max_sp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getStatus_point() {
        return status_point;
    }

    public void setStatus_point(int status_point) {
        this.status_point = status_point;
    }

    public int getSkill_point() {
        return skill_point;
    }

    public void setSkill_point(int skill_point) {
        this.skill_point = skill_point;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public int getManner() {
        return manner;
    }

    public void setManner(int manner) {
        this.manner = manner;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public int getGuild_id() {
        return guild_id;
    }

    public void setGuild_id(int guild_id) {
        this.guild_id = guild_id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public int getHomun_id() {
        return homun_id;
    }

    public void setHomun_id(int homun_id) {
        this.homun_id = homun_id;
    }

    public int getElemental_id() {
        return elemental_id;
    }

    public void setElemental_id(int elemental_id) {
        this.elemental_id = elemental_id;
    }

    public int getHair() {
        return hair;
    }

    public void setHair(int hair) {
        this.hair = hair;
    }

    public int getHair_color() {
        return hair_color;
    }

    public void setHair_color(int hair_color) {
        this.hair_color = hair_color;
    }

    public int getClothes_color() {
        return clothes_color;
    }

    public void setClothes_color(int clothes_color) {
        this.clothes_color = clothes_color;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getHead_top() {
        return head_top;
    }

    public void setHead_top(int head_top) {
        this.head_top = head_top;
    }

    public int getHead_mid() {
        return head_mid;
    }

    public void setHead_mid(int head_mid) {
        this.head_mid = head_mid;
    }

    public int getHead_bottom() {
        return head_bottom;
    }

    public void setHead_bottom(int head_bottom) {
        this.head_bottom = head_bottom;
    }

    public int getRobe() {
        return robe;
    }

    public void setRobe(int robe) {
        this.robe = robe;
    }

    public String getLast_map() {
        return last_map;
    }

    public void setLast_map(String last_map) {
        this.last_map = last_map;
    }

    public int getLast_x() {
        return last_x;
    }

    public void setLast_x(int last_x) {
        this.last_x = last_x;
    }

    public int getLast_y() {
        return last_y;
    }

    public void setLast_y(int last_y) {
        this.last_y = last_y;
    }

    public String getSave_map() {
        return save_map;
    }

    public void setSave_map(String save_map) {
        this.save_map = save_map;
    }

    public int getSave_x() {
        return save_x;
    }

    public void setSave_x(int save_x) {
        this.save_x = save_x;
    }

    public int getSave_y() {
        return save_y;
    }

    public void setSave_y(int save_y) {
        this.save_y = save_y;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public int getMother() {
        return mother;
    }

    public void setMother(int mother) {
        this.mother = mother;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getFame() {
        return fame;
    }

    public void setFame(int fame) {
        this.fame = fame;
    }

    public int getRename() {
        return rename;
    }

    public void setRename(int rename) {
        this.rename = rename;
    }

    public int getDelete_date() {
        return delete_date;
    }

    public void setDelete_date(int delete_date) {
        this.delete_date = delete_date;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getUnban_time() {
        return unban_time;
    }

    public void setUnban_time(int unban_time) {
        this.unban_time = unban_time;
    }

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }

    public int getUniqueitem_counter() {
        return uniqueitem_counter;
    }

    public void setUniqueitem_counter(int uniqueitem_counter) {
        this.uniqueitem_counter = uniqueitem_counter;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHotkey_rowshift() {
        return hotkey_rowshift;
    }

    public void setHotkey_rowshift(int hotkey_rowshift) {
        this.hotkey_rowshift = hotkey_rowshift;
    }

    public int getHotkey_rowshift2() {
        return hotkey_rowshift2;
    }

    public void setHotkey_rowshift2(int hotkey_rowshift2) {
        this.hotkey_rowshift2 = hotkey_rowshift2;
    }

    public int getClan_id() {
        return clan_id;
    }

    public void setClan_id(int clan_id) {
        this.clan_id = clan_id;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    public int getShow_equip() {
        return show_equip;
    }

    public void setShow_equip(int show_equip) {
        this.show_equip = show_equip;
    }

       
}