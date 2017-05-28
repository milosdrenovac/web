<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Dota Store</title>
    <link href="style.css" rel="stylesheet" type="text/css" />



</head>
<body>

    <div id="wrapper">

        <div id="header">

            <div id="site_title">
                <h1><a href="http://blog.dota2.com/?l=english" target="_blank">Game that's not LoL</a></h1>
            </div> 

            <div id="search_box">
                <form action="#" method="get">
                    <input type="text" placeholder="Type a keyword &amp; hit enter" name="q" size="10" 
                           id="searchfield" title="searchfield" />
                </form>
            </div>
        </div>

        <div id="menu">
            <ul>
                <li><a href="${"?m=home"}" class="current">Home</a></li>
                <li><a href="?m=cart" target="_parent">Cart</a></li>
                    <li><a href="${"?m=admin"}" target="_parent">Admin panel</a></li>

            </ul>   
            <c:if test="${sessionScope.username==null}">
                <div id="login">
                    <a href="${"?m=login"}">Login</a> or <a href="${"?m=register"}">Register</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.username!=null}">
                <h5>Greetings, ${sessionScope.username} <a href="Logout">logout</a>
                </h5>
            </c:if>
            <div class="cleaner"></div>
        </div> 

        <div id="middle">
            <div id="middle_img"><a href="${"?m=home"}"><img class="middle_img" src="images/rubick_pimp.jpg" alt="image" /></a></div>
            <div id="m_right">
                <h1>Pimp my hero up</h1>
                <p>This is a Dota 2 shop. Place where you can spend your parents hard earned money on useless and meaningless stuff like hero cosmetics, that will make your hero stand out from the crowd. Not. Just remember there are no locked heroes in this game so you can pimp all 113 heroes. Good for us. Enjoy!</p>
                <a href="https://www.youtube.com/watch?v=q6Ju0OnMXK8" class="float_r" target="_blank" >Details</a>
            </div>
        </div>
        <div id="content">
            <div class="content_box">
                <h2>Welcome to Dota 2 store</h2>
                <p>Dota is a competitive game of action and strategy, played both professionally and casually by millions of passionate fans worldwide. Players pick from a pool of over a hundred heroes, forming two teams of five players. Dota 2 is a free-to-play multiplayer online battle arena (MOBA) video game developed and published by Valve Corporation ..."</p>
            </div>

            <!-- seci vamo -->