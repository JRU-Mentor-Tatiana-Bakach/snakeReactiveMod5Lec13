package com.example.snakereactivemod5lec13.repository;

import com.example.snakereactivemod5lec13.model.Snake;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SnakeRepository
        extends ReactiveCrudRepository<Snake, Long> {
}
