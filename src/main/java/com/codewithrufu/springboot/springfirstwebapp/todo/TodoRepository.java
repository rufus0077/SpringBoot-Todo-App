package com.codewithrufu.springboot.springfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo, Integer> {
    public List<ToDo> findByUserName(String userName);
}
