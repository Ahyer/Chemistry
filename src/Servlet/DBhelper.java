package Servlet;

import java.sql.*;
import java.util.*;
import java.io.*;
public class DBhelper {
		private  static  final  String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    private  static  final  String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Chemistry";
	    private static  final String username ="sa";
	    private  static final String userpwd ="2510789";
	   public static Connection getConnection() throws Exception {
		   Connection con=null;
	        Statement stmt=null;
	        
	        try
	        {
	            Class.forName(driver);
	            con=DriverManager.getConnection(URL, username, userpwd);
	           System.out.println("连接成功");
	        }
	        catch(ClassNotFoundException e1)
	        {
	            System.out.print("数据库驱动不存在！");
	            System.out.print(e1.toString());
	        }
	        catch(SQLException e2)
	        {
	            System.out.print("数据库存在异常！");
	            System.out.print(e2.toString());
	        }
	        finally
	        {
	           
	        } 
	  return con; 
	}
	    public static void main(String []args) {
	    	
			
		}
}
