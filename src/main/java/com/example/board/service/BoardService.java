package com.example.board.service;

import com.example.board.dto.BoardResponseDTO;
import com.example.board.dto.CreateBoardRequestDTO;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDTO save(CreateBoardRequestDTO requestDTO) {
        Member findMember = memberRepository.findByUsernameOrElseThrow(requestDTO.getUsername());

        Board board = new Board(requestDTO);
        board.setMember(findMember);

        return new BoardResponseDTO(boardRepository.save(board));
    }
}
