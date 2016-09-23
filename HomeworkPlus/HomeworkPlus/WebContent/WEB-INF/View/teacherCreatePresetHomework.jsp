<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/Resources/style.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/Resources/side-bar.css" />" type="text/css">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Maths Homework PlusZZZ</title>
</head>
<body>

<%@include file="Main/Templates/topBar.html" %>
<%@include file="Main/Templates/teacherSideBar.html" %>

Please select a topic for your homework and how many questions.

<form:form method="POST" action="/HomeworkPlus/createdHomework" modelAttribute="homeworkWrapper">
             <table>
                <tr>
                    <td><form:label path="questionType">Question Topic</form:label></td>
                    <td><form:select path="questionType">
                    <option value="pythagoras">Pythagoras</option>
                    <option value="quadFormula">Quadratic Formula</option>
                    </form:select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="numberOfQuestions">Number Of Questions</form:label></td>
                    <td><form:select path="numberOfQuestions">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    </form:select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create" /></td>
                </tr>
            </table>
        </form:form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>