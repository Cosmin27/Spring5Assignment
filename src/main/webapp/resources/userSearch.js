$(document).ready(function() {
	$("#searchResults").on('click', '.btn-follow-user', function(event) {
		var urlString = "http://localhost:8080/assignment5spring/followUserRest/";
		urlString += event.currentTarget.id;
		$.ajax({
			url: urlString,
			type:'PUT',
			dataType : 'json',
			success : function(data) {
				if(data.code == 200) {
					var buttonID = "#" + event.currentTarget.id;
					$(buttonID).val("Unfollow");
					$(buttonID).removeClass("btn-follow-user").addClass("btn-unfollow-user");
				}
			},
			error: function(e) {
				console.log(e);
			}
		});
	});
	
	$("#searchResults").on('click', '.btn-unfollow-user', function(event) {
		var urlString = "http://localhost:8080/assignment5spring/unfollowUserRest/";
		urlString += event.currentTarget.id;
		$.ajax({
			url: urlString,
			type:'PUT',
			dataType : 'json',
			success : function(data) {
				if(data.code == 200) {
					var buttonID = "#" + event.currentTarget.id;
					$(buttonID).val("Follow");
					$(buttonID).removeClass("btn-unfollow-user").addClass("btn-follow-user");
				}
			},
			error: function(e) {
				console.log(e);
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
				dataType : 'json',
				success : function(data) {
					printResults(data);
				},
				error: function(e) {
					console.log(e);
				}
			});
		}
		else {
			urlString += $("#userSearch").val();
			$.ajax({
				url : urlString,
				dataType : 'json',
				success: function(data) {
					$("#searchResults").empty();
					console.log(data);
					if(data == null){
						$("#searchResults").append("<p>Search returned no results.</p>");
					}
					else {
						$("#searchResults").append("<p>Search results:</p>");
						printResults(data);
					}
				},
				error: function(e) {
					console.log(e);
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
		dataType : 'json',
		success : function(data) {
			printResults(data);
		},
		error: function(e) {
			console.log(e);
		}
	});
}

function printResults(data) {
	for(var element in data) {
		if(data[element]) {
			$("#searchResults").append("<p><span class=\"bold_font\">" + element + "</span> <input name=\"removeuser\" type=\"button\" id=\"" + element + "\" value=\"Unfollow\" class=\"btn btn-unfollow-user\" /></p>");
		}
		else {
			$("#searchResults").append("<p><span class=\"bold_font\">" + element + "</span> <input name=\"adduser\" type=\"button\" id=\"" + element + "\" value=\"Follow\" class=\"btn btn-follow-user\" /></p>");
		}
	}
}