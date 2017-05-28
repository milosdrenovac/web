<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content_box last">
    <div class="col_w481">
        <div class="sub_content_box">
            <h2>Items in your cart</h2>

            <c:forEach var="item" items="${sessionScope.cart}" >
                <h4>${item.name}</h4>
                <div class="image_wrapper image_fl"><img src="${item.image}"  width="150" height="100" alt="kao neka slika" /></div>
                <p align="justify"> ${item.description} </p>
                <p align="justify"> Price: ${item.price}$ </p>
                <div class="cleaner"></div>
            </c:forEach>
            <c:if test="${empty sessionScope.cart&&sessionScope.username!=null}">
                <h3>Your cart is empty please continue <a href="?m=home">browsing trough our stuff</a></h3>
            </c:if>
            <c:if test="${sessionScope.username==null}">
                <br/>
                <p align="justify" > <h5>If you wish to buy something please <a href="?m=login">LOGIN</a> or <a href="?m=regiser"> REGISTER </a> </h5> </p>
            </c:if>
            <c:if test="${!empty sessionScope.cart}">
                <a class="more float_r" style="width: 100px; height: 40px; padding-top: 20px; font-size: 20px" href="?m=billing">BUY</a>
            </c:if>
        </div>
    </div>
</div>
<%@include file="bot.jsp" %>