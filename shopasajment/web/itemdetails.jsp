<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content_box last">
    <div class="col_w481">
        <div class="sub_content_box">
            <h2>Items</h2>
            <h4>${item.name}</h4>
            <div class="image_wrapper image_fl"><img src="${item.image}"  width="300" height="200" alt="kao neka slika" /></div>
            <p align="justify"> ${item.description} </p>
            <p align="justify"> Price: ${item.price}$ </p>
            <a class="more float_r" href="?m=addtocart&id=${item.id}">Add to cart</a>
            <div class="cleaner"></div>
        </div>
    </div>
</div>
<%@include file="bot.jsp" %>