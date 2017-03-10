package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class appen
 */
public class appen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("coming");
				// TODO Auto-generated method stub
			PrintWriter out =response.getWriter();
			//next will be the url pattern given in the xml file for helloservelt
			RequestDispatcher rd=request.getRequestDispatcher("next");
			
			out.print("<body style='background-color:red;'>");
			
		//here include method bringing the out put from the helloservlet end in colorapppender class its printing
			rd.include(request, response);
			//out.print("</body></style>");
				
			}
	}


