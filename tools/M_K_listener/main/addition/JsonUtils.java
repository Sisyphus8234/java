package addition;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class JsonUtils {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static final String filePathPrefix = "custom/";
    public static final String filePathSuffix = ".json";

    public static <T> T readJsonFile(String fileName, Class<T> valueType) throws IOException {
        File file = new File(filePathPrefix + fileName + filePathSuffix);
        return objectMapper.readValue(file, valueType);
    }

    public static <T> T readJsonFile(String fileName, TypeReference<T> typeReference) throws IOException {
        File file = new File(filePathPrefix + fileName + filePathSuffix);
        return objectMapper.readValue(file, typeReference);
    }

    public static <T> void writeJsonFile(String fileName, T data) throws IOException {
        File file = new File(filePathPrefix + fileName + filePathSuffix);
        objectMapper.writeValue(file, data);
    }


    public static String jsonExample = "jsonExample";
    public static HashMap<String, Point> jsonExampleMap;

    static {
        try {
            TypeReference<HashMap<String, Point>> typeReference = new TypeReference<HashMap<String, Point>>() {
            };
            jsonExampleMap = JsonUtils.readJsonFile(jsonExample, typeReference);
        } catch (IOException e) {
            jsonExampleMap = new HashMap<>();
        }
    }


}
