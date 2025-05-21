package com.example.board.dto;

import lombok.Getter;

@Getter
public class BoardWithAgeResponseDTO {
    private final String title;
    private final String contents;
    private final Integer age;

    public BoardWithAgeResponseDTO(String title, String contents, Integer age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }
}
