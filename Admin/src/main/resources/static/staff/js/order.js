async function findAllPOrder() {
  $('#example').DataTable().destroy();
  var from = document.getElementById("from").value
  var to = document.getElementById("to").value
  var url = 'http://localhost:8080/staff/all-order';
  if(from != "" && to != ""){
      url += '?from='+from+'&to='+to;
  }
  const response = await fetch(url, {
    method: 'GET'
  });
  var list = await response.json();
  console.log(list)
  var main = '';
  for (i = 0; i < list.length; i++) {
  main += `<tr>
          <td>${list[i].id}</td>
          <td>${list[i].orderDateTime}</td>
          <td>${formatmoney(list[i].totalPrice)}</td>
          <td>${formatmoney(list[i].discount)}</td>
          <td>${formatmoney(list[i].amount)}</td>
          <td>${list[i].confirmed}</td>
          <td>${list[i].orderStatus}</td>
          <td>${list[i].userEntity==null?'':list[i].userEntity.username}</td>
          <td>${list[i].customerEntity== null?'':list[i].customerEntity.username}</td>
          <td class="sticky-col">
              <a onclick="loadDetailOrder(${list[i].id})" data-bs-toggle="modal" data-bs-target="#viewdetail"><i class="fa fa-eye iconaction"></i></a>
              <i onclick="setIdUpdateStt(${list[i].id},'${list[i].orderStatus}')" data-bs-toggle="modal" data-bs-target="#statusOrder" class="fa fa-edit iconaction"></i>
              <span onclick="loadOrderById(${list[i].id})" data-bs-toggle="modal" data-bs-target="#addNote" class="pointer">Add note</span>
          </td>
      </tr>`
  }
  document.getElementById("listOrder").innerHTML = main;
  $('#example').DataTable();
}


async function loadDetailOrder(id) {
  var url = 'http://localhost:8080/staff/order-detail-by-order?id='+id;
  const response = await fetch(url, {
    method: 'GET'
  });
  var list = await response.json();
  console.log(list)
  var main = '';
  for (i = 0; i < list.length; i++) {
  main += `<tr>
          <td>${list[i].id}</td>
          <td><img src="http:${list[i].productEntity.image1}" style="width:80px"></td>
          <td>${list[i].productEntity.id}</td>
          <td>${list[i].productEntity.name}</td>
          <td>${formatmoney(list[i].productEntity.price)}</td>
          <td>${list[i].quantity}</td>
      </tr>`
  }
  document.getElementById("listOrderDetail").innerHTML = main;
}


async function loadOrderById(id) {
  document.getElementById("idOrder").value = id;
  var url = 'http://localhost:8080/staff/get-order-by-id?id='+id;
  const response = await fetch(url, {
    method: 'GET'
  });
  var order = await response.json();
  console.log(order)
  document.getElementById("noteorder").value = order.note;
  if(order.informationRelated != null){
    await new Promise(r => setTimeout(r, 500));
    tinyMCE.get('editor').setContent(order.informationRelated)
  }
  else{
    tinyMCE.get('editor').setContent("");
  }
}

async function addNote() {
  var url = 'http://localhost:8080/staff/add-order-note';

  var id = document.getElementById("idOrder").value
  var note = document.getElementById("noteorder").value
  var infRelate = tinyMCE.get('editor').getContent()
  var obj = {
      "orderId": id,
      "note": note,
      "inforRelated": infRelate
  }

  const response = await fetch(url, {
      method: 'POST',
      headers: new Headers({
          'Content-Type': 'application/json'
      }),
      body: JSON.stringify(obj)
  });
  if (response.status < 300) {
      swal({
          title: "Notification",
          text: "Success",
          type: "success"
      },
      function() {
          $("#addNote").modal("hide");
      });
  }
  if (response.status == exceptionCode) {
      var result = await response.json()
      toastr.warning(result.defaultMessage);
  }
  document.getElementById("loading").style.display = 'none'
}

async function loadAllStatus() {
  var url = 'http://localhost:8080/staff/get-all-status-order';
  const response = await fetch(url, {
    method: 'GET'
  });
  var list = await response.json();
  var main = '';
  for (i = 0; i < list.length; i++) {
  main += `<option value="${list[i]}">${list[i]}</option>`
  }
  document.getElementById("liststatus").innerHTML = main;
}

function setIdUpdateStt(id, sttName){
  document.getElementById("idOrderUpdate").value = id
  document.getElementById("liststatus").value = sttName
}

async function updateStatusOrder() {
  var id = document.getElementById("idOrderUpdate").value
  var statuso = document.getElementById("liststatus").value
  var url = 'http://localhost:8080/staff/update-status-order?orderStatusName='+statuso+'&id='+id;
  const response = await fetch(url, {
      method: 'POST'
  });
  if (response.status < 300) {
      swal({
          title: "Notification",
          text: "Success",
          type: "success"
      },
      function() {
          $("#statusOrder").modal("hide");
          findAllPOrder();
      });
  }
  else {
      toastr.error("failure");
  }
}
