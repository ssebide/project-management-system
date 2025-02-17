package com.ssebide.service;

import com.ssebide.modal.Invitation;

import jakarta.mail.MessagingException;

public interface InvitationService {

    public void sendInvitation (String email, long projectId) throws MessagingException;
    public Invitation accepInvitation(String token, long userId) throws Exception;

    public String getTokenByUserMail(String userEmail);

    void deleteToken(String token);
}
