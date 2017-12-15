
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			商品详细信息
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<DIV style="position: absolute; width:100%;z-index: 22;overflow:auto; top: 180px" id="layinfoshopping">
			<c:forEach var="shopinfo" items="${sessionScope.onegoodsinfo}" varStatus="sta">
				<TABLE width="30%" align="center">
					<TBODY>
						<TR>
							<TD colspan="2" style="font-size:20px;color:blue" align="center">
								商品详细信息:<BR><BR>
							</TD>
						</TR>
						<TR>
							<td valign="top" align="center" width="100%" height="210" colspan="2">
								<img border="0" src="${shopinfo.imagePath}" height="210" width="100%">
							</td>
						</TR>
						<TR>
							<TD width="30%">
								商品名称：
							</TD>
							<TD align="center" width="70%">
								<font color="#9900FF">
									${shopinfo.goodsName}
								</font>
							</TD>
						</TR>
						<TR>
							<TD>
								起始价格：
							</TD>
							<TD align="center">
								<font color="#9900FF">
									${shopinfo.beginPrice}
								</font>
							</TD>
						</TR>
						<TR>
							<TD>
								商品描述：
							</TD>
							<TD align="center">
								<font color="#9900FF">
									${shopinfo.goodsDescription}
								</font>
							</TD>
						</TR>
						<TR>
							<TD>
								发布时间：
							</TD>
							<TD align="center">
								<font color="#9900FF">
									${shopinfo.enroTime}
								</font>
							</TD>
						</TR>
						<TR>
							<TD>
								用户等级：
							</TD>
							<TD align="center">
								<font color="#9900FF">
									${sessionScope.dengji}
								</font>
							</TD>
						</TR>
						<TR>
								<TD align="center" colspan="2">
									<A href="/OnLineSaleSystem/servlet/ReAppselect?selectname=pinglun">
										关于此商品所有评论>>>>
									</A>
								</TD>
							</TR>
					</TBODY>
				</TABLE>
			</c:forEach>
		</DIV>
	</body>
</html>
