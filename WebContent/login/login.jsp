<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>

	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Login</h1>

		<form action="<%=request.getContextPath()%>/login" method="post">
			<div class="form-group">
				<label>User Name</label> <input type="text" id="username"
					placeholder="User Name" name="username">
			</div>
			<div class="form-group">
				<label>Password</label> <input type="text" id="password"
					placeholder="password" name="password">
			</div>
			<button class="btn btn-primary" type="submit">Submit</button>
		</form>
	</div>


	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>