/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO extends dal.DBContext{
    public ArrayList<Product> getProduct(){
        
        ArrayList<Product> data = new ArrayList<>();
        try {
            String strSelect = "SELECT [ID]"
                    + "      ,[Tên]\n"
                    + "      ,[Số lượng]\n"
                    + "      ,[Đơn giá]\n"
                    + "  FROM [product]";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String ql = rs.getString(3);
                String price = rs.getString(4);
                Product product = new Product(ID, name, ql, price);
                data.add(product);
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return data;
    }
}
