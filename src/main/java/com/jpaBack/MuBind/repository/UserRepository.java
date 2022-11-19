package com.jpaBack.MuBind.repository;



import com.jpaBack.MuBind.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//유저 리포지토리
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}