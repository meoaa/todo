package v3.repository;

import domain.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoMemoryRepositoryV3V3 implements TodoRepositoryV3 {

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
        return new ArrayList<>(store);
    }

    public long delete(Todo todo){
        store.remove(todo);
        return todo.getId();
    }

    @Override
    public boolean isEmpty() {
        return store.isEmpty();
    }
}
