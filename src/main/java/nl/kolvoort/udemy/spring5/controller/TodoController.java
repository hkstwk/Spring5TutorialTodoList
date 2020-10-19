package nl.kolvoort.udemy.spring5.controller;

import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.udemy.spring5.model.TodoData;
import nl.kolvoort.udemy.spring5.model.TodoItem;
import nl.kolvoort.udemy.spring5.service.TodoItemService;
import nl.kolvoort.udemy.spring5.util.AttributeNames;
import nl.kolvoort.udemy.spring5.util.Mappings;
import nl.kolvoort.udemy.spring5.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Slf4j
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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(Model model){
        TodoItem todoItem = new TodoItem("","", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    // http://localhost/todo-items/addItem
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from form = {}", todoItem);
        todoItemService.addItem(todoItem);
        return "redirect:/" + Mappings.ITEMS;
    }

}
