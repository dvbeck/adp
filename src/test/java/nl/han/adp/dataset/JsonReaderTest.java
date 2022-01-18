package nl.han.adp.dataset;

import nl.han.adp.utility.Constants;
import nl.han.adp.utility.dataset.JsonUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class JsonReaderTest {
    @Test
    void readJsonFile() throws IOException {
        JsonUtils.readFromResources(Constants.Files.DATASET_SORTEREN).map(json -> json.getJSONArray(Constants.Sorteren.SORTEER_LIJST_FLOAT)).ifPresent(arr -> {
            Double[] array = JsonUtils.toDoubleArray(arr);
            array[0] = 11312312312312.324;
            System.out.println(11312312312312.324);
            System.out.println(Arrays.toString(array));
        });


    }
}
