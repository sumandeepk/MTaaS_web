


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import connection.Cloud;
import connection.DatabaseConnection;



/**
 * Servlet implementation class ViewAdvertisements
 */
public class ViewClouds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewClouds() {
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
			Cloud[] clouds = db.getClouds();

			System.out.println("clouds"+ clouds);
			// for( int i = 0; i< advertisements.length;i++){
			//
			// out.println(advertisements[i].getProductName());
			// }

			if (clouds != null) {
				request.setAttribute("clouds", clouds);
				RequestDispatcher rd = request
						.getRequestDispatcher("viewClouds.jsp");
				rd.forward(request, response);
			} else {
				out.println("There is no clouds");
				
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
