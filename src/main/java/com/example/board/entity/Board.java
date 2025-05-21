package com.example.board.entity;

import com.example.board.dto.CreateBoardRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Board() {}

    public Board(CreateBoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.contents = requestDTO.getContents();
    }
}