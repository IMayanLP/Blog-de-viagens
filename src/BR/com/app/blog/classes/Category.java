package BR.com.app.blog.classes;

import BR.com.app.blog.connection.ClassWithCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Category implements ClassWithCRUD {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean insert(Connection con) {
        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String comando = "INSERT INTO Category (id,name)";
            comando = comando + " VALUES (default,?)";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getName());
            instrucaoSQL.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao criar Categoria.");
        }
        return false;
    }

    @Override
    public boolean del(Connection con) {
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String sql = "DELETE FROM Category";
            sql = sql + " WHERE id=?";

            instrucaoSQL = con.prepareStatement(sql);
            instrucaoSQL.setInt(1, getId());
            instrucaoSQL.executeUpdate();

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
            String comando = "Update Category SET name=? where id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getName());
            instrucaoSQL.setInt(2, getId());
            instrucaoSQL.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao editar dados");
        }

        return false;
    }
    
    public static Category getCategory(Connection con, int id){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        Category cat = null;
        
        try {
            // criando a instrução SQL
            String comando = "select * from Category where id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, id);
            resultados = instrucaoSQL.executeQuery();

            while (resultados.next()) {
                cat = new Category(resultados.getInt("id"), resultados.getString("name"));
                return cat;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados.");
        }
        
        return cat;
    }
    
    public static boolean alreadyExists(Connection con, String name){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
        try {
            // criando a instrução SQL
            String comando = "select * from Category where name=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, name);
            resultados = instrucaoSQL.executeQuery();

            if(resultados.next()){
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados.");
        }
        
        return false;
    }
    
    public static Category getByName(Connection con, String name){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        Category cat = null;
        
        try {
            // criando a instrução SQL
            String comando = "select * from Category where name=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, name);
            resultados = instrucaoSQL.executeQuery();

            if(resultados.next()){
                cat = new Category(resultados.getInt("id"), resultados.getString("name"));
                return cat;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados.");
        }
        
        return cat;
    }
    
    public static ArrayList<Category> list(Connection con) {
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet r;
        ArrayList<Category> categories = new ArrayList<Category>();

        try {
            // criando a instrução SQL
            instrucaoSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            r = instrucaoSQL.executeQuery("SELECT * FROM Category");

            while (r.next()) {
                categories.add(new Category(r.getInt("id"), r.getString("name")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as publicações.");
        }

        return categories;
    }   
}
