    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="container border">
        <h1 class="text-center text-danger fw-bold">List Video</h1>
        <ul class="nav nav-tabs" id="myTab" role="tablist">
        
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="tab1-tab" data-bs-toggle="tab" data-bs-target="#tab1" type="button" role="tab" aria-controls="tab1" aria-selected="true">VideoLiked</a>
            </li>
          
            
            
            
            
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="tab2-tab" data-bs-toggle="tab" data-bs-target="#tab2" type="button" role="tab" aria-controls="tab2" aria-selected="false">Histories</a>
            </li>
           
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="tab1" role="tabpanel" aria-labelledby="tab1-tab">
                <div class="row mt-3">
                
                    <div class="col-sm-12">
                        <h3 class="text-center text-danger">VideoLiked</h3>
                        
						<table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Video ID</th>
                            <th scope="col">Video Title</th>
                            <th scope="col">URL</th>
                            <th scope="col">Description</th>
                      	    <th scope="col">Liked Date</th>
                            
                            <th scope="col">Like</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Video list items will be populated here -->
                        <c:forEach items="${list }" var="item">
                        <tr>
                   
                      
                                                
                        <td>${item.getVideoId() }</td>
                        <td>${item.getTitle() }</td>
                        <td>${item.getUrl() }</td>
                        <td>${item.getMes() }</td>
                        <td>${item.getLike_date() }</td>
                        <td>
                        <a href="/asm2/views/user/video?videoid=${item.getVideoId() }" class="btn btn-primary">Unlike</a>
                        </td>
                    
                   

                       

                        </tr>
                        </c:forEach>
                        
                       
                    </tbody>
                </table>
                
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="tab2-tab">
                <h3 class="text-center text-danger mt-3">Histories</h3>
                <table class="table">
                    <thead>
                        <tr>
                                           <th scope="col">Video ID</th>
                            <th scope="col">Video Title</th>
                            <th scope="col">URL</th>
                            <th scope="col">Description</th>
                      	    <th scope="col">View Date</th>
                       
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Video list items will be populated here -->
                        <c:forEach items="${list_history }" var="item">
                        <tr>
        			  <td>${item.getVideoId() }</td>
                        <td>${item.getTitle() }</td>
                        <td>${item.getUrl() }</td>
                        <td>${item.getMes() }</td>
                        <td>${item.getView_date() }</td>
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

