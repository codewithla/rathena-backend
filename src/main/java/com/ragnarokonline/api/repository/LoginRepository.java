package com.ragnarokonline.api.repository;

import java.util.Optional;

import com.ragnarokonline.api.model.LoginModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
    Optional<LoginModel> getUserByUserid(String userid);
    Optional<LoginModel> getUserByEmail (String email);
}
