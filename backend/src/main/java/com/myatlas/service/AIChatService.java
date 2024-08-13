package com.myatlas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AIChatService {

    private final RestTemplate restTemplate;

    // URL API для взаимодействия с AI (например, GPT-4 API)
    private static final String AI_API_URL = "https://api.openai.com/v1/completions";

    // API ключ для доступа к AI сервису
    private static final String API_KEY = "YOUR_API_KEY_HERE";

    public AIChatService() {
        this.restTemplate = new RestTemplate();
    }

    public String getAIResponse(String userInput) {
        // Создаем параметры запроса
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4");
        requestBody.put("prompt", userInput);
        requestBody.put("max_tokens", 150);
        requestBody.put("temperature", 0.7);

        // Устанавливаем заголовки
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + API_KEY);
        headers.put("Content-Type", "application/json");

        // Отправляем запрос и получаем ответ
        Map<String, Object> response = restTemplate.postForObject(
                AI_API_URL,
                new HttpEntity<>(requestBody, new HttpHeaders(headers)),
                Map.class
        );

        // Извлекаем текст из ответа
        String aiResponse = (String) ((Map<String, Object>) ((List<Object>) response.get("choices")).get(0)).get("text");

        return aiResponse.trim();
    }
}
