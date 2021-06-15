var departments =$("#dep-data").text();
var user =$("#user-data").text();

$(function () {


    <!--加载的科室-->

    var miandepid = user.maindepid;
    var secdepid = user.secdepid;
    var maindep = departments[miandepid - 1].maindep;
    var secdeplist = departments[miandepid - 1].secDepartments;
    var secdep;
    for (var i = 0; i < secdeplist.length; i++) {

        if (secdepid === secdeplist[i].id) {
            secdep = secdeplist[i].secdep;
        }
    }

    var first = document.getElementById("maindep-select");
    var second = document.getElementById("secdep-select");
    first.options.add(new Option(maindep, miandepid));
    second.options.add(new Option(secdep, secdepid));


    <!--设置doctor的科室-->

    for (var i = 0; i < departments.length; i++) {
        if (i !== (miandepid - 1)) {
            first.options.add(new Option(departments[i].maindep, departments[i].id));
        }
    }

    for (var i = 0; i < secdeplist.length; i++) {
        second.options.add(new Option(secdeplist[i].secdep, secdeplist[i].id));
    }

});

$("#regbtn").click(function () {

    var nickname;
    var age = null;
    var phone;
    var serialnumber;
    var email;
    var maindepid;
    var secdepid;
    var gender;

    nickname = $("#nickname").val();
    phone = $("#phone").val();
    age = $("#age").val();
    serialnumber = $("#serialnumber").val();
    email = $("#email").val();

    //获取select选中的option的value
    maindepid = $('#maindep-select option:selected').val();
    secdepid = $('#secdep-select option:selected').val();

    //获取选中的radio的value
    gender = $('input:radio:checked').val();

    tips.loading('show');


    $.ajax({
        type: "post",
        url: "/account/edituser",
        data: {
            "id": user.id,
            "nickname": nickname,
            "age": age,
            "phone": phone,
            "serialnumber": serialnumber,
            "email": email,
            "maindepid": maindepid,
            "secdepid": secdepid,
            "gender": gender
        },
        success: function (r) {

            tips.loading('hide');
            tips.notify(r.msg, 'success', 3000);

            window.location.reload();

        }
    });


});


<!--选择框二级联动-->

function nextChange() {

    var second = document.getElementById("secdep-select");
    second.options.length = 0;

    <!--获取选中的option的value-->

    var maindepid = $('#maindep-select option:selected').val();
    secdepartment = departments[maindepid - 1].secDepartments;

    for (var i = 0; i < secdepartment.length; i++) {
        second.options.add(new Option(secdepartment[i].secdep, secdepartment[i].id));
    }

}