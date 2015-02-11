package momenhere.tools;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param object
	 * @return
	 */
	public static String createJsonString(Object value) {
		System.out.println("value"+value.toString());
		Gson gson = new Gson();
		System.out.println("11");
		String str = gson.toJson(value);//from json to string
		System.out.println("22");
		return str;
	}

}
