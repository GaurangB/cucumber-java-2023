package util;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtil {

    public static String getJsonArrayFileAsString(String fullPath) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fullPath)) {

            //Read JSON file
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            return jsonArray.toString();

        } catch (Exception ignored) {
            return null;
        }
    }
}
