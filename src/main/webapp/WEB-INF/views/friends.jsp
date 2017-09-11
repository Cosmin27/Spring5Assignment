<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<html>
<head>
<title>Friends</title>
<link href="/assignment5spring/resources/style.css" rel="stylesheet"
	type="text/css" />
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="/assignment5spring/resources/userSearch.js"></script>
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
					<div class="search_container">
						<form action="" method="POST" id="messageForm">
										<table>

											<tr>
												<td><label class="artist_form_label">Search for: 
												</label></td>
												<td><input size="90" type="text" id="userSearch"
													class="vertical_middle" name="userSearch"/></td>
												

											</tr>
										</table>
									</form>
						<br>
						<div id="searchResults">
							
						</div>
						<br>
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
	</div>
	<script>
		loadInitialList();
		var logged = ${sessionScope.logged};
		if(logged == true){
			var usernameString = "${sessionScope.usernameString}";
			var userID = "${sessionScope.userID}";
		}
		else {
			var usernameString = "";
		}
	</script>
</body>
</html>
