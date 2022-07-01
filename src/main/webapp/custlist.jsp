<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
   <head>
      <title></title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="css/style.css">
      <script src="https://kit.fontawesome.com/9bff21277a.js" crossorigin="anonymous"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <link rel="stylesheet" href="style.css">
      
   </head>
   
   <body>
      
      <sql:setDataSource var="ic" driver="org.postgresql.Driver"
         url="jdbc:postgresql://ec2-18-204-142-254.compute-1.amazonaws.com/d5ivvm39oh719k"
         user = "cqrczajvwzbsyn"
         password="a9510d4ab2b0cf12aea03b2c8811e6e818edc93b5dd99fee6f9e303bfc3654cd"/>
         
      <sql:query dataSource="${ic}" var="oc">
select row_number() over () "rank",* from customer join report using(nric)
      </sql:query>
            
      <div class="content" ><br>
      
      <h2 style="color:white;"> Customer Feedback Report</h2>
		
     
         <div style="overflow-x:auto;">
            
            <table style="background-color:rgba(255,255,255,1);color:black;" id="custlist">
               <tr>
                  <th  style="width: 50px; height: 50px;">No.</th>
                  <th  style="width:300px;">IC Number</th>
                  <th style="width: 650px;">Name</th>
                  <th  style="width: 250px;">Category</th>
                  <th  style="width: 250px;">Date</th>
                  <th style="width: 100px;">Action</th>
               </tr>
               
               <c:forEach var="result" items="${oc.rows}">
                  <tr>
                     <td class="no">
                        <c:out value="${result.rank}"/>
                     </td>
                     <td class="name">
                        <c:out value="${result.nric}"/>
                     </td>
                     <td class="no">
                        <c:out value="${result.name}"/>
                     </td>
                     <td class="id">
                        <c:out value="${result.catogary}"/>
                     </td>
                     <td class="id">
                        <c:out value="${result.date}"/>
                     </td>
                     <td>
                        <form method="post">
                           <button  class="action"  type="edit" formaction="viewdetails.jsp?ic=${result.nric}"
                              >DETAILS
                           </button>
                        </form>
                        
                       
                     </td>
                  </tr>
               </c:forEach>
            </table>
            <form>
              <button formaction="assg.jsp">ADD</button>
         </form>
         </div>
         <br><br><br>
      </div>
      <style>
         h3{color: black;}
         #myInput{display: inline-block;width: 500px ;}
         th, td { border: 1px solid;}
         th{background-color:#ffd9b3}
      </style>
      <script>

      </script>
   </body>
</html>