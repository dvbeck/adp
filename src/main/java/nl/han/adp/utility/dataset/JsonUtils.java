package nl.han.adp.utility.dataset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.stream.Collectors;

public class JsonUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static Optional<JSONObject> readFromResources(String filename) {
        InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream(filename);
        if (is != null) {
            var str = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
            return Optional.of(new JSONObject(str));
        }
        return Optional.empty();
    }

    public static Integer[] toIntegerArray(JSONArray array)  {
        return toArrayI(array, Integer[].class);
    }

    public static Double[] toDoubleArray(JSONArray array)  {
        return toArrayI(array, Double[].class);
    }

    private static <T> T toArrayI(JSONArray array, Class<T> type) {
        try {
            return objectMapper.readValue(array.toString(), type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
