<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			商品信息
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: underline;
}
a:active {
	text-decoration: none;
}
-->
</style>
	</head>
	<body>
	<jsp:include flush="true" page="Header.jsp" />
		<DIV style="position: absolute; width: 780px;z-index: 22; left: 115px;overflow:auto; top: 180px" id="layinfoshopping">
			<FONT color="#bbddff" size="5px">
			${sessionScope.Serchinfo}
			</FONT>
			<br />
			<TABLE border="0" width="100%" id="tab" height="160">
				<c:forEach var="shopinfo" items="${sessionScope.wareName}" varStatus="sta">
					<c:if test="${(sta.count-1)!=0}">
						<c:choose>
							<c:when test="${(sta.count-1)%3==0}">
								<TR>
									<TD>
										<hr width="400%">
									</TD>
								</TR>
							</c:when>
						</c:choose>
					</c:if>
					<TD>
						<table border="0" width="33%" id="table1" height="188">
							<tr>
								<td height="163" valign="top">
									<p align="center">
										<img border="0" src="${shopinfo.imagePath}" width="135" height="163">
										</a>
									</p>
								</td>
							</tr>
							<tr>
								<td height="9" width="200">
									<p align="center">
										<font color="#CC6600" size="3">
										<A href="/OnLineSaleSystem/servlet/ReBuySale?checkid=${shopinfo.id}">
											${shopinfo.goodsName}
											</A>
										</font>
									</p>
								</td>
							</tr>
							<tr>
								<td align="center">
										<font size="2">
											起始价:￥
											<font color="#9900FF">
												${shopinfo.beginPrice}
											</font>
											元
										</font>
								</td>
							</tr>
							<tr>
								<td align="center">
										<font size="2">
											简单描述:
											<font color="#9900FF">
												${shopinfo.goodsDescription}
											</font>
										</font>
								</td>
							</tr>
							<tr>
								<td height="10" align="center">
									<a href="/OnLineSaleSystem/servlet/UserinfoServlet?shopid=${shopinfo.id}&tranname=goumai">
										购买此商品
									</a>
								</td>
							</tr>
							<TR>
								<TD align="center">
									<A href="/OnLineSaleSystem/servlet/UserinfoServlet?shopid=${shopinfo.id}&tranname=pinglun">
										发表评论
									</A>
								</TD>
							</TR>
							
						</table>
					</TD>
				</c:forEach>
			</TABLE>
		</DIV>
	</body>
</html>
