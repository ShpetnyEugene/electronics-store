<#import "layout.ftl" as u>
<@u.page title="Registration">
<h1>Registration Form</h1>
<div class="form-inline">

    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3">Email address</label>
        <input type="email" class="form-control" id="login" placeholder="Email">
    </div>

    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Password</label>
        <input type="password" class="form-control" id="password1" placeholder="Password">
    </div>

    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Repeat Password</label>
        <input type="password" class="form-control" id="password2" placeholder="Password">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me
        </label>
    </div>
    <button onclick="submit()" class="btn btn-default">Registration</button>
    <button onclick="clearForm()" class="btn btn-default">Clear form</button>
</div>

<script>
    function submit() {
        var formData = {};
        formData['login'] = document.getElementById("login");
        formData['password'] = document.getElementById("password2");
        var myURL = 'http://localhost:8090/users/registration';

        $.ajax({
            type: "POST",
            data: JSON.stringify(formData),
            url: myURL,
            dataType: 'json',
            contentType : 'application/json',
            complete : function(data) {
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
            t
        }
    }
</script>

</@u.page>