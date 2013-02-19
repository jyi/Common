package util.data.json;

import java.math.BigInteger;

import com.sdicons.json.model.JSONInteger;
import com.sdicons.json.model.JSONObject;
import com.sdicons.json.model.JSONString;
import com.sdicons.json.model.JSONValue;

public class Json {

	public static String getStr(JSONObject o, String key) {
		JSONValue v = o.get(key);
		assert v.isString();
		String rst = ((JSONString) v).getValue();
		return rst;
	}

	public static int getInt(JSONObject o, String key) {
		JSONValue v = o.get(key);
		assert v.isInteger();
		BigInteger rst = ((JSONInteger) v).getValue();
		return rst.intValue();
	}

	public static long getLong(JSONObject o, String key) {
		JSONValue v = o.get(key);
		assert v.isInteger();
		BigInteger rst = ((JSONInteger) v).getValue();
		return rst.longValue();
	}

}
