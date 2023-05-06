package assets.sharing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connectionfactory {

    public Connection Connectionfactory (){
            Connection conn = null;

            try{
                String url = "jdbc:mysql://localhost:3306/" ; //ainda falta nome do banco user e password;
                conn = DriverManager.getConnection(url);
            } catch (SQLException erro){
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
            return conn;
    }   
}
