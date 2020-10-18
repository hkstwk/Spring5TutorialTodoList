package nl.kolvoort.udemy.spring5.service;

import lombok.Getter;
import lombok.NonNull;
import nl.kolvoort.udemy.spring5.model.TodoData;
import nl.kolvoort.udemy.spring5.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // fields
    @Getter
    private final TodoData data;

    // constructor
    public TodoItemServiceImpl() {
        this.data = new TodoData();
    }

    // public methods
    @Override
    public void addItem(@NonNull TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(@NonNull TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }
}
