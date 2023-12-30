var selectedCategories = [];
function toggleCategory(categoryId) {
    let categoryButton = document.getElementById("category_" + categoryId);
    console.log(categoryId);
    categoryButton.classList.toggle("selected");

    if (categoryButton.classList.contains("selected")) {
        selectedCategories.push(categoryId);
    } else {
        let index = selectedCategories.indexOf(categoryId);
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
    // Thu thập dữ liệu biểu mẫu
    let formData = new FormData(document.getElementById("addProductForm"));
    fetch('/admin/product-add', {
        method: 'POST',
        body: formData,
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP Error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            if (data.success) {
                // This line redirects to '/login'
                console.log('Xác nhận đổi mật khẩu thành công. Đang chuyển hướng đến trang xác nhận đăng ký.');
                window.location.replace('/admin/product');
            }else {
                console.error('Xác nhận đổi mật khẩu thất bại:', data.message);
                alert("Thêm sản phẩm thất bại");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Lỗi khi xử lý response thông báo 2");
            console.error('Error:', error);
            window.location.href = 'admin/product';
        });
}

// THÔNG BÁO LỖI

// function validateFormAddProduct() {
//     var name = document.getElementById('name').value;
//     var originalPrice = document.getElementById('originalPrice').value;
//     var discount = document.getElementById('discount').value;
//     var description = document.getElementById('description').value;
//     var delivery = document.getElementById('delivery').value;
//     var sub_info = document.getElementById('sub_info').value;
//     var image1 = document.getElementById('image1').value;
//     var image2 = document.getElementById('image2').value;
//     var image3 = document.getElementById('image3').value;
//     var image4 = document.getElementById('image4').value;
//     var image5 = document.getElementById('image5').value;
//
//
// // Reset error messages
//     document.getElementById('nameError').innerText = '';
//     document.getElementById('originalPriceError').innerText = '';
//     document.getElementById('discountError').innerText = '';
//     document.getElementById('descriptionError').innerText = '';
//     document.getElementById('deliveryError').innerText = '';
//     document.getElementById('sub_infoError').innerText = '';
//     document.getElementById('image1Error').innerText = '';
//     document.getElementById('image2Error').innerText = '';
//     document.getElementById('image3Error').innerText = '';
//     document.getElementById('image4Error').innerText = '';
//     document.getElementById('image5Error').innerText = '';
// // Repeat similar lines for other fields
//
//     var isValid = true;
//     if (!name ) {
//         document.getElementById('nameError').innerText = 'Vui lòng nhập tên đăng nhập.';
//         isValid = false;
//     }
//     if (!originalPrice ) {
//         document.getElementById('originalPriceError').innerText = 'Vui lòng nhập mật khẩu.';
//         isValid = false;
//     }
//     if (!discount ) {
//         document.getElementById('discountError').innerText = 'Vui lòng nhập họ và tên.';
//         isValid = false;
//     }
//     if (!description) {
//         document.getElementById('descriptionError').innerText = 'Vui lòng nhập số điện thoại.';
//         isValid = false;
//     }
//     if (!delivery ) {
//         document.getElementById('deliveryError').innerText = 'Vui lòng nhập địa chỉ.';
//         isValid = false;
//     }
//     if (!sub_info ) {
//         document.getElementById('sub_infoError').innerText = 'Vui lòng nhập ngày sinh.';
//         isValid = false;
//     }
//     if (!image1 ) {
//         document.getElementById('image1Error').innerText = 'Vui lòng nhập lương.';
//         isValid = false;
//     }
//     if (!image2 ) {
//         document.getElementById('image2Error').innerText = 'Vui lòng nhập phân quyền.';
//         isValid = false;
//     }
//     if (!image3 ) {
//         document.getElementById('image3Error').innerText = 'Vui lòng nhập phân quyền.';
//         isValid = false;
//     }
//     if (!image4 ) {
//         document.getElementById('image4Error').innerText = 'Vui lòng nhập phân quyền.';
//         isValid = false;
//     }
//     if (!image5 ) {
//         document.getElementById('image5Error').innerText = 'Vui lòng nhập phân quyền.';
//         isValid = false;
//     }
//     return isValid;
// }

window.addEventListener('unhandledrejection', event => {
    console.error('Unhandled Promise Rejection:', event.reason);
});