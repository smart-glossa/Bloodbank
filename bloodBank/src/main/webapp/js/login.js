$(document).ready(function() {
    $(document).on("click", "#signin", function(key) {
            var name = $("#Name").val();
            var pass = $("#password").val();
            var cpass = $("#cpassword").val();
            if (name === "") {
                alert("Please Enter Name..");
                $("#Name").focus().css("outline-color", "#ff0000");
                return;
            }
            if (pass === "") {
                alert("Please Enter Password..");
                $("#password").focus().css("outline-color", "#ff0000");
                return;
            }
            if (cpass === "") {
                alert("Please Enter ConformPassword");
                $("#cpassword").focus().css("outline-color", "#ff0000");
                return;
            }
            if (cpass !== pass) {

                $("#divCheckPasswordMatch").html("Passwords do not match!").show().fadeOut(3000);
                $("#cpassword").focus().css("outline-color", "red");
                return;
            } else {

                $("#divCheckPasswordMatch").html("Passwords match.").show().fadeOut(3000);
            }
            //added user detail

            var url = "/bloodBank/blood?operation=reg&Name=" + name + "&password=" + pass;
            $.ajax({
                url: url,
                type: 'POST'
            }).done(function(result) {
                result = JSON.parse(result);
                if (result.status == 1) {
                    alert("successfully Added");
                    $('#name').val("");
                    $('#password').val("");
                    $('#cpassword').val("");
                } else {
                    result = JSON.parse(result);
                    if (result.status == 0) {
                        alert("Error occurs");
                    }
                }
            }).fail(function(result) {
                alert("Please Check Details!..")
            });

        })
        /*keyup and keydown*/
    $(document).on("keyup", "#Name", function(key) {
        var td = $(this).parent();
        var tr = td.parent();
        if (key.which == 13) {
            tr.next().children().children("#password").focus();
        }
    })
    $(document).on("keyup", "#password", function(key) {
        var td = $(this).parent();
        var tr = td.parent();
        if (key.which == 13) {
            tr.next().children().children("#cpassword").focus();
        }
        if (key.which == 38) {
            tr.prev().children().children("#Name").focus();
        }
    })
    $(document).on("keyup", "#cpassword", function(key) {
        var td = $(this).parent();
        var tr = td.parent();
        if (key.which == 13) {
            tr.next().children().children("#signin").focus();
        }
        if (key.which == 38) {
            tr.prev().children().children("#password").focus();
        }
    })
    $('#signin').keypress(function(event) {
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if (keycode == '13') {
            //  alert('You pressed a "enter" key in textbox');
        }
    });
    $(document).on("click", "#login", function(key) {
        var names = $('#Names').val();
        var pass = $('#pwd').val();

        if (names == "") {
            alert("Please Enter username ");
            $("#Names").focus().css("outline-color", "#ff0000");
        }
        if (pass == "") {
            alert("Please Enter password");
            $("#pwd").focus().css("outline-color", "ff0000");
            return;
        }
        var url = "/bloodBank/blood?operation=login&Names=" +
            names + "&pass=" + pass;
        $.ajax({
            url: url,
            type: 'POST'
        }).done(function(result) {
            var resp = JSON.parse(result);
            if (resp.status == 1) {
                document.cookie = "user=" + names;
                window.location.href = "blood.html";


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
});
