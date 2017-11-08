<#import "layout.ftl" as u>

<@u.page title="Purshases">

<div class="container-fluid">
    <div id="products-container" class="row">
    </div>
</div>
    <#if Session.userId??>
    ${Session.userId}
    </#if>
<script>

    var myURL = 'http://localhost:8090/users/purchases';
    $.ajax({
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        url: myURL,
        xhrFields: {
            withCredentials: true
        },
        complete: function (data) {
            $.each(data, function (i, f) {
                var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
                        "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.product.id + ">" +
                        "<img class=" + "'card-img-top image-product'" + " id=" + f.product.id + " src=" + f.product.images + " alt=" + ">" + "</a>"
                        + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
                        + "<h4 class=" + "card-title" + ">" +
                        "<a href=" + "http://localhost:8091/products/" + f.product.id
                        + " name=" + f.product.name + " id=" + f.product.id + ">" + f.product.name + "</a>"
                        + "</h4>" + "<h5>" + f.product.price + "$</h5>" + "<p class=" + "card-text" + ">" + f.product.description
                        + "</p>" + "</div>"
                        + "<div class=" + "card-footer" + ">"
                        + "<button id=" + f.product.id + " type=" + "button" + " onclick=" + "deleteFromCart(this)" + "> Delete from cart" + "</button>"
                        + "</div>" + "</div>" + "</div>";

                $(element).appendTo("#products-container");
            });
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(thrownError)
        }
    });


    //    $.getJSON("http://localhost:8090/users/purchases", {
    //        dataType: "json",
    //        contentType: 'application/json',
    //        xhrFields: {
    //            withCredentials: true
    //        }
    //    }).done(function (data) {
    //        $.each(data.product, function (i, f) {
    //            var element = "<div style='width:100px' class=" + "col-md-3" + ">" +
    //                    "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + data.product.id + ">" +
    //                    "<img class=" + "'card-img-top image-product'" + " id=" + data.product.id + " src=" + data.product.images + " alt=" + ">" + "</a>"
    //                    + "<h4 class=" + "card-title" + ">" + "<div class=" + "card-body" + ">"
    //                    + "<h4 class=" + "card-title" + ">" +
    //                    "<a href=" + "http://localhost:8091/products/" + data.product.id
    //                    + " name=" + data.product.name + " id=" + data.product.id + ">" + data.product.name + "</a>"
    //                    + "</h4>" + "<h5>" + data.product.price + "$</h5>" + "<p class=" + "card-text" + ">" + data.product.description
    //                    + "</p>" + "</div>"
    //                    + "<div class=" + "card-footer" + ">"
    //                    + "<button id=" + data.product.id + " type=" + "button" + " onclick=" + "deleteFromCart(this)" + "> Delete from cart" + "</button>"
    //                    + "</div>" + "</div>" + "</div>";
    //            $(element).appendTo("#products-container");
    //        });
    //    });

</script>


</@u.page>