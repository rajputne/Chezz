
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			�ҵĹ��ﳵ
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<FORM>
			<DIV style="position: absolute; width: 100%;z-index: 22;overflow:auto; top: 180px" id="layinfoshopping">
				<TABLE width="70%" align="center" style="background:#dfddff">
					<TBODY>
						<TR>
							<TD colspan="6" align="center" style="font-size:20px;color:blue">
								${sessionScope.BuyGoodsInfo}
							</TD>
						</TR>
						<TR>
							<TD width="12%">
								��Ʒ���
							</TD>
							<TD width="12%">
								����۸�
							</TD>
							<TD width="12%">
								��������
							</TD>
							<TD width="27%" align="center">
								�ͻ���ַ
							</TD>
							<TD width="20%" align="center">
								�ͻ���ʽ
							</TD>
							<TD width="17%" align="center">
								����ʱ��
							</TD>
						</TR>
						<c:forEach var="goodsinfo" items="${sessionScope.albuygoods}" varStatus="sta">
							<TR>
								<TD width="12%" align="center">
								<A href="/OnLineSaleSystem/servlet/ReBuySale?checkid=${goodsinfo.goodsId}">
									${goodsinfo.goodsId}
								</A>
								</TD>
								<TD width="12%" align="center">
									${goodsinfo.buyPrice}
								</TD>
								<TD width="12%" align="center">
									${goodsinfo.buyCount}
								</TD>
								<TD align="center">
									${goodsinfo.sendAddress}
								</TD>
								<TD align="center">
									${goodsinfo.sendFashion}
								</TD>
								<TD align="center">
									${goodsinfo.buyTime}
								</TD>
							</TR>
						</c:forEach>
					</TBODY>
				</TABLE>
			</DIV>
		</FORM>
	</body>
</html>
