
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>���������ʾ</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <jsp:include flush="true" page="Header.jsp" />
		<form method="POST" action="/OnLineSaleSystem/servlet/ReLeaveWord" name="frmshowsucc">
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:200px" id="layer1">
				<DIV align="center" style="font-size:20px;color:blue">${sessionScope.succinfo}
    	
    		<BR><BR>
    	</DIV>
    	<c:forEach var="saleinfo" items="${sessionScope.succlist}" varStatus="sta">
			<TABLE width="80%" align="center"  style="background:#dfddff">
				<TBODY>
					<c:if test="${(sta.count)==1}">
						<TR>
							<TD width="10%">
								��Ʒ���
							</TD>
							<TD width="15%" align="center">
								��Ʒ����
							</TD>
							<TD width="25%" align="center">
								��Ʒ����
							</TD>
							<TD width="10%" >
								��������
							</TD>
							<TD width="10%">
								��ʼ�۸�
							</TD>
							<TD width="10%">
								����۸�
							</TD>
							<TD width="10%">
								��������
							</TD>
							<TD width="10%">
								�����û�
							</TD>
						</TR>
					</c:if>
					<TR>
						<TD width="10%" align="center">
							${saleinfo.id}
						</TD>
						<TD width="15%" align="center">
							${saleinfo.name}
						</TD>
						<TD width="25%" align="center">
							${saleinfo.miaos}
						</TD>
						<TD width="10%" align="center">
							${saleinfo.count}
						</TD>
						<TD width="10%" align="center">
							${saleinfo.price}
						</TD>
						<TD width="10%" align="center">
							${saleinfo.prices}
						</TD>
						<TD width="10%" align="center">
							${saleinfo.buyCount}
						</TD>
						<TD width="10%" align="center">
							<A href="/OnLineSaleSystem/servlet/ReUserInfo?userinfoid=${saleinfo.buyUserId}">
							${saleinfo.buyUserId}
							</A>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</c:forEach>
			</div>
		</form>
  </body>
</html>
