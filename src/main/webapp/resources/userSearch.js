$(document).ready(function() {
	$("#searchResults").on('click', '.btn-follow-user', function(event) {
		console.log("here follow " + event.currentTarget.id);
		var urlString = "http://localhost:8080/assignment5spring/followUserRest/";
		urlString += event.currentTarget.id;
		$.ajax({
			url: urlString,
			type:'PUT',
			dataType : 'json'
			}).then(function(data) {
				//console.log(data);
				if(data.code == 200) {
					var buttonID = "#" + event.currentTarget.id;
					$(buttonID).val("Unfollow");
					$(buttonID).removeClass("btn-follow-user").addClass("btn-unfollow-user");
				}
			});
	});
	
	$("#searchResults").on('click', '.btn-unfollow-user', function(event) {
		console.log("here unfollow " + event.currentTarget.id);
		var urlString = "http://localhost:8080/assignment5spring/unfollowUserRest/";
		urlString += event.currentTarget.id;
		$.ajax({
			url: urlString,
			type:'PUT',
			dataType : 'json'
			}).then(function(data) {
				//console.log(data);
				if(data.code == 200) {
					var buttonID = "#" + event.currentTarget.id;
					$(buttonID).val("Follow");
					$(buttonID).removeClass("btn-unfollow-user").addClass("btn-follow-user");
				}
			});
	});
	
	$("#userSearch").keydown(function(event) {
		if(event.which == 13) {
			event.preventDefault();
		}
	});
	
	$("#userSearch").keyup(function(event) {
		var urlString = "http://localhost:8080/assignment5spring/search/";
		if($("#userSearch").val().length == 0) {
			$("#searchResults").empty();
			$.ajax({
				url : urlString,
				dataType : 'json'
			}).then(function(data) {
				for(var index = 0; index < data.length; index++) {
					var hasFriend = false;
					var friends = data[index].friendsAsStrings;
					for(var friendIndex = 0; friendIndex < friends.length; friendIndex++) {
						//console.log(friends[friendIndex].username + " " + data[index].username);
						if(friends[friendIndex] == usernameString) {
							hasFriend = true;
						}
					}
					if(hasFriend) {
						$("#searchResults").append("<p><span class=\"bold_font\">" + data[index].username + "</span> <input name=\"addremoveuser\" type=\"button\" id=\"" + data[index].username + "\" value=\"Unfollow\" class=\"btn btn-unfollow-user\" /></p>");
					}
					else {
						$("#searchResults").append("<p><span class=\"bold_font\">" + data[index].username + "</span> <input name=\"addremoveuser\" type=\"button\" id=\"" + data[index].username + "\" value=\"Follow\" class=\"btn btn-follow-user\" /></p>");
					}
				}
			});
			
		}
		else {
			console.log($("#userSearch").val());
			
			urlString += $("#userSearch").val();
			
			$.ajax({
				url : urlString,
				dataType : 'json'
			})
			.then(
					function(data) {
						$("#searchResults").empty();
						if(data.length == 0){
							$("#searchResults").append("<p>Search returned no results.</p>");
						}
						else {
							$("#searchResults").append("<p>Search results:</p>");
							for(var index = 0; index < data.length; index++) {
								var hasFriend = false;
								var friends = data[index].friendsAsStrings;
								for(var friendIndex = 0; friendIndex < friends.length; friendIndex++) {
									//console.log(friends[friendIndex].username + " " + data[index].username);
									if(friends[friendIndex] == usernameString) {
										hasFriend = true;
									}
								}
								if(hasFriend) {
									$("#searchResults").append("<p><span class=\"bold_font\">" + data[index].username + "</span> <input name=\"removeuser\" type=\"button\" id=\"" + data[index].username + "\" value=\"Unfollow\" class=\"btn btn-unfollow-user\" /></p>");
								}
								else {
									$("#searchResults").append("<p><span class=\"bold_font\">" + data[index].username + "</span> <input name=\"adduser\" type=\"button\" id=\"" + data[index].username + "\" value=\"Follow\" class=\"btn btn-follow-user\" /></p>");
								}
							}
						}
					});
		}
	});
	
	
});

function loadInitialList() {
	var urlString = "http://localhost:8080/assignment5spring/search/";
	$("#searchResults").empty();
	$.ajax({
		url : urlString,
		dataType : 'json'
	}).then(function(data) {
		for(var index = 0; index < data.length; index++) {
			var hasFriend = false;
			var friends = data[index].friendsAsStrings;
			for(var friendIndex = 0; friendIndex < friends.length; friendIndex++) {
				if(friends[friendIndex] == usernameString) {
					hasFriend = true;
				}
			}
			if(hasFriend) {
				$("#searchResults").append("<p><span class=\"bold_font\">" + data[index].username + "</span> <input name=\"removeuser\" type=\"button\" id=\"" + data[index].username + "\" value=\"Unfollow\" class=\"btn btn-unfollow-user\" /></p>");
			}
			else {
				$("#searchResults").append("<p><span class=\"bold_font\">" + data[index].username + "</span> <input name=\"adduser\" type=\"button\" id=\"" + data[index].username + "\" value=\"Follow\" class=\"btn btn-follow-user\" /></p>");
			}
		}
	});
}