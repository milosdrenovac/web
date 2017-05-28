<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="loginf">
    <form action="Login" method="post">
        <table class="login_table">
            <tr>
                <td>Username <span>*</span></td>
                <td><input type="text" name="username" id="username" placeholder="username"></td>
            </tr>
            <tr>
                <td>Password <span>*</span></td>
                <td><input type="password" name="password" id="password" placeholder="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form>
</div>

<%@include file="bot.jsp" %>