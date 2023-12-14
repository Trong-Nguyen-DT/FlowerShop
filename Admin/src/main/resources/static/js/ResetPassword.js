function confirmReset(button) {
    var resetPasswordUrl = $(button).data("url");
    var userId = $(button).data("userid");

    // Sử dụng AJAX để gửi yêu cầu
    $.ajax({
        type: "POST",
        url: resetPasswordUrl.replace('{id}', userId),
        data: {userId: userId},
        success: function (response) {
            // Xử lý khi yêu cầu thành công
            alert("Password reset confirmed");
            hideOverlay();
        },
        error: function (error) {
            // Xử lý khi có lỗi
            console.error("Error resetting password:", error);
            hideOverlay();
        }
    });
}

function cancelReset() {
    // Người dùng không muốn reset, ẩn overlay
    hideOverlay();
}

function showOverlay() {
    document.getElementById("overlay").style.display = "flex";
}

function hideOverlay() {
    document.getElementById("overlay").style.display = "none";
}
