package io.kvlabs.filemock;

import io.kvlabs.filemock.mapper.Mapper;
import io.kvlabs.filemock.mapper.Deserializer;
import io.kvlabs.filemock.mapper.DeserializerFactory;

/**
 *
 * @author kanchana-prasanth
 */
public class FileToMock {

    /**
     * Creates mock object of given class with the JSON data provided in the
     * path.
     *
     * @param <T> as the class type
     * @param filePath as the path to the mock file
     * @param classToMock class or interface to mock
     * @return mock object
     */
    public static <T> T mockFile(String filePath, Class<T> classToMock) {
        return mockFile(filePath, Mapper.JACKSON_1, true, classToMock);
    }

    /**
     * Creates mock object of given class with the JSON data provided in the
     * path.
     *
     * @param <T> as the class type
     * @param filePath as the path to the mock file
     * @param mapper type of Mapper need to used
     * @param classToMock class or interface to mock
     * @return mock object
     */
    public static <T> T mockFile(String filePath, Mapper mapper, Class<T> classToMock) {
        return mockFile(filePath, mapper, true, classToMock);
    }

    /**
     * Creates mock object of given class with the JSON data provided in the
     * path.
     *
     * @param <T> as the class type
     * @param filePath as the path to the mock file
     * @param mapper type of Mapper need to used
     * @param safe if set true this will ignore the json schema mismatch
     * @param classToMock class or interface to mock
     * @return mock object
     */
    public static <T> T mockFile(String filePath, Mapper mapper, boolean safe, Class<T> classToMock) {
        Deserializer deserializer = DeserializerFactory.create(mapper);
        return deserializer.deserialize(filePath, classToMock, safe);
    }
}
