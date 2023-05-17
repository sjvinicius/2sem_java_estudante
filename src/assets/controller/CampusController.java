package assets.controller;

import assets.sharing.Connectionfactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CampusController {

  String nome;

  public ArrayList<String> BuscarCurso() {
    String sql = "SELECT campus.NOME FROM curso WHERE campus.STATUS = 'A'";

    ArrayList<String> campus = new ArrayList<String>() {};
    Connectionfactory link = new Connectionfactory();

    try (PreparedStatement stmt = link.getConn().prepareStatement(sql)) {
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        campus.add(rs.getString("NOME"));
      }

      return campus;
    } catch (SQLException e) {
      System.out.println(e);
    }

    return null;
  }
}
