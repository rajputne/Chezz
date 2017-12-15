package servletpackage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataaccess.SqlConnection;
import entities.BuyUser;

public class ReUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ReUserInfo() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session=request.getSession();
		SqlConnection consql=new SqlConnection();
		ArrayList list=new ArrayList();
		BuyUser b=new BuyUser();
		long id=Long.parseLong(request.getParameter("userinfoid"));
		String sql="select * from BuyUser where pkid="+id+"";
		ResultSet rs=consql.lookfor(sql);
		try {
			while(rs.next())
			{
				
				b.setName(rs.getString(2));
				b.setTelePhone(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setTrueName(rs.getString(6));
				b.setAddress(rs.getString(7));
				b.setPostBoy(rs.getString(8));
				list.add(b);
			}
			if(list.size()!=0)
			{
			session.setAttribute("uu",list);
			response.sendRedirect(request.getContextPath()+"/userAllinfo.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				consql.sqlCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request,response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
