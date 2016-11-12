package mongo.api;

import com.mongodb.*;

/**
 * Created by aambuj on 18-10-2016.
 */
public class TestMongoConnection {
    public static void main(String args[]){
        MongoClient client = new MongoClient("localhost",27017);
        DB db = client.getDB("aambuj");
        DBCollection collection = db.getCollection("asgard");
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        builder.append("_id","ID123");
        builder.append("name","Anurag");
        builder.append("email","aambuj@yodlee.com");
        DBObject object = builder.get();
        WriteResult result = collection.insert(object);
        if(result.isUpdateOfExisting()){
            System.out.println("updated the required rows");
        }
    }
}
