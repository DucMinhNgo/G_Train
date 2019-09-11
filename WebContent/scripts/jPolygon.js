/*
   jPolygon - a ligthweigth javascript library to draw polygons over HTML5 canvas images.
   Project URL: http://www.matteomattei.com/projects/jpolygon
   Author: Matteo Mattei <matteo.mattei@gmail.com>
   Version: 1.0
   License: MIT License
*/

var perimeter = new Array();
var perimeter_X = new Array();
var perimeter_Y = new Array();
var complete = false;
var canvas = document.getElementById("jPolygon");
var ctx;
var nameimage="";
var list_X=new Array();
var list_Y=new Array();



/*
function line_intersects(p0, p1, p2, p3) {
    var s1_x, s1_y, s2_x, s2_y;
    s1_x = p1['x'] - p0['x'];
    s1_y = p1['y'] - p0['y'];
    s2_x = p3['x'] - p2['x'];
    s2_y = p3['y'] - p2['y'];

    var s, t;
    s = (-s1_y * (p0['x'] - p2['x']) + s1_x * (p0['y'] - p2['y'])) / (-s2_x * s1_y + s1_x * s2_y);
    t = ( s2_x * (p0['y'] - p2['y']) - s2_y * (p0['x'] - p2['x'])) / (-s2_x * s1_y + s1_x * s2_y);

    if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
    {
        // Collision detected
        return true;
    }
    return false; // No collision
}*/
/*
function myCanvas() {
	
	 
	var c = document.getElementById("jPolygon");
	var ctx = c.getContext("2d");
	ctx.canvas.width =640;
	 ctx.canvas.height = 480;
	 
	 //document.body.innerHTML =document.getElementById("my_image").getAttribute('src');
	 
	var img = document.getElementById("my_image");
	//alert(img.src);
	nameimage.push(img.src);
	 
	//document.getElementById("my_image")=img.src;
	
	ctx.drawImage(img,0,0,640,480);
	
	
	}*/
function myCanvaspi() {
		
		 
		var c = document.getElementById("jPolygon");
		var ctx = c.getContext("2d");
		ctx.canvas.width =640;
		 ctx.canvas.height = 480;
		 
		 //document.body.innerHTML =document.getElementById("my_image").getAttribute('src');
		 
		var img = document.getElementById("my_image");
		//alert(img.src);
		nameimage=img.src;
		
		 
		//document.getElementById("my_image")=img.src;
		
		ctx.drawImage(img,0,0,640,480);
		
		
		}



function point(x, y){
    ctx.fillStyle="white";
    ctx.strokeStyle = "white";
    ctx.fillRect(x-2,y-2,4,4);
    ctx.moveTo(x,y);
}


function undo(){
    ctx = undefined;
    perimeter.pop();
    perimeter_X.pop();
    perimeter_Y.pop();
    
    complete = false;
    start(true);
}
function add_canvas(){
	//ctx = undefined;
    perimeter = new Array();
    perimeter_X= new Array();
    perimeter_Y= new Array();
    
    complete = false;
    start();
    
	
}

function clear_canvas(){
	
	
	
	
	
    ctx = undefined;
    perimeter = new Array();
    perimeter_X = new Array();
    perimeter_Y = new Array();
    complete = false;
    document.getElementById('coordinates').value = '';
    
    //
   
    
    
    
    
    //
    start();
    if(document.querySelector(".getNameimage").textContent==" "){
    	
    }
    
    else if(document.querySelector(".getNameimage").textContent=="images/"){
    }
    else{
    	
    	 
    	 //document.body.innerHTML =document.getElementById("my_image").getAttribute('src');
    	 
    	var img = document.getElementById("my_image");
    	img.src=document.querySelector(".getNameimage").textContent;
    	
    	
    	canvas.setAttribute('data-imgsrc',img.src);
    	
    	
    	
    	
    	
        	
        	
        }
    
    
}

