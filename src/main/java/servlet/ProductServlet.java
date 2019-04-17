package servlet;

import dal.ProductDalImp;
import dto.Product;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {

        System.out.println("here");

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            out.println("<html>");
            out.println("<head><title>Hello Servlet</title></head>");
            out.println("<body>");
            out.println("<h3>Hello World</h3>");

            ProductDalImp productDal = new ProductDalImp();
            Product product = productDal.readAllFromDB().get(0);
            out.println(product.toString());

            out.println("This is my first Servlet");
            out.println("</body>");
            out.println("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
