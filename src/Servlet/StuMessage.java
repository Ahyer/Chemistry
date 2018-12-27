package Servlet;

import java.io.ObjectInputStream.GetField;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class StuMessage {
	private String yaopinbianhao;
	private String num;
	private String xuehao;
	private  String bianhao;
	
	public String getbianhao() {
		return bianhao;
		
	}
	public void  setbianhao(int a) {
		this.bianhao=a+"";
	}
	public String getyaopinbianhao()
	{
		return yaopinbianhao;
	}
	public String getnum() {
		return num;
		
	}
	public String getxuehao()
	{
		return xuehao;
	}
	
	public void setyaopinbianhao(String a)
	{
		this.yaopinbianhao=a;
	}
	public void setnum(String a)
	{
		this.num=a;
	}
	public void setxuehao(String a)
	{
		this.xuehao=a;
	}
}
