$(function () {
    $(".repeat").on('click', function (e) {
        e.preventDefault();
        var $self = $(this);
        $self.before($self.prev('table').clone());
    });
});

function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}