package assets.controller;

import assets.model.Estudante;
import assets.sharing.Connectionfactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudanteController {

  public void CreateNewEstudante(Estudante est) {}

  public Estudante ListOneEstudante(String srgm) {
    Connectionfactory link = new Connectionfactory();

    try {
      String rgm = null;
      String nome = null;
      String nasc = null;
      String cpf = null;
      String email = null;
      String end = null;
      String mun = null;
      String uf = null;
      String celular = null;

      String sql =
        "SELECT aluno.RMG, aluno.NOME, aluno.NASC, aluno.CPF, aluno.EMAIL, aluno.END, aluno.MUN, aluno.UF, aluno.CELULAR FROM aluno WHERE aluno.RGM = ? AND STATUS = 'A' LIMIT 1";

      try (PreparedStatement pstmt = link.getConn().prepareStatement(sql);) {
        pstmt.setString(1, srgm);
        ResultSet rs = pstmt.executeQuery(sql);

        if (rs.next()) {
          rgm = rs.getString("RGM");
          nome = rs.getString("NOME");
          nasc = rs.getString("NASC");
          cpf = rs.getString("CPF");
          email = rs.getString("EMAIL");
          end = rs.getString("END");
          mun = rs.getString("MUN");
          uf = rs.getString("UF");
          celular = rs.getString("CELULAR");
        }

        return new Estudante(
          rgm,
          nome,
          nasc,
          cpf,
          email,
          end,
          mun,
          uf,
          celular
        );
      } catch (SQLException e) {
        System.out.println(e);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  public void DeleteOneEstudante(String rgm) {
    Connectionfactory link = new Connectionfactory();

    String sql = "UPDATE aluno SET aluno.STATUS = 'I' WHERE aluno.RGM = ?";
    try (PreparedStatement pstmt = link.getConn().prepareStatement(sql);) {
      pstmt.setString(1, rgm);

      ResultSet rs = pstmt.executeQuery(sql);

      link.getConn().close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  public Estudante UpdateEstudante(
    String rgm,
    String nasc,
    String cpf,
    String email,
    String end,
    String mun,
    String uf,
    String celular
  ) {
    Connectionfactory link = new Connectionfactory();

    String sql =
      "UPDATE aluno SET aluno.RGM = ?, aluno.NASC = ?, aluno.CPF = ?, aluno.EMAIL = ?, aluno.END = ?, aluno.MUN = ?, aluno.UF = ?, aluno.CELULAR = ? WHERE aluno.RGM = ? AND aluno.STATUS = 'A'";

    try (PreparedStatement pstmt = link.getConn().prepareStatement(sql)) {
      pstmt.setString(1, rgm == null ? "NULL" : rgm);
      pstmt.setString(2, nasc == null ? "NULL" : nasc);
      pstmt.setString(3, cpf == null ? "NULL" : cpf);
      pstmt.setString(4, email == null ? "NULL" : email);
      pstmt.setString(5, end == null ? "NULL" : end);
      pstmt.setString(6, mun == null ? "NULL" : mun);
      pstmt.setString(7, uf == null ? "NULL" : uf);
      pstmt.setString(8, celular == null ? "NULL" : celular);

      ResultSet rs = pstmt.executeQuery(sql);

      link.getConn().close();
    } catch (SQLException e) {
      System.out.println(e);
    }

    return null;
  }

  public Estudante CreateEstudante(
    String rgm,
    String nasc,
    String cpf,
    String email,
    String end,
    String mun,
    String uf,
    String celular
  ) {
    Connectionfactory link = new Connectionfactory();
    String sql =
      "INSERT INTO aluno(aluno.RGM,aluno.NASC,aluno.CPF,aluno.EMAIL,aluno.END,aluno.MUN,aluno.UF,aluno.CELULAR) VALUES (?,?,?,?,?,?,?,?)";

    try (PreparedStatement pstmt = link.getConn().prepareStatement(sql);) {
      pstmt.setString(1, rgm == null ? "NULL" : rgm);
      pstmt.setString(2, nasc == null ? "NULL" : nasc);
      pstmt.setString(3, cpf == null ? "NULL" : cpf);
      pstmt.setString(4, email == null ? "NULL" : email);
      pstmt.setString(5, end == null ? "NULL" : end);
      pstmt.setString(6, mun == null ? "NULL" : mun);
      pstmt.setString(7, uf == null ? "NULL" : uf);
      pstmt.setString(8, celular == null ? "NULL" : celular);

      ResultSet rs = pstmt.executeQuery(sql);
    } catch (SQLException e) {
      System.out.println(e);
    }

    return null;
  }
}