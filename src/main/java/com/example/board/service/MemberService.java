package com.example.board.service;

import com.example.board.dto.MemberResponseDTO;
import com.example.board.dto.SignUpRequestDTO;
import com.example.board.dto.SignUpResponseDTO;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO) {
        Member member = new Member(requestDTO);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDTO(savedMember);
    }

    public MemberResponseDTO findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if(optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        return new MemberResponseDTO(optionalMember.get());
    }
}
