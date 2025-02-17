package com.ssebide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssebide.modal.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    Invitation findByToken(String token);

    Invitation findByEmail(String userEmail);
}
