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
