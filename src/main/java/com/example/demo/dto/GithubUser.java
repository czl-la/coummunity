package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GithubUser {
    private String name;
    private String bio;
    private Long id;
}
