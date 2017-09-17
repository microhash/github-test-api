package com.githubapi.client.dto.commits;

import lombok.Data;

@Data
public class Commit {
    private String sha;
    private String url;
    private Author author;
    private String date;
    private String name;
    private String email;
    private Commiter commiter;
    private String message;
    private Tree tree;
    private Parents parents;
}
