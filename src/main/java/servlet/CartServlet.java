package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dal.CartDalImp;
import dto.Cart;
import model.CartModel;
import model.LoginModel;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class CartServlet extends HttpServlet {

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

            CartDalImp cartDal = new CartDalImp();

            Cart cart = cartDal.readFromDBById(Integer.valueOf(parameterId)).get();
            ctx.setVariable("cartModel", cart);
            List<Cart> cartList = cartDal.readAllFromDB();

            List<CartModel> cartModelList = new ArrayList<>();

            for (Cart cartItem : cartList) {
                CartModel cartModelItem =
                        new CartModel(cartItem.getId(),
                                cartItem.getOrder_id(),
                                cartItem.getProduct_count(),
                                cartItem.getPrice_id(),
                                getUrl(request, cartItem.getId()));
                cartModelList.add(cartModelItem);
            }

            ctx.setVariable("cartListModel", cartModelList);


            try {
                String template = null;
                if ("edit".equals(parameterAction)) {
                    template = "cartEdit";
                } else {
                    template = "cart";
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


        System.out.println(loginModel);


        CartDalImp imp = new CartDalImp();

        List<Cart> cartList = imp.readAllFromDB();


        resp.getWriter().write(cartList.toString());
        resp.getWriter().flush();
        resp.getWriter().close();









     /*   String parameterAct = request.getParameter("action");
        String parameterId1 = request.getParameter("id");

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
            out.println("<h3>Hello Cart</h3>");
            out.println(uri);
           *//* out.println("<br>");
            out.println(parameterId1 + " was passed as the id");
            out.println("<br>");
            out.println(parameterAct + " was passed as the action");*//*


            CartDalImp cartDal = new CartDalImp();
            List<Cart> cartList = cartDal.readAllFromDB();

            out.println("<ul>");
            for (Cart cartItem : cartList) {
                out.println("<li>" + cartItem.toString() + "</li>");
            }

            out.println("</ul>");
            out.println("This is my first Servlet");
            out.println("</body>");
            out.println("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}




