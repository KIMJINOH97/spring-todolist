package Todo.Todolist.controller;

import Todo.Todolist.domain.TodoList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListController {
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("data", "spring");
        return "index";
    }

    @PostMapping("/todo")
    public String create(TodoList todo){
        TodoList list = new TodoList();
        list.setTodo(todo.getTodo());
        System.out.println("todo : " + todo.getTodo());
        return "redirect:/";
    }
}
