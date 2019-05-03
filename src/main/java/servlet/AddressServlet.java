package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dal.UserDalImp;
import dto.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class AddressServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) {

		System.out.println("here");

		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			out.println("<html>");
			out.println("<head><title>Hello Servlet</title></head>");
			out.println("<body>");
			out.println("<h3>Hello World</h3>");

			UserDalImp userDal = new UserDalImp();
			User user = userDal.readAllFromDB().get(0);
			out.println(user.toString());

			out.println("This is my first Servlet");
			out.println("</body>");
			out.println("<html>");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here in the post method.");
		String body = request.getReader().lines().collect(Collectors.joining());
		System.out.println(body);
		ObjectMapper objectMapper = new ObjectMapper();
		UserModel userModel = objectMapper.readValue(body, UserModel.class);

		System.out.println(userModel);

		response.getWriter().write(body);
		response.getWriter().flush();
		response.getWriter().close();


	}
}
