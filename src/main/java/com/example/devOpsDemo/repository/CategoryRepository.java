package main.java.com.example.devOpsDemo.repository;

import main.java.com.example.devOpsDemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}