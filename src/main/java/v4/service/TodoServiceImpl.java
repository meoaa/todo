package v4.service;

import domain.Todo;
import domain.dto.TodoCreateRequestDto;
import domain.dto.TodoResponseDto;
import v4.repository.TodoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto createTodo(TodoCreateRequestDto dto){
        Todo savedTodo = todoRepository.save(new Todo(dto.getTitle()));
        return TodoResponseDto.of(savedTodo);
    }

    public TodoResponseDto findOneTodo(long id){
        Todo findTodo = checkExistTodo(id);
        return TodoResponseDto.of(findTodo);
    }

    public List<TodoResponseDto> findAllTodo(){

        if(todoRepository.isEmpty()){
            throw new NoSuchElementException("할 일이 존재하지 않습니다.");
        }

        List<Todo> todos = todoRepository.findAll();
        return todos.stream()
                .map(TodoResponseDto::of)
                .collect(Collectors.toList());
    }
    
    public long deleteTodo(long id){
        Todo todo = checkExistTodo(id);
        return todoRepository.delete(todo);
    }

    public TodoResponseDto updatedCompleted(long id){
        Todo todo = checkExistTodo(id);
        todo.toggleComplete();
        return TodoResponseDto.of(todo);
    }

    private Todo checkExistTodo(long id) {
        return todoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 id와 일치하는 할 일이 존재하지 않습니다."));
    }
}
