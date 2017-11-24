package com.kvlabs.filemock.mapper;

/**
 * Supported Deserializer operations
 *
 * @author kanchana-prasanth
 */
public interface Deserializer {

    /**
     * Un marshal json file to Object
     *
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @return un-marshaled value of json
     */
    <T> T deserialize(String path, Class<T> tclass);

    /**
     * Un marshal json file to Object
     *
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @param safeParse
     * @return un-marshaled value of json
     */
    <T> T deserialize(String path, Class<T> tclass, boolean safeParse);
}
