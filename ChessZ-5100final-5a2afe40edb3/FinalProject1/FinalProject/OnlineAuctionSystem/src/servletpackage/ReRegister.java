package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.BuyUser;
import entities.SellUser;

import business.BuyUserRules;
import business.SellUserRules;
import business.impl.BuyUserRulesImpl;
import business.impl.SellUserRulesImpl;
public class ReRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ReRegister() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("GBK");
		request.setCharacterEncoding("GBK");
		HttpSession session=request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();			
		    String btnname=request.getParameter("resubmit").trim();	//获取提交按钮的名字
			//检查用户名是否已经存在
			String choicename=request.getParameter("radFin").trim();//判断是以买者权限注册还是以卖者权限注册
			if("买者".equals(choicename))
			{
				//购买用户注册，及拍买用户
			BuyUserRules buyuser=new BuyUserRulesImpl();
			boolean tag=buyuser.isContaintUser(request.getParameter("txtusername").trim());
			if(tag==true)
			{
				//查到存在该用户		
				session.setAttribute("Y","此用户已经存在,请另填用户名!!");
				session.setAttribute("Name",request.getParameter("txtusername").trim());
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
			else if("检查用户名".equals(btnname))
			{
				//不存在此用户
				session.setAttribute("Y","用户名有效，请继续填写相关信息");
				session.setAttribute("Name",request.getParameter("txtusername").trim());
				response.sendRedirect(request.getContextPath()+"/register.jsp");			
			}
			else 
			{
				//提交注册，写入数据库
				BuyUser bu=new BuyUser();
				bu.setName(request.getParameter("txtusername").trim());//用户名字
				bu.setPassword(request.getParameter("txtpwd").trim());	//密码							
				bu.setTelePhone(request.getParameter("txttel").trim());//联系电话
				bu.setEmail(request.getParameter("txtemail").trim());//电子邮件
				bu.setTrueName(request.getParameter("txttruename").trim());	//真实名字
				bu.setAddress(request.getParameter("txtaddress").trim());//联系地址	
				bu.setPostBoy(request.getParameter("txtPostBoy").trim());//邮编
				bu.setPassHint(request.getParameter("txtPassHint").trim());//密码提示
				 boolean userregister=buyuser.addUser(bu);
				 if(userregister==false)
				 {
					 //写入失败
					 session.setAttribute("registerinfo","注册失败，请检查操作！！");
					 response.sendRedirect("www.qq.com");
				 }
				 else
				 {
					 //成功
					 session.setAttribute("registerinfo","注册成功!!");					
					 response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
				 }
			}
		}
			else
			{
				//拍卖用户注册
				SellUserRules saleuser=new SellUserRulesImpl();				
				boolean tag=saleuser.isContaintUser(request.getParameter("txtusername").trim());
				if(tag==true)
				{
					//查到存在该用户		
					session.setAttribute("Y","此用户已经存在,请另填用户名!!");
					session.setAttribute("Name",request.getParameter("txtusername").trim());
					response.sendRedirect(request.getContextPath()+"/register.jsp");
				}
				else if("检查用户名".equals(btnname))
				{
					//不存在此用户
					session.setAttribute("Y","用户名有效，请继续填写相关信息");
					session.setAttribute("Name",request.getParameter("txtusername").trim());
					response.sendRedirect(request.getContextPath()+"/register.jsp");			
				}
				else 
				{
					//提交注册，写入数据库
					SellUser seluser=new SellUser();					
					seluser.setUsername(request.getParameter("txtusername").trim());//用户名字
					seluser.setPassword(request.getParameter("txtpwd").trim());	//密码							
					seluser.setTetlePhone(request.getParameter("txttel").trim());//联系电话
					seluser.setEMail(request.getParameter("txtemail").trim());//电子邮件
					seluser.setTrueName(request.getParameter("txttruename").trim());	//真实名字
					seluser.setAddress(request.getParameter("txtaddress").trim());//联系地址	
					seluser.setPostBoy(request.getParameter("txtPostBoy").trim());//邮编
					seluser.setPassHint(request.getParameter("txtPassHint").trim());//密码提示					
					boolean userregister=saleuser.addUser(seluser);
					 if(userregister==false)
					 {
						 //写入失败
						 session.setAttribute("registerinfo","注册失败，请检查操作！！");
					 }
					 else
					 {
						 //成功
						 session.setAttribute("registerinfo","注册成功!!");
						 response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
					 }
				}
			}
		out.flush();
		out.close();		
	}	
	
	public void init() throws ServletException {
		// Put your code here
	}

}
