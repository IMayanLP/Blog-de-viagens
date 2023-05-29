package BR.com.app.blog.connection;

import java.sql.Connection;

public interface ClassWithCRUD {
    
    public abstract boolean insert(Connection con);
    public abstract boolean del(Connection con);
    public abstract boolean update(Connection con);
    
}
