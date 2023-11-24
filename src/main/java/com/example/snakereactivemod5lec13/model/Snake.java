package com.example.snakereactivemod5lec13.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="snake")
public class Snake {
    @Id
    private Long id;
    private String name;
    private Integer age;
}
