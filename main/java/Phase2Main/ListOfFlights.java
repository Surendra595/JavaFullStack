package Phase2Main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListOfFlights
 */
@WebServlet("/ListOfFlights")
public class ListOfFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String departure=request.getParameter("departure");
		try {
		ConnectionUtil dao = new ConnectionUtil();
		List<String[]> flights=dao.getAvailableFlights(from, to, 
		departure);
		HttpSession session=request.getSession();
		session.setAttribute("flights", flights);
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		printStackTrace();
		}
		response.sendRedirect("FlightList.jsp");
		}
		}
