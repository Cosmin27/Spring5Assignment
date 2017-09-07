function loadMessages() {
	sendMessage();
	console.log("testing here");
	console.log(logged);
	if (logged) {

		var urlString = "http://localhost:8080/assignment5spring/messages/";
		urlString += usernameString;

		$.ajax({
					url : urlString,
					dataType : 'json'
				})
				.then(
						function(data) {

							for (var index = 0; index < data.messages.length; index++) {
								$('#messages')
										.append(
												"<p><span class=\"bold_font\">"
														+ data.messages[index].messageAuthor.username
														+ ":</span> "
														+ data.messages[index].messageText
														+ "</p>");
							}
						});
	}
};

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
				$('#messages').append("<p><span class=\"bold_font\">" + data.messageAuthor.username + ":</span> " + data.messageText + "</p>");
			},
			error: function(e) {
				console.log(e);
			}
		});
	});
}