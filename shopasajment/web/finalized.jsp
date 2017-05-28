<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content_box last">

    <div class="col_w340">
        <h2>Your profile</h2>
        <div class="categories">
            <h4>Hello: ${sessionScope.first_name} ${sessionScope.last_name} </h4>
            <h4>Your remaining fund after this purchase is: ${sessionScope.vallet}$ </h4>
            <h5>Continue <a href="?m=home">browsing</a></h5>
        </div>
    </div>
</div>
<%@include file="bot.jsp" %>