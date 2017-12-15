
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>
			¡Ù—‘–≈œ¢
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<form>
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:180px" id="layer1">
				<DIV align="center" style="font-size:20px;color:blue">
					${sessionScope.leaveinfo}
					<c:set value="" var="leaveinfo" scope="session"></c:set>
					<BR>
					<BR>
				</DIV>
				<c:forEach var="linfo" items="${sessionScope.showleave}" varStatus="sta">
					<TABLE width="60%" align="center" style="background:#dfddff">
						<TBODY>
							<c:if test="${(sta.count)==1}">
								<TR>
									<TD width="15%">
										¡Ù—‘±‡∫≈
									</TD>
									<TD width="65%" align="center">
										¡Ù—‘ƒ⁄»›
									</TD>
									<TD width="20%">
										¡Ù—‘ ±º‰
									</TD>
								</TR>
							</c:if>
							<TR>
								<TD align="center" width="15%">
									${linfo.id}
								</TD>
								<TD align="center" width="65%">
									${linfo.content}
								</TD>
								<TD width="20%">
									${linfo.ltime}
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</c:forEach>
			</div>
		</form>
	</body>
</html>
