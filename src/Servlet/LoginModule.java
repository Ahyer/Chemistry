package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Servlet.Lianjie;
/**
 * Servlet implementation class LoginModule
 */
@WebServlet("/LoginModule")
public class LoginModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginModule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name="";
		String password="";
		String type="";
		name=request.getParameter("name");
		password=request.getParameter("password");
		type=request.getParameter("stutea");
		Lianjie ui=new Lianjie();
		String result=ui.LoginPass(name, password, type);
		System.out.println("返回值"+result);
		
        HttpSession session =request.getSession();
        session.setAttribute("Value", result);
        session.setAttribute("Xuehao", name);
		if (!result.equals("failure"))
		{
			if(type.equals("student"))
			{		
			response.sendRedirect("Student.jsp");
			}
			else 
			{
				response.sendRedirect("Teacher.jsp");
			}
		
		}else {
			response.sendRedirect("index.jsp");
		}
	
	}

}
