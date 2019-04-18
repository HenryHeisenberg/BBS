$(document).ready(function () {
    
    $("#submit").click(function () { 
        $.ajax({
            type: "POST",
            url: "login",
            data: $("#loginData").serialize(),
            //dataType: "dataType",
            success: function (response) {
                console.log(response);
            }
        });
    
        
    });
    
});