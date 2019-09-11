<html> 
  <head> 
    <title>A_jax at work</title> 

    <script>
      var XMLHttpRequestObject = false; 

      if (window.XMLHttpRequest) {
        XMLHttpRequestObject = new XMLHttpRequest();
      } else if (window.ActiveXObject) {
        XMLHttpRequestObject = new ActiveXObject("Microsoft.XMLHTTP");
      }
      

      function getData(dataSource, divID) 
      { 
	  
        if(XMLHttpRequestObject) {
          var obj = document.getElementById(divID); 
          XMLHttpRequestObject.open("GET", dataSource); 

          XMLHttpRequestObject.onreadystatechange = function() 
          { 
            if (XMLHttpRequestObject.readyState == 4 && 
              XMLHttpRequestObject.status == 200) { 
                obj.innerHTML = XMLHttpRequestObject.responseText; 
            } 
          } 

          XMLHttpRequestObject.send(null); 
        }
      }
    </script>
  </head> 

  <body>

    <h1>Fetching data with A j a x  javaScript</h1>

    <form>
      <input type="button" value="Display Message" onclick = "getData('14_B_BBI_DARK_Defect_1.bmp.json', 'targetDiv')" /> 
    </form>

    <div id="targetDiv">
      <p>The fetched data will go here.</p> 
    </div> 

  </body> 
</html>
