import java.sql.*;

public class ConnectURL {
    public static void main(String[] args) {

//        // Create a variable for the connection string.
//        String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=Final;user=sa;password=123";
//
//        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
//            String SQL = "SELECT * FROM [Final].[dbo].[Admin]";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            while (rs.next()) {
//                System.out.println(rs.getString("AdminName") + " " + rs.getString("Address"));
//            }
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
////        }
//        String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=Final;user=sa;password=123";
//        String insertOrderSQL = "INSERT INTO [dbo].[User]\n" +
//                "           ([UserName]\n" +
//                "           ,[Address]\n" +
//                "           ,[Phone]\n" +
//                "           ,[Email]\n" +
//                "           ,[Password]\n" +
//                "           ,[status]\n" +
//                "           ,[img])\n" +
//                "     VALUES\n" +
//                "           (?,?,?,?,?,?,?)";
//        try (Connection con = DriverManager.getConnection(connectionUrl);) {
//            PreparedStatement ps = con.prepareStatement(insertOrderSQL);
//            ps.setString(1, "JohnDoe");
//            ps.setString(2, "123 Main St");
//            ps.setString(3, "123-456-7890");
//            ps.setString(4, "john@example.com");
//            ps.setString(5, "password123");
//            ps.setString(6, "true");
//            ps.setString(7, "profile_image.jpg");
//
//            int rowsAffected = ps.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("User inserted successfully.");
//            } else {
//                System.out.println("User insertion failed.");
//            }
//        } catch (SQLException e) {
//            System.out.println("SQL error: " + e.getMessage());
//        }
//    }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=InventorySystem;user=sa;password=123";
        String insertOrderSQL = "INSERT INTO [dbo].[Orders]\n" +
                "           ([OrderDate]\n" +
                "           ,[RequiredDate]\n" +
                "           ,[CustomerID]\n" +
                "           ,[TotalPrice])\n" +
                "     VALUES\n" +
                "           (?,?,?,?)\n";
        try (Connection con = DriverManager.getConnection(connectionUrl);) {
            PreparedStatement ps = con.prepareStatement(insertOrderSQL);
            ps.setString(1, "order.getOrderDate()");
            ps.setString(2, "order.getRequiredDate()");
            ps.setString(3, "order.getCustomerID()");
            ps.setDouble(4, 123);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL eror: " + e);
        }
    }
}