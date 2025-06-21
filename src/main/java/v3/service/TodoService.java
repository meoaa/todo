package v3.service;

import domain.Todo;

import java.util.List;
import java.util.NoSuchElementException;

public interface TodoService {

    Todo createTodo(String title);

    Todo findOneTodo(long id);
    List<Todo> findAllTodo();

    long deleteTodo(long id);

    Todo updatedCompleted(long id);
}
