package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.BuyUser;
import entities.SellUser;

import business.BuyUserRules;
import business.SellUserRules;
import business.impl.BuyUserRulesImpl;
import business.impl.SellUserRulesImpl;

public class ReUpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReUpdatePass() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String pass=request.getParameter("txtpass").trim();//��ȡ����
		String Userdegree=(String)session.getAttribute("Userdegree");//��ȡ�û����
		long id=Long.parseLong((String)session.getAttribute("loginedUserId"));//��ȡ�û�ID
		
		if("��".equals(Userdegree))
		{
			//�������޸�����			
			BuyUserRules buyuser=new BuyUserRulesImpl();
			BuyUser bu=new BuyUser();
			bu.setId(id);
			bu.setPassword(pass);
			boolean tag=buyuser.modifyUser(bu);
			if(tag==true)
			{
				//�޸ĳɹ�
				session.setAttribute("Updateinfo","�����޸ĳɹ�����");
				response.sendRedirect(request.getContextPath()+"/UserInfo.jsp");
			}else
			{
				//�޸�ʧ��
				session.setAttribute("Updateinfo","�����޸�ʧ�ܣ����������");
				response.sendRedirect(request.getContextPath()+"/UserInfo.jsp");			
			}
		}
		else{
			//�������޸�����
			SellUserRules selluser=new SellUserRulesImpl();
			SellUser suser=new SellUser();
			suser.setId(id);
			suser.setPassword(pass);
			boolean tag=selluser.modifyUser(suser);
			if(tag==true)
			{
				//�����޸ĳɹ�
				session.setAttribute("Updateinfo","�����޸ĳɹ�����");
				response.sendRedirect(request.getContextPath()+"/UserInfo.jsp");
			}else
			{
				//�޸�ʧ��
				session.setAttribute("Updateinfo","�����޸�ʧ�ܣ����������");
				response.sendRedirect(request.getContextPath()+"/UserInfo.jsp");	
			}
		}		
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
