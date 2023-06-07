package BR.com.app.blog.classes;

import BR.com.app.blog.connection.ClassWithCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BR.com.app.blog.classes.utils.Utils;

public class Post implements ClassWithCRUD {

    private int id;
    private String title;
    private String description;
    private String content;
    private String date;
    private int Admin_id;
    private int Category_id;

    public Post(int id, String title, String description, String date, String content, int Admin_id, int Category_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        if (date == null) {
            this.date = Utils.getDate();
        } else {
            this.date = date;
        }
        this.Admin_id = Admin_id;
        this.Category_id = Category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAdmin_id() {
        return Admin_id;
    }

    public void setAdmin_id(int Admin_id) {
        this.Admin_id = Admin_id;
    }
    
    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int Category_id) {
        this.Category_id = Category_id;
    }

    @Override
    public boolean insert(Connection con) {
        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String comando = "INSERT INTO Post (id,title,description,content,date,Admin_id,Category_id)";
            comando = comando + " VALUES (default,?,?,?,?,?,?)";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getTitle());
            instrucaoSQL.setString(2, getDescription());
            instrucaoSQL.setString(3, getContent());
            instrucaoSQL.setString(4, getDate());
            instrucaoSQL.setInt(5, getAdmin_id());
            instrucaoSQL.setInt(6, getCategory_id());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao criar Post.");
        }

        return false;

    }

    @Override
    public boolean del(Connection con) {
        PreparedStatement instrucaoSQL;

        try {
            // criando a instrução SQL
            String sql = "DELETE FROM Post";
            sql = sql + " WHERE id = ?";

            Rating.deleteAllRatingByPostId(con, getId());

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
            String comando = "UPDATE Post SET title=?, description=?, content=?, date=?, Admin_id=?, Category_id=? where (id=?)";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setString(1, getTitle());
            instrucaoSQL.setString(2, getDescription());
            instrucaoSQL.setString(3, getContent());
            instrucaoSQL.setString(4, getDate());
            instrucaoSQL.setInt(5, getAdmin_id());
            instrucaoSQL.setInt(6, getCategory_id());
            instrucaoSQL.setInt(7, getId());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editado com sucesso");

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao editar dados");
        }

        return false;
    }

    public static Post getById(Connection con, int id) {
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        Post post = null;

        try {
            // criando a instrução SQL
            String comando = "select * from Post where id=?";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, id);
            resultados = instrucaoSQL.executeQuery();

            while (resultados.next()) {
                post = new Post(resultados.getInt("id"), resultados.getString("title"), resultados.getString("description"), resultados.getString("date"), resultados.getString("content"), resultados.getInt("Admin_id"), resultados.getInt("Category_id"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Publicação não encontrada.");
        }

        return post;
    }

    public static ArrayList<Post> list(Connection con) {
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet r;
        ArrayList<Post> posts = new ArrayList<Post>();

        try {
            // criando a instrução SQL
            instrucaoSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // pequena gambiarra pra converter a string data (DD/MM/AAAA) pro datetime do SQL, essa eu tive que pensar
            r = instrucaoSQL.executeQuery("SELECT * FROM Post ORDER BY cast(concat(substring(date,7,4),'-',substring(date,4,2),'-',substring(date,1,2)) as date) DESC");

            while (r.next()) {
                posts.add(new Post(r.getInt("id"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getString("date"),
                        r.getString("content"),
                        r.getInt("Admin_id"),
                        r.getInt("Category_id")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as publicações.");
        }

        return posts;
    }
    
    public static ArrayList<Post> listByCategory(Connection con, int cat_id) {
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet r;
        ArrayList<Post> posts = new ArrayList<Post>();

        try {
            // criando a instrução SQL
            String comando = "SELECT * FROM Post WHERE Category_id = ? ORDER BY cast(concat(substring(date,7,4),'-',substring(date,4,2),'-',substring(date,1,2)) as date) DESC";
            instrucaoSQL = con.prepareStatement(comando);
            instrucaoSQL.setInt(1, cat_id);
            r = instrucaoSQL.executeQuery();
            
            while (r.next()) {
                posts.add(new Post(r.getInt("id"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getString("date"),
                        r.getString("content"),
                        r.getInt("Admin_id"),
                        r.getInt("Category_id")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as publicações.");
        }

        return posts;
    }

}
