package nl.han.adp.utility.dataset;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
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

    public static List<Integer> toIntegerList(JSONArray array)  {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<array.length(); i++) {
            var val = array.getInt(i);
            list.add(val);
        }
        return list;
    }

    public static Object[] toObjectArray(JSONArray array)  {
        return toArrayI(array, Object[].class);
    }


    public static Double[] toDoubleArray(JSONArray array)  {
        return toArrayI(array, Double[].class);
    }

    public static List<List<Integer>> toIntegerListList(JSONArray array)  {
        TypeFactory typeFactory = new ObjectMapper().getTypeFactory();
        CollectionType listType = typeFactory.constructCollectionType(List.class, Integer.class);
        CollectionType listListType = typeFactory.constructCollectionType(List.class, listType);
        try {
            return objectMapper.readValue(array.toString(), listListType);
        } catch (Exception e) {
            return null;
        }
    }

    private static <T> T toArrayI(JSONArray array, Class<T> type) {
        try {
            return objectMapper.readValue(array.toString(), type);
        } catch (Exception e) {
            return null;
        }
    }

    public static Map<String, List<Integer>> toStringIntegerListMap(JSONObject jsonObject) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String key : jsonObject.keySet()) {
            List<Integer> value = JsonUtils.toIntegerList(jsonObject.getJSONArray(key));
            map.put(key, value);
        }
        return map;
    }

}
