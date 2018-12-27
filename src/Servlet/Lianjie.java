package Servlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.swing.plaf.TabbedPaneUI;

import Servlet.DBhelper;
public class Lianjie {
	public int add() {
try {	
	DBhelper conn=new DBhelper();
	Connection con=conn.getConnection();
	String sql = "select * from Table_1 ";
	
	    Statement stmt=con.createStatement();
	    ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("password"));
		}
}
catch(Exception e) {
	return 1;

}
return 0;
}
	/*
	 * 
	 * 登录模块
	 * 
	 * */
	public String LoginPass(String name,String pass,String type)
	{
		try {
			DBhelper conn=new DBhelper();
			Connection con=conn.getConnection();
			Statement stmt=con.createStatement();

			if(type.equals("student"))//如果是学生
			{
				String sql ="select * from student where xuehao = '"+name+"'";
				ResultSet rs =stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				
				 int numOfColumn=rsmd.getColumnCount();
				 for(int i=1;i<=numOfColumn;i++)
				 {
					 String n = rsmd.getColumnName(i);
					 System.out.println("我要写了"+n);
				 }
				
				while(rs.next())
				{
					System.out.println(rs.getString("password"));
					String a=rs.getString("password");
					if(pass.equals(a))
					{
						a=rs.getString("name");
						return a;
					}
				}
			}else //如果是老师
				{
				String sql ="select * from AD where zhigonghao = '"+name+"'";
				ResultSet rs =stmt.executeQuery(sql);
				while(rs.next())
				{
					System.out.println(rs.getString("password"));
					String a=rs.getString("password");
					if(pass.equals(a))
					{
						return rs.getString("wokername");
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出错了");
		}
		return "failure";
	}

	
	/*
	 * 
	 * 学生端的申请模块
	 * 
	 * 
	 */
	public boolean shuaxinshenqing(String xuehao,String bianhao,String  nums) {
		
		try {
			DBhelper conn=new DBhelper();
			Connection con=conn.getConnection();
			Statement stmt=con.createStatement();
			//求出申请对象的职工号
			/*String zhigonghao="";
			String sql="select zhigonghao from library \r\n" + 
					"where shiyanshihao in\r\n" + 
					"(\r\n" + 
					"	select shiyanshihao from Pill \r\n" + 
					"	where yaopinbianhao ='"+ bianhao+"')";
			System.out.println(sql);
			ResultSet rs =stmt.executeQuery(sql);
		
			while(rs.next())
			{
				zhigonghao=rs.getString("zhigonghao");
			}
			*/
			//获取职工号完毕
			
			
			/*2指定的是还没有审批
			 * 
			 * 1代表审批成功
			 * 0代表审批失败
			*/
			String sql="";
			sql="insert into apply(xuehao,yaopinbianhao,nums,boolean) values ('"+xuehao+"','"+bianhao+"',"+nums+","+2+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		/*	sql="select MAX(bianhao) from apply";
			rs =stmt.executeQuery(sql);
			int liushuihao=0;;
			while(rs.next())
			{
				liushuihao=rs.getInt(1);
			}
		*/
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	
	/*
	 * 老师审批模块
	 * 
	 * */
	public ArrayList<StuMessage> queryStu (String zhigonghao) 
	{
		ArrayList<StuMessage> message=new ArrayList<>();
		ArrayList<String> Library=new ArrayList<>();
		try {
			DBhelper conn=new DBhelper();
			Connection con=conn.getConnection();
			Statement stmt=con.createStatement();
			/*
			 * 
			 * 先查看老师管理那些个实验室，从这些实验室中 找到需要审批的数据，实验室一个一个来。
			 *  select shiyanshihao from Lgunali where zhigonghao=zhigonghao;
			 *  用ArrayList保存住结果

			 *  select bianhao from apply where yaopinbianhao in
			 *  (
			 *  	select yaopinbianhao from Pill where shiyanshihao ='shiyan'
			 *  )

			 * 
			 * */
			String sql="select shiyanshihao from Lguanli where zhigonghao='"+zhigonghao+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Library.add(rs.getString("shiyanshihao"));
			}
			for(int i=0;i<Library.size();i++)
			{
				sql="select * from apply where boolean='2' and yaopinbianhao in (select yaopinbianhao from Pill where shiyanshihao ='"+Library.get(i)+"')";
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					StuMessage stu=new StuMessage();
					stu.setxuehao(rs.getString("xuehao"));
					stu.setbianhao(rs.getInt("bianhao"));
					stu.setnum(rs.getString("nums"));
					stu.setyaopinbianhao(rs.getString("yaopinbianhao"));
					message.add(stu);
				}
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	/*
	 * 自定义查询
	 * 
	 */
	public ArrayList<String> gaoji(String sql)
	{
		ArrayList<String> arrayList=new ArrayList<>();
		
		try {
			DBhelper conn=new DBhelper();
			Connection con=conn.getConnection();
			Statement stmt=con.createStatement();
			
			ResultSet rs =stmt.executeQuery(sql);
			  ResultSetMetaData rsmd=rs.getMetaData();
			  int numberOfColumns=rsmd.getColumnCount();//获得了一共有多少列
			  
			  System.out.println("一共有"+numberOfColumns+"列");
			 
			  for(int i=1;i<=numberOfColumns;i++)
				  arrayList.add(rsmd.getColumnName(i));
			  
			
			while(rs.next())
			{
				for(int i=1;i<=numberOfColumns;i++)
				{
					arrayList.add(rs.getString(i));
				}
			}
			String ha=numberOfColumns+"";
			arrayList.add(ha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayList;
		
	}
}
	
	

