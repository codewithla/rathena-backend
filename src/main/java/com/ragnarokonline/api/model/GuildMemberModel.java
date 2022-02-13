package com.ragnarokonline.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guild_member")
public class GuildMemberModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guild_id;
    @Column(name = "char_id")
    private int charId;
    private int exp;
    private int position;
    
    public GuildMemberModel() {}

    public GuildMemberModel(int guild_id, int charId, int exp, int position) {
        this.guild_id = guild_id;
        this.charId = charId;
        this.exp = exp;
        this.position = position;
    }

    public int getGuild_id() {
        return guild_id;
    }

    public void setGuild_id(int guild_id) {
        this.guild_id = guild_id;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    
}
