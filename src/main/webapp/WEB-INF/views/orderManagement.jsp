<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@include file="/WEB-INF/views/template/admin-header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1>Order Management</h1>
            <p class="lead">Order Details</p>
        </div>
        <table class="table table-hover table-striped">
            <thead>
            <th>Order No.<br>& Date</th>
            <th>Customer<br>Details</th>
            <th>Products<br>Ordered</th>
            <th>Total Amount &<br>Payment Mode</th>
            <th>Shipping<br>Address</th>
            <th class="text-center">Status</th>
            </thead>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td>Order No.: ${order.customerOrderId}<br>
                        Date: <fmt:formatDate type="date" value="${order.creationDate}"/>
                    </td>
                    <td>
                        Name: ${order.customer.customerName}<br>
                        Email: ${order.customer.customerEmail}<br>
                        Contact No.: ${order.customer.customerPhone}
                    </td>
                    <td>
                        <c:forEach items="${order.cart.cartItems}" var="item">
                            ${item.product.productName}
                            <br>
                            (${item.quantity} unit(s) * &#8377;${item.product.productPrice} = &#8377;${item.totalPrice})
                            <br>
                        </c:forEach>
                    </td>
                    <td align="center"><strong>&#8377;${order.cart.grandTotal}<br>
                        COD</strong></td>
                    <td>${order.shippingAddress}</td>

                    <td class="text-center">
                        <form action="/admin/order" method="post">
                            <select id="status" name="status"
                                    onchange="if(this.value != '${order.status}') { this.form.submit(); }">
                                <option value="${order.status}">${order.status}</option>
                                <option value="Active">Active</option>
                                <option value="In-Transit">In-Transit</option>
                                <option value="Delivered">Delivered</option>
                                <option value="Cancelled">Cancelled</option>
                            </select>
                            <input type="hidden" name="orderId" id="orderId" value="${order.customerOrderId}" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="/WEB-INF/views/template/admin-footer.jsp" %>