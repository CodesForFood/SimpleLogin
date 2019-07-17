<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Login</title>
</head>
<body>
	<h1>Hello, please login</h1>
	
	<form method="POST" action="/SimpleLogin/login">
		<label for="uName">Username: </label>
		<input id="uName" type="text" name="userName"/>
		<br>
		
		<label for="pWord">Password: </label>
		<input id="pWord" type="password" name="password"/>
		<br>
		<button type="submit">Submit</button> 
	</form>
	
	<h3>${errMsg}</h3>
</body>
</html>