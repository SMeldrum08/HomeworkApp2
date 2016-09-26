$(function () {
    $(".repeat").on('click', function (e) {
        e.preventDefault();
        var $self = $(this);
        $self.before($self.prev('table').clone());
    });
});