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


            <!-- seci vamo -->

            <h4>Manipulate Item</h4>
            <form method="post" action="AddItem" id="itemform" enctype="multipart/form-data"></form>
            <form method="post" action="SearchItem" id="searchitem"></form>

            Search for item: <input type="text" name="searchfield" form="searchitem" placeholder="enter item name">
            <input type="submit" value="Search" name="manipulate" style="width: 90px" form="searchitem">
            <br /><br />
            <h5 style="color: red">${sessionScope.itemError}</h5>
            <br /><br />
            <table>
                <caption>Item</caption>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Category</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="name" style="width: 100px" form="itemform" value="${sessionScope.searchedItem.name}"></td>
                        <td><textarea name="description" style="width: 100px; height: 80px" form="itemform">${sessionScope.searchedItem.description}</textarea></td>
                        <td><input type="number" step="0.01" name="price" min="0" style="width: 100px" form="itemform" value="${sessionScope.searchedItem.price}"></td>
                        <td><input type="file" name="image" style="width: 180px" form="itemform" value="${sessionScope.searchedItem.image}"></td>
                        <td><select name="categoryid" form="itemform" style="width: 90px">
                                <option>Enter category:</option>
                                <c:forEach items="${allCategories}" var="categ">
                                    <c:if test="${sessionScope.searchedItem.category!=null&&categ.id==sessionScope.searchedItem.category}">
                                        <option value="${categ.id}" selected="">${categ.name}</option>
                                    </c:if>
                                    <option value="${categ.id}">${categ.name}</option>
                                </c:forEach>
                            </select></td>
                        <td><input type="number" name="quantity" min="0" style="width: 100px" form="itemform" value="${sessionScope.searchedItem.quantity}"></td>
                        <td>
                            <select name="categoryselect" form="itemform">
                                <option value="empty">Choose action</option>
                                <option value="Insert">Insert</option>
                                <option value="Remove">Remove</option>
                                <option value="Edit">Edit</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <th colspan="6">Manipulate item</th>
                        <th><input type="submit" value="OK" style="width: 90px" form="itemform"></th>
                    </tr>
                </tfoot>
            </table>
            <br /><br />


            <h4>Search user by:</h4>
            <form method="post" action="AdminSearch" >
                <select name="searchselect" >
                    <option value="username">User name</option>
                    <option value="first_name">First name</option>
                    <option value="last_name">Last name</option>
                    <option value="role">Role</option>
                </select>
                <br /><br />
                <input type="text" name="searchfield">
                <br /><br />
                <input type="submit" value="Search" >

            </form>
            <br /><br />

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
                    </tr>
                </thead>
                <c:forEach var="result" items="${searchList}">
                    <tbody>
                        <tr>
                            <td>${result.username}</td>
                            <td>${result.firstName}</td>
                            <td>${result.lastName}</td>
                            <td>${result.password}</td>
                            <td>${result.vallet} $</td>
                            <c:if test="${result.role==1}">
                                <td>User</td>
                            </c:if>
                            <c:if test="${result.role==2}">
                                <td>Admin</td>
                            </c:if>
                            <c:if test="${result.role==0}">
                                <td>No role</td>
                            </c:if>
                            <td>
                                <form method="post" action="ManipulateUser">
                                    <input type="hidden" name="userid" value="${result.id}">
                                    <input type="submit" name="action" value="Edit" style="width: 90px">
                                    <input type="submit" name="action" value="Delete" style="width: 90px">
                                    <input type="submit" name="action" value="View Purchases" style="width: 110px">
                                </form>
                            </td>
                        </tr>
                    </tbody>

                </c:forEach>
                <tfoot>
                    <tr>
                        <th colspan="6">User data</th>
                    </tr>
                </tfoot>
            </table>
            <br /><br />

            <h4>Insert category:</h4>
            <form method="post" action="AddCategory" >
                <input type="text" name="categoryname" placeholder="write category name">
                <br /><br />
                <input type="submit" value="Insert category">

            </form>
            <br /><br />

            <h4>Remove category:</h4>
            <form method="post" action="RemoveCategory" >
                <select name="categoryselect">
                    <option>Choose category</option>
                    <c:forEach items="${allCategories}" var="categ">
                        <option value="${categ.id}">${categ.name}</option>
                    </c:forEach>
                </select>
                <br /><br />
                <input type="submit" value="Remove category">
            </form>
            <br /><br />


            <%@include file="bot.jsp" %>