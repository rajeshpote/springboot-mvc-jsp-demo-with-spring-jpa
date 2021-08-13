<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>

<head>
    <title>Customer Registration Form</title>
     <style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
 
<body>
    <h2><spring:message code="lbl.page" text="Customer Registration" /></h2>
    <br/>
    <form:form method="post" modelAttribute="customer">
    <%-- <form:errors path="*" cssClass="error" /> --%>
        <table>
           <tr>
                <td><spring:message code="lbl.title" text="Title" /></td>
                <td><form:input path="title" /></td>
                <td><form:errors path="title" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.firstName" text="First Name" /></td>
                <td><form:input path="firstName" /></td>
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.lastName" text="Last Name" /></td>
                <td><form:input path="lastName" /></td>
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.email" text="Email Id" /></td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.addressLine1" text="Address Line 1" /></td>
                <td><form:input path="addressLine1" /></td>
                <td><form:errors path="addressLine1" cssClass="error" /></td>
            </tr>
             <tr>
                <td><spring:message code="lbl.addressLine2" text="Address Line 2" /></td>
                <td><form:input path="addressLine2" /></td>
            </tr>
             <tr>
                <td><spring:message code="lbl.city" text="City" /></td>
                <td><form:input path="city" /></td>
            </tr>
             <tr>
                <td><spring:message code="lbl.postcode" text="PostCode" /></td>
                <td><form:input path="postcode" /></td>
                <td><form:errors path="postcode" cssClass="error" /></td>
            </tr>
             <tr>
                <td><spring:message code="lbl.telephoneNumber" text="Telephone Number" /></td>
                <td><form:input path="telephoneNumber" /></td>

            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Register"/></td>

            </tr>


        </table>
        <td><form:errors path="status" cssClass="error" /></td>
    </form:form>
</body>
</html>