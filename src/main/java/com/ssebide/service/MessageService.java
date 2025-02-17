package com.ssebide.service;

import java.util.List;

import com.ssebide.modal.Message;

public interface MessageService {
    Message sendMessage(Long senderId, Long chatId, String content) throws Exception;

    List<Message> getMessagesByProjectId(Long projectId) throws Exception;
}
