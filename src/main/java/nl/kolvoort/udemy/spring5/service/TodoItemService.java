package nl.kolvoort.udemy.spring5.service;

import nl.kolvoort.udemy.spring5.model.TodoData;
import nl.kolvoort.udemy.spring5.model.TodoItem;

public interface TodoItemService {

    public void addItem(TodoItem toAdd);
    public void removeItem(int id);
    public TodoItem getItem(int id);
    public void updateItem(TodoItem toUpdate);
    public TodoData getData();
}
