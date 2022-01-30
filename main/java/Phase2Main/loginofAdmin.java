package Phase2Main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginofAdmin
 */
@WebServlet("/loginofAdmin")
public class loginofAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
		ConnectionUtil dao=new ConnectionUtil();
		if(dao.checkAdmin(email,password)) {
		response.sendRedirect("AdminHome.jsp");
		}
		else {
		HttpSession session=request.getSession();
		session.setAttribute("message", "Invalid Details");
		response.sendRedirect("AdminPage.jsp");
		}
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		}
