package v2;

import domain.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoRepositoryV2 {

    private static List<Todo> store = new ArrayList<>();

    public Todo save(Todo todo){
        boolean isDuplicate = store.stream()
                .anyMatch(elem -> elem.getId() == todo.getId());

        if(isDuplicate){
            throw new IllegalArgumentException("이미 존재하는 id 입니다.");
        }

        store.add(todo);
        return todo;
    }

    public Optional<Todo> findById(long id){
        return store.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst();
    }


    public List<Todo> findAll(){
        return store;
    }

    public long delete(Todo todo){
        store.remove(todo);
        return todo.getId();
    }

    public boolean isEmpty(){
        return store.isEmpty();
    }
}
