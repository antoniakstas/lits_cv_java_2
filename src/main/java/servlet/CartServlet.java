package servlet;

import dal.CartDalImp;
import dto.Cart;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        ServletOutputStream out = null;


        String parameterAct = request.getParameter("action");
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
            out.println("<br>");
            out.println(parameterId1 + " was passed as the id");
            out.println("<br>");
            out.println(parameterAct + " was passed as the action");


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
        }


    }

    /*public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {

        System.out.println("here");

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            out.println("<html>");
            out.println("<head><title>Hello Servlet</title></head>");
            out.println("<body>");
            out.println("<h3>Hello World</h3>");

            CartDalImp cartDal = new CartDalImp();
            Cart cart = cartDal.readAllFromDB().get(0);
            out.println(cart.toString());

            out.println("This is my first Servlet");
            out.println("</body>");
            out.println("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
