
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			�û���ϸ��Ϣ
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
	 <jsp:include flush="true" page="Header.jsp" />
	 <div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:200px" id="layer1">
		<DIV align="center" style="font-size:20px;color:blue">
		�û���ϸ��Ϣ    	
    		<BR><BR>
    	</DIV>
		<c:forEach var="saleinfo" items="${sessionScope.uu}" varStatus="sta">
			<TABLE width="40%" align="center" style="background:#dfddff">
				<TBODY>
					<TR>
						<TD width="30%">
							�û�������
						</TD>
						<TD width="70%" align="center">
							${saleinfo.name}
						</TD>
					</TR>
					<TR>
						<TD>
							��ϵ�绰��
						</TD>
						<TD align="center">
							${saleinfo.telePhone}
						</TD>
					</TR>
					<TR>
						<TD>
							�����ʼ���
						</TD>
						<TD align="center">
							${saleinfo.email}
						</TD>
					</TR>
					<TR>
						<TD>
							��ʵ������
						</TD>
						<TD align="center">
							${saleinfo.trueName}
						</TD>
					</TR>
					<TR>
						<TD>
							��ϵ��ַ��
						</TD>
						<TD align="center">
							${saleinfo.address}
						</TD>
					</TR>
					<TR>
						<TD>
							�������룺
						</TD>
						<TD align="center">
							${saleinfo.postBoy}
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</c:forEach>
		</div>
	</body>
</html>
