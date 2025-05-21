package com.example.board.service;

import com.example.board.dto.SignUpRequestDTO;
import com.example.board.dto.SignUpResponseDTO;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO) {
        Member member = new Member(requestDTO);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDTO(savedMember);
    }
}
