package com.example.demo.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.domain.Testdb;
@Repository
public interface TestRepository extends JpaRepository<Testdb, Long> {
// Find all TestDB entities by a name
Testdb findByName(String name);
}
   

