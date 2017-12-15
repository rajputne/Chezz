package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataaccess.SqlConnection;

public class ReAppraise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ReAppraise() {
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

		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		SqlConnection consql=new SqlConnection();
		long sellid=0;		
		long gid=Long.parseLong((String)session.getAttribute("seId"));
		System.out.println(gid);
			String sqll="select FK_SellId from GoodsInfo where pkid="+gid+"";
			ResultSet rs=consql.lookfor(sqll);
			try {
				while(rs.next())
				{
					sellid=rs.getLong(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					consql.sqlCon().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//评论处理
		String Userdegree=(String)session.getAttribute("Userdegree");// 获取用户身份
		if("卖".equals(Userdegree))
		{
			//评论添加失败
			session.setAttribute("Appinfo","对不起，您没有评论权限!");
			response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
		}
		else{
			int fen=Integer.parseInt(request.getParameter("txtfen").trim());
			String content=request.getParameter("txtcontent").trim();
			long id=Long.parseLong((String)session.getAttribute("loginedUserId"));//获取用户ID
			String sql="insert into Appraise values("+id+","+fen+",'"+content+"')";			
			boolean tag=consql.conupdate(sql);
			if(tag==false)
			{
				//评论添加失败
				session.setAttribute("Appinfo","您的评论信息发送失败!");
				response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
			}
			else
			{
				//评论发表成功
				String sqlupdate="update SellUser set CreditValue=CreditValue+"+fen+" where pkid="+sellid+"";
				boolean tagg=consql.conupdate(sqlupdate);
				if(tagg==false)
				{
					session.setAttribute("Appinfo","您的评论信息发送失败!");
					response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
				}
				else
				{
				session.setAttribute("Appinfo","您的评论信息已成功发送!");
				response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
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
