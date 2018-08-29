<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  import="model.PersonInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your information</title>
</head>
<body>
	<%
		PersonInfo p = (PersonInfo) session.getAttribute("person");
	%>
	<div class="container mt-4">

		<h3 class="text-center">Email found in the database with
			following values</h3>
		<div class="row mt-4">
			<div class="col-4"></div>
			<div class="col-4">
				<table class="table">
					<tr>
						<th class="text-right">Name:</th>
						<td><%= p.getName() %></td>
					</tr>
					<tr>
						<th class="text-right">Email:</th>
						<td>
							<%= p.getEmail() %>
						</td>
					</tr>
					<tr>
						<th class="text-right">Phone</th>
						<td>
							<%= p.getPhone() %>
						</td>
					</tr>
					<tr>
						<th class="text-right">Password</th>
						<td>
							<%= p.getPassword() %>
						</td>
					</tr>
					<tr>
						<th class="text-right">Gender:</th>
						<td>
							<%= p.getGender() %>
						</td>
					</tr>
				</table>

			</div>
		</div>
	</div>
</body>
</html>