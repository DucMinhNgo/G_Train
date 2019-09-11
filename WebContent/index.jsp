<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="Subject.MonHoc" %>
 <%@ page import="Subject.MonHocDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <title>G_train</title>
        <meta charset="UTF-8">
        <meta name="description" content="An example using jPolygon">
        <meta name="keywords" content="HTML,CSS,JavaScript,jPolygon">
        <meta name="author" content="Matteo Mattei">
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="Style/Style.css" />
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   <script src="scripts/jPolygon.js"></script>
   <script src="scripts/Script.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
  ul#label {
    height: 155px;
}
 ul.nav.nav-pills.nav-stacked {
    overflow: scroll;
     height: 175px;
    overflow-y:auto;
    overflow-x: hidden;
}
ul#Image {
    height: 300px;
}
</style>
    </head>
    <body onload="clear_canvas()">
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Label</a></li>
        <li><a href="#">Train</a></li>
        <li><a href="#">Visualize</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron">
<img id="logo" src="icon//logo.ico" alt="folder image"  width="50px" />
<img id="companyname" src="icon//ge3f.png" alt="folder image"  width="100px" />
  <div class="container text-center">
 
    
    <div class="row">
      
  <div class="column">
    <div class="card">
      <img src="icon//folder.png" alt="folder image" width="30" height="30" /><br/>Import
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
  
  <div class="column">
    <div class="card">
      <img src="icon//auto.png" alt="folder image" width="30" height="30" /><br/>Import
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
      <div class="column">
    <div class="card">
      <img src="icon//manual.png" alt="folder image" width="30" height="30" /><br/>Auto
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
      <div class="column">
    <div class="card">
      <img src="icon//Overlay.png" alt="folder image" width="30" height="30" /><br/>Manual
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
      <div class="column">
    <div class="card">
      <img src="icon//filter.png" alt="folder image" width="30" height="30" /><br/>Display Overlay
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
      <div class="column">
    <div class="card">
      <img src="icon//contrast.png" alt="folder image" width="30" height="30" /><br/>Filter Mode
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
      <div class="column">
    <div class="card">
      <img src="icon//cropview.png" alt="folder image" width="30" height="30" /><br/>Crop SizeS
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
      <div class="column">
    <div class="card">
      <img src="icon//plusbutton.png" alt="folder image" width="30" height="30" /><br/>Model Selection
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
      
  
      <div class="column">
    <div class="card">
      <img src="icon//folder.png" alt="folder image" width="30" height="30" /><br/>Import
      <div class="container">
        
        
        
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
    
  </div>
    
  </div>
</div>
 <%!MonHocDAO monHocDAO = new MonHocDAO(); %>
<%monHocDAO.findAll(); %>
<%request.setAttribute("listmonHoc",monHocDAO.findAll()); %>
<div class="container-fluid">
  <div class="row content">
  
    <div class="col-sm-3 sidenav">
    
      <ul id="label" class="nav nav-pills nav-stacked">
        <li class="active"><a href="#section1">Labels</a></li>
        <li><a href="#section2">Over Kill</a></li>
        <li><a href="#section3">Over Kill</a></li>
        <li><a href="#section3">Over Kill</a></li>
         <li><a href="#section3">Over Kill</a></li>
      </ul><br>
       <ul id="Image" class="nav nav-pills nav-stacked">
       <li class="active"><a href="#section1">Images</a></li>
      
         <c:forEach items="${listmonHoc}" var="name">
 
        
        <li><a id="${name.name}" href="#" onclick="changeImage(this.id)">${name.name}</a></li>
        </c:forEach>
        
        
        
      </ul><br>
    
    </div>

    <div class="col-sm-9">
    
    <input id="prodId" name="prodId" type="hidden" value="1234">
      <h4><small>Show Image</small></h4>
      
      
	
      
  

<br>



      
 
<div style="float:left">
            <canvas  id="jPolygon" width="640" height="480" style="cursor:crosshair" data-imgsrc="images/cat.jpg" onmousedown="point_it(event)" oncontextmenu="return false;">
                Your browser does not support the HTML5 canvas tag.
            </canvas>
             <h3 class="getNameimage">${nameimage_canvas} </h3>
              <h3 class="List_X">${List_X}</h3>
              <!-- 
              <input type="hidden" id="List_X" name="List_X" value="${List_X}" />
           
             
            <textarea id="send_X" name="send_X"  style="width:300px; height:200px;"></textarea>
                <p><strong>Coordinates_Y:</strong></p>
            
               -->
           
            
            
            
            
        </div>
        <div style="float:left; margin-left:20px;">

            <div>
                 <p><button onclick="myCanvaspi()">Add to canvas</button></p>
   
 
   			<!-- xem hinh anh truoc khi add vao cavas -->
   			<script>
   			
   			</script>
   			
 					<img id="my_image"  src="images/image.png" width="100px" height="100px" alt="error" />
 				



  

                   <form action="UploadServlet" method="post" enctype="multipart/form-data" name="form1" id="form1">
		
			<!--  	<form action="UploadServlet">-->
					
						Multiple image upload<br>
					
						Specify file : <input name="file" type="file" id="file" multiple>
				<!-- 
					<input type="submit">
</form> -->
					 
					<input type="submit" name="Submit" value="Submit Files">
				
	</form>
                <button onclick="undo()">Undo</button>
                <button onclick="clear_canvas()">Clear</button>
                <button onclick="add_canvas()"> Polygon</button>
                
                <p>Press <strong>Left Click</strong> to draw a point.</p>
                <p><strong>CTRL+Click</strong> or <strong>Right Click</strong> to close the polygon.</p>
            </div>
             
            <div>
                <p><strong>Coordinates:</strong></p>
                
                <textarea id="coordinates" name="coordinates" disabled="disabled" style="width:300px; height:200px;"></textarea>
                
               <form action="UploadServlet" method="post" enctype="multipart/form-data" name="form2" id="form2">
               
               Specify file : <input name="file" type="file" id="file" multiple>
               
                <p><strong>Coordinates_X:</strong></p>
                
               
                
                <textarea id="coordinates_X" name="coordinates_X"  style="width:300px; height:200px;"></textarea>
                <p><strong>Coordinates_Y:</strong></p>
               
               
               
                <textarea id="coordinates_Y" name="coordinates_Y"  style="width:300px; height:200px;"></textarea>
                 <p><strong>Name image:</strong></p>
                
               
                <input type="text" id="Name_image" name="Name_image" value="" />
                
                <input id="Submit2" type="submit">
               </form>
            </div>
            
        </div>
        

  
        <div style="float:left">
        
            <canvas onload="" id="jPolygon" width="640" height="480" style="cursor:crosshair" data-imgsrc="23_B_BBI_DARK_Defect_1.bmp" onmousedown="point_it(event)" oncontextmenu="return false;">
                Your browser does not support the HTML5 canvas tag.
                
            </canvas>
            
            
              <!--  
            <canvas id="myCanvas" width="300" height="150" style="border:1px solid #d3d3d3;">
Your browser does not support the HTML5 canvas tag.</canvas>
           
            -->
        </div>
        <script>

</script>
        
        
        <script type="text/javascript" src="scripts/jPolygon.js"></script>
        <script type="text/javascript" src="scripts/Script.js"></script>
        <script type="text/javascript" src="scripts/EventMouse.js"></script>
      
    <h3>${message }</h3>
    
      
      <hr>
      
              <br>
                      
           
    </div>
  </div>
</div>








<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
