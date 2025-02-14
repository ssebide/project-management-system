package com.ssebide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssebide.modal.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
