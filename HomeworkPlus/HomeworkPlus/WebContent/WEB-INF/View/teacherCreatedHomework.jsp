<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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


Displayed homework 
<span class="printButton"><input type="button" onclick="printDiv('examQuestions')" value="print" /></span><br>

<div id="examQuestions">
<c:forEach items="${questions}" var="question">
<div class="pageBreak">
${question.questionNumber}
<div class="examQuestionBody">

<c:if test="${not empty question.preImageLines}">
	<c:forEach begin="0" end="${fn:length(question.postImageLines) - 1}" var="index">
   
   		<c:out value="${question.preImageLines[index]}"/><br>

	</c:forEach>
</c:if>

<c:if test="${not empty question.encodedQuestionImage}">
	<span class="questionImage"><img src="data:image/png;base64,${question.encodedQuestionImage}"></span>
	${question.notAccurate} <br><br>
</c:if>

<c:if test="${not empty question.centralEquation}">
	<div class="centralEquation"><br>${question.centralEquation}<br><br></div>
</c:if>


<c:if test="${not empty question.postImageLines}">
	<c:forEach begin="0" end="${fn:length(question.postImageLines) - 1}" var="index">
   
   		<c:out value="${question.postImageLines[index]}"/><br>

	</c:forEach>
</c:if>
<br><br><br>

<div class="answerBox">${question.answerBox} <br></div>
</div>
</div>
</c:forEach>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="Resources/js/repeatingForm.js"></script>
</body>
</html>