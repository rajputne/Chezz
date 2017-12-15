
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>
			已经拍卖过的商品
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<form method="POST" action="/OnLineSaleSystem/servlet/ReLeaveWord" name="frmshow">
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:200px" id="layer1">
				<DIV align="center" style="font-size:20px;color:blue">${sessionScope.saleinfos}
    	<c:set value="" var="saleinfos" scope="session"></c:set>
    		<BR><BR>
    	</DIV>
    	<c:forEach var="saleinfo" items="${sessionScope.saleGoodsinfo}" varStatus="sta">
			<TABLE width="65%" align="center"  style="background:#dfddff">
				<TBODY>
					<c:if test="${(sta.count)==1}">
						<TR>
							<TD width="15%">
								商品名称
							</TD>
							<TD width="15%">
								起始价格
							</TD>
							<TD width="40%" align="center">
								商品描述
							</TD>
							<TD width="15%" >
								拍卖数量
							</TD>
							<TD width="15%">
								拍卖时间
							</TD>
						</TR>
					</c:if>
					<TR>
						<TD width="15%" align="center">
							${saleinfo.goodsName}
						</TD>
						<TD width="15%" align="center">
							${saleinfo.beginPrice}
						</TD>
						<TD width="40%" align="center">
							${saleinfo.goodsDescription}
						</TD>
						<TD width="15%" align="center">
							${saleinfo.goodsCount}
						</TD>
						<TD width="15%" align="center">
							${saleinfo.enroTime}
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</c:forEach>
			</div>
		</form>
	</body>
</html>
