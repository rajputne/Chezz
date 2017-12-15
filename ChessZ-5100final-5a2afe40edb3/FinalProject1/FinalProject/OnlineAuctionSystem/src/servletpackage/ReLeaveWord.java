package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.LeaveWordRules;
import business.impl.LeaveWordRulesImpl;

import entities.LeaveWord;

public class ReLeaveWord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReLeaveWord() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		//用户留言管理
		
		String Userdegree=(String)session.getAttribute("Userdegree");// 获取用户身份
		if("卖".equals(Userdegree))
		{
			// 留言失败
			session.setAttribute("LeaveInfo","对不起，您没有留言权限!!");
			response.sendRedirect(request.getContextPath()+"/LeaveWord.jsp");
		}
		else{
			// 设置时间
			Date d=new Date();
			SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
			String date=f.format(d);
			long id=Long.parseLong((String)session.getAttribute("loginedUserId"));// 获取用户ID
			LeaveWord leave=new LeaveWord();
			leave.setBUserid(id);
			leave.setContent(request.getParameter("txtcontent").trim());
			leave.setLtime(date);
			LeaveWordRules lRules=new LeaveWordRulesImpl();
			boolean tag=lRules.saveLeave(leave);
			if(tag==false)
			{
				// 留言失败
				session.setAttribute("LeaveInfo","您的留言操作失败，请检查操作!!");
				response.sendRedirect(request.getContextPath()+"/LeaveWord.jsp");
			}
			else
			{
				// 留言成功
				session.setAttribute("LeaveInfo","您的留言信息已经成功发送!!");
				response.sendRedirect(request.getContextPath()+"/LeaveWord.jsp");
			}
		}
		out.flush();
		out.close();
	}	public void init() throws ServletException {
		// Put your code here
	}

}
