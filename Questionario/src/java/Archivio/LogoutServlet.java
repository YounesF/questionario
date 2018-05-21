
package Archivio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cUserMail = new Cookie("cookmail", null);
        Cookie cPassword = new Cookie("cookpass", null);
        Cookie cRemember = new Cookie("cookrem", null);
        cUserMail.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRemember.setMaxAge(0);
        response.addCookie(cUserMail);
        response.addCookie(cPassword);
        response.addCookie(cRemember);
        HttpSession httpSession = request.getSession();
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/homepage.jsp");
    }
}

