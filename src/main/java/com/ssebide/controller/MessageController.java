package com.ssebide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssebide.modal.Chat;
import com.ssebide.modal.Message;
import com.ssebide.modal.User;
import com.ssebide.request.CreateMessageRequest;
import com.ssebide.service.MessageService;
import com.ssebide.service.ProjectService;
import com.ssebide.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request) throws Exception{
        User user = userService.findUserById(request.getSenderId());

        if(user == null) throw new Exception("User not found with Id: "+ request.getSenderId());

        Chat chats = projectService.getProjectById(request.getProjectId()).getChat();
        if(chats == null) throw new Exception("Chats Not Found");

        Message sentMessage = messageService.sendMessage(request.getSenderId(), request.getProjectId(), request.getContent());

        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessageByChatId(@PathVariable Long projectId) throws Exception {
        List<Message> messages = messageService.getMessagesByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }

}
