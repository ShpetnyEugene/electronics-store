<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="Layout for all pages">
    <meta name="Shpetny Eugene">

    <title>Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/shop-item.css" rel="stylesheet">
    <link href="/resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/assets/easy-autocomplete/easy-autocomplete.css" rel="stylesheet">
    <link href="/resources/assets/easy-autocomplete/easy-autocomplete.themes.css" rel="stylesheet">

    <link href="/resources/assets/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="/resources/assets/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">


    <script src="/resources/assets/jquery/jquery-3.1.1.min.js"></script>
    <script src="/resources/assets/easy-autocomplete/jquery.easy-autocomplete.js"></script>


<#--<!-- IE10 viewport hack for Surface/desktop Windows 8 bug &ndash;&gt;-->
<#--<link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">-->

    <!-- Custom styles for this template -->
<#--<link href="/resources/css/style.css" rel="stylesheet">-->

<#--<!-- Just for debugging purposes. Don't actually copy these 2 lines! &ndash;&gt;-->
<#--<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]&ndash;&gt;-->
<#--<script src="../../assets/js/ie-emulation-modes-warning.js"></script>-->

<#--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries &ndash;&gt;-->
<#--<!--[if lt IE 9]>-->
<#--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>-->
<#--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>-->
<#--<![endif]&ndash;&gt;-->

</head>
<body style="padding: 0">

<h1>Login Form</h1>
<h4 id="message" style="text-align: center"></h4>
<div class="form-inline">
    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3">Email address</label>
        <input type="email" class="form-control" id="login" placeholder="Email" required>
    </div>
    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Password</label>
        <input type="password" class="form-control" id="password1" placeholder="Password" required>
    </div>

    <button onclick="submit()" class="btn btn-default">Login</button>
    <button onclick="clearForm()" class="btn btn-default">Clear form</button>
</div>


<script>
    function submit() {
        var formData = {};
        formData['login'] = document.getElementById("login").value;
        formData['password'] = document.getElementById("password1").value;
        var myURL = 'http://localhost:8097/admin/login';
        $.ajax({
            type: "POST",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType: 'application/json',
            complete: function (data) {
                if(data){
                    window.location.href = "/admin/panel";
                }else {
                    clearForm();
                    $("#message").html("Error user not found")
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(thrownError)
            }
        });
    }


    function clearForm() {
        var inputList = document.getElementsByTagName("input");
        for (i = 0; i < inputList.length; i++) {
            inputList[i].value = "";
        }
        try {
            document.getElementById("result").innerHTML = "";
        } catch (err) {
        }
    }
</script>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/assets/popper/popper.min.js"></script>


<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<#--<script src="../../assets/js/vendor/holder.min.js"></script>-->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<#--<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>-->
</body>
</html>