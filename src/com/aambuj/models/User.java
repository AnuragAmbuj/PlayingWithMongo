package com.aambuj.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.StringTokenizer;

/**
 * Created by aambuj on 19-10-2016.
 */
public class User {
    private String id;
    private String name;
    private String email;
    private String password;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJSONString(){

        String flow =  "{";
        flow = flow + "\"_id\":"+"\""+id+"\""+",";
        flow = flow + "\"name\":"+"\""+name+"\""+",";
        flow = flow + "\"email\":"+"\""+email+"\""+",";
        flow = flow + "\"password\":"+"\""+password.hashCode()+"\""+"}";
        return flow;
    }

    public DBObject toDBObject(){
        DBObject object = new BasicDBObject();
        object.put("_id",id);
        object.put("name",name);
        object.put("email",email);
        object.put("password",password);
        return object;
    }


}
