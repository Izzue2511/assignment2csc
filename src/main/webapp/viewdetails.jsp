<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
   <head>
      <title></title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <script src="https://kit.fontawesome.com/9bff21277a.js" crossorigin="anonymous"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <link rel="stylesheet" href="style.css">
      
   </head>
   <body>
      <%
         Class.forName("org.postgresql.Driver");
         String dbURL = "jdbc:postgresql://ec2-18-204-142-254.compute-1.amazonaws.com/d5ivvm39oh719k";
         String user = "cqrczajvwzbsyn";
         String pass = "a9510d4ab2b0cf12aea03b2c8811e6e818edc93b5dd99fee6f9e303bfc3654cd";
         String ic=request.getParameter("ic");
         String sql= "select * from customer join  report using(nric) where nric='"+ic+"'";
         Connection con=DriverManager.getConnection(dbURL, user, pass);
         Statement stmt=con.createStatement();
         ResultSet rs=stmt.executeQuery(sql);
         while(rs.next())
         {
         %>
      <div class="content">
         <div class="custform">
            <form class="speaker" method="post">
                        <div class="flex">
            
              <fieldset class="custinfo">
                <legend>Customer Information </legend> 
               <label>   IC Number </label>
               <input type="text" name="custnric" value='<%=rs.getString("nric") %>' disabled /><br>
               <label>  Name </label>
               <input type="text" name="custname" value='<%=rs.getString("name") %>' disabled id="a1"><br>
               <label>  Phone</label>
               <input type="text" name="custphone" value='<%=rs.getString("phone") %>' disabled id="a2"><br>
               <label>    E-mail</label>
               <input type="text" name="custemail" value='<%=rs.getString("email") %>' disabled id="a3"><br>
                   </fieldset>
                                  <fieldset class="feedbackinfo">
                                                  <legend>Service Information </legend> 
                                  
                   
                 <label>  Category </label>
               <input type="text" name="category" value='<%=rs.getString("catogary") %>' disabled /><br>
               <label>  Date </label>
               <input type="text" name="visitdate" value='<%=rs.getString("date") %>' disabled id="a4"><br>
               <label>  Item</label>
               <input type="text" name="item" value='<%=rs.getString("item") %>' disabled id="a5"><br>
               <label>   Price</label>
               <input type="text" name="price" value='<%=rs.getString("price") %>' disabled id="a6"><br>
               <label>  Subject</label>
               <input type="text" name="subject" value='<%=rs.getString("subject") %>' disabled id="a7"><br>
               <label>  Message</label>
  				<textarea type="text" name="message" disabled ><%=rs.getString("message") %></textarea><br>                
                              </fieldset>
                                         <input type="hidden" name="custnric" value='<%=rs.getString("nric") %>'>
                  </div>
                   <div>
                           <input type="hidden" name="action" value="deleteService">
 
                           <button  class="action"  type="delete" formaction="AssgServlet"  onclick="return confirm('Confrim delete this information?')">DELETE</button>
                     </div><div>
            <button  class="action"  type="edit" formaction="editDetails.jsp?ic=<%=rs.getString("nric") %>"
                              >EDIT
                           </button></div>
            
                   <%} %>
            </form>
         </div>
      </div>
      <br><br><br>
   </body>
   <style type="text/css">
      h3{color: black;}
      #myInput{display: inline-block;width: 500px ;}
   </style>
   <script>
   function edit(){
	   var el1 = document.getElementById('a1');

		el1.removeAttribute("disabled");
	 }
   </script>
</html>