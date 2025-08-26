package com.codewithrufu.springboot.springfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;

    @RequestMapping("/list-todos")
    public String listTodos(ModelMap model) {
        List<ToDo> todos = todoService.findByUsername("Rufu");
        model.put("todos", todos);
        return "listTodos";
    }


    // so initially it handles all the requests lige GET, POST, PUT, DELETE all to vary it see next function
//    @RequestMapping("/add-todo")
//    public String showNewTodoPage() {
//        return "todo";
//    }


    @RequestMapping(value="/add-todo", method= RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        if (username == null) {
            // If name is not in model, redirect to login or set a default value
            return "redirect:login"; // or set a default username
        }
        ToDo todo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="/add-todo", method= RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        if (todo.getId() == 0) { // New todo
            todoService.addTodo(model.get("name").toString(), todo.getDescription(), LocalDate.now().plusYears(1), false);
        } else { // Existing todo being updated
            todo.setUserName(model.get("name").toString());
            todoService.updateTodo(todo);
        }
        return "redirect:list-todos";
    }


    @RequestMapping("/delete-todo")
    public String deleteTodos(@RequestParam(required = false, defaultValue = "0") int id) {
        //delete todo
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/update-todo",method=RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam(required = false, defaultValue = "0") int id, ModelMap model) {
        //update todo
        ToDo todo = todoService.findById(id);
        model.put("todo", todo);
        return "todo";
    }


    @RequestMapping(value="/update-todo", method= RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
//        String description = todo.getDescription();
//        todoService.deleteById(todo.getId());
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }










}
