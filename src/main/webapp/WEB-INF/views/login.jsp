<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<html>
<head>
<title>Login</title>
<link href="/assignment5spring/resources/style.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="header_wrapper">
		<div class="header">
			<div class="page_title">Assignment</div>
			<div class="main_menu">
				
				<c:choose>
					<c:when test="${sessionScope.logged == true}">
						<p><span style="color:white">Logged in as ${sessionScope.usernameString}   |   </span>
						<a href="/assignment5spring/">Home</a>
						<a href="/assignment5spring/friends">Friends</a>
						<a href="/assignment5spring/about">About</a>
						<a href="/assignment5spring/logout">Log out</a></p>
					</c:when>

					<c:otherwise>
						<a href="/assignment5spring/">Home</a>
						<a href="/assignment5spring/about">About</a>
						<a href="/assignment5spring/login">Login</a>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
	</div>
	<div class="info_header_wrapper"></div>

	<div class="content_wrapper">
		<div class="content">
			<div>
				<div class="content-holder">
					<sf:form action="/assignment5spring/login" method="POST"
						modelAttribute="login">
						<input type="hidden" name="_method" value="POST" />
						<input type="hidden" name="usernameHidden" value="${user.username}" />
						<input type="hidden" name="passwordHidden" value="${user.password}" />
						<div class="padding_container">
							<table>
								<tr>
									<td><label for="username" class="artist_form_label">Username:
									</label></td>
									<td><sf:input path="username" size="15" id="username"
											class="vertical_middle" /> <sf:errors path="username"
											cssClass="error" /></td>
								</tr>
								<tr>
									<td><label for="password" class="artist_form_label">Password:
									</label></td>
									<td><sf:input path="password" size="15" id="password"
											type="password" class="vertical_middle" /> <sf:errors
											path="password" cssClass="error" /></td>
								</tr>
							</table>
						</div>
						
						<div>
							<p><span class="bold_font" style="color:red">${error}</span></p>
						</div>

						<div class="button-wrapper">
							<div class="button_holder">
								<input name="tryToLogin" type="submit" value="Log in"
									class="btn" />
								<!-- using the actual application name in the URL -->
								<a href="/assignment3spring/"
									class="btn" class="left_spacing">Cancel/Back</a>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>

		<div class="info_footer_wrapper"></div>
		<div class="footer_wrapper">
			<div class="footer">
				<div class="copyright">Spring Session Breakout</div>
			</div>
		</div>
	</div>
	
	<script>
		var logged = ${sessionScope.logged};
		if(logged == true){
			var usernameString = "${sessionScope.usernameString}";
		}
		else {
			var usernameString = "";
		}
	</script>
</body>
</html>
