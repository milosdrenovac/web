<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div >
    <table>
        <caption>List of all ${sessionScope.userpurchases.username}'s orders</caption>
        <thead>
            <tr>
                <th>Date</th>
                <th>Price</th>
                <th>Items</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${sessionScope.purchases}" var="purchase">
                <tr>
                    <td style="width: 100px">${purchase.date}</td>
                    <td style="width: 100px">${purchase.totalPrice}$</td>
                    <td style="width: 100px">
                        <c:forEach items="${purchase.allitems}" var="item">
                            ${item.name}
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <th colspan="3">User orders</th>

            </tr>
        </tfoot>
    </table>

</div>

<%@include file="bot.jsp" %>