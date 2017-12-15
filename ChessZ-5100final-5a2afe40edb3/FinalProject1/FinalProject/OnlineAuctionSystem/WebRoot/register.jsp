<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>
			用户注册
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
<SCRIPT language="javascript" type="text/javascript" >
function checkName()
{       
		if(document.frmre.txtusername.value.length==0){
			document.getElementById("0").innerText="用户名不能为空";
			document.getElementById("0").style.display="block";
			document.getElementById("0").style.color="#FF0000";
			return false;
		}
	    else
	    {	
		document.getElementById("0").style.display="none";	
			return true;
		}	
};
function checkPostBoy(){
	if(document.frmre.txtPostBoy.value.length==0)
	 {
	 document.getElementById("6").innerText="必须填写邮政编码";
	 document.getElementById("6").style.display="block";
	 document.getElementById("6").style.color="#FF0000";
	 return false;
	 }	
	else{
	  document.getElementById("6").style.display="none";	 
	  return true;
	  } 
}
function checkpwd()
	{	
	 if(document.frmre.txtpwd.value.length==0)
	 {
	 document.getElementById("1").innerText="密码不能为空";
	 document.getElementById("1").style.display="block";
	 document.getElementById("1").style.color="#FF0000";
	 return false;
	 }	
	 else{
	  document.getElementById("1").style.display="none";	 
	  return true;
	  }	 
	 }
	function checkeven()
	{
	 if(document.frmre.txtpwdc.value.length==0)
	 {
	   document.getElementById("1").innerText="重复密码不能为空";
	    document.getElementById("1").style.display="block";
	    document.getElementById("1").style.color="#FF0000";
	    return false;
	 }	
	 else
	 {	 
				if(document.frmre.txtpwd.value!=document.frmre.txtpwdc.value)
					{
					  document.getElementById("1").innerText="两次密码不一致";
				      document.getElementById("1").style.display="block";
				      document.getElementById("1").style.color="#FF0000";				
					  return false;
					}
				 else {						      
				 	document.getElementById("1").style.display="none";										
				 	return true;
	 				}		 	
						
	 }
}
function checktel()
  {
    if(document.frmre.txttel.value.length==0)
    {
    	document.getElementById("2").innerText="联系电话为必填项";
		 document.getElementById("2").style.display="block";
		 document.getElementById("2").style.color="#FF0000";
		 return false;
    }
    else{
    if(document.frmre.txttel.value.search(/(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{7,8}$)|(^0{0,1}13[0-9]{9}$)/))
    {
	     	 document.getElementById("2").innerText="请填写正确的格式如:028-...或13...或(028)...";
			 document.getElementById("2").style.display="block";
			 document.getElementById("2").style.color="#FF0000";
			 return false;
	}
	else{
	     	document.getElementById("2").style.display="none";
	     	return true;
	     }	     
	 }  
  }
 
 function checkemail()
 {
   if(document.frmre.txtemail.value.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)   !=   -1)
   {
  	document.getElementById("3").style.display="none";
  	return true;
   }
   else
   {
     document.getElementById("3").innerText="电子邮件格式不正确";
	document.getElementById("3").style.display="block";
	document.getElementById("3").style.color="#FF0000";
	return false;
   }
 }
   function checkaddress()
   {
   		if(document.frmre.txtaddress.value.length==0)
   		{
   			document.getElementById("5").innerText="请填如您的联系地址";
   			document.getElementById("5").style.display="block";
   			document.getElementById("5").style.color="#FF0000";
   			return false;
   		}
   		else
   		{
   			document.getElementById("5").style.display="none";
   			return true;
   		}
   }
    function checktruename(){     	
	if(document.frmre.txttruename.value.length==0){
		document.getElementById("4").innerText="真实名不能为空";
		document.getElementById("4").style.display="block";
		document.getElementById("4").style.color="#FF0000";		
		return false;
	}
		 else{	
		document.getElementById("4").style.display="none";
		return true;	
		}	
}
function checkAll()
{
if(document.frmre.txtusername.value.length==0 ||document.frmre.txtpwd.value.length==0 ||
document.frmre.txtpwdc.value.length==0 ||document.frmre.txttruename.value.length==0 
||document.frmre.txttel.value.length==0||document.frmre.txtaddress.value.length==0 
||document.frmre.txtPostBoy.value.length==0)
{
	alert("请填写完整信息");
		return false;
}
else{
	if(checktruename()==false)
	{
		alert("请填写完整信息");
		return false;
	}
	if(checkaddress()==false)
	{
		alert("请填写完整信息");
		return false;
	}
	if(checkPostBoy()==false)
	{
		alert("请填写邮政编码");
		return false;
	}
	if(checkemail()==false)
	{
		alert("电子邮件格式不正确");
		return false;
	}
	if(checktel()==false)
	{
		alert("联系电话格式不正确");
		return false;
	}
	if(checkeven()==false || checkpwd()==false)
	{
	
		alert("密码信息错误");
		return false;
	}
		if(checkName()==false)
	{
		alert("请填写完整信息");
		return false;
	}
		if(checkpwd()==false || checkeven()==false)
	{
		alert("请填写完整信息");
		return false;
	}
	else
	{
	return true;
	}	
	}
	}
	function checkn()
	{
	if(document.frmre.txtusername.value.length==0)
	{
		alert("请先填写用户名");		
		return false;
	}
	return true;
	}
