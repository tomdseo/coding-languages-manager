<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>

<body class="sub-page">
	<div class="mx-auto d-inline-block">
		<a href="/dashboard">Dashboard</a>
		<h1 class="mt-3"><c:out value="${language.name}"/></h1>
		<p>Description: <c:out value="${language.creator}"/></p>
		<p class="mb-5">Language: <c:out value="${language.version}"/></p>
		<a href="/languages/${language.id}/edit">Edit</a>
		<a href="/languages/${language.id}/delete">Delete</a>
	</div>
</body>