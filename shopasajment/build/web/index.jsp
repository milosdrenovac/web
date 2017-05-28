<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content_box last">
    <div class="col_w340">
        <h2>Categories</h2>
        <div class="categories">
            <ul>
                <c:forEach var="category" items="${allCategories}">
                    <li>
                        <h6><a href="?category=${category.id}">${category.name}</a></h6>
                        <!--<div class="ra_img_wrapper"><img src="images/" alt="slika kategorije" /></div>-->
                        <div class="cleaner"></div>
                    </li>
                    
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="col_w480">
        <div class="sub_content_box">
            <h2>Items </h2>
            <c:if test="${param.category==null}">
                <c:forEach var="item" items="${allItems}" >                                                                                                      
                    <c:choose>
                        <c:when test="${item.category==1}" >
                            <h4>${item.name}</h4>
                            <div class="image_wrapper image_fl"><img src="${item.image}" width="150" height="100" alt="kao neka slika" /></div>
                            <p align="justify"> ${item.description} </p>
                            <p align="justify"> Price: ${item.price}$ </p>
                            <div class="cleaner"></div>
                            <a class="more float_r" href="?m=itemdetails&id=${item.id}">Details</a>
                            
                        </c:when>
                    </c:choose>
                </c:forEach>
                <br/>
                <p align="justify"> <h3>These are just some of the items we have in our inventory, browse trough categories to explore some more...</h3> </p>
            </c:if>
            <c:forEach var="item" items="${allItems}" >                                                                                                      
                <c:choose>
                    <c:when test="${item.category==param.category}" >
                        <h4>${item.name}</h4>
                        <div class="image_wrapper image_fl"><img src="${item.image}" width="150" height="100" alt="kao neka slika" /></div>
                        <p align="justify"> ${item.description} </p>
                        <p align="justify"> Price: ${item.price}$ </p>
                        <a class="more float_r" href="?m=itemdetails&id=${item.id}">Details</a>
                        <div class="cleaner"></div>
                    </c:when>
                </c:choose>
            </c:forEach>
        </div>
        <!--        <ul class="pagination">
                    <li><a href="#">«</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">»</a></li>
                </ul>-->
    </div>
</div>
<%@include file="bot.jsp" %>