package v4.config;

import v4.repository.TodoMemoryRepository;
import v4.service.TodoService;
import v4.service.TodoServiceImpl;

public class TodoConfig {
    
    public TodoService todoService(){
        return new TodoServiceImpl(todoRepository());
    }

    public TodoMemoryRepository todoRepository() {
        return new TodoMemoryRepository();
    }
}
