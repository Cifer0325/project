<script language=javascript>
  function out(obj){
   var i = obj ;
   if(i==0)
   document.location.href="${pageContext.request.contextPath }/index";
   document.body.innerHTML = i;
   i--;
   setTimeout("out("+i+")",1000);
  }
 </script>
 <body onload="out(0);">  
 </body>