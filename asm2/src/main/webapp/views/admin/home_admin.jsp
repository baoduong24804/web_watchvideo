<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style>
    .custom-menu .list-group-item {
      background-color: #f8f9fa;
      border: none;
      border-radius: 0;
      color: #333;
    }

    .custom-menu .list-group-item:hover {
      background-color: #e9ecef;
    }

    .custom-menu .list-group-item.active {
      background-color: #007bff;
      color: #fff;
    }
  </style>
</head>
<body>
  <header class="bg-light">
    <div class="container py-3">
      <h1>Trang Admin</h1>
      <a href="" class="btn btn-primary">Reload</a>
      <a href="/asm2/views/index" class="btn btn-primary">Trang chủ</a>
    </div>
  </header>

  <div class="container">
    <div class="row">
      <div class="col-md-3 border p-2">
        <!-- Menu -->
        <div class="p-1 d-flex flex-nowrap align-items-center">
            <img class="img-fluid w-25 h-25 rounded-circle" style="border: 2px solid black;" src="https://th.bing.com/th/id/OIP.tC-xaYfczNuuja-a3xAQuAHaHa?rs=1&pid=ImgDetMain" alt="">
         
            <span class="ms-2">Name: ${currentUser.getUsername()}</span>
            
            
        </div>
        <div class="list-group custom-menu">
          <a onclick="handleLinkClick()" href="/asm2/views/admin/video" class="list-group-item list-group-item-action mb-2 border">Quản lý Video</a>
          <a onclick="handleLinkClick()" href="/asm2/views/admin/user" class="list-group-item list-group-item-action mb-2 border">Quản lý Người dùng</a>
          <a onclick="handleLinkClick()" href="/asm2/views/admin/statistical" class="list-group-item list-group-item-action mb-2 border">Thống kê</a>
        
        </div>
      </div>
      <div class="col-md-9">
        <!-- Nội dung chức năng -->
	<c:choose>
	  <c:when test="${not empty includeFile}">
	    <jsp:include page="${includeFile }"></jsp:include>
	  </c:when>
	</c:choose>
		
      </div>
    </div>
  </div>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
  
   
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script>
    window.onload = function() {
        // Xóa các thuộc tính khỏi session khi trang được tải lại
        <% 
            HttpSession session3 = request.getSession();
            session.removeAttribute("mes");
            session.removeAttribute("mes1");
        %>
    };

    function handleLinkClick() {
        // Xóa các thuộc tính khỏi session khi nhấp vào thẻ <a>
        <% 
            HttpSession session2 = request.getSession();
            session.removeAttribute("mes");
            session.removeAttribute("mes1");
        %>
    }
</script>
  
</body>
</html>