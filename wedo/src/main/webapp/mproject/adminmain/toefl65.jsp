<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>eLEARNING - eLearning HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->

    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
        <a href="mainAdmin.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
            <h2 style="color:darkblue;"><i class="fa fa-book me-3"></i> We Do </h2>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0" >

                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="font-weight: bold; font-size: 18px;">우리두소개</a>
                    <div class="dropdown-menu fade-down m-0">
                    	<a href="#" class="nav-item nav-link"></a>
                        <a href="teacherMem.jsp" class="dropdown-item">강사진</a>
                        <a href="curriculum.jsp" class="dropdown-item">커리큘럼</a>
                        <a href="whatWeDo.jsp" class="dropdown-item">우리두란?</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="toeic.html" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="font-weight: bold; font-size: 18px;">토익</a>
                    <div class="dropdown-menu fade-down m-0">
                    	<a href="#" class="nav-item nav-link"></a>
                        <a href="toeic600.jsp" class="dropdown-item">600(입문)</a>
                        <a href="toeic700.jsp" class="dropdown-item">700(기본)</a>
                        <a href="toeic800.jsp" class="dropdown-item">800(중급)</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="font-weight: bold; font-size: 18px;">토스&오픽</a>
                    <div class="dropdown-menu fade-down m-0">
                    	<a href="#" class="nav-item nav-link"></a>
                        <a href="tossOpicIM.jsp" class="dropdown-item">IM+(초급)</a>
                        <a href="tossOpicIH.jsp" class="dropdown-item">IH+(기본)</a>
                        <a href="tossOpicAL.jsp" class="dropdown-item">AL+(중급)</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="font-weight: bold; font-size: 18px;">토플</a>
                    <div class="dropdown-menu fade-down m-0">
                    	<a href="#" class="nav-item nav-link"></a>
                        <a href="toefl65.jsp" class="dropdown-item">65점반(입문)</a>
                        <a href="toefl75.jsp" class="dropdown-item">75점반(기본)</a>
                        <a href="toefl85.jsp" class="dropdown-item">85점반(중급)</a>
                    </div>
                </div>
               
                 <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="font-weight: bold; font-size: 18px;">공지사항</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="notice.jsp" class="dropdown-item">공지사항</a>
                    </div>
                </div>
            </div>
            <a href="../adminpages/adIndex.jsp" style="padding-top: 1.5rem !important; padding-bottom: 1.5rem !important; padding-right: 3rem !important;
   			 padding-left: 3rem !important; display: block !important; text-align: center; vertical-align: middle;cursor: pointer; color: #ae6bd7;
    		 user-select: none;">My page<i class="fa fa-arrow-right ms-3"></i>
    		</a>
        </div>
    </nav>
    <!-- Navbar End -->
    <!-- Header Start -->
    <div class="container-fluid bg-primary py-5 mb-5 page-header">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-10 text-center" style="margin-top: 85px;">
                    <h1 class="display-3 text-white animated slideInDown">65점반(입문)</h1>
                   <!--  <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">Testimonial</li>
                        </ol>
                    </nav> -->
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->


   <!-- Section-->
                  <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="../main/img/토플 기초 리딩 이원선 강사.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Hackers Reading Intro</h5><br>
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" target="_blank" onClick="window.open(this.href, '', 'width=1200, height=800');" href="/wedo/classInfoAdmin.do?classNo=C13" >자세히 보기</a></div>
                            </div>
                            
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <!-- Product image-->
                            <img class="card-img-top" src="../main/img/토플 기초 리스닝 이유호 강사.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Hackers Listening Intro</h5><br>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                </div>
                            </div>
                            <!-- Product actions-->
                           <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" target="_blank" onClick="window.open(this.href, '', 'width=1200, height=800');" href="/wedo/classInfoAdmin.do?classNo=C14">자세히 보기</a></div>
                            </div>
                            
                        </div>
                    </div>
                                   </div>
            </div>
        </section>
    <!-- Footer Start -->
  <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Contact</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>대전 중구 계룡로 846 4층 403호</p>
                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>042-222-8202</p>
                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>WeDo@ddit.ac.kr</p>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="copyright">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a class="border-bottom" href="mainAdmin.jsp">We Do</a> 우리도 할 수 있다!
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <div class="footer-menu">
                            <a href="mainAdmin.jsp">Home</a>
                            <a href="notice.jsp">Notice</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>