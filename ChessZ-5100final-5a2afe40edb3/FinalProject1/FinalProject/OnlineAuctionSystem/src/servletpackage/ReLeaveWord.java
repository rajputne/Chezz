package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.LeaveWordRules;
import business.impl.LeaveWordRulesImpl;

import entities.LeaveWord;

public class ReLeaveWord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReLeaveWord() {
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
		HttpSession session=request.getSession();
		//�û����Թ���
		
		String Userdegree=(String)session.getAttribute("Userdegree");// ��ȡ�û����
		if("��".equals(Userdegree))
		{
			// ����ʧ��
			session.setAttribute("LeaveInfo","�Բ�����û������Ȩ��!!");
			response.sendRedirect(request.getContextPath()+"/LeaveWord.jsp");
		}
		else{
			// ����ʱ��
			Date d=new Date();
			SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
			String date=f.format(d);
			long id=Long.parseLong((String)session.getAttribute("loginedUserId"));// ��ȡ�û�ID
			LeaveWord leave=new LeaveWord();
			leave.setBUserid(id);
			leave.setContent(request.getParameter("txtcontent").trim());
			leave.setLtime(date);
			LeaveWordRules lRules=new LeaveWordRulesImpl();
			boolean tag=lRules.saveLeave(leave);
			if(tag==false)
			{
				// ����ʧ��
				session.setAttribute("LeaveInfo","�������Բ���ʧ�ܣ��������!!");
				response.sendRedirect(request.getContextPath()+"/LeaveWord.jsp");
			}
			else
			{
				// ���Գɹ�
				session.setAttribute("LeaveInfo","����������Ϣ�Ѿ��ɹ�����!!");
				response.sendRedirect(request.getContextPath()+"/LeaveWord.jsp");
			}
		}
		out.flush();
		out.close();
	}	public void init() throws ServletException {
		// Put your code here
	}

}
