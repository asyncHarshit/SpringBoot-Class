package com.example.gemini.controller;

import com.example.gemini.model.Chat;
import com.example.gemini.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final GeminiService geminiService;

    public ChatController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping
    public Chat chat(@RequestBody String query) {
        return geminiService.askGemini(query);
    }
}
