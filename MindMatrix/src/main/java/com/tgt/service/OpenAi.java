package com.tgt.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tgt.entity.Chat;
import com.tgt.entity.Conversation;
import com.tgt.entity.Users;
import com.tgt.model.ChatRequest;
import com.tgt.model.ChatResponse;
import com.tgt.model.Message;
import com.tgt.model.Prompts;
import com.tgt.model.Recommendation;
import com.tgt.model.RegForm;
import com.tgt.repository.ChatRepository;
import com.tgt.repository.ConversationRepository;
import com.tgt.repository.UsersRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class OpenAi implements IOpenAi{
	@Autowired
	ChatRepository chatRepo;
	@Autowired
	UsersRepository userRepo;
	@Autowired
	ConversationRepository conRepo;
	@Autowired
    private RestTemplate restTemplate;
	
	private String model = "gpt-3.5-turbo";
	
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    @Value("${openai.apiKey}")
    private  String API_KEY;
    
    @Override
	public String newAi(Prompts prompt, HttpSession session) {
//    	String id = session.getId();
		// TODO Auto-generated method stub
    
    	@SuppressWarnings("unchecked")
		List<Message> chatHistory = (List<Message>) session.getAttribute("chatHistory");
        if (chatHistory == null) {
            chatHistory = new ArrayList<>();
        }
        
        chatHistory.add(new Message("user", prompt.getPrompt()));

       
        ChatRequest request = new ChatRequest(model, chatHistory);
      
        ChatResponse response = restTemplate.postForObject(API_URL, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response from the side";
        }

       
        String reply = response.getChoices().get(0).getMessage().getContent();
        
      
        session.setAttribute("chatHistory" , chatHistory);

        return reply;
	} 

    public CompletableFuture<String> generate(String promptInput) {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = null;
        try {
            URI uri = new URI(API_URL);
            String requestBody = "{\"model\": \"gpt-3.5-turbo\",\"messages\": [{\"role\": \"user\",\"content\": \""
                    + promptInput + "\"}]}";

            request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            CompletableFuture<String> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }

        return httpClient.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(throwable -> {
                    System.err.println("Error: " + throwable.getMessage());
                    return "Error occurred while generating.";
                });
    }

	@Override
	public Users signInSignUp(RegForm user) {
		// TODO Auto-generated method stub
		 Optional<Users> findByEmail = userRepo.findByEmail(user.getEmail());
		if (findByEmail.isEmpty()) return userRepo.save(new Users(null, null, user.getEmail(), user.getPassword(), user.getImageUrl(),null));
		return findByEmail.get();
	}

	
	@Override
	public Users getUserById(Integer userId) {
		Optional<Users> findById = userRepo.findById(userId);
		if (findById.isEmpty()) return null;
		return findById.get();
	}
	
	@Override
	public Chat createChatForUser(Integer userId) {

		// TODO Auto-generated method stub
		Users users = userRepo.findById(userId).get();
		 if (users == null) return null;
		Chat chat = new Chat();
		chat.setUserId(userId);
		return chatRepo.save(chat);

	}
	

	@Override
	public Chat getChatByChatId(Integer chatId) {

		// TODO Auto-generated method stub
		return chatRepo.findById(chatId).get();
	}

	
	@Override
	public List<Chat> getChatListByChatId(Integer chatId) {
		
		Optional<Chat> findById = chatRepo.findById(chatId);
		if (findById.isEmpty()) return null;

		return null;
	}

	
	@Override	
	public List<Chat> getAllChatsForUser(Integer chatId) {
		// TODO Auto-generated method stub
		List<Chat> findAllByChatId = chatRepo.findAllByChatId(chatId);
		if (findAllByChatId.isEmpty()) return null;
		return findAllByChatId;
	}
	

	@Override
	public Conversation startInterview(Integer userId,  Prompts prompts,  HttpSession session) {

		Users users = userRepo.findById(userId).get();

	    Chat chats = new Chat();
	    Chat chat = chatRepo.save(chats);
	    
	    String interviewPrompt = Prompts.getInterviewPrompt(prompts.getPrompt());
//	    generate(interviewPrompt);
	    Conversation conversation = new Conversation();
	    conversation.setBotReply(newAi(new Prompts(interviewPrompt),session));
	    conversation.setUserReply(prompts.getPrompt());

	    // Ensure conversationsId is initialized as an empty list
	    if (chat.getConversationsId() == null) {
	        chat.setConversationsId(new ArrayList<>());
	    }

	    users.getChatsId().add(chat.getChatId());
//	    conRepo.save(conversation);
	    chat.getConversationsId().add(conversation.getConversationId());
//	    conRepo.save(conversation);
//	    chatRepo.save(chat);
//	    userRepo.save(users);

	    return conversation;
	}
	
	@Override
	public Conversation getConversationBYId(Integer convId) {
		// TODO Auto-generated method stub
		Optional<Conversation> findById = conRepo.findById(convId);
		if (findById.isEmpty()) return null;
		return findById.get();
	}
	

	@Override
	public List<Conversation> getAllConversationsInChat(Integer conId) {
		// TODO Auto-generated method stub
		List<Conversation> findAllByConId = conRepo.findAllByConId(conId);
		if (findAllByConId.isEmpty()) return null;
		return findAllByConId;
	}
	

	@Override
	public Prompts stopInterviewAndGetScore(Integer chatId , HttpSession session) {
		// TODO Auto-generated method stub
	
	    return new Prompts(newAi(new Prompts("Stop The Interview and give the feedaback and end the interview"),session));

	}
	@Override
	public Conversation countinueInterview(Integer chatId, Prompts prompts , HttpSession session)  {
		if (session == null) {
	        // Handle the case when the session is null
	        // You might want to log an error or throw an exception based on your use case
	        return null;
	    }

	    Chat chat2 = chatRepo.findById(chatId).orElse(null);
	    if (chat2 == null) {
	        // Handle the case when the chat with the given chatId is not found
	        return null;
	    }

	    Users users = userRepo.findById(chat2.getUserId()).orElse(null);
	    if (users == null) {
	        // Handle the case when the user associated with the chat is not found
	        return null;
	    }

	    Chat chats = new Chat();
	    Chat chat = chatRepo.save(chats);

	    String interviewPrompt = Prompts.getInterviewPrompt(prompts.getPrompt());
	    Conversation conversation = new Conversation();
	    conversation.setBotReply(newAi(prompts, session)); // Pass the session to newAi method
	    conversation.setUserReply(prompts.getPrompt());

	    // Ensure conversationsId is initialized as an empty list
	    if (chat.getConversationsId() == null) {
	        chat.setConversationsId(new ArrayList<>());
	    }

	    users.getChatsId().add(chat.getChatId());
//	    conRepo.save(conversation);
	    chat.getConversationsId().add(conversation.getConversationId());
//	    chatRepo.save(chat);
//	    userRepo.save(users);

	    return conversation;

	}
  
}
