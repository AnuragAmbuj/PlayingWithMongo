package com.aambuj.ops;

import com.aambuj.models.User;
import com.mongodb.*;

import java.util.ArrayList;

/**
 * Created by aambuj on 18-10-2016.
 */
public class CRUDOperations {

    private MongoClient client;
    private DB db;
    private DBCollection dbCollection;
    WriteResult writeResult;

    private CRUDOperations(){
        client = DBUtilities.getProductionMongoClient();
        db = DBUtilities.getAccountsDbProducton();
        dbCollection = DBUtilities.getUserCollectionProduction();
    }
    public boolean writeUserToDB(User user){
        if(user!=null){
            throw new NullPointerException("Cannot Process Null user");
        }
        DBObject dbObject = DBUtilities.getDBObjectFromUser(user);
        writeResult = dbCollection.insert(dbObject);
        return writeResult.wasAcknowledged();
    }

    public boolean removeUserFromDB(String userId){
       return true;
    }

    public User findUserFromDB(String userId){
        if(userId == null){
            throw new NullPointerException("Unable to Process null userId");
        }
        DBObject object = new BasicDBObject("_id",userId);
        DBCursor cursor = dbCollection.find(object);
        DBObject tempObject;
        if(cursor.hasNext()){
            tempObject = cursor.next();
            return new User(object.get("_id").toString(),object.get("name").toString(),object.get("email").toString(),object.get("password").toString());
        }else
        {
            return null;
        }


    }

    public ArrayList<User> getUserFromDB(String name){
        DBObject object = new BasicDBObject("name",name);
        DBCursor cursor = dbCollection.find(object);
        ArrayList<User> userArrayList = new ArrayList<>();
        while(cursor.hasNext()){
            DBObject userDBObject = cursor.next();
            String id = userDBObject.get("_id").toString();
            String nameTemp = userDBObject.get("name").toString();
            String email = userDBObject.get("email").toString();
            String password = userDBObject.get("password").toString();
            User tUser = new User(id,nameTemp,email,password);
            userArrayList.add(tUser);
        }
        return userArrayList;
    }

}
