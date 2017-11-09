<#import "layout.ftl" as u>

<@u.page title="Home">

<div class="container">
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
        <h2 class="display-3">A Warm Welcome!</h2>
        <p class="lead">This is an electronics store with a large selection of goods. To work with the site, select a
            category.</p>
        <a href="/products" class="btn btn-primary btn-lg">Go to catalog !</a>
    </header>


    <div class="container-fluid">
        <div id="products-container" class="row">

        </div>
    </div>
</div>


<script>

    $.getJSON("http://localhost:8090/home", function (data) {

                $("#products-container").empty();
                $.fn.raty.defaults.path = '/resources/assets/raty/images';
                $.each(data, function (i, f) {
                    var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                            "<div  class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.id + ">" +
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
    function buy(obj) {
        sessionStorage.setItem(obj.id, obj.id);
        var formData = {};
        $('#cart').empty();
        $('<span class="badge">Cart ' + sessionStorage.length + '</span>').appendTo("#cart");
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

    function getDetails(obj) {
        var formData = {};
        formData['name'] = obj.id;
        var myURL = 'http://localhost:8090/products';
        $.ajax({
            type: "POST",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType: 'application/json',
            complete: function (data) {
                window.location.href = "/products";
            }
        });
    }
</script>

</@u.page>