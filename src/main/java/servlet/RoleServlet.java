package servlet;

import dal.RoleDalImp;
import dto.Role;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleServlet extends HttpServlet {
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

            RoleDalImp roleDalImp = new RoleDalImp();
            Role role = roleDalImp.readAllFromDB().get(0);
            out.println(role.toString());

            out.println("This is my first Servlet");
            out.println("</body>");
            out.println("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
