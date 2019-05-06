package servlet;

import dal.PriceDalImp;
import dal.RoleDalImp;
import dto.Price;
import dto.Role;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RoleServlet extends HttpServlet {

    @Override
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
            out.println("<h3>Hello Price</h3>");
            out.println(uri);
            out.println("<br>");
            out.println(parameterId1 + " was passed as the id");
            out.println("<br>");
            out.println(parameterAct + " was passed as the action");

            RoleDalImp roleDalImp = new RoleDalImp();
            List<Role> roleList = roleDalImp.readAllFromDB();

            out.println("<ul>");
            for (Role roleItem : roleList) {
                out.println("<li>" + roleItem.toString() + "</li>");
            }

            out.println("</ul>");
//            out.println("This is my first Servlet");
            out.println("</body>");
            out.println("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
