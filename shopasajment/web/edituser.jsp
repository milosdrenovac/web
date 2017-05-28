<%@include file="top.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div >
    <form action="EditUser" method="post" id="forma"></form>
        <table>
            <caption>User data</caption>
            <thead>
                <tr>
                    <th>User name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Password</th>
                    <th>Funds</th>
                    <th>Role</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <tr>

                    <td><input type="text" name="username" value="${usertoedit.username}" style="width: 100px" form="forma"></td>
                    <td><input type="text" name="firstname" value="${usertoedit.firstName}" style="width: 100px" form="forma"></td>
                    <td><input type="text" name="lastname" value="${usertoedit.lastName}" style="width: 100px" form="forma"></td>
                    <td><input type="text" name="password" value="${usertoedit.password}" style="width: 100px" form="forma"></td>
                    <td><input type="number" name="vallet" value="${usertoedit.vallet}" style="width: 100px" form="forma"> $</td>
                    <td>
                        <select name="roleselect" form="forma">
                            <option value="1">User</option>
                            <option value="2">Admin</option>
                        </select>
                    </td>
                    <td><input type="submit" value="OK" form="forma"></td>

                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <th colspan="7">Edit user</th>

                </tr>
            </tfoot>
        </table>

</div>

<%@include file="bot.jsp" %>