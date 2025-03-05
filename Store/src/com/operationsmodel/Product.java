package com.operationsmodel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {
	private static final String url = "jdbc:mysql://localhost:3306/store";
	private static final String username = "root";
	private static final String password = "ADit12..";
	
	public static void insert(int id, String name, float price, int quantity, String category) throws Exception{
		Connection conn = DriverManager.getConnection(url,username,password);
		String str = "{Call store.insertProducts(?,?,?,?,?)}";
		CallableStatement cs = conn.prepareCall(str);
		cs.setInt(1,id);
		cs.setString(2,name);
		cs.setFloat(3,price);
		cs.setInt(4, quantity);
		cs.setString(5, category);
		cs.execute();
		System.out.println("Product inserted successfully👍...");
		cs.close();
		conn.close();
	}
	public static void delete(int id) throws Exception{
		Connection conn = DriverManager.getConnection(url,username,password);
		String str = "{Call store.deleteProduct(?)}";
		CallableStatement cs = conn.prepareCall(str);
		cs.setInt(1,id);
		cs.execute();
		System.out.println("Product Removed successfully👍...");
		cs.close();
		conn.close();
	}
	public static void update(int id, String name, float price, int quantity, String category) throws Exception{
		Connection conn = DriverManager.getConnection(url,username,password);
		String str = "{Call store.updateProduct(?,?,?,?,?)}";
		CallableStatement cs = conn.prepareCall(str);
		cs.setInt(1,id);
		cs.setString(2,name);
		cs.setFloat(3,price);
		cs.setInt(4, quantity);
		cs.setString(5, category);
		cs.execute();
		System.out.println("Product updated successfully👍...");
		cs.close();
		conn.close();
	}
	public static void retrieveAllProducts(){
		String str = "SELECT * FROM products;";
		try(Connection conn = DriverManager.getConnection(url,username,password);
		Statement smt = conn.createStatement();
		ResultSet rs = smt.executeQuery(str)){
			System.out.println("Products List");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				int quantity = rs.getInt("quantity");
				String category = rs.getString("category");
				System.out.println("Id: "+id+" Name: "+name+" Price: "+price+" Quantity: "+quantity+" Category: "+category);
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void retrieveProductById(int id) throws Exception{
		Connection conn = DriverManager.getConnection(url,username,password);
		String str = "SELECT * FROM products WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(str);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			int quantity = rs.getInt("quantity");
			String category = rs.getString("category");
			System.out.println("Id: "+id1+" Name: "+name+" Price: "+price+" Quantity: "+quantity+" Category: "+category);
		}
		rs.close();
		ps.close();
		conn.close();
	}
}
