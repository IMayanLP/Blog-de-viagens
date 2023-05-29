package BR.com.app.blog.classes;

import BR.com.app.blog.classes.entities.Admin;
import BR.com.app.blog.classes.entities.Entity;

public class Section {
    private Entity userLogged;
    private boolean active;

    public Section() {
        this.userLogged = null;
        this.active = false;
    }

    public Entity getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(Entity userLogged) {
        this.userLogged = userLogged;
        this.active = true;
    }
    
    public boolean isAdmin(){
        return (this.userLogged instanceof Admin);
    }
    
    public boolean haveUser() {
        if(this.userLogged != null) return true;
        return false;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void close() {
        setActive(false);
        setUserLogged(null);
    }
    
}
