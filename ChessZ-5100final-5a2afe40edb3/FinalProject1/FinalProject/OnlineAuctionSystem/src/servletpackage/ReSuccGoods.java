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
import entities.Succ;

public class ReSuccGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReSuccGoods() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		SqlConnection consql = new SqlConnection();
		ArrayList list=new ArrayList();
		long id = Long
				.parseLong((String) session.getAttribute("loginedUserId"));// 获取用户ID
		String sql = "select p.pkid, p.GoodsName,p.GoodsDescription,p.Amount,p.BeginPrice ,b.BuyPrice,b.BuyCount,b.Fk_BuUserId from(select * from GoodsInfo where pkid in(select Fk_GoodsId from BuyGoodsInfo)) as p left join BuyGoodsInfo as b on p.pkid=b.Fk_GoodsId where FK_SellId="
				+ id + "";
		ResultSet rs = consql.lookfor(sql);
		try {
			while(rs.next())
			{
				Succ succ=new Succ();
				succ.setId(rs.getLong(1));
				succ.setName(rs.getString(2));
				succ.setMiaos(rs.getString(3));
				succ.setCount(rs.getInt(4));
				succ.setPrice(new Double(rs.getDouble(5)));
				succ.setPrices(new Double(rs.getDouble(6)));
				succ.setBuyCount(rs.getInt(7));
				succ.setBuyUserId(rs.getLong(8));
				list.add(succ);
			}
			if(list.size()!=0)
			{
				session.setAttribute("succinfo","您拍卖成功的商品如下：");
				session.setAttribute("succlist",list);
				response.sendRedirect(request.getContextPath()+"/showSucc.jsp");
			}
			else
			{
				session.setAttribute("succinfo","您还没有拍卖成功的商品：");
				response.sendRedirect(request.getContextPath()+"/showSucc.jsp");
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

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
