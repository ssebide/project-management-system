package com.ssebide.service;

import java.util.List;
import java.util.Optional;

import com.ssebide.modal.Issue;
import com.ssebide.modal.User;
import com.ssebide.request.IssueRequest;

public interface IssueService {

    Issue getIssueById(long issueId) throws Exception;

    List<Issue> getIssueByProjectId(long projectId) throws Exception;

    Issue createIssue(IssueRequest issue, User user) throws Exception;

    void deleteIssue(long issueId, long userId) throws Exception;

    Issue addUserToIssue(long issueId, long userId) throws Exception;

    Issue updateIssueStatus(long issueId, String status) throws Exception;
}