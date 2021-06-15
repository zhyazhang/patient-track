$(function () {
    $('#summernote').summernote({
        height: 600,                 // 定义编辑框高度
        minHeight: null,             // 定义编辑框最低的高度
        maxHeight: null,             // 定义编辑框最高德高度
        <!--工具栏-->
        toolbar: [
            <!--字体工具-->
            ['fontname', ['fontname']], //字体系列
            ['style', ['bold', 'italic', 'underline', 'clear']], // 字体粗体、字体斜体、字体下划线、字体格式清除
            ['font', ['strikethrough', 'superscript', 'subscript']], //字体划线、字体上标、字体下标
            ['fontsize', ['fontsize']], //字体大小
            ['color', ['color']], //字体颜色

            <!--段落工具-->
            ['style', ['style']],//样式
            ['para', ['ul', 'ol', 'paragraph']], //无序列表、有序列表、段落对齐方式
            ['height', ['height']], //行高

            <!--插入工具-->
            ['table', ['table']], //插入表格
            ['hr', ['hr']],//插入水平线
            ['link', ['link']], //插入链接

            <!--其它-->
            ['fullscreen', ['fullscreen']], //全屏
            ['codeview', ['codeview']], //查看html代码
            ['undo', ['undo']], //撤销
            ['redo', ['redo']], //取消撤销
            ['help', ['help']], //帮助
        ],

    });


});



