package v3.service;

import domain.Todo;
import domain.dto.TodoCreateRequestDto;
import domain.dto.TodoResponseDto;
import v3.repository.TodoMemoryRepositoryV3V3;
import v3.repository.TodoRepositoryV3;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TodoServiceV3Impl implements TodoServiceV3 {

    private final TodoRepositoryV3 todoRepositoryV3 = new TodoMemoryRepositoryV3V3();

    public TodoResponseDto createTodo(TodoCreateRequestDto dto){
        Todo savedTodo = todoRepositoryV3.save(new Todo(dto.getTitle()));
        return TodoResponseDto.of(savedTodo);
    }

    public TodoResponseDto findOneTodo(long id){
        Todo findTodo = checkExistTodo(id);
        return TodoResponseDto.of(findTodo);
    }

    public List<TodoResponseDto> findAllTodo(){

        if(todoRepositoryV3.isEmpty()){
            throw new NoSuchElementException("할 일이 존재하지 않습니다.");
        }

        List<Todo> todos = todoRepositoryV3.findAll();
        return todos.stream()
                .map(TodoResponseDto::of)
                .collect(Collectors.toList());
    }
    
    public long deleteTodo(long id){
        Todo todo = checkExistTodo(id);
        return todoRepositoryV3.delete(todo);
    }

    public TodoResponseDto updatedCompleted(long id){
        Todo todo = checkExistTodo(id);
        todo.toggleComplete();
        return TodoResponseDto.of(todo);
    }

    private Todo checkExistTodo(long id) {
        return todoRepositoryV3.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 id와 일치하는 할 일이 존재하지 않습니다."));
    }
}
