<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>    
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
		<form method="POST" action="/OnLineSaleSystem/servlet/ReSerch" name="frmindex" id="frmindex">
			<div style="position: absolute; width: 100px; height: 100px; z-index: 1" id="layer1">
				<img border="0" src="Image\69.jpg" width="980" height="136">
				<div style="position: absolute; width: 701px; height: 25px; z-index: 1; left: 160px; top: 64px" id="divlookfor">
					<table border="0" width="100%">
						<tr>
							<td width="15%">
								��Ʒ����:
							</td>
							<td width="281">
								<input type="text" name="txtLookName" size="38">
							</td>
							<td colspan="2" align="center">
								<input type="radio" value="��ȷ" checked name="radSearch">
								��ȷ����
								<input type="radio" name="radSearch" value="ȫ��">
								ȫ������
							</td>
							<td width="94">
								<input type="submit" value=" ���� " name="resubmit">
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div style="position: absolute; width: 470px; height: 19px; z-index: 2; left: 422px; top: 33px">
				<A href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=buyCar">
					�ҵĹ��ﳵ
				</A>
				&nbsp;|
				<A href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=userzhanghu">
					�ҵ��ʻ�
				</A>
				&nbsp;|
			
				<A href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=paimai">
					��Ʒ����
				</A>
				&nbsp;|				
				<a href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=liuyan">
						��������
				</a>
				&nbsp;|
				<A href="help.jsp" target="new">
					��������
				</A>
				
			</div>

			<div style="position: absolute; width: 37px; height: 21px; z-index: 3; left: 362px; top: 35px">
				<A href="index.jsp">
					��ҳ
				</A>
			</div>

			<div style="position: absolute; width: 700px; height: 20px; z-index: 4; left: 277px; top: 130px" id="divUserinfo">
				����,
				<font color="#800000">
					${sessionScope.loginedUserName}
				</font>
				&nbsp;&nbsp;
				��ӭ���ٱ���վ!
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				[<a href="userLogin.jsp">��½</a>]&nbsp;[<a href="register.jsp">ע��</a>]</div>
			<div style="position: absolute; width: 137px; height: 34px; z-index: 5; left: 151px; top: 18px">
				<i>
					<font face="French Script MT" size="6" color="#008000">
						OnLineSale
					</font>
				</i>
			</div>
		</form>
	</body>
</html>
