package servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) {
		ServletContextTemplateResolver templateResolver =
				new ServletContextTemplateResolver(this.getServletContext());

		templateResolver.setPrefix("/WEB-INF/page/");
		templateResolver.setSuffix(".html");


		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		WebContext ctx = new WebContext(request, response, getServletConfig().getServletContext(), request.getLocale());
		// This will be prefixed with /WEB-INF/ and suffixed with .html

		List<String> listUrl = new ArrayList<>();
		Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();

		String baseUrl = request.getScheme() +
				"://" +
				request.getServerName() +
				":" +
				request.getServerPort() +
				getServletContext().getContextPath() +
				"/";

		for(Map.Entry <String, ? extends ServletRegistration> entry : servletRegistrations.entrySet()) {

			try {
				String mapping;
				if (entry.getKey().equals("default")|| entry.getKey().equals("jsp")) continue;

				mapping = entry.getValue().getMappings().iterator().next();
				String urlItem = baseUrl + mapping.substring(1);
				listUrl.add(urlItem);
			} catch (Exception ex) {}

		}
		ctx.setVariable("urlList", listUrl);


		try {
			String template = "home";
			templateEngine.process(template, ctx, response.getWriter());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
