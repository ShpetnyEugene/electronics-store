<#import "layout.ftl" as u>

<@u.page title="Products">

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-4" id="features-div">
            <h1 class="my-4">Filter</h1>
            <div class="list-group">

            </div>
        </div>
        <script>
            //    a = [
            //
            //        {
            //            "type":"binary",
            //            "name":"test"
            //        },
            //        {
            //            "type":"value",
            //            "name":"Weight"
            //        }
            //
            //
            //    ]
        </script>

        <div class="col-md-6 col-md-offset-3">
            <ul class="nav nav-pills">
                <li><a class="btn btn-primary" id="Phone" onclick="page(this)">Phones</a></li>
                <li><a class="btn btn-primary" id="Laptops" onclick="page(this)">Laptops</a></li>
                <li><a class="btn btn-primary" id="Tablets" onclick="page(this)">Tablets</a></li>
                <li><a class="btn btn-primary" id="TVs" onclick="page(this)">TVS</a></li>
            </ul>
        </div>

        <div class="container-fluid">
            <div id="products-container" class="row">

            </div>
        </div>


        <script>


            function buy(obj) {
                sessionStorage.setItem(obj.id, obj.id);
                var formData = {};
                formData['id'] = obj.id;

                var myURL = 'http://localhost:8090/users/cart';
                $.ajax({
                    type: "POST",
                    data: JSON.stringify(formData),
                    xhrFields: {
                        withCredentials: true
                    },
                    url: myURL,
                    dataType: 'json',
                    contentType: 'application/json',
                    error: function (xhr, ajaxOptions, thrownError) {
                        console.log(thrownError)
                    }
                });
            }

            $.getJSON("http://localhost:8090/products?type=Phone", function (data) {
                        $("#products-container").empty();
                        $.each(data, function (i, f) {
                            var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                                    "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.id + ">" +
                                    "<img class=" + "card-img-top" + " id=" + f.id + " src=" + f.images + " alt=" + ">" + "</a>"
                                    + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                                    + "<h4 class=" + "card-title" + ">" +
                                    "<a href=" + "http://localhost:8091/products/" + f.id
                                    + " name=" + f.name + " id=" + f.id + ">" + f.name + "</a>"
                                    + "</h4>" + "<h5>" + f.price + "$</h5>" + "<p class=" + "card-text" + ">" + f.description
                                    + "</p>" + "</div>"
                                    + "<div class=" + "card-footer" + ">"
                                    + " <select id=" + "example" + ">" +
                                    "<option value=" + "1" + ">" + "1" + "</option>" +
                                    "<option value=" + "2" + ">" + "2" + "</option>" +
                                    "<option value=" + "3" + ">" + "3" + "</option>" +
                                    "<option value=" + "4" + ">" + "4" + "</option>" +
                                    "<option value=" + "5" + ">" + "5" + "</option>" +
                                    "</select>"
                                    + "<button id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                    + "</div>" + "</div>" + "</div>";

                            $(element).appendTo("#products-container");
                        });
                    }
            );

            function page(obj) {
                $("#products-container").empty();
                $.getJSON("http://localhost:8090/products?type=" + obj.id, function (data) {
                            $.each(data, function (i, f) {
                                var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                                        "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.id + ">" +
                                        "<img class=" + "card-img-top" + " id=" + f.id + " src=" + f.images + " alt=" + ">" + "</a>"
                                        + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                                        + "<h4 class=" + "card-title" + ">" +
                                        "<a href=" + "http://localhost:8091/products/" + f.id
                                        + " name=" + f.name + " id=" + f.id + ">" + f.name + "</a>"
                                        + "</h4>" + "<h5>" + f.price + "$</h5>" + "<p class=" + "card-text" + ">" + f.description
                                        + "</p>" + "</div>"
                                        + "<div class=" + "card-footer" + ">"
                                        + " <select id=" + "example" + f.id + ">" +
                                        "<option value=" + "1" + ">" + "1" + "</option>" +
                                        "<option value=" + "2" + ">" + "2" + "</option>" +
                                        "<option value=" + "3" + ">" + "3" + "</option>" +
                                        "<option value=" + "4" + ">" + "4" + "</option>" +
                                        "<option value=" + "5" + ">" + "5" + "</option>" +
                                        "</select>"
                                        + "<button id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                        + "</div>" + "</div>" + "</div>";
                                $(element).appendTo("#products-container");

                            });

                            $.getJSON("http://localhost:8090/features/all", function (features) {
                                $.each(features, function (i, f) {

                                    var elementFeatures = "<p>" + f.name +"</p>"+ "<input type=checkbox name=" + f.name + " value=" + f.value + ">" + f.value + "<p>";
                                    console.log(elementFeatures);
                                    $(elementFeatures).appendTo("#features-div");
                                });

                            });
                        }
                );
            }
        </script>
</@u.page>