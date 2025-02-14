package com.ssebide.service;

import org.springframework.stereotype.Service;

import com.ssebide.modal.Chat;
import com.ssebide.repository.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatRepository chatRepository;

    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);

    }

}
