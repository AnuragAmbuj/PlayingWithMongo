package com.aambuj.ops;

import com.aambuj.models.User;
import com.mongodb.*;

/**
 * Created by aambuj on 18-10-2016.
 */
public class DBUtilities {

    private static final MongoClient PRODUCTION_MONGO_CLIENT = new MongoClient("localhost",27017);
    private static final DB ACCOUNTS_DB_PRODUCTON = PRODUCTION_MONGO_CLIENT.getDB("dbprod");
    private static final DBCollection USER_COLLECTION_PRODUCTION = ACCOUNTS_DB_PRODUCTON.getCollection("users");
    private static final DBCollection ADMIN_COLLECTION_PRODUCTION = ACCOUNTS_DB_PRODUCTON.getCollection("admins");

    public static MongoClient getProductionMongoClient() {
        return PRODUCTION_MONGO_CLIENT;
    }

    public static DB getAccountsDbProducton() {
        return ACCOUNTS_DB_PRODUCTON;
    }

    public static DBCollection getUserCollectionProduction() {
        return USER_COLLECTION_PRODUCTION;
    }

    public static DBCollection getAdminCollectionProduction(){
        return ADMIN_COLLECTION_PRODUCTION;
    }

    public static DBObject getDBObjectFromUser(User user){
        if(user == null){
            throw new NullPointerException("Cannot process null User passed to getDBObject(User user).");
        }
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        builder.append("_id",user.getId());
        builder.append("name",user.getName());
        builder.append("email",user.getEmail());
        builder.append("password",user.getPassword());
        return builder.get();
    }

    public static User toUser(DBObject object){
        String id= object.get("_id").toString();
        String name = object.get("name").toString();
        String email = object.get("email").toString();
        String password = object.get("password").toString();
        return new User(id,name,email,password);
    }

    public static User verifyUserFromDB(String email,String password){

        DBObject queryObject = new BasicDBObject();
        queryObject.put("email",email);
        queryObject.put("password",password);
        DBObject object;
        User user;
        String id = "";
        String name = "";
        String email1 = "";
        String password1 = "";
        DBCursor cursor = getUserCollectionProduction().find(queryObject);
        if(cursor.hasNext()){
            object = cursor.next();
            id= object.get("_id").toString();
            name = object.get("name").toString();
            email1 = object.get("email").toString();
            password1= object.get("password").toString();

        }
        return new User(id,name,email1,password1);
    }


}
