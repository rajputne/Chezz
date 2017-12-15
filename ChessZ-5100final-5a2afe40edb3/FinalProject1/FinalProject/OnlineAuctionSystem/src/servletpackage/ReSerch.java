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

import business.GoodsInfoRules;
import business.impl.GoodsInfoRulesImpl;

import entities.GoodsInfo;

public class ReSerch extends HttpServlet {
	private static final long serialVersionUID = 354341L;
	public ReSerch() {
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
		response.setCharacterEncoding("GBK");
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		session.removeAttribute("wareName");
		SqlConnection consql=new SqlConnection();
		GoodsInfo goodsinfo=new GoodsInfo();
		GoodsInfoRules goodsRules=new GoodsInfoRulesImpl();
		ArrayList list=new ArrayList();
		//用户搜索
		String radFin=request.getParameter("radSearch").trim();
		if("精确".equals(radFin))
		{
			//进行精确搜索
			goodsinfo.setGoodsName(request.getParameter("txtLookName"));
			ResultSet rs=goodsRules.getGoodsInfo(goodsinfo);//返回所有精确搜索出来的记录
			//数据读取
			try {
				while(rs.next())
				{
					GoodsInfo goodsinfos=new GoodsInfo();
					goodsinfos.setId(rs.getLong(1));
					goodsinfos.setGoodsName(rs.getString(2));
					goodsinfos.setGoodsDescription(rs.getString(3));
					goodsinfos.setBeginPrice(new Double(rs.getDouble(4)));
					goodsinfos.setImagePath(rs.getString(5));
					list.add(goodsinfos);	
				}
				if(list.size()!=0){
					//查到记录集
					 session.setAttribute("wareName",list);
					 session.setAttribute("Serchinfo","您的搜索共包含以下信息:");
					 response.sendRedirect(request.getContextPath()+"/FindGoods.jsp");
					 return;
				 }
				else
				{
					//没有搜索到相关记录
					session.setAttribute("Serchinfo","对不起没有找到您想要的商品");
					response.sendRedirect(request.getContextPath()+"/FindGoods.jsp");				
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
		else
		{
			//进行模糊搜索
			goodsinfo.setGoodsName(request.getParameter("txtLookName"));
			ResultSet rs=goodsRules.getAllGoodsinfo(goodsinfo);//返回所有模糊搜索出来的记录
			//数据读取
			try {
				while(rs.next())
				{
					GoodsInfo goodsinfos=new GoodsInfo();
					goodsinfos.setId(rs.getLong(1));//商品ID
					goodsinfos.setGoodsName(rs.getString(2));//商品名称
					goodsinfos.setGoodsDescription(rs.getString(3));//商品描述
					goodsinfos.setBeginPrice(new Double(rs.getDouble(4)));//商品起始价格
					goodsinfos.setImagePath(rs.getString(5));//商品图片
					list.add(goodsinfos);					
				}
				if(list.size()!=0){
					//查到记录集
					 session.setAttribute("wareName",list);
					 session.setAttribute("Serchinfo","您所的搜索共包含以下信息:");
					 response.sendRedirect(request.getContextPath()+"/FindGoods.jsp");
					 return;
				 }
				else
				{
					//没有搜索到相关记录
					session.setAttribute("Serchinfo","对不起没有找到您想要的商品");
					response.sendRedirect(request.getContextPath()+"/FindGoods.jsp");				
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
	public void init() throws ServletException {
		// Put your code here
	}

}
