package com.ssebide.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IssueRequest {
    private String title;
    private String description;
    private String status;
    private long projectId;
    private String priority;
    private LocalDate dueDate;
}
