package JSON;


import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Crunchify.com
 */
 
@SuppressWarnings("unused")
public class CrunchifyJSONReadFromFile {
 
   
    
	
	public static void main(String[] args) {
		
	
    	
    	//polygon=a.ReadJSON("14_B_BBI_DARK_Defect_1.bmp.json");
    	/*
    	
    	System.out.println(polygon.getStatus());
    	System.out.println(polygon.getRegionsObject());
    	System.out.println(polygon.getClassId());
    	
    	System.out.println(polygon.getOriginalRegionsObject());
    	System.out.println(polygon.getCurTorelant());
    	
    	
    	System.out.println(polygon.getFilename()+".json");
    	System.out.println(polygon.getListIsAutoLabel());
    	System.out.println(polygon.getPointAutoLabel());
    	System.out.println(polygon.getWidth());
    	System.out.println(polygon.getHeight());
    	System.out.println(polygon.getCenter());*/
		
		
		
		
		PolygonObject polygon=new PolygonObject(); 
		
		ReadAndWriteJSON a=new ReadAndWriteJSON(); 
		//polygon=a.ReadJSON("14_B_BBI_DARK_Defect_1.bmp.json");
	    polygon.setFilename("15_B_BBI_DARK_Defect_1.bmp");
		
    	
    	Double List_X[]= {373.75,455.75,326.75,350.75,462.75,465.75,413.75,365.75,436.75,524.75,512.75,466.75,508.75,465.75,385.75,436.75,496.75,564.75,540.75,449.75,454.75};
    	
    	Double List_Y[]= {170.296875,271.296875,282.296875,212.296875,176.296875,215.296875,231.296875,167.296875,120.296875,152.296875,209.296875,121.296875,145.296875,221.296875,147.296875,136.296875,167.296875,182.296875,91.296875,46.296875,109.296875};
    	
    	PolygonObjectDaoImpl polygonimpl=new PolygonObjectDaoImpl();
    	polygon.AddRegionObject(polygonimpl.ArraytoJSONArray(List_X),polygonimpl.ArraytoJSONArray(List_Y));
    	polygon.AddRegionObject(polygonimpl.ArraytoJSONArray(List_X),polygonimpl.ArraytoJSONArray(List_Y));
    	polygon.AddRegionObject(polygonimpl.ArraytoJSONArray(List_X),polygonimpl.ArraytoJSONArray(List_Y));
    	polygon.AddOriginalRegionObject(polygonimpl.ArraytoJSONArray(List_X),polygonimpl.ArraytoJSONArray(List_Y));
    	
	    
    	a.WriteJSON(polygon);
    	
		/*String a="[291,306,136,246]";
		PolygonObjectDaoImpl polygonimpl=new PolygonObjectDaoImpl();
		polygonimpl.StringArraytoJSONArray(a);
		System.out.println(polygonimpl.StringArraytoJSONArray(a));
		*/
		String a1="http://localhost:8080/G_Train/images/45_B_BBI_DARK_Defect_1.bmp";
		String[] words = a1.split("/");
		JSONArray result = new JSONArray();
		//System.out.println();
		
		System.out.println(words[words.length-1]);
		 for (String w : words) {
			 //System.out.println(w);
			 
			 //double d = Double.parseDouble(w);
			 
			 //result.add(d);
	            
	        }
	    
		
		
    	
    	
    	
    	
    	
    	
    	
    	
       
    	
    	
        
    }
}
