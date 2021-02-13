package Todo.Todolist.repository;

import Todo.Todolist.domain.TodoList;

import java.util.List;
import java.util.Optional;

public interface ListRepository {
    TodoList save(TodoList todoList);
    Optional<TodoList> findById(Long id);
    List<TodoList> findAll();
}
