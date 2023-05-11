package assets.sharing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connectionfactory {

    public Connection Connectionfactory(){
            Connection conn = null;
            System.out.println("qqlc");
            try{
                String url = "jdbc:mysql://localhost:3306/estudante_2sem_cc?user=root&password="; //ainda falta nome do banco user e password;
                conn = DriverManager.getConnection(url);
                System.out.println(conn);
            } catch (SQLException erro){
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
            return conn;
    }   
}
