<#import "layout.ftl" as u>

<@u.page title="Cart">

<div class="col-lg-4 col-md-6 mb-4">
    <div class="card h-100">
        <a href="#"><img class="card-img-top" id="image" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
            <h4 class="card-title">
                <a href="#" name="item" id="item6">Item Five</a>
            </h4>
            <h5>$24.99</h5>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam
                aspernatur!
                Lorem ipsum dolor sit amet.</p>
        </div>
        <div class="card-footer">
            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
        </div>
    </div>
</div>

    <button onclick="buy()">Buy All</button>

<div id="asd">

</div>

<script>



    for(var i = 0; i < sessionStorage.length; i++){
        $.get( "http://localhost:8090/users/cart?id="+sessionStorage.getItem(i), function( data ) {
            $( "#asd" ).html( data. );

        });
    }


    function buy() {
        var data = sessionStorage;
        var myUrl = 'http://localhost:8090/users/cart';
        $.ajax({
            type: "DELETE",
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json',
            url:myUrl,
            complete:function () {
                sessionStorage.clear();
                window.href("/home")
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(thrownError)
            }
        });
    }
</script>


</@u.page>