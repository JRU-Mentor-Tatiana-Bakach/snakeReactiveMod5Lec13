package com.example.snakereactivemod5lec13.controller;

import com.example.snakereactivem5l13.model.Snake;
import com.example.snakereactivem5l13.service.SnakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reactive/snakes")
public class SnakeController {

    private final SnakeService snakeService;

    @GetMapping
    public Flux<Snake> findAll(){
        return snakeService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Snake> findById(@PathVariable Long id){
        return snakeService.get(id);
    }

    @PostMapping
    public Mono<Snake> create(@RequestBody Snake snake){
        return snakeService.save(snake);
    }

    @PutMapping("/{id}")
    public Mono<Snake> update(@PathVariable Long id,
                              @RequestBody Snake snake){
        return snakeService.save(snake);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return snakeService.deleteById(id);
    }
}
