package assets.controller;

import assets.model.Estudante;
import assets.sharing.Connectionfactory;
import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EstudanteController {

  public void CreateNewEstudante(Estudante est) {}

  public Estudante ListOneEstudante(String srgm) {
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

      Connectionfactory link = new Connectionfactory();
      String _srgm = srgm;
      // String sql =
      //   "SELECT aluno.RGM, aluno.NOME, aluno.NASC, aluno.CPF, aluno.EMAIL, aluno.END, aluno.MUN, aluno.UF, aluno.CELULAR FROM aluno WHERE aluno.RGM = '" +
      //   srgm +
      //   "' AND aluno.STATUS = 'A'";
      String sql =
        "SELECT aluno.RGM, aluno.NOME, aluno.NASC, aluno.CPF, aluno.EMAIL, aluno.END, aluno.MUN, aluno.UF, aluno.CELULAR FROM aluno WHERE aluno.RGM = ? AND aluno.STATUS = 'A'";
      try (PreparedStatement pstmt = link.getConn().prepareStatement(sql)) {
        pstmt.setString(1, _srgm);

        ResultSet rs = pstmt.executeQuery();

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

        JOptionPane.showMessageDialog(null, "Usuário encontrado.");

        link.getConn().close();
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

  public int DeleteOneEstudante(String rgm) {
    Connectionfactory link = new Connectionfactory();

    String sql =
      "UPDATE aluno SET aluno.STATUS = 'I' WHERE aluno.RGM = ? AND aluno.STATUS = 'A'";
    try (PreparedStatement pstmt = link.getConn().prepareStatement(sql);) {
      pstmt.setString(1, rgm);
      int rs = pstmt.executeUpdate();

      if (rs > 0) {
        // Sucesso

      } else {
        // Erro

      }

      link.getConn().close();
      return rs;
    } catch (SQLException e) {
      System.out.println(e);
    }

    return 0;
  }

  public Estudante UpdateEstudante(
    String rgm,
    String nome,
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
      "UPDATE aluno SET aluno.NOME = ?, aluno.NASC = ?, aluno.CPF = ?, aluno.EMAIL = ?, aluno.END = ?, aluno.MUN = ?, aluno.UF = ?, aluno.CELULAR = ? WHERE aluno.RGM = ? AND aluno.STATUS = 'A'";

    try (PreparedStatement pstmt = link.getConn().prepareStatement(sql)) {
      pstmt.setString(1, nome == null ? "NULL" : nome);
      pstmt.setString(2, nasc == null ? "NULL" : nasc);
      pstmt.setString(3, cpf == null ? "NULL" : cpf);
      pstmt.setString(4, email == null ? "NULL" : email);
      pstmt.setString(5, end == null ? "NULL" : end);
      pstmt.setString(6, mun == null ? "NULL" : mun);
      pstmt.setString(7, uf == null ? "NULL" : uf);
      pstmt.setString(8, celular == null ? "NULL" : celular);
      pstmt.setString(9, rgm == null ? "NULL" : rgm);

      int rs = pstmt.executeUpdate();

      if (rs > 0) {
        link.getConn().close();
        JOptionPane.showMessageDialog(null, "Alteração realizada.");

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
        
      } else {
        JOptionPane.showMessageDialog(null, "Não foram realizadas alterações.");
        return null;
      }
    } catch (SQLException e) {
      System.out.println(e);
    }

    return null;
  }

  public Estudante CreateEstudante(
    String rgm,
    String nome,
    String nasc,
    String cpf,
    String email,
    String end,
    String mun,
    String uf,
    String celular
  ) {
    Estudante est = null;

    Connectionfactory link = new Connectionfactory();
    String sql =
      "SELECT aluno.RGM, aluno.NOME, aluno.NASC, aluno.CPF, aluno.EMAIL, aluno.END, aluno.MUN, aluno.UF, aluno.CELULAR FROM aluno WHERE aluno.RGM = ?";

    try (PreparedStatement stmt = link.getConn().prepareStatement(sql)) {
      stmt.setString(1, rgm);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        est =
          new Estudante(
            rs.getString("RGM"),
            rs.getString("NOME"),
            rs.getString("NASC"),
            rs.getString("CPF"),
            rs.getString("EMAIL"),
            rs.getString("END"),
            rs.getString("MUN"),
            rs.getString("UF"),
            rs.getString("CELULAR")
          );
      }
    } catch (SQLException e) {
      System.out.println(e);
    }

    if (est == null) {
      String sqlinsert =
        "INSERT INTO aluno(aluno.RGM,aluno.NOME, aluno.NASC,aluno.CPF,aluno.EMAIL,aluno.END,aluno.MUN,aluno.UF,aluno.CELULAR,aluno.CRIACAO_DATA) VALUES (?,?,?,?,?,?,?,?,?,NOW())";

      try (
        PreparedStatement pstmt = link.getConn().prepareStatement(sqlinsert);
      ) {
        pstmt.setString(1, rgm == null ? "NULL" : rgm);
        pstmt.setString(2, nome == null ? "NULL" : nome);
        pstmt.setString(3, nasc == null ? "NULL" : nasc);
        pstmt.setString(4, cpf == null ? "NULL" : cpf);
        pstmt.setString(5, email == null ? "NULL" : email);
        pstmt.setString(6, end == null ? "NULL" : end);
        pstmt.setString(7, mun == null ? "NULL" : mun);
        pstmt.setString(8, uf == null ? "NULL" : uf);
        pstmt.setString(9, celular == null ? "NULL" : celular);

        int rs = pstmt.executeUpdate();

        if (rs > 0) {
          System.out.println("Estudante inserido");
        } else {
          System.out.println("Não foi possível inserir o estudante.");
          // JOptionPane.showMessageDialog(null, rs);
        }
        link.getConn().close();
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        // JOptionPane.showMessageDialog(null, );
        // e.printStackTrace();
      }

      return null;
    } else {
      JOptionPane.showMessageDialog(
        null,
        "Usuário inativo, entre em contato com o suporte para reativação."
      );

      return null;
    }
  }
}
