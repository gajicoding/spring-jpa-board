package com.example.board.dto;

import com.example.board.entity.Member;
import lombok.Getter;

@Getter
public class SignUpResponseDTO {
    private final Long id;

    private final String username;

    private final Integer age;

    public SignUpResponseDTO(Member savedMember) {
        this.id = savedMember.getId();
        this.username = savedMember.getUsername();
        this.age = savedMember.getAge();
    }
}
