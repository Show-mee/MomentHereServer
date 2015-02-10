package momenthere.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
				
		String username = request.getParameter("name");		
		String message = request.getParameter("message");	
		String times = request.getParameter("times");	
		//String time = request.getParameter("times");	
		System.out.println(" ");		
		System.out.println("time "+times);
		String location = request.getParameter("location");	
		System.out.println("location "+location);		
		Boolean InsertSuccess = InsertNewData(username, message, location, times);
		System.out.print("insertsuccess: "+InsertSuccess);
		//out.print("name"+username+"   password"+password+" success "+loginSuccess);
		
		out.flush();
		out.close();
	}
	
	public boolean InsertNewData(String username,String message,String location, String time){
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");     //????????????MYSQL JDBC????????????????????????   
	        //Class.forName("org.gjt.mm.mysql.Driver");
	       System.out.println("Success loading Mysql Driver!");
	      }
	      catch (Exception e) {
	        System.out.print("Error loading Mysql Driver!");
	        e.printStackTrace();
	      }
	      try {
	        Connection connect = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/momenthere","root","root");

	        System.out.println("Success connect Mysql server!");
	        Statement stmt = connect.createStatement();
	        int rs = stmt.executeUpdate("insert into messages values('"+username+"','"+message+"','"+time+"','"+location+"')");
	
	      }
	      catch (Exception e) {
	        System.out.print("get data error!");
	        e.printStackTrace();
	      }
	      
	      
	     return true;
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
