package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataaccess.SqlConnection;

public class ReAppraise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ReAppraise() {
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

		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		SqlConnection consql=new SqlConnection();
		long sellid=0;		
		long gid=Long.parseLong((String)session.getAttribute("seId"));
		System.out.println(gid);
			String sqll="select FK_SellId from GoodsInfo where pkid="+gid+"";
			ResultSet rs=consql.lookfor(sqll);
			try {
				while(rs.next())
				{
					sellid=rs.getLong(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					consql.sqlCon().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//���۴���
		String Userdegree=(String)session.getAttribute("Userdegree");// ��ȡ�û����
		if("��".equals(Userdegree))
		{
			//�������ʧ��
			session.setAttribute("Appinfo","�Բ�����û������Ȩ��!");
			response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
		}
		else{
			int fen=Integer.parseInt(request.getParameter("txtfen").trim());
			String content=request.getParameter("txtcontent").trim();
			long id=Long.parseLong((String)session.getAttribute("loginedUserId"));//��ȡ�û�ID
			String sql="insert into Appraise values("+id+","+fen+",'"+content+"')";			
			boolean tag=consql.conupdate(sql);
			if(tag==false)
			{
				//�������ʧ��
				session.setAttribute("Appinfo","����������Ϣ����ʧ��!");
				response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
			}
			else
			{
				//���۷���ɹ�
				String sqlupdate="update SellUser set CreditValue=CreditValue+"+fen+" where pkid="+sellid+"";
				boolean tagg=consql.conupdate(sqlupdate);
				if(tagg==false)
				{
					session.setAttribute("Appinfo","����������Ϣ����ʧ��!");
					response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
				}
				else
				{
				session.setAttribute("Appinfo","����������Ϣ�ѳɹ�����!");
				response.sendRedirect(request.getContextPath()+"/Appraise.jsp");
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
