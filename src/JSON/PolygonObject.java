package JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class PolygonObject implements JSONAware {
	
	private long Status;
	private JSONObject originalRegionsObject;
	//private JSONObject idOriginal;//
	private Double curTorelant;//
	//private JSONArray List_Y;//
	//private JSONArray List_X;//
	private JSONArray classId;
	private JSONObject RegionsObject;
	private String filename;
	private JSONArray listIsAutoLabel;
	private JSONArray pointAutoLabel;
	private long width;
	private long height; 
	private String Center;
	
	
	@SuppressWarnings("unchecked")
	public PolygonObject() {
		
		Status=1;
		filename="";
		width=512;
		height=512;
		Center="0,0";
		curTorelant=0.0;
		listIsAutoLabel=new JSONArray();
		listIsAutoLabel.add(false);
    	listIsAutoLabel.add(false);
    	pointAutoLabel=new JSONArray();
    	pointAutoLabel.add("0,0");
    	pointAutoLabel.add("0,0");
    	classId=new JSONArray();
    	classId.add("Bridging defect");
    	classId.add("Overkill");
    	originalRegionsObject=new JSONObject();
    	RegionsObject=new JSONObject();
		
		
	}
	@SuppressWarnings("unchecked")
	public void AddRegionObject(JSONArray List_X,JSONArray List_Y) {
		JSONObject temptObject= new JSONObject();
    	temptObject.put("List_Y",List_Y);
    	temptObject.put("Center",Center);
    	temptObject.put("curTorelant",curTorelant);
    	temptObject.put("List_X",List_X);
    	RegionsObject.put(Integer.toString(RegionsObject.size()),temptObject);
    	
		
	}
	@SuppressWarnings("unchecked")
	public void AddOriginalRegionObject(JSONArray List_X,JSONArray List_Y) {
		JSONObject temptObject= new JSONObject();
    	temptObject.put("List_Y",List_Y);
    	temptObject.put("Center",Center);
    	temptObject.put("curTorelant",curTorelant);
    	temptObject.put("List_X",List_X);
    	originalRegionsObject.put(Integer.toString(originalRegionsObject.size()),temptObject);
    	
		
	}
	
	


	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		return null;
	}


	public PolygonObject(long status, JSONObject originalRegionsObject, Double curTorelant, JSONArray classId,
			JSONObject regionsObject, String filename, JSONArray listIsAutoLabel, JSONArray pointAutoLabel, long width,
			long height, String center) {
		super();
		Status = status;
		this.originalRegionsObject = originalRegionsObject;
		this.curTorelant = curTorelant;
		this.classId = classId;
		RegionsObject = regionsObject;
		this.filename = filename;
		this.listIsAutoLabel = listIsAutoLabel;
		this.pointAutoLabel = pointAutoLabel;
		this.width = width;
		this.height = height;
		Center = center;
	}


	public long getStatus() {
		return Status;
	}


	public void setStatus(long status) {
		Status = status;
	}


	public JSONObject getOriginalRegionsObject() {
		return originalRegionsObject;
	}


	public void setOriginalRegionsObject(JSONObject originalRegionsObject) {
		this.originalRegionsObject = originalRegionsObject;
	}


	public Double getCurTorelant() {
		return curTorelant;
	}


	public void setCurTorelant(Double curTorelant) {
		this.curTorelant = curTorelant;
	}


	public JSONArray getClassId() {
		return classId;
	}


	public void setClassId(JSONArray classId) {
		this.classId = classId;
	}


	public JSONObject getRegionsObject() {
		return RegionsObject;
	}


	public void setRegionsObject(JSONObject regionsObject) {
		RegionsObject = regionsObject;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public JSONArray getListIsAutoLabel() {
		return listIsAutoLabel;
	}


	public void setListIsAutoLabel(JSONArray listIsAutoLabel) {
		this.listIsAutoLabel = listIsAutoLabel;
	}


	public JSONArray getPointAutoLabel() {
		return pointAutoLabel;
	}


	public void setPointAutoLabel(JSONArray pointAutoLabel) {
		this.pointAutoLabel = pointAutoLabel;
	}


	public long getWidth() {
		return width;
	}


	public void setWidth(long width) {
		this.width = width;
	}


	public long getHeight() {
		return height;
	}


	public void setHeight(long height) {
		this.height = height;
	}


	public String getCenter() {
		return Center;
	}


	public void setCenter(String center) {
		Center = center;
	}



	
	
	
	
	






	
	
	
	

}
