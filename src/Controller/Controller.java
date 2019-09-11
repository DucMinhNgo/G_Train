package Controller;

import java.io.File;

import java.io.IOException;

import java.nio.file.Files;


//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import JSON.PolygonObject;
import JSON.PolygonObjectDaoImpl;
import JSON.ReadAndWriteJSON;

//import Subject.MonHocDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static void copyFile( File from, File to ) throws IOException {
        Files.copy( from.toPath(), to.toPath() );
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
String coordinates_X= (String) request.getParameter("coordinates_X");

String coordinates_Y= (String) request.getParameter("coordinates_Y");
String filename= (String) request.getParameter("Name_image");

if(coordinates_X!=null) {
	
	//System.out.println(coordinates_X);
	//System.out.println(coordinates_Y);
	//String filename="http://localhost:8080/G_Train/images/45_B_BBI_DARK_Defect_1.bmp";
	String[] words = filename.split("/");
	
	//System.out.println();
	
	//System.out.println(words[words.length-1]);
	PolygonObject polygon=new PolygonObject(); 
	//polygon.setFilename(filename);
	polygon.setFilename(words[words.length-1]);
	PolygonObjectDaoImpl polygonimpl=new PolygonObjectDaoImpl();
	JSONArray List_X=polygonimpl.StringArraytoJSONArray(coordinates_X);
	JSONArray List_Y=polygonimpl.StringArraytoJSONArray(coordinates_Y);
	polygon.AddRegionObject(List_X,List_Y);
	polygon.AddOriginalRegionObject(List_X,List_Y);
	
	System.out.println(polygon.getFilename());
	
	
	
	
	
	
	
	
	
	System.out.println(polygon);
	ReadAndWriteJSON read_write=new ReadAndWriteJSON();
	
	read_write.WriteJSON(polygon);
	
	
	

	
	
}
	
		
		
		//request.setAttribute("namefile","java.jsp");
		
		
		
		
		
		/*
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		System.out.println(cars[0]);
		
		
		

		File dirFrom= new File("E:\\GE3F_Company\\Estimation\\JAVA.png");
		File dirTo= new File("E:\\GE3F_Company\\Destimation\\JAVA.png");

		try {
		        copyFile(dirFrom, dirTo);
		} catch (IOException ex) {
		       
		}
		
		
		
		
		
		
		MonHocDAO monHocDAO = new MonHocDAO();
		monHocDAO.findAll();
		
		//ghi du lieu va thuoc tinh vao request
		request.setAttribute("listmonHoc",monHocDAO.findAll());
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("ListName.jsp");
		rd.forward(request, response);
		*/
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
