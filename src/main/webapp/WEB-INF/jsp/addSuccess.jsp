<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration Completed</title>
</head>

<body>
    <h1>Registration Success</h1>
</body>

<c:if test="${not empty lists}">
<hr>
Customer Registration List:
<hr>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>FirstName</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Telephone Number</th>
    </tr>

    <c:forEach items="${lists}" var="cust">
    <tr>
                <td>${cust.id}</td>
                <td>${cust.title}</td>
                <td>${cust.firstName}</td>
                <td>${cust.lastName}</td>
                <td>${cust.email}</td>
                 <td>${cust.telephoneNumber}</td>
     </tr>
</c:forEach>
</c:if>