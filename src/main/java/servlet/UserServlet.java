package servlet;

import dal.UserDalImp;
import dto.User;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) {
		ServletOutputStream out = null;


		// http://localhost:8880/application/user?action=create&id=5

		String parameterAction = request.getParameter("action");
		String parameterId = request.getParameter("id");

		String uri = request.getScheme() +
				"://" +
				request.getServerName() +
				":" +
				request.getServerPort() +
				request.getRequestURI() +
				"?" +
				request.getQueryString();

		try {
			out = response.getOutputStream();
			out.println("<html>");
			out.println("<head><title>Hello Servlet</title></head>");
			out.println("<body>");
			out.println("<h3>Hello User</h3>");
			out.println(uri);
			out.println("<br>");
			out.println(parameterId + " was passed as the id");
			out.println("<br>");
			out.println(parameterAction + " was passed as the action");


			UserDalImp userDal = new UserDalImp();
			List<User> userList = userDal.readAllFromDB();

			out.println("<ul>");
			for (User userItem : userList) {
				out.println("<li>" + userItem.toString() + "</li>");
			}

			out.println("</ul>");
			out.println("This is my first Servlet");
			out.println("</body>");
			out.println("<html>");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
