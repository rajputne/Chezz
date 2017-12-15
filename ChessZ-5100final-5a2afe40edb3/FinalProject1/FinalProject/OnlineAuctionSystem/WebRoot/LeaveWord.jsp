<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			用户留言
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<SCRIPT language="javascript" type="text/javascript">
	function checkcontent()
	{       
			if(document.frmLeave.txtcontent.value==0){
				alert("请先填写您的流言内容!!");
						return false;
			}
		    else
		    {	
				return true;
			}	
	}
</SCRIPT>
	</head>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<form method="POST" action="/OnLineSaleSystem/servlet/ReLeaveWord" name="frmLeave">
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:200px" id="layer1">
				<TABLE width="40%" align="center" style="background:#dfddff">
					<TBODY>
						<TR>
							<TD>
								请在这里输入您的流言内容:

							</TD>
						</TR>
						<TR>
							<TD>
								<textarea rows="3" name="txtcontent" cols="50">
    					</textarea>
							</TD>
						</TR>
						<TR>
							<TD align="center">
								<input type="submit" value="提交我的留言" name="btnsubmit" onclick="return checkcontent();">

								<input type="reset" value="重新填写留言" name="btnreset">
								<A href="/OnLineSaleSystem/servlet/ReAppselect?selectname=liuyan">
									所有留言>>>
								</A>
							</TD>
						</TR>
						<TR>
							<TD style="color:#3366ff;font-size:20px" align="center">
								<BR>
								${sessionScope.LeaveInfo}
								<c:set value="" var="LeaveInfo" scope="session"></c:set>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</div>
		</form>
		<div style="position: absolute; width:100%; height: 42px; z-index: 1; top: 400px" id="layer2">
			<jsp:include flush="true" page="Footer.jsp" />
		</div>
	</body>
</html>
