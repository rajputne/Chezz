package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import javax.servlet.http.*;

import dataaccess.SqlConnection;
import entities.BuyUser;
import entities.SellUser;
import business.BuyUserRules;
import business.SellUserRules;
import business.impl.BuyUserRulesImpl;
import business.impl.SellUserRulesImpl;

public class ReLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReLogin() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		HttpSession sess = request.getSession(true);
		SqlConnection consql = new SqlConnection();
		String name = request.getParameter("txtusername").trim();
		String pwd = request.getParameter("txtuserpass").trim();
		String loginFin = request.getParameter("radFin").trim();
		if ("".equals(name) || "".equals(pwd)) {
			sess.setAttribute("Login", "请填写完整信息!!!");
			response.sendRedirect(request.getContextPath() + "/userLogin.jsp");
			return;
		} else {
			if ("买".equals(loginFin)) {
				// 以购买者身份登陆
				sess.setAttribute("Userdegree","买");
				BuyUser bu = new BuyUser();
				bu.setName(name);
				bu.setPassword(pwd);
				BuyUserRules buyuser = new BuyUserRulesImpl();
				ResultSet rs = buyuser.loginUser(bu);
				try {
					if (rs.next()) {
						// 登陆成功
						bu.setId(rs.getLong(1));
						bu.setName(rs.getString(2));
						bu.setPassword(rs.getString(3));
						bu.setTelePhone(rs.getString(4));
						bu.setEmail(rs.getString(5));
						bu.setTrueName(rs.getString(6));
						bu.setAddress(rs.getString(7));
						bu.setPostBoy(rs.getString(8));
						bu.setPassHint(rs.getString(9));
						sess.setAttribute("loginedUserId",""+rs.getLong(1));
						sess.setAttribute("loginedUserName",rs.getString(2));
						response.sendRedirect(request.getContextPath()+"/index.jsp");
					} else {
						// 登陆失败
						sess.setAttribute("Login", "对不起，用户名或密码错误，请重新输入!!!!");
						response.sendRedirect(request.getContextPath()
								+ "/userLogin.jsp");
						return;
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						consql.sqlCon().close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} else {
				// 以拍卖者身份登陆
				SellUser suser = new SellUser();
				suser.setUsername(name);
				suser.setPassword(pwd);
				SellUserRules selluser = new SellUserRulesImpl();
				ResultSet rs = selluser.loginUser(suser);
				try {
					if (rs.next()) {
						// 登陆成功
						sess.setAttribute("Userdegree","卖");
						suser.setId(rs.getLong(1));
						suser.setUsername(rs.getString(2));
						suser.setPassword(rs.getString(3));
						suser.setTetlePhone(rs.getString(4));
						suser.setEMail(rs.getString(5));
						suser.setTrueName(rs.getString(6));
						suser.setAddress(rs.getString(7));
						suser.setPostBoy(rs.getString(8));
						suser.setPassHint(rs.getString(9));
						//拍卖者登陆
						sess.setAttribute("loginedUserId",""+rs.getLong(1));
						sess.setAttribute("loginedUserName",rs.getString(2));
						response.sendRedirect(request.getContextPath()+"/saleGoods.jsp");
					} else {
						// 登陆失败
						sess.setAttribute("Login", "对不起，用户名或密码错误，请重新输入!!!!");
						response.sendRedirect(request.getContextPath()
								+ "/userLogin.jsp");
						return;
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						consql.sqlCon().close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
