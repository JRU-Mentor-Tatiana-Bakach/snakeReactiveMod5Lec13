package com.example.snakereactivemod5lec13.controller;

import com.example.snakereactivemod5lec13.model.Snake;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SnakeControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void findAll() {
        webTestClient.get().uri("/reactive/snakes")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Snake.class);
    }

    @Test
    void findById() {
        webTestClient.get().uri("/reactive/snakes/1")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Snake.class);
    }

    @Test
    void create() {
        Snake snake = Snake.builder()
                .name("New Snake")
                .age(1000)
                .build();
        webTestClient.post().uri("/reactive/snakes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(snake), Snake.class)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.name").isEqualTo(snake.getName())
                .jsonPath("$.age").isEqualTo(snake.getAge())
                .returnResult();
    }
}