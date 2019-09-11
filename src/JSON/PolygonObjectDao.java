package JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public  interface PolygonObjectDao {
	
	public JSONArray ArraytoJSONArray(Double [] myArray) ;
	public JSONObject PolygonObject_to_JSONObject(PolygonObject polygon);
	
	 
	

}
