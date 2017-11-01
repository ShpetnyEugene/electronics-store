<#import "layout.ftl" as u>

<@u.page title="Product">

<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-lg-9">
            <div class="card mt-4" id="products-container">
                <div id="stars">
                </div>
            </div>
        </div>
    </div>


    <script>
        var element;
        function addCart(data) {
            sessionStorage.setItem(data.id, data.id);
        }
        $.getJSON("http://localhost:8090" + window.location.pathname, function (data) {
            element = "<img class='card-img-top img-fluid' src=" + data.images + " alt=Photo>" +
                    "<div class=card-body>" + "<h3 class=card-title>" + data.name + "</h3>" + "<h4>" + data.price + "$</h4>"
                    + "<p class=card-text>" + data.description + "</p>" + "<select id='example'>" + "<option value=1>" + "1" +
                    "</option>" + "<option value=2>" + "2" + "</option>" + "<option value=3>" + "3" + "</option >"
                    + "<option value = 4 >" + "4" + "</option >" + "<option value = 5>" + "5" + "</option >" + "</select >"
                    + "</div></div>" + "<div class='card card-outline-secondary my-4'>" + "<div class='card-header'> Features :"
                    + "</div>" + "<div class='card-body'>";


            $.getJSON("http://localhost:8090/features?productId=" + data.id, function (features) {
                $.each(features, function (i, f) {
                    element = element + "<p>" + f.name + " : " + f.value + "</p>"
                });
                $('#stars').raty();
                $(element).appendTo("#products-container");
            });
        });
    </script>
</@u.page>