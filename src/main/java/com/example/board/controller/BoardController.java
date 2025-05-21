package com.example.board.controller;

import com.example.board.dto.BoardResponseDTO;
import com.example.board.dto.BoardWithAgeResponseDTO;
import com.example.board.dto.CreateBoardRequestDTO;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDTO> save(@RequestBody CreateBoardRequestDTO requestDTO) {
        return new ResponseEntity<>(boardService.save(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDTO>> findAll() {
        return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardWithAgeResponseDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
