<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			我的帐户
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script language="javascript" type="text/javascript">
	 function checkpass()
	 { 	
		if(document.frmupdate.txtpass.value.length==0 ||document.frmupdate.ctxtpass.value.length==0){
			alert("请填写完整的密码信息!!");
			return false;
		}
	    else
	    {	
		if(document.frmupdate.txtpass.value!=document.frmupdate.ctxtpass.value)
			{
			  alert("两次密码不一致,请重新输入!!");			 
			  return false;
			}
		 else {								
		 	return true;
	 		}
		}		
	 }
	</script>
	</head>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<form method="POST" action="/OnLineSaleSystem/servlet/ReUpdatePass" name="frmupdate">
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:180px">
				<table width="40%" align="center" style="background:#dfddff">
					<TBODY>
						<TR>
							<TD colspan="2" align="center" style="color:#ddbbcc;font-size:20px">
								用户密码修改
								<br><br>
							</TD>
						</TR>
						<TR>
							<TD width="20%">
								输入密码:
							</TD>
							<TD width="80%" align="center">
								<INPUT type="password" name="txtpass" size="30">
							</TD>
						</TR>
						<TR>
							<TD>
								重复密码:
							</TD>
							<TD align="center">
								<INPUT type="password" name="ctxtpass" size="30">
							</TD>
						</TR>
						<TR>
							<TD colspan="2" align="center">
								<INPUT type="submit" name="btnupdatepass" value="修改密码" onclick="return checkpass();">
								&nbsp;
								<input type="reset" value="重填密码" name="btnreset">
							</TD>
						</TR>
					</TBODY>
				</table>
				<BR>
				<DIV id="divinfo" align="center" style="font-size:30px;color:#ffbbdd">
					${sessionScope.Updateinfo}
					<c:set scope="session" value="" var="Updateinfo" />
				</DIV>
			</div>
		</form>
	</body>
</html>
