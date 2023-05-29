package BR.com.app.blog.classes.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Admin extends Entity {
    
    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    
    @Override
    public boolean insert(Connection con) {
        //intruçao sql
        PreparedStatement instrucaoSQL;
        if(alreadyExists(con)) {
            JOptionPane.showMessageDialog(null, "Email ja utilizado.");
            return false;
        }

        try {
            // criando a instrução SQL
            String comando = "INSERT INTO Admin (id,name,email,password)";
            comando = comando + " VALUES (default,?,?,?)";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getName());
            instrucaoSQL.setString(2, getEmail());
            instrucaoSQL.setString(3, getPassword());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao adicionar o Admin.");
        }
        
        return false;
        
    }

    @Override
    public boolean del(Connection con) {
        PreparedStatement instrucaoSQL;
        
        try {
            // criando a instrução SQL
            String sql = "DELETE FROM Admin";
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
            String comando = "Update Admin SET name=?,email=?,password=? where id=?";
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
        ArrayList<Admin> admins = new ArrayList<Admin>();
        
        try {
            // criando a instrução SQL
            String comando = "select * from Admin where email=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getEmail());
            resultados = instrucaoSQL.executeQuery();
            
            while (resultados.next()) {
                admins.add(new Admin(resultados.getInt("id"), resultados.getString("name"), resultados.getString("email"), resultados.getString("password")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro.");
        }
        if(admins.size() != 0) return true;
        return false;
    }
    
    public static Admin getByLogin(Connection con, String email, String passwd){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        Admin admin = null;
        
        try {
            // criando a instrução SQL
            String comando = "select * from Admin where email=? and password=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, email);
            instrucaoSQL.setString(2, passwd);
            resultados = instrucaoSQL.executeQuery();

            while (resultados.next()) {
                admin = new Admin(resultados.getInt("id"), resultados.getString("name"), resultados.getString("email"), resultados.getString("password"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados não encontrados.");
        }
        
        return admin;
    }
    
    public static Admin getById(Connection con, int id){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        Admin admin = null;
        
        try {
            // criando a instrução SQL
            String comando = "select * from Admin where id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, id);
            resultados = instrucaoSQL.executeQuery();

            while (resultados.next()) {
                admin = new Admin(resultados.getInt("id"), resultados.getString("name"), resultados.getString("email"), resultados.getString("password"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados.");
        }
        
        return admin;
    }
    
    public static ArrayList<Admin> list(Connection con) {
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        ArrayList<Admin> admins = new ArrayList<Admin>();
        
        try {
            // criando a instrução SQL
            instrucaoSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultados = instrucaoSQL.executeQuery("select * from Admin");

            while (resultados.next()) {
                admins.add(new Admin(resultados.getInt("id"), resultados.getString("name"), resultados.getString("email"), resultados.getString("password")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar dados.");
        }
        return admins;
    }
    
}
