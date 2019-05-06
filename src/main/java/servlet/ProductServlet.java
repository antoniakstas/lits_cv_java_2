package servlet;

import dal.ProductDalImp;
import dto.Product;
import model.ProductModel;
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

public class ProductServlet extends HttpServlet {

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
            out.println("<h3>Hello Product</h3>");
            out.println(uri);
            out.println("<br>");
            out.println(parameterId1 + " was passed as the id");
            out.println("<br>");
            out.println(parameterAct + " was passed as the action");


            ProductDalImp productDalImp = new ProductDalImp();
            List<Product> productList = productDalImp.readAllFromDB();

            out.println("<ul>");
            for (Product productItem : productList) {
                out.println("<li>" + productItem.toString() + "</li>");
            }

            out.println("</ul>");
            out.println("");
            out.println("</body>");
            out.println("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }






//        String parameterAction = request.getParameter("action");
//        String parameterId = request.getParameter("id");
//        String uri = getUrl(request, Integer.valueOf(parameterId));
//
//        ServletContextTemplateResolver templateResolver =
//                new ServletContextTemplateResolver(this.getServletContext());
//
//        templateResolver.setPrefix("/WEB-INF/page/");
//        templateResolver.setSuffix(".html");
//
//
//        TemplateEngine templateEngine = new TemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        WebContext ctx = new WebContext(request, response, getServletConfig().getServletContext(), request.getLocale());
//        ctx.setVariable("currentDate", 123);
//        ctx.setVariable("currentProductId", parameterId);
//        ctx.setVariable("url", uri);
//
//        ProductDalImp productDal =  new ProductDalImp();
//
//        Product product = productDal.readFromDBById(Integer.valueOf(parameterId)).get();
//        ProductModel productModel = new ProductModel(product.getId(),
//                product.getIndex(),
//                product.getName(),
//                product.getManufacturer(),
//                product.getCount(), uri);
//
//
//        ctx.setVariable("productModel", product);
//        List<Product> productList = productDal.readAllFromDB();
//
//        List<ProductModel> productModelList = new ArrayList<>();
//
//        for (Product productItem : productList) {
//            ProductModel productModelItem = new ProductModel(productItem.getId(),
//                    productItem.getIndex(),
//                    productItem.getName(),
//                    productItem.getManufacturer(),
//                    productItem.getCount(), getUrl(request, productItem.getId()));
//            productModelList.add(productModelItem);
//        }
//
//        ctx.setVariable("productListModel", productModelList);
//
//
//        try {
//            String template = null;
//            if ("edit".equals(parameterAction)) {
//                template = "productEdit";
//            } else {
//                template = "product";
//            }
//            templateEngine.process(template, ctx, response.getWriter());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private String getUrl(HttpServletRequest request, int idValue) {
//        return request.getScheme() +
//                "://" +
//                request.getServerName() +
//                ":" +
//                request.getServerPort() +
//                request.getRequestURI() +
//                "?" +
//                "id=" +
//                idValue;
//    }


//        System.out.println("here");
//
//        ServletOutputStream out = null;
//        try {
//            out = response.getOutputStream();
//            out.println("<html>");
//            out.println("<head><title>Hello Servlet</title></head>");
//            out.println("<body>");
//            out.println("<h3>Hello World</h3>");
//
//            ProductDalImp productDal = new ProductDalImp();
//            Product product = productDal.readAllFromDB().get(0);
//            out.println(product.toString());
//
//            out.println("This is my first Servlet");
//            out.println("</body>");
//            out.println("<html>");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
