package v3.service;

import v3.dto.TodoCreateRequestDto;
import v3.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {

    TodoResponseDto createTodo(TodoCreateRequestDto dto);

    TodoResponseDto findOneTodo(long id);

    List<TodoResponseDto> findAllTodo();

    long deleteTodo(long id);

    TodoResponseDto updatedCompleted(long id);
}
