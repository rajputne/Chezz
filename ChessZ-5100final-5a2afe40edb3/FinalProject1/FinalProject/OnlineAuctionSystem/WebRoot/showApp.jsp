
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>留言信息</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>  
  <body>
  <jsp:include flush="true" page="Header.jsp" />
    <form>
    <div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:200px" id="layer1">
    	<DIV align="center" style="font-size:20px;color:blue">${sessionScope.sappinfo}
    	<c:set value="" var="sappinfo" scope="session"></c:set>
    		<BR><BR>
    	</DIV>
    	<c:forEach var="Appinfo" items="${sessionScope.allApp}" varStatus="sta">
			<TABLE width="60%" align="center"  style="background:#dfddff">
				<TBODY>
					<c:if test="${(sta.count)==1}">
						<TR>
							<TD width="15%">
								评论编号
							</TD>
							<TD width="15%">
								评论分数
							</TD>
							<TD width="70%" align="center">
								评论内容
							</TD>
						</TR>
					</c:if>
					<TR>
						<TD width="15%" align="center">
							${Appinfo.id}
						</TD>
						<TD width="15%" align="center">
							${Appinfo.appMark}
						</TD>
						<TD width="70%" align="center">
							${Appinfo.appContent}
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</c:forEach>
		</div>
    </form>
  </body>
</html>
