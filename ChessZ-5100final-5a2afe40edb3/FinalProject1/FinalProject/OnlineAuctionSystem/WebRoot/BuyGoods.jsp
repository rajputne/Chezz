<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			商品购买
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
					alert("请填写完整信息!");
					return false;
				}
			else{
					var re=/^[0-9]*[0-9]$/;
					if(!re.test(document.frmbuy.txtbuycount.value))
					{
					alert("购买数量必须为大于零的整数 ！！");
					return false;	
					}					
				    else
				    {	
				    	if((document.frmbuy.txtbuycount.value)<=0 ||(document.frmbuy.txtprice.value)<=0)
				    		{
					    		alert("购买数量，或价格必须大于零!!");
					    		return false;
				    		}
				    	else
					    	{
						    	if(isNaN(document.frmbuy.txtprice.value))
								{
									alert("购买价格格式不对!!");
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
								请填写以下购买信息:
								<BR>
							</TD>
						</TR>
						<TR>
							<TD width="25%" align="center">
								购买价格:
							</TD>
							<TD width="75%" align="center">
								<INPUT type="text" name="txtprice" size="30">
							</TD>
						</TR>
						<TR>
							<TD width="25%" align="center">
								购买数量:
							</TD>
							<TD width="75%" align="center">
								<INPUT type="text" name="txtbuycount" size="30">
							</TD>
						</TR>
						<TR>
							<TD width="20%" align="center">
								送货地址:
							</TD>
							<TD width="80%" align="center">
								<INPUT type="text" name="txtaddress" size="30">
							</TD>
						</TR>
						<TR>
							<TD width="20%" align="center">
								送货方式:
							</TD>
							<TD width="80%" align="center">
								<INPUT type="text" name="txtsendFin" size="30">
							</TD>
						</TR>
						<TR>
							<TD colspan="2" align="center">
								<input type="submit" value="提交购买" name="btnsubmit" onclick="return checkcontent();">
								&nbsp;
								<input type="reset" value="重填信息" name="btnreset">
								&nbsp;
								<a href="FindGoods.jsp">
									返回
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
