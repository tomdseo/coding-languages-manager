<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>

<body class="sub-page">
		<a href="/languages/${language.id}/delete">Delete</a>
		<a href="/languages/">Dashboard</a>
	<div>
		<h1>Edit Language</h1>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		    <input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>
		        <form:input path="version" class="form-control"/>
		    </p>
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>