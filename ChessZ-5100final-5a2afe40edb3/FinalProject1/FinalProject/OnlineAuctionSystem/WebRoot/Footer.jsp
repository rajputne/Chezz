
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<form method="POST" action="/OnLineSaleSystem/servlet/ReSerch" name="frmfooter" id="frmfooter">
			<div style="position: absolute; width: 618px; height: 33px; z-index: 1;" id="layer1">
				<img border="0" src="Image\next.JPG" width="983" height="36" />
			</div>
			<div style="position: absolute; width: 701px; height: 25px; z-index: 1; left: 151px;" id="divlookfor">
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
			<br>
			<br>
			<br>
			<div style="position: absolute; width: 100%; height: 104px; z-index: 10;" id="layer14">
				<table border="0" width="60%" align="center">
					<tr>
						<td align=center>
							<a href="index.jsp">
								<font color="#0000FF">
									��ҳ
								</font>
							</a>
							<font color="#0000FF">
								|
							</font>
							<a href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=userzhanghu">
								<font color="#0000FF">
									�ҵ��ʻ�
								</font>
							</a>
							<font color="#0000FF">
								|
							</font>
							<a href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=buyCar">
								<font color="#0000FF">
									���ﳵ
								</font>
							</a>
							<font color="#0000FF">
								|
							</font>
							<a href="help.jsp" target="new">
								<font color="#0000FF">
									��������
								</font>
							</a>
							<font color="#0000FF">
								|
							</font>
							<a href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=liuyan">
								<font color="#0000FF">
									��������
								</font>
							</a>
							<P></P>
						</td>
					</tr>
					<tr>
						<td align=center>
							��ϵ����:
							<a href="mailto:tangweiqq@126.com">
								fggfdgddgd@126.com
							</a>
							&nbsp;�绰��12345678912 QQ:
							<a href="http://wpa.qq.com/msgrd?V=1&Uin=328320449&Site=idcstar.cn&Menu=yes" target=blank>
								<font size="2" color="#336600">
									124223290
								</font>
							</a>
							<font size="2" color="#336600">
								(
							</font>
							<font color="#9900FF" face="�����п�" size="2">
								Ҷ��
							</font>
							<font color="#336600" size="2">
								)
							</font>
						</td>
					</tr>
					<tr>
						<td align=center>
							xxxxxxxxx����С��@
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
