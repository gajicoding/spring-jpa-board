package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDTO {
    private final Long id;
    private final String title;
    private final String contents;

    public BoardResponseDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
    }
}
