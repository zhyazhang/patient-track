function addnotice() {
    var title = $('#thetitle').val();
    var content = $('#summernote').summernote('code');

    console.log("asdsd");

    $.ajax({
        type: "post",
        url: "/notice/add",
        data: {
            "title": title,
            "content": content
        },
        success: function (r) {

            if (r.code === 200) {

                $('#myModal').modal('hide');
                tips.notify('添加成功！', 'success', 3000);
            } else {
                $('#myModal').modal('hide');
                tips.notify('添加失败，请稍后重试！', 'danger', 3000);
            }


        }
    });


}
