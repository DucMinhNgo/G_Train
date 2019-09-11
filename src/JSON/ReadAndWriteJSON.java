package JSON;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadAndWriteJSON {
	public PolygonObject ReadJSON(String path) {
		PolygonObject polygon=new PolygonObject(); 
		
		JSONParser parser = new JSONParser();
		 
        try {
        	
 
            Object obj = parser.parse(new FileReader(path));
 
            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject);
 
            //String Status = (String) jsonObject.get("Status");
            //System.out.println("Status: " + Status);
            
           
            
            //String originalRegions = (String) jsonObject.get("originalRegions");
            
            JSONObject originalRegionsObject =(JSONObject) jsonObject.get("originalRegions");
            polygon.setOriginalRegionsObject(originalRegionsObject);
            
            //System.out.println("\n originalRegions: " +originalRegionsObject);
            
            //show 
            for (int i = 0; i < originalRegionsObject.size(); i++) {
            	//System.out.println(Integer.toString(i));
            	
            	JSONObject idOriginal =(JSONObject) originalRegionsObject.get(Integer.toString(i));
            	
            	//System.out.println("\n id: " +idOriginal);
            	Double curTorelant = (Double) idOriginal.get("curTorelant");
            	polygon.setCurTorelant(curTorelant);
            	
            	//System.out.println("\n curTorelant: " +curTorelant);
            	String Center = (String) idOriginal.get("Center");
            	polygon.setCenter(Center);
            	//System.out.println("\n Center: " +Center);
            	
            	//String curTorelant = (String) idOriginal.get("curTorelant");
            	
            	/*
            	JSONArray List_Y = (JSONArray) idOriginal.get("List_Y");
            	
                System.out.println("\n List_Y:");
                System.out.println(List_Y);
                Iterator<Double> iterator = List_Y.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                */
                //JSONArray List_X = (JSONArray) idOriginal.get("List_X");
                /*
                System.out.println("\n List_X:");
                System.out.println(List_X);
                
                Iterator<Double> iterator1 = List_X.iterator();
                while (iterator1.hasNext()) {
                    System.out.println(iterator1.next());
                }
                */
                
                
            	
            	
            	
            	
            }
          
            
            //System.out.println();
            
            
            
            
            
           // JSONObject idOriginalRegions =(JSONObject) jsonObject.get("0");
            //System.out.println("0: " +idOriginalRegions);
            
            
            
            //int Status = Integer.parseInt((String) jsonObject.get("Status"));
            //int Status=(int) jsonObject.get("Status");
            
            
            //String regions = (String) jsonObject.get("regions");
            
            
            
            JSONArray classId = (JSONArray) jsonObject.get("classId");
            polygon.setClassId(classId);
            /*
            System.out.println("\n classId:");
            Iterator<String> iterator = classId.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/
            
            
            
            JSONObject RegionsObject =(JSONObject) jsonObject.get("regions");
            polygon.setRegionsObject(RegionsObject);
            //System.out.println("\n regions: " +RegionsObject);
            
            String filename = (String) jsonObject.get("filename");
            polygon.setFilename(filename);
           // System.out.println("\n filename: " + filename);
            
            
            
            
            JSONArray listIsAutoLabel = (JSONArray) jsonObject.get("listIsAutoLabel");
            polygon.setListIsAutoLabel(listIsAutoLabel);
            
            //System.out.println("\n listIsAutoLabel:");
            
           /* Iterator<Boolean> iterator1 = listIsAutoLabel.iterator();
            while (iterator1.hasNext()) {
                System.out.println(iterator1.next());
            }
            */
            
            JSONArray pointAutoLabel = (JSONArray) jsonObject.get("pointAutoLabel");
            
            polygon.setPointAutoLabel(pointAutoLabel);
            
            //System.out.println("\n pointAutoLabel:");
            /*
            Iterator<String> iterator2 = pointAutoLabel.iterator();
            while (iterator2.hasNext()) {
                System.out.println(iterator2.next());
            }
            
            */
            
            
            //System.out.println("Status: " +Status);
            
            long width = (long) jsonObject.get("width");
            polygon.setWidth(width);
           // String  width = (String) jsonObject.get("width");
            //System.out.println("\n width: " + width);
            
            
           long height = (long) jsonObject.get("height");
           polygon.setHeight(height);
            //System.out.println("\n height: " +height);
            
            long Status = (long) jsonObject.get("Status");
            polygon.setStatus(Status);
            //System.out.println("Status: " +Status);
            
           
            
            
            
            
 
            
            //System.out.println("Regions: " + regions);
            
            
           
            
           
            
           
            
            
          
            
           
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		return polygon;
	}
	public boolean WriteJSON(PolygonObject polygon) {
		PolygonObjectDaoImpl polygonImpl=new PolygonObjectDaoImpl();
		
		JSONObject obj= new JSONObject();
		obj=polygonImpl.PolygonObject_to_JSONObject(polygon);
		
		String namefileJSON;
		//namefileJSON="WebContent/DataJSON/"+polygon.getFilename()+".json";
		namefileJSON="C:\\Users\\Admin\\eclipse-workspace\\G_train\\WebContent\\DataJSON\\"+polygon.getFilename()+".json";
		//namefileJSON=polygon.getFilename()+".json";
		
		//System.out.println(obj);
    	try (FileWriter file = new FileWriter(namefileJSON)) {
			file.write(obj.toJSONString());
			//System.out.println("Successfully Copied JSON Object to File...");
			//System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean WriteJSON() {
		/*
    	ReadAndWriteJSON a=new ReadAndWriteJSON();
    	a.ReadJSON("14_B_BBI_DARK_Defect_1.bmp.json");*/
    	//Array[] a=[];
    	//double[] longArray=new double[] {250.0,243.0,240.0,241.0,246.0,252.0,254.0,254.0,251.0,258.0,263.0,265.0,264.0,262.0,262.0,256.0};
    	
    	//JSONArray List_X=longArray;
    	
    	JSONArray List_X = new JSONArray();
    	//double[] longArray=new double[] {250.0,243.0,240.0,241.0,246.0,252.0,254.0,254.0,251.0,258.0,263.0,265.0,264.0,262.0,262.0,256.0};
    	
    	//List_X.add(longArray);
    	
    	List_X.add(250.0);
    	List_X.add(243.0);
    	List_X.add(240.0);
    	/*
    	System.out.println("\n List_X:");
    	System.out.println(List_X);
    	Iterator<Double> iterator1 = List_X.iterator();
        while (iterator1.hasNext()) {
        	//Double a1=iterator1.next();
            System.out.println(iterator1.next());
        }
        */
        
        
        JSONArray List_Y = new JSONArray();
        //System.out.println(List_Y);
    	List_Y.add(251.0);
    	List_Y.add(241.0);
    	List_Y.add(241.0);
    	
    	String Center="0,0";
    	Double curTorelant=0.0;
    	
    	JSONObject temptObject= new JSONObject();
    	temptObject.put("List_Y",List_Y);
    	temptObject.put("Center",Center);
    	temptObject.put("curTorelant",curTorelant);
    	temptObject.put("List_X",List_X);
    	
    	//System.out.println(temptObject);
    	JSONObject RegionsObject= new JSONObject();
    	Integer.toString(RegionsObject.size());
    	RegionsObject.put(Integer.toString(RegionsObject.size()),temptObject);
    	RegionsObject.put(Integer.toString(RegionsObject.size()),temptObject);
    	//System.out.println(RegionsObject);
    	
    	
    	JSONObject originalRegions= new JSONObject();
    	originalRegions.put(Integer.toString(originalRegions.size()),temptObject);
    	originalRegions.put(Integer.toString(originalRegions.size()),temptObject);
    	long Status=1;
    	JSONArray classId=new JSONArray();
    	classId.add("Bridging defect");
    	classId.add("Overkill");
    	
    	
    	
    	JSONArray listIsAutoLabel=new JSONArray();
    	listIsAutoLabel.add(false);
    	listIsAutoLabel.add(false);
    	
    	
    	JSONArray pointAutoLabel=new JSONArray();
    	pointAutoLabel.add("0,0");
    	pointAutoLabel.add("0,0");
    	
    	
    	String filename="7_B_BBI_DARK_Defect_1.bmp";
    	long width=512;
    	long height=512;
    	
    	JSONObject obj= new JSONObject();
    	
    	obj.put("Status",Status);
    	obj.put("regions",RegionsObject);
    	obj.put("originalRegions",originalRegions);
    	obj.put("classId",classId);
    	obj.put("listIsAutoLabel",listIsAutoLabel);
    	obj.put("pointAutoLabel",pointAutoLabel);
    	obj.put("filename",filename);
    	obj.put("width",width);
    	obj.put("height",height);
    	
    	//System.out.println(obj);
    	try (FileWriter file = new FileWriter("Dustin.json")) {
			file.write(obj.toJSONString());
			//System.out.println("Successfully Copied JSON Object to File...");
			//System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//ReadAndWriteJSON a=new ReadAndWriteJSON();
    	//a.ReadJSON("Dustin.json");
    	
		
		return true;
	}
		
	

}
