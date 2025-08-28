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
public class TodoControllerJpa {
    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }


    private TodoRepository todoRepository;

    @RequestMapping("/list-todos")
    public String listTodos(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<ToDo> todos = todoRepository.findByUserName(username);
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
        String username = getLoggedInUsername(model);
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

            String username = getLoggedInUsername(model);
            todo.setUserName(username);
            todoRepository.save(todo);
//            todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());

        return "redirect:list-todos";
    }


    @RequestMapping("/delete-todo")
    public String deleteTodos(@RequestParam(required = false, defaultValue = "0") int id) {
        //delete todo
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/update-todo",method=RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam(required = false, defaultValue = "0") int id, ModelMap model) {
        //update todo
//        ToDo todo = todoService.findById(id);
        ToDo todo = todoRepository.findById(id).get();
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
//        todoService.updateTodo(todo);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }


    private static String getLoggedInUsername(ModelMap model) {
        return (String) model.get("name");
    }









}
