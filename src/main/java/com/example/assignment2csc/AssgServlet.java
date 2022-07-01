package assignment2;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/AssgServlet")
public class AssgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private customerDAO cd;
    public void init() {
        cd = new customerDAO();
    }
    
   
    public AssgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String action = request.getParameter("action");
	        try {
	            switch (action) {
	                case "addService":
	                    addService(request, response);
	                    break;
	                	case "deleteService":
	                    deleteService(request,response);
	                    break;
	                      case "updateService":
	                    updateService(request,response);
	                    break;
	                case "cancel":
	                    cancel(request, response);
	                    break;
	               
	            }

	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }

	}
	private void addService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

		String name= request.getParameter("custname");
		String email= request.getParameter("custemail");
		String phone= request.getParameter("custphone");
		String nric= request.getParameter("custnric");
		String category= request.getParameter("category");
		String date= request.getParameter("visitdate");
		String item= request.getParameter("item");
		Double price=Double.parseDouble(request.getParameter("price"));
		String subject= request.getParameter("subject");
		String message= request.getParameter("message");
      
        customer cs = new customer();
        cs.setId(nric);
        cs.setCustname(name);
        cs.setCustphone(phone);
        cs.setCusteemail(email);
                
        report rp=new report();
        
        rp.setCategory(category);
        rp.setVisitdate(Date.valueOf(date));
        rp.setItem(item);
        rp.setPrice(price);
        rp.setSubject(subject);
        rp.setMessage(message);
        rp.setNric(nric);
        
        cd.addService(cs,rp);
      
        response.sendRedirect("custlist.jsp");
    }
    
	private void deleteService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id=request.getParameter("custnric");
        cd.deleteService(id);
        response.sendRedirect("custlist.jsp");
    }
	private void updateService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

		String name= request.getParameter("custname");
		String email= request.getParameter("custemail");
		String phone= request.getParameter("custphone");
		String nric= request.getParameter("custnric");
		String category= request.getParameter("category");
		String date= request.getParameter("visitdate");
		String item= request.getParameter("item");
		Double price=Double.parseDouble(request.getParameter("price"));
		String subject= request.getParameter("subject");
		String message= request.getParameter("message");
      
        customer cs = new customer();
        cs.setId(nric);
        cs.setCustname(name);
        cs.setCustphone(phone);
        cs.setCusteemail(email);
                
        report rp=new report();
        
        rp.setCategory(category);
        rp.setVisitdate(Date.valueOf(date));
        rp.setItem(item);
        rp.setPrice(price);
        rp.setSubject(subject);
        rp.setMessage(message);
        rp.setNric(nric);
        
        cd.updateService(cs,rp);

        response.sendRedirect("custlist.jsp");
    }
	private void cancel(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
		response.sendRedirect("custlist.jsp");
	}
	
}
