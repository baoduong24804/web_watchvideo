<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style>
a{
    text-decoration: none;
    color: black;
}

.row{
    margin-left: 75.5px;
    margin-right: 75.5px;
}

section{
    padding-top: 24px;
}

article{
    padding-left: 24px;
}

/* .video-chitiet{
    position: relative;
    border-radius: 15px;
    width: 100%;
    padding-bottom: 50%;
    background-color: black;
} */

.info-kenh{
    display: inline-block;
}

.btn-dangky-kenh{
    border: none;
    margin-left: 2%;
    
    height: 3.5vh;
    width: 4.5vw;
    border-radius: 18px;
}

.btn-dangky-kenh:hover{
    opacity: 0.8;
}

.btn{
    background-color: rgb(236, 236, 236);
    border-radius: 18px;
}

.btn:hover{
    background-color: rgb(211, 211, 211);
}

.btn-like{
    border: 0 1px 0 0 solid black;
}

.vertical-divider {
    border-left: 1px solid #000; /* Màu và chiều dày của đường gạch */
    height: 40px; /* Chiều cao của thanh gạch */
    margin: 0 1px;
}

.btn-space-10{
    margin: 0 3px;
}

.mota-video{
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 20px;
    margin-top: 20px;
    background-color: rgb(236, 236, 236);
}

.mota-video p{
    color: grey;
}

.show-more-btn{
    border: none;
    margin: 0;
    padding: 0;
}

.comments {
    margin-top: 20px;
}

.comment {
    margin-bottom: 10px;
}

.item {
    margin-bottom: 50px;
}

.item-image {
    margin-right: 8px; /* Khoảng cách giữa hình ảnh và nội dung */
    height: 94px; /* Chiều cao tự động điều chỉnh */
    width: 168px;/* Độ rộng của hình ảnh */
    float: left; /* Đặt hình ảnh bên trái */
    border: 1px solid black;
    border-radius: 10px;
}

.item-info {
    overflow: hidden; /* Tránh tràn bị overflow của nội dung */
}

.item-info h4 {
    margin-top: 0; /* Xóa margin top của tiêu đề */
    margin-bottom: 0;
}

.item-info p{
    opacity: 0.5;
    margin-bottom: 0;
}

.btn-expand {
    position: absolute;
    bottom: 1%;
    right: 4%;
    color: #fff;
    margin-right: 10px; /* Khoảng cách giữa các nút */
}

/* .btn-fullscreen {
    position: absolute;
    bottom: 1%;
    right: 1%;
    background-color: #007bff; 
    color: #fff; 
    border: none; 
} */

/* .btn-fullscreen:hover, .btn-expand:hover{
    color: white; 
    opacity: 0.8;
} */

/* .video-chitiet.fullscreen {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 100; 
} */
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Icon -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">

