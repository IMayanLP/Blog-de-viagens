package BR.com.app.blog.classes;

import BR.com.app.blog.connection.ClassWithCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Rating implements ClassWithCRUD {
    private int id;
    private int User_id;
    private int Post_id;
    private int isLiked;

    public Rating(int id, int User_id, int Post_id, int isLiked) {
        this.id = id;
        this.User_id = User_id;
        this.Post_id = Post_id;
        this.isLiked = isLiked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public int getPost_id() {
        return Post_id;
    }

    public void setPost_id(int Post_id) {
        this.Post_id = Post_id;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }
    
    @Override
    public boolean insert(Connection con) {
        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String comando = "INSERT INTO Rating (id,User_id,Post_id,isLiked)";
            comando = comando + " VALUES (default,?,?,?)";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, getUser_id());
            instrucaoSQL.setInt(2, getPost_id());
            instrucaoSQL.setInt(3, getIsLiked());
            instrucaoSQL.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao criar Avaliação.");
        }
        return false;
    }

    @Override
    public boolean del(Connection con) {
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String sql = "DELETE FROM Rating";
            sql = sql + " WHERE User_id=? and Post_id=?";

            instrucaoSQL = con.prepareStatement(sql);
            instrucaoSQL.setInt(1, getUser_id());
            instrucaoSQL.setInt(2, getPost_id());
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
            String comando = "Update Rating SET isLiked=? where id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, getIsLiked());
            instrucaoSQL.setInt(2, getId());
            instrucaoSQL.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao editar dados");
        }

        return false;
    }

    public boolean alreadyRated(Connection con){
        PreparedStatement instrucaoSQL;
        ResultSet resultados;
        ArrayList<Rating> rates = new ArrayList<>();
        
        try {
            // criando a instrução SQL
            String comando = "select * from Rating where User_id=? and Post_id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, getUser_id());
            instrucaoSQL.setInt(2, getPost_id());
            resultados = instrucaoSQL.executeQuery();
            
            while (resultados.next()) {
                rates.add(new Rating(resultados.getInt("id"), resultados.getInt("User_id"), resultados.getInt("Post_id"), resultados.getInt("isLiked")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro.");
        }
        if(rates.size() != 0) return true;
        return false;
    }
    
    public static Rating getRate(Connection con, int user_id, int post_id){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        Rating rate = null;
        
        try {
            // criando a instrução SQL
            String comando = "select * from Rating where User_id=? and Post_id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, user_id);
            instrucaoSQL.setInt(2, post_id);
            resultados = instrucaoSQL.executeQuery();

            while (resultados.next()) {
                rate = new Rating(resultados.getInt("id"), resultados.getInt("User_id"), resultados.getInt("Post_id"), resultados.getInt("isLiked"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados.");
        }
        
        return rate;
    }
    
    public static int quanityRating(Connection con, int post_id, int is_liked){
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        int count = 0;
        
        try {
            // criando a instrução SQL
            String comando = "select * from Rating where Post_id=? and isLiked=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, post_id);
            instrucaoSQL.setInt(2, is_liked);
            resultados = instrucaoSQL.executeQuery();

            while (resultados.next()) {
                count++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados.");
        }
        
        return count;
    }
    
    public static boolean deleteAllRatingByPostId(Connection con, int post_id) {
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String sql = "DELETE FROM Rating";
            sql = sql + " WHERE Post_id=?";

            instrucaoSQL = con.prepareStatement(sql);
            instrucaoSQL.setInt(1, post_id);
            instrucaoSQL.executeUpdate();

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir.");
        }
        return false;
    }
}
