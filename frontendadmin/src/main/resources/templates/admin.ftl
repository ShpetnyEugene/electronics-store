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

<div class="row">
    <div class="col-md-6 col-md-offset-3">

        <h5 id="message"></h5>

        <h3 style="text-align: center">Change information about product</h3>
        <h4>Select product</h4>

        <select name="id" id="select" multiple class="form-control">

        </select>

        <h4>Please input new information</h4>

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" placeholder="Name">
        </div>

        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="number" class="form-control" id="amount" placeholder="Amount">
        </div>

        <div class="form-group">
            <label for="amount">Descriptions</label>
            <input type="text" class="form-control" id="descriptions" placeholder="Descriptions">
        </div>


        <div class="form-group">
            <label for="amount">Rating</label>
            <input type="number" class="form-control" id="rating" placeholder="Rating">
        </div>

        <center>
            <button onclick="submit()">Change</button>
            <button onclick="deleteProduct()">Delete</button>
            <button onclick="clearForm()">Clear form</button>
        </center>

        <h3 style="text-align: center">Change view home</h3>
        <label class="radio-inline">
            <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 4 Last product
        </label>
        <label class="radio-inline">
            <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 4 Most Popular
        </label>
        <center>
            <button onclick="accept()">Accept</button>
        </center>
        <p>
        <center>
            <button onclick="redirectOnCatalog()">Back to home</button>
        </center>


    </div>
</div>


<script>
    function submit() {
        var formData = {};
        formData['id'] = document.getElementsByName("id");
        formData['name'] = document.getElementById("name");
        formData['amount'] = document.getElementById("amount");
        formData['descriptions'] = document.getElementById("descriptions");
        formData['rating'] = document.getElementById("rating");
        var myURL = '${url}/admin';

        $.ajax({
            type: "POST",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType: 'application/json',
            complete: function (data) {
                if (data) {
                    $("#message").html("Successful !!")
                } else {
                    clearForm();
                    $("#message").html("Check the data")
                }
            }
        });
    }

    function deleteProduct() {
        var formData = {};
        formData['id'] = document.getElementsByName("id");
        var myURL = '${url}/admin';
        $.ajax({
            type: "DELETE",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType: 'application/json',
            complete: function (data) {
                console.log('Delete id : ' + data)
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

    function accept() {

    }

    function redirectOnCatalog() {
        window.location.href = "http://localhost:8091/home"
    }


    $(function () {
        $.getJSON('http://localhost:8097/admin', function (data) {
            $.each(data.product, function (i, f) {
                var element = "<option" + f.id + ">" + f.name + "</option>";
                $(element).appendTo("#select")
            });
        });
    });


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