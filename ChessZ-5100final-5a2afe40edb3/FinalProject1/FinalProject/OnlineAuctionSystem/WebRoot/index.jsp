<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			Ê×Ò³
		</title>
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

			<jsp:include flush="true" page="Header.jsp" />
			<div style="position: absolute; width: 201px; height: 165px; z-index: 10; left: 22px; top: 165px" id="layer1">
				<img border="0" src="Image\0.jpg" width="955" height="350">
			</div>

			<DIV style="position: absolute; width: 950px; height: 58px; z-index: 9; top: 540px" id="lay">
				<jsp:include flush="true" page="Footer.jsp" />
			</DIV>
		</form>
	</body>

</html>
