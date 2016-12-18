
function show() {
	if (document.getElementById('benefits').style.display == 'none') {
		document.getElementById('benefits').style.display = 'block';
	}
	return false;
}
function hide() {
	if (document.getElementById('benefits').style.display == 'block') {
		document.getElementById('benefits').style.display = 'none';
	}
	return false;
}

$(document).ready(function() {
	$(document).on("click","#logins",function(key) {
		var user = $('#Names').val();
		var pass = $('#pwd').val();

		if (user == "") {
			alert("Please Enter username ");
			$("#Names").focus().css("outline-color", "#ff0000");
		}
		if (pass == "") {
			alert("Please Enter password");
			$("#pwd").focus().css("outline-color", "ff0000");
			return;
		} 
		var url = "/Library/lib?operation=login&Names="
				+ user + "&pwd=" + pass;
		$.ajax({
			url : url,
			type : 'POST'
		}).done(function(result) {
			var resp = JSON.parse(result);
			if (resp.status == 1) {
				document.cookie = "Name=" + user;
				window.location.href="index.html";
		
			} else {
				//result = JSON.parse(result);
				if (resp.status == "error") {
					alert("Incorrect username /password");
				}
			}

		}).fail(function(result) {
			console.log(result);
		});

	});
	$(document).on("keyup","#Names",function(key){
        var td = $(this).parent();
        var tr = td.parent();
        if (key.which == 13) {
            tr.next().children().children("#pwd").focus();
        }
    })
     $(document).on("keyup","#pwd",function(key){
        var td = $(this).parent();
        var tr = td.parent();
        if (key.which == 13) {
            tr.next().children().children("#logins").focus();
        }
        if(key.which == 38){
            tr.prev().children().children("#Names").focus();
        }
    })
    $('#logins').keypress(function(event){
    var keycode = (event.keyCode ? event.keyCode : event.which);
    if(keycode == '13'){
      //  alert('You pressed a "enter" key in textbox');  
    }
});
});