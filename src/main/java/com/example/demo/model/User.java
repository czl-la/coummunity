package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User  {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
}
