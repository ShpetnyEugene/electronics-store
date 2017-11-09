<#import "layout.ftl" as u>

<@u.page title="Products">

<div class="container">


    <div class="row" style="margin-bottom: 20px;">
        <div class="col-md-6">
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" id="Phone" onclick="page(this)" class="btn btn-default">Phones</button>
                <button type="button" id="Laptops" onclick="page(this)" class="btn btn-default">Laptops</button>
                <button type="button" id="Tablets" onclick="page(this)" class="btn btn-default">Tablets</button>
                <button type="button" id="TVs" onclick="page(this)" class="btn btn-default">TVS</button>
            </div>
        </div>


        <div class="col-md-6">
            <label>Sort by:</label>
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" id="name" onclick="sorting(this)" class="btn btn-default">Name</button>
                <button type="button" id="price" onclick="sorting(this)" class="btn btn-default">Price</button>
                <button type="button" id="rating" onclick="sorting(this)" class="btn btn-default">Rating</button>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4">
            <h1 class="my-4">Filter</h1>
        </div>
        <div class="col-md-8"></div>
    </div>


    <div class="row">

        <div class="col-md-4">
            <div class="list-group" id="features-div">

            </div>
            <button class="btn btn-default" onclick="findProduct()">Apply Filter</button>
        </div>

        <div class="col-md-8">
            <div class="container-fluid">
                <div id="products-container" class="row">

                </div>
            </div>
        </div>

    </div>

    <script>

        var type = 'Phone';

        $.fn.raty.defaults.path = '/resources/assets/raty/images';

        function buy(obj) {
            sessionStorage.setItem(obj.id, obj.id);
            var formData = {};
            formData['id'] = obj.id;
            $('#cart').empty();
            $('<span class="badge">Cart ' + sessionStorage.length + '</span>').appendTo("#cart");
            var myURL = '${backendUrl}/users/cart';
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

        $.getJSON("${backendUrl}/features/all", function (features) {
            $.each(features, function (i, f) {
                var elementFeatures = "<h4>" + i + "</h4>";
                for (var per = 0; per < f.length; per++) {

                    elementFeatures = elementFeatures + "<div class=checkbox><label><input class=checkbox id=" + i + " type=checkbox name=" + f[per].value + " value=" + f[per].value + ">" + f[per].value + "</label></div>";
                }
                $(elementFeatures).appendTo("#features-div");
            });

        });

        function findProduct() {
            var checkboxes = document.getElementsByClassName('checkbox');
            var myURL = '${backendUrl}/features/all?features=';
            var count = 0;
            for (var index = 0; index < checkboxes.length; index++) {
                if (checkboxes[index].checked) {
                    myURL = myURL + checkboxes[index].id + '=' + checkboxes[index].value + ",";
                    count = 1;
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
                                    + "<button class='btn btn-default' id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                    + "</div>" + "</div>" + "</div>";

                            $(element).appendTo("#products-container");

                            $('#stars' + f.id).raty({
                                score: f.rating,
                                click: function (score, event) {
                                    var myURL = '${backendUrl}/rating';
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

        $.getJSON("${backendUrl}/products?type=Phone", function (data) {
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
                                + "<button class='btn btn-default' id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                + "</div>" + "</div>" + "</div>";

                        $(element).appendTo("#products-container");

                        $('#stars' + f.id).raty({
                            score: f.rating,
                            click: function (score, event) {
                                var myURL = '${backendUrl}/rating';
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


        function sorting(dataSort) {
            $("#products-container").empty();
            $.getJSON("${backendUrl}/sorting?type=" + type + "&sort=" + dataSort.id, function (data) {
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
                                    + "<button class='btn btn-default' id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                    + "</div>" + "</div>" + "</div>";

                            $(element).appendTo("#products-container");

                            $('#stars' + f.id).raty({
                                score: f.rating,
                                click: function (score, event) {
                                    var myURL = '${backendUrl}/rating';
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

        function page(obj) {
            $("#products-container").empty();
            type = obj.id;
            $.getJSON("${backendUrl}/products?type=" + obj.id, function (data) {
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
                                    + "<button class='btn btn-default' id=" + f.id + " type=" + "button" + " onclick=" + "buy(this)" + "> Add to Cart" + "</button>"
                                    + "</div>" + "</div>" + "</div>";

                            $(element).appendTo("#products-container");

                            $('#stars' + f.id).raty({
                                score: f.rating,
                                click: function (score, event) {
                                    var myURL = '${backendUrl}/rating';
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