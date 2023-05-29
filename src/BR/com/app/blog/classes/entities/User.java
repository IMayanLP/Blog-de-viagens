package BR.com.app.blog.classes.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class User extends Entity {
    
    public User(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    
    @Override
    public boolean insert(Connection con) {
        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String comando = "INSERT INTO User (id,name,email,password)";
            comando = comando + " VALUES (default,?,?,?)";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getName());
            instrucaoSQL.setString(2, getEmail());
            instrucaoSQL.setString(3, getPassword());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Conta criada com sucesso");
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao adicionar o usuário.");
        }
        
        return false;
        
    }

    @Override
    public boolean del(Connection con) {
        PreparedStatement instrucaoSQL;
        
        try {
            // criando a instrução SQL
            String sql = "DELETE FROM User";
            sql = sql + " WHERE id = ?";

            instrucaoSQL = con.prepareStatement(sql);
            instrucaoSQL.setInt(1, getId());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Apagado com sucesso");
            
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir.");
        }
        return false;
    }

    @Override
    public boolean update(Connection con) {
        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            //instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String comando = "Update User SET name=?,email=?,password=? where id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getName());
            instrucaoSQL.setString(2, getEmail());
            instrucaoSQL.setString(3, getPassword());
            instrucaoSQL.setInt(4, getId());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editado com sucesso");
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao editar dados");
        }
        
        return false;  
    }
    
    @Override
    public boolean alreadyExists(Connection con){
        PreparedStatement instrucaoSQL;
        ResultSet resultados;
        ArrayList<User> users = new ArrayList<User>();
        
        try {
            // criando a instrução SQL
            String comando = "select * from User where email=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getEmail());
            resultados = instrucaoSQL.executeQuery();
            
            while (resultados.next()) {
                users.add(new User(resultados.getInt("id"), resultados.getString("name"), resultados.getString("email"), resultados.getString("password")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro.");
        }
        if(users.size() != 0) return true;
        return false;
    }
    
    public static User getByLogin(Connection con, String email, String passwd){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        User user = null;
        
        try {
            // criando a instrução SQL
            String comando = "select * from User where email=? and password=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, email);
            instrucaoSQL.setString(2, passwd);
            resultados = instrucaoSQL.executeQuery();

            while (resultados.next()) {
                user = new User(resultados.getInt("id"), resultados.getString("name"), resultados.getString("email"), resultados.getString("password"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados não encontrados.");
        }
        
        return user;
    }
    
    public static ArrayList<User> list(Connection con) {
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        ArrayList<User> users = new ArrayList<User>();
        
        try {
            // criando a instrução SQL
            instrucaoSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultados = instrucaoSQL.executeQuery("select * from User");

            while (resultados.next()) {
                users.add(new User(resultados.getInt("id"), resultados.getString("name"), resultados.getString("email"), resultados.getString("password")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar dados.");
        }
        return users;
    }
    
}
