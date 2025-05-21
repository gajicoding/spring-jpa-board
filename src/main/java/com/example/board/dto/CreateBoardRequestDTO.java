package com.example.board.dto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDTO {
    private final String title;
    private final String contents;
    private final String username;

    public CreateBoardRequestDTO(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
