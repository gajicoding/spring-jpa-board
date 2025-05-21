package com.example.board.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDTO {
    private final String username;

    private final String password;

    private final Integer age;

    public SignUpRequestDTO(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
