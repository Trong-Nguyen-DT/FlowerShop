function validateForm() {
    // Lấy giá trị từ trường input
    var nameItem = document.getElementById('nameItem').value;

    // Reset thông báo lỗi
    document.getElementById('nameError').innerText = '';

    // Kiểm tra hợp lệ
    var isValid = true;

    if (!nameItem) {
        document.getElementById('nameError').innerText = 'Vui lòng nhập Name.';
        isValid = false;
    }

    // Nếu có lỗi, không ngăn chặn submit form và hiển thị thông báo
    // if (!isValid) {
    //     showAlert('Vui lòng điền đầy đủ thông tin.');
    //     return false;
    // }

    // Gọi hàm kiểm tra trùng tên
    // checkDuplicate();

    // Trả về giá trị isValid, nếu false sẽ ngăn chặn submit form
    return isValid;
}

// function checkDuplicate() {
//     var nameValue = document.getElementById("nameItem").value;
//
//     // Sử dụng AJAX để gửi yêu cầu kiểm tra đến máy chủ
//     $.ajax({
//         type: 'GET',
//         url: '/admin/item/checkDuplicate?name=' + nameValue,  // Điều chỉnh đường dẫn tùy thuộc vào cấu trúc URL của bạn
//         success: function (result) {
//             if (result) {
//                 // Hiển thị thông báo lỗi nếu dữ liệu đã tồn tại
//                 document.getElementById("nameError").innerHTML = "Item with the same name already exists";
//                 // Nếu dữ liệu trùng, đặt biến isValid thành false để ngăn chặn submit form
//                 isValid = false;
//             } else {
//                 // Xóa thông báo lỗi nếu dữ liệu không tồn tại
//                 document.getElementById("nameError").innerHTML = "";
//             }
//         },
//         error: function (error) {
//             console.log(error);
//         }
//     });
// }
//
// function showAlert(message) {
//     var alertDiv = $('<div class="alert alert-danger" role="alert">' + message + '</div>');
//     $('#alertContainer').html(alertDiv);
//     setTimeout(function () {
//         alertDiv.fadeOut();
//     }, 3000);
// }