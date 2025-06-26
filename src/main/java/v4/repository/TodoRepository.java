package v4.repository;

import domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);

    Optional<Todo> findById(long id);

    List<Todo> findAll();

    long delete(Todo todo);

    boolean isEmpty();
}
