package com.tgt.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgt.entity.Chat;
import com.tgt.entity.Conversation;
import com.tgt.entity.Users;
import com.tgt.model.Prompts;
import com.tgt.model.Recommendation;
import com.tgt.model.RegForm;
import com.tgt.service.OpenAi;

import jakarta.servlet.http.HttpSession;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mindmatrix")
public class GPT3Controller {

	@Autowired
    OpenAi openAi;
	
	@PostMapping("/generate-text-newAi")
    public Prompts newAi(@RequestBody Prompts prompts ,HttpSession session ){  
		
		String newAi = openAi.newAi(prompts , session);
    	return  new Prompts(newAi);
    }
	
	
    @PostMapping("/generate-text")
    public String generateText(@RequestBody Prompts prompts ) throws InterruptedException, ExecutionException {    
    	// The JSON-formatted string
//    	String[] inputString = openAi.generate(prompts.getPrompt()).get().split(":");
//    	String[] split = inputString[9].split("}");
//    	return new Prompts(split[0]);
    	return openAi.generate(prompts.getPrompt()).get();
    	
    }
    
    
   
    @PostMapping("/sign-in-sign-up")
    public ResponseEntity<Users> signInSignUp(@RequestBody RegForm user) throws InterruptedException, ExecutionException{
        Users createdUser = openAi.signInSignUp(user);
        if (createdUser != null) {
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer userId) {
        Users user = openAi.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create-chat/{userId}")
    public ResponseEntity<Chat> createChatForUser(@PathVariable Integer userId) {
        Chat chat = openAi.createChatForUser(userId);
        if (chat != null) {
            return ResponseEntity.ok(chat);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-chat/{chatId}")
    public ResponseEntity<Chat> getChatByChatId(@PathVariable Integer chatId) {
        Chat chat = openAi.getChatByChatId(chatId);
        if (chat != null) {
            return ResponseEntity.ok(chat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all-chats/{userId}")
    public ResponseEntity<List<Chat>> getAllChatsForUser(@PathVariable Integer userId) {
        List<Chat> chats = openAi.getAllChatsForUser(userId);
        return ResponseEntity.ok(chats);
    }

    @PostMapping("/{userId}/start-interview")
    public ResponseEntity<Conversation> startInterview(@PathVariable Integer userId, @RequestBody Prompts prompts , HttpSession session) {
        Conversation conversation = openAi.startInterview(userId, prompts,session);
        if (conversation != null) {
            return ResponseEntity.ok(conversation);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{convId}/get-conversation")
    public ResponseEntity<Conversation> getConversationById(@PathVariable Integer convId) {
        Conversation conversation = openAi.getConversationBYId(convId);
        if (conversation != null) {
            return ResponseEntity.ok(conversation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userId}/get-all-conversations")
    public ResponseEntity<List<Conversation>> getAllConversationsInChat(@PathVariable Integer userId) {
        List<Conversation> conversations = openAi.getAllConversationsInChat(userId);
        return ResponseEntity.ok(conversations);
    }

    @GetMapping("/{userId}/stop-interview")
    public Prompts  stopInterviewAndGetScore(@PathVariable Integer userId , HttpSession session) {
         Prompts stopInterviewAndGetScore = openAi.stopInterviewAndGetScore(userId,session);
        if (stopInterviewAndGetScore != null) {
            return openAi.stopInterviewAndGetScore(userId,session);
        } else {
            return null;
        }
    }
    
    @GetMapping("/{chatId}/continue")
    Conversation countinueInterview(Integer chatId, Prompts prompts , HttpSession session) {
    	
    	Conversation conversation = openAi.countinueInterview(chatId,prompts,session);
    	

    	if (conversation != null) {
            return conversation;
        }        
    	return null;
    
    }
    	
}