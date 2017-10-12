<#import "layout.ftl" as u>
<@u.page title="Registration">
<h1>Registration</h1>
<div class="form-inline">

    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3">Login</label>
        <input type="text" class="form-control" id="login" placeholder="Login">
    </div>

    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Password</label>
        <input type="password" class="form-control" id="password1" placeholder="Password 1">
    </div>

    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Repeat Password</label>
        <input type="password" class="form-control" id="password2" placeholder="Password 2">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me
        </label>
    </div>
    <button onclick="submit()" class="btn btn-default">Registration</button>
    <button onclick="clearForm()" class="btn btn-default">Clear form</button>
</div>

<h4 id="message"></h4>

<script>

    function submit() {
        if (document.getElementById("password2").value !== document.getElementById("password1").value){
            clearForm();
            $("#message").html("Password 1 and password 2 must match");
            return;
        }

        var formData = {};
        formData['login'] = document.getElementById("login").value;
        formData['password'] = document.getElementById("password2").value;
        var myURL = '${backendUrl}/users/registration';
        $.ajax({
            type: "POST",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType: 'application/json',
            complete: function (data) {
                window.location.href = "/home";
                var result = data.responseText;
                document.getElementById("result").innerHTML = result;
                console.log(result);
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