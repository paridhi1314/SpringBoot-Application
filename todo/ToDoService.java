package todolist.todo;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ToDoService {
	private List<ToDo> todos = new ArrayList<>(
		Arrays.asList(
				new ToDo(1,"Task_1", "Summary_1", "Desc_1"),
				new ToDo(2,"Task_2", "Summary_2", "Desc_2"),
				new ToDo(3,"Task_3", "Summary_3", "Desc_3")
			)
		);
	
	public List<ToDo> getAllToDos(){
		return todos;
	}

	public ToDo getToDo(Integer id) {
		// TODO Auto-generated method stub
		return todos.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void createToDo(ToDo todo) {
		todos.add(todo);
	
	}

	public void updateToDo( Integer id, ToDo todo) {
		for(int i=0;i<todos.size();i++) {
			ToDo t = todos.get(i);
			if(t.getId().equals(id)) {
			  todos.set(i, todo);
			  return;
			}	
		
		}
		
	}

	public void deleteToDo(Integer id) {
		todos.removeIf(t-> t.getId().equals(id));
		
	}

}
