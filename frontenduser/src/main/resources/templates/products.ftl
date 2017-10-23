<#import "layout.ftl" as u>

<@u.page title="Products">

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <h1 class="my-4">Filter</h1>
            <div class="list-group">
                <a href="#" class="list-group-item"></a>
                <a href="#" class="list-group-item">Category 2</a>
                <a href="#" class="list-group-item">Category 3</a>
            </div>
        </div>



        <div class="col-md-6 col-md-offset-3">
            <ul class="nav nav-pills">
                <li><a class="btn btn-primary" id="Phone" onclick="page(this)">Phones</a></li>
                <li><a class="btn btn-primary" id="Laptops" onclick="page(this)">Laptops</a></li>
                <li><a class="btn btn-primary" id="Tablets" onclick="page(this)">Tablets</a></li>
                <li><a class="btn btn-primary" id="TVs" onclick="page(this)">TVS</a></li>
            </ul>
        </div>

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

                    <button type="button" onclick="buy(this)">Buy</button>


                </div>
            </div>
        </div>




        <script>

            $.getJSON("http://localhost:8090/products?type=Phone", function (data) {
                        $.each(data.product, function (i, f) {
                            var element = "<a href="+ +">" +
                                    "<img class=/"card-img-top" id="i.id" src="+ i.images +" ";

                            $(element).appendTo("#name1")
                        });
                    }
            );


            function page(obj) {
                $.getJSON("http://localhost:8090/products?type="+obj.id, function (data) {
                            $.each(data.product, function (i, f) {
                                var element = "<a href="+ +">" +
                                        "<img class=/"card-img-top" id="i.id" src="+ i.images +" ";

                                $(element).appendTo("#name1")
                            });
                        }
                );
            }

            function buy(obj) {
                sessionStorage.setItem(obj.id,obj.id);
            }

        </script>



</@u.page>