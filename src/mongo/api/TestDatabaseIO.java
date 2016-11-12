package mongo.api;

import com.aambuj.models.User;
import com.aambuj.ops.DBUtilities;

/**
 * Created by aambuj on 11-11-2016.
 */
public class TestDatabaseIO {
    public static void main(String args[]){
        User user = new User("a123","aambuj","aambuj@yodlee.com","samplepass");
        DBUtilities.getUserCollectionProduction().insert(user.toDBObject());
    }
}
