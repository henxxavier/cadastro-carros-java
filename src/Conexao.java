import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public static Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:database/carros.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

