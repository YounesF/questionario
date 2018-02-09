package Archivio;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
   public static Connection getConn() {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://dumbo.db.elephantsql.com:5432/iovbwnfi",
            "iovbwnfi", "5nodVLhOz0f_vqPZgzOh1_AAYmmssPq3");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
 
      return c;
}
}