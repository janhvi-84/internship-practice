
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    // Add Method 
    public void addStudent(Student student){
        String sql="INSERT INTO students(id,name,age,course) VALUES(?,?,?,?)";
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,student.getId());
            ps.setString(2,student.getName());
            ps.setInt(3,student.getAge());
             ps.setString(4, student.getCourse());
              int rows=ps.executeUpdate();
              if(rows>0){
                System.out.println("Student Added Successfully");
                
              }
            ps.close();
            con.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Veiw Method 
public void viewStudents() {

    String sql = "SELECT * FROM students";

    try {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        System.out.println("\n===== Student List =====");

        while (rs.next()) {

            System.out.println("ID      : " + rs.getInt("id"));
            System.out.println("Name    : " + rs.getString("name"));
            System.out.println("Age     : " + rs.getInt("age"));
            System.out.println("Course  : " + rs.getString("course"));
            System.out.println("---------------------------");
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

//Udate method 

public void updateStudent(int id, String name, int age, String course) {

    Connection con = DBConnection.getConnection();
    if (con == null) {
    System.out.println("Database Connection Failed!");
    return;
}

    String query = "UPDATE students SET name=?, age=?, course=? WHERE id=?";

    try {
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, course);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student Updated Successfully...");
        } else {
            System.out.println("Student ID not found!");
        }

        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}



// Delete Method

public void deleteStudent(int id) {

    String sql = "DELETE FROM students WHERE id=?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student Deleted Successfully...");
        } else {
            System.out.println("Student ID Not Found!");
        }

        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Search Student by ID

public void searchStudent(int id) {

    String sql = "SELECT * FROM students WHERE id=?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("\n===== Student Found =====");
            System.out.println("ID      : " + rs.getInt("id"));
            System.out.println("Name    : " + rs.getString("name"));
            System.out.println("Age     : " + rs.getInt("age"));
            System.out.println("Course  : " + rs.getString("course"));

        } else {

            System.out.println("Student ID Not Found!");

        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
}
