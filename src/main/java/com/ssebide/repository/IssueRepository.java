package com.ssebide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssebide.modal.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{

}
