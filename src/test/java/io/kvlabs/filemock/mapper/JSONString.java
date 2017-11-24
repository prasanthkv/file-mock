package io.kvlabs.filemock.mapper;

/**
 *
 * @author kanchana
 */
class JSONString {

    static final String SAMPLE_POJO = "{\"boolean\":true,\"integer\":123,\"string\":\"File Mock\",\"array\":[1,2,3],\"sub_object\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},\"meta_data\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"}}";
    static final String SAMPLE_POJO_MISSING = "{\"boolean\":true,\"integer\":123,\"string\":\"File Mock\",\"sub_object\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"}}";
    static final String SAMPLE_POJO_MORE = "{\"boolean\":true,\"name\":\"kanchana\",\"integer\":123,\"string\":\"File Mock\",\"array\":[1,2,3],\"sub_object\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},\"meta_data\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"}}";
    static final String SAMPLE_POJO_ERROR = "---- asdas:asd";
}
