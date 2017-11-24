package io.kvlabs.filemock.mapper;

/**
 * Supported JSON mapper
 *
 * @author kanchana-prasanth
 */
public enum Mapper {
    JACKSON_1,
    JACKSON_2,
    MOSHI,
    GSON;
    
    public static final Mapper DEFAULT = JACKSON_1;
}
