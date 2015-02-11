package momenthere.trackmap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import momenthere.login.Message;

//Specialize differet types generate different objects
public class JsonService2 {
	public JsonService2() {

	}

	public TrackmapNode getTrackmapNode() {
		Date date;
		String dateString = "03/04/2013";
		TrackmapNode tmn = null;
		SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = dateFormater.parse(dateString);
			tmn = new TrackmapNode("a", date, "9182", 23);
			System.out.println(tmn);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tmn;
	}

	public List<Message> getlistTrackmapNode(String username) {
		List<Message> list = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2 Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("2 Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/momenthere", "root", "root");
			System.out.println("Success connect Mysql server!!!");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from messages where name = '"
							+ username + "'");
			String name, message, time, current_location;
			while (rs.next()) {
				name = rs.getString("name");
				message = rs.getString("message");
				time = rs.getString("time");
				username = rs.getString("location");

				Message m = new Message(name, message, username, time);
				System.out.println("m:" + m.toString());
				list.add(m);
			}
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
		return list;
	}

}
