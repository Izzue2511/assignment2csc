<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<header></header>
    <div class="title">
        <h1>FEEDBACK FORM</h1>
   		<h2>Please provide as much information that is relevant to the issues as possible.</h2>
    </div>
    <div class="content">
        <form method="post" action="AssgServlet">
            <div class="flex">
            <fieldset class="custinfo">
                <legend>Customer Information </legend> 
                <label>Name:<br /></label>
                <input type="text" name="custname"><br />
                <label>IC Number:<br /></label>
                <input type="text" name="custnric"><br />
                <label>Email:<br />
                <input type="text" name="custemail"></label><br /> 
                <label>Phone:<br />
                <input type="text" name="custphone"></label><br /> 
            </fieldset>
               <fieldset class="feedbackinfo">
                <legend>Service Information </legend> 
                <label>Category:<br /></label>
                <select id="category" name="category">
                    <option value="Hospitality">Hospitality</option>
                    <option value="Product Quality">Product Quality</option>
                    <option value="Compliments">Compliments</option>
                    <option value="Others">Others</option>
                </select><br />           
                <label>Visit Date:<br />
                <input type="date" name="visitdate"></label><br /> 
                <label>Items:<br />
                <input type="text" name="item" value="Not Applicable"></label><br /> 
                <label>Prices:<br />
                <input type="text" name="price" value="0.00"></label><br />         
            </fieldset>
            <fieldset class="feedbackmessage">
                <legend>Message Details </legend> 
                <label>Subject :<br /></label>
                <input type="text" name="subject" required><br />
                <label>Message :<br /></label>
                <textarea name="message" required></textarea>
            </fieldset>

            </div>
           <input type="hidden" name="action" value="addService">
		    <button type="submit" class="button button1" name="submit" >SUBMIT</button><br><br>
        </form>
    </div>
</body>
</html>