package com.tgt.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tgt.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByEmail(String email);
}
