<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="loginf">
    <form action="Register" method="post">
        <table class="login_table">
            <h3 style="color: red">${sessionScope.errormsg}</h3>
            <tr>
                <td>Username <span>*</span></td>
                <td><input type="text" name="username" id="username" placeholder="username"></td>
            </tr>
            <tr>
                <td>Password <span>*</span></td>
                <td><input type="password" name="password" id="password" placeholder="password" ></td>
            </tr>
            <tr>
                <td>First name <span>*</span></td>
                <td><input type="text" name="first_name" id="first_name" placeholder="your name"></td>
            </tr>
            <tr>
                <td>Last name <span>*</span></td>
                <td><input type="text" name="last_name" id="last_name" placeholder="your last name"></td>
            </tr>
            <tr>
                <td>Add funds <span>*</span></td>
                <td><input type="text" name="wallet" id="wallet" maxlength="6" placeholder="give us some monies"></td>
            </tr>
            <tr>
                <td>Check if you want admin controls <span>*</span></td>
                <td><input type="checkbox" name="admincheck" checked=""></td>
            </tr>
            
            <tr>
                <td><input type="submit" value="Register"></td>
            </tr>
        </table>
    </form>
</div>

<%@include file="bot.jsp" %>