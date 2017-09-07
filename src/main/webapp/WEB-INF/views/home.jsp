<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
<link href="/assignment5spring/resources/style.css" rel="stylesheet"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="/assignment5spring/resources/messages.js"></script>
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
					<div class="padding_container">
						<c:choose>
							<c:when test="${sessionScope.logged == true}">

								<div class="padding_container">
									<div id="messages"></div>
									<form action="" method="POST" id="messageForm">
										<table>

											<tr>
												<td><label class="artist_form_label">Message:
												</label></td>
												<td><input size="90" type="text" id="messageText"
													class="vertical_middle" name="messageText"/></td>
												<td>
													<div class="button_holder">
														<input name="submitMessage" type="button"
															id="submitMessage" value="Send Message" class="btn" />
													</div>
												</td>

											</tr>
										</table>
									</form>
								</div>

							</c:when>
							<c:otherwise>
								<p>Log in to be able to see messages.</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="info_footer_wrapper"></div>
	<div class="footer_wrapper">
		<div class="footer">
			<div class="copyright">Spring Session Breakout</div>
		</div>
	</div>
	<script>
		var logged = ${sessionScope.logged};

		if (logged) {
			var usernameString = "${sessionScope.usernameString}";
			loadMessages();
		} else {
			var usernameString = "";
		}
	</script>
</body>
</html>
