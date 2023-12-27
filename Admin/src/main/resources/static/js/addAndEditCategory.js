function validateForm() {
    var name = document.getElementById('name').value;
    var image = document.getElementById('image').value;
    var detail = document.getElementById('detail').value;

    // Reset error messages
    document.getElementById('nameError').innerText = '';
    document.getElementById('imageError').innerText = '';
    document.getElementById('detailError').innerText = '';

    // Repeat similar lines for other fields

    var isValid = true;


    if (!name ) {
        document.getElementById('nameError').innerText = 'Vui lòng nhập tên category';
        isValid = false;
    }
    if (!image ) {
        document.getElementById('imageError').innerText = 'Vui lòng nhập file ảnh cho category.';
        isValid = false;
    }
    if (!detail ) {
        document.getElementById('detailError').innerText = 'Vui lòng nhập thông tin chi tiết cho category.';
        isValid = false;
    }
    return isValid;
}