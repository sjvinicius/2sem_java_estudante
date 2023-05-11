package assets.model;

public class Estudante {

    private int estudanteid;
    private int rgm;
    private String nasc;
    private String cpf;
    private String email;
    private String end;
    private String mun;
    private String uf;
    private String celular;

    public Estudante(){

    }

    /// Gera um novo objeto estudante com as informações preenchendo todos os campos de estudantes
    public Estudante(int estudanteid,int rgm, String nasc, String cpf, String email, String end, String mun, String uf,
            String celular) {
        
        this.estudanteid = estudanteid;
        this.rgm = rgm;
        this.rgm = rgm;
        this.nasc = nasc;
        this.cpf = cpf;
        this.email = email;
        this.end = end;
        this.mun = mun;
        this.uf = uf;
        this.celular = celular;
    }
    
    public int getRgm() {
        return rgm;
    }
    public void setRgm(int rgm) {
        this.rgm = rgm;
    }
    public String getNasc() {
        return nasc;
    }
    public void setNasc(String nasc) {
        this.nasc = nasc;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public String getMun() {
        return mun;
    }
    public void setMun(String mun) {
        this.mun = mun;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
}
