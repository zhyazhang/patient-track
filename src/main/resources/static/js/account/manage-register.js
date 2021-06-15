$(function () {


    var flagSelect = false;
    var flagSerial = false;
    var flagPwd = false;

    var maindepid, serialnumber, password;


    $("#password").change(function () {

        password = $("#password").val();

        $("#invalid-pwd").hide();

        if (password.length < 6 || password.length > 20) {

            $("#invalid-pwd").show();
            flagPwd = false;
        } else {
            flagPwd = true;
        }


    });


    $("#serialnumber").change(function () {

        serialnumber = $("#serialnumber").val();

        $("#invalid-serial").hide();
        $("#invalid-serialexit").hide();

        if (serialnumber.length !== 5) {

            $("#invalid-serial").show();
            flagSerial = false;

        } else {

            $("#invalid-serial").hide();

            $.ajax({
                type: "post",
                url: "/auth/ifSerialNumberExit",
                async: true,
                data: {
                    "number": serialnumber
                },
                success: function (r) {
                    if (r.code === 200) {
                        flagSerial = true;
                    } else {
                        $("#invalid-serialexit").show();
                        flagSerial = false;
                    }
                }
            });
        }

    });


    $("#reg-btn").click(function () {

            maindepid = $("#maindep-select").val();
            var nickname = $("#maindep-select option:selected").text() + "挂号员";
            serialnumber = $("#serialnumber").val();
            password = $("#password").val();


            if (maindepid !== -1) {
                if (flagSerial && flagPwd) {

                    tips.loading('show');

                    $.ajax({
                        type: "post",
                        url: "/auth/register/4",
                        data: {
                            "phone": serialnumber,
                            "serialnumber": serialnumber,
                            "maindepid": maindepid,
                            "password": password,
                            "nickname": nickname
                        },
                        success: function (r) {

                            if (r.code === 200) {

                                tips.loading('hide');
                                tips.notify('注册成功，返回登录界面！', 'success', 3000);

                                $('#register').modal('hide');
                            } else {

                                tips.loading('hide');
                                tips.notify(r.msg, 'danger', 100);
                            }
                        }
                    });
                }
            } else {
                $("#invalid-select").show();

            }
        }
    );


    $("#add-reg").click(function () {
        $('#register').modal('show');

    });


    $("#search-button").click(function () {
        var classify = $('#search-select option:selected').val();
        var content = $('#search-input').val();
        // console.log(classify + content);
        console.log(classify + content);

        if ('serialnumber' === classify) {
            classify = 'phone';
        }

        location.href = "/account/getusers?type=4&" + classify + "=" + content;

    });


    $('.search-bar .dropdown-menu a').click(function () {
        var field = $(this).data('field') || '';
        $('#search-field').val(field);
        $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });
});