<#include "security.ftl">

<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8">

        <link rel="stylesheet" href="/templates/css/nav-bar.css">
        <link rel="stylesheet" href="/templates/css/login.css">
        <link rel="stylesheet" href="/templates/css/registrationn.css">
        <link rel="stylesheet" href="/templates/css/nav-bar-w3.css">
        <link rel="stylesheet" href="/templates/css/footer.css">
        <link rel="stylesheet" href="/templates/css/body.css">
        <link rel="stylesheet" href="/templates/css/responsible-design.css">
        <link rel="stylesheet" href="/templates/css/mypage.css">
        <link rel="stylesheet" href="https://cssreset.com/?dl_id=3">

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


        <title>Title</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src='https://www.google.com/recaptcha/api.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <#--tag should be inside HEAD jQuery-->
    </head>

<body class="body">
<#macro page>
<!-- !!!!!!!!!!!!!!!!!!!!!!!!!! id="main" for js for footer-->
<div id="main">
    <div class="topnav" id="myTopnav">
        <div class="nav-bar">
            <a  href="/#C1" id="C1">Home</a>
            <a href="/mypage#C2" id="C2">My Page</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <a  href="/user">Admin</a>
      <#--      <a href="/logout" class="sign_out"  type="submit">Sign Out </a>-->
            <form  action="/logout" method="post">
            <#-- don't forget _csrf.token  otherwise yo uwill se this message
                "This application has no explicit mapping for /error, so you are seeing this as a fallback."-->
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="sign_out"  type="submit">Sign Out </button>
            </form>

            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
    </div>
    <div class="user_name">${name}</div>

<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
    <#nested>
</div>

    <div id="footer" class="footer-relative">
        <div class="footer-bottom">
            <div class="grid-container">
                <div class="item1"></div>
                <div class="item2" style="color:white; padding-bottom: 10px">About Company</div>
                <div class="item3" style="color:white">Possibilities</div>
                <div class="item4" style="color:white">Partners</div>
                <div class="item5"style="color:white">Support</div>
                <div class="item6"></div>
                <div class="item7"></div>
                <div class="item8">About us</div>
                <div class="item9">9</div>
                <div class="item10">Advertisement</div>
                <div class="item11">Assistance</div>
                <div class="item12"></div>
                <div class="item13"></div>
                <div class="item14">Contacts</div>
                <div class="item15">15</div>
                <div class="item16" style="font-size: 20px">&#169 2018-2019 "Dnevnik-online.com"</div>
            </div>
            <!--<div class="footer-bottom">&#169 2018-2019 "Dnevnik-online.com"</div>-->
        </div>
    </div>
</#macro>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/resetAllFieldsRegistration.js" type="text/javascript"></script>
<script src="/templates/css/js/myPageAjax.js" type="text/javascript"></script>
<script src="/templates/css/js/login.js" ></script>
</body>
</html>
