package zuyisf;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class JSONWrite {

    public static void main(String[] args) {
        try {
            Path inputFilePath = Paths.get("orarendZUYISF.json");
            String jsonDocument = Files.readString(inputFilePath);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonDocument);

            printJsonObject(jsonObject, "", System.out);

            JSONObject newJsonObject = copyJsonObject(jsonObject);

            System.out.println("\n\nÚj JSON dokumentum:");
            printJsonObject(newJsonObject, "", System.out);

            Path outputFilePath = Paths.get("orarendZUYISF1.json");
            try (FileWriter fileWriter = new FileWriter(outputFilePath.toFile())) 
            {
                printJsonObject(newJsonObject, "", fileWriter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject copyJsonObject(JSONObject jsonObject) 
    {
        JSONObject newJsonObject = new JSONObject();

        for (Object entryObject : jsonObject.entrySet()) 
        {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) entryObject;
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof JSONObject || value instanceof JSONArray) 
            {
                newJsonObject.put(key, copyJsonValue(value));
            } else 
            {
                newJsonObject.put(key, value);
            }
        }

        return newJsonObject;
    }

    private static Object copyJsonValue(Object value) 
    {
        if (value instanceof JSONObject) 
        {
            return copyJsonObject((JSONObject) value);
        } else if (value instanceof JSONArray) 
        {
            return copyJsonArray((JSONArray) value);
        } else 
        {
            return value;
        }
    }

    private static JSONArray copyJsonArray(JSONArray jsonArray) 
    {
        JSONArray newArray = new JSONArray();
        for (Object arrayElement : jsonArray) 
        {
            newArray.add(copyJsonValue(arrayElement));
        }
        return newArray;
    }

    private static void printJsonObject(JSONObject jsonObject, String indent, Appendable out) 
    {
        try {
            out.append("{\n");
            for (Object entryObject : jsonObject.entrySet()) {
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) entryObject;
                String key = entry.getKey();
                Object value = entry.getValue();

                out.append(indent).append("  \"").append(key).append("\": ");

                if (value instanceof JSONObject) 
                {
                    printJsonObject((JSONObject) value, indent + "  ", out);
                } else if (value instanceof JSONArray) 
                {
                    printJsonArray((JSONArray) value, indent + "  ", out);
                } else 
                {
                    out.append("\"").append(value.toString()).append("\"");
                }

                if (entryObject != jsonObject.entrySet().toArray()[jsonObject.entrySet().size() - 1]) 
                {
                    out.append(",");
                }
                out.append("\n");
            }
            out.append(indent).append("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printJsonArray(JSONArray jsonArray, String indent, Appendable out) 
    {
        try {
            out.append("[\n");
            for (Object arrayElement : jsonArray) 
            {
                if (arrayElement instanceof JSONObject) 
                {
                    printJsonObject((JSONObject) arrayElement, indent + "  ", out);
                } else if (arrayElement instanceof JSONArray) {
                    printJsonArray((JSONArray) arrayElement, indent + "  ", out);
                } else 
                {
                    out.append(indent).append("  \"").append(arrayElement.toString()).append("\"");
                }

                if (arrayElement != jsonArray.toArray()[jsonArray.size() - 1]) 
                {
                    out.append(",");
                }
                out.append("\n");
            }
            out.append(indent).append("]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
