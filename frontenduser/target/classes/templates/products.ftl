<#import "layout.ftl" as u>

<@u.page title="Products">


<div class="container">

    <div class="row">


        <div class="col-md-6 col-md-offset-3" style="margin-bottom: 50px">
            <ul class="nav nav-pills">
                <li><a class="btn btn-primary" id="Phone" onclick="page(this)">Phones</a></li>
                <li><a class="btn btn-primary" id="Laptops" onclick="page(this)">Laptops</a></li>
                <li><a class="btn btn-primary" id="Tablets" onclick="page(this)">Tablets</a></li>
                <li><a class="btn btn-primary" id="TVs" onclick="page(this)">TVS</a></li>
            </ul>
        </div>

        <div class="col-md-4">
            <h1 class="my-4">Filter</h1>
            <div class="list-group" id="features-div">

            </div>
            <button onclick="findProduct()">Find Product</button>
        </div>

        <div class="container-fluid">
            <div id="products-container" class="row">

            </div>
        </div>
        <script>

            $.fn.raty.defaults.path = '/resources/assets/raty/images';

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

            $.getJSON("http://localhost:8090/features/all", function (features) {
                $.each(features, function (i, f) {
                    var elementFeatures = "<div class=row><div class=col-md-1><h4>" + i + "</h4>";
                    for (var per = 0; per < f.length; per++) {
                        elementFeatures = elementFeatures + "<input class=checkbox id=" + i + " type=checkbox name=" + f[per].value + " value=" + f[per].value + ">" + f[per].value + "</div></div>";
                    }
                    $(elementFeatures).appendTo("#features-div");
                });

            });

            function findProduct() {
                var checkboxes = document.getElementsByClassName('checkbox');
                var myURL = 'http://localhost:8090/features/all?features=';
                var count =0;
                for (var index = 0; index < checkboxes.length; index++) {
                    if (checkboxes[index].checked) {
                        myURL = myURL + checkboxes[index].id + '=' + checkboxes[index].value + ",";
                        count  = 1;
                    }
                }
                if (count >= 1) {
                    $.ajax({
                        type: "POST",
                        url: myURL,
                        complete: function (data) {
                            $("#products-container").empty();
                            $.each(data.responseJSON, function (i, f) {
                                var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                                        "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.id + ">" +
                                        "<img class=" + "image-product" + " id=" + f.id + " src=" + f.images + " alt=" + ">" + "</a>"
                                        + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                                        + "<h4 class=" + "card-title" + ">" +
                                        "<a href=" + "http://localhost:8091/products/" + f.id
                                        + " name=" + f.name + " id=" + f.id + ">" + f.name + "</a>"
                                        + "<div id=stars" + f.id + "> </div>"
                                        + "</h4>" + "<h5>" + f.price + "$</h5>" + "<p class=" + "card-text" + ">" + f.description
                                        + "</p>" + "</div>"
                                        + "<div class=" + "card-footer" + ">"
                                        + "<button id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                        + "</div>" + "</div>" + "</div>";

                                $(element).appendTo("#products-container");

                                $('#stars' + f.id).raty({
                                    score: f.rating,
                                    click: function (score, event) {
                                        var myURL = 'http://localhost:8090/rating';
                                        var dataRating = {};
                                        dataRating['rating'] = score;
                                        dataRating['id'] = f.id;
                                        $.ajax({
                                            type: "POST",
                                            data: JSON.stringify(dataRating),
                                            url: myURL,
                                            dataType: 'json',
                                            contentType: 'application/json',
                                            complete: function (res) {
                                                $('stars').raty({
                                                    score: res.responseJSON
                                                })
                                            },
                                            error: function (xhr, ajaxOptions, thrownError) {
                                                console.log(thrownError)
                                            }
                                        });
                                    }
                                });


                            });
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            console.log(thrownError)
                        }
                    });
                }
            }

            $.getJSON("http://localhost:8090/products?type=Phone", function (data) {
                        $("#products-container").empty();
                        $.each(data, function (i, f) {
                            var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                                    "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.id + ">" +
                                    "<img class=" + "image-product" + " id=" + f.id + " src=" + f.images + " alt=" + ">" + "</a>"
                                    + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                                    + "<h4 class=" + "card-title" + ">" +
                                    "<a href=" + "http://localhost:8091/products/" + f.id
                                    + " name=" + f.name + " id=" + f.id + ">" + f.name + "</a>"
                                    + "<div id=stars" + f.id + "> </div>"
                                    + "</h4>" + "<h5>" + f.price + "$</h5>" + "<p class=" + "card-text" + ">" + f.description
                                    + "</p>" + "</div>"
                                    + "<div class=" + "card-footer" + ">"
                                    + "<button id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                    + "</div>" + "</div>" + "</div>";

                            $(element).appendTo("#products-container");

                            $('#stars' + f.id).raty({
                                score: f.rating,
                                click: function (score, event) {
                                    var myURL = 'http://localhost:8090/rating';
                                    var dataRating = {};
                                    dataRating['rating'] = score;
                                    dataRating['id'] = f.id;
                                    $.ajax({
                                        type: "POST",
                                        data: JSON.stringify(dataRating),
                                        url: myURL,
                                        dataType: 'json',
                                        contentType: 'application/json',
                                        complete: function (res) {
                                            $('stars').raty({
                                                score: res.responseJSON
                                            })
                                        },
                                        error: function (xhr, ajaxOptions, thrownError) {
                                            console.log(thrownError)
                                        }
                                    });
                                }
                            });



                        });
                    }
            );

            function page(obj) {
                $("#products-container").empty();
                $.getJSON("http://localhost:8090/products?type=" + obj.id, function (data) {
                            $.each(data, function (i, f) {
                                var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                                        "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.id + ">" +
                                        "<img class=" + "image-product" + " id=" + f.id + " src=" + f.images + " alt=" + ">" + "</a>"
                                        + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                                        + "<h4 class=" + "card-title" + ">" +
                                        "<a href=" + "http://localhost:8091/products/" + f.id
                                        + " name=" + f.name + " id=" + f.id + ">" + f.name + "</a>"
                                        + "<div id=stars" + f.id + "> </div>"
                                        + "</h4>" + "<h5>" + f.price + "$</h5>" + "<p class=" + "card-text" + ">" + f.description
                                        + "</p>" + "</div>"
                                        + "<div class=" + "card-footer" + ">"
                                        + "<button id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                        + "</div>" + "</div>" + "</div>";

                                $(element).appendTo("#products-container");

                                $('#stars' + f.id).raty({
                                    score: f.rating,
                                    click: function (score, event) {
                                        var myURL = 'http://localhost:8090/rating';
                                        var dataRating = {};
                                        dataRating['rating'] = score;
                                        dataRating['id'] = f.id;
                                        $.ajax({
                                            type: "POST",
                                            data: JSON.stringify(dataRating),
                                            url: myURL,
                                            dataType: 'json',
                                            contentType: 'application/json',
                                            complete: function (res) {
                                                $('stars').raty({
                                                    score: res.responseJSON
                                                })
                                            },
                                            error: function (xhr, ajaxOptions, thrownError) {
                                                console.log(thrownError)
                                            }
                                        });
                                    }
                                });
                            });
                        }
                );
            }
        </script>
</@u.page>