package com.tgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tgt.entity.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Integer>{
	@Query("SELECT c FROM Conversation c WHERE c.conversationId = :conversationId")
    List<Conversation> findAllByConId(Integer conversationId);
}
