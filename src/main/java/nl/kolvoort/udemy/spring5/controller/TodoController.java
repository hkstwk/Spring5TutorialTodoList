package nl.kolvoort.udemy.spring5.controller;

import nl.kolvoort.udemy.spring5.model.TodoData;
import nl.kolvoort.udemy.spring5.service.TodoItemService;
import nl.kolvoort.udemy.spring5.util.Mappings;
import nl.kolvoort.udemy.spring5.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // model attributes
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // handler methods
    // http://localhost/todo-items/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

}
