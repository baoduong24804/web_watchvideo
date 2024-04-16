 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- Icon -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
</head>

<style>
    .navbar-brand {
      margin-right: auto;
      margin-left: 10px;
    }
    .offcanvas {
      margin-top: 56px;
    }
    .navbar-toggler {
      width: 40px;
      margin-top: 5px;
      font-size: 12px;
      border-radius: 45%; /* Áp dụng viền hình tròn */
    }

    .search-input {
      border: none;
      border-top-left-radius: 30px;
      border-bottom-left-radius: 30px;
      height: 40px;
      padding-left: 20px;
      outline: none; /* Xóa border khi input được focus */
    }

    .search-button {
      border-top-right-radius: 30px;
      border-bottom-right-radius: 30px;
      border: none;
      background-color: rgb(206, 203, 203);
      width: 70px;
      height: 40px;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
      border: 1px solid rgb(159, 153, 153);
    }

    .search-button i {
      font-size: 20px;
    }
    .account img {
      margin-top: -8px;
    }
    aside {
      position: fixed;
      top: 0;
      z-index: 1000;
    }
    ::-webkit-scrollbar {
  width: 8px; /* Độ rộng của thanh cuộn */
}
::-webkit-scrollbar-thumb {
  background-color: #888;
  border-radius: 4px;
}
::-webkit-scrollbar-thumb:hover {
  background-color: #555;
}


section:last-child {
  z-index: 0;
}
.video-clip{
  width: 300px;
  
}
.video-clip .img-title img{
  border-radius: 15px;
}
@media screen and (max-width:767px) {
  .col-md-1{
    display: none;
  }
  .search-form{
    display: none !important;
  }
  .information{
    position: absolute;
  }
  
}
@media screen and (max-width:300px) {
  .information{
    display: none !important;
  }
}

  </style>
