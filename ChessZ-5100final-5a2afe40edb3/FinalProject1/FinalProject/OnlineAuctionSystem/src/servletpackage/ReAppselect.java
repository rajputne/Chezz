package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataaccess.SqlConnection;
import entities.Appraise;
import entities.GoodsInfo;
import entities.LeaveWord;

public class ReAppselect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReAppselect() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		SqlConnection consql=new SqlConnection();
		ArrayList list=new ArrayList();
		String selectname=request.getParameter("selectname");		
		if("pinglun".equals(selectname))
		{
			//�鿴����������Ϣ
			//long id=Long.parseLong(request.getParameter("selectid"));
			String sql="select * from Appraise ";
			ResultSet rs=consql.lookfor(sql);
			try {
				while(rs.next())
				{
					//��¼����������Ϣ
					Appraise app=new Appraise();
					app.setId(rs.getLong(1));
					app.setAppMark(rs.getInt(3));
					app.setAppContent(rs.getString(4));
					list.add(app);
				}
				if(list.size()!=0)
				{
					session.setAttribute("sappinfo","����������Ϣ���£�");
					session.setAttribute("allApp",list);
					response.sendRedirect(request.getContextPath()+"/showApp.jsp");
				}
				else
				{
					session.setAttribute("sappinfo","û���κ�������Ϣ!");
					response.sendRedirect(request.getContextPath()+"/showApp.jsp");
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
		if("paimai".equals(selectname))
		{
			//�鿴��������������Ʒ��Ϣ
			long id=Long.parseLong((String)session.getAttribute("loginedUserId"));// ��ȡ�û�ID
			String sql="select * from GoodsInfo where FK_SellId="+id+"";
			ResultSet rs=consql.lookfor(sql);
			try {
				while(rs.next())
				{
					GoodsInfo goods=new GoodsInfo();
					goods.setGoodsName(rs.getString(2));
					goods.setGoodsDescription(rs.getString(3));
					goods.setBeginPrice(new Double(rs.getDouble(4)));
					goods.setGoodsCount(rs.getInt(6));
					goods.setEnroTime(""+rs.getDate(7));
					list.add(goods);
				}
				if(list.size()!=0)
				{
					session.setAttribute("saleinfos","��������������Ʒ����:");
					session.setAttribute("saleGoodsinfo",list);
					response.sendRedirect(request.getContextPath()+"/showSaleGoods.jsp");
				}
				else
				{
					session.setAttribute("saleinfos","��û���������κ���Ʒ!");
					response.sendRedirect(request.getContextPath()+"/showSaleGoods.jsp");
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
		if("liuyan".equals(selectname))
		{
			//�鿴����������Ϣ
			String sql="select * from LeaveWord";
			ResultSet rs=consql.lookfor(sql);
			try {
				while(rs.next())
				{
					//��¼����������Ϣ
					LeaveWord leave=new LeaveWord();
					leave.setId(rs.getLong(1));
					leave.setContent(rs.getString(3));
					leave.setLtime(""+rs.getDate(4));
					list.add(leave);
				}
				//session.setAttribute("newDate",new Date());
				if(list.size()!=0)
				{
					session.setAttribute("leaveinfo","����������Ϣ���£�");
					session.setAttribute("showleave",list);
					response.sendRedirect(request.getContextPath()+"/showleave.jsp");
				}else
				{
					session.setAttribute("leaveinfo","û���κ�������Ϣ!");
					response.sendRedirect(request.getContextPath()+"/showleave.jsp");
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
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
