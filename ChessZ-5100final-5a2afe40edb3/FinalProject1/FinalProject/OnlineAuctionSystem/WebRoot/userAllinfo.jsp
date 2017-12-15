
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			用户详细信息
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
		用户详细信息    	
    		<BR><BR>
    	</DIV>
		<c:forEach var="saleinfo" items="${sessionScope.uu}" varStatus="sta">
			<TABLE width="40%" align="center" style="background:#dfddff">
				<TBODY>
					<TR>
						<TD width="30%">
							用户姓名：
						</TD>
						<TD width="70%" align="center">
							${saleinfo.name}
						</TD>
					</TR>
					<TR>
						<TD>
							联系电话：
						</TD>
						<TD align="center">
							${saleinfo.telePhone}
						</TD>
					</TR>
					<TR>
						<TD>
							电子邮件：
						</TD>
						<TD align="center">
							${saleinfo.email}
						</TD>
					</TR>
					<TR>
						<TD>
							真实姓名：
						</TD>
						<TD align="center">
							${saleinfo.trueName}
						</TD>
					</TR>
					<TR>
						<TD>
							联系地址：
						</TD>
						<TD align="center">
							${saleinfo.address}
						</TD>
					</TR>
					<TR>
						<TD>
							邮政编码：
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
