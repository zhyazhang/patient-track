function resetPwd(theIndex) {

    tips.loading('show');
    var checkLength = $("input:checkbox[name='check-item']:checked").length;
    if (checkLength === 0) {
        tips.loading('hide');
        tips.notify("请至少选择一个用户", 'danger', 100);
        return;
    }

    var phonelist = '';

    $("input[type='checkbox']").each(function () { //遍历checkbox的选择状态
        if ($(this).prop("checked")) { //如果值为checked表明选中了
            phonelist += $(this).closest('tr').find('td').eq(theIndex).text() + ".";
        }
    });

    $.ajax({
        type: "post",
        url: "/account/resetpwd",
        data: {
            "phonelist": phonelist.trim(),
        },
        success: function (r) {
            if (r.code === 200) {
                tips.loading('hide');
                tips.notify('重置密码成功！', 'success', 3000);
                window.location.reload();
            } else {
                tips.loading('hide');
                tips.notify(r.msg, 'danger', 100);
            }

        }
    })

}