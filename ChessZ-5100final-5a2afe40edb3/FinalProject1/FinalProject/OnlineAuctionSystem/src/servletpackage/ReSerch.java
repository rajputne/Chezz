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
		//�û�����
		String radFin=request.getParameter("radSearch").trim();
		if("��ȷ".equals(radFin))
		{
			//���о�ȷ����
			goodsinfo.setGoodsName(request.getParameter("txtLookName"));
			ResultSet rs=goodsRules.getGoodsInfo(goodsinfo);//�������о�ȷ���������ļ�¼
			//���ݶ�ȡ
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
					//�鵽��¼��
					 session.setAttribute("wareName",list);
					 session.setAttribute("Serchinfo","��������������������Ϣ:");
					 response.sendRedirect(request.getContextPath()+"/FindGoods.jsp");
					 return;
				 }
				else
				{
					//û����������ؼ�¼
					session.setAttribute("Serchinfo","�Բ���û���ҵ�����Ҫ����Ʒ");
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
			//����ģ������
			goodsinfo.setGoodsName(request.getParameter("txtLookName"));
			ResultSet rs=goodsRules.getAllGoodsinfo(goodsinfo);//��������ģ�����������ļ�¼
			//���ݶ�ȡ
			try {
				while(rs.next())
				{
					GoodsInfo goodsinfos=new GoodsInfo();
					goodsinfos.setId(rs.getLong(1));//��ƷID
					goodsinfos.setGoodsName(rs.getString(2));//��Ʒ����
					goodsinfos.setGoodsDescription(rs.getString(3));//��Ʒ����
					goodsinfos.setBeginPrice(new Double(rs.getDouble(4)));//��Ʒ��ʼ�۸�
					goodsinfos.setImagePath(rs.getString(5));//��ƷͼƬ
					list.add(goodsinfos);					
				}
				if(list.size()!=0){
					//�鵽��¼��
					 session.setAttribute("wareName",list);
					 session.setAttribute("Serchinfo","����������������������Ϣ:");
					 response.sendRedirect(request.getContextPath()+"/FindGoods.jsp");
					 return;
				 }
				else
				{
					//û����������ؼ�¼
					session.setAttribute("Serchinfo","�Բ���û���ҵ�����Ҫ����Ʒ");
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
