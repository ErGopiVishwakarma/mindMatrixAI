package com.tgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tgt.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
	
	@Query("SELECT c FROM Chat c WHERE c.chatId = :chatId")
    List<Chat> findAllByChatId(Integer chatId);
}
