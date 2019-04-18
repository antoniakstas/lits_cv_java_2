package servlet;

import dal.PriceDalImp;

import dto.Price;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PriceServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {

        System.out.println("here is");

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            out.println("<html>");
            out.println("<head><title>Hello Servlet</title></head>");
            out.println("<body>");
            out.println("<h3>Hello World</h3>");

            PriceDalImp priceDal = new PriceDalImp();
            Price price = priceDal.readAllFromDB().get(0);
            out.println(price.toString());

            out.println("This is my first Servlet");
            out.println("</body>");
            out.println("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
