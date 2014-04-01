package pl.edu.pk.cyberMama;

import pl.edu.pk.cyberMama.dao.UsersDaoSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Nati on 29.03.14.
 */
public class LoginValidationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String passwordHash = request.getParameter("passwordHash");
        System.out.println(login);
        System.out.println(passwordHash);
        PrintWriter writer =  response.getWriter();
        if (passwordHash.equals(UsersDaoSingleton.getInstance().getUserByLogin(login))){
            request.getSession().setAttribute("user", login);
            writer.write("/js/home.jsp");
        } else {
            writer.write("/index.jsp?error=true");
        }
    writer.close();
    }
}
