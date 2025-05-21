package com.example.board.controller;

import com.example.board.dto.SignUpRequestDTO;
import com.example.board.dto.SignUpResponseDTO;
import com.example.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<SignUpResponseDTO> singUp(@RequestBody SignUpRequestDTO requestDTO) {
        return new ResponseEntity<>(memberService.signUp(requestDTO), HttpStatus.CREATED);
    }
}
