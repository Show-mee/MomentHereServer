package momenthere.trackmap;

import net.sf.json.JSONObject;

public class JsonTools2 {
	public JsonTools2() {

	}
	public static String createJsonString(String key, Object value){
		JSONObject jsonObject =  new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}
}
