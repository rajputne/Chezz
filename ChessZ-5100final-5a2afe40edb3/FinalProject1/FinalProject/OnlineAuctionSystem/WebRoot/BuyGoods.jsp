<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			��Ʒ����
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<SCRIPT language="javascript" type="text/javascript">
		function checkcontent()
		{       
			if(document.frmbuy.txtbuycount.value.length==0 ||document.frmbuy.txtaddress.value.length==0
			||document.frmbuy.txtsendFin.value.length==0 || document.frmbuy.txtprice.value.length==0)
				{
					alert("����д������Ϣ!");
					return false;
				}
			else{
					var re=/^[0-9]*[0-9]$/;
					if(!re.test(document.frmbuy.txtbuycount.value))
					{
					alert("������������Ϊ����������� ����");
					return false;	
					}					
				    else
				    {	
				    	if((document.frmbuy.txtbuycount.value)<=0 ||(document.frmbuy.txtprice.value)<=0)
				    		{
					    		alert("������������۸���������!!");
					    		return false;
				    		}
				    	else
					    	{
						    	if(isNaN(document.frmbuy.txtprice.value))
								{
									alert("����۸��ʽ����!!");
									return false;
								}
						    	else
						    	{
								return true;
								}
							}
					}
				}	
		}
		</SCRIPT>
	</head>
	<body>
		
		<jsp:include flush="true" page="Header.jsp" />
		<form method="POST" action="/OnLineSaleSystem/servlet/ReBuyGoods" name="frmbuy">
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:180px">
				<TABLE width="40%" align="center" style="background:#dfddff">
					<TBODY>
						<TR>
							<TD colspan="2" align="center" style="font-size:20px">
								����д���¹�����Ϣ:
								<BR>
							</TD>
						</TR>
						<TR>
							<TD width="25%" align="center">
								����۸�:
							</TD>
							<TD width="75%" align="center">
								<INPUT type="text" name="txtprice" size="30">
							</TD>
						</TR>
						<TR>
							<TD width="25%" align="center">
								��������:
							</TD>
							<TD width="75%" align="center">
								<INPUT type="text" name="txtbuycount" size="30">
							</TD>
						</TR>
						<TR>
							<TD width="20%" align="center">
								�ͻ���ַ:
							</TD>
							<TD width="80%" align="center">
								<INPUT type="text" name="txtaddress" size="30">
							</TD>
						</TR>
						<TR>
							<TD width="20%" align="center">
								�ͻ���ʽ:
							</TD>
							<TD width="80%" align="center">
								<INPUT type="text" name="txtsendFin" size="30">
							</TD>
						</TR>
						<TR>
							<TD colspan="2" align="center">
								<input type="submit" value="�ύ����" name="btnsubmit" onclick="return checkcontent();">
								&nbsp;
								<input type="reset" value="������Ϣ" name="btnreset">
								&nbsp;
								<a href="FindGoods.jsp">
									����
								</a>
							</TD>
						</TR>
						<TR>
							<TD colspan="2" align="center" style="color:#3366ff;font-size:20px">
								<BR>
								${sessionScope.buyinfo}
								<c:set var="buyinfo" value="" scope="session"></c:set>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</div>
		</form>
	</body>
</html>
