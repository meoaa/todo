package v3.service;

import domain.dto.TodoCreateRequestDto;
import domain.dto.TodoResponseDto;

import java.util.List;

public interface TodoServiceV3 {

    TodoResponseDto createTodo(TodoCreateRequestDto dto);

    TodoResponseDto findOneTodo(long id);

    List<TodoResponseDto> findAllTodo();

    long deleteTodo(long id);

    TodoResponseDto updatedCompleted(long id);
}
