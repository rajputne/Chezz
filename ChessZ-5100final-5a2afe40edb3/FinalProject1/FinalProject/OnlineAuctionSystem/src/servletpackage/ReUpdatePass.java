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
		String pass=request.getParameter("txtpass").trim();//获取密码
		String Userdegree=(String)session.getAttribute("Userdegree");//获取用户身份
		long id=Long.parseLong((String)session.getAttribute("loginedUserId"));//获取用户ID
		
		if("买".equals(Userdegree))
		{
			//购买者修改密码			
			BuyUserRules buyuser=new BuyUserRulesImpl();
			BuyUser bu=new BuyUser();
			bu.setId(id);
			bu.setPassword(pass);
			boolean tag=buyuser.modifyUser(bu);
			if(tag==true)
			{
				//修改成功
				session.setAttribute("Updateinfo","密码修改成功！！");
				response.sendRedirect(request.getContextPath()+"/UserInfo.jsp");
			}else
			{
				//修改失败
				session.setAttribute("Updateinfo","密码修改失败，请检查操作！");
				response.sendRedirect(request.getContextPath()+"/UserInfo.jsp");			
			}
		}
		else{
			//拍卖者修改密码
			SellUserRules selluser=new SellUserRulesImpl();
			SellUser suser=new SellUser();
			suser.setId(id);
			suser.setPassword(pass);
			boolean tag=selluser.modifyUser(suser);
			if(tag==true)
			{
				//密码修改成功
				session.setAttribute("Updateinfo","密码修改成功！！");
				response.sendRedirect(request.getContextPath()+"/UserInfo.jsp");
			}else
			{
				//修改失败
				session.setAttribute("Updateinfo","密码修改失败，请检查操作！");
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
