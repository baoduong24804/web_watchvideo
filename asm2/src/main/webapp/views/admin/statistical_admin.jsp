
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container border">
    <h1 class="text-center text-danger fw-bold">Statistical</h1>
    
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="tab1-tab" data-bs-toggle="tab" data-bs-target="#tab1" type="button" role="tab" aria-controls="tab1" aria-selected="true">Statistical List</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="tab2-tab" data-bs-toggle="tab" data-bs-target="#tab2" type="button" role="tab" aria-controls="tab2" aria-selected="false">UserLiked Video</a>
            </li>
        </ul>
  <div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="tab1" role="tabpanel" aria-labelledby="tab1-tab">
  
       <h3 class="text-center text-danger">Video List</h3>
       <a href="/asm2/views/admin/statistical?action=xuatexcel"  class="btn btn-primary m-2">Export Excel</a>
      <table class="table mt-3">
        <thead>
          <tr>
            <th scope="col">Video ID</th>
            <th scope="col">Video Title</th>
            <th scope="col">URL</th>
            <th scope="col">Share</th>
            <th scope="col">Like</th>
          </tr>
        </thead>
        <tbody>
          <!-- Table rows will be populated here -->
                    <c:forEach items="${list_video }" var="item">
                        <tr>
                        <td>${item.getVideoId() }</td>
                        <td>${item.getTitle() }</td>
                        <td>${item.getUrl() }</td>
                        <td>${item.getShare() }</td>
                        
                        <td>${item.getTotalLike() }</td>
                        
                        </tr>
                        </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="tab2-tab">
    
       <h3 class="text-center text-danger">Favorite User</h3>
      <div class="row mt-3">
        <div class="col-md-12">
          <div class="form-group">
            <label for="videoTitle">Video Title</label>
            <select class="form-control" id="videoTitle" onchange="changeVideoURL()">
              <!-- Option items will be populated here -->
              <option value="" selected="selected">Select Video</option>
              <c:forEach items="${list_video }" var="item">
                       <option value="?videoid=${item.getVideoId() }">${item.getVideoId() }. ${item.getTitle() }</option>
              </c:forEach>
              
            </select>
            <a id="videoLink" href="" target="_blank"></a>
          </div>
        </div>
      </div>
      <table class="table mt-3">
      	<p class="fs-3 fw-bold text-primary">${vi.getTitle() }</p>
        <thead>
          <tr>
          	<th scope="col">UserId</th>
            <th scope="col">Username</th>
            <th scope="col">Email</th>
            <th scope="col">Like Date</th>
          </tr>
        </thead>
        <tbody>
          <!-- Table rows will be populated here -->
          <c:forEach items="${list_user }" var="item">
                        <tr>
                        <td>${item.getUserId() }</td>
                        <td>${item.getUsername() }</td>
                        <td>${item.getEmail() }</td>
                        <td>${item.getLike_date() }</td>
        
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
	  const tabParam = urlParams.get('videoid');
		
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


  function changeVideoURL() {
	  var selectElement = document.getElementById("videoTitle");
	    var selectedValue = selectElement.value;

	    window.location.href = selectedValue;
	   
  }
  
  
  

</script>
