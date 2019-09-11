package Controller;

import java.io.File;

import java.io.IOException;

import java.nio.file.Files;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;

import JSON.PolygonObject;
import JSON.PolygonObjectDaoImpl;
import JSON.ReadAndWriteJSON;
import Subject.MonHocDAO;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	// Get Current Directory using getAbsolutePath()
    File file = new File("");
    String currentDirectory = file.getAbsolutePath();
	private final String UPLOAD_DIRECTORY =currentDirectory;/*currentDirectory+"/WebContent/images"*///"C:/Users/Admin/eclipse-workspace/JavaWeb03/WebContent/images";/*"D:/abc";*/
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}
	
	 public static void copyFile( File from, File to ) throws IOException {
	        Files.copy( from.toPath(), to.toPath() );
	    } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String name_url=url.getHost();
		//String url = request.getRequestURL().toString();
		//System.out.println(url);
		
         String coordinates_X= (String) request.getParameter("coordinates_X");
		
		String coordinates_Y= (String) request.getParameter("coordinates_Y");
		String filename= (String) request.getParameter("Name_image");
		//"C:\\Users\\Admin\\eclipse-workspace\\G_train\\WebContent\\images\\"
		
		
		//System.out.println(filename);
	   // 
		
		if(coordinates_X!=null) {
			
			//System.out.println(coordinates_X);
			//System.out.println(coordinates_Y);
			//String filename="http://localhost:8080/G_Train/images/45_B_BBI_DARK_Defect_1.bmp";
			String[] words = filename.split("/");
			
			//System.out.println();
			
			//System.out.println(words[words.length-1]);
			PolygonObject polygon=new PolygonObject(); 
			ReadAndWriteJSON read_write=new ReadAndWriteJSON();
			
			
			//System.out.println("C:\\Users\\Admin\\eclipse-workspace\\G_Train\\WebContent\\DataJSON\\"+words[words.length-1]+".json");
			File check_file = new File("C:\\Users\\Admin\\eclipse-workspace\\G_Train\\WebContent\\DataJSON\\"+words[words.length-1]+".json");
			if(check_file.exists()==true) {
				
				polygon=read_write.ReadJSON("C:\\Users\\Admin\\eclipse-workspace\\G_Train\\WebContent\\DataJSON\\"+words[words.length-1]+".json");
			}
			
			
			
			//polygon.setFilename(filename);
			polygon.setFilename(words[words.length-1]);
			PolygonObjectDaoImpl polygonimpl=new PolygonObjectDaoImpl();
			JSONArray List_X=polygonimpl.StringArraytoJSONArray(coordinates_X);
			JSONArray List_Y=polygonimpl.StringArraytoJSONArray(coordinates_Y);
			polygon.AddRegionObject(List_X,List_Y);
			polygon.AddRegionObject(List_X,List_Y);
			polygon.AddOriginalRegionObject(List_X,List_Y);
			
			//System.out.println(polygon.getFilename());
			//System.out.println(polygon);
			
			
			read_write.WriteJSON(polygon);
			request.setAttribute("nameimage_canvas","images/"+polygon.getFilename());
			request.setAttribute("List_X",polygon.getRegionsObject());
			
			//System.out.println(polygon.getFilename());
			
			//request.setAttribute("listmonHoc",monHocDAO.findAll());
			
			/*
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			*/
		}
		
		
		
		
		
		
		

		
		
	
	
		/*
		String coordinates_Y= (String) request.getParameter("coordinates_Y");
		String nameimage=(String) request.getParameter("prodId");
		if(coordinates_X!="") {
			System.out.println(coordinates_X);
			System.out.println(coordinates_Y);
			System.out.println(nameimage);
		}
		*/
		
		
		if(ServletFileUpload.isMultipartContent(request))
		{
			
			
			try
			{
				
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multiparts)
				{
					if(!item.isFormField())
					{
						
						String name = new File(item.getName()).getName();
					
						//String workingDirectory = System.getProperty(name);
						
						//System.out.println(workingDirectory + File.separator +name);
						
						//System.out.println(UPLOAD_DIRECTORY + File.separator + name);
						
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
						
						//System.out.println("images" + File.separator + name);
						//item.write(new File("images" + File.separator + name));
						
						
						File dirFrom= new File(UPLOAD_DIRECTORY + File.separator + name);
						
						File file= new File(UPLOAD_DIRECTORY + File.separator + name);
						//file.delete();
						
						//File dirTo= new File("C:\\Users\\Admin\\eclipse-workspace\\G_train\\WebContent\\images\\"+name);
						File dirTo= new File("C:\\Users\\Admin\\eclipse-workspace\\G_train\\WebContent\\images\\"+name);
						//File dirTo= new File("WebContent/images/"+name);
						
						
						//System.out.println("images"+File.separator+name);
						
						
						MonHocDAO monHocDAO = new MonHocDAO();
						//xu ly khi luu du lieu len vao csdl
						
						//System.out.println(name);
						
						name='a'+(String)name;
						//System.out.println(name);
						
					
						monHocDAO.insert(name);
						
	
						
						monHocDAO.findAll();
						
						
						request.setAttribute("listmonHoc",monHocDAO.findAll());
						request.getRequestDispatcher("/index.jsp").forward(request, response);
						/*
						RequestDispatcher rd = null;
						rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
						*/
						
						

						try {
						        copyFile(dirFrom, dirTo);
						        file.delete();
						        
						} catch (IOException ex) {
						       
						}
					}
				}
				
				request.setAttribute("message", "File uploaded successfully.");
				//request.setAttribute("file", "not_request");
				//request.setAttribute("file",null);
			}
			catch(Exception ex)
			{
				request.setAttribute("message", "File upload failed due to : " + ex);
			}
		}
		else
		{
			/*
			MonHocDAO monHocDAO = new MonHocDAO();
			monHocDAO.findAll();
			
			
			request.setAttribute("listmonHoc",monHocDAO.findAll());
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			*/
			request.setAttribute("message", "Sorry this servlet only handles file upload request.");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
