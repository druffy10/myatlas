package com.myatlas.service;

import com.myatlas.dto.AIChatRequestDTO;
import com.myatlas.dto.AIChatResponseDTO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AIChatService {

    private final RestTemplate restTemplate;

    private static final String AI_API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "YOUR_API_KEY_HERE";

    public AIChatService() {
        this.restTemplate = new RestTemplate();
    }

    public String getAIResponse(String userInput) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4");
        requestBody.put("prompt", userInput);
        requestBody.put("max_tokens", 150);
        requestBody.put("temperature", 0.7);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        Map<String, Object> response = restTemplate.postForObject(AI_API_URL, entity, Map.class);

        String aiResponse = (String) ((Map<String, Object>) ((List<Object>) response.get("choices")).get(0)).get("text");

        return aiResponse.trim();
    }

    public AIChatResponseDTO processUserMessage(AIChatRequestDTO aiChatRequestDTO) {
        String aiResponse = getAIResponse(aiChatRequestDTO.getMessage());
        return new AIChatResponseDTO(aiResponse, true);
    }

    public AIChatResponseDTO generateRoute(AIChatRequestDTO aiChatRequestDTO) {
        String aiResponse = "Generated route based on input: " + aiChatRequestDTO.getMessage();
        return new AIChatResponseDTO(aiResponse, true);
    }

}
