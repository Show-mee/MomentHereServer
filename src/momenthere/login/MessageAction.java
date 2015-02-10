package momenthere.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import momenhere.tools.JsonService;
import momenhere.tools.JsonTools;

public class MessageAction extends HttpServlet {

	private JsonService service;

	/**
	 * Constructor of the object.
	 */
	public MessageAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		String jsonString = "";
		String action_flag = request.getParameter("action_flag");

		List<Message> list = service.getlistPerson(action_flag);
		System.out.print("list " + list.toString());
		jsonString = JsonTools.createJsonString(list);
		out.println(jsonString);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
		service = new JsonService();
	}

}
