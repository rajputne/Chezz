
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			��������
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<SCRIPT language="javascript" type="text/javascript">
		function checkcontent()
		{       
			if(isNaN(document.frmApp.txtfen.value)||(document.frmApp.txtfen.value)<0 ||document.frmApp.txtfen.value.length==0
			||(document.frmApp.txtfen.value)>100)
				{
					alert("���۷���Ϊ1����100!!");
					return false;
				}
			else{
					var re=/^[0-9]*[0-9]$/;
					if(!re.test(document.frmApp.txtfen.value))
					{
					alert("���۷�������Ϊ���� ����");
					return false;	
					}
					if(document.frmApp.txtcontent.value==0){
						alert("����д������������!!");
								return false;
					}
				    else
				    {	
						return true;
					}
				}	
		}
		</SCRIPT>
	</head>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<form method="POST" action="/OnLineSaleSystem/servlet/ReAppraise" name="frmApp">
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:180px">
				<table width="35%" align="center" style="background:#dfddff">
					<TBODY>
						<TR>
							<TD colspan="2" style="color:green">
								����д���Դ���Ʒ��������Ϣ:
								<br>
								<br>
							</TD>
						</TR>
						<TR>
							<TD width="25%">
								���۷���:
							</TD>
							<TD width="75%">
								<input type="text" name="txtfen" size="31">
							</TD>
						</TR>
						<TR>
							<TD>
								��������:
							</TD>
							<TD>
								<textarea rows="3" name="txtcontent" cols="30">
    					</textarea>
							</TD>
						</TR>
						<TR>
							<TD colspan="2" align="center">
								<input type="submit" value="�ύ����" name="btnsubmit" onclick="return checkcontent();">
								&nbsp;
								<input type="reset" value="��������" name="btnreset">
								&nbsp;
								<a href="FindGoods.jsp">
										����
								</a>								
							</TD>
						</TR>
						<TR>
							<TD colspan="2" align="center" style="color:#3366ff;font-size:20px">
								<BR>
								${sessionScope.Appinfo}
								<c:set var="Appinfo" value="" scope="session"></c:set>
							</TD>
						</TR>
					</TBODY>
				</table>
			</div>
		</form>
	</body>
</html>
