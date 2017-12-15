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
import javax.swing.JOptionPane;

import dataaccess.SqlConnection;

import business.BuyGoodsInfoRules;
import business.impl.BuyGoodsInfoRulesImpl;

import entities.BuyGoodsInfo;

public class UserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserinfoServlet() {
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
		SqlConnection con = new SqlConnection();
		ArrayList list = new ArrayList();
		String Userdegree = (String) session.getAttribute("Userdegree");// 获取用户身份
		// 取出用户名字，判断是否已经登陆
		String userName = (String) session.getAttribute("loginedUserName");
		if (userName == null || "".equals(userName)) {
			// 作一个标记，以便用户注册成功后到我的帐户页面
			session.setAttribute("Login", "请先登陆，再进入相关操作!");
			response.sendRedirect(request.getContextPath() + "/userLogin.jsp");
			return;
		} else {
			// 添加用户名字到session中以便于在“我的帐户”页面中使用
			session.setAttribute("UserName", userName);
			// 获取用户点击的为什么请求
			String tranname = request.getParameter("tranname").trim();
			if ("userzhanghu".equals(tranname))// 用户点击我的帐户连接
				response.sendRedirect(request.getContextPath()
						+ "/UserInfo.jsp");
			if ("pinglun".equals(tranname))// 用户点击发表评论
			{
				//long id=Long.parseLong(request.getParameter("shopid"));
				System.out.println(request.getParameter("shopid"));
				session.setAttribute("seId",request.getParameter("shopid"));
				response.sendRedirect(request.getContextPath()
						+ "/Appraise.jsp");
			}
			if ("liuyan".equals(tranname))// 用户点击留言转到留言页面
				response.sendRedirect(request.getContextPath()
						+ "/LeaveWord.jsp");
			if("paimai".equals(tranname))
			{
				if("卖".equals(Userdegree))
				response.sendRedirect(request.getContextPath()+"/saleGoods.jsp");
				else
				{
					session.setAttribute("Login","请以拍卖者身份登陆拍卖！");
					response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
				}
			}
			if ("goumai".equals(tranname))// 用户点击购买时
			{
				String id = request.getParameter("shopid");
				System.out.println(id);
				session.setAttribute("selectGoodsId", id);
				response.sendRedirect(request.getContextPath()
						+ "/BuyGoods.jsp");
			}

			if ("buyCar".equals(tranname)) {
				if ("卖".equals(Userdegree)) {
						//没有权限查看购物车
					JOptionPane.showMessageDialog(null, "对不起，您没有权限查看购物车!", "提示信息",
                            JOptionPane.INFORMATION_MESSAGE);
					session.setAttribute("Login","请以购买者身份登陆查看购物车!");
					response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
				} 
				else {
					// 点击购物车,准备数据，并发送到购物车页面
					long id = Long.parseLong((String) session
							.getAttribute("loginedUserId"));// 获取用户ID

					BuyGoodsInfoRules buyGoods = new BuyGoodsInfoRulesImpl();
					ResultSet rs = buyGoods.getBuyGoodsInfo(id);
					try {
						while (rs.next()) {
							BuyGoodsInfo bu = new BuyGoodsInfo();
							bu.setId(rs.getLong(1));// 购买编号
							bu.setBuyUserId(rs.getLong(2));// 用户ID
							bu.setGoodsId(rs.getLong(3));// 商品编号
							bu.setBuyPrice(new Double(rs.getDouble(4)));// 购买价格
							bu.setBuyCount(rs.getInt(5));// 购买数量
							bu.setBuyTime("" + rs.getDate(6));// 购买时间
							bu.setSendAddress(rs.getString(7));// 送货地址
							bu.setSendFashion(rs.getString(8));// 送货方式
							bu.setIsSucc(rs.getByte(9));// 是否成功
							list.add(bu);// 将购买商品对象放到List中
						}
						if (list.size() != 0) {
							session.setAttribute("albuygoods", list);
							session.setAttribute("BuyGoodsInfo", "您一共购买了以下商品：");
							response.sendRedirect(request.getContextPath()
									+ "/buyCar.jsp");
						} else {
							// 没有购买商品
							session
									.setAttribute("BuyGoodsInfo",
											"您还没有购买任何商品！！");
							response.sendRedirect(request.getContextPath()
									+ "/buyCar.jsp");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							con.sqlCon().close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
