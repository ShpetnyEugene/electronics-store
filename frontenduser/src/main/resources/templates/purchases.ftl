<#import "layout.ftl" as u>

<@u.page title="Purshases">


<#--<div class="col-lg-4 col-md-6 mb-4">-->
    <#--<div class="card h-100">-->
        <#--<a href="#"><img class="card-img-top" id="image" src="http://placehold.it/700x400" alt=""></a>-->
        <#--<div class="card-body">-->
            <#--<h4 class="card-title">-->
                <#--<a href="#" name="item" id="item6">Item Five</a>-->
            <#--</h4>-->
            <#--<h5>$24.99</h5>-->
            <#--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam-->
                <#--aspernatur!-->
                <#--Lorem ipsum dolor sit amet.</p>-->
        <#--</div>-->
        <#--<div class="card-footer">-->
            <#--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->

<script>

    $.getJSON("http://localhost:8090/products?type=Phone", function (data) {
                $.each(data, function (i, f) {
                    var element = "<div class=" + "col-lg-4 col-md-6 mb-4" + ">" +
                            "<div class=" + "card h-100" + ">" + "<a href=" + "http://localhost:8091/products/" + f.id + ">" +
                            "<img class=" + "card-img-top" + "style: width='30px'" + " id=" + f.id + " src=" + f.images + " alt=" + ">" + "</a>"
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
                    $(element).appendTo("body")
                });
            }
    );

</script>


</@u.page>