package com.example.gemini.service;

import com.example.gemini.model.Chat;
import com.example.gemini.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final ChatRepository chatRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public GeminiService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat askGemini(String userQuery) {

        String geminiAnswer = callGemini(userQuery);

        Chat chat = new Chat();
        chat.setUserQuery(userQuery);
        chat.setGeminiResponse(geminiAnswer);

        return chatRepository.save(chat);
    }

    private String callGemini(String prompt) {

        String url =
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key="
                        + apiKey;

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, entity, Map.class);

        try {
            Map candidate = (Map) ((List<?>) response.getBody()
                    .get("candidates")).get(0);
            Map content = (Map) candidate.get("content");
            Map part = (Map) ((List<?>) content.get("parts")).get(0);
            return part.get("text").toString();
        } catch (Exception e) {
            return "Error from Gemini";
        }
    }
}
