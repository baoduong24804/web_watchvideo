    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="container border">
        <h1 class="text-center text-danger fw-bold">Video Management</h1>
        <ul class="nav nav-tabs" id="myTab" role="tablist">
        
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="tab1-tab" data-bs-toggle="tab" data-bs-target="#tab1" type="button" role="tab" aria-controls="tab1" aria-selected="true">Video Edition</a>
            </li>
          
            
            
            
            
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="tab2-tab" data-bs-toggle="tab" data-bs-target="#tab2" type="button" role="tab" aria-controls="tab2" aria-selected="false">Video List</a>
            </li>
           
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="tab1" role="tabpanel" aria-labelledby="tab1-tab">
                <div class="row mt-3">
                
                    <div class="col-sm-12">
                        <h3 class="text-center text-danger">Video Edition</h3>
                        <p class="text-success fw-bold" id="message">${mes }</p>
                        <p class="text-danger fw-bold" id="message">${mes1 }</p>
                        <form action="/asm2/views/admin/video">
                            <div class="mb-3">
                            <label for="videoId" class="form-label">VideoId</label>
                            <input type="text" name="VideoId" class="form-control" id="videoId" value="${video.getVideoId() }" placeholder="VideoId">
                        </div>
                        <div class="mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" name="Title" class="form-control" id="title" value="${video.getTitle() }" placeholder="Title">
                        </div>
                        <div class="mb-3">
                            <label for="poster" class="form-label">Poster</label>
                            <input type="text" name="Poster" class="form-control" id="poster" value="${video.getPoster() }" placeholder="Poster URL">
                        </div>
                        <div class="mb-3">
                            <label for="videoId" class="form-label">URL</label>
                            <input type="text" name="URL" class="form-control" id="videoId" value="${video.getUrl() }" placeholder="URL">
                        </div>
						<div class="mb-3 form-check">
						    <input type="radio" name="check" value="1" class="form-check-input" id="active" ${video.getOnline() ? 'checked' : ''}>
						    <label class="form-check-label" for="active">Active</label>
						</div>
						<div class="mb-3 form-check">
						    <input type="radio" name="check" value="0" class="form-check-input" id="Inactive" ${!video.getOnline() ? 'checked' : ''}>
						    <label class="form-check-label" for="Inactive">Inactive</label>
						</div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <textarea class="form-control" name="Description" id="description" rows="3" placeholder="Description">${video.getDescription() }</textarea>
                        </div>
                      <div class="text-center mb-3">
                      
                        <button type="submit" name="btn" value="Create" class="btn btn-primary">Create</button>
                        
                        <button type="submit" name="btn" value="Update" class="btn btn-success">Update</button>
                        <button type="submit" name="btn" value="Reset" class="btn btn-warning">Reset</button>
                      

                      </div>
                      </form>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="tab2-tab">
                <h3 class="text-center text-danger mt-3">Video List</h3>
                      <form class="d-flex form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2 w-75" type="search" name="input_search" placeholder="Search" aria-label="Search">
      <div class="ms-2 me-2">
      <input type="radio" name="by" checked="checked" value="id"> Id
      </div>
      <div class="ms-2 me-2">
      <input type="radio" name="by" value="title"> Title
      </div>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
     
    </form>
    <a href="/asm2/views/admin/video?action=xuatexcel"  class="btn btn-primary m-2">Export Excel</a>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Video ID</th>
                            <th scope="col">Video Title</th>
                            <th scope="col">URL</th>
                            <th scope="col">Description</th>
                            <th scope="col">Online</th>
                            
                            <th scope="col">Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Video list items will be populated here -->
                        <c:forEach items="${list_video }" var="item">
                        <tr>
                        <td>${item.getVideoId() }</td>
                        <td>${item.getTitle() }</td>
                        <td>${item.getUrl() }</td>
                        <td>${item.getDescription() }</td>
                        <td>${item.getOnline() }</td>
                        <td>
                        <a href="/asm2/views/admin/video?videoid=${item.getVideoId() }" class="btn btn-primary">Edit</a>
                        </td>
                        </tr>
                        </c:forEach>
                        
                       
                    </tbody>
                </table>
            </div>
        </div>
   

    

  
    <!-- 
      <script>
 // Gửi yêu cầu Ajax khi tab được chọn
    $('#tab1-tab').click(function() {
    	var tabUrl = '/asm2/views/admin/video?tab=1';
        $.ajax({
            url: tabUrl,
            type: 'GET',
            data: { tab: '1' },
            success: function(response) {
                // Xử lý phản hồi từ servlet
                // Ví dụ: Cập nhật nội dung của trang
                $('#content').html(response);
             // Thay đổi URL trong trình duyệt
                history.pushState(null, null, tabUrl);
            },
            error: function(xhr, status, error) {
                // Xử lý lỗi nếu có
                //console.log('Có lỗi xảy ra: ' + error);
            }
        });
    });

    $('#tab2-tab').click(function() {
    	var tabUrl = '/asm2/views/admin/video?tab=2';
        $.ajax({
            url: tabUrl,
            type: 'GET',
            data: { tab: '2' },
            success: function(response) {
                // Xử lý phản hồi từ servlet
                // Ví dụ: Cập nhật nội dung của trang
                $('#content').html(response);
             // Thay đổi URL trong trình duyệt
                history.pushState(null, null, tabUrl);
            },
            error: function(xhr, status, error) {
                // Xử lý lỗi nếu có
                //console.log('Có lỗi xảy ra: ' + error);
            }
        });
    });
	</script>
     -->
  
    
<!-- 
    <script>
 // Lấy các phần tử tab bằng id
    var tab1 = document.getElementById('tab1-tab');
    var tab2 = document.getElementById('tab2-tab');

    // Gắn sự kiện click cho tab1
    tab1.addEventListener('click', function() {
        // Thay đổi URL thành "/video?tab=1"
        window.history.pushState(null, null, '/asm2/views/admin/video?tab=1');
    });

    // Gắn sự kiện click cho tab2
    tab2.addEventListener('click', function() {
        // Thay đổi URL thành "/video?tab=2"
        window.history.pushState(null, null, '/asm2/views/admin/video?tab=2');
    });
	</script>
 -->
 
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
 

