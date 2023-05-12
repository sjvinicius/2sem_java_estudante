package assets.sharing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connectionfactory {

  Connection conn = null;

  public Connection getConn() {
    return conn;
  }

  public void setConn(Connection conn) {
    this.conn = conn;
  }

  public Connectionfactory() {
    try {
      String url =
        // "jdbc:mysql://localhost:3306/estudante_2sem_cc?user=root&password="; // Giovanni Connection
        "jdbc:mysql://localhost:3306/estudante_2sem_cc?user=root&password=12345"; // Vinicius Conection
        this.setConn(DriverManager.getConnection(url));

      System.out.println("Banco de Dados: OK");
    } catch (SQLException erro) {
      JOptionPane.showMessageDialog(null, erro.getMessage());
    }
  }

  // public void SendQuery(String query) {
  //   try (
  //     Statement stmt = getConn().createStatement();
  //     ResultSet rs = stmt.executeQuery(query);
  //   ) {

  //     while(rs.next()){
  //       System.out.println(rs.getString("EMAIL"));
  //     }
  //   } catch (SQLException erro) {
  //     JOptionPane.showMessageDialog(null, erro.getMessage());
  //   }
  // }
}