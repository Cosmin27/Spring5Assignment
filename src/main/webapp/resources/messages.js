function loadMessages() {
	sendMessage();
	if (logged) {
		var urlString = "http://localhost:8080/assignment5spring/messages/";
		urlString += userID;
		$('#messages').append("<p><span class = \"bold_font\"> Loading messages... </span></p>");
		$.ajax({
					url : urlString,
					dataType : 'json',
					success: function(data) {
						$('#messages').empty();
						for (var index = 0; index < data.messages.length; index++) {
							$('#messages')
									.append(
											"<p><span class=\"bold_font\">"
													+ data.messages[index].messageAuthor.user_name
													+ ":</span> "
													+ data.messages[index].messageText
													+ "</p>");
						}
					},
					error: function(e) {
						console.log(e);
					}
				});
				
	}
}

function sendMessage() {
	$("#messageText").keypress(function(event) {
		if(event.which == 13) {
			jQuery('#submitMessage').focus().click();
			return false;
		}
	});
	$("#submitMessage").on('click', function() {
		$.ajax({
			url : "http://localhost:8080/assignment5spring/postMessage",
			type : "POST",
			dataType:'json',
			contentType: 'application/json',
			data : JSON.stringify({"messageAuthor": null, "messageText": $("#messageText").val()}),
			success : function(data) {
				$("#messageText").val("");
				$('#messages').append("<p><span class=\"bold_font\">" + data.messageAuthor.user_name + ":</span> " + data.messageText + "</p>");
			},
			error: function(e) {
				console.log(e);
			}
		});
	});
}