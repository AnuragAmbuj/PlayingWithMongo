package mongo.api;

import com.aambuj.utils.MediaUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by aambuj on 11-11-2016.
 */
public class SampleJATest {
    public static void main(String args[]){
        try {
            MediaUtils.parseJSONArrayString(new File("testexample.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
