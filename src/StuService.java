

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Servlet.Lianjie;

/**
 * Servlet implementation class StuService
 */
@WebServlet("/StuService")
public class StuService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		//开始处理学生的申请，准备插入apply表
		
		String xuehao="";
		String bianhao="";
		String shuliang="";
		
		xuehao=request.getParameter("xuehao");
		bianhao=request.getParameter("ID");
		shuliang=request.getParameter("nunmber");
		
		System.out.println(xuehao);
		Lianjie gao=new Lianjie();
		if( gao.shuaxinshenqing(xuehao, bianhao, shuliang) )
		{
			
			request.setAttribute("success", "success");
			request.getRequestDispatcher("Student.jsp").forward(request, response);
		}
		
		
	}

}
