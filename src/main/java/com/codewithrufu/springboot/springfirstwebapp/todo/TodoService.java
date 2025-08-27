package com.codewithrufu.springboot.springfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
                Predicate<? super ToDo> predicate = todo -> todo.getUserName().equalsIgnoreCase(username);
                return todos.stream().filter(predicate).toList();
        }

        public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone) {
                todos.add(new ToDo(todos.size() + 1, userName, description, targetDate, isDone));
        }

        public void deleteById(int id) {
                todos.removeIf(t -> t.getId() == id);
        }

        public ToDo findById(int id) {
                ToDo todo = todos.stream().filter(t -> t.getId() == id).findFirst().get();
                return todo;
        }

        public void updateTodo(@Valid ToDo updatedTodo) {
                ToDo existingTodo = findById(updatedTodo.getId());
                if (existingTodo != null) {
                    existingTodo.setDescription(updatedTodo.getDescription());
                    existingTodo.setTargetDate(updatedTodo.getTargetDate());
//                    existingTodo.setDone(updatedTodo.isDone());
                }
        }
}
