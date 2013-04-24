<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Hello, can I help you?</title>
</head>
<body>

	<c:choose>
		<c:when
			test="${not empty sessionScope.goodegg && sessionScope.goodegg eq 'yes'}">
			<p>Lovely to see you again sir!</p>
		</c:when>
		<c:otherwise>
			<p>Who's there? Bob, is that you?</p>

			<div id="passphraseForm">
				<form action="<c:url value="/checkPassPhrase" />" method="post">
					<div id="passphraseChallenge">What is the secret phrase?</div>
					<p>
						<input type="text" name="passphrase" />
					</p>
					<p>
						<input id="submit" type="submit" value="whisper passphrase" />
					</p>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>