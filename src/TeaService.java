

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Servlet.DBhelper;

/**
 * Servlet implementation class TeaService
 */
@WebServlet("/TeaService")
public class TeaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaService() {
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
		String yaopin=request.getParameter("yaopinbianhao");
		String choice=request.getParameter("choice");
		String bianhao=request.getParameter("bianhao");
		String zhigonghao=request.getParameter("zhigonghao");
		int nums=Integer.parseInt(request.getParameter("shuliang"));
		System.out.println(zhigonghao);
		try {
			DBhelper conn=new DBhelper();
			Connection con=conn.getConnection();
			Statement stmt=con.createStatement();
			if(choice.equals("agree"))//如果老师同意
			{
				String sql="Update apply set boolean ="+1+"where bianhao="+bianhao;
				stmt.executeUpdate(sql);
				
				//修改药品数量
				sql="update Pill set shuliang =shuliang-"+nums+" where yaopinbianhao='"+ yaopin+"'";
				stmt.executeUpdate(sql);
				
				
				//修改学生剩余数量
				String xuehao="";
				sql="select xuehao from apply where bianhao="+bianhao;
				ResultSet dS=stmt.executeQuery(sql);
				while(dS.next())
				{
					xuehao=dS.getString("xuehao");
				}
				
				
				sql="select type  from library where shiyanshihao in\r\n" + 
						"(\r\n" + 
						"	select shiyanshihao from Pill where yaopinbianhao ='" + yaopin+"'\r\n" + ") ";
				dS=stmt.executeQuery(sql);
				while(dS.next())
				{
					String teString=dS.getString("type");
					System.out.println(teString);
					if (dS.getString("type").equals("im        ")) {
						sql="update student set imdanger=imdanger-" +nums+ 
								"where xuehao='"+xuehao+"'";
					}else {
						sql="update student set danger=danger-" +nums+ 
								"where xuehao='"+xuehao+"'";
					}
				}
				stmt.executeUpdate(sql);
				
			}else {
				//不同意状态是0
				String sql="Update apply set boolean ="+0+"where bianhao="+bianhao;
				stmt.executeUpdate(sql);
			}
			String sql="insert into Lshenpi values('"+zhigonghao+"','2018-11-15',"+bianhao+")";//插入审批表
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
		
			response.sendRedirect("Teacher.jsp");
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}
