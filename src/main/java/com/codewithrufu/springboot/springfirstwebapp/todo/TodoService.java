package com.codewithrufu.springboot.springfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
        private static List<ToDo> todos = new ArrayList<>();;
        //todos ;
        static {
                todos.add(new ToDo(1, "Rufu", "learn java", LocalDate.now().plusDays(5), false));
                todos.add(new ToDo(2, "Rufu", "learn spring", LocalDate.now().plusDays(10), false));
                todos.add(new ToDo(3, "Rufu", "learn angular", LocalDate.now().plusDays(15), false));
        }

        public List<ToDo> findByUsername(String username) {
                return todos;
        }

        public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone) {
                todos.add(new ToDo(todos.size() + 1, userName, description, targetDate, isDone));
        }
}
