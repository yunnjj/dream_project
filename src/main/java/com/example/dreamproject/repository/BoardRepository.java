package com.example.dreamproject.repository;

import com.example.dreamproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository를 상속받아 기본 CRUD 기능 제공
}
