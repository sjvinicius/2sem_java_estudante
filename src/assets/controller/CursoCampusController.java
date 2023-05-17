package assets.controller;

public class CursoCampusController {

  String nomeCuso;
  String nomeCampus;

  public void BuscarCursoCampus() {
    String sql = "SELECT curso.NOME,campus.NOME from cursocampus";
  }
}
