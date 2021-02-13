package Todo.Todolist.repository;

import Todo.Todolist.domain.TodoList;

import java.util.*;

public class MemoryListRepository implements ListRepository {
    private static Map<Long, TodoList> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public TodoList save(TodoList todoList) {
        todoList.setId(++sequence);
        store.put(todoList.getId(), todoList);
        return todoList;
    }

    @Override
    public Optional<TodoList> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<TodoList> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clear() {
        store.clear();
    }
}
