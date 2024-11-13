package com.example.demo.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;

//  @Repository
//  public interface BlogRepository extends JpaRepository<Article, Long>{
// List<Article> findAll();
//  }
 
@Repository
 public interface BlogRepository extends JpaRepository<Board, Long>{
    Page<Board> findByTitleContainingIgnoreCase(String title, Pageable pageable);
     // List<Article> findAll();
     
 }



