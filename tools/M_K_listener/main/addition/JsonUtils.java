package addition;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonUtils {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static final String filePathPrefix="custom/";
    public static final String filePathSuffix=".json";

    public static <T> T readJsonFile(String fileName, Class<T> valueType) throws IOException {
            File file = new File(filePathPrefix+fileName+filePathSuffix);
            return objectMapper.readValue(file, valueType);
    }
    public static <T> T readJsonFile(String fileName, TypeReference<T> typeReference) throws IOException {
        File file = new File(filePathPrefix+fileName+filePathSuffix);
        return objectMapper.readValue(file, typeReference);
    }

    public static <T> void writeJsonFile(String fileName, T data) throws IOException {
            File file = new File(filePathPrefix+fileName+filePathSuffix);
            objectMapper.writeValue(file, data);
    }




}
