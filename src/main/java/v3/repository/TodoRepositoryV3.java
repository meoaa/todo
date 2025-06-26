package v3.repository;

import domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepositoryV3 {
    Todo save(Todo todo);

    Optional<Todo> findById(long id);

    List<Todo> findAll();

    long delete(Todo todo);

    boolean isEmpty();
}
