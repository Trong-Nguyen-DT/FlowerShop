var code = document.getElementById('code').value;
var conditionPrice = document.getElementById('conditionPrice').value;
var startDate = document.getElementById('startDate').value;
var endDate = document.getElementById('endDate').value;
var percentage = document.getElementById('percentage').value;
var usageLimit = document.getElementById('usageLimit').value;
var voucherTypes = document.getElementById('voucherTypes').value;

// Reset error messages
document.getElementById('codeError').innerText = '';
document.getElementById('conditionPriceError').innerText = '';
document.getElementById('startDateError').innerText = '';
document.getElementById('endDateError').innerText = '';
document.getElementById('percentageError').innerText = '';
document.getElementById('usageLimitError').innerText = '';

// Repeat similar lines for other fields

var isValid = true;

function validateForm() {
    if (!code ) {
        document.getElementById('codeError').innerText = 'Vui lòng nhập Code.';
        isValid = false;
    }
    if (parseFloat(conditionPrice) === 0.0 ) {
        document.getElementById('conditionPriceError').innerText = 'Vui lòng nhập Condition price.';
        isValid = false;
    }
    if (!startDate ) {
        document.getElementById('startDateError').innerText = 'Vui lòng nhập Start date.';
        isValid = false;
    }
    if (!endDate ) {
        document.getElementById('endDateError').innerText = 'Vui lòng nhập End date.';
        isValid = false;
    }
    if (parseFloat(percentage) === 0.0 ) {
        document.getElementById('percentageError').innerText = 'Vui lòng nhập Percentage.';
        isValid = false;
    }
    if (parseInt(usageLimit) === 0 ) {
        document.getElementById('usageLimitError').innerText = 'Vui lòng nhập Usage limit.';
        isValid = false;
    }
    if (!voucherTypes ) {
        document.getElementById('voucherTypesError').innerText = 'Vui lòng chọn Voucher types.';
        isValid = false;
    }
    return isValid;
}