</head>
<body>
    <div class="container">
        <section class="row">
            <article class="col-md-8">
            <div>
            <a href="/asm2/views/index" class="btn btn-primary m-2">Trang chủ</a>
            </div>
            
                <div class="video-chitiet">
					
                    <iframe style="width: 100%;" height="540"
                        src="https://www.youtube.com/embed/${video.getUrl() }" title="YouTube video player"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <!-- <button class="btn btn-expand bg-black" ng-click="toggleArticleExpansion()">
                        <i class="bi bi-arrows-angle-expand" ng-show="!isArticleExpanded"></i>
                        <i class="bi bi-arrows-angle-contract" ng-show="isArticleExpanded"></i>
                    </button>
                    <button class="btn btn-fullscreen bg-black" ng-click="toggleFullscreen()">
                        <i class="bi bi-fullscreen" ng-show="!isFullscreen"></i>
                        <i class="bi bi-fullscreen-exit" ng-show="isFullscreen"></i>
                    </button> -->
                </div>

                <div class="info-video mt-2">
                    <h3>${video.getTitle()}</h3>
                    <a href="#"><img src="images/logo.png" class="logo-kenh" alt="" height="50"
                            style="margin-bottom: 30px;"></a>
                    <div class="info-kenh">
                        <h4 style="margin-bottom:   0;">Youtube</h4>
                        <p style="margin-bottom: 0;">0 Số người đăng ký</p>
                    </div>
                    <button class="btn-dangky-kenh bg-black text-white">Đăng ký</button>

                    <div class="tt-video float-end">
                        <div class="btn-group like-dislike btn-space-3">
                            <a href="<c:url value='/views/video?action=like&id=${video.getVideoId() }'/>">
                             
                      <button id="likeOrUnlikeBtn" class="btn btn-primary tm-btn-big" onclick="toggleLike()">
   						 <c:choose>
    				    <c:when test="${flagLikedBtn == true}">
     				       Unlike
   					     </c:when>
 				       <c:otherwise>Like</c:otherwise>
  					  </c:choose>
						</button>
                       
                            </a>
                            	
                        </div>
                       <a href="<c:url value='/views/video?action=share&id=${video.getVideoId() }'/>">
                        <button onclick="copyToClipboard()" type="button" class="btn btn-lighty btn-space-3"><i class="bi bi-share"></i> Chia
                            sẻ</button>
                        </a>
                        <button type="button" class="btn btn-lighty btn-space-3"><i class="bi bi-download"></i> Tải
                            xuống</button>
                        <button type="button" class="btn btn-lighty btn-space-3"><i class="bi bi-scissors"></i> Tạo đoạn
                            video</button>
                        <button type="button" class="btn btn-lighty btn-space-3">...</button>
                    </div>

                    <div class="mota-video" id="motaVideo">
                        <h4 style="margin-top: 0;">Mô tả</h4>
                        <!-- Sử dụng ng-show để kiểm soát việc hiển thị mô tả ngắn hoặc đầy đủ -->
                        <p>${video.getDescription() }</p>
                        <!-- Nút để điều khiển việc rút ngắn và hiển thị đầy đủ mô tả -->
                        <button class="show-more-btn" ng-click="toggleDescription()">showMoreText </button>
                    </div>
                    <div class="comments">
                        <h4>Comments</h4>
                        <textarea class="form-control" ng-model="newComment"
                            placeholder="Write your comment here..."></textarea>
                        <button class="btn mt-2 text-black float-end" ng-click="addComment()">Comment</button>
                        <button class="btn mt-2 text-black float-end" ng-click="cancelComment()">Cancel</button>
                        <div class="mt-3">
                            <div class="comment">
                                <p> comment </p>
                                <hr>
                            </div>
                            <div>
                                mes
                            </div>
                        </div>
                    </div>
                </div>
            </article>
            <aside class="col-md-4">
            
            <c:forEach items="${list_video }" var="vd">
             
                            <div class="item">
                            <a style="text-decoration: none;" class="text-black" href="<c:url value='/views/video?action=watch&id=${vd.getVideoId() }'></c:url>">
                            <img class="item-image" src="${vd.getPoster() }" alt="">
                             
                       
                         <div class="item-info">
                       
                            <h4>${vd.getTitle() }</h4>
                      
                        
                            <p> Youtube </p>
                        
                        <p>item.luotxem - item.ngaydang</p>
                    </div>
                            </a>
                   
                </div>
            </c:forEach>

            </aside>
        </section>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
    function toggleLike() {
        var likeBtn = document.getElementById('likeOrUnlikeBtn');
        if (likeBtn.innerHTML.trim() === 'Like') {
            likeBtn.innerHTML = 'Unlike';
            // Thực hiện hành động Like ở đây (có thể gửi yêu cầu AJAX đến máy chủ để cập nhật trạng thái)
        } else {
            likeBtn.innerHTML = 'Like';
            // Thực hiện hành động Unlike ở đây (có thể gửi yêu cầu AJAX đến máy chủ để cập nhật trạng thái)
        }
    }
</script>
<script>
    function copyToClipboard() {
        var currentURL = window.location.href;
        
        var tempInput = document.createElement("input");
        tempInput.value = currentURL;
        document.body.appendChild(tempInput);
        tempInput.select();
        document.execCommand("copy");
        document.body.removeChild(tempInput);
        
        alert("Đường dẫn đã được sao chép vào clipboard!");
    }
</script>
</body>
</html>