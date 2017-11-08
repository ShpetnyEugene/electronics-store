<#import "layout.ftl" as u>

<@u.page title="Product">

<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-lg-9">
            <div class="card mt-4" id="products-container">

            </div>
            <div id="stars">
            </div>
        </div>
    </div>


    <script>
        $.fn.raty.defaults.path = '/resources/assets/raty/images';

        var element;
        function addCart(data) {
            sessionStorage.setItem(data.id, data.id);
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
        $.getJSON("http://localhost:8090" + window.location.pathname, function (data) {
            element = "<img style='height: 300px' class='card-img-top img-fluid image-product' src=" + data.images + " alt=Photo>" +
                    "<div class=card-body>" + "<h3 class=card-title>" + data.name + "</h3>" + "<h4>" + data.price + "$</h4>"
                    + "<p class=card-text>" + data.description + "</p>" + "<div id=stars"  + "></div>"
                    + "</div></div>" + "<div class='card card-outline-secondary my-4'>" + "<div class='card-header'><h3> Features :</h3>"
                    + "</div>" + "<div class='card-body'>";

            $('#stars').raty({
                score: data.rating,
                click: function (score,event) {
                    var myURL = 'http://localhost:8090/rating';
                    var dataRating = {};
                    dataRating['rating'] = score;
                    dataRating['id'] = data.id;
                    $.ajax({
                        type: "POST",
                        data: JSON.stringify(dataRating),
                        url: myURL,
                        dataType: 'json',
                        contentType: 'application/json',
                        complete: function (res) {
                            $('stars').raty({
                                score : res.responseJSON
                            })
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            console.log(thrownError)
                        }
                    });
                }
        });


            $.getJSON("http://localhost:8090/features?productId=" + data.id, function (features) {
                $.each(features, function (i, f) {
                    element = element + "<h4>" + f.name + " : " + f.value + "</h4>"
                });


                $(element).appendTo("#products-container");
            });

//            $('#stars').raty({
//                score: data.rating,
//                click: function (score,event) {
//                    $.ajax({
//                        type: "POST",
//                        data: JSON.stringify(score),
//                        xhrFields: {
//                            withCredentials: true
//                        },
//                        url: myURL,
//                        dataType: 'json',
//                        contentType: 'application/json',
//                        error: function (xhr, ajaxOptions, thrownError) {
//                            console.log(thrownError)
//                        }
//                    });
//
//                }
//            });

        });
    </script>
</@u.page>