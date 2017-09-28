<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Checkout Page Three: Order Confirmation Starts----------------------->
<jsp:useBean id="now" class="java.util.Date"/>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
        </div>
        <div class="Controls">
            <div class="row">
                <form:form commandName="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="text-center">
                            <h1>Order Confirmation</h1>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-12 text-center">
                            <p> Date: <fmt:formatDate value="${now}" type="date"/></p>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Shipping Address${order.cart.customer.customerId}</strong><br>
                                        ${order.cart.customer.shippingAddress.addressLine1} <br>
                                        ${order.cart.customer.shippingAddress.addressLine2} <br>
                                        ${order.cart.customer.shippingAddress.city}<br>
                                        ${order.cart.customer.shippingAddress.state} <br>
                                        ${order.cart.customer.shippingAddress.country} <br>
                                        ${order.cart.customer.shippingAddress.pinCode} <br>
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Billing Address</strong><br>
                                        ${order.cart.customer.billingAddress.addressLine1} <br>
                                        ${order.cart.customer.billingAddress.addressLine2} <br>
                                        ${order.cart.customer.billingAddress.city}<br>
                                        ${order.cart.customer.billingAddress.state} <br>
                                        ${order.cart.customer.billingAddress.country} <br>
                                        ${order.cart.customer.billingAddress.pinCode} <br>
                                </address>
                            </div>
                        </div>
                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th class="text-center">Price/Unit</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-7"><em>${cartItem.product.productName}</em></td>
                                        <td class="col-md-1" style="text-align: center">
                                            <em>${cartItem.quantity}</em></td>
                                        <td class="col-md-3" style="text-align: center">
                                            <em>&#8377;${cartItem.product.productPrice}</em></td>
                                        <td class="col-md-1" style="text-align: center">
                                            <em>&#8377;${cartItem.totalPrice}</em></td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong> Grand Total: </strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>&#8377;${order.cart.grandTotal}</strong></h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <input type="hidden" name="_flowExecutionKey"/>
                        <br><br>
                        <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
                        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                        <input type="submit" value="Submit Order" name="_eventId_orderConfirmed"
                               class="btn btn-success">
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<!-----------------------Checkout Page Three: Order Confirmation Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>