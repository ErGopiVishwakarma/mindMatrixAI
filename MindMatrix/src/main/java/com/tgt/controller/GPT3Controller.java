package com.tgt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgt.model.Chat;
import com.tgt.model.Conversation;
import com.tgt.model.Prompts;
import com.tgt.model.RegForm;
import com.tgt.model.Users;
import com.tgt.service.OpenAi;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mindmatrix")
public class GPT3Controller {

	@Autowired
    OpenAi openAi;

    @PostMapping("/generate-text")
    public Prompts generateText(@RequestBody Prompts prompts ) throws InterruptedException, ExecutionException {    
    	// The JSON-formatted string
    	String[] inputString = openAi.generate(prompts.getPrompt()).get().split(":");
    	String[] split = inputString[9].split("}");
    	return new Prompts(split[0]);
    }
    
    @GetMapping("/user")
    public ResponseEntity<Users> generateText() {    	
    	
    	return null;
    }
    
    
    
    @PostMapping("/signup")
    public Users createUser(@RequestBody RegForm user) {
        // Implement the logic to create a new user and return the created user object.
        return null;
    }
    
    @PostMapping("/signin")
    public Users loginUser(@RequestBody RegForm user) {
        // Implement the logic to create a new user and return the created user object.
        return null;
    }
    

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable long userId) {
        // Implement the logic to retrieve a user by their ID and return the user object.
        Users user = null /* ... */;
        return user;
    }

    @PostMapping("/{userId}/chats")
    public Chat createChatForUser(@PathVariable long userId, @RequestBody Chat chat) {
        // Implement the logic to create a new chat for the specified user and return the created chat object.
        return chat;
    }

    @GetMapping("/{userId}/chats")
    public List<Chat> getAllChatsForUser(@PathVariable long userId) {
        // Implement the logic to retrieve all chats for the specified user and return a list of chat objects.
        List<Chat> chats = null;
        return chats;
    }

    @PostMapping("/{userId}/chats/{chatId}/conversations")
    public Conversation addConversationToChat(@PathVariable long userId, @PathVariable long chatId,
                                              @RequestBody Conversation conversation) {
        // Implement the logic to add a new conversation to the specified chat for the given user.
        return conversation;
    }

    @GetMapping("/{userId}/chats/{chatId}/conversations")
    public List<Conversation> getAllConversationsInChat(@PathVariable long userId, @PathVariable long chatId) {
        // Implement the logic to retrieve all conversations in the specified chat for the given user.
        List<Conversation> conversations = null;
        return conversations;
    }
    
}