function draw(end){
	
    
    
	
	ctx.lineWidth = 1;
    ctx.strokeStyle = "white";
    ctx.lineCap = "square";
    
    
    	//alert(document.getElementById("List_X").value);
 if(document.querySelector(".getNameimage").textContent!=" "){
    	
    	var new_obj = document.querySelector(".List_X").textContent;
    	var obj = JSON.parse(new_obj);
    	for (var key in obj) {
    	    // skip loop if the property is from prototype
    	    if (!obj.hasOwnProperty(key)) continue;

    	    var obj1 = obj[key];
    	   list_X=obj1["List_X"];
   	       list_Y=obj1["List_Y"];
   	    ctx.beginPath();
   	 ctx.moveTo(list_X[0],list_Y[0]); 
    	point(list_X[0],list_Y[0]);
   	    for (i = 1; i < list_X.length; i++) {
   	    	ctx.lineTo(list_X[i],list_Y[i]); 
   	        point(list_X[i],list_Y[i]);
   	   }
    	   
     ctx.lineTo(list_X[0],list_Y[0]);
     
     ctx.closePath();
     ctx.stroke();
     //ctx.fillStyle = "red";
     ctx.fillStyle = 'rgba(255, 255, 255, 0.01)';
     ctx.strokeStyle = 'red';
     ctx.fill();
     ctx.stroke();
    	}
    	
    }
    	
    
	

    
   
    
    
   
    /*
    
    ctx.beginPath();
    ctx.moveTo(70, 80);
    point(70, 80);
    ctx.lineTo(120, 200);
    point(120, 200);
    ctx.lineTo(90, 300);
    point(90, 300);
    ctx.lineTo(70, 80);
    ctx.closePath();
    ctx.stroke();
    ctx.fillStyle = 'rgba(255, 255, 255, 0.01)';
   // ctx.fillStyle = "green";
    ctx.strokeStyle = 'green';
    ctx.fill();
    ctx.stroke();
    
    ctx.beginPath();
    ctx.moveTo(170, 180);point(170, 180);
    ctx.lineTo(120, 300);point(120, 300);
    ctx.lineTo(190, 200);point(190, 200);
    ctx.lineTo(170, 180)
    ctx.closePath();
    ctx.stroke();
    ctx.fillStyle = 'rgba(255, 255, 255, 0.01)';
    //ctx.fillStyle = "purple";
    ctx.strokeStyle = 'purple';
    ctx.fill();
    ctx.stroke();
    */
    
    
    
    ctx.beginPath();
    
  

    
        			
    



    for(var i=0; i<perimeter.length; i++){
        if(i==0){
            ctx.moveTo(perimeter[i]['x'],perimeter[i]['y']);
            end || point(perimeter[i]['x'],perimeter[i]['y']);
        } else {
            ctx.lineTo(perimeter[i]['x'],perimeter[i]['y']);
            end || point(perimeter[i]['x'],perimeter[i]['y']);
        }
    }
    
    if(end){
        ctx.lineTo(perimeter[0]['x'],perimeter[0]['y']);
        ctx.closePath();
        ctx.fillStyle = 'rgba(255, 0, 0, 0.01)';
        ctx.fill();
        ctx.strokeStyle = 'blue';
        complete = true;
    }
    ctx.stroke();
    

    // print coordinates
    if(perimeter.length == 0){
        document.getElementById('coordinates').value = '';
    } else {
    	
       
        //document.getElementById('coordinates').value+= JSON.stringify(perimeter[0]['x']);
        
   
        	
        	
        	
        document.getElementById('Name_image').value=nameimage;
        	
        
        document.getElementById('coordinates_X').value = JSON.stringify(perimeter_X);
        document.getElementById('coordinates_Y').value = JSON.stringify(perimeter_Y);
        
        
    }
}

/*function check_intersect(x,y){
    if(perimeter.length < 4){
        return false;
    }
    var p0 = new Array();
    var p1 = new Array();
    var p2 = new Array();
    var p3 = new Array();

    p2['x'] = perimeter[perimeter.length-1]['x'];
    p2['y'] = perimeter[perimeter.length-1]['y'];
    p3['x'] = x;
    p3['y'] = y;

    for(var i=0; i<perimeter.length-1; i++){
        p0['x'] = perimeter[i]['x'];
        p0['y'] = perimeter[i]['y'];
        p1['x'] = perimeter[i+1]['x'];
        p1['y'] = perimeter[i+1]['y'];
        if(p1['x'] == p2['x'] && p1['y'] == p2['y']){ continue; }
        if(p0['x'] == p3['x'] && p0['y'] == p3['y']){ continue; }
        if(line_intersects(p0,p1,p2,p3)==true){
            return true;
        }
    }
    return false;
}
*/
function Redirect() {
    window.location="UploadServlet";
 }
function getValueX_Y(){
	   var save_X=document.getElementById("coordinates_X");
    //save_X.setAttribute("value",perimeter_X);
    save_X.setAttribute("coordinates_X","1234");
    
    var save_Y=document.getElementById("coordinates_Y");
    save_Y.setAttribute("value",perimeter_Y);
   
   

}
function Submit_form() {
	  document.getElementById("Submit2").click();
	}

