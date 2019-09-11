package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PolygonObjectDaoImpl implements PolygonObjectDao{
	@SuppressWarnings("unchecked")
	public JSONArray StringArraytoJSONArray(String a) {
		
		a=a.substring(1,a.length()-1);
		String[] words = a.split(",");
		JSONArray result = new JSONArray();
		 for (String w : words) {
			 
			 double d = Double.parseDouble(w);
			 result.add(d);
	            
	        }
		 //System.out.println(result);
		return result;
	}
	@SuppressWarnings("unchecked")
	public JSONArray ArraytoJSONArray(Double [] myArray) {
		
		 JSONArray jsArray = new JSONArray();
	      for (int i = 0; i < myArray.length; i++) {
	    	  jsArray.add(myArray[i]);
	         
	      }
		return jsArray;
		
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject PolygonObject_to_JSONObject(PolygonObject polygon) {
		JSONObject obj= new JSONObject();
		obj.put("Status",polygon.getStatus());
    	obj.put("regions",polygon.getRegionsObject());
    	obj.put("originalRegions",polygon.getOriginalRegionsObject());
    	obj.put("classId",polygon.getClassId());
    	obj.put("listIsAutoLabel",polygon.getListIsAutoLabel());
    	obj.put("pointAutoLabel",polygon.getPointAutoLabel());
    	obj.put("filename",polygon.getFilename());
    	obj.put("width",polygon.getWidth());
    	obj.put("height",polygon.getHeight());
    	return obj;
		
	}
	
	

}