<body>


  <div class="container-fluid">
 	   <section style="height: 60px;">
      <div class="row bg-white fixed-top">
        <div class="col-md-3">
          <nav class="navbar">
            <div class="container-fluid">
              <button
                class="navbar-toggler border-white"
                type="button"
                data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasScrolling"
                aria-controls="offcanvasScrolling"
                aria-label="Toggle navigation"
              >
                <span
                  class="navbar-toggler-icon mx-auto"
                  style="color: gray"
                ></span>
              </button>
              <a class="navbar-brand text-white" href="#">
                <img
                  src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/YouTube_full-color_icon_(2017).svg/2560px-YouTube_full-color_icon_(2017).svg.png"
                  class="img-fluid"
                  width="40px"
                  style="color: white"
                />
                <span
                  class="country text-black"
                  style="font-size: 12px; position: relative; bottom: 10px"
                  >VN</span
                >
              </a>
              <div
                class="offcanvas offcanvas-start"
                data-bs-scroll="true"
                data-bs-backdrop="false"
                tabindex="-1"
                id="offcanvasScrolling"
                aria-labelledby="offcanvasScrollingLabel"
                style="width: 280px"
              >
                <div class="offcanvas-body">
                  <div class="row">
                    <div class="col-md-2">
                      <svg
                      xmlns="http://www.w3.org/2000/svg"
                      enable-background="new 0 0 24 24"
                      height="24"
                      viewBox="0 0 24 24"
                      width="24"
                      focusable="false"
                      style="pointer-events: none; display: inherit"
                    >
                      <g>
                        <path d="M4 21V10.08l8-6.96 8 6.96V21h-6v-6h-4v6H4z"></path>
                      </g>
                    </svg>
                  </div>
                  <div class="col-md-10 fw-bold">
                    <span>Trang Chủ</span>
                  </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <svg
                xmlns="http://www.w3.org/2000/svg"
                height="24"
                viewBox="0 0 24 24"
                width="24"
                focusable="false"
                style="pointer-events: none; display: inherit"
              >
                <path
                  d="M10 14.65v-5.3L15 12l-5 2.65zm7.77-4.33-1.2-.5L18 9.06c1.84-.96 2.53-3.23 1.56-5.06s-3.24-2.53-5.07-1.56L6 6.94c-1.29.68-2.07 2.04-2 3.49.07 1.42.93 2.67 2.22 3.25.03.01 1.2.5 1.2.5L6 14.93c-1.83.97-2.53 3.24-1.56 5.07.97 1.83 3.24 2.53 5.07 1.56l8.5-4.5c1.29-.68 2.06-2.04 1.99-3.49-.07-1.42-.94-2.68-2.23-3.25zm-.23 5.86-8.5 4.5c-1.34.71-3.01.2-3.72-1.14-.71-1.34-.2-3.01 1.14-3.72l2.04-1.08v-1.21l-.69-.28-1.11-.46c-.99-.41-1.65-1.35-1.7-2.41-.05-1.06.52-2.06 1.46-2.56l8.5-4.5c1.34-.71 3.01-.2 3.72 1.14.71 1.34.2 3.01-1.14 3.72L15.5 9.26v1.21l1.8.74c.99.41 1.65 1.35 1.7 2.41.05 1.06-.52 2.06-1.46 2.56z"
                ></path>
              </svg>
                  </div>
                  <div class="col-md-10 fw-bold">
                    <span>Shorts</span>
                  </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <svg
                      xmlns="http://www.w3.org/2000/svg"
                      enable-background="new 0 0 24 24"
                      height="24"
                      viewBox="0 0 24 24"
                      width="24"
                      focusable="false"
                      style="pointer-events: none; display: inherit"
                    >
                      <path
                        d="M10 18v-6l5 3-5 3zm7-15H7v1h10V3zm3 3H4v1h16V6zm2 3H2v12h20V9zM3 10h18v10H3V10z"
                      ></path>
                    </svg>
                  </div>
                  <div class="col-md-10 fw-bold">
                    <span>Kênh đăng ký</span>
                  </div>
                  </div>
                  <hr>
                  <h5 class="fw-bold">Bạn</h5>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" focusable="false" style="pointer-events: none; display: inherit;">
                        <path d="M3,3v18h18V3H3z M4.99,20c0.39-2.62,2.38-5.1,7.01-5.1s6.62,2.48,7.01,5.1H4.99z M9,10c0-1.65,1.35-3,3-3s3,1.35,3,3 c0,1.65-1.35,3-3,3S9,11.65,9,10z M12.72,13.93C14.58,13.59,16,11.96,16,10c0-2.21-1.79-4-4-4c-2.21,0-4,1.79-4,4 c0,1.96,1.42,3.59,3.28,3.93c-4.42,0.25-6.84,2.8-7.28,6V4h16v15.93C19.56,16.73,17.14,14.18,12.72,13.93z"></path>
                      </svg>
              </svg>
                  </div>
                  <div class="col-md-10 fw-bold">
                    <span>Kênh của bạn</span>
                  </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <svg xmlns="http://www.w3.org/2000/svg" height="24" style="pointer-events: none; display: inherit;" viewBox="0 0 24 24" width="24" focusable="false"><g><path d="M14.97 16.95 10 13.87V7h2v5.76l4.03 2.49-1.06 1.7zM22 12c0 5.51-4.49 10-10 10S2 17.51 2 12h1c0 4.96 4.04 9 9 9s9-4.04 9-9-4.04-9-9-9C8.81 3 5.92 4.64 4.28 7.38c-.11.18-.22.37-.31.56L3.94 8H8v1H1.96V3h1v4.74c.04-.09.07-.17.11-.25.11-.22.23-.42.35-.63C5.22 3.86 8.51 2 12 2c5.51 0 10 4.49 10 10z"></path></g></svg>
              </svg>
                  </div>
                  <div class="col-md-10 fw-bold">
                    <span>Video đã xem</span>
                  </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24" viewBox="0 0 24 24" width="24" focusable="false" style="pointer-events: none; display: inherit;"><path d="m10 8 6 4-6 4V8zm11-5v18H3V3h18zm-1 1H4v16h16V4z"></path></svg>
                  </div>
                  <div class="col-md-10 fw-bold">
                    <span>Video của bạn</span>
                  </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24" focusable="false" style="pointer-events: none; display: inherit;"><path d="M14.97 16.95 10 13.87V7h2v5.76l4.03 2.49-1.06 1.7zM12 3c-4.96 0-9 4.04-9 9s4.04 9 9 9 9-4.04 9-9-4.04-9-9-9m0-1c5.52 0 10 4.48 10 10s-4.48 10-10 10S2 17.52 2 12 6.48 2 12 2z"></path></svg>                  </div>
                  <div class="col-md-10 fw-bold">
                    <span>Xem sau</span>
                  </div>
                  </div>
                  <hr>
                  <h5 class="fw-bold">Kênh đăng ký</h5>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <img id="img" draggable="false" class="style-scope yt-img-shadow rounded-circle" height="24" width="24" alt="" src="https://yt3.ggpht.com/ytc/AIdro_kU6zYXtTUBeM5yBlPkn9wLiiImQx8v-6Qz4WwMcw=s88-c-k-c0x00ffffff-no-rj">
                    </div>
                  <div class="col-md-10 fw-bold">
                    <span>Coffin</span>
                  </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <img id="img" draggable="false" class="style-scope yt-img-shadow rounded-circle" height="24" width="24" alt="" src="https://yt3.ggpht.com/OdhARr7ONXGpp5CNuaeM6F0G5BSf041L8b7l0wtp9WCZfkOK2psFal2miJIzLbgM72_E7SWljw=s88-c-k-c0x00ffffff-no-rj">                    </div>
                  <div class="col-md-10 fw-bold">
                    <span>FAP TV</span>
                  </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-md-2">
                      <img id="img" draggable="false" class="style-scope yt-img-shadow rounded-circle" height="24" width="24" alt="" src="https://yt3.ggpht.com/ytc/AIdro_mt0YW7EKVz8GNMrNv--0Ofy2rKRvbJmjKYAO_BAsE=s88-c-k-c0x00ffffff-no-rj"></div>
                  <div class="col-md-10 fw-bold">
                    <span>WWE</span>
                  </div>
                </div>
                <hr>
                <h5 class="fw-bold">Khám phá</h5>
                <div class="row mt-3">
                  <div class="col-md-2">
                    <svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24" viewBox="0 0 24 24" width="24" focusable="false" style="pointer-events: none; display: inherit; width: 100%; height: 100%;"><path d="M19 3.87v9.77C19 17.7 15.86 21 12 21s-7-3.3-7-7.37v-.13c0-1.06.22-2.13.62-3.09.5-1.19 1.29-2.21 2.27-2.97.85-.66 1.83-1.14 2.87-1.65.39-.19.77-.38 1.15-.58.36-.19.72-.38 1.08-.56v3.22l1.55-1.04L19 3.87M20 2l-6 4V3c-.85.44-1.7.88-2.55 1.33-1.41.74-2.9 1.34-4.17 2.32-1.13.87-2.02 2.05-2.58 3.37-.46 1.09-.7 2.29-.7 3.48v.14C4 18.26 7.58 22 12 22s8-3.74 8-8.36V2zM9.45 12.89 14 10v5.7c0 1.82-1.34 3.3-3 3.3s-3-1.47-3-3.3c0-1.19.58-2.23 1.45-2.81z"></path></svg>
                 </div>
                <div class="col-md-10 fw-bold">
                  <span>Thịnh hành</span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-md-2">
                  <svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24" viewBox="0 0 24 24" width="24" focusable="false" style="pointer-events: none; display: inherit; width: 100%; height: 100%;"><path d="M12 4v9.38c-.73-.84-1.8-1.38-3-1.38-2.21 0-4 1.79-4 4s1.79 4 4 4 4-1.79 4-4V8h6V4h-7zM9 19c-1.66 0-3-1.34-3-3s1.34-3 3-3 3 1.34 3 3-1.34 3-3 3zm9-12h-5V5h5v2z"></path></svg>
                </div>
              <div class="col-md-10 fw-bold">
                <span>Âm nhạc</span>
              </div>
            </div>
            <div class="row mt-3">
              <div class="col-md-2">
                <svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24" viewBox="0 0 24 24" width="24" focusable="false" style="pointer-events: none; display: inherit; width: 100%; height: 100%;"><path d="M10 12H8v2H6v-2H4v-2h2V8h2v2h2v2zm7 .5c0-.83-.67-1.5-1.5-1.5s-1.5.67-1.5 1.5.67 1.5 1.5 1.5 1.5-.67 1.5-1.5zm3-3c0-.83-.67-1.5-1.5-1.5S17 8.67 17 9.5s.67 1.5 1.5 1.5 1.5-.67 1.5-1.5zm-3.03-4.35-4.5 2.53-.49.27-.49-.27-4.5-2.53L3 7.39v6.43l8.98 5.04 8.98-5.04V7.39l-3.99-2.24m0-1.15 4.99 2.8v7.6L11.98 20 2 14.4V6.8L6.99 4l4.99 2.8L16.97 4z"></path></svg>
                            </div>
            <div class="col-md-10 fw-bold">
              <span>Trò chơi</span>
            </div>
          </div>
              </div>
            </div>
          </nav>
        </div>
        <div class="col-md-7 d-flex align-items-center justify-content-center">
          <form action="/asm2/views/index" class="search-form d-flex" role="search">
            <input name="input_search" class="search-input" style="flex-grow: 1;width: 500px;border: 1px solid rgb(206, 203, 203);" type="search" placeholder="Search" aria-label="Search"/>
            <button type="submit" class="search-button">
              <i class="bi bi-search"></i>
            </button>
            <button
              type="submit"
              style="
                margin-left: 10px;
                border-radius: 50%;
                font-size: 24px;
                border: 1px solid rgb(206, 203, 203);
              "
            >
              <i class="bi bi-mic-fill"></i>
            </button>
          </form>
        </div>

        <div class="col-md-2 d-flex justify-content-end information">
        <div>
        <c:choose>
        <c:when test="${not empty sessionScope.currentUser }">
        <a href="/asm2/views/logout" class="btn btn-primary m-2" style="white-space: nowrap;">Đăng xuất,${sessionScope.currentUser.getUsername() }</a>
        </c:when>
        <c:otherwise>
        <a href="/asm2/views/Account?action=dang-nhap" class="btn btn-primary m-2" style="white-space: nowrap;">Đăng nhập/Đăng ký</a>
        </c:otherwise>
        </c:choose>
      
        </div>
          <div class="create-video m-3">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              height="24"
              style="pointer-events: none; display: inherit"
              viewBox="0 0 24 24"
              width="24"
              focusable="false"
            >
              <path
                d="M14 13h-3v3H9v-3H6v-2h3V8h2v3h3v2zm3-7H3v12h14v-6.39l4 1.83V8.56l-4 1.83V6m1-1v3.83L22 7v8l-4-1.83V19H2V5h16z"
              ></path>
            </svg>
          </div>
          <div class="Notification m-3">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              enable-background="new 0 0 24 24"
              height="24"
              viewBox="0 0 24 24"
              width="24"
              focusable="false"
              style="pointer-events: none; display: inherit"
            >
              <path
                d="M10 20h4c0 1.1-.9 2-2 2s-2-.9-2-2zm10-2.65V19H4v-1.65l2-1.88v-5.15C6 7.4 7.56 5.1 10 4.34v-.38c0-1.42 1.49-2.5 2.99-1.76.65.32 1.01 1.03 1.01 1.76v.39c2.44.75 4 3.06 4 5.98v5.15l2 1.87zm-1 .42-2-1.88v-5.47c0-2.47-1.19-4.36-3.13-5.1-1.26-.53-2.64-.5-3.84.03C8.15 6.11 7 7.99 7 10.42v5.47l-2 1.88V18h14v-.23z"
              ></path>
            </svg>
          </div>
          <div class="account m-3">
         
            <img
              id="img"
              draggable="false"
              class="style-scope yt-img-shadow rounded-circle"
              alt="Hình ảnh đại diện"
              height="32"
              width="32"
              src="https://yt3.ggpht.com/yti/ANjgQV_SrRAY9ED9CTdDBge6x7pB66k0HdNY2-GxoIuA9g=s88-c-k-c0x00ffffff-no-rj"
            />
          </div>
        </div>
      </div>
    </section>
    <!-- body -->
  <section style="height: 100px;">
    <div class="row">
  	
    
    <div class="col-md-1">
        <aside id="sidebar" style="display: block;">
          <div class="header-tab">
            <div class="home-collections text-center mt-5">
              <br />
              <a href="#" class="text-decoration-none text-black" style="font-size: 14px;">
                <span
                  ><svg
                    xmlns="http://www.w3.org/2000/svg"
                    enable-background="new 0 0 24 24"
                    height="24"
                    viewBox="0 0 24 24"
                    width="24"
                    focusable="false"
                    style="pointer-events: none; display: inherit"
                  >
                    <g>
                      <path d="M4 21V10.08l8-6.96 8 6.96V21h-6v-6h-4v6H4z"></path>
                    </g>
                  </svg>
                  <br />Trang chủ</span
                >
              </a>
            </div>
            <br />
            <div class="short text-center">
              <a href="#" class="text-decoration-none text-black" style="font-size: 14px;">
                <span class="mt-5">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    height="24"
                    viewBox="0 0 24 24"
                    width="24"
                    focusable="false"
                    style="pointer-events: none; display: inherit"
                  >
                    <path
                      d="M10 14.65v-5.3L15 12l-5 2.65zm7.77-4.33-1.2-.5L18 9.06c1.84-.96 2.53-3.23 1.56-5.06s-3.24-2.53-5.07-1.56L6 6.94c-1.29.68-2.07 2.04-2 3.49.07 1.42.93 2.67 2.22 3.25.03.01 1.2.5 1.2.5L6 14.93c-1.83.97-2.53 3.24-1.56 5.07.97 1.83 3.24 2.53 5.07 1.56l8.5-4.5c1.29-.68 2.06-2.04 1.99-3.49-.07-1.42-.94-2.68-2.23-3.25zm-.23 5.86-8.5 4.5c-1.34.71-3.01.2-3.72-1.14-.71-1.34-.2-3.01 1.14-3.72l2.04-1.08v-1.21l-.69-.28-1.11-.46c-.99-.41-1.65-1.35-1.7-2.41-.05-1.06.52-2.06 1.46-2.56l8.5-4.5c1.34-.71 3.01-.2 3.72 1.14.71 1.34.2 3.01-1.14 3.72L15.5 9.26v1.21l1.8.74c.99.41 1.65 1.35 1.7 2.41.05 1.06-.52 2.06-1.46 2.56z"
                    ></path>
                  </svg>
                  <br />
                  Shorts</span
                >
              </a>
            </div>
            <br />
            <div class="kenhcuaban text-center">
              <a href="#" class="text-decoration-none text-black" style="font-size: 14px;"
                ><span
                  ><svg
                    xmlns="http://www.w3.org/2000/svg"
                    enable-background="new 0 0 24 24"
                    height="24"
                    viewBox="0 0 24 24"
                    width="24"
                    focusable="false"
                    style="pointer-events: none; display: inherit"
                  >
                    <path
                      d="M10 18v-6l5 3-5 3zm7-15H7v1h10V3zm3 3H4v1h16V6zm2 3H2v12h20V9zM3 10h18v10H3V10z"
                    ></path>
                  </svg>
                  <br />Kênh đã đăng kí</span
                ></a
              >
            </div>
            <br />
            <div class="You text-center">
              <a href="#" class="text-decoration-none text-black" style="font-size: 14px;">
                <span
                  ><svg
                    xmlns="http://www.w3.org/2000/svg"
                    enable-background="new 0 0 24 24"
                    height="24"
                    viewBox="0 0 24 24"
                    width="24"
                    focusable="false"
                    style="pointer-events: none; display: inherit"
                  >
                    <path
                      d="M10 18v-6l5 3-5 3zm7-15H7v1h10V3zm3 3H4v1h16V6zm2 3H2v12h20V9zM3 10h18v10H3V10z"
                    ></path>
                  </svg>
                  <br />
                  You</span
                >
              </a>
            </div>
          </div>
        </aside>

      </div>
     
     <!-- body right -->
     
      <div class="col-md 11">
        <article class="row ms-3 mt-2 container">
        <div class="col-md-12 mb-3 text-center">
        <a href="/asm2/views/index" class="btn btn-primary">Trang chủ</a>

        <c:choose>
        <c:when test="${not empty sessionScope.currentUser }">
      
        <c:if test="${sessionScope.currentUser.getRole() == true}">
            <a href="/asm2/views/admin" class="btn btn-primary">Quản lý (chỉ admin)</a>
        </c:if>
       
                
        <a href="/asm2/views/user/video" class="btn btn-primary">Danh sách Video</a>
        
        </c:when>

        <c:otherwise>
        
        </c:otherwise>
        </c:choose>
        </div>
        
        <c:forEach items="${list_video }" var="video">
        
         <div class="col-md-3 video-clip mb-3">
         <a style="text-decoration: none;" class="text-black" href="<c:url value='/views/video?action=watch&id=${video.getVideoId() }'></c:url>">
         
         
            <div class="img-title">
              <img src="${video.getPoster() }" class="img-fluid mb-3"  style="height: 155px; width: 100%"> <br>
            </div>
            
            <div class="row">
	              <div class="col-md-2">
	                <img id="img" draggable="false" class="style-scope yt-img-shadow rounded-circle" alt="" width="38" src="https://yt3.ggpht.com/2z2U4P9mtaKyG4dHsBc8Ore-v6eEXP1u11RQjKZiQqxAJ3TDkt--vrTYr3IAYNGK7SyODlhm=s68-c-k-c0x00ffffff-no-rj"> 
	              </div>
              
	              <div class="col-md-10">
	                <span class="fw-bold">${video.getTitle() }</span>
	                <br>
	                <span>Actor</span>
	                <br>
	                <span>
	                ${video.getShare() } Share
	                </span>
	              </div>
            </div>
            </a>
          </div>
     
        </c:forEach>
        
        <!-- Hiển thị button phân trang -->
