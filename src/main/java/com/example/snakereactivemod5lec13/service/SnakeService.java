package com.example.snakereactivemod5lec13.service;

import com.example.snakereactivem5l13.model.Snake;
import com.example.snakereactivem5l13.repository.SnakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SnakeService {
    private final SnakeRepository snakeRepository;

    public Mono<Snake> get(Long id){
        return snakeRepository.findById(id);
    }

    public Flux<Snake> getAll(){
        return snakeRepository.findAll();
    }

    public Mono<Snake> save(Snake snake){
        return snakeRepository.save(snake);
    }

    public Mono<Void> deleteById(Long id){
        return snakeRepository.deleteById(id);
    }


}
