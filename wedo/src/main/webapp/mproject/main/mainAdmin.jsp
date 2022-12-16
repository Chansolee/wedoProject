<%@page import="kr.or.ddit.wedo.vo.ManagerVO"%>
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
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" style="font-weight: bold; font-size: 18px;">고객센터(공지사항, FAQ)</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="notice.jsp" class="dropdown-item">공지사항</a>
                        <a href="cs.jsp" class="dropdown-item">지원센터</a>
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


    <!-- Carousel Start -->
    <div class="container-fluid p-0 mb-5">
        <div class="owl-carousel header-carousel position-relative">
        <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="img/main4.png" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" > <!-- style="background: rgba(24, 29, 56, .7);" -->
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8" style="margin-left: 300px;">
                               <!--  <h5 class="text-primary text-uppercase mb-3 animated slideInDown" style="padding-left:300px;">We Do it !</h5>
                                <h1 class="display-3 text-white animated slideInDown" style="font-size: 3rem;">우리두와 함께 영어 마스터 하기</h1>
                                <p class="fs-5 text-white mb-4 pb-2" style="padding-left:300px;"">in korea Online</p> -->
                              <!--   <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                <a href="" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Join Now</a> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="img/main2.png" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center"> <!-- style="background: rgba(24, 29, 56, .7);" -->
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8" style="margin-left: 300px;">
                               <!--  <h5 class="text-primary text-uppercase mb-3 animated slideInDown" style="padding-left:300px;">We Do it !</h5>
                                <h1 class="display-3 text-white animated slideInDown" style="font-size: 5rem;">Looking for an english teacher?</h1>
                                <p class="fs-5 text-white mb-4 pb-2" style="padding-left:300px; ">in korea Online</p> -->
                              <!--   <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                <a href="" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Join Now</a> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="img/main3.png" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" > <!-- style="background: rgba(24, 29, 56, .7);" -->
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8" style="margin-left: 300px;">
                               <!--  <h5 class="text-primary text-uppercase mb-3 animated slideInDown" style="padding-left:300px;">We Do it !</h5>
                                <h1 class="display-3 text-white animated slideInDown" style="font-size: 3rem;">우리두와 함께 영어 마스터 하기</h1>
                                <p class="fs-5 text-white mb-4 pb-2" style="padding-left:300px;"">in korea Online</p> -->
                              <!--   <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                <a href="" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Join Now</a> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="img/main1.png" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" > <!-- style="background: rgba(24, 29, 56, .7);" -->
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8" style="margin-left: 300px;">
                               <!--  <h5 class="text-primary text-uppercase mb-3 animated slideInDown" style="padding-left:300px;">We Do it !</h5>
                                <h1 class="display-3 text-white animated slideInDown" style="font-size: 3rem;">우리두와 함께 영어 마스터 하기</h1>
                                <p class="fs-5 text-white mb-4 pb-2" style="padding-left:300px;"">in korea Online</p> -->
                              <!--   <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                <a href="" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Join Now</a> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Carousel End -->


    <!-- Service Start -->
    <div style="margin-top: -55px; background-color: #dfdfdf; padding-bottom: 15px;">
        <div class="container">
            <div class="row g-4">
                <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-graduation-cap" style="color:#778899;"></i>
                            <h5 class="mb-3">시험일정</h5>
                            <a href="https://exam.toeic.co.kr/receipt/examSchList.php" target="_blank" style="color:#778899;">시험일정 바로가기</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-graduation-cap" style="color:#778899;"></i>
                            <h5 class="mb-3">성적확인</h5>
                            <a href="https://exam.toeic.co.kr/common/commonPreLogin.php?returnUrl=/result/scoreList.php" target="_blank" style="color: darkblue;">성적확인 바로가기</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-graduation-cap" style="color:#778899;"></i>
                            <h5 class="mb-3">시험꿀팁</h5>
                            <a href="https://www.youtube.com/watch?v=JDud9Dc47dA" target="_blank" style="color: #778899;">시험꿀팁 바로가기</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                           <i class="fa fa-3x fa-graduation-cap" style="color:#778899;"></i>
                            <h5 class="mb-3">네이버카페</h5>
                            <a href="https://cafe.naver.com/toeicamp" target="_blank" style="color: #778899;">네이버카페 바로가기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Service End -->


    <!-- About Start -->
    <div style="padding-top: 0rem !important; padding-bottom: 2rem !important; width: 90%;
    padding-right: var(--bs-gutter-x, .75rem); padding-left: var(--bs-gutter-x, .75rem); margin-right: auto;
    margin-left: auto; background-color: rgba(223, 223, 223, .4); margin-top: 60px;     border-radius: 165px;" >
        <div class="container" style="margin-top: 30px;">
            <div class="row g-5" style="text-align: center;">
             <!--    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s" style="min-height: 400px;    width: 100%;">
                    <div class="position-relative h-100">
                        <img class="img-fluid position-absolute w-100 h-100" src="img/about.jpg" alt="" style="object-fit: cover;">
                    </div>
                </div> -->
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s" style="min-height: 50px; width: 35%; margin-left: 450px; background-color: rgba(223, 223, 223, .6); border-radius: 56px;
                background-color:rgba(252, 215, 252, 0.6);margin-top: 30px;margin-bottom: -30px; padding: 0px; ">
                    <!-- <h6 class="section-title text-center px-3" style="background-color: rgba(223, 223, 223, 0.6);">공지사항</h6> -->
                    <h3 style="text-align: center; margin-top: 0.5rem;">온라인클래스 안내사항</h3>
                
                </div>
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s" style="min-height: 100px; width: 100%; background-color: rgba(223, 223, 223, .6); border-radius: 56px;">
                    
                    <p class="mb-4" style="text-align: center;"></p>
                    <p class="mb-4"style="text-align: center;"></p>
                    <div class="row gy-2 gx-4 mb-4">
                        <div class="col-sm-6" style="text-align: center;">
                            <p class="mb-0"><i class="fa fa-arrow-right me-2"></i>가나다라</p>
                        </div>
                        <div class="col-sm-6" style="text-align: center;">
                            <p class="mb-0"><i class="fa fa-arrow-right me-2"></i>가나다라</p>
                        </div>
                        <div class="col-sm-6" style="text-align: center;">
                            <p class="mb-0"><i class="fa fa-arrow-right me-2"></i>가나다라</p>
                        </div>
                        <div class="col-sm-6" style="text-align: center;">
                            <p class="mb-0"><i class="fa fa-arrow-right me-2"></i>가나다라</p>
                        </div>
                        <div class="col-sm-6" style="text-align: center;">
                            <p class="mb-0"><i class="fa fa-arrow-right me-2"></i>가나다라</p>
                        </div>
                        <div class="col-sm-6" style="text-align: center;">
                            <p class="mb-0"><i class="fa fa-arrow-right me-2"></i>가나다라</p>
                        </div>
                    </div>
                    <a class="btn  px-5" href="" style="text-align: center; background-color: #f2cb49; border-color: #f2cb49; margin-top: -50px; border-radius: 28px; padding: 10px 10px;">더보기</a>
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->

    <!-- Team Start -->
    
    <div class="container-xxl" style=" padding-top: 3rem !important; padding-bottom: 3rem !important;">
        <div class="container">
            <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                <h6 class="section-title  px-3" style="background-color:rgba(223, 223, 223, .2);">강사진 소개</h6>
                <h1 class="mb-5">스타 강사</h1>
            </div>
            <div class="row g-4">
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="team-item" style="background-color: #dfdfdf !important; padding-top: 40px;">
                        <div class="overflow-hidden">
                            <img class="img-fluid" src="img/team-1.jpg" alt="">
                        </div>
                        <div class="position-relative d-flex justify-content-center" style="margin-top: -23px;">
                            <div class="bg-light d-flex justify-content-center pt-2 px-1">
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h5 class="mb-0">이찬솔</h5>
                            <small>안톤의 점수보장반</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="team-item" style="background-color: #dfdfdf !important; padding-top: 40px;">
                        <div class="overflow-hidden">
                            <img class="img-fluid" src="img/team-2.jpg" alt="">
                        </div>
                        <div class="position-relative d-flex justify-content-center" style="margin-top: -23px;">
                            <div class="bg-light d-flex justify-content-center pt-2 px-1">
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h5 class="mb-0">방형준</h5>
                            <small>방형준의 기초영문법&구문독해</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="team-item" style="background-color: #dfdfdf !important; padding-top: 40px;">
                        <div class="overflow-hidden">
                            <img class="img-fluid" src="img/team-3.jpg" alt="">
                        </div>
                        <div class="position-relative d-flex justify-content-center" style="margin-top: -23px;">
                            <div class="bg-light d-flex justify-content-center pt-2 px-1">
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h5 class="mb-0">오용택</h5>
                            <small>용택쌤의 왕기초 종합반</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.7s">
                    <div class="team-item" style="background-color: #dfdfdf !important; padding-top: 40px;">
                        <div class="overflow-hidden">
                            <img class="img-fluid" src="img/team-4.jpg" alt="">
                        </div>
                        <div class="position-relative d-flex justify-content-center" style="margin-top: -23px;">
                            <div class="bg-light d-flex justify-content-center pt-2 px-1">
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h5 class="mb-0">이유영</h5>
                            <small>유자쌤의 빡쎈 집중관리반</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Team End -->

    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Quick Link</h4>
                    <a class="btn btn-link" href="">About Us</a>
                    <a class="btn btn-link" href="">Contact Us</a>
                    <a class="btn btn-link" href="">Privacy Policy</a>
                    <a class="btn btn-link" href="">Terms & Condition</a>
                    <a class="btn btn-link" href="">FAQs & Help</a>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Contact</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                    <div class="d-flex pt-2">
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Gallery</h4>
                    <div class="row g-2 pt-2">
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-1.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-2.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-3.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-2.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-3.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-1.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Newsletter</h4>
                    <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="copyright">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved.

                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                        Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a><br><br>
                        Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <div class="footer-menu">
                            <a href="">Home</a>
                            <a href="">Cookies</a>
                            <a href="">Help</a>
                            <a href="">FQAs</a>
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