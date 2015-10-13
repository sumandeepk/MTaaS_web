


import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import connection.DatabaseConnection;
import connection.Instance;



/**
 * Servlet implementation class ViewAdvertisements
 */
public class MonitorInstances extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonitorInstances() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {

			DatabaseConnection db = new DatabaseConnection();
		    Instance[] instances = db.getInstances();

//			System.out.println("instances"+ instances);
//			 for( int i = 0; i< instances.length;i++){
//			
//			 System.out.println(instances[i].getInstanceId());
//			 }

			if (instances != null) {
				request.setAttribute("instances", instances);
				RequestDispatcher rd = request
						.getRequestDispatcher("monitorInstances.jsp");
				rd.forward(request, response);
			} else {
				out.println("There is no instances");
				
			}
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
