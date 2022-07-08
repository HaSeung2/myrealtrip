<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이리얼트립 :: 로그인</title>
  <c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
  <link rel="shortcut icon" type="image/x-icon" href="${cp}/app/img/favicon.ico">
  <link rel="stylesheet" href="${cp}/css/common.css">
  <link rel="stylesheet" href="${cp}/css/pointContainer.css">
  <link rel="stylesheet" href="${cp}/css/index.css">
  <link rel="stylesheet" href="${cp}/css/user/sign.css">
  <link rel="stylesheet" href="${cp}/css/footer.css">
</head>
<body>
	<!-- header시작 -->
  <%@ include file="/app/common/header.jsp" %>
  	<!-- header끝 -->
		<!-- 회원가입 시작 -->
  	<div class="signup_container">
		<div class="signup_wrapper">
			<div class="signup_contnent">
			<img class="welcomeHands" src="${cp}/app/img/hands.png" alt="welcome hand">
			<p class="welcomeTitle">반갑습니다!</p>
			<p class="welcomeSubTitle">여행의 모든 것, 마이리얼트립</p>
			<div class="kakaoOauthBtn_wrapper">
				<button type="button" class="kakao_button">
				<div class="button_container" onclick="kakaoLogin();">
					<img class="kakao_img" src="${cp}/app/img/kakao_log.svg" alt="kakao">
					<span>카카오로 계속하기</span>
				</div>
				</button>
			</div>
			<div class="oauthList_container">
				<div class="oauth_container">
					<div class="icon-wrapper">
						<img class="iconImg" src="${cp}/app/img/facebook_log.svg" alt="페이스북">
						<img class="iconImgHover" src="${cp}/app/img/facebook_log_on.svg" alt="페이스북">
						<input type="hidden" value="페이스북">
						<span>페이스북</span>
					</div>
					<span class="oauthList_line"></span>
					<div class="icon-wrapper">
						<img class="iconImg" src="${cp}/app/img/naver_log.svg" alt="네이버">
						<img class="iconImgHover" src="${cp}/app/img/naver_log_on.svg" alt="네이버">
						<input type="hidden" value="네이버">
						<span>네이버</span>
					</div>
					<span class="oauthList_line"></span>
					<div class="icon-wrapper" >
						<img class="iconImg" src="${cp}/app/img/email_log.svg" alt="이메일">
						<img class="iconImgHover" src="${cp}/app/img/email_log_on.svg" alt="이메일">
						<input type="hidden" value="이메일 로그인">
						<span>이메일</span>
					</div>
				</div>
			</div>
			<div class="sign_in_move_container">
				<span>아직 회원이 아니신가요?</span>
				<!-- 로그인 요청 정보 -->
				<a class="sign_in_move" href="${cp}/user/sign_up.us">회원가입</a>
			</div>
			</div>
		</div>
	  </div>
  	<!-- 회원가입 끝 -->
  	<!-- footer 시작 -->
	<div class="default-components" id="footer-components">
		<footer id="footer" class="footer-container">
  			<%@ include file="/app/common/footer.jsp" %>	
 		</footer>
	</div>
  <!-- footer 끝 -->
</body>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="${cp}/js/chatbot.js"></script>
<script src="${cp}/js/designForInput.js"></script>
<script src="${cp}/js/loginEffect.js"></script>
<script src="${cp}/js/myinfo.js"></script>
<script>
Kakao.init('d4becfd70ec68cb3664026df1d784c41'); //발급받은 키 중 javascript키를 사용해준다.
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	 location.href = "http://localhost:9090/myrealtrip/index.jsp?loginUser="+response.kakao_account.email+"&username="+response.properties.nickname;
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
</script>
</html>