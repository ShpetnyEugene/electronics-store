<#import "layout.ftl" as u>
<@u.page title="Login">
<h1>Login Form</h1>
<h4 id="message" style="text-align: center"></h4>
<div class="form-inline">
    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3">Email address</label>
        <input type="email" class="form-control" id="login" placeholder="Email" required>
    </div>
    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Password</label>
        <input type="password" class="form-control" id="password1" placeholder="Password" required>
    </div>

    <button onclick="submit()" class="btn btn-default">Login</button>
    <button onclick="clearForm()" class="btn btn-default">Clear form</button>
</div>

<script>
    function submit() {
        var formData = {};
        formData['login'] = document.getElementById("login").value;
        formData['password'] = document.getElementById("password1").value;
        var myURL = 'http://localhost:8090/users/login';
        $.ajax({
            type: "POST",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType: 'application/json',
            xhrFields: {
                withCredentials: true
            },
            complete: function (data) {
                if(data){
                    addCart();
                    window.location.href = "/home";
                }else {
                    clearForm();
                    $("#message").html("Error user not found")
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
               console.log(thrownError)
            }
        });
    }
    function addCart() {
        if(sessionStorage.length !== 0){
            var values = [],
                    keys = Object.keys(sessionStorage),
                    i = keys.length;
            while (i--) {
                values.push(sessionStorage.getItem(keys[i]));
            }
            var formData = values;
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
    }

    function clearForm() {
        var inputList = document.getElementsByTagName("input");
        for (i = 0; i < inputList.length; i++) {
            inputList[i].value = "";
        }
        try {
            document.getElementById("result").innerHTML = "";
        } catch (err) {
        }
    }
</script>
</@u.page>