
/* Form wizard */

$(function() {
    $('#form-wizard-1').bootstrapWizard({'tabClass': 'nav nav-pills'});
});

$(function() {
    $('#form-wizard-2').bootstrapWizard({'tabClass': 'list-group list-group-separator row list-group-icons list-group-centered', 'nextSelector': '.button-next', 'previousSelector': '.button-previous', 'firstSelector': '.button-first', 'lastSelector': '.button-last'});
});

$(function() {
    $('#form-wizard-3').bootstrapWizard({'tabClass': ''});
});