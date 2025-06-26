package v4.service;

import domain.dto.TodoCreateRequestDto;
import domain.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {

    TodoResponseDto createTodo(TodoCreateRequestDto dto);

    TodoResponseDto findOneTodo(long id);

    List<TodoResponseDto> findAllTodo();

    long deleteTodo(long id);

    TodoResponseDto updatedCompleted(long id);
}
