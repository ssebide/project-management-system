package com.ssebide.service;

import java.util.List;
import java.util.Optional;

import com.ssebide.modal.Issue;
import com.ssebide.request.IssueRequest;

public interface IssueService {

    Optional<Issue> getIssueById(long issueId) throws Exception;

    List<Issue> getIssueByProjectId(long projectId) throws Exception;

    Issue creatIssue(IssueRequest issue, long userId) throws Exception;

    String deleteIssue(long issueId, long userId) throws Exception;

    Issue addUserToIssue(long issueId, long userId) throws Exception;

    Issue updateIssueStatus(long issueId, String status) throws Exception;
}