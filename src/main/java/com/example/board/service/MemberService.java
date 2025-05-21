package com.example.board.service;

import com.example.board.dto.MemberResponseDTO;
import com.example.board.dto.SignUpRequestDTO;
import com.example.board.dto.SignUpResponseDTO;
import com.example.board.dto.UpdatePasswordRequestDTO;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        return new MemberResponseDTO(memberRepository.findByIdOrElseThrow(id));
    }

    @Transactional
    public void updatePassword(Long id, UpdatePasswordRequestDTO requestDTO) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if(!findMember.getPassword().equals(requestDTO.getOldPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password does not match");
        }

        findMember.updatePassword(requestDTO.getNewPassword());
    }
}
