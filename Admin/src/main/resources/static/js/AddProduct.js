var selectedCategories = [];

function toggleCategory(categoryId) {
    var categoryButton = document.getElementById("category_" + categoryId);
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

// Function to send selected categories to the server
function sendCategoriesToServer() {
    var data = {
        selectedCategories: selectedCategories,
        // Add other information if needed
    };

    console.log(data);

    // Send data to the server using Fetch API or jQuery Ajax
    // fetch("/customer/sendSelectedCategories", {
    //     method: "POST",
    //     headers: {
    //         "Content-Type": "application/json",
    //     },
    //     body: JSON.stringify(data),
    // })
    // .then(function (response) {
    //     if (response.ok) {
    //         // Handle the result from the server if needed
    //         return response.json();
    //     } else {
    //         // Handle errors if needed
    //         console.error("Error:", response.statusText);
    //     }
    // })
    // .then(function (result) {
    //     // Handle the result from the server if needed
    //     console.log(result);
    // })
    // .catch(function (error) {
    //     console.error("Error:", error);
    // });
}
function submitForm() {
    var categoryIdsInput = document.getElementById("categoryIdsInput");

    if (categoryIdsInput) {
        // Đảm bảo rằng đối tượng không phải là null trước khi truy cập thuộc tính
        categoryIdsInput.value = selectedCategories.join(',');
        document.getElementById("productForm").submit();
    } else {
        console.error("Element with id 'categoryIdsInput' not found");
    }
}
