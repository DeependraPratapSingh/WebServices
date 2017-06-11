

<script>

 

var xmlhttp;
if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
   xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
  xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
  <!--	 document.getElementById("container-item").innerHTML = "";-->
       var arr = JSON.parse(xmlhttp.responseText);
       var qry = "<select name='city'><option value =''>All</option>";
       for(i=0;i<arr[0].length;i++)
       {
    		qry+="<option   value = '"+arr[0][i].city+"'>"+arr[0][i].city+"</option>";   		 
        
       }
       qry+="</select>";
       document.getElementById("city").innerHTML+=qry;
       qry="";
       qry+="<select name='type'><option  value =''>All</option>";
       for(i=0;i<arr[1].length;i++)
	   {
    	   qry+="<option  value = '"+arr[1][i].type+"'>"+arr[1][i].type+"</option>";
	   }
       qry+="</select>";
       document.getElementById("type").innerHTML+=qry;
    }
  }
  var filter = "SearchContent";
  xmlhttp.open("POST",filter,true);
  xmlhttp.send();
  
  
<!------------>






function load()
{
	  var city = document
      var xmlhttp;
      if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
         xmlhttp=new XMLHttpRequest();
      }
      else
      {// code for IE6, IE5
         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
        xmlhttp.onreadystatechange=function()
        {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
          {
        <!--	 document.getElementById("container-item").innerHTML = "";-->
             var arr = JSON.parse(xmlhttp.responseText);
             for(i = 0;i<arr.length;i++)
                 {
                     document.getElementById("container-item").innerHTML += "<div id='item' class='item'><img src = '' width = '100'>"+arr[i].name+"</div>";
                 }
          }
        }
        var filter = 
"SearchContent?name="+document.getElementById("searchContent").value+"&city="+city+"&type="+type;
        xmlhttp.open("GET",filter,true);
        xmlhttp.send();
}
</script>


<style>
div.search-bar
{
	margin-top:20px;
	margin-left:40%;
	min-width:150px;
	max-width:150px;
	float:left;
}
div.container-item
{
	position: relative;
	margin-top: 80px;
	margin-left: 10px;
}
</style>




<div class = "search-bar">
	<input size="30"  type="text" placeholder="type pet name..."  id="searchContent" name="searchContent" onkeyup="javascript:load();">
</div>
<div id="filter" class="filter">
	<table>
		<tr>
			<td>City:  <div id="city"></div>
			</td>
			<td>Type:<div id="type"> </div>
			</td>
			<td><input type="button" onClick = "load();"></td>
		</tr>
	</table>
</div>
<div id="container-item" class="container-item"></div>




