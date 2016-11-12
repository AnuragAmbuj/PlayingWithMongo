package com.aambuj.ops;

import com.aambuj.runtime.InvalidAdminException;
import com.mongodb.*;

/**
 * Created by aambuj on 20-10-2016.
 */
public class DBUtilitiesAdmin {
    MongoClient mongoClient;
    DB database;
    public DBUtilitiesAdmin(String employeeUserName,String referenceNumber,String password) throws InvalidAdminException {
        throw new InvalidAdminException();
    }
    public void createConnection(String url,int port){
        mongoClient = new MongoClient(url,port);
    }
    public DB createDatabase(String databaseName){
        database = mongoClient.getDB(databaseName);
        return database;
    }

    public void createCollection(String collectionName){
        DBObject object = null;
        database.createCollection(collectionName,object);
    }
    public void addAdmin(String employeeName,String referenceNumber,String password){
        DBCollection collection = database.getCollection("admins");
        DBObject object = new BasicDBObject();
        object.put("employeeName",employeeName);
        object.put("referenceNumber",referenceNumber);
        object.put("password",password);
        collection.insert(object);
    }

    /**
     *
     * @param jsonScriptExecutable
     * @param isWellFormed
     * @apiNote DO NOT PASS true always for isWellFormed, only the result of MediaUtils.isWellFormed() should be passed.
     */
    public void executeLTTScript(String jsonScriptExecutable,boolean isWellFormed){
        if(isWellFormed){

        }
    }
    

}
