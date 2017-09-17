package com.githubapi.client.dto.commits;

import lombok.Data;

@Data
class Author {
    private String date;
    private String name;
    private String email;
}
