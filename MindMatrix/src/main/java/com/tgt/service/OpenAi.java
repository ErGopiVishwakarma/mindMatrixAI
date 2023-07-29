package com.tgt.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenAi implements IOpenAi{
	
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    @Value("${openai.apiKey}")
    private  String API_KEY;   

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
}
