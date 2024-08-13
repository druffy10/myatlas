package com.myatlas.controller;

import com.myatlas.dto.AIChatRequestDTO;
import com.myatlas.dto.AIChatResponseDTO;
import com.myatlas.service.AIChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class AIChatController {

    @Autowired
    private AIChatService aiChatService;

    @PostMapping("/message")
    public ResponseEntity<AIChatResponseDTO> processUserMessage(@RequestBody AIChatRequestDTO aiChatRequestDTO) {
        AIChatResponseDTO response = aiChatService.processUserMessage(aiChatRequestDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/generate-route")
    public ResponseEntity<AIChatResponseDTO> generateRoute(@RequestBody AIChatRequestDTO aiChatRequestDTO) {
        AIChatResponseDTO response = aiChatService.generateRoute(aiChatRequestDTO);
        return ResponseEntity.ok(response);
    }
}
