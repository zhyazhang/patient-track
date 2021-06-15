$(function () {

    $("#search-button").click(function () {
        var classify = $('#search-select option:selected').val();
        var content = $('#search-input').val();

        console.log(classify + "  " + content);
        location.href = "/notice/notices?" + classify + "=" + content;
    });


    $('.search-bar .dropdown-menu a').click(function () {
        var field = $(this).data('field') || '';
        $('#search-field').val(field);
        $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });
});