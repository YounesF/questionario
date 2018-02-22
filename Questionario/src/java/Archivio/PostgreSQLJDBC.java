package Archivio;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
   public static Connection getConn() {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://bcvok3nhsz0o9cs-postgresql.services.clever-cloud.com:5432/bcvok3nhsz0o9cs", "ux6voecdslgozt45qrrm", "xtCYXt2BO78tq0xgqXcf");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
 
      return c;
}
}