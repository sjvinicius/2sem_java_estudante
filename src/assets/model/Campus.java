package assets.model;

public class Campus {

  public int campusid;
  public String nome;

  public Campus(int campusid, String nome) {
    this.campusid = campusid;
    this.nome = nome;
  }

  public int getCampusid() {
    return campusid;
  }

  public void setCampusid(int campusid) {
    this.campusid = campusid;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
