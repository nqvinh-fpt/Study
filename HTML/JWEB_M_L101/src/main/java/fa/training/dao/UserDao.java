/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.dao;

import fa.training.entities.User;
import fa.training.utils.DBUtils;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinh1
 */
public class UserDao extends DBUtils {

    public User checkLoginUser(String email, String pass) {
        String sql = "select * from [User] where Email =? and [Password] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("userName"),
                        rs.getString("password"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println("error db");
        }
        return null;
    }

    public void registerUser(String firstName, String lastName, String email, String userName, String password) {
        String insert = "INSERT INTO [dbo].[Users]\n"
                + "           ([FirstName]\n"
                + "           ,[LastName]\n"
                + "           ,[Email]\n"
                + "           ,[UserName]\n"
                + "           ,[Password])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, userName);
            ps.setString(5, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Create Account Error!!");
        }
    }

    public ArrayList<User> getListUser() {
        ArrayList<User> data = new ArrayList<>();
        try {
            String strSelect = "SELECT [FirstName]\n"
                    + "      ,[LastName]\n"
                    + "      ,[Email]\n"
                    + "      ,[UserName]\n"
                    + "  FROM [Users]";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                String email = rs.getString(3);
                String userName = rs.getString(4);
                User brand = new User(firstName,lastName,email,userName);
                data.add(brand);
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return data;
    }
}