function point_it(event) {
    if(complete){
    	//alert(document.getElementById('coordinates_X').value);
        //alert('Polygon already created');
    	//Redirect();	
    	//getValueX_Y();
    	
    	Submit_form();
    	
    	
       // draw(false);
    	
    	
    	draw(true);
        //document.getElementById('coordinates').value = JSON.stringify(nameimage);
        
        
        
        
        //document.body.innerHTML =document.getElementById("my_image").getAttribute('src');
        //alert(perimeter.size());fruits.length;canvas.getAttribute('data-imgsrc');document.getElementById("my_image");
       // document.body.innerHTML = "<jsp:include page='Controller'></jsp:include>";
        
        perimeter = new Array();
        
        
        //let d = new Date();
        //document.body.innerHTML = "<h1>Today's date is " + d + "</h1>";
        
        
      
        
        perimeter_X = new Array();
        
        perimeter_Y = new Array();
        complete = false;
        start();
        return false;
    }
    var rect, x, y;

    if(event.ctrlKey || event.which === 3 || event.button === 2){
        if(perimeter.length==2){
            alert('You need at least three points for a polygon');
            return false;
        }
        
        x = perimeter[0]['x'];
        y = perimeter[0]['y'];
      
        
       
        
        
        
        draw(true);
        
        alert('Polygon closed');
	event.preventDefault();
        return false;
    } else {
    	
        rect = canvas.getBoundingClientRect();
        x = event.clientX - rect.left;
        y = event.clientY - rect.top;
        if (perimeter.length>0 && x == perimeter[perimeter.length-1]['x'] && y == perimeter[perimeter.length-1]['y']){
            // same point - double click
            return false;
        }
        
        
        /*
        if(check_intersect(x,y)){
            alert('The line you are drowing intersect another line');
            return false;
        }*/
        perimeter.push({'x':x,'y':y});
        perimeter_X.push(x);
        perimeter_Y.push(y);
        
        
        
        
        draw(false);
        return false;
    }
}
function changeImage(clicked_id)
{
	
	//alert(nameimage);Name_image
	//document.getElementById("Name_image").value="1234";
	
	document.getElementById("my_image").src ="images/"+clicked_id; 
	
	document.getElementById("prodId").value=clicked_id;
	//document.getElementById("Name_image").value=document.getElementById("my_image").src;
	
	//alert("show result");
	//alert(clicked_id);
	//nameimage=clicked_id;
	//alert(nameimage);
	
	
	//document.getElementById("jPolygon").data-imgsrc ="images/"+clicked_id; 
	
}

function start(with_draw) {
    var img = new Image();
    //myCanvas();
    
    
   
    canvas.setAttribute('data-imgsrc',document.getElementById("my_image").src);

    
    
    img.src = canvas.getAttribute('data-imgsrc');
    
    var a=img.src;

    
    //nameimage=canvas.getAttribute('data-imgsrc');

    img.onload = function(){
        ctx = canvas.getContext("2d");
       // perimeter_X.push(x);
        //nameimage.push(a);
        
  
        //document.getElementById('coordinates_Y').value = JSON.stringify(perimeter_Y);
       
        //canvas.setAttribute('data-imgsrc',img.src);
        ctx.drawImage(img, 0, 0, canvas.width, canvas.height);
        
        
        
        
        
        if(with_draw == true){
        	
        	
        
            draw(false);
        }
    }
   
        
}
/*
var c = document.getElementById("jPolygon");
var ctx = c.getContext("2d");
ctx.beginPath();
ctx.moveTo(30, 20);
ctx.lineTo(20, 100);
ctx.lineTo(70, 100);
ctx.closePath();
ctx.stroke();
ctx.fillStyle = "red";
ctx.fill();
ctx.lineWidth = 1;
ctx.strokeStyle = "white";
ctx.lineCap = "square";
ctx.beginPath();
*/
function upload_canvas(){
	ctx.lineWidth = 1;
    ctx.strokeStyle = "white";
    ctx.lineCap = "square";
    ctx.beginPath();

    //diem dau
        ctx.moveTo(30,20);
        end || point(30,20);
        //noi nhung diem coin lai
    
        ctx.lineTo(20, 100);
        end || point(70, 100);
    


    ctx.lineTo(30,20);
    ctx.closePath();
    ctx.fillStyle = 'rgba(255, 0, 0, 0.5)';
    ctx.fill();
    ctx.strokeStyle = 'blue';
    

ctx.stroke();
}
