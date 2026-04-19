package dataDrivenTesting;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingDataFromJSON {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader=new FileReader("./src\\test\\resources\\CommonData.json");
		JSONParser ref=new JSONParser();
		Object javaObj = ref.parse(reader);
		JSONObject jsonObj=(JSONObject)javaObj;
		String value=jsonObj.get("browser").toString();
		System.out.println(value);
	}

}
