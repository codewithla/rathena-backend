package com.ragnarokonline.api.repository;

import java.util.Optional;

import com.ragnarokonline.api.model.CharacterModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterModel, Integer>{
    Optional<CharacterModel> getCharacterByName(String name);
}
