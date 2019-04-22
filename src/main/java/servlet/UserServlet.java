package servlet;

import dal.UserDalImp;
import dto.User;
import model.UserModel;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) {
		ServletOutputStream out = null;


		// http://localhost:8880/application/user?action=create&id=5

		String parameterAction = request.getParameter("action");
		String parameterId = request.getParameter("id");

		String uri = getUrl(request, new Integer(parameterId));

		ServletContextTemplateResolver templateResolver =
				new ServletContextTemplateResolver(this.getServletContext());

		templateResolver.setPrefix("/WEB-INF/page/");
		templateResolver.setSuffix(".html");


		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		WebContext ctx = new WebContext(request, response, getServletConfig().getServletContext(), request.getLocale());
		// This will be prefixed with /WEB-INF/ and suffixed with .html
		ctx.setVariable("currentDate", 123);
		ctx.setVariable("currentUserId", parameterId);
		ctx.setVariable("url", uri);

		UserDalImp userDal = new UserDalImp();

		User user = userDal.readFromDBById(new Integer(parameterId)).get();
		UserModel userModel =
				new UserModel(user.getId(), user.getName(), uri);

		ctx.setVariable("userModel", user);
		List<User> userList = userDal.readAllFromDB();

		List<UserModel> userModelList = new ArrayList<>();

		for (User userItem : userList) {
			UserModel userModelItem =
					new UserModel(userItem.getId(),
							userItem.getName(),
							getUrl(request, userItem.getId()));
			userModelList.add(userModelItem);
		}

		ctx.setVariable("userListModel", userModelList);


		try {
			String template = null;
			if ("edit".equals(parameterAction)) {
				template = "userEdit";
			} else {
				template = "user";
			}
			templateEngine.process(template, ctx, response.getWriter());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getUrl(HttpServletRequest request, int idValue) {
		return request.getScheme() +
				"://" +
				request.getServerName() +
				":" +
				request.getServerPort() +
				request.getRequestURI() +
				"?" +
				"id=" +
				idValue;
	}

}
