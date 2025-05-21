package com.example.board.entity;

import com.example.board.dto.SignUpRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer age;

    public Member() {}

    public Member(SignUpRequestDTO requestDTO) {
        this.username = requestDTO.getUsername();
        this.password = requestDTO.getPassword();
        this.age = requestDTO.getAge();
    }
}
