package com.aambuj.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONCallback;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by aambuj on 02-11-2016.
 */
public class MediaUtils {
    public static DBObject parseJSONString(String jsonString){
        DBObject object = new BasicDBObject();
        jsonString = jsonString.replace("{","");
        jsonString = jsonString.replace("}","");
        StringTokenizer keyVals = new StringTokenizer(jsonString,",");
        while(keyVals.hasMoreTokens()){
            String token = keyVals.nextToken();
            token = token.replace("\"","");
            String[] kVs = token.split(":");
            System.out.println("Key: "+kVs[0]+" and value "+kVs[1]);
            object.put(kVs[0],kVs[1]);
        }
        return object;
    }

    public static void parseJSONArrayString(File jsonStringFile) throws FileNotFoundException {
        Scanner scan = new Scanner(jsonStringFile);
        String fileContents ="";
        while(scan.hasNextLine()){
            fileContents = fileContents + scan.nextLine();
        }
        fileContents = fileContents.replace("[","");
        fileContents = fileContents.replace("]","");
        int runningIndex = fileContents.indexOf('{');
        int endIndex = fileContents.indexOf(',');
        while(endIndex <= fileContents.length()-1){
           String json = fileContents.substring(runningIndex,endIndex-1);
           fileContents = fileContents.substring(json.length()-1);
           runningIndex = fileContents.indexOf('{');
           endIndex = fileContents.indexOf('}');
            System.out.println("____________________");
            System.out.println(json);

        }
    }

    /**
     *
     * @param jsonString Takes a well formed JSON as a string and parses it into a hash map value
     * @param isWellFormed Takes the boolean result of isJSONStringValidated(String jsonString), or any custom method that checks the well forming of the json as a string
     * @return <b>HashMap</b>
     * @apiNote Please do not always pass true for isWellFormed boolean parameter, check if the json is truely well formed and then pass true. Pass false if the JSON is loaded from external sources so that appropriate action can be taken when error string is obtained.
     */

    public static HashMap<String,String> parseJSONString(String jsonString,boolean isWellFormed){

        HashMap<String,String> stringHashMap= new HashMap<>();
        if(isWellFormed) {
            jsonString = jsonString.replace("{", "");
            jsonString = jsonString.replace("}", "");
            StringTokenizer keyVals = new StringTokenizer(jsonString, ",");
            while (keyVals.hasMoreTokens()) {
                String token = keyVals.nextToken();
                token = token.replace("\"", "");
                String[] kVs = token.split(":");
                System.out.println("Key: " + kVs[0] + " and value " + kVs[1]);
                stringHashMap.put(kVs[0], kVs[1]);
            }
        }else{
            stringHashMap.put("error","JSON is not well formed and hence cannot be processed");
        }
        return stringHashMap;
    }
    public static String getJSONString(DBObject object){
        return object.toString();
    }

    public static boolean isJSONStringValidated(String jsonString){
        if(jsonString.startsWith("{") && jsonString.endsWith("}"))
            return true;
        else
            return false;
    }

    public static DBObject convert(HashMap<String,String> jsonHashMap){
        //TODO
        return null;
    }

    public static HashMap<String,String> convert(DBObject object){
        //TODO
        return null;
    }
}