<c:if test="${totalPages > 1}">
  <nav aria-label="Page navigation">
      <ul class="pagination">
          <c:if test="${currentPage > 1}">
              <li class="page-item">
                  <a class="page-link" href="/asm2/views/index?page=${currentPage - 1}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                      <span class="sr-only">Trang trước</span>
                  </a>
              </li>
          </c:if>
  
          <c:forEach begin="1" end="${totalPages}" var="pageNumber">
              <c:choose>
                  <c:when test="${pageNumber eq currentPage}">
                      <li class="page-item active">
                          <a class="page-link" href="/asm2/views/index?page=${pageNumber}">${pageNumber}</a>
                      </li>
                  </c:when>
                  <c:otherwise>
                      <li class="page-item">
                          <a class="page-link" href="/asm2/views/index?page=${pageNumber}">${pageNumber}</a>
                      </li>
                  </c:otherwise>
              </c:choose>
          </c:forEach>
  
          <c:if test="${currentPage < totalPages}">
              <li class="page-item">
                  <a class="page-link" href="/asm2/views/index?page=${currentPage + 1}" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <span class="sr-only">Trang kế tiếp</span>
                  </a>
              </li>
          </c:if>
      </ul>
  </nav>
</c:if>
        
         

<div
				class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
				<c:if test="${currentPage == 1 }">
				<a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
				</c:if>
				<c:if test="${currentPage > 1 }">
					<a href="/asm2/views/index?page=${currentPage - 1}" class="btn btn-primary tm-btn-prev mb-2 ">Previous</a>
				</c:if>
				<div class="tm-paging d-flex">
					<c:forEach varStatus="i" begin ="1" end="${maxPage}"> 
					<a href="/asm2/views/index?page=${i.index}" 
					class="active tm-paging-link ${currentPage == i.index ? 'active' : ''}">${i.index}</a>
					</c:forEach>
				</div>
				<c:if test="${currentPage == maxPage }">
				<a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Next</a>
				</c:if>
				<c:if test="${currentPage < maxPage }">
					<a href="/asm2/views/index?page=${currentPage + 1}" class="btn btn-primary tm-btn-prev mb-2 ">Next</a>
				</c:if>
					
			</div>


        </article>
      </div>
    </div>
  </section>
  </div>

        <script>
          // Hàm để chuyển đổi sự hiển thị của phần aside
          function toggleAside() {
            var sidebar = document.getElementById('sidebar');
            sidebar.style.display = (sidebar.style.display === 'none') ? 'block' : 'none';
          }
      
          // Thêm sự kiện nghe vào nút offcanvas
          document.querySelector('.navbar-toggler').addEventListener('click', toggleAside);
          // Lắng nghe sự kiện khi offcanvas được mở hoặc đóng
	$('#offcanvas').on('show.bs.offcanvas hide.bs.offcanvas', function () {
    // Lấy chiều rộng hiện tại của artical
    var currentWidth = $('.col-md-11').width();

    // Nếu offcanvas đang được mở, thu nhỏ artical
    if ($('#offcanvas').hasClass('show')) {
        $('.col-md-11').css('width', currentWidth - 250); // Giả sử offcanvas có độ rộng là 250px
    } else { // Nếu offcanvas đang được đóng, phục hồi kích thước của artical
        $('.col-md-11').css('width', ''); // Sử dụng kích thước mặc định
    }
});

        </script>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>