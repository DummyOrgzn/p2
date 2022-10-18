import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Test {

    public static void main (String args[]) throws IOException {
        FileInputStream report = new FileInputStream("C:\\Users\\Saiprasad\\Downloads\\Lacework-3589623644698828724.json");
        String ra = report.toString();
        ArrayNode finalReports = new ObjectMapper().createArrayNode();
        JsonNode reports = new ObjectMapper().readTree(report);
        if (reports == null || reports.isEmpty())
            System.out.println("Genda");

        Iterator<Map.Entry<String, JsonNode>> fields = reports.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            if (!field.getKey().equalsIgnoreCase("processedFiles"))
                finalReports.add((JsonNodeFactory.instance.objectNode()).set(field.getKey(), field.getValue()));
        }

        String lastDate = reports.get("processedFiles").toString();

        System.out.println(lastDate);
		System.out.println("aws_access_key_id : sdefasd97asdgfuas9dfgh9a");
		System.out.println("aws_secret_access_key : sdefasd97asdgfuas9dfgh9a");
		System.out.println(lastDate);
    }
}
