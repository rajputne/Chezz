<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>
			�û���¼
		</title>
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
	<script language="javascript" type="text/javascript">
 function checkusername()
 { 	
		document.getElementById("1").style.display="none";	
 }
</script>
	<body link="#0000FF" vlink="#0000FF" alink="#0000FF">
		<form method="POST" action="/OnLineSaleSystem/servlet/ReLogin" name="frmlogin">
			<div style="position: absolute; width: 100px; height: 409px; z-index: 1; left: 121px; top: 5px" id="layer1">
				<img border="0" src="Image\df.jpg" width="722" height="409">
				<div style="position: absolute; width: 251px; height: 75px; z-index: 1; left: 76px; top: 203px" id="layer17">
					<TABLE>
						<TBODY>
							<TR>
								<td colspan="2" align="center">
								<input type="radio" value="��" checked name="radFin" onclick="showCreadit();">
								�����½&nbsp;
								<input type="radio" name="radFin" value="��" onclick="onshowCredit();">
								������½
								</td>
							</TR>
							<TR>
								<TD>
								�û���:
								</TD>
								<TD>
									<input type="text" name="txtusername" size="19"  onblur="checkusername();">
								</TD>
							</TR>
							<TR>
								<TD>
								�� &nbsp;�룺
								</TD>
								<TD>
									<input type="password" name="txtuserpass" size="20">
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</div>
				<div style="position: absolute; width: 209px; height: 22px; z-index: 3; left: 486px; top: 370px" id="layer19">
					<b>
						<font color="#0099CC">
							����ʲô�Ͽ�
						</font>
					</b>
					<a href="register.jsp">
						<font color="#800000">
							ע��
						</font>
					</a>
					<b>
						<font color="#0099CC">
							��!!
						</font>
					</b>
				</div>
				<!--hjkhkjk-->
				<div style="position: absolute; width: 233px; height: 29px; z-index: 5; left: 75px; top: 287px" id="layer21">

					<p>
						<input type="submit" value="  ��     ¼  " name="btnlogin" style="padding-top: 4px; padding-bottom: 4px; background-Image: url('Image\de.jpg')">
						&nbsp;
						<a href="register.jsp">
							���ע��
						</a>
					</p>
				</div>
		</form>
		<div style="position: absolute; width: 400px; height: 100px; z-index: 10; left: 200px; top: 426px" id="layer13">
			<A href="index.jsp">��ҳ |</A>			
			<A href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=buyCar">�ҵĹ��ﳵ | </A>
			<A href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=userzhanghu">�ҵ��ʻ� |</A>			
			<A href="help.jsp" target="new">�������� |</A>
			<a href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=liuyan">��������</a>
		</div>
		<DIV style="position: absolute; width: 196px; height: 46px; z-index: 11; left: 160px; top: 130px" id=1>
			<font color="#FF0000">
				${sessionScope.Login}
				<c:set var="Login" value="" scope="session"></c:set>
			</font>
		</DIV>
	</body>
</html>
