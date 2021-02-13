package Todo.Todolist.repository;

import Todo.Todolist.domain.TodoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryListRepositoryTest {
    MemoryListRepository repository = new MemoryListRepository();

    @AfterEach
    public void clear(){
        repository.clear();
    }

    @Test
    public void save(){
        TodoList list = new TodoList();
        list.setTodo("오늘은 뭐하지? ");

        // System.out.println(list.getId()); // 밑 줄에서 setId를 해주기때문에 지금은 null 값임.
        repository.save(list);
        System.out.println(list.getId());

        TodoList result = repository.findById(list.getId()).get();
        assertThat(result).isEqualTo(list);
    }

    @Test
    public void findAll(){
        TodoList list1 = new TodoList();
        TodoList list2 = new TodoList();

        list1.setTodo("안녕하세요");
        repository.save(list1);

        list2.setTodo("김진오 입니다.");
        repository.save(list2);

        List<TodoList> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
