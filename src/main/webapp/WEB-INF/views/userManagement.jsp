<%@include file="/WEB-INF/views/template/admin-header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1>Users Management</h1>
            <p class="lead">All Registered Users</p>
        </div>
        <table class="table table-hover table-striped">
            <thead>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Username</th>
            <th>Enabled</th>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.username}</td>
                    <td>${customer.enabled}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="/WEB-INF/views/template/admin-footer.jsp" %>