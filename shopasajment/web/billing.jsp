<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content_box last">

    <div class="col_w340">
        <h2>Your profile</h2>
        <div class="categories">
            <h4>Hello: ${sessionScope.first_name} ${sessionScope.last_name}, </h4>
            <h4>your available fund is: ${sessionScope.vallet}$ </h4>
        </div>
    </div>


    <div class="col_w480">
        <div class="sub_content_box">
            <h2>Items in your cart</h2>
            <c:forEach var="item" items="${sessionScope.cart}" >
                <h4>${item.name}</h4>
                <p align="justify"> ${item.description} </p>
                <p align="justify"> Price: ${item.price}$ </p>
                <hr style="width: 200px; float: left"/>
                <br/>
                <div class="cleaner"></div>
            </c:forEach>
            <h5>Total price: ${sessionScope.allprice}$</h5>
            <br/>
            <c:if test="${sessionScope.vallet>sessionScope.allprice}">
                <h5>Your have enough moniez for this purchase!</h5>  
            </c:if>
            <c:if test="${sessionScope.vallet<sessionScope.allprice}">
                <h5 style="color: red">Your funds are insufficient for this purchase.</h5>  
                <h5>Add more funds to your account..</h5>
                <form method="post" action="AddFunds">
                    <input type="number" name="newfunds" min="1">
                    <input type="submit" value="Add funds">
                </form>
            </c:if>
            
            <a class="more float_r" style="width: 100px; height: 40px; padding-top: 20px; font-size: 20px" href="Finalized">BUY</a>
        </div>
    </div>
</div>
<%@include file="bot.jsp" %>