package Phase2Main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotServlet
 */
@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
		ConnectionUtil dao=new ConnectionUtil();
		HttpSession session=request.getSession();
		if(dao.changeAdminPassword(email,password)) {
		session.setAttribute("message", "Password Changed 
				+ Successfully");
		}
		
		else {
		session.setAttribute("message", "Invalid Details");
		}
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		response.sendRedirect("AdminPage.jsp");
		}
		}


