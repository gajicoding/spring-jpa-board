package com.example.board.dto;

import lombok.Getter;

@Getter
public class UpdatePasswordRequestDTO {
    private final String oldPassword;
    private final String newPassword;

    public UpdatePasswordRequestDTO(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
