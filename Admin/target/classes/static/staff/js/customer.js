async function findAllCustomer() {
  $('#example').DataTable().destroy();
  var url = 'http://localhost:8080/staff/all-customer';
  const response = await fetch(url, {
    method: 'GET'
  });
  var list = await response.json();
  var main = '';
  for (i = 0; i < list.length; i++) {
    main += `<tr>
                  <td>${list[i].id}</td>
                  <td><img src="${list[i].avatar}" style="width: 100px"></td>
                  <td>${list[i].address}</td>
                  <td>${list[i].email}</td>
                  <td>${list[i].fullName}</td>
                  <td>${list[i].phone}</td>
                  <td>${list[i].username}</td>
              </tr>`
  }
  document.getElementById("listCustomer").innerHTML = main;
  $('#example').DataTable();
}
