package Archivio;

import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RecuperaServlet extends HttpServlet {
    
    @EJB
    private EmailSessionBean emailBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{
            String password;
            Utente user = new Utente();
            user.setEmail(request.getParameter("email"));
            password=RecuperaDAO.recupera(user);
            emailBean.sendEmail(user.getEmail(),"Recupero Credenziali","la tua password è:"+password);
            
        }
        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
