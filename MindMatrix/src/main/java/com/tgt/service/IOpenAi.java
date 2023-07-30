package com.tgt.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.tgt.entity.Chat;
import com.tgt.entity.Conversation;
import com.tgt.entity.Users;
import com.tgt.model.Prompts;
import com.tgt.model.Recommendation;
import com.tgt.model.RegForm;

import jakarta.servlet.http.HttpSession;

public interface IOpenAi {
	CompletableFuture<String> generate(String promptInput);
	
	String newAi(Prompts prompts , HttpSession session);

    Users signInSignUp(RegForm user);
    Users getUserById(Integer userId);
    
    Chat createChatForUser(Integer userId);
    Chat getChatByChatId(Integer chatId);
    List<Chat> getChatListByChatId(Integer chatId);
    List<Chat> getAllChatsForUser(Integer userId);
    
    Conversation startInterview(Integer userId, Prompts prompts , HttpSession session);
    Conversation countinueInterview(Integer userId, Prompts prompts , HttpSession session);
    
    Conversation getConversationBYId(Integer convId);
    List<Conversation> getAllConversationsInChat(Integer userId);
    Prompts stopInterviewAndGetScore(Integer userId, HttpSession session);
}
