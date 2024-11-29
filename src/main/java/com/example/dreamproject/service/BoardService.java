package com.example.dreamproject.service;

import com.example.dreamproject.entity.Board;
import com.example.dreamproject.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시글 생성
    public Board createPost(Board board) {
        return boardRepository.save(board);
    }

    // 게시글 목록 조회
    public List<Board> getAllPosts() {
        return boardRepository.findAll();
    }

    // 게시글 단일 조회
    public Board getPostById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
    }

    // 게시글 수정
    public Board updatePost(Long id, Board updatedBoard) {
        Board board = getPostById(id);
        board.setTitle(updatedBoard.getTitle());
        board.setContent(updatedBoard.getContent());
        return boardRepository.save(board);
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
