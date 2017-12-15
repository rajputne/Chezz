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
		String Userdegree = (String) session.getAttribute("Userdegree");// ��ȡ�û����
		// ȡ���û����֣��ж��Ƿ��Ѿ���½
		String userName = (String) session.getAttribute("loginedUserName");
		if (userName == null || "".equals(userName)) {
			// ��һ����ǣ��Ա��û�ע��ɹ����ҵ��ʻ�ҳ��
			session.setAttribute("Login", "���ȵ�½���ٽ�����ز���!");
			response.sendRedirect(request.getContextPath() + "/userLogin.jsp");
			return;
		} else {
			// ����û����ֵ�session���Ա����ڡ��ҵ��ʻ���ҳ����ʹ��
			session.setAttribute("UserName", userName);
			// ��ȡ�û������Ϊʲô����
			String tranname = request.getParameter("tranname").trim();
			if ("userzhanghu".equals(tranname))// �û�����ҵ��ʻ�����
				response.sendRedirect(request.getContextPath()
						+ "/UserInfo.jsp");
			if ("pinglun".equals(tranname))// �û������������
			{
				//long id=Long.parseLong(request.getParameter("shopid"));
				System.out.println(request.getParameter("shopid"));
				session.setAttribute("seId",request.getParameter("shopid"));
				response.sendRedirect(request.getContextPath()
						+ "/Appraise.jsp");
			}
			if ("liuyan".equals(tranname))// �û��������ת������ҳ��
				response.sendRedirect(request.getContextPath()
						+ "/LeaveWord.jsp");
			if("paimai".equals(tranname))
			{
				if("��".equals(Userdegree))
				response.sendRedirect(request.getContextPath()+"/saleGoods.jsp");
				else
				{
					session.setAttribute("Login","������������ݵ�½������");
					response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
				}
			}
			if ("goumai".equals(tranname))// �û��������ʱ
			{
				String id = request.getParameter("shopid");
				System.out.println(id);
				session.setAttribute("selectGoodsId", id);
				response.sendRedirect(request.getContextPath()
						+ "/BuyGoods.jsp");
			}

			if ("buyCar".equals(tranname)) {
				if ("��".equals(Userdegree)) {
						//û��Ȩ�޲鿴���ﳵ
					JOptionPane.showMessageDialog(null, "�Բ�����û��Ȩ�޲鿴���ﳵ!", "��ʾ��Ϣ",
                            JOptionPane.INFORMATION_MESSAGE);
					session.setAttribute("Login","���Թ�������ݵ�½�鿴���ﳵ!");
					response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
				} 
				else {
					// ������ﳵ,׼�����ݣ������͵����ﳵҳ��
					long id = Long.parseLong((String) session
							.getAttribute("loginedUserId"));// ��ȡ�û�ID

					BuyGoodsInfoRules buyGoods = new BuyGoodsInfoRulesImpl();
					ResultSet rs = buyGoods.getBuyGoodsInfo(id);
					try {
						while (rs.next()) {
							BuyGoodsInfo bu = new BuyGoodsInfo();
							bu.setId(rs.getLong(1));// ������
							bu.setBuyUserId(rs.getLong(2));// �û�ID
							bu.setGoodsId(rs.getLong(3));// ��Ʒ���
							bu.setBuyPrice(new Double(rs.getDouble(4)));// ����۸�
							bu.setBuyCount(rs.getInt(5));// ��������
							bu.setBuyTime("" + rs.getDate(6));// ����ʱ��
							bu.setSendAddress(rs.getString(7));// �ͻ���ַ
							bu.setSendFashion(rs.getString(8));// �ͻ���ʽ
							bu.setIsSucc(rs.getByte(9));// �Ƿ�ɹ�
							list.add(bu);// ��������Ʒ����ŵ�List��
						}
						if (list.size() != 0) {
							session.setAttribute("albuygoods", list);
							session.setAttribute("BuyGoodsInfo", "��һ��������������Ʒ��");
							response.sendRedirect(request.getContextPath()
									+ "/buyCar.jsp");
						} else {
							// û�й�����Ʒ
							session
									.setAttribute("BuyGoodsInfo",
											"����û�й����κ���Ʒ����");
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
