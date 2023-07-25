package operation.app;

public class ToDo {
    private int id;
    private String todo;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    public ToDo(String todo) {
        this.todo = todo;
    }
    
}
