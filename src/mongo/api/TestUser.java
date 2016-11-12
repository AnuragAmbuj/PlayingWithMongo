package mongo.api;

import com.aambuj.models.User;
import com.aambuj.ops.DBUtilities;
import com.aambuj.utils.MediaUtils;
import com.mongodb.DBObject;
import com.sun.media.jfxmedia.Media;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by aambuj on 19-10-2016.
 */
public class TestUser {
    public static void main(String args[]){

        User user = new User("34590","aambuj","abc@gmail.com","aambuj");
        System.out.println(user.toJSONString());
        DBObject object = MediaUtils.parseJSONString(user.toJSONString());
        DBObject newObject = MediaUtils.parseJSONString("{\"_id\":\"123\"}");
        System.out.println(newObject);
        System.out.println(object);
        System.out.println(user.toDBObject());
        HashMap<String,String> hashMap = MediaUtils.parseJSONString(user.toJSONString(),true);
        System.out.println("Printing from hashtable");
        Set<String> keySet = hashMap.keySet();
        for(String key:keySet){

            System.out.println("Key:"+key+" and value is "+ hashMap.get(key));
        }
    }
}
