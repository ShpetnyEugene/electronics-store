<#import "layout.ftl" as u>
<@u.page title="/users/login">
<h1>Login Form</h1>
<div class="form-inline">
    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3">Email address</label>
        <input type="email" class="form-control" id="login" placeholder="Email" required>
    </div>
    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Password</label>
        <input type="password" class="form-control" id="password1" placeholder="Password" required>
    </div>

    <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me
        </label>
    </div>
    <button onclick="submit()" class="btn btn-default">Login</button>
    <button onclick="clearForm()" class="btn btn-default">Clear form</button>
</div>

<script>
    function submit() {
        var formData = {};
        formData['login'] = document.getElementById("login");
        formData['password'] = document.getElementById("password1");
        var myURL = '/users/login';

        $.ajax({
            type: "POST",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType : 'application/json',
            complete : function(data) {
                window.location.href = "/home";
            }
        });
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