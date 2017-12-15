package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataaccess.SqlConnection;

public class ReBuyGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReBuyGoods() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		SqlConnection consql = new SqlConnection();
		String Userdegree = (String) session.getAttribute("Userdegree");// 获取用户身份
		if ("卖".equals(Userdegree)) {
			// 用户以卖者身份登陆
			session.setAttribute("buyinfo", "您还没有权限竟价购买商品!");
			response.sendRedirect(request.getContextPath() + "/BuyGoods.jsp");
		} else {
			// 用户以买者身份登陆

			float price = 0;// 保存商品购买表中的临时最高价格
			int shuliang = 0;// 保存商品信息表中的临时商品数量
			float beginprice = 0;// 保存商品信息表中的临时的起始价格
			// 设置时间
			Date d = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String date = f.format(d);
			long id = Long.parseLong((String) session
					.getAttribute("selectGoodsId"));// 获得商品ID
			long userid = Long.parseLong((String) session
					.getAttribute("loginedUserId"));// 获取用户ID
			String sql = "select BuyPrice from BuyGoodsInfo where Fk_GoodsId="
					+ id + " ";// 查询商品购买表中的最高竟价
			String sqlcount = "select BeginPrice,Amount from GoodsInfo where pkid="
					+ id + "";// 查询商品信息表中商品的数量
			ResultSet rs1 = consql.lookfor(sqlcount);
			ResultSet rs = consql.lookfor(sql);
			try {
				while (rs1.next()) {
					beginprice = rs1.getFloat(1);// 获取商品信息表中的起始价格
					shuliang = rs1.getInt(2);// 获取商品信息表中商品的数量
				}
				while (rs.next()) {
					price = rs.getFloat(1);// 获取商品购买表中买者的最高竟价
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
			float money = Float.parseFloat(request.getParameter("txtprice"));// 购买价格
			if (money > price && money > beginprice) {
				// 竟价成功
				int count = Integer.parseInt(request
						.getParameter("txtbuycount"));// 购买数量
				if (count <= shuliang) {
					String address = request.getParameter("txtaddress");
					String sendFin = request.getParameter("txtsendFin");
					// 检查数据库中是否存在对当前用户正在购买的商品信息
					String sqlexists = "select * from BuyGoodsInfo where Fk_GoodsId="
							+ id + "";
					ResultSet rsex = consql.lookfor(sqlexists);
					try {
						if (rsex.next() == true) {
							// 更新记录
							String sqlupdate = "update BuyGoodsInfo set Fk_BuUserId="
									+ userid
									+ ",BuyPrice="
									+ money
									+ ",BuyCount="
									+ count
									+ ""
									+ ",BuyTime='"
									+ date
									+ "',SendAddress='"
									+ address
									+ "',SendFashion='"
									+ sendFin
									+ "' where Fk_GoodsId=" + id + "";
							boolean tag = consql.conupdate(sqlupdate);
							if (tag == false) {
								// 操作失败
								session.setAttribute("buyinfo", "竟价购买操作失败!");
								response.sendRedirect(request.getContextPath()
										+ "/BuyGoods.jsp");
							} else {
								// 操作成功
								session.setAttribute("buyinfo",
										"您的竟价拍买信息已成功发送!");
								response.sendRedirect(request.getContextPath()
										+ "/BuyGoods.jsp");
							}
						} else {
							// 保存新记录
							String sqlinsert = "insert into BuyGoodsInfo values("
									+ userid
									+ ","
									+ id
									+ ""
									+ ","
									+ money
									+ ","
									+ count
									+ ",'"
									+ date
									+ "','"
									+ address
									+ "','"
									+ sendFin
									+ "',"
									+ 1
									+ ")";
							boolean tag = consql.conupdate(sqlinsert);
							if (tag == false) {
								// 操作失败
								session.setAttribute("buyinfo", "竟价购买操作失败!");
								response.sendRedirect(request.getContextPath()
										+ "/BuyGoods.jsp");
							} else {
								// 操作成功
								session.setAttribute("buyinfo",
										"您的竟价拍买信息已成功发送!");
								response.sendRedirect(request.getContextPath()
										+ "/BuyGoods.jsp");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							consql.sqlCon().close();// 关闭数据库连接
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					// 购买失败
					session.setAttribute("buyinfo", "数量超过现有数量，购买失败!");
					response.sendRedirect(request.getContextPath()
							+ "/BuyGoods.jsp");
				}
			} else {
				// 竟价失败
				session.setAttribute("buyinfo", "竟价过低，购买失败!");
				response.sendRedirect(request.getContextPath()
						+ "/BuyGoods.jsp");
			}
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
