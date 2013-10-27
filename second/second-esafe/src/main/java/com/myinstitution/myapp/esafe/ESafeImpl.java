package com.myinstitution.myapp.esafe;

import java.util.HashMap;

import org.slf4j.Logger;

import com.myinstitution.myapp.common.FilePersistence;
import com.myinstitution.myapp.logger.LoggerFactory;

public class ESafeImpl implements ESafe {
    private static Logger LOGGER = LoggerFactory
            .getLogger(ESafeImpl.class);
    String eSafePath;
    public ESafeImpl(String eSafePath) throws Exception {
        LOGGER.debug("Constructing esafe");
        this.eSafePath = eSafePath;
        HashMap<String, byte[]> hashMap = null;
        try {
            LOGGER.debug("Check if esafe already exist");
            hashMap = retrieveESafe(eSafePath);
        } catch (Exception e) {
            LOGGER.debug("Error retrieving esafe", e);
            try {
                hashMap = new HashMap<String, byte[]>();
                LOGGER.debug("Creating new esafe", e);
                FilePersistence.write(hashMap, eSafePath);
                LOGGER.debug("Created new esafe", e);
            } catch (Exception e1) {
                LOGGER.debug("Error creating new esafe", e);
                throw e1;
            }
        }
    }

    private HashMap<String, byte[]> retrieveESafe(String eSafePath) throws Exception {
        LOGGER.debug("Retrieving esafe");
        Object object = FilePersistence.read(eSafePath);
        LOGGER.debug("Retrieved esafe");
        return (HashMap<String, byte[]>) object;
    }

    public byte[] retrieveItemAsBinary(String key) throws Exception {
        LOGGER.debug("Retrieving item from esafe");
        return retrieveESafe(this.eSafePath).get(key);
    }

    public boolean containsItem(String key) throws Exception {
        LOGGER.debug("Checking if item is there in esafe");
        return retrieveESafe(this.eSafePath).containsKey(key);
    }

    public void removeItem(String key) throws Exception {
        LOGGER.debug("Removing item from esafe");
        HashMap<String, byte[]> hashMap = retrieveESafe(this.eSafePath);
        hashMap.remove(key);
        FilePersistence.write(hashMap, eSafePath);
        LOGGER.debug("Removed item from esafe");
    }

    public void createItem(String baseDataKey, byte[] b) throws Exception {
        LOGGER.debug("Creating item in esafe");
        HashMap<String, byte[]> hashMap = retrieveESafe(this.eSafePath);
        hashMap.put(baseDataKey, b);
        FilePersistence.write(hashMap, eSafePath);
        LOGGER.debug("Created item in esafe");
    }

}
