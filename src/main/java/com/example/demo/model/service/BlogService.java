package com.example.demo.model.service;
 import java.util.List;
 import java.util.Optional;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
 import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BlogRepository;
 import lombok.RequiredArgsConstructor;
 @Service

 @RequiredArgsConstructor // 생성자자동생성(부분)

 public class BlogService {
 
@Autowired // 객체주입자동화, 생성자1개면생략가능
// private final BlogRepository blogRepository; // 리포지토리선언
private final BlogRepository blogRepository; // 리포지토리 선언

// public List<Article> findAll() { // 게시판전체목록조회
   //  return blogRepository.findAll();
//  }

public List<Board> findAll() { // 게시판 전체 목록 조회
   return blogRepository.findAll();
}

//  public Article save(AddArticleRequest request){
//     // DTO가없는경우이곳에직접구현가능
//     // public ResponseEntity<Article> addArticle(@RequestParam String title, @RequestParam String content) {
//     // Article article = Article.builder()
//     // .title(title)
//     // .content(content)
//     // .build();
//     return blogRepository.save(request.toEntity());
//  } 

//  public Optional<Article> findById(Long id) { // 게시판특정글조회
   //  return blogRepository.findById(id);
   //   }

   public Optional<Board> findById(Long id) { // 게시판 특정 글 조회
      return blogRepository.findById(id);
   }
    
     public void update(Long id, AddArticleRequest request) {
     Optional<Board> optionalArticle = blogRepository.findById(id); // 단일글조회
    optionalArticle.ifPresent(article -> { //값이있으면
    article.update(request.getTitle(), request.getContent(),  article.getUser(), article.getNewdate(), article.getCount(), article.getLikec()); // 값을수정
    blogRepository.save(article); // Article 객체에저장
    });
     }


  public void delete(Long id) {
    blogRepository.deleteById(id);
    }  
   
    public Board save(AddArticleRequest request){
      // DTO가 없는 경우 이곳에 직접 구현 가능
     return blogRepository.save(request.toEntity());
      }
   
   public Page<Board> findAll(Pageable pageable) {
      return blogRepository.findAll(pageable);
      }   

   public Page<Board> searchByKeyword(String keyword, Pageable pageable) {
      return blogRepository.findByTitleContainingIgnoreCase(keyword, pageable);
      } // LIKE 검색 제공(대소문자 무시)   
}
