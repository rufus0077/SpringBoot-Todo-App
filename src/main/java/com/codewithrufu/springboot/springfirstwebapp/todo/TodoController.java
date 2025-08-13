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
        ToDo todo = new ToDo(0,model.get("name").toString(),"",LocalDate.now().plusYears(1),false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="/add-todo", method= RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        String description = todo.getDescription();
        todoService.addTodo(model.get("name").toString(),description, LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }



}
