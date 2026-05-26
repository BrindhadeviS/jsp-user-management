package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
	public static String className = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/user_db";
	public static String user = "root";
	public static String password = "root";

	public void saveUser(User u) throws Exception {
		Class.forName(className);
		Connection c = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = c.prepareStatement("insert into user values (?,?,?,?,?,?)");
		ps.setInt(1, u.getId());
		ps.setString(2, u.getFname());
		ps.setString(3, u.getLname());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getPassword());
		ps.setLong(6, u.getPhone());
		
		ps.executeUpdate();
		System.out.println("Data saved");
	}
	
	public void updateUser(User u) throws Exception {
		Class.forName(className);
		Connection c = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = c.prepareStatement("update user set fname=?, lname=?, email=?, password=?, phone=? where id=?");
		ps.setInt(6, u.getId());
		ps.setString(2, u.getFname());
		ps.setString(3, u.getLname());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getPassword());
		
		ps.executeUpdate();
		System.out.println("Data Updatedd");
	}
	
	public void deleteUser(int id) throws Exception {
		Class.forName(className);
		Connection c = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = c.prepareStatement("delete from user where id =?");
		ps.setInt(1, id);
		
		ps.executeUpdate();
		System.out.println("Data deleted");
	}
	
	public User fetchUserById(int id) throws Exception
	{
		Class.forName(className);
		Connection c = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = c.prepareStatement("select * from user where id =?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id1 = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			long phone = rs.getLong(6);
			
			User u = new User();
			u.setId(id1);
			u.setFname(fname);
			u.setLname(lname);
			u.setEmail(email);
			u.setPassword(password);
			u.setPhone(phone);
			
			return u;
			
		}
		else {
			return null;
		}
		
	}
	
	public User fetchUSerByEmail(String email) throws Exception
	{
		Class.forName(className);
		Connection c = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = c.prepareStatement("select * from user where email =?");
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email1 = rs.getString(4);
			String password = rs.getString(5);
			long phone = rs.getLong(6);
			
			User u = new User();
			u.setId(id);
			u.setFname(fname);
			u.setLname(lname);
			u.setEmail(email1);
			u.setPassword(password);
			u.setPhone(phone);
			
			return u;
			
		}
		else {
			return null;
		}
		
		
	}
	

	public List<User> fetchAll() throws Exception
	{
		Class.forName(className);
		Connection c = DriverManager.getConnection(url, user, password);
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from user");
		
		ArrayList< User> al = new ArrayList();
		
		while (rs.next()) {
			int id1 = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			long phone = rs.getLong(6);
			
			User u = new User();
			u.setId(id1);
			u.setFname(fname);
			u.setLname(lname);
			u.setEmail(email);
			u.setPassword(password);
			u.setPhone(phone);
			
			al.add(u);
		}
		return al;		
	}
		
}
