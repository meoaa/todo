package v2;

import domain.Todo;

import java.util.List;
import java.util.NoSuchElementException;

public class TodoServiceV2 {

    private final TodoRepositoryV2 todoRepository = new TodoRepositoryV2();

    public Todo createTodo(String title){
        return todoRepository.save(new Todo(title));
    }

    public Todo findOneTodo(long id){
        return checkExistTodo(id);
    }
    public List<Todo> findAllTodo(){
        if(todoRepository.isEmpty()){
            throw new NoSuchElementException("할 일이 존재하지 않습니다.");
        }
        return todoRepository.findAll();
    }
    
    public long deleteTodo(long id){
        Todo todo = checkExistTodo(id);
        return todoRepository.delete(todo);
    }

    public Todo updatedCompleted(long id){
        Todo todo = checkExistTodo(id);
        todo.toggleComplete();
        return todo;
    }

    private Todo checkExistTodo(long id) {
        return todoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 id와 일치하는 할 일이 존재하지 않습니다."));
    }
}
