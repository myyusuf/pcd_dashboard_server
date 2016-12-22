package id.co.wika.pcd.dashboard;

import java.util.HashMap;
import java.util.Map;

public class ResponseHelper {
	public static Map<String, String> responseSuccess(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Status", "Success");
		return map;
	}
}
