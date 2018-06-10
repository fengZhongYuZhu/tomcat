<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎${userName }回来！！！
	<hr>
	<h4>您已经购买的英雄有：</h4>
	<table width="200px">
		<tr height="30px">
			<td width="100px">名称</td>
			<td width="100px">操作</td>
		</tr>
		<c:forEach var="yingXiong" items="${yiMaiList }">
			<tr height="30px">
				<td width="100px"><c:out value="${yingXiong.p_name }"/></td>
				<td width="100px"><a href="<%=path%>/yingXiong?state=tui&p_id=<c:out value="${yingXiong.p_id }"/>">退货</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<hr>
	<h4>您还可以购买的英雄有：</h4>
	<table width="200px">
		<tr height="30px">
			<td width="100px">名称</td>
			<td width="100px">操作</td>
		</tr>
		<c:forEach var="yingXiong" items="${weiMaiList }">
			<tr height="30px">
				<td width="100px"><c:out value="${yingXiong.p_name }"/></td>
				<td width="100px"><a href="<%=path%>/yingXiong?state=mai&p_id=<c:out value="${yingXiong.p_id }"/>">购买</a></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
</body>
</html>