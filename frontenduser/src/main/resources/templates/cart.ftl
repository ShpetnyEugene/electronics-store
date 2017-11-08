<#import "layout.ftl" as u>

<@u.page title="Cart">

<div class="container-fluid">
    <div id="products-container" class="row">
    </div>
</div>
<br>
<br>
<div id="cost" class="col-md-4 col-md-offset-4">

</div>

<center>
    <button onclick="buyAll()">Buy All</button>
</center>


<script>
    var cost = 0;
    var values = [],
            keys = Object.keys(sessionStorage),
            i = keys.length;
    while (i--) {
        values.push(sessionStorage.getItem(keys[i]));
    }
    for (var j = 0; j < sessionStorage.length; j++) {
        $.get("http://localhost:8090/users/cart?id=" + values.pop(), function (data) {
            var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                    "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + data.id + ">" +
                    "<img class=" + "image-product" + " id=" + data.id + " src=" + data.images + " alt=" + ">" + "</a>"
                    + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                    + "<h4 class=" + "card-title" + ">" +
                    "<a href=" + "http://localhost:8091/products/" + data.id
                    + " name=" + data.name + " id=" + data.id + ">" + data.name + "</a>"
                    + "</h4>" + "<h5>" + data.price + "$</h5>" + "<p class=" + "card-text" + ">" + data.description
                    + "</p>" + "</div>"
                    + "<div class=" + "card-footer" + ">"
                   + "<button id=" + data.id + " type=" + "button" + " onclick=" + "deleteFromCart(this)" + "> Delete from cart" + "</button>"
                    + "</div>" + "</div>" + "</div>";
            cost = cost + parseInt(data.price);
            $(element).appendTo("#products-container");

            $("#cost").empty();
            $("#cost").html("<h4 style='text-align: right'>Price for all purchases:" + cost + " $</h4>");
        });

    }


    function deleteFromCart(data) {
        cost = 0;
        var values1 = [],
                keys = Object.keys(sessionStorage),
                i = keys.length;
        while (i--) {
            values1.push(sessionStorage.getItem(keys[i]));
        }
        $("#products-container").empty();
        sessionStorage.removeItem(data.id);

        for (var j = 0; j < sessionStorage.length; j++) {
            $.get("http://localhost:8090/users/cart?id=" + values1.pop(), function (data) {
                var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                        "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + data.id + ">" +
                        "<img class=" + "image-product" + " id=" + data.id + " src=" + data.images + " alt=" + ">" + "</a>"
                        + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                        + "<h4 class=" + "card-title" + ">" +
                        "<a href=" + "http://localhost:8091/products/" + data.id
                        + " name=" + data.name + " id=" + data.id + ">" + data.name + "</a>"
                        + "</h4>" + "<h5>" + data.price + "$</h5>" + "<p class=" + "card-text" + ">" + data.description
                        + "</p>" + "</div>"
                        + "<div class=" + "card-footer" + ">"
                        +"<button id=" + data.id + " type=" + "button" + " onclick=" + "deleteFromCart(this)" + "> Delete from cart" + "</button>"
                        + "</div>" + "</div>" + "</div>";
                cost = cost + parseInt(data.price);
                $(element).appendTo("#products-container");

                $("#cost").empty();
                $("#cost").html("<h4 style='text-align: right'>Price for all purchases:" + cost + " $</h4>");
            });
        }
    }

    function buyAll() {
        var values = [],
                keys = Object.keys(sessionStorage),
                i = keys.length;
        while (i--) {
            values.push(sessionStorage.getItem(keys[i]));
        }

        var data = values;
        var myUrl = 'http://localhost:8090/users/cart';
        $.ajax({
            type: "PUT",
            data: JSON.stringify(data),
            dataType: 'json',
            xhrFields: {
                withCredentials: true
            },
            contentType: 'application/json',
            url: myUrl,
            complete: function () {
                sessionStorage.clear();
                window.location.replace("/home");
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(thrownError)
            }
        });
    }
</script>
</@u.page>