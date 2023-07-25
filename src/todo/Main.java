package todo;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import operation.app.ToDo;
import operation.app.ToDoOperation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to ToDo JDBC App");
		System.out.println("Press 1 to add todo");
		System.out.println("Press 2 to delete todo");
		System.out.println("Press 3 to show all todos");
		System.out.println("Press 4 to show one todo");
		System.out.println("Press 5 to exit");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try{

			while(true){
				int input = Integer.parseInt(bf.readLine());
				
				if(input==1){
					// add todo
					System.out.println("Enter ToDo Entry: ");
					String todo = bf.readLine();
					ToDo td = new ToDo(todo);
					boolean temp = ToDoOperation.createTodo(td);
					if(temp) System.out.println("Success");
					else System.out.println("Failed");
				}
				else if (input==2) {
					// delete todo
					System.out.println("Enter id :");
					int id = Integer.parseInt(bf.readLine());
					ToDoOperation.deleteTodo(id);
					
				} else if (input==3) {
					//show all todos
					List<String> todos = ToDoOperation.showTodos();
					System.out.println("Todos are...");
					for (String string : todos) {
						System.out.println(string);
					}
					
				} else if (input==4) {
					//show one todo
					System.out.println("Enter id: ");
					int id = Integer.parseInt(bf.readLine());
					ToDoOperation.showOneTodo(id);
					
					
				} else if (input==5) {
					//exit
					break;
				} else {
					
					
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
