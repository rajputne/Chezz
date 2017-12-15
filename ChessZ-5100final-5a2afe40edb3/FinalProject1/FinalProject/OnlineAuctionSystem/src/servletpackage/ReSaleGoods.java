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
		//设置时间
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String date=f.format(d);
		//设置时间结束
		//获取图片名称
		File file=new File(request.getParameter("txtPath"));
		String filetitle=file.getName();
		if(filetitle==null ||"".equals(filetitle))
			filetitle="no.jpg";
		String filename="Image\\"+filetitle;
		//
		GoodsInfo goods=new GoodsInfo();
		long id=Long.parseLong((String)session.getAttribute("loginedUserId"));//获取拍卖用户ID
		goods.setGoodsName(request.getParameter("txtgoodsname").trim());//添加商品名字
		goods.setGoodsDescription(request.getParameter("txtmiaoshu").trim());//添加商品描述
		goods.setBeginPrice(Double.valueOf(request.getParameter("txtbeginPrice").trim()));//添加商品起始价格
		goods.setImagePath(filename);//添加商品图片路径
		goods.setGoodsCount(Integer.parseInt(request.getParameter("txtcount").trim()));//添加商品数量
		goods.setEnroTime(date);//添加商品添加时间
		goods.setSellUserId(id);//添加拍卖用户ID
		GoodsInfoRules goodsadd=new GoodsInfoRulesImpl();
		boolean tag=goodsadd.saveGoods(goods);
		if(tag==true)
		{
			//拍卖商品信息添加成功
			session.setAttribute("SaleInfo","拍卖商品上传成功!!");
			response.sendRedirect(request.getContextPath()+"/saleGoods.jsp");
			
		}
		else
		{
			//拍卖商品信息添加失败
			session.setAttribute("SaleInfo","拍卖商品上传失败，请检查操作!!");
			response.sendRedirect(request.getContextPath()+"/saleGoods.jsp");
		}
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
