package frsp.Model;

import java.io.Serializable;

public class Users implements Serializable
{
    private String name;
    private String email;
    private String password;
    private String id;
    
    public Users(){
        name = null;
        email = null;
        password = null;
    }
    public Users(String n, String e, String p){
        name = n;
        email = e;
        password = p;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setID(String n){
        id = n;
    }
    public String getID(){
        return id;
    }
    public void setPassword(String password) {
        this.password = password;
    }   
    public String toString(){
        return id+"%"+name+"%"+email+"%"+password+"£";
    }
    
}
