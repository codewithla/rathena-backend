package com.ragnarokonline.api.repository;

import java.util.Optional;

import com.ragnarokonline.api.model.GuildMemberModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuildMemberRepository extends JpaRepository<GuildMemberModel, Integer>{
    Optional<GuildMemberModel> getGuildMemberByCharId(int charId);
    Optional<GuildMemberModel> deleteGuildMemberByCharId(int charId);
}
