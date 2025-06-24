package base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtil {

    public static final ObjectMapper objectMapper = new ObjectMapper();

//    public static final String filePathPrefix = "custom/";
//    public static final String filePathSuffix = ".json";

    public static <T> T readJsonFile(String fileName, Class<T> valueType) {
        File file = new File(fileName);
        try {
            return objectMapper.readValue(file, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readJsonFile(String fileName, TypeReference<T> typeReference) {
        File file = new File(fileName);
        try {
            return objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void writeJsonFile(String fileName, T data) {
        try {
            File file = new File(fileName);
            objectMapper.writeValue(file, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    public static String jsonExample = "jsonExample";
//    public static HashMap<String, Point> jsonExampleMap;
//
//    static {
//        TypeReference<HashMap<String, Point>> typeReference = new TypeReference<HashMap<String, Point>>() {
//        };
//        jsonExampleMap = JsonUtils.readJsonFile(jsonExample, typeReference);
//
//    }


}
