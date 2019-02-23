package com.mytest.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Student {
    @Id
    private String _id;
    private String name;
    private String email;
    private String code;
}
