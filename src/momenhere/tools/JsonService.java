package momenhere.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

import momenthere.login.Message;

//import java.util.Map;

public class JsonService {

	public JsonService() {
		// TODO Auto-generated constructor stub
	}

	public List<Message> getlistPersons() {
		List<Message> list = new ArrayList<Message>();
		Message m1 = new Message("jack", "s", "guangxi", "a");
		Message m2 = new Message("rose", "s", "guangdong", "x");
		list.add(m1);
		list.add(m2);
		return list;
	}

	public List<Message> getlistPerson(String location) {
		List<Message> list = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/momenthere", "root", "root");
			System.out.println("Success connect Mysql server!!!");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from messages where location = '"
							+ location + "'");
			String name, message, time, current_location;
			while (rs.next()) {
				name = rs.getString("name");
				message = rs.getString("message");
				time = rs.getString("time");
				location = rs.getString("location");

				Message m = new Message(name, message, location, time);
				System.out.print("m" + m.toString());
				list.add(m);

			}
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}

		return list;

	}

}