</SCRIPT>
</head>	
	<body>
		<form method="POST" action="/OnLineSaleSystem/servlet/ReRegister" name="frmre" id="frmre">
			<DIV id="divimage"align="center">
				<div style="position: absolute; width: 450px; height: 34px; z-index: 1; left: 315px; top: 95px" id="layer1">
　					<A href="index.jsp">首    页 | </A>
					<A href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=buyCar">我的购物车 | </A>
					<A href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=userzhanghu">我的帐户 |</A>
					<A href="help.jsp" target="new">帮助中心 |</A>
					<a href="/OnLineSaleSystem/servlet/UserinfoServlet?tranname=liuyan">发表留言</a>
				</div>
				<img border="0" src="Image\23.jpg" width="80%" height="110">
			</DIV>
			<div >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img border="0" src="Image\34.JPG" width="759" height="34">
			</div>
			<table border="0" width="60%" align="center"  style="background:#dfddff">
				<TBODY>		
					<tr>
						<td colspan="2" align="center">
							<input type="radio" value="买者" checked name="radFin" >
							以购买者身份注册&nbsp;
							<input type="radio" name="radFin" value="卖者" >
							以拍卖者身份注册
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">						
								<font color="#FF0000">			
									${sessionScope.Y}
									<c:set var="Y" value="" scope="session"/>
								</font>						
						</td>
					</tr>
					<tr>
						<td width="25%" align="right">
							您的用户名:
						</td>
						<td width="75%" align="center">
							<input type=text size="25" name="txtusername" value="${sessionScope.Name}"  onblur="checkName();">
							<c:set value="" var="Name" scope="session"></c:set>
							<input type="submit" value="检查用户名" name="resubmit" onClick="return checkn();">
						</td>
					</tr>
					<tr>
						<td style="display:none" id="0" colspan="2" align="center">
						</td>
					</tr>
					<tr>
						<td  align="right">
							您的密码:
						</td>
						<td align="center">
							<input type=password size="44" name=txtpwd onblur="checkpwd();">
						</td>
					</tr>
					<tr>
						<td style="display:none" id=1 colspan="2" align="center">
						</td>
					</tr>
					<tr>
						<td align="right">
							请再输一次密码:
						</td>
						<td align="center">
							<input type=password size=44 name=txtpwdc maxlength="16" onblur="checkeven();">
						</td>
					</tr>
					<tr>
						<td  align="right">
							&nbsp; 您的联系电话:
						</td>
						<td align="center">
							<input type=text size="40" name=txttel maxlength="15" onblur="checktel();">
						</td>
					</tr>
					<tr>
						<td style="display:none" id=2 colspan="2" align="center">						
						</td>
					</tr>
					<tr>
						<td align="right">
							您的电子邮件:
						</td>
						<td align="center">
							<input type=text size="40" name=txtemail onblur="checkemail();">
						</td>
					</tr>
					<tr>
						<td style="display:none" id=3 colspan="2" align="center">
						</td>
					</tr>
					<tr>
						<td  align="right">
							您的真实名字:
						</td>
						<td align="center">
							<input type=text size=40 name=txttruename maxlength="8" onblur="checktruename();">
						</td>
					</tr>
					<tr>
						<td style="display:none" id=4 colspan="2" align="center">
						</td>
					</tr>
					<tr>
						<td  align="right">
							&nbsp; 您的联系地址:
						</td>
						<td align="center">
							<input type=text size="40" name=txtaddress onblur="checkaddress();">
						</td>
					</tr>
					<tr>
						<td style="display:none" id=5 colspan="2" align="center">
						</td>
					</tr>
					<tr>
						<td align="right">
							您的邮政编码:
						</td>
						<td align="center">
							<input type=text size=40 name=txtPostBoy maxlength="6" onblur="checkPostBoy();">
						</td>
					</tr>
					<tr>
						<td style="display:none" id=6 colspan="2" align="center">
						</td>
					</tr>
					<tr>
						<td align="right">
							您的密码提示:
						</td>
						<td align="center">
							<input type=text size=40 name=txtPassHint >
						</td>
					</tr>					
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="   提   交   " name="resubmit" onClick="return checkAll();">
						</td>
					</tr>					
				</TBODY>
			</table>
		</form>		
	</body>
</html>
