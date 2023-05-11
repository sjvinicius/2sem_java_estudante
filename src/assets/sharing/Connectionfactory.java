package assets.sharing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connectionfactory {

  Connection conn = null;

  public Connectionfactory() {
    try {
      String url =
        "jdbc:mysql://localhost:3306/estudante_2sem_cc?user=root&password=12345"; //ainda falta nome do banco user e password;
      this.conn = DriverManager.getConnection(url);

      System.out.println(this.conn);
    } catch (SQLException erro) {
      JOptionPane.showMessageDialog(null, erro.getMessage());
    }
  }

  public void SendQuery(String query) {
    // Connectionfactory conn = new Connectionfactory();
    // conn = conn.Connectionfactory();
    // String query = "SELECT * FROM aluno";
    try (
      Statement stmt = this.conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
    ) {
      while(rs.next()){
        //Display values
        System.out.println("Email: " + rs.getString("EMAIL"));
     }
    } catch (SQLException erro) {
      JOptionPane.showMessageDialog(null, erro.getMessage());
    }
  }
}
