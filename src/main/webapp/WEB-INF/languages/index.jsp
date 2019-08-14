<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page contentType="text/html; charset=UTF-8" %> <!-IMPORTANT LINE TO DISPLAY EMOJISSSSSS->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>

<body>
	<div class="max-width80 mx-auto mb-5">
		<h1 class="display-4 text-center mb-3">🔥💻 Coding Languages 💻🔥</h1>
		<table class="table">
		    <thead class="thead-dark">
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${languages}" var="language">
		        <tr>
		            <td><c:out value="${language.name}"/></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.version}"/></td>
		            <td><a href="/language/${language.id}/delete">delete</a>    <a href="/language/${language.id}/edit">edit</a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
	<div class="max-width80 mx-auto">
		<p class="lead">Input a Language</p>
		<form:form action="/create_language" method="post" modelAttribute="language">
		    <p>
		        <form:label path="name">Language Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator Name</form:label>
		        <form:errors path="creator"/>
		        <form:input path="creator" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="version">Version Number</form:label>
		        <form:errors path="version"/>
		        <form:input path="version" class="form-control"/>
		    </p>
		    <input type="submit" value="Submit"/>
		</form:form> 
	</div>
</body>