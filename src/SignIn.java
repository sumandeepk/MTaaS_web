
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DatabaseConnection;
import connection.User;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			DatabaseConnection db = new DatabaseConnection();
			 User u = db.signIn(email, password);

			 System.out.println("user id =="+ u.getPersonId());
			if (u.getPersonId()==1) {

				response.sendRedirect("http://localhost:8080/MTaaS_web/selectAlgorithm.jsp");

			} else if (u.getPersonId() >1){
				response.sendRedirect("http://localhost:8080/MTaaS_web/home.jsp");

			}else{
				response.sendRedirect("http://localhost:8080/MTaaS_web/signIn.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
