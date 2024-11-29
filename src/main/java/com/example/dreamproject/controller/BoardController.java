package com.example.dreamproject.controller;

import com.example.dreamproject.entity.Board;
import com.example.dreamproject.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 생성
    @PostMapping
    public ResponseEntity<Board> createPost(@RequestBody Board board) {
        return ResponseEntity.ok(boardService.createPost(board));
    }

    // 게시글 목록 조회
    @GetMapping
    public ResponseEntity<List<Board>> getAllPosts() {
        return ResponseEntity.ok(boardService.getAllPosts());
    }

    // 게시글 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<Board> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getPostById(id));
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Board> updatePost(@PathVariable Long id, @RequestBody Board board) {
        return ResponseEntity.ok(boardService.updatePost(id, board));
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        boardService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
