package com.ssebide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssebide.modal.Issue;
import com.ssebide.modal.Project;
import com.ssebide.modal.User;
import com.ssebide.repository.IssueRepository;
import com.ssebide.request.IssueRequest;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Override
    public Issue getIssueById(long issueId) throws Exception {
        Optional<Issue> issue = issueRepository.findById(issueId);
        if (issue.isPresent()) {
            return issue.get();
        }
        throw new Exception("No issues found with issue id" + issueId);
    }

    @Override
    public List<Issue> getIssueByProjectId(long projectId) throws Exception {
        return issueRepository.findByProjectId(projectId);
    }

    @Override
    public Issue createIssue(IssueRequest issueRequest, User user) throws Exception {

        Project project = projectService.getProjectById(issueRequest.getProjectId());

        Issue issue = new Issue();
        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setStatus(issueRequest.getStatus());
        issue.setProjectID(issue.getProjectID());
        issue.setPriority(issueRequest.getPriority());
        issue.setDueDate(issueRequest.getDueDate());

        issue.setProject(project);

        return issueRepository.save(issue);
    }

    @Override
    public void deleteIssue(long issueId, long userId) throws Exception {
        getIssueById(issueId);

        issueRepository.deleteById(issueId);
    }

    @Override
    public Issue addUserToIssue(long issueId, long userId) throws Exception {
        User user = userService.findUserById(userId);

        Issue issue = getIssueById(issueId);
        issue.setAssignee(user);
        return issueRepository.save(issue);
    }

    @Override
    public Issue updateIssueStatus(long issueId, String status) throws Exception {
        Issue issue = getIssueById(issueId);

        issue.setStatus(status);

        return issueRepository.save(issue);
    }

}
