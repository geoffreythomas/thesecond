package com.myinstitution.myapp.esafe;

public interface ESafe {

    byte[] retrieveItemAsBinary(String key) throws Exception;

    boolean containsItem(String key) throws Exception;

    void removeItem(String key) throws Exception;

    void createItem(String key, byte[] b) throws Exception;

}
