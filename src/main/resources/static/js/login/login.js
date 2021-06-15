$(function () {

    $("#login").click(function () {

        var phone = $("#phone").val();
        var password = $("#password").val();
        var code;

        tips.loading('show');

        if (isNumber(phone)) {

            $.ajax({
                type: "post",
                url: "/auth/login",
                async: false,
                data: {
                    "phone": phone.trim(),
                    "password": password
                    /*"validateCode": validateCode,
                    "rememberMe": rememberMe*/
                },
                success: function (r) {
                    code = r.code;

                    if (code === 200) {
                        tips.loading('hide');
                        tips.notify('修改成功，页面即将自动跳转~', 'success', 3000);


                        location.href = "/auth/index";
                    } else {
                        tips.loading('hide');
                        tips.notify(r.msg, 'danger', 100);
                    }

                }
            });

        } else {

            tips.loading('hide');

            tips.notify('请以正确格式输入账号！', 'danger', 100);
        }


    });


})