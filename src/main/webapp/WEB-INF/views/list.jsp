<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script type="text/javascript">
	function add() {
		var formData = new FormData($("#form")[0]);
		$.ajax({
			processData : false,
			contentType : false,
			url : "publish1",
			data : formData,
			type : "post",
			success : function(msg) {
				if (msg) {
					alert("发布成功");
					location="list";
				} else {
					alert("发布失败,未选择图片");
				}
			}

		})
	}
</script>
</head>
<body>
	<table class="table table-striped">
		<tr>
			<td>编号</td>
			<td>名字</td>
			<td>图片</td>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td><img alt="" src="/pic/${p.picture}" width="50px"
					height="60px"></td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>form</h2>
	<form action="publish" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>名字:</td>
				<td><input name="name" type="text"></td>
			</tr>
			<tr>
				<td>图片:</td>
				<td><input name="file" type="file"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>

	<br>

	<h2>ajax</h2>
	<form id="form">
		<table>
			<tr>
				<td>名字:</td>
				<td><input name="name" type="text"></td>
			</tr>
			<tr>
				<td>图片:</td>
				<td><input name="file" type="file"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="button" onclick="add()">提交</button></td>
			</tr>
		</table>
	</form>
</body>
</html>