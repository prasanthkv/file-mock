package com.kvlabs.filemock.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kvlabs.filemock.exception.FileNotFoundException;
import com.kvlabs.filemock.exception.JsonMappingException;

/**
 * Utility class to un marshal service response to mock using jackson (
 * fasterxml)
 *
 * @param <T>
 * @author kanchana-prasanth
 * @link https://github.com/FasterXML/jackson-databind/wiki/Serialization-features
 * @link https://github.com/FasterXML/jackson-databind#commonly-used-features
 * @since 1.0.0
 */
class FileToMockJackson2 implements Deserializer {

    /**
     * Un marshal json file to Object
     *
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @return un-marshaled value of json
     */
    @Override
    public <T> T deserialize(String path, Class<T> tclass) {
        return this.deserialize(path, tclass, true);
    }

    /**
     * Un marshal json file to Object
     *
     * @param path as the patch to json resource
     * @param tclass as the response class
     * @param safeParse
     * @return un-marshaled value of json
     */
    @Override
    public <T> T deserialize(String path, Class<T> tclass, boolean safeParse) {
        InputStream input = this.getClass().getResourceAsStream(path);
        if (input == null) {
            throw new FileNotFoundException("unable to find the given file [" + path + "]");
        }
        //got file
        try (StringWriter writter = new StringWriter()) {
            IOUtils.copy(input, writter);
            String jsonAsAString = writter.toString();
            ObjectMapper mapper = new ObjectMapper();
            if (safeParse) {
                //marking response safe
                // to prevent exception when encountering unknown property:
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                // to allow coercion of JSON empty String ("") to null Object value:
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                //read
            }
            return mapper.readValue(jsonAsAString, tclass);
        } catch (Exception e) {
            throw new JsonMappingException("unable to parse file", e);
        }
    }
}
