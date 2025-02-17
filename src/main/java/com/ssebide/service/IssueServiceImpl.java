package com.ssebide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssebide.modal.Issue;
import com.ssebide.repository.IssueRepository;
import com.ssebide.request.IssueRequest;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Optional<Issue> getIssueById(long issueId) throws Exception {
        Optional<Issue> issue = issueRepository.findById(issueId);
        if (issue.isPresent()) {
            return issue;
        }
        throw new Exception("No issues found with issue id" + issueId);
    }

    @Override
    public List<Issue> getIssueByProjectId(long projectId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIssueByProjectId'");
    }

    @Override
    public Issue creatIssue(IssueRequest issue, long userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creatIssue'");
    }

    @Override
    public String deleteIssue(long issueId, long userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteIssue'");
    }

    @Override
    public Issue addUserToIssue(long issueId, long userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addUserToIssue'");
    }

    @Override
    public Issue updateIssueStatus(long issueId, String status) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateIssueStatus'");
    }

}
