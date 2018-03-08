package tags;

import Archivio.PostgreSQLJDBC;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Registra extends SimpleTagSupport {
    
    Connection conn; 
    PreparedStatement pst;
    ResultSet rs;

    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try{
            // connect to database
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("select id,nome from regioni order by nome");
            rs = pst.executeQuery();
            String output = "<select name=uid>";
 
            while (rs.next()) {
                output += "<option value=" + rs.getString("id") + ">" + rs.getString("nome") + "</option>";
            }
            output += "</select>";
            out.println(output);
            conn.close();
        } catch (Exception ex) {
            throw new JspException("Error in UsersHandler tag", ex);
        }
    
    }
}
