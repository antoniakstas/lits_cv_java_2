package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dal.ProductDalImp;
import dal.UserDalImp;
import dto.Product;
import dto.User;
import model.LoginModel;
import model.UserModel;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        ServletOutputStream out = null;


        // http://localhost:8880/application/user?action=create&id=5

        String parameterAction = request.getParameter("action");
        String parameterId = request.getParameter("id");

        if (parameterId != null) {
            Integer idValue = Integer.valueOf(parameterId);
            String uri = getUrl(request, idValue);


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
            ctx.setVariable("url", "the null value was here");

            UserDalImp userDal = new UserDalImp();

            User user = userDal.readFromDBById(Integer.valueOf(parameterId)).get();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getReader().lines().collect(Collectors.joining());
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel loginModel =
                objectMapper.readValue(body, LoginModel.class);




//        UserModel userModel =
//                objectMapper.readValue(body, UserModel.class);

        System.out.println(loginModel);


        ProductDalImp imp = new ProductDalImp();

        List<Product> productList = imp.readAllFromDB();


        resp.getWriter().write(productList.toString());
        resp.getWriter().flush();
        resp.getWriter().close();

    }
}
