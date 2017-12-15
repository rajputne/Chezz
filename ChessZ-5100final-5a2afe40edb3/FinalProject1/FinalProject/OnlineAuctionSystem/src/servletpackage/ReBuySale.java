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
import entities.GoodsInfo;

public class ReBuySale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ReBuySale() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		HttpSession session = request.getSession(false);
		SqlConnection consql=new SqlConnection();
		ArrayList list=new ArrayList();
		GoodsInfo goods=new GoodsInfo();
		long sellid=0;
		int Cvalue=0;
		//处理显示商品详细信息
		long id=Long.parseLong(request.getParameter("checkid"));
		String sl="select FK_SellId from GoodsInfo where pkid="+id+"";
		ResultSet rss=consql.lookfor(sl);
		try {
			while(rss.next())
			{
				sellid=rss.getLong(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			try {
				consql.sqlCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String sq="select CreditValue from SellUser where pkid="+sellid+"";
		ResultSet res=consql.lookfor(sq);
		try {
			while(res.next())
			{
				Cvalue=res.getInt(1);
			}
			if(Cvalue<100)
			{
				//最低等级
				session.setAttribute("dengji","一般");
			}
			if(Cvalue>=100 && Cvalue<200)
			{
				//中级
				session.setAttribute("dengji","中级");
			}
			if(Cvalue>=200 && Cvalue<500)
			{
				//高级
				session.setAttribute("dengji","高级");
			}
			if(Cvalue>=500)
			{
				//特级
				session.setAttribute("dengji","特级");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			try {
				consql.sqlCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String sql="select * from GoodsInfo where pkid="+id+"";
		ResultSet rs=consql.lookfor(sql);
		try {
			while(rs.next())
			{
				//goods.setId(rs.getLong(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsDescription(rs.getString(3));
				goods.setBeginPrice(new Double(rs.getDouble(4)));
				goods.setImagePath(rs.getString(5));
				goods.setEnroTime(""+rs.getDate(7));
				list.add(goods);
			}
			if(list.size()!=0)
			{
				session.setAttribute("onegoodsinfo",list);
				response.sendRedirect(request.getContextPath()+"/AllInfo.jsp");
			}
			else
			{
				//
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
