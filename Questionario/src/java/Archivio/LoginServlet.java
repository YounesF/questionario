
package Archivio;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
  }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{	    
            Utente user = new Utente();
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user = LoginDAO.login(user);
	   		    
            if (user.isValid()){
                String remember = request.getParameter ("Ricordami");
                Cookie cUserMail = new Cookie ("cookmail", user.getEmail());
                Cookie cPassword = new Cookie ("cookpass", user.getPassword());
                Cookie cRemember = new Cookie ("cookrem", remember.trim ());
                cUserMail.setMaxAge(365 * 24 * 60 * 60 * 1000); //ricorda per un anno
                cPassword.setMaxAge(365 * 24 * 60 * 60 * 1000);
                cRemember.setMaxAge(365 * 24 * 60 * 60 * 1000);
                response.addCookie (cUserMail);
                response.addCookie (cPassword);
                response.addCookie (cRemember);
                HttpSession session = request.getSession(true);	    
                session.setAttribute("currentSessionUser",user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.jsp");
                requestDispatcher.forward(request, response);
            }       
            else 
                response.sendRedirect("login.jsp"); //error page
        }
	
        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}

