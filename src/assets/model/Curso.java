package assets.model;

public class Curso {

  private int cursoid;
  private String nome;

  public Curso(int cursoid, String nome) {
    this.cursoid = cursoid;
    this.nome = nome;
  }

  public int getCursoid() {
    return cursoid;
  }

  public void setCursoid(int cursoid) {
    this.cursoid = cursoid;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
