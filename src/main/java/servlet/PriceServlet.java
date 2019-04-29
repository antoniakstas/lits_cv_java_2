package servlet;

import dal.PriceDalImp;
import dto.Price;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PriceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        ServletOutputStream out = null;


        // http://localhost:8880/application/user?action=create&id=5

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
            out.println("<h3>Hello Price</h3>");
            out.println(uri);
            out.println("<br>");
            out.println(parameterId1 + " was passed as the id");
            out.println("<br>");
            out.println(parameterAct + " was passed as the action");


            PriceDalImp priceDal = new PriceDalImp();
            List<Price> priceList = priceDal.readAllFromDB();

            out.println("<ul>");
            for (Price priceItem : priceList) {
                out.println("<li>" + priceItem.toString() + "</li>");
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
