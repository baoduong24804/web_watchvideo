<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container border">
    <h1 class="text-center text-danger fw-bold">User Management</h1>
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="tab1-tab" data-bs-toggle="tab" data-bs-target="#tab1" type="button" role="tab" aria-controls="tab1" aria-selected="true">User Edition</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="tab2-tab" data-bs-toggle="tab" data-bs-target="#tab2" type="button" role="tab" aria-controls="tab2" aria-selected="false">User List</a>
            </li>
        </ul>
  <div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="tab1" role="tabpanel" aria-labelledby="tab1-tab">
      
      <div class="row mt-3">
        <div class="col-sm-12">
        <h3 class="text-center text-danger">User Edition</h3>
        <p class="text-success fw-bold" id="message">${mes }</p>
        <p class="text-danger fw-bold" id="message">${mes1 }</p>
        <form action="/asm2/views/admin/user">
        <div class="mb-3 form-group">
            <label for="userName">UserId</label>
            <input type="text" class="form-control" name="UserId" value="${user.getUserId() }" id="userId" placeholder="UserId">
          </div>
          <div class="mb-3 form-group">
            <label for="userName">Username</label>
            <input type="text" class="form-control" name="Username" value="${user.getUsername() }" id="userName" placeholder="Username">
          </div>
          <div class="mb-3 form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="Password" value="${user.getPassword() }" id="password" placeholder="Password">
          </div>
          <div class="mb-3 form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="Email" value="${user.getEmail() }" id="email" placeholder="Email">
          </div>
          <div class="mb-3 form-check">
            <input type="checkbox" name="check" value="1" class="form-check-input" ${user.getOnline() ? 'checked' : ''} id="online">
            <label class="form-check-label" for="online">Online</label>
          </div>
          <div class="text-center mb-3">
          <button type="submit" name="btn" value="Update" class="btn btn-primary mt-3">Update</button>
          <button type="submit" name="btn" value="Reset" class="btn btn-danger mt-3">Reset</button>
          </div>
            </form>
        </div>
      
      </div>
    </div>
    <div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="tab2-tab">
      <h3 class="text-center text-danger">User List</h3>
      <form class="d-flex form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2 w-75" type="search" name="input_search" placeholder="Search" aria-label="Search">
      <div class="ms-2 me-2">
      <input type="radio" name="by" checked="checked" value="id"> Id
      </div>
      <div class="ms-2 me-2">
      <input type="radio" name="by" value="email"> Email
      </div>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
     
    </form>
    <a href="/asm2/views/admin/user?action=xuatexcel"  class="btn btn-primary m-2">Export Excel</a>
      <table class="table mt-3">
        <thead>
          <tr>
            <th scope="col">UserId</th>
            <th scope="col">Username</th>
            <th scope="col">Password</th>
            <th scope="col">Email</th>
           
            <th scope="col">Online</th>
            <th scope="col">Edit</th>
          </tr>
        </thead>
        <tbody>
          <!-- Table rows will be populated here -->
          <c:forEach items="${list_user }" var="item">
                        <tr>
                        <td>${item.getUserId() }</td>
                        <td>${item.getUsername() }</td>
                        <td>${item.getPassword() }</td>
                        <td>${item.getEmail() }</td>
                        
                        <td>${item.getOnline() }</td>
                        <td>
                        <a href="/asm2/views/admin/user?userid=${item.getUserId() }" class="btn btn-primary">Edit</a>
                        </td>
                        </tr>
                        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script>
window.addEventListener("popstate", handleURLChange());
//window.addEventListener("hashchange", handleURLChange());

function handleURLChange() {
	 // Lấy giá trị của tham số 'tab' từ URL
	
	  const urlParams = new URLSearchParams(window.location.search);
	  const tabParam = urlParams.get('input_search');
		
	  // Kiểm tra nếu tham số 'tab' có giá trị là 'tab2'
	  if (tabParam != null) {
	  	// Ẩn tab 1
	      const tab1 = document.getElementById('tab1');
	      const tab1Tab = document.getElementById('tab1-tab');
	      tab1.classList.remove('show', 'active');
	      tab1Tab.classList.remove('active');
	    // Kích hoạt tab 2
	    const tab2 = document.getElementById('tab2');
	    const tab2Tab = document.getElementById('tab2-tab');
	    tab2.classList.add('show', 'active');
	    tab2Tab.classList.add('active');
	  }
}
</script>
