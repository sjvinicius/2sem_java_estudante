package assets.controller;

import assets.sharing.Connectionfactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoController {

  String nome;

  public ArrayList<String> BuscarCurso() {
    String sql = "SELECT curso.NOME FROM curso";

    ArrayList<String> cursos = new ArrayList<String>() {};
    Connectionfactory link = new Connectionfactory();

    try (PreparedStatement stmt = link.getConn().prepareStatement(sql)) {
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        cursos.add(rs.getString("NOME"));
      }

      return cursos;
    } catch (SQLException e) {
      System.out.println(e);
    }

    return null;
  }
}
