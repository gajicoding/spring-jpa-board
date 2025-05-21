package com.example.board.dto;

import com.example.board.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDTO {
    private final String username;

    private final Integer age;

    public MemberResponseDTO(Member member) {
        this.username = member.getUsername();
        this.age = member.getAge();
    }
}