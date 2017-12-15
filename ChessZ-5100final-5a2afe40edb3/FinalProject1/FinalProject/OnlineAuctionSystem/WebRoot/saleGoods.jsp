<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>
			商品拍卖
		</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<script language="javascript" type="text/javascript">
		 function checkall()
		 { 	
			if(document.frmSale.txtgoodsname.value.length==0 ||document.frmSale.txtbeginPrice.value.length==0
			||document.frmSale.txtcount.value.length==0)
			{
				alert("请填写完整的商品信息!!");
				return false;
			}
			else{
				if(isNaN(document.frmSale.txtbeginPrice.value))
				{
					alert("起始价格格式不对!!");
					return false;
				}
				else{
					var re=/^[0-9]*[0-9]$/;
					if(!re.test(document.frmSale.txtcount.value))
					{
					alert("商品数量必须为整数 ！！");
					return false;					
					}
					else{
						return true;					
					}
				}
			}
		 }
	</script>
	<body>
		<jsp:include flush="true" page="Header.jsp" />
		<form method="POST" action="/OnLineSaleSystem/servlet/ReSaleGoods" name="frmSale">
			<div style="position: absolute; width: 98%; height: 204px; z-index: 1; left:22px; top:180px">
				<TABLE width="45%" align="center" border="0" style="background:#dfddff">
					<TBODY>
						<TR>
							<TD colspan="2" align="center" style="color:#ddabcc;font-size:20px">
								商品拍卖信息
							</TD>
						</TR>
						<TR>
							<TD width="20%">
								商品名称:
							</TD>
							<TD width="80%" align="center">
								<INPUT type="text" name="txtgoodsname" size="40">
							</TD>
						</TR>
						<tr>
							<td>
								商品描述:
							</td>
							<td align=center>
								<textarea name="txtmiaoshu" cols="39" rows="3"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								起始价格:
							</td>
							<td align=center>
								<input type=text name="txtbeginPrice" size="40" />
							</td>
						</tr>
						<tr>
							<td>
								商品图片:
							</td>
							<td align=center>
								<input type="file" name="txtPath" size="30" onkeydown="return false">
							</td>
						</tr>
						<tr>
							<td>
								商品数量:
							</td>
							<td align=center>
								<input type=text name="txtcount" size="40" />
							</td>
						</tr>
						<tr>
							<td align=center colspan="2">
								<input type=submit name="btnok" value="提交商品信息" onclick="return checkall();">
								<input type=reset name="btnrest" value="重填商品信息">
							</td>
						</tr>
						<TR>
							<TD align="center" colspan="2">
								<A href="/OnLineSaleSystem/servlet/ReAppselect?selectname=paimai">查看我所有拍卖过的商品</A>
								&nbsp;&nbsp;
								<A href="/OnLineSaleSystem/servlet/ReSuccGoods">查看拍卖成功的商品</A>
							</TD>
						</TR>
						<TR>
							<TD colspan="2" align="center" style="font-size:30px;color:#ffaadd">
								${sessionScope.SaleInfo}
								<c:set scope="session" value="" var="SaleInfo" />
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</div>
		</form>
	</body>
</html>
