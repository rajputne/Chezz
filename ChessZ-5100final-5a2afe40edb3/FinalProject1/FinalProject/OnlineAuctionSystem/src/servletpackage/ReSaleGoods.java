package servletpackage;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.GoodsInfoRules;
import business.impl.GoodsInfoRulesImpl;

import entities.GoodsInfo;

public class ReSaleGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ReSaleGoods() {
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
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");		
		//����ʱ��
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String date=f.format(d);
		//����ʱ�����
		//��ȡͼƬ����
		File file=new File(request.getParameter("txtPath"));
		String filetitle=file.getName();
		if(filetitle==null ||"".equals(filetitle))
			filetitle="no.jpg";
		String filename="Image\\"+filetitle;
		//
		GoodsInfo goods=new GoodsInfo();
		long id=Long.parseLong((String)session.getAttribute("loginedUserId"));//��ȡ�����û�ID
		goods.setGoodsName(request.getParameter("txtgoodsname").trim());//�����Ʒ����
		goods.setGoodsDescription(request.getParameter("txtmiaoshu").trim());//�����Ʒ����
		goods.setBeginPrice(Double.valueOf(request.getParameter("txtbeginPrice").trim()));//�����Ʒ��ʼ�۸�
		goods.setImagePath(filename);//�����ƷͼƬ·��
		goods.setGoodsCount(Integer.parseInt(request.getParameter("txtcount").trim()));//�����Ʒ����
		goods.setEnroTime(date);//�����Ʒ���ʱ��
		goods.setSellUserId(id);//��������û�ID
		GoodsInfoRules goodsadd=new GoodsInfoRulesImpl();
		boolean tag=goodsadd.saveGoods(goods);
		if(tag==true)
		{
			//������Ʒ��Ϣ��ӳɹ�
			session.setAttribute("SaleInfo","������Ʒ�ϴ��ɹ�!!");
			response.sendRedirect(request.getContextPath()+"/saleGoods.jsp");
			
		}
		else
		{
			//������Ʒ��Ϣ���ʧ��
			session.setAttribute("SaleInfo","������Ʒ�ϴ�ʧ�ܣ��������!!");
			response.sendRedirect(request.getContextPath()+"/saleGoods.jsp");
		}
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
