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
import org.springframework.web.bind.annotation.*;

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
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // handler methods
    // http://localhost/todo-items/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model) {
        log.info("Editing item with id {}", id);
        TodoItem todoItem = todoItemService.getItem(id);

        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    // http://localhost/todo-items/addItem
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);

        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }

    // http://localhost/todo-items/addItem
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("deleting item with id = {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;

    }

}
