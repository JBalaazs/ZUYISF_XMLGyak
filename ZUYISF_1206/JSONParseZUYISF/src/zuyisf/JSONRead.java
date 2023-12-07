package zuyisf;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class JSONRead {

    public static void main(String[] args) {
        try {
            Path inputFilePath = Paths.get("orarendZUYISF.json");
            String jsonDocument = Files.readString(inputFilePath);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonDocument);

            StringBuilder result = new StringBuilder();
            printJsonObject(jsonObject, "", result);

            //Kiírjuk a szöveget a konzolra
            System.out.println(result.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printJsonObject(JSONObject jsonObject, String indent, StringBuilder result) {
        for (Object entryObject : jsonObject.entrySet()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) entryObject;
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof JSONObject || value instanceof JSONArray) {
                result.append(indent).append(key).append(": ").append("\n");
                printJsonValue(value, indent + "  ", result);
            } else {
                result.append(indent).append(key).append(": ").append(value).append("\n");
            }
        }
    }

    private static void printJsonArray(JSONArray jsonArray, String indent, StringBuilder result) {
        for (Object arrayElement : jsonArray) {
            printJsonValue(arrayElement, indent, result);
        }
    }

    private static void printJsonValue(Object value, String indent, StringBuilder result) {
        if (value instanceof JSONObject) {
            printJsonObject((JSONObject) value, indent + "  ", result);
        } else if (value instanceof JSONArray) {
            printJsonArray((JSONArray) value, indent + "  ", result);
        } else {
            result.append(indent).append(value).append("\n");
        }
    }
}
