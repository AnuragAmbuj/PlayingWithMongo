package com.aambuj.runtime;

/**
 * Created by aambuj on 31-10-2016.
 */
public class InvalidAdminException extends Throwable {

    public InvalidAdminException(){
        new RuntimeException("Invalid Admin Exception");
    }

    public String getMessage(){
        return "Not a valid admin. Please contact Operations Team to resolve the issue";
    }

}
