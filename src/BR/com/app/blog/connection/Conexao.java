package BR.com.app.blog.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public static Connection criarConexao() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=root&useSSL=false");
            
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }
}
