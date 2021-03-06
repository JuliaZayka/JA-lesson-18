<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Lesson-18</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>



	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">Spring MVC</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">All Participants</a></li>
				<li><a href="new">new Participant</a></li>
			</ul>
		</div>
	</nav>


	<div class="container">

		<c:choose>
			<c:when test="${mode == 'PART_VIEW'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>E-mail</th>
							<th>Level</th>
							<th>Pr_Skill</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="participant" items="${part}">
							<tr>
								<td>${book.id}</td>
								<td>${book.name}</td>
								<td>${book.email}</td>
								<td>${book.level}</td>
								<td>${book.primarySkill}</td>
								<td><a href="update?id= ${participant.id}">edit</a></td>
								<td><a href="delete?id= ${participant.id}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>

			<c:when test="${mode == 'PART_EDIT' || mode == 'PART_CREATE'}">
				<form action="save" method="POST">
				
				<input type="hidden" value="${participant.id}" class="form-control" id="id" name="id">
				
					<div class="form-group">
						<label for="Name">Name:</label> <input type="text"
							class="form-control" id="name" name="name"
							value="${participant.name}">
					</div>


					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" name="email"
							value="${participant.email}">
					</div>
					
					<div class="form-group">
						<label for="level">Level:</label> <input type="text"
							class="form-control" id="level" name="level"
							value="${participant.level}">
					</div>
					
					<div class="form-group">
						<label for="primarySkill">primarySkill:</label> <input type="text"
							class="form-control" id="primarySkill" name="primarySkill"
							value="${participant.primarySkill}">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>

		</c:choose>
	</div>
</body>
</html>