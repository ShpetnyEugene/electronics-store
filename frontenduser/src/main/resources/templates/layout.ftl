<#macro page title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="Layout for all pages">
    <meta name="Shpetny Eugene">

    <title>${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/shop-item.css" rel="stylesheet">
    <link href="/resources/css/fontawesome-stars.css" rel="stylesheet">
    <link href="/resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/assets/easy-autocomplete/easy-autocomplete.css" rel="stylesheet">
    <link href="/resources/assets/easy-autocomplete/easy-autocomplete.themes.css" rel="stylesheet">

    <link href="/resources/assets/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="/resources/assets/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<#--TODO CHECK THIS-->
    <link href="/resources/assets/raty/jquery.raty.css" rel="stylesheet">
    <link href="/resources/assets/raty/labs.css" rel="stylesheet">


    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">

    <script src="/resources/assets/jquery/jquery-3.1.1.min.js"></script>
    <script src="/resources/js/jquery.barrating.min.js"></script>
    <script src="/resources/assets/easy-autocomplete/jquery.easy-autocomplete.js"></script>
<#--TODO CHECK THIS-->
    <script src="/resources/assets/raty/jquery.raty.js"></script>
    <script src="/resources/assets/raty/labs.js"></script>


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

    <title>${title}</title>
</head>
<body style="padding: 0">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home">Home</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/products">Catalog<span class="sr-only">(current)</span></a></li>
                <li><a href="http://localhost:8099/admin/login">Admin<span class="sr-only">(current)</span></a></li>
                <li>
                    <form class="navbar-form ">
                        <input class="form-group form-control" id="template-custom" style="width: 500px"/>
                    </form>
                </li>
            </ul>


            <ul class="nav navbar-nav navbar-right">
                <li><a href="/users/cart"><span class="badge" id="cart">
                </span></a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Action Account <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/users/login">Login</a></li>
                        <li><a href="/users/registration">Registration</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a onclick="logout()">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
    <#nested>
<footer>
    <hr>
    <h3 style="text-align: center">Created by Shpetny Eugene</h3>
</footer>


<script>


    function logout() {
        var myURL = 'http://localhost:8090/users/logout';
        $.ajax({
            type: "GET",
            url: myURL,
            xhrFields: {
                withCredentials: true
            },
            complete: function () {
                window.location.href = "/home";
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(thrownError)
            }
        });
    }

    var options = {
        url: "http://localhost:8090/search",
        getValue: "name",
        list: {
            match: {
                enabled: true
            }
        },
        template: {
            type: "custom", method: function (value, item) {
                console.log(item);
                return "<a href=/products/" + item.id + ">" + "<img style='width:50px;' src=" + item.images + "/> | " + value + " | " + item.description + "  |  " + item.price + "$" + "</a";
            }
        }
    };

    $("#template-custom").easyAutocomplete(options);
    $('<span class="badge">Cart ' + sessionStorage.length + '</span>').appendTo('#cart')

</script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/assets/popper/popper.min.js"></script>
<script src="/resources/js/jquery.barrating.min.js"></script>


<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<#--<script src="../../assets/js/vendor/holder.min.js"></script>-->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<#--<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>-->
</body>
</html>
</#macro>