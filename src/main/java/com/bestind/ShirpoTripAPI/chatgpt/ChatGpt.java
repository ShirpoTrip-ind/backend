package com.bestind.ShirpoTripAPI.chatgpt;

import com.bestind.ShirpoTripAPI.config.ChatGptConfig;
import com.bestind.ShirpoTripAPI.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.ArrayList;
import java.util.List;

public class ChatGpt {
    private final ChatGptConfig extractTags;
    @Autowired
    ChatGpt(ChatGptConfig extractTags) {
        this.extractTags = extractTags;
    }

    public List<String> getTags(String text) {
        List<String> tags = new ArrayList<>();

        // получаем теги

        return tags;
    }
}
