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
		    String btnname=request.getParameter("resubmit").trim();	//��ȡ�ύ��ť������
			//����û����Ƿ��Ѿ�����
			String choicename=request.getParameter("radFin").trim();//�ж���������Ȩ��ע�ỹ��������Ȩ��ע��
			if("����".equals(choicename))
			{
				//�����û�ע�ᣬ�������û�
			BuyUserRules buyuser=new BuyUserRulesImpl();
			boolean tag=buyuser.isContaintUser(request.getParameter("txtusername").trim());
			if(tag==true)
			{
				//�鵽���ڸ��û�		
				session.setAttribute("Y","���û��Ѿ�����,�������û���!!");
				session.setAttribute("Name",request.getParameter("txtusername").trim());
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
			else if("����û���".equals(btnname))
			{
				//�����ڴ��û�
				session.setAttribute("Y","�û�����Ч���������д�����Ϣ");
				session.setAttribute("Name",request.getParameter("txtusername").trim());
				response.sendRedirect(request.getContextPath()+"/register.jsp");			
			}
			else 
			{
				//�ύע�ᣬд�����ݿ�
				BuyUser bu=new BuyUser();
				bu.setName(request.getParameter("txtusername").trim());//�û�����
				bu.setPassword(request.getParameter("txtpwd").trim());	//����							
				bu.setTelePhone(request.getParameter("txttel").trim());//��ϵ�绰
				bu.setEmail(request.getParameter("txtemail").trim());//�����ʼ�
				bu.setTrueName(request.getParameter("txttruename").trim());	//��ʵ����
				bu.setAddress(request.getParameter("txtaddress").trim());//��ϵ��ַ	
				bu.setPostBoy(request.getParameter("txtPostBoy").trim());//�ʱ�
				bu.setPassHint(request.getParameter("txtPassHint").trim());//������ʾ
				 boolean userregister=buyuser.addUser(bu);
				 if(userregister==false)
				 {
					 //д��ʧ��
					 session.setAttribute("registerinfo","ע��ʧ�ܣ������������");
					 response.sendRedirect("www.qq.com");
				 }
				 else
				 {
					 //�ɹ�
					 session.setAttribute("registerinfo","ע��ɹ�!!");					
					 response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
				 }
			}
		}
			else
			{
				//�����û�ע��
				SellUserRules saleuser=new SellUserRulesImpl();				
				boolean tag=saleuser.isContaintUser(request.getParameter("txtusername").trim());
				if(tag==true)
				{
					//�鵽���ڸ��û�		
					session.setAttribute("Y","���û��Ѿ�����,�������û���!!");
					session.setAttribute("Name",request.getParameter("txtusername").trim());
					response.sendRedirect(request.getContextPath()+"/register.jsp");
				}
				else if("����û���".equals(btnname))
				{
					//�����ڴ��û�
					session.setAttribute("Y","�û�����Ч���������д�����Ϣ");
					session.setAttribute("Name",request.getParameter("txtusername").trim());
					response.sendRedirect(request.getContextPath()+"/register.jsp");			
				}
				else 
				{
					//�ύע�ᣬд�����ݿ�
					SellUser seluser=new SellUser();					
					seluser.setUsername(request.getParameter("txtusername").trim());//�û�����
					seluser.setPassword(request.getParameter("txtpwd").trim());	//����							
					seluser.setTetlePhone(request.getParameter("txttel").trim());//��ϵ�绰
					seluser.setEMail(request.getParameter("txtemail").trim());//�����ʼ�
					seluser.setTrueName(request.getParameter("txttruename").trim());	//��ʵ����
					seluser.setAddress(request.getParameter("txtaddress").trim());//��ϵ��ַ	
					seluser.setPostBoy(request.getParameter("txtPostBoy").trim());//�ʱ�
					seluser.setPassHint(request.getParameter("txtPassHint").trim());//������ʾ					
					boolean userregister=saleuser.addUser(seluser);
					 if(userregister==false)
					 {
						 //д��ʧ��
						 session.setAttribute("registerinfo","ע��ʧ�ܣ������������");
					 }
					 else
					 {
						 //�ɹ�
						 session.setAttribute("registerinfo","ע��ɹ�!!");
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
