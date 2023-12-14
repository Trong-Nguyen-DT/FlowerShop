var selectedCategories = [];

function toggleCategory(categoryId) {
    var categoryButton = document.getElementById("category_" + categoryId);
    console.log(categoryId);
    categoryButton.classList.toggle("selected");

    if (categoryButton.classList.contains("selected")) {
        selectedCategories.push(categoryId);
    } else {
        var index = selectedCategories.indexOf(categoryId);
        if (index !== -1) {
            selectedCategories.splice(index, 1);
        }
    }
    console.log(selectedCategories);
    return selectedCategories;
}

function submitForm() {
    // Cập nhật giá trị của input ẩn với các danh mục đã chọn
    document.getElementById("categoryIdsInput").value = selectedCategories.join(',');

    // Giả sử bạn có một hàm tên là sendDataToController
    sendDataToController();
}

function sendDataToController() {
    // Thu thập dữ liệu biểu mẫu
    var formData = new FormData(document.getElementById("addProductForm"));

    // Thực hiện một yêu cầu AJAX
    fetch('/admin/product/add', {
        method: 'POST',
        body: formData,
    })
        .then(response => response.json())
        .then(data => {
            // Xử lý phản hồi từ máy chủ nếu cần
            console.log(data);
        })
        .catch(error => {
            console.error('Lỗi:', error);
        });
}


// THÔNG BÁO LỖI


function validateForm() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var fullName = document.getElementById('fullName').value;
    var image = document.getElementById('image').value;
    var phone = document.getElementById('phone').value;
    var address = document.getElementById('address').value;
    var birthday = document.getElementById('birthday').value;
    var salary = document.getElementById('salary').value;
    var role = document.getElementById('role').value;

// Reset error messages
    document.getElementById('usernameError').innerText = '';
    document.getElementById('passwordError').innerText = '';
    document.getElementById('fullNameError').innerText = '';
    document.getElementById('imageError').innerText = '';
    document.getElementById('phoneError').innerText = '';
    document.getElementById('addressError').innerText = '';
    document.getElementById('birthdayError').innerText = '';
    document.getElementById('salaryError').innerText = '';
    document.getElementById('roleError').innerText = '';
    // Repeat similar lines for other fields

    var isValid = true;


    if (!username ) {
        document.getElementById('usernameError').innerText = 'Vui lòng nhập tên đăng nhập.';
        isValid = false;
    }
    if (!password ) {
        document.getElementById('passwordError').innerText = 'Vui lòng nhập mật khẩu.';
        isValid = false;
    }
    if (!fullName ) {
        document.getElementById('fullNameError').innerText = 'Vui lòng nhập họ và tên.';
        isValid = false;
    }
    // if (!image ) {
    //     document.getElementById('imageError').innerText = 'Vui lòng nhập image.';
    //     isValid = false;
    // }
    if (!phone) {
        document.getElementById('phoneError').innerText = 'Vui lòng nhập số điện thoại.';
        isValid = false;
    }
    if (isValidPhoneNumber(phone) === false){
        document.getElementById('phoneError').innerText = 'Vui lòng nhập đúng định dạng.';
        isValid = false;
    }
    if (!address ) {
        document.getElementById('addressError').innerText = 'Vui lòng nhập địa chỉ.';
        isValid = false;
    }
    if (!birthday ) {
        document.getElementById('birthdayError').innerText = 'Vui lòng nhập ngày sinh.';
        isValid = false;
    }
    if (!salary ) {
        document.getElementById('salaryError').innerText = 'Vui lòng nhập lương.';
        isValid = false;
    }
    if (!role ) {
        document.getElementById('roleError').innerText = 'Vui lòng nhập phân quyền.';
        isValid = false;
    }
    return isValid;
}
function isValidPhoneNumber(phone) {
    // Sử dụng biểu thức chính quy để kiểm tra
    const phoneRegex = /^0[0-9]{9}$/;
    return phoneRegex.test(phone);
}

