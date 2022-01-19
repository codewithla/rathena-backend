package com.ragnarokonline.api.repository;

import java.util.Optional;

import com.ragnarokonline.api.model.GuildModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuildRepository extends JpaRepository<GuildModel, Integer>{
    Optional<GuildModel> getGuildByCharId(int charId);
    Optional<GuildModel> getGuildByName(String name);
    Optional<GuildModel> getGuildByMaster(String master);
}
