

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQS.RequestGenerator;
import connection.Request;




public class AddInstance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInstance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//String qdone;	
		String requestType = "dynamicRequest";
		
		 try{			
			 	String resourceName = request.getParameter("resourceName");
			 	String resourceType = request.getParameter("resourceType");
			 	int volume = Integer.parseInt(request.getParameter("volume"));
			 	int duration = Integer.parseInt(request.getParameter("duration"));
			 	
			 	
			 	RequestGenerator g = new RequestGenerator();
//			 	DatabaseConnection db = new DatabaseConnection();
//			 	db.addInstance(instanceId, instanceType, volume, duration);
			 	
			 	System.out.println("Resource name"+ resourceName);
			 	System.out.println("Resource type"+ resourceType);
			 	System.out.println("volume"+ volume);
			 	System.out.println("duration"+ duration);
			 	
			 	Request r = new Request("1",resourceName,resourceType,volume,duration,1,false);
			 	
			 	ArrayList<Request> requests = new ArrayList<Request>();
			 	requests.add(r);
			 	Request[] i = requests.toArray(new Request[requests.size()]);
			 	g.sendRequest(i,requestType);
					
			 	String nextJSP = "/home.jsp";
			 	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			 	dispatcher.forward(request,response);
				
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}
	
	
		

}

