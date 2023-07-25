package operation.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToDoOperation {
    public static boolean createTodo(ToDo td){
        boolean flag = false;
        Connection con = DBConn.connect();
        String sql = "insert into todotable (TODO) values(?)";
        try{

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, td.getTodo());
            stmt.executeUpdate();
            flag = true;
            return flag;
        }catch(Exception e){
            e.printStackTrace();
            return flag;
        }
    }
    public static List<String> showTodos(){
        Connection con = DBConn.connect();
        String sql = "select * from todotable";
        List<String> todos = new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String s = rs.getString("todo");
                todos.add(id+":"+s);
            }
            return todos;
        }
        catch(Exception e){
            e.printStackTrace();
            return todos;
        }
    }
    public static boolean deleteTodo(int id){
        boolean flag = false;
        Connection conn = DBConn.connect();
        String sql = "delete from todotable where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Deleted Successfully");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Failed to delete");
        }

        return flag;
    }
    public static void showOneTodo(int id){
        Connection conn = DBConn.connect();
        String sql = "select * from todotable where id="+id;
        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(id+":"+rs.getString("todo"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
