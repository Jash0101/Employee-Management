import java.sql.*;
import java.util.*;

public class EmployeeCRUD {

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO Employee(name, salary) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getName());
            stmt.setDouble(2, emp.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary")
                );
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE Employee SET name = ?, salary = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getName());
            stmt.setDouble(2, emp.getSalary());
            stmt.setInt(3, emp.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Employee updated.");
            else
                System.out.println("Employee not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted.");
            else
                System.out.println("Employee not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

