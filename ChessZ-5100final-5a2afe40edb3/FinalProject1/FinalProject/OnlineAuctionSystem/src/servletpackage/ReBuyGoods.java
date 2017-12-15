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
		String Userdegree = (String) session.getAttribute("Userdegree");// ��ȡ�û����
		if ("��".equals(Userdegree)) {
			// �û���������ݵ�½
			session.setAttribute("buyinfo", "����û��Ȩ�޾��۹�����Ʒ!");
			response.sendRedirect(request.getContextPath() + "/BuyGoods.jsp");
		} else {
			// �û���������ݵ�½

			float price = 0;// ������Ʒ������е���ʱ��߼۸�
			int shuliang = 0;// ������Ʒ��Ϣ���е���ʱ��Ʒ����
			float beginprice = 0;// ������Ʒ��Ϣ���е���ʱ����ʼ�۸�
			// ����ʱ��
			Date d = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String date = f.format(d);
			long id = Long.parseLong((String) session
					.getAttribute("selectGoodsId"));// �����ƷID
			long userid = Long.parseLong((String) session
					.getAttribute("loginedUserId"));// ��ȡ�û�ID
			String sql = "select BuyPrice from BuyGoodsInfo where Fk_GoodsId="
					+ id + " ";// ��ѯ��Ʒ������е���߾���
			String sqlcount = "select BeginPrice,Amount from GoodsInfo where pkid="
					+ id + "";// ��ѯ��Ʒ��Ϣ������Ʒ������
			ResultSet rs1 = consql.lookfor(sqlcount);
			ResultSet rs = consql.lookfor(sql);
			try {
				while (rs1.next()) {
					beginprice = rs1.getFloat(1);// ��ȡ��Ʒ��Ϣ���е���ʼ�۸�
					shuliang = rs1.getInt(2);// ��ȡ��Ʒ��Ϣ������Ʒ������
				}
				while (rs.next()) {
					price = rs.getFloat(1);// ��ȡ��Ʒ����������ߵ���߾���
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
			float money = Float.parseFloat(request.getParameter("txtprice"));// ����۸�
			if (money > price && money > beginprice) {
				// ���۳ɹ�
				int count = Integer.parseInt(request
						.getParameter("txtbuycount"));// ��������
				if (count <= shuliang) {
					String address = request.getParameter("txtaddress");
					String sendFin = request.getParameter("txtsendFin");
					// ������ݿ����Ƿ���ڶԵ�ǰ�û����ڹ������Ʒ��Ϣ
					String sqlexists = "select * from BuyGoodsInfo where Fk_GoodsId="
							+ id + "";
					ResultSet rsex = consql.lookfor(sqlexists);
					try {
						if (rsex.next() == true) {
							// ���¼�¼
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
								// ����ʧ��
								session.setAttribute("buyinfo", "���۹������ʧ��!");
								response.sendRedirect(request.getContextPath()
										+ "/BuyGoods.jsp");
							} else {
								// �����ɹ�
								session.setAttribute("buyinfo",
										"���ľ���������Ϣ�ѳɹ�����!");
								response.sendRedirect(request.getContextPath()
										+ "/BuyGoods.jsp");
							}
						} else {
							// �����¼�¼
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
								// ����ʧ��
								session.setAttribute("buyinfo", "���۹������ʧ��!");
								response.sendRedirect(request.getContextPath()
										+ "/BuyGoods.jsp");
							} else {
								// �����ɹ�
								session.setAttribute("buyinfo",
										"���ľ���������Ϣ�ѳɹ�����!");
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
							consql.sqlCon().close();// �ر����ݿ�����
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					// ����ʧ��
					session.setAttribute("buyinfo", "����������������������ʧ��!");
					response.sendRedirect(request.getContextPath()
							+ "/BuyGoods.jsp");
				}
			} else {
				// ����ʧ��
				session.setAttribute("buyinfo", "���۹��ͣ�����ʧ��!");
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
