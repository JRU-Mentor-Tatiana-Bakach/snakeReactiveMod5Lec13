Проект который мы писали на занятии по теме Spring WebFlux
Чтобы запустить проект, не забудьте создать подключение к БД.
В проекте использован PostgreSQL


Для БД:

create database snakes;

create table snake(
id BIGSERIAL PRIMARY KEY,
name varchar(100),
age INTEGER
);

INSERT INTO snake (name, age)
VALUES
('Draco', 10),
('Liza', 20),
('Kevin', 100);